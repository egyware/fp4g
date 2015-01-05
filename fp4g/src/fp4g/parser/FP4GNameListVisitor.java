package fp4g.parser;

import org.antlr.v4.runtime.tree.ParseTree;

import fp4g.core.Expresion;
import fp4g.core.IValue;
import fp4g.data.DeclVar;
import fp4g.data.IDefine;
import fp4g.data.NameList;
import fp4g.data.VarType;
import fp4g.exceptions.CannotEvalException;
import fp4g.log.Log;
import fp4g.parser.FP4GParser.DeclareVarContext;


public class FP4GNameListVisitor extends FP4GBaseVisitor<DeclVar>  
{
	private final FP4GExpresionVisitor exprVisitor;
	
	public FP4GNameListVisitor(FP4GExpresionVisitor exprVisitor)
	{
		this.exprVisitor = exprVisitor;		
	}
	
	public NameList getNameList(IDefine current, FP4GParser.NameListContext ctx)
	{
		if(ctx == null) return null;
		final NameList list = new NameList();
		
		final int n = ctx.getChildCount();		
        for (int i=0; i<n; i++) 
        {
            ParseTree c = ctx.getChild(i);
            if(c instanceof FP4GParser.DeclareVarContext)
            {
            	DeclVar declVar = visitDeclareVar(current,(DeclareVarContext) c);
            	list.add(declVar);
            }                    
        }
        return list;		
	}
	
	public NameList getFlags(NameList list, IDefine current, FP4GParser.FlagContext ctx)
	{
		if(ctx == null) return null;
		if(list ==  null) list = new NameList();
		
		DeclVar var = visitDeclareVar(current, ctx.declareVar());
		list.add(var);
		
        return list;		
	}
	
	
	public DeclVar visitDeclareVar(IDefine current, FP4GParser.DeclareVarContext ctx)
	{
		//: varType varName=ID (EQUAL initValue = expr)?;
		DeclVar declVar;
		final VarType type = ctx.varType().type;
		if(ctx.initValue != null)
		{			
			try
			{
				Expresion initExpr = exprVisitor.visit(ctx.initValue);
				IValue<?> initValue = initExpr.eval(current);
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
