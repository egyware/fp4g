package fp4g.parser;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import fp4g.data.ExprList;
import fp4g.data.Expresion;
import fp4g.data.IDefine;
import fp4g.data.ILib;
import fp4g.data.Statement;
import fp4g.data.Statements;
import fp4g.data.expresion.FunctionCall;
import fp4g.data.statements.Assignment;

public class FP4GStatementVisitor extends FP4GBaseVisitor<Statement> 
{
	private final FP4GExpresionVisitor exprVisitor;	
	private final ILib lib;
	
	public FP4GStatementVisitor(ILib lib, FP4GExpresionVisitor exprVisitor)
	{
		this.exprVisitor = exprVisitor;
		this.lib   = lib;
		
	}
	
	@Override
	public Statement visitAssign(FP4GParser.AssignContext ctx)
	{
		String varName = ctx.varName.getText();
		Expresion expresion = exprVisitor.visit(ctx.expr());
		
		return new Assignment(varName, expresion);		
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
		if((statement != null)&&(tree instanceof ParserRuleContext))
		{
			statement.setLine(((ParserRuleContext) tree).getStart().getLine());			
		}		
		return statement;		
	}
	
	@Override
	public Statement visitFunctionCall(FP4GParser.FunctionCallContext ctx)
	{
		String callName = ctx.name.getText();		
		ExprList exprList = exprVisitor.getExprListWithSpaces(current,ctx.functionExprList()); //acá se crea un nuevo stack!
				
		//le paso también el define donde se está invocando 01-03-2014
		FunctionCall functionCall = new FunctionCall(current, callName, exprList);
		exprList = null;		
		
		return functionCall;
	}	
}
