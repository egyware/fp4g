// Generated from C:\Users\Edgardo\Git\fp4g-src\fp4g\src/fp4g/parser/FP4G.g by ANTLR 4.1

package fp4g.parser;

import static fp4g.Log.*;

import fp4g.data.*;
import fp4g.data.define.*;
import fp4g.data.managers.*;


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
	 * Visit a parse tree produced by {@link FP4GParser#using}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsing(@NotNull FP4GParser.UsingContext ctx);

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
	 * Visit a parse tree produced by {@link FP4GParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(@NotNull FP4GParser.IdContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#usings}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsings(@NotNull FP4GParser.UsingsContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#subExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubExpr(@NotNull FP4GParser.SubExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#addExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(@NotNull FP4GParser.AddExprContext ctx);

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
	 * Visit a parse tree produced by {@link FP4GParser#gameValues}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGameValues(@NotNull FP4GParser.GameValuesContext ctx);

	/**
	 * Visit a parse tree produced by {@link FP4GParser#game}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGame(@NotNull FP4GParser.GameContext ctx);

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
	 * Visit a parse tree produced by {@link FP4GParser#minusExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinusExpr(@NotNull FP4GParser.MinusExprContext ctx);

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
}