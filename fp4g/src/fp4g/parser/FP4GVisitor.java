// Generated from C:\Users\Edgardo\Git\fp4g-src\fp4g\src/fp4g/parser/FP4G.g4 by ANTLR 4.1

package fp4g.parser;

import static fp4g.Log.*;

import fp4g.data.*;
import fp4g.data.define.*;

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
	 * Visit a parse tree produced by {@link FP4GParser#subNExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubNExpr(@NotNull FP4GParser.SubNExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#divNExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivNExpr(@NotNull FP4GParser.DivNExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#assetType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssetType(@NotNull FP4GParser.AssetTypeContext ctx);

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
	 * Visit a parse tree produced by {@link FP4GParser#gameLib}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGameLib(@NotNull FP4GParser.GameLibContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#minusNExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinusNExpr(@NotNull FP4GParser.MinusNExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#logicalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalExpr(@NotNull FP4GParser.LogicalExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#gameValues}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGameValues(@NotNull FP4GParser.GameValuesContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#multNExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultNExpr(@NotNull FP4GParser.MultNExprContext ctx);

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
	 * Visit a parse tree produced by {@link FP4GParser#assets}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssets(@NotNull FP4GParser.AssetsContext ctx);

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
	 * Visit a parse tree produced by {@link FP4GParser#nameList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNameList(@NotNull FP4GParser.NameListContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#onStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnStatement(@NotNull FP4GParser.OnStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#accessVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessVar(@NotNull FP4GParser.AccessVarContext ctx);

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
	 * Visit a parse tree produced by {@link FP4GParser#varLExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarLExpr(@NotNull FP4GParser.VarLExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#assetValueInner}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssetValueInner(@NotNull FP4GParser.AssetValueInnerContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#numericExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericExpr(@NotNull FP4GParser.NumericExprContext ctx);

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
	 * Visit a parse tree produced by {@link FP4GParser#notLExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotLExpr(@NotNull FP4GParser.NotLExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#parLExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParLExpr(@NotNull FP4GParser.ParLExprContext ctx);

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
	 * Visit a parse tree produced by {@link FP4GParser#addNExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddNExpr(@NotNull FP4GParser.AddNExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#declareVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareVar(@NotNull FP4GParser.DeclareVarContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#usings}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsings(@NotNull FP4GParser.UsingsContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#varNExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarNExpr(@NotNull FP4GParser.VarNExprContext ctx);

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
	 * Visit a parse tree produced by {@link FP4GParser#game}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGame(@NotNull FP4GParser.GameContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#parNExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParNExpr(@NotNull FP4GParser.ParNExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#parArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParArray(@NotNull FP4GParser.ParArrayContext ctx);
}