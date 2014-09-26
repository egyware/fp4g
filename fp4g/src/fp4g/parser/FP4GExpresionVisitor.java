/**
 * 
 */
package fp4g.parser;


import java.util.Iterator;
import java.util.Stack;

import org.antlr.v4.runtime.tree.ParseTree;

import fp4g.classes.MessageMethods;
import fp4g.data.Add;
import fp4g.data.DefineTypes;
import fp4g.data.ExprList;
import fp4g.data.Expresion;
import fp4g.data.IDefine;
import fp4g.data.ILib;
import fp4g.data.add.AddMethod;
import fp4g.data.define.Message;
import fp4g.data.expresion.AddExpr;
import fp4g.data.expresion.ArrayList;
import fp4g.data.expresion.ArrayMap;
import fp4g.data.expresion.BinaryOp;
import fp4g.data.expresion.ClassMap;
import fp4g.data.expresion.CustomClassList;
import fp4g.data.expresion.CustomClassMap;
import fp4g.data.expresion.DirectCode;
import fp4g.data.expresion.IList;
import fp4g.data.expresion.IMap;
import fp4g.data.expresion.Literal;
import fp4g.data.expresion.MessageExpr;
import fp4g.data.expresion.ToExpr;
import fp4g.data.expresion.UnaryOp;
import fp4g.data.expresion.VarDot;
import fp4g.data.expresion.VarId;
import fp4g.data.expresion.literals.BoolLiteral;
import fp4g.data.expresion.literals.FloatLiteral;
import fp4g.data.expresion.literals.IntegerLiteral;
import fp4g.data.expresion.literals.StringLiteral;
import fp4g.exceptions.CannotEvalException;
import fp4g.exceptions.DefineNotFoundException;
import fp4g.exceptions.FP4GRuntimeException;
import fp4g.log.FP4GError;
import fp4g.log.FP4GWarn;
import fp4g.log.Log;

/**
 * @author Edgardo
 *
 */
public class FP4GExpresionVisitor extends FP4GBaseVisitor<Expresion> 
{
	private final Stack<Stack<Expresion>> stacks = new Stack<Stack<Expresion>>();	
	private Stack<Expresion> stack;	
	private final Stack<IMap> map_stack = new Stack<IMap>();
	private final Stack<IList> list_stack = new Stack<IList>();
	private final ILib lib;
	private FP4GDataVisitor dataVisitor;
	
	public FP4GExpresionVisitor(ILib lib, FP4GDataVisitor dataVisitor)
	{	
		this.lib = lib;
		this.dataVisitor = dataVisitor;
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
		
	private void pushStack()
	{
		if(stack == null)
		{
			stack = new Stack<Expresion>();
		}
		else
		{
			stacks.push(stack);
			stack = new Stack<Expresion>();
		}
	}
	private Stack<Expresion> pop()
	{
		Stack<Expresion> old = stack;
		stack = null;
		if(!stacks.empty())
		{
			stack = stacks.pop();
		}
		return old;
	}
	
	private IDefine current;
	@Override
	public Expresion visit(ParseTree tree)
	{
		current = dataVisitor.current();
		return super.visit(tree);
	}
	
	public Expresion getExpr(FP4GParser.ExprContext ctx)
	{
	
		return visit(ctx);
	}
	
	public ExprList getExprList(IDefine current, FP4GParser.ExprListContext ctx)
	{
		if(ctx == null) return null; //En cierto codigo aveces ExprList puede ser null porque no se escribio, asi que solo se regresa null. La comprobación se hace desde afuera si este es null o no.
		this.current = current;
		pushStack();		
		
		//visitamos los hijos personalmente, evitamos usar cada vez menos la pila. (realmente me confunde, le pierdo el paso)
		int n = ctx.getChildCount();
        for (int i=0; i<n; i++) 
        {
            ParseTree c = ctx.getChild(i);
            Expresion childResult = c.accept(this);
            if(childResult != null)
            {
           	 	stack.push(childResult);
            }                     
        }
		
        ExprList exprList = new ExprList(stack.size());
		
		//añadimos todas las expresiones				
		while(!stack.isEmpty())
		{
			final Expresion expr = stack.pop();		
			exprList.addFirst(expr);				
		}	
		pop();
		return exprList;		
	}
	
	public ExprList getExprListWithSpaces(IDefine current, FP4GParser.FunctionExprListContext ctx)
	{
		if(ctx == null) return null; //En cierto codigo aveces ExprList puede ser null porque no se escribio, asi que solo se regresa null. La comprobación se hace desde afuera si este es null o no.
		this.current = current;
		pushStack();		
		
		//visitamos los hijos personalmente, evitamos usar cada vez menos la pila. (realmente me confunde, le pierdo el paso)
		int n = ctx.getChildCount();
        for (int i=0; i<n; i++) 
        {
            ParseTree c = ctx.getChild(i);
            Expresion childResult = c.accept(this);
            if(childResult != null)
            {
           	 	stack.push(childResult);
            }                     
        }
		
        ExprList exprList = new ExprList(stack.size());
		
		//añadimos todas las expresiones				
		while(!stack.isEmpty())
		{
			final Expresion expr = stack.pop();		
			exprList.addFirst(expr);				
		}	
		pop();
		return exprList;		
	}
	
	@Override
	public Expresion visitExprList(FP4GParser.ExprListContext ctx)
	{
		throw new IllegalStateException("Jamás debe ser invocada esta función");		
	}
	
	
	@Override
	public Expresion visitLessThanExpr(FP4GParser.LessThanExprContext ctx)
	{
		Expresion left = visit(ctx.left);
		Expresion right = visit(ctx.right);
		
		BinaryOp binaryExpr = new BinaryOp(BinaryOp.OperatorType.LessThan,left,right);
		
		return binaryExpr;		
	}
	
	@Override
	public Expresion visitMoreThanExpr(FP4GParser.MoreThanExprContext ctx)
	{
		Expresion left = visit(ctx.left);
		Expresion right = visit(ctx.right);
		
		BinaryOp binaryExpr = new BinaryOp(BinaryOp.OperatorType.MoreThan,left,right);
		
		return binaryExpr;		
	}
	
	@Override
	public Expresion visitEqualExpr(FP4GParser.EqualExprContext ctx)
	{
		Expresion left = visit(ctx.left);
		Expresion right = visit(ctx.right);
		
		BinaryOp binaryExpr = new BinaryOp(BinaryOp.OperatorType.Equal,left,right);
		
		return binaryExpr;
	}
	
	@Override
	public Expresion visitMinusExpr(FP4GParser.MinusExprContext ctx)
	{		
		Expresion expr = visit(ctx.op);;
		UnaryOp unaryExpr = new UnaryOp(UnaryOp.Type.Minus,expr);
		
		return unaryExpr;		
	}
	
	@Override
	public Expresion visitMultExpr(FP4GParser.MultExprContext ctx)
	{	
		Expresion left = visit(ctx.left);
		Expresion right = visit(ctx.right);
				
		BinaryOp binaryExpr = new BinaryOp(BinaryOp.OperatorType.Mult,left,right);
			
		return binaryExpr;
	}
	
	@Override
	public Expresion visitDivExpr(FP4GParser.DivExprContext ctx)
	{
		Expresion left = visit(ctx.left);
		Expresion right = visit(ctx.right);
		
		BinaryOp binaryExpr = new BinaryOp(BinaryOp.OperatorType.Div,left,right);
		
		return binaryExpr;
	}
	
	@Override
	public Expresion visitAddExpr(FP4GParser.AddExprContext ctx)
	{		
		Expresion left = visit(ctx.left);
		Expresion right = visit(ctx.right);
		
		BinaryOp binaryExpr = new BinaryOp(BinaryOp.OperatorType.Add,left,right);
		
		return binaryExpr;
	}
	
	@Override
	public Expresion visitSubExpr(FP4GParser.SubExprContext ctx)
	{
		Expresion left = visit(ctx.left);
		Expresion right = visit(ctx.right);		
		
		BinaryOp binaryExpr = new BinaryOp(BinaryOp.OperatorType.Sub,left,right);
		
		return binaryExpr;
	}
	
	@Override
	public Expresion visitIntLiteral(FP4GParser.IntLiteralContext ctx)
	{
		Integer integer = Integer.valueOf(ctx.getText());
		Literal<Integer> literal = new IntegerLiteral(integer);
		
		return literal;
	}
	
	@Override
	public Expresion visitDecimalLiteral(FP4GParser.DecimalLiteralContext ctx)
	{
		Float integer = Float.valueOf(ctx.getText());
		Literal<Float> literal = new FloatLiteral(integer);
				
		return literal;
	}
	
	//logical expresion
	@Override
	public Expresion visitNotExpr(FP4GParser.NotExprContext ctx)
	{			
		Expresion expr = visit(ctx.op);;		
		UnaryOp unaryExpr = new UnaryOp(UnaryOp.Type.Not,expr);
 
		return unaryExpr;
	}
	
	@Override
	public Expresion visitParExpr(FP4GParser.ParExprContext ctx)
	{		
		Expresion expr = visit(ctx.op);
		//TODO debo habilitar de nuevo esta funcion?
		//expr.setPar(true); //establecemos que esta expresión, lleva parentesis
				
		return expr;
	}	
	
	@Override 
	public Expresion visitBoolLiteral(FP4GParser.BoolLiteralContext ctx)
	{
		boolean bool = Boolean.parseBoolean(ctx.BOOL_LITERAL().getText());
		Literal<Boolean> literal = new BoolLiteral(bool);
				
		return literal;
	}
	
	@Override
	public Expresion visitToExpr(FP4GParser.ToExprContext ctx)
	{
		//identificar primero si son las constantes GAME, SELF y OTHER
		if(ctx.gameTo != null)
		{
			return ToExpr.GAME;
		}else 
		if(ctx.selfTo != null)
		{
			return ToExpr.SELF;
		}else
		if(ctx.otherTo != null)
		{
			return ToExpr.OTHER;
		}
		else //ctx.idTo
		{
			//regresamos el nombre sin comprobar ni nada, la comprobación de que si es sistema o no, se hará en tiempo de generación
			return new ToExpr(ctx.idTo.getText());
		}		
	}
	@Override
	public Expresion visitDefineAddExpr(FP4GParser.DefineAddExprContext ctx)
	{
		try 
		{
			Message message  = lib.getDefine(DefineTypes.MESSAGE,ctx.defineName.getText());
			AddMethod method = message.getAddMethod(ctx.addName.getText());
			if(method == null)
			{
				throw new FP4GRuntimeException(FP4GWarn.MissingDefineAdd,String.format("No se encontró el Add %s en %s",ctx.addName.getText(),ctx.defineName.getText()));
			}
			return new AddExpr(method);
		}
		catch (DefineNotFoundException e) 
		{
			throw new FP4GRuntimeException(FP4GWarn.MissingDefineAdd,String.format("No se encontró el Add %s en %s",ctx.addName.getText(),ctx.defineName.getText()));
		}				
	}
	
	@Override
	public Expresion visitMessageExpr(FP4GParser.MessageExprContext ctx)
	{
		String messageName = ctx.methodName.getText();
		AddMethod method = methods().getMessageMethod(messageName);
		
		pushStack();
		ExprList exprList = getExprList(current,ctx.exprList()); //acá se crea un nuevo stack!
		pop();
		
		return new MessageExpr(method,exprList);
	}

	//otros visitors
		
	@Override
	public Expresion visitArray(FP4GParser.ArrayContext ctx)
	{		
		return visit(ctx.arrayBody());		
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Expresion visitEmptyArray(FP4GParser.EmptyArrayContext ctx)
	{		
		Literal<?> empty = null;
		ClassLoader cl = getClass().getClassLoader();
		try {
			Class<?> clazz = cl.loadClass(String.format("fp4g.classes.%s",ctx.bean));								
			if(IMap.class.isAssignableFrom(clazz))
			{
				empty = new CustomClassMap((Class<? extends IMap>) clazz);
			}
			else
			if(IList.class.isAssignableFrom(clazz))
			{
				empty = new CustomClassList((Class<? extends IList>) clazz);
			}
			else
			{
				empty = new ClassMap<Object>(clazz);
			}
		}
		catch (ClassNotFoundException e)
		{
			throw new FP4GRuntimeException(FP4GError.ClassNotFound,e.getMessage(),e);
		}	
		return empty;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Expresion visitAssocArray(FP4GParser.AssocArrayContext ctx)
	{
		IMap map = null;		
		if(ctx.bean != null)
		{			
			ClassLoader cl = getClass().getClassLoader();
			try {
				Class<?> clazz = cl.loadClass(String.format("fp4g.classes.%s",ctx.bean));								
				if(IMap.class.isAssignableFrom(clazz))
				{
					map = new CustomClassMap((Class<? extends IMap>) clazz);
				}
				else
				{
					map = new ClassMap<Object>(clazz);
				}
			}
			catch (ClassNotFoundException e)
			{
				throw new FP4GRuntimeException(FP4GError.ClassNotFound,e.getMessage(),e);
			}
		}
		//ctx.arrayBody()
		if(map == null)
		{
			map = new ArrayMap();
		}		
		map_stack.push(map);
		super.visitAssocArray(ctx);
		map_stack.pop();
		
		return (Expresion)map;		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Expresion visitListArray(FP4GParser.ListArrayContext ctx)
	{
		IList list = null;
		if(ctx.bean != null)
		{			
			ClassLoader cl = getClass().getClassLoader();
			try {
				Class<?> clazz = cl.loadClass(String.format("fp4g.classes.%s",ctx.bean));
				if(IList.class.isAssignableFrom(clazz))
				{
					list = new CustomClassList((Class<? extends IList>) clazz);
				}
				else
				{
					throw new IllegalStateException("No se puede crear una lista de esto!");
				}
			} catch (ClassNotFoundException e) {				
				throw new FP4GRuntimeException(FP4GError.ClassNotFound,e.getMessage(),e);
			}
		}
		//ctx.arrayBody()
		if(list == null)
		{
			list = new ArrayList();
		}		
		list_stack.push(list);
		super.visitListArray(ctx);
		list_stack.pop();
		
		return (Expresion)list;		
	}
	
	@Override
	public Expresion visitItemArray(FP4GParser.ItemArrayContext ctx) 
	{
		Expresion expr = visit(ctx.expr());
		IList list = list_stack.peek();
		if(expr instanceof Literal)
		{
			list.add((Literal<?>) expr);
		}
		else
		{
			try
			{
				list.add(FP4GDataVisitor.eval(current,expr));
			}
			catch(CannotEvalException e)
			{
				Log.Exception(e, ctx.start.getLine());
			}
		}		
		return null;
	}
	
	@Override
	public Expresion visitParArray(FP4GParser.ParArrayContext ctx)
	{
		String key = ctx.key;
				
		Expresion expr = visit(ctx.expr());		
		
		IMap array = map_stack.peek();
		if(expr instanceof Literal)
		{
			array.set(key, (Literal<?>) expr);
		}
		else
		{
			try
			{
				array.set(key,FP4GDataVisitor.eval(current,expr));
			}
			catch(CannotEvalException cee)
			{
				Log.Exception(cee, ctx.start.getLine());				
			}
		}		
		return null;		
	}
	

	@Override
	public Expresion visitStringLiteral(FP4GParser.StringLiteralContext ctx)
	{
		String string = ctx.STRING_LITERAL().getText();
		string = string.substring(1, string.length()-1);		
		Literal<String> literal = new StringLiteral(string);
				
		return literal;
	}
	
	@Override
	public Expresion visitDirectCode(FP4GParser.DirectCodeContext ctx)
	{
		String code = ctx.DIRECTCODE().getText();
		code = code.substring(2,code.length()-1);
		DirectCode dc = new DirectCode(code);
			
		return dc;
	}
	
	
	@Override
	public Expresion visitAccessOp(FP4GParser.AccessOpContext ctx)
	{
		//primero revisar que tipo de operacion es
		if(ctx.list.size() > 0) //si es mayor que 0, entonces, no podemos hacer referencia a un DEFINE...
		{
			VarId last = null;
			for(Iterator<String> iterator = ctx.list.descendingIterator();iterator.hasNext();)
			{
				String varName = iterator.next();
				if(last == null)
				{					
					last = new VarId(varName);	
				}
				else
				{
					last = new VarDot(varName, last);
				}				
			}
			last = new VarDot(ctx.varName.getText(),last);
			return last;
		}
		else //es igual a 0, podemos hacer referencia a un define cualquiera
		{
			String name = ctx.varName.getText();
			if(current != null)
			{
				Add add = current.findAddDefineByName(name);
				if(add != null)
				{
					return new AddExpr(add);
				}
			}
			try
			{
				return lib.getDefine(name);						
			}
			catch(DefineNotFoundException e)
			{
				return new VarId(name);
			}
		}
	}
	
}
