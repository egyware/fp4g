package fp4g.parser;

import java.util.Stack;

import org.antlr.v4.runtime.tree.ParseTree;

import fp4g.data.DeclVar;
import fp4g.data.Expresion;
import fp4g.data.IDefine;
import fp4g.data.IValue;
import fp4g.data.NameList;
import fp4g.data.VarType;
import fp4g.exceptions.CannotEvalException;
import fp4g.log.Log;


public class FP4GNameListVisitor extends FP4GBaseVisitor<DeclVar>  
{
	private final FP4GExpresionVisitor exprVisitor;
	private final Stack<IDefine> current;
	
	public FP4GNameListVisitor(FP4GExpresionVisitor exprVisitor, Stack<IDefine> current)
	{
		this.exprVisitor = exprVisitor;
		this.current = current;
	}
	
	public NameList getNameList(FP4GParser.NameListContext ctx)
	{
		if(ctx == null) return null;
		final NameList list = new NameList();
		final int n = ctx.getChildCount();		
        for (int i=0; i<n; i++) 
        {
            ParseTree c = ctx.getChild(i);
            DeclVar childResult = c.accept(this);
            if(childResult != null)
            {
           	 	list.add(childResult);
            }                     
        }
        return list;		
	}
	
	
	@Override 
	public DeclVar visitDeclareVar(FP4GParser.DeclareVarContext ctx)
	{
		//: varType varName=ID (EQUAL initValue = expr)?;
		DeclVar declVar;
		final VarType type = ctx.varType().type;
		if(ctx.initValue != null)
		{			
			try
			{
				Expresion initExpr = exprVisitor.visit(ctx.initValue);
				IValue<?> initValue = initExpr.eval(current.peek());
				declVar = new DeclVar(type, ctx.varName.getText(),initValue);
			}
			catch (CannotEvalException e) 
			{
				Log.Exception(e,ctx.start.getLine());
				declVar = new DeclVar(type, ctx.varName.getText());
			}
		}
		else
		{
			declVar = new DeclVar(type, ctx.varName.getText());
		}
		return declVar;		
	}	
	
}
