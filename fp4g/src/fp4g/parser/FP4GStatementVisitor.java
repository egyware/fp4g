package fp4g.parser;

import java.util.Collection;
import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import fp4g.classes.MessageMethods;
import fp4g.data.Define;
import fp4g.data.DefineTypes;
import fp4g.data.ExprList;
import fp4g.data.Expresion;
import fp4g.data.IDefine;
import fp4g.data.ILib;
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
import fp4g.exceptions.DefineNotFoundException;
import fp4g.exceptions.FP4GRuntimeException;
import fp4g.log.FP4GError;

public class FP4GStatementVisitor extends FP4GBaseVisitor<Statement> 
{
	private final FP4GExpresionVisitor exprVisitor;	
	private final ILib lib;
	
	public FP4GStatementVisitor(ILib lib, FP4GExpresionVisitor exprVisitor)
	{
		this.exprVisitor = exprVisitor;
		this.lib   = lib;
		
	}
	
	private MessageMethods methods;
	private MessageMethods methods()
	{
		try
		{
			if(methods == null)
			{
				methods = (MessageMethods)lib.get(Message.METHODS).getValue();
			}
			return methods;
		}
		catch(NullPointerException e)
		{
			throw new FP4GRuntimeException(FP4GError.MessagesMethodNotFound,"Los metodos para los mensajes no se encontrarón",e);
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

	
	private IDefine current;
	public Statements getStatements(IDefine current, FP4GParser.StatementsContext ctx)
	{
		this.current = current;
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
		Subscribe subscribe;
		//where=ID ON message=ID (DOUBLEDOT method=ID)?
		String whereName = ctx.where.getText();
		Instance whereType = Instance.System;
		String messageName = ctx.message.getText();
		String methodName = (ctx.method != null)?ctx.method.getText():null;
		
		//obtener message
		Message message;
		try
		{
			message = lib.getDefine(DefineTypes.MESSAGE, messageName);
		}
		catch(DefineNotFoundException e)
		{
			//imperdonable
			throw new FP4GRuntimeException(FP4GError.DefineIsRequired, ctx.getStart().getLine(), String.format("El Define tipo MESSAGE %s es necesario", messageName), e);
		}
		//objetener  method
		AddMethod method = message.getAddMethod(methodName);
		
		Define where;
		try 
		{
			where = lib.getDefine(whereName);
		}
		catch (DefineNotFoundException e) 
		{
			//imperdonable
			throw new FP4GRuntimeException(FP4GError.DefineIsRequired, ctx.getStart().getLine(), String.format("El Define de nombre %s es necesario", messageName), e);
		}

		subscribe = new Subscribe(whereType, where, message, method);
		
		return subscribe;
	}
	
	@Override 
	public Statement visitUnsubscribe(FP4GParser.UnsubscribeContext ctx)
	{
		Unsubscribe subscribe;
		//where=ID ON message=ID (DOUBLEDOT method=ID)?
		String whereName = ctx.where.getText();
		Instance whereType = Instance.System;
		String messageName = ctx.message.getText();
		String methodName = (ctx.method != null)?ctx.method.getText():null;
		
		//obtener message
		Message message;
		try
		{
			message = lib.getDefine(DefineTypes.MESSAGE, messageName);
		}
		catch(DefineNotFoundException e)
		{
			//imperdonable
			throw new FP4GRuntimeException(FP4GError.DefineIsRequired, ctx.getStart().getLine(), String.format("El Define tipo MESSAGE %s es necesario", messageName), e);
		}
		//objetener  method
		AddMethod method = message.getAddMethod(methodName);
		
		Define where;
		try 
		{
			where = lib.getDefine(whereName);
		}
		catch (DefineNotFoundException e) 
		{
			//imperdonable
			throw new FP4GRuntimeException(FP4GError.DefineIsRequired, ctx.getStart().getLine(), String.format("El Define de nombre %s es necesario", messageName), e);
		}
		
		//identificar where que es		
		subscribe = new Unsubscribe(whereType, where, message, method);
		
		return subscribe;
	}
	
	@Override
	public Statement visitSend(FP4GParser.SendContext ctx)
	{
		AddMethod method = methods().getMessageMethod(ctx.messageMethodName);
		if(method == null)
		{
			throw new FP4GRuntimeException(FP4GError.FilterMethodMissing,"No se encontró un metodo para el filtro:  ".concat(ctx.messageMethodName));
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
			List<AddDefine> behaviors = current.getAddDefines(DefineTypes.BEHAVIOR);
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
			Collection<IDefine> managers = lib.getDefines(DefineTypes.MANAGER);
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
						throw new FP4GRuntimeException(FP4GError.ManagerIsNotAReceiver,String.format("El manager \"%s\" no puede recibir mensajes.",receiver));							 
					}
					break;
				}
			}					
		
			break;		
		}		
		
		ExprList list = exprVisitor.getExprList(current,ctx.exprList());
		if(list != null)
		{		
			//TODO checkar la exprList, checkar que?, Compararla contra MessageMethod.Params se requiere conocimiento adicional.
			send.setArguments(list);		
		}
		
		
		return send;		
	}
}
