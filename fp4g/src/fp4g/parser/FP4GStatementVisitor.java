package fp4g.parser;

import java.util.Collection;
import java.util.List;
import java.util.Stack;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import fp4g.classes.MessageMethods;
import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.ExprList;
import fp4g.data.Expresion;
import fp4g.data.IDefine;
import fp4g.data.Instance;
import fp4g.data.Statement;
import fp4g.data.Statements;
import fp4g.data.add.AddDefine;
import fp4g.data.add.AddMethod;
import fp4g.data.define.Manager;
import fp4g.data.define.Message;
import fp4g.data.statements.Assignment;
import fp4g.data.statements.Destroy;
import fp4g.data.statements.Send;
import fp4g.data.statements.Subscribe;
import fp4g.data.statements.Unsubscribe;
import fp4g.exceptions.FP4GRuntimeException;
import fp4g.log.info.Error;

public class FP4GStatementVisitor extends FP4GBaseVisitor<Statement> 
{
	private final Stack<IDefine> current;
	private final FP4GExpresionVisitor exprVisitor;	
	private final IDefine container;
	
	public FP4GStatementVisitor(IDefine container,Stack<IDefine> current, FP4GExpresionVisitor exprVisitor)
	{
		this.current     = current;
		this.exprVisitor = exprVisitor;
		this.container   = container;
		
	}
	
	private MessageMethods methods;
	private MessageMethods methods()
	{
		try
		{
			if(methods == null)
			{
				methods = (MessageMethods)container.get(Message.METHODS).getValue();
			}
			return methods;
		}
		catch(NullPointerException e)
		{
			throw new FP4GRuntimeException(Error.MessageMethodNotFound,"Los metodos para los mensajes no se encontrarón",e);
		}
	}
	
	@Override
	public Statement visitAssign(FP4GParser.AssignContext ctx)
	{
		String varName = ctx.varName.getText();
		Expresion expresion = exprVisitor.visit(ctx.expr());
		
		Assignment assignment = new Assignment(varName, expresion);
		return assignment;
	}

	
	public Statements getStatements(FP4GParser.StatementsContext ctx)
	{
		Statements statements = new Statements();	
		if(ctx.children != null)
		{
			for(ParseTree c:ctx.children)
			{
				Statement code = visit(c);
				if(code != null)
				{
					statements.add(code);
				}
			}		
		}
		return statements;		
	}
	
	@Override
	public Statement visit(ParseTree tree)
	{
		Statement statement = super.visit(tree);
		if((statement != null)&&(tree instanceof TerminalNode))
		{
			statement.setLine(((TerminalNode) tree).getSymbol().getLine());			
		}		
		return statement;		
	}
	
	@Override
	public Statement visitDestroy(FP4GParser.DestroyContext ctx)
	{
		Destroy destroy = new Destroy(Instance.Self);
		return destroy;
	}
	
	@Override 
	public Statement visitSubscribe(FP4GParser.SubscribeContext ctx)
	{
		Define define = (Define)current.peek();
		Subscribe subscribe;
		//where=ID ON message=ID (DOUBLEDOT method=ID)?
		String whereName = ctx.where.getText();
		Instance whereType = Instance.Self;
		String messageName = ctx.message.getText();
		String methodName = (ctx.method != null)?ctx.method.getText():null;
		
		//obtener message
		Message message = define.getDefine(DefineType.MESSAGE, messageName);
		//objetener  method
		AddMethod method = message.getAddMethod(methodName);
		
		Define where = define.getDefine(whereName);
		
		//identificar where que es
		whereType = Instance.System;
		subscribe = new Subscribe(whereType, where, message, method);
		
		return subscribe;
	}
	
	@Override 
	public Statement visitUnsubscribe(FP4GParser.UnsubscribeContext ctx)
	{
		Define define = (Define)current.peek();
		Unsubscribe subscribe;
		//where=ID ON message=ID (DOUBLEDOT method=ID)?
		String whereName = ctx.where.getText();
		Instance whereType = Instance.Self;
		String messageName = ctx.message.getText();
		String methodName = (ctx.method != null)?ctx.method.getText():null;
		
		//obtener message
		Message message = define.getDefine(DefineType.MESSAGE, messageName);
		//objetener  method
		AddMethod method = message.getAddMethod(methodName);
		
		Define where = define.getDefine(whereName);
		
		//identificar where que es
		whereType = Instance.System;
		subscribe = new Unsubscribe(whereType, where, message, method);
		
		return subscribe;
	}
	
	@Override
	public Statement visitSend(FP4GParser.SendContext ctx)
	{
		Define define = (Define)current.peek();
		
		AddMethod method = methods().getMessageMethod(ctx.messageMethodName);
		if(method == null)
		{
			throw new FP4GRuntimeException(Error.FilterMethodMissing,"No se encontró un metodo para el filtro:  ".concat(ctx.messageMethodName));
		}
		Instance type = null;
		String receiver = null;
		//Busqueda de quien envia mensaje.
		//1.- Game
		//2.- Self
		//3.- Other
		//4.- Componente
		//5.- Tag
		//6.- Sistema
		type = (ctx.receiverType == null)?Instance.Behavior:ctx.receiverType;
		
		
		Send send = null;
		switch(type)
		{		
		case Game:			
		case Other:			
		case Self:
			send = new Send(type,method,receiver);
			break;
		default:
			receiver = ctx.receiverName;
		//Behavior
			//buscar en los add de la entidad.
			List<AddDefine> behaviors = define.getAddDefines(DefineType.BEHAVIOR);
			for(AddDefine bhvr:behaviors)
			{
				//buscar de forma iterativa
				if(bhvr.name.equals(receiver))
				{
					type = Instance.Behavior; //Es un behavior!
					send = new Send(type,method,receiver);
					break;
				}
			}
	    //Tag
			//buscar algún tag, si es que existe
			
	    //System
			
			//buscar en los defines de sistemas.
			Collection<IDefine> managers = container.getDefines(DefineType.MANAGER);
			for(IDefine manager:managers)
			{
				if(manager.getName().equals(receiver))
				{
					if(((Manager)manager).isReceiver())
					{
						type = Instance.System; //es un sistema!, ojo que el sistema puede que no esté definido...
						send = new Send(type,method,(Manager)manager);
					}
					else
					{
						//lanzar error						
						throw new FP4GRuntimeException(Error.ManagerIsNotAReceiver,String.format("El manager \"%s\" no puede recibir mensajes.",receiver));							 
					}
					break;
				}
			}					
		
			break;		
		}		
		
		ExprList list = exprVisitor.getExprList(ctx.exprList());
		if(list != null)
		{		
			//TODO checkar la exprList, checkar que?, Compararla contra MessageMethod.Params se requiere conocimiento adicional.
			send.setArguments(list);		
		}
		
		
		return send;		
	}
}
