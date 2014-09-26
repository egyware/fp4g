// Generated from C:\Users\Edgardo\Git\fp4g-src\fp4g\src/fp4g/parser/FP4G.g4 by ANTLR 4.1

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
	 * Visit a parse tree produced by {@link FP4GParser#messageExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessageExpr(@NotNull FP4GParser.MessageExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(@NotNull FP4GParser.AssignContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#using}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsing(@NotNull FP4GParser.UsingContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#usingValues}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingValues(@NotNull FP4GParser.UsingValuesContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#listArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListArray(@NotNull FP4GParser.ListArrayContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#stringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(@NotNull FP4GParser.StringLiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#add}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddMethod(@NotNull FP4GParser.AddMethodContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#accessOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessOp(@NotNull FP4GParser.AccessOpContext ctx);

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
	 * Visit a parse tree produced by {@link FP4GParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(@NotNull FP4GParser.FunctionCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#addDefine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddDefine(@NotNull FP4GParser.AddDefineContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#subExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubExpr(@NotNull FP4GParser.SubExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#parseLib}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParseLib(@NotNull FP4GParser.ParseLibContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#when}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhen(@NotNull FP4GParser.WhenContext ctx);

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
	 * Visit a parse tree produced by {@link FP4GParser#gameValues}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGameValues(@NotNull FP4GParser.GameValuesContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#emptyArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyArray(@NotNull FP4GParser.EmptyArrayContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#toExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToExpr(@NotNull FP4GParser.ToExprContext ctx);

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
	 * Visit a parse tree produced by {@link FP4GParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull FP4GParser.StatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#moreThanExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoreThanExpr(@NotNull FP4GParser.MoreThanExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#assets}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssets(@NotNull FP4GParser.AssetsContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#flag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlag(@NotNull FP4GParser.FlagContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#boolLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolLiteral(@NotNull FP4GParser.BoolLiteralContext ctx);

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
	 * Visit a parse tree produced by {@link FP4GParser#equalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualExpr(@NotNull FP4GParser.EqualExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#libBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLibBody(@NotNull FP4GParser.LibBodyContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#programBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramBody(@NotNull FP4GParser.ProgramBodyContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet(@NotNull FP4GParser.SetContext ctx);

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
	 * Visit a parse tree produced by {@link FP4GParser#usingValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingValue(@NotNull FP4GParser.UsingValueContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#declareVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareVar(@NotNull FP4GParser.DeclareVarContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#defineID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefineID(@NotNull FP4GParser.DefineIDContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#usings}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsings(@NotNull FP4GParser.UsingsContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(@NotNull FP4GParser.StatementsContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#addExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(@NotNull FP4GParser.AddExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#accessOpExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessOpExpr(@NotNull FP4GParser.AccessOpExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#divExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivExpr(@NotNull FP4GParser.DivExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#defineValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefineValue(@NotNull FP4GParser.DefineValueContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#exprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprList(@NotNull FP4GParser.ExprListContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#notExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(@NotNull FP4GParser.NotExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#lessThanExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessThanExpr(@NotNull FP4GParser.LessThanExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#define}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine(@NotNull FP4GParser.DefineContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#defineAddExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefineAddExpr(@NotNull FP4GParser.DefineAddExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#functionExprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionExprList(@NotNull FP4GParser.FunctionExprListContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#assetValueWithInnerValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssetValueWithInnerValue(@NotNull FP4GParser.AssetValueWithInnerValueContext ctx);

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