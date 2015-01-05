// Generated from C:\Users\edgardo.moreno\git\fp4g\fp4g\src/fp4g/parser/FP4G.g4 by ANTLR 4.4

package fp4g.parser;

import static fp4g.log.Log.*;

import fp4g.core.*;
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
	 * Visit a parse tree produced by the {@code decimalLiteral}
	 * labeled alternative in {@link FP4GParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimalLiteral(@NotNull FP4GParser.DecimalLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assocArray}
	 * labeled alternative in {@link FP4GParser#arrayBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssocArray(@NotNull FP4GParser.AssocArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code defineAddExpr}
	 * labeled alternative in {@link FP4GParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefineAddExpr(@NotNull FP4GParser.DefineAddExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code moreThanExpr}
	 * labeled alternative in {@link FP4GParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoreThanExpr(@NotNull FP4GParser.MoreThanExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FP4GParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull FP4GParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link FP4GParser#assetValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssetValue(@NotNull FP4GParser.AssetValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link FP4GParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull FP4GParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link FP4GParser#assetValueWithInnerValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssetValueWithInnerValue(@NotNull FP4GParser.AssetValueWithInnerValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link FP4GParser#when}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhen(@NotNull FP4GParser.WhenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code minusExpr}
	 * labeled alternative in {@link FP4GParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinusExpr(@NotNull FP4GParser.MinusExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link FP4GParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpr(@NotNull FP4GParser.ParExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FP4GParser#varType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarType(@NotNull FP4GParser.VarTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link FP4GParser#assets}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssets(@NotNull FP4GParser.AssetsContext ctx);
	/**
	 * Visit a parse tree produced by {@link FP4GParser#libBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLibBody(@NotNull FP4GParser.LibBodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code divExpr}
	 * labeled alternative in {@link FP4GParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivExpr(@NotNull FP4GParser.DivExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FP4GParser#parseLib}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParseLib(@NotNull FP4GParser.ParseLibContext ctx);
	/**
	 * Visit a parse tree produced by {@link FP4GParser#resolver}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResolver(@NotNull FP4GParser.ResolverContext ctx);
	/**
	 * Visit a parse tree produced by {@link FP4GParser#assetValuesInner}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssetValuesInner(@NotNull FP4GParser.AssetValuesInnerContext ctx);
	/**
	 * Visit a parse tree produced by {@link FP4GParser#onFilters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnFilters(@NotNull FP4GParser.OnFiltersContext ctx);
	/**
	 * Visit a parse tree produced by {@link FP4GParser#parArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParArray(@NotNull FP4GParser.ParArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multExpr}
	 * labeled alternative in {@link FP4GParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultExpr(@NotNull FP4GParser.MultExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code accessOpExpr}
	 * labeled alternative in {@link FP4GParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessOpExpr(@NotNull FP4GParser.AccessOpExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link FP4GParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(@NotNull FP4GParser.NotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link FP4GParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(@NotNull FP4GParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link FP4GParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(@NotNull FP4GParser.AddExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FP4GParser#instantiator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstantiator(@NotNull FP4GParser.InstantiatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link FP4GParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(@NotNull FP4GParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code directCode}
	 * labeled alternative in {@link FP4GParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirectCode(@NotNull FP4GParser.DirectCodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code listArray}
	 * labeled alternative in {@link FP4GParser#arrayBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListArray(@NotNull FP4GParser.ListArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link FP4GParser#functionExprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionExprList(@NotNull FP4GParser.FunctionExprListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code emptyArray}
	 * labeled alternative in {@link FP4GParser#arrayBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyArray(@NotNull FP4GParser.EmptyArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link FP4GParser#declareVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareVar(@NotNull FP4GParser.DeclareVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link FP4GParser#itemArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItemArray(@NotNull FP4GParser.ItemArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code toExpr}
	 * labeled alternative in {@link FP4GParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToExpr(@NotNull FP4GParser.ToExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FP4GParser#defineID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefineID(@NotNull FP4GParser.DefineIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link FP4GParser#flag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlag(@NotNull FP4GParser.FlagContext ctx);
	/**
	 * Visit a parse tree produced by {@link FP4GParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(@NotNull FP4GParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link FP4GParser#modifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifiers(@NotNull FP4GParser.ModifiersContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subExpr}
	 * labeled alternative in {@link FP4GParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubExpr(@NotNull FP4GParser.SubExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolLiteral}
	 * labeled alternative in {@link FP4GParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolLiteral(@NotNull FP4GParser.BoolLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link FP4GParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(@NotNull FP4GParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link FP4GParser#define}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine(@NotNull FP4GParser.DefineContext ctx);
	/**
	 * Visit a parse tree produced by {@link FP4GParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull FP4GParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FP4GParser#on}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOn(@NotNull FP4GParser.OnContext ctx);
	/**
	 * Visit a parse tree produced by {@link FP4GParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet(@NotNull FP4GParser.SetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link FP4GParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpr(@NotNull FP4GParser.ArrayExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lessThanExpr}
	 * labeled alternative in {@link FP4GParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessThanExpr(@NotNull FP4GParser.LessThanExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intLiteral}
	 * labeled alternative in {@link FP4GParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntLiteral(@NotNull FP4GParser.IntLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link FP4GParser#defineValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefineValue(@NotNull FP4GParser.DefineValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link FP4GParser#accessOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessOp(@NotNull FP4GParser.AccessOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link FP4GParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilter(@NotNull FP4GParser.FilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code messageExpr}
	 * labeled alternative in {@link FP4GParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessageExpr(@NotNull FP4GParser.MessageExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FP4GParser#programBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramBody(@NotNull FP4GParser.ProgramBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link FP4GParser#exprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprList(@NotNull FP4GParser.ExprListContext ctx);
	/**
	 * Visit a parse tree produced by {@link FP4GParser#nameList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNameList(@NotNull FP4GParser.NameListContext ctx);
	/**
	 * Visit a parse tree produced by {@link FP4GParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(@NotNull FP4GParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalExpr}
	 * labeled alternative in {@link FP4GParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualExpr(@NotNull FP4GParser.EqualExprContext ctx);
}