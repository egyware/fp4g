/**
 * 
 */
package fp4g.parser;

import static fp4g.Log.Show;

import java.util.Stack;

import org.antlr.v4.runtime.tree.ParseTree;

import fp4g.Log;
import fp4g.Log.ErrType;
import fp4g.Log.WarnType;
import fp4g.data.ExprList;
import fp4g.data.Expresion;
import fp4g.data.IDefine;
import fp4g.data.expresion.ArrayList;
import fp4g.data.expresion.ArrayMap;
import fp4g.data.expresion.BinaryOp;
import fp4g.data.expresion.ClassMap;
import fp4g.data.expresion.CustomClassList;
import fp4g.data.expresion.CustomClassMap;
import fp4g.data.expresion.DirectCode;
import fp4g.data.expresion.FunctionCall;
import fp4g.data.expresion.List;
import fp4g.data.expresion.Literal;
import fp4g.data.expresion.Map;
import fp4g.data.expresion.UnaryOp;
import fp4g.data.expresion.VarDot;
import fp4g.data.expresion.VarId;
import fp4g.data.expresion.literals.BoolLiteral;
import fp4g.data.expresion.literals.FloatLiteral;
import fp4g.data.expresion.literals.IntegerLiteral;
import fp4g.data.expresion.literals.StringLiteral;
import fp4g.exceptions.CannotEvalException;
import fp4g.parser.FP4GParser.ArrayBodyContext;

/**
 * @author Edgardo
 *
 */
public class FP4GExpresionVisitor extends FP4GBaseVisitor<Expresion> 
{
	private final Stack<Stack<Expresion>> stacks = new Stack<Stack<Expresion>>();	
	private Stack<Expresion> stack;
	private final Stack<IDefine> current;
	private final Stack<Map> map_stack = new Stack<Map>();
	private final Stack<List> list_stack = new Stack<List>();
	
	public FP4GExpresionVisitor(Stack<IDefine> d)
	{
		current = d;
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
	
	public ExprList getExprList(FP4GParser.ExprListContext ctx)
	{
		if(ctx == null) return null; //En cierto codigo aveces ExprList puede ser null porque no se escribio, asi que solo se regresa null. La comprobación se hace desde afuera si este es null o no.
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
	
	
	//numeric expresion!
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
				
		BinaryOp binaryExpr = new BinaryOp(BinaryOp.Type.Mult,left,right);
			
		return binaryExpr;
	}
	
	@Override
	public Expresion visitDivExpr(FP4GParser.DivExprContext ctx)
	{
		Expresion left = visit(ctx.left);
		Expresion right = visit(ctx.right);
		
		BinaryOp binaryExpr = new BinaryOp(BinaryOp.Type.Div,left,right);
		
		return binaryExpr;
	}
	
	@Override
	public Expresion visitAddExpr(FP4GParser.AddExprContext ctx)
	{		
		Expresion left = visit(ctx.left);
		Expresion right = visit(ctx.right);
		
		BinaryOp binaryExpr = new BinaryOp(BinaryOp.Type.Add,left,right);
		
		return binaryExpr;
	}
	
	@Override
	public Expresion visitSubExpr(FP4GParser.SubExprContext ctx)
	{
		Expresion left = visit(ctx.left);
		Expresion right = visit(ctx.right);		
		
		BinaryOp binaryExpr = new BinaryOp(BinaryOp.Type.Sub,left,right);
		
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
		expr.setPar(true); //establecemos que esta expresión, lleva parentesis
				
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
	public Expresion visitVarExpr(FP4GParser.VarExprContext ctx)
	{		
		//¿Para que era esto?
		return super.visitVarExpr(ctx);		
	}
	
	
	
	//otros visitors	
	@Override
	public Expresion visitFunctionCallExpr(FP4GParser.FunctionCallExprContext ctx)
	{
		//guardamos el actual stack!
		pushStack();
		
		String callName = ctx.functionName.getText();
		
		ExprList exprList = getExprList(ctx.exprList()); //acá se crea un nuevo stack!
				
		FunctionCall functionCall = new FunctionCall(callName,exprList);
		exprList = null;		
		
		//restablecemos el stack anterior
		pop();		
				
		return functionCall;
	}	
		
	@Override
	public Expresion visitArray(FP4GParser.ArrayContext ctx)
	{		
		//pequeño parche y entendible para pasarle los datos hacia abajo.
		//Abajo hacia los nodos hojas, entiendase que estoy recorriendo un arbol.
		ArrayBodyContext arrayBodyContext = ctx.arrayBody();
		arrayBodyContext.bean = ctx.bean;
		return visit(arrayBodyContext);		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Expresion visitAssocArray(FP4GParser.AssocArrayContext ctx)
	{
		Map map = null;		
		if(ctx.bean != null)
		{			
			ClassLoader cl = getClass().getClassLoader();
			try {
				Class<?> clazz = cl.loadClass(String.format("fp4g.classes.%s",ctx.bean));								
				if(Map.class.isAssignableFrom(clazz))
				{
					map = new CustomClassMap((Class<? extends Map>) clazz);
				}
				else
				{
					map = new ClassMap<Object>(clazz);
				}
			} catch (ClassNotFoundException e) {				
				Show(ErrType.ClassNotFound,ctx.bean);
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
		List list = null;
		if(ctx.bean != null)
		{			
			ClassLoader cl = getClass().getClassLoader();
			try {
				Class<?> clazz = cl.loadClass(String.format("fp4g.classes.%s",ctx.bean));
				if(List.class.isAssignableFrom(clazz))
				{
					list = new CustomClassList((Class<? extends List>) clazz);
				}
				else
				{
					throw new IllegalStateException("No se puede crear una lista de esto!");
				}
			} catch (ClassNotFoundException e) {				
				Show(ErrType.ClassNotFound,ctx.bean);
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
		List list = list_stack.peek();
		if(expr instanceof Literal)
		{
			list.add((Literal<?>) expr);
		}
		else
		{
			try 
			{
				list.add(FP4GDataVisitor.eval(current.peek(),expr));
			}
			catch (CannotEvalException e) 
			{
				Log.Show(WarnType.CannotEvalExpr,ctx.expr().start.getLine());
			}
		}		
		return null;
	}
	
	@Override
	public Expresion visitParArray(FP4GParser.ParArrayContext ctx)
	{
		String key = ctx.key;
				
		Expresion expr = visit(ctx.expr());		
		
		Map array = map_stack.peek();
		if(expr instanceof Literal)
		{
			array.set(key, (Literal<?>) expr);
		}
		else
		{
			try
			{
				array.set(key,FP4GDataVisitor.eval(current.peek(),expr));
			}
			catch(CannotEvalException cee)
			{
				Log.Show(WarnType.CannotEvalExpr,ctx.start.getLine());
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
	public Expresion visitAccessVarName(FP4GParser.AccessVarNameContext ctx)
	{
		//devuelve el regreso de los nodos hijos. (las 3 siguientes funciones...)
		return visit(ctx.var);
	}
	
	@Override 
	public Expresion visitVarCurrent(FP4GParser.VarCurrentContext ctx)
	{
		return VarId.current;
	}
	
	@Override
	public Expresion visitVarParent(FP4GParser.VarParentContext ctx)
	{
		return VarId.parent;
	}
	
	@Override 
	public Expresion visitVarName(FP4GParser.VarNameContext ctx)
	{
		return new VarId(ctx.varName.getText());
	}
	
	
	@Override 
	public Expresion visitCurrentOperator(FP4GParser.CurrentOperatorContext ctx)
	{
		return VarId.current;
	}
	
	@Override
	public Expresion visitParentOperator(FP4GParser.ParentOperatorContext ctx)
	{
		return VarId.parent;
	}
	
	@Override 
	public Expresion visitVarNameOperator(FP4GParser.VarNameOperatorContext ctx)
	{
		return null;
	}
	
	@Override
	public Expresion visitAccessVarOperator(FP4GParser.AccessVarOperatorContext ctx)
	{
		VarId varId    = (VarId)visit(ctx.pVar);
		VarId property = (VarId)visit(ctx.propertyAccess);
		if(varId == VarId.current)
		{
			VarDot var = new VarDot(VarDot.current, property);
			return var;
		}else
		if(varId == VarId.parent)
		{
			VarDot var = new VarDot(VarDot.parent, property);
			return var;
		}
		else
		{
			VarDot var = new VarDot(ctx.pVar.name,property);
			return var;
		}	
	}
}
