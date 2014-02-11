// Generated from C:\Users\edgardo.moreno\git\fp4g\fp4g\src/fp4g/parser/FP4G.g4 by ANTLR 4.1

package fp4g.parser;

import static fp4g.log.Log.*;

import fp4g.data.*;
import fp4g.data.statements.*;
import fp4g.data.define.*;
import fp4g.data.vartypes.*;

import java.util.LinkedList;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FP4GParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FP4GVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FP4GParser#multExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultExpr(@NotNull FP4GParser.MultExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#functionCallExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpr(@NotNull FP4GParser.FunctionCallExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#using}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsing(@NotNull FP4GParser.UsingContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#send}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSend(@NotNull FP4GParser.SendContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#accessVarOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessVarOperator(@NotNull FP4GParser.AccessVarOperatorContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#listArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListArray(@NotNull FP4GParser.ListArrayContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#currentOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCurrentOperator(@NotNull FP4GParser.CurrentOperatorContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#stringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(@NotNull FP4GParser.StringLiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#arrayExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpr(@NotNull FP4GParser.ArrayExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#defineValues}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefineValues(@NotNull FP4GParser.DefineValuesContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#parExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpr(@NotNull FP4GParser.ParExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#onStatements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnStatements(@NotNull FP4GParser.OnStatementsContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#subExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubExpr(@NotNull FP4GParser.SubExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#varParent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarParent(@NotNull FP4GParser.VarParentContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#onFilters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnFilters(@NotNull FP4GParser.OnFiltersContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#on}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOn(@NotNull FP4GParser.OnContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#intLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntLiteral(@NotNull FP4GParser.IntLiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#assocArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssocArray(@NotNull FP4GParser.AssocArrayContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#accessVarName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessVarName(@NotNull FP4GParser.AccessVarNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#gameLib}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGameLib(@NotNull FP4GParser.GameLibContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#gameValues}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGameValues(@NotNull FP4GParser.GameValuesContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#decimalLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimalLiteral(@NotNull FP4GParser.DecimalLiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#gameValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGameValue(@NotNull FP4GParser.GameValueContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#assetValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssetValue(@NotNull FP4GParser.AssetValueContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#varID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarID(@NotNull FP4GParser.VarIDContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#assets}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssets(@NotNull FP4GParser.AssetsContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#varNameOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarNameOperator(@NotNull FP4GParser.VarNameOperatorContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#boolLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolLiteral(@NotNull FP4GParser.BoolLiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(@NotNull FP4GParser.StartContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull FP4GParser.ProgramContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#itemArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItemArray(@NotNull FP4GParser.ItemArrayContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#nameList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNameList(@NotNull FP4GParser.NameListContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#parentOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentOperator(@NotNull FP4GParser.ParentOperatorContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#onStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnStatement(@NotNull FP4GParser.OnStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilter(@NotNull FP4GParser.FilterContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(@NotNull FP4GParser.ArrayContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#assetValuesInner}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssetValuesInner(@NotNull FP4GParser.AssetValuesInnerContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#assetValueInner}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssetValueInner(@NotNull FP4GParser.AssetValueInnerContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet(@NotNull FP4GParser.SetContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#varExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarExpr(@NotNull FP4GParser.VarExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#add}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(@NotNull FP4GParser.AddContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#varType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarType(@NotNull FP4GParser.VarTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#declareVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareVar(@NotNull FP4GParser.DeclareVarContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#destroy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDestroy(@NotNull FP4GParser.DestroyContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#usings}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsings(@NotNull FP4GParser.UsingsContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#varName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarName(@NotNull FP4GParser.VarNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#addExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(@NotNull FP4GParser.AddExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#exprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprList(@NotNull FP4GParser.ExprListContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#defineValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefineValue(@NotNull FP4GParser.DefineValueContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#notExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(@NotNull FP4GParser.NotExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#divExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivExpr(@NotNull FP4GParser.DivExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#define}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine(@NotNull FP4GParser.DefineContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#directCode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirectCode(@NotNull FP4GParser.DirectCodeContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#varCurrent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarCurrent(@NotNull FP4GParser.VarCurrentContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#game}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGame(@NotNull FP4GParser.GameContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#minusExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinusExpr(@NotNull FP4GParser.MinusExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#parArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParArray(@NotNull FP4GParser.ParArrayContext ctx);
}