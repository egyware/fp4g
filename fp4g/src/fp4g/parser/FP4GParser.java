// Generated from C:\Users\Edgardo\Git\fp4g-src\fp4g\src/fp4g/parser/FP4G.g4 by ANTLR 4.1

package fp4g.parser;

import static fp4g.log.Log.*;

import fp4g.core.*;
import fp4g.data.*;
import fp4g.data.statements.*;
import fp4g.data.define.*;
import fp4g.data.vartypes.*;

import java.util.LinkedList;


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FP4GParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SINGLE_LINE_COMMENT=1, MULTI_LINE_COMMENT=2, TYPE=3, RESOLVER=4, DEFINE=5, 
		MODEL=6, CONTROLLER=7, VIEW=8, SET=9, ADD=10, ON=11, USING=12, START=13, 
		ASSETS=14, FLAG=15, WHEN=16, FOR=17, MANAGER=18, GAME=19, STATE=20, ASSET=21, 
		BEHAVIOR=22, ENTITY=23, GOAL=24, MESSAGE=25, BASE=26, TO=27, SOURCE=28, 
		AS=29, OTHER=30, SELF=31, EMPTY=32, THEN=33, ABRE_COR=34, ABRE_PAR=35, 
		ABRE_LLAV=36, CIERRA_COR=37, CIERRA_PAR=38, CIERRA_LLAV=39, COMA=40, EQUAL=41, 
		DOT=42, DOTCOMA=43, DOUBLEDOT=44, PLUS=45, MINUS=46, MULTIPLY=47, DIVIDE=48, 
		MORE_THAN=49, LESS_THAN=50, AND=51, OR=52, XOR=53, NOT=54, NUMBER_TYPE=55, 
		STRING_TYPE=56, BOOL_TYPE=57, INTEGER_TYPE=58, DOUBLE_TYPE=59, FLOAT_TYPE=60, 
		DIRECTCODE=61, INT_LITERAL=62, DECIMAL_LITERAL=63, STRING_LITERAL=64, 
		BOOL_LITERAL=65, CURRENT_LITERAL=66, ID=67, NL=68, WS=69;
	public static final String[] tokenNames = {
		"<INVALID>", "SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT", "'TYPE'", "'RESOLVER'", 
		"'DEFINE'", "'MODEL'", "'CONTROLLER'", "'VIEW'", "'SET'", "'ADD'", "'ON'", 
		"'USING'", "'START'", "'ASSETS'", "'FLAG'", "'WHEN'", "'FOR'", "'MANAGER'", 
		"'GAME'", "'STATE'", "'ASSET'", "'BEHAVIOR'", "'ENTITY'", "'GOAL'", "'MESSAGE'", 
		"'BASE'", "'TO'", "'SOURCE'", "'AS'", "'OTHER'", "'SELF'", "'EMPTY'", 
		"'THEN'", "'['", "'('", "'{'", "']'", "')'", "'}'", "','", "'='", "'.'", 
		"';'", "':'", "'+'", "'-'", "'*'", "'/'", "'>'", "'<'", "'AND'", "'OR'", 
		"'XOR'", "'NOT'", "'Number'", "'String'", "'Bool'", "'Integer'", "'Double'", 
		"'Float'", "DIRECTCODE", "INT_LITERAL", "DECIMAL_LITERAL", "STRING_LITERAL", 
		"BOOL_LITERAL", "'current'", "ID", "NL", "WS"
	};
	public static final int
		RULE_program = 0, RULE_parseLib = 1, RULE_usings = 2, RULE_libBody = 3, 
		RULE_programBody = 4, RULE_type = 5, RULE_define = 6, RULE_resolver = 7, 
		RULE_set = 8, RULE_using = 9, RULE_usingValues = 10, RULE_usingValue = 11, 
		RULE_game = 12, RULE_gameValues = 13, RULE_gameValue = 14, RULE_add = 15, 
		RULE_addDefine = 16, RULE_addMethod = 17, RULE_define2 = 18, RULE_on = 19, 
		RULE_statements = 20, RULE_statement = 21, RULE_functionCall = 22, RULE_functionExprList = 23, 
		RULE_assign = 24, RULE_onFilters = 25, RULE_filter = 26, RULE_defineValues = 27, 
		RULE_defineValue = 28, RULE_exprList = 29, RULE_nameList = 30, RULE_declareVar = 31, 
		RULE_varType = 32, RULE_defineID = 33, RULE_assets = 34, RULE_assetValueWithInnerValue = 35, 
		RULE_assetValue = 36, RULE_assetValuesInner = 37, RULE_flag = 38, RULE_when = 39, 
		RULE_expr = 40, RULE_accessOp = 41, RULE_array = 42, RULE_arrayBody = 43, 
		RULE_itemArray = 44, RULE_parArray = 45;
	public static final String[] ruleNames = {
		"program", "parseLib", "usings", "libBody", "programBody", "type", "define", 
		"resolver", "set", "using", "usingValues", "usingValue", "game", "gameValues", 
		"gameValue", "add", "addDefine", "addMethod", "define2", "on", "statements", 
		"statement", "functionCall", "functionExprList", "assign", "onFilters", 
		"filter", "defineValues", "defineValue", "exprList", "nameList", "declareVar", 
		"varType", "defineID", "assets", "assetValueWithInnerValue", "assetValue", 
		"assetValuesInner", "flag", "when", "expr", "accessOp", "array", "arrayBody", 
		"itemArray", "parArray"
	};

	@Override
	public String getGrammarFileName() { return "FP4G.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }


	private ILib lib; 

	public void setValue(Object o, String key, Object value)
	{
		if(value instanceof Expresion)
		{
			value = ((Expresion)value).eval(lib);
		}
		if(value instanceof IValue)
		{
			value = ((IValue)value).getValue();
		}
		BeanAccess.setValue(o,key,value);
	}

	public FP4GParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(FP4GParser.EOF, 0); }
		public ProgramBodyContext programBody() {
			return getRuleContext(ProgramBodyContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92); programBody();
			setState(93); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParseLibContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(FP4GParser.EOF, 0); }
		public LibBodyContext libBody() {
			return getRuleContext(LibBodyContext.class,0);
		}
		public ParseLibContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parseLib; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitParseLib(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseLibContext parseLib() throws RecognitionException {
		ParseLibContext _localctx = new ParseLibContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_parseLib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95); libBody();
			setState(96); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UsingsContext extends ParserRuleContext {
		public UsingContext using(int i) {
			return getRuleContext(UsingContext.class,i);
		}
		public List<UsingContext> using() {
			return getRuleContexts(UsingContext.class);
		}
		public UsingsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_usings; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitUsings(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UsingsContext usings() throws RecognitionException {
		UsingsContext _localctx = new UsingsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_usings);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==USING) {
				{
				{
				setState(98); using();
				}
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LibBodyContext extends ParserRuleContext {
		public SetContext set(int i) {
			return getRuleContext(SetContext.class,i);
		}
		public TerminalNode DOTCOMA(int i) {
			return getToken(FP4GParser.DOTCOMA, i);
		}
		public DefineContext define(int i) {
			return getRuleContext(DefineContext.class,i);
		}
		public List<TerminalNode> DOTCOMA() { return getTokens(FP4GParser.DOTCOMA); }
		public List<DefineContext> define() {
			return getRuleContexts(DefineContext.class);
		}
		public List<SetContext> set() {
			return getRuleContexts(SetContext.class);
		}
		public LibBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_libBody; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitLibBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LibBodyContext libBody() throws RecognitionException {
		LibBodyContext _localctx = new LibBodyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_libBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DEFINE || _la==SET) {
				{
				setState(108);
				switch (_input.LA(1)) {
				case SET:
					{
					setState(104); set(lib);
					setState(105); match(DOTCOMA);
					}
					break;
				case DEFINE:
					{
					setState(107); define();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgramBodyContext extends ParserRuleContext {
		public SetContext set(int i) {
			return getRuleContext(SetContext.class,i);
		}
		public TerminalNode DOTCOMA(int i) {
			return getToken(FP4GParser.DOTCOMA, i);
		}
		public DefineContext define(int i) {
			return getRuleContext(DefineContext.class,i);
		}
		public List<TerminalNode> DOTCOMA() { return getTokens(FP4GParser.DOTCOMA); }
		public List<DefineContext> define() {
			return getRuleContexts(DefineContext.class);
		}
		public GameContext game(int i) {
			return getRuleContext(GameContext.class,i);
		}
		public List<GameContext> game() {
			return getRuleContexts(GameContext.class);
		}
		public List<SetContext> set() {
			return getRuleContexts(SetContext.class);
		}
		public ProgramBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programBody; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitProgramBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramBodyContext programBody() throws RecognitionException {
		ProgramBodyContext _localctx = new ProgramBodyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_programBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DEFINE || _la==SET) {
				{
				setState(118);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(113); set(lib);
					setState(114); match(DOTCOMA);
					}
					break;

				case 2:
					{
					setState(116); game();
					}
					break;

				case 3:
					{
					setState(117); define();
					}
					break;
				}
				}
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public Type value;;
		public Token typeName;
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public TerminalNode CIERRA_PAR() { return getToken(FP4GParser.CIERRA_PAR, 0); }
		public TerminalNode ABRE_PAR() { return getToken(FP4GParser.ABRE_PAR, 0); }
		public TerminalNode TYPE() { return getToken(FP4GParser.TYPE, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123); match(TYPE);
			setState(124); match(ABRE_PAR);
			setState(125); ((TypeContext)_localctx).typeName = match(ID);
			setState(126); match(CIERRA_PAR);
			 ((TypeContext)_localctx).value =  lib.getType((((TypeContext)_localctx).typeName!=null?((TypeContext)_localctx).typeName.getText():null)); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefineContext extends ParserRuleContext {
		public Token typeName;
		public Token modelName;
		public Token modelClass;
		public Token controllerName;
		public Token controllerClass;
		public Token viewName;
		public Token viewPath;
		public TerminalNode VIEW() { return getToken(FP4GParser.VIEW, 0); }
		public TerminalNode MODEL() { return getToken(FP4GParser.MODEL, 0); }
		public TerminalNode DEFINE() { return getToken(FP4GParser.DEFINE, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(FP4GParser.STRING_LITERAL, 0); }
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public TerminalNode CONTROLLER() { return getToken(FP4GParser.CONTROLLER, 0); }
		public TerminalNode CIERRA_PAR() { return getToken(FP4GParser.CIERRA_PAR, 0); }
		public TerminalNode ABRE_PAR() { return getToken(FP4GParser.ABRE_PAR, 0); }
		public TerminalNode TYPE() { return getToken(FP4GParser.TYPE, 0); }
		public DefineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitDefine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefineContext define() throws RecognitionException {
		DefineContext _localctx = new DefineContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_define);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129); match(DEFINE);
			setState(151);
			switch (_input.LA(1)) {
			case TYPE:
				{
				setState(130); match(TYPE);
				setState(131); ((DefineContext)_localctx).typeName = match(ID);
				 Type t = new Type(); t.setName((((DefineContext)_localctx).typeName!=null?((DefineContext)_localctx).typeName.getText():null)); lib.registerType(t); 
				}
				break;
			case MODEL:
				{
				setState(133); match(MODEL);
				setState(134); ((DefineContext)_localctx).modelName = match(ID);
				setState(135); match(ABRE_PAR);
				setState(136); ((DefineContext)_localctx).modelClass = match(STRING_LITERAL);
				setState(137); match(CIERRA_PAR);
				 Model m = new Model(); m.setName((((DefineContext)_localctx).modelName!=null?((DefineContext)_localctx).modelName.getText():null)); m.setModel((((DefineContext)_localctx).modelClass!=null?((DefineContext)_localctx).modelClass.getText():null)); lib.registerModel(m); 
				}
				break;
			case CONTROLLER:
				{
				setState(139); match(CONTROLLER);
				setState(140); ((DefineContext)_localctx).controllerName = match(ID);
				setState(141); match(ABRE_PAR);
				setState(142); ((DefineContext)_localctx).controllerClass = match(STRING_LITERAL);
				setState(143); match(CIERRA_PAR);
				 Controller c = new Controller(); lib.registerContronller(c); 
				}
				break;
			case VIEW:
				{
				setState(145); match(VIEW);
				setState(146); ((DefineContext)_localctx).viewName = match(ID);
				setState(147); match(ABRE_PAR);
				setState(148); ((DefineContext)_localctx).viewPath = match(STRING_LITERAL);
				setState(149); match(CIERRA_PAR);
				 View v = new View(); lib.registerView(v); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ResolverContext extends ParserRuleContext {
		public Resolver r;;
		public Type t;;
		public Token name;
		public Token string;
		public Token string2;
		public TypeContext type;
		public TerminalNode ABRE_COR() { return getToken(FP4GParser.ABRE_COR, 0); }
		public TerminalNode STRING_LITERAL(int i) {
			return getToken(FP4GParser.STRING_LITERAL, i);
		}
		public TerminalNode DOTCOMA(int i) {
			return getToken(FP4GParser.DOTCOMA, i);
		}
		public List<TerminalNode> DOTCOMA() { return getTokens(FP4GParser.DOTCOMA); }
		public List<TerminalNode> STRING_LITERAL() { return getTokens(FP4GParser.STRING_LITERAL); }
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public TerminalNode COMA(int i) {
			return getToken(FP4GParser.COMA, i);
		}
		public SetContext set(int i) {
			return getRuleContext(SetContext.class,i);
		}
		public TerminalNode CIERRA_COR() { return getToken(FP4GParser.CIERRA_COR, 0); }
		public TerminalNode FOR() { return getToken(FP4GParser.FOR, 0); }
		public List<TerminalNode> COMA() { return getTokens(FP4GParser.COMA); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode RESOLVER() { return getToken(FP4GParser.RESOLVER, 0); }
		public List<SetContext> set() {
			return getRuleContexts(SetContext.class);
		}
		public ResolverContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resolver; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitResolver(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResolverContext resolver() throws RecognitionException {
		ResolverContext _localctx = new ResolverContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_resolver);
		 
			List<String> imports = new LinkedList<String>(); 

		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(153); match(RESOLVER);
			setState(154); ((ResolverContext)_localctx).name = match(ID);
			 ((ResolverContext)_localctx).r =  new Resolver(lib.getType((((ResolverContext)_localctx).name!=null?((ResolverContext)_localctx).name.getText():null))); lib.registerResolver(_localctx.r); 
			setState(156); match(ABRE_COR);
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SET) {
				{
				{
				setState(157); set(_localctx.r);
				setState(158); match(DOTCOMA);
				}
				}
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(170);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(165); ((ResolverContext)_localctx).string = match(STRING_LITERAL);
					setState(166); match(COMA);
					 imports.add((((ResolverContext)_localctx).string!=null?((ResolverContext)_localctx).string.getText():null)); 
					}
					} 
				}
				setState(172);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(175);
			_la = _input.LA(1);
			if (_la==STRING_LITERAL) {
				{
				setState(173); ((ResolverContext)_localctx).string2 = match(STRING_LITERAL);
				 imports.add((((ResolverContext)_localctx).string2!=null?((ResolverContext)_localctx).string2.getText():null)); 
				}
			}

			setState(177); match(DOTCOMA);
			setState(178); match(CIERRA_COR);
			setState(179); match(FOR);
			setState(180); ((ResolverContext)_localctx).type = type();
			((ResolverContext)_localctx).t =  ((ResolverContext)_localctx).type.value; 
			}

				_localctx.r.setSources(imports);
				lib.registerResolver(_localctx.t, _localctx.r);

		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetContext extends ParserRuleContext {
		public Object object;
		public Token key;
		public ExprContext expr;
		public TerminalNode SET() { return getToken(FP4GParser.SET, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public TerminalNode EQUAL() { return getToken(FP4GParser.EQUAL, 0); }
		public SetContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public SetContext(ParserRuleContext parent, int invokingState, Object object) {
			super(parent, invokingState);
			this.object = object;
		}
		@Override public int getRuleIndex() { return RULE_set; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetContext set(Object object) throws RecognitionException {
		SetContext _localctx = new SetContext(_ctx, getState(), object);
		enterRule(_localctx, 16, RULE_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183); match(SET);
			setState(184); ((SetContext)_localctx).key = match(ID);
			setState(185); match(EQUAL);
			setState(186); ((SetContext)_localctx).expr = expr(0);
			 setValue(_localctx.object,(((SetContext)_localctx).key!=null?((SetContext)_localctx).key.getText():null),((SetContext)_localctx).expr.value); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UsingContext extends ParserRuleContext {
		public DefineType type3 = null;
		public Token ID;
		public Token name;
		public TerminalNode ABRE_COR() { return getToken(FP4GParser.ABRE_COR, 0); }
		public TerminalNode DOTCOMA() { return getToken(FP4GParser.DOTCOMA, 0); }
		public List<TerminalNode> ID() { return getTokens(FP4GParser.ID); }
		public TerminalNode MANAGER() { return getToken(FP4GParser.MANAGER, 0); }
		public TerminalNode BEHAVIOR() { return getToken(FP4GParser.BEHAVIOR, 0); }
		public TerminalNode GOAL() { return getToken(FP4GParser.GOAL, 0); }
		public TerminalNode CIERRA_COR() { return getToken(FP4GParser.CIERRA_COR, 0); }
		public TerminalNode STATE() { return getToken(FP4GParser.STATE, 0); }
		public UsingValuesContext usingValues() {
			return getRuleContext(UsingValuesContext.class,0);
		}
		public TerminalNode USING() { return getToken(FP4GParser.USING, 0); }
		public TerminalNode ENTITY() { return getToken(FP4GParser.ENTITY, 0); }
		public TerminalNode MESSAGE() { return getToken(FP4GParser.MESSAGE, 0); }
		public TerminalNode ID(int i) {
			return getToken(FP4GParser.ID, i);
		}
		public UsingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_using; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitUsing(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UsingContext using() throws RecognitionException {
		UsingContext _localctx = new UsingContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_using);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189); match(USING);
			setState(204);
			switch (_input.LA(1)) {
			case MANAGER:
				{
				setState(190); match(MANAGER);
				 ((UsingContext)_localctx).type3 =  DefineTypes.MANAGER; 
				}
				break;
			case STATE:
				{
				setState(192); match(STATE);
				 ((UsingContext)_localctx).type3 =  DefineTypes.STATE;   
				}
				break;
			case BEHAVIOR:
				{
				setState(194); match(BEHAVIOR);
				 ((UsingContext)_localctx).type3 =  DefineTypes.BEHAVIOR;
				}
				break;
			case ENTITY:
				{
				setState(196); match(ENTITY);
				 ((UsingContext)_localctx).type3 =  DefineTypes.ENTITY;  
				}
				break;
			case GOAL:
				{
				setState(198); match(GOAL);
				 ((UsingContext)_localctx).type3 =  DefineTypes.GOAL;    
				}
				break;
			case MESSAGE:
				{
				setState(200); match(MESSAGE);
				 ((UsingContext)_localctx).type3 =  DefineTypes.MESSAGE; 
				}
				break;
			case ID:
				{
				setState(202); ((UsingContext)_localctx).ID = match(ID);
				 ((UsingContext)_localctx).type3 =  DefineTypes.getDefineTypeByName((((UsingContext)_localctx).ID!=null?((UsingContext)_localctx).ID.getText():null));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(206); ((UsingContext)_localctx).name = match(ID);
			setState(212);
			switch (_input.LA(1)) {
			case DOTCOMA:
				{
				setState(207); match(DOTCOMA);
				}
				break;
			case ABRE_COR:
				{
				setState(208); match(ABRE_COR);
				setState(209); usingValues();
				setState(210); match(CIERRA_COR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UsingValuesContext extends ParserRuleContext {
		public List<UsingValueContext> usingValue() {
			return getRuleContexts(UsingValueContext.class);
		}
		public UsingValueContext usingValue(int i) {
			return getRuleContext(UsingValueContext.class,i);
		}
		public UsingValuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_usingValues; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitUsingValues(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UsingValuesContext usingValues() throws RecognitionException {
		UsingValuesContext _localctx = new UsingValuesContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_usingValues);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SET || _la==ADD) {
				{
				{
				setState(214); usingValue();
				}
				}
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UsingValueContext extends ParserRuleContext {
		public AddContext add() {
			return getRuleContext(AddContext.class,0);
		}
		public TerminalNode DOTCOMA() { return getToken(FP4GParser.DOTCOMA, 0); }
		public SetContext set() {
			return getRuleContext(SetContext.class,0);
		}
		public UsingValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_usingValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitUsingValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UsingValueContext usingValue() throws RecognitionException {
		UsingValueContext _localctx = new UsingValueContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_usingValue);
		try {
			setState(226);
			switch (_input.LA(1)) {
			case ADD:
				enterOuterAlt(_localctx, 1);
				{
				setState(220); add();
				setState(221); match(DOTCOMA);
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 2);
				{
				setState(223); set(null);
				setState(224); match(DOTCOMA);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GameContext extends ParserRuleContext {
		public String name;
		public Token ID;
		public TerminalNode ABRE_COR() { return getToken(FP4GParser.ABRE_COR, 0); }
		public TerminalNode GAME() { return getToken(FP4GParser.GAME, 0); }
		public TerminalNode DEFINE() { return getToken(FP4GParser.DEFINE, 0); }
		public TerminalNode CIERRA_COR() { return getToken(FP4GParser.CIERRA_COR, 0); }
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public GameValuesContext gameValues() {
			return getRuleContext(GameValuesContext.class,0);
		}
		public GameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_game; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitGame(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GameContext game() throws RecognitionException {
		GameContext _localctx = new GameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_game);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228); match(DEFINE);
			setState(229); match(GAME);
			setState(230); ((GameContext)_localctx).ID = match(ID);
			 ((GameContext)_localctx).name =  (((GameContext)_localctx).ID!=null?((GameContext)_localctx).ID.getText():null); 
			setState(232); match(ABRE_COR);
			setState(233); gameValues();
			setState(234); match(CIERRA_COR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GameValuesContext extends ParserRuleContext {
		public GameValueContext gameValue(int i) {
			return getRuleContext(GameValueContext.class,i);
		}
		public List<GameValueContext> gameValue() {
			return getRuleContexts(GameValueContext.class);
		}
		public GameValuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gameValues; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitGameValues(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GameValuesContext gameValues() throws RecognitionException {
		GameValuesContext _localctx = new GameValuesContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_gameValues);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SET) | (1L << ADD) | (1L << ON) | (1L << FLAG) | (1L << WHEN))) != 0)) {
				{
				{
				setState(236); gameValue();
				}
				}
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GameValueContext extends ParserRuleContext {
		public OnContext on() {
			return getRuleContext(OnContext.class,0);
		}
		public FlagContext flag() {
			return getRuleContext(FlagContext.class,0);
		}
		public AddContext add() {
			return getRuleContext(AddContext.class,0);
		}
		public TerminalNode DOTCOMA() { return getToken(FP4GParser.DOTCOMA, 0); }
		public WhenContext when() {
			return getRuleContext(WhenContext.class,0);
		}
		public SetContext set() {
			return getRuleContext(SetContext.class,0);
		}
		public GameValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gameValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitGameValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GameValueContext gameValue() throws RecognitionException {
		GameValueContext _localctx = new GameValueContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_gameValue);
		try {
			setState(255);
			switch (_input.LA(1)) {
			case ADD:
				enterOuterAlt(_localctx, 1);
				{
				setState(242); add();
				setState(243); match(DOTCOMA);
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 2);
				{
				setState(245); set(null);
				setState(246); match(DOTCOMA);
				}
				break;
			case WHEN:
				enterOuterAlt(_localctx, 3);
				{
				setState(248); when();
				setState(249); match(DOTCOMA);
				}
				break;
			case ON:
				enterOuterAlt(_localctx, 4);
				{
				setState(251); on();
				}
				break;
			case FLAG:
				enterOuterAlt(_localctx, 5);
				{
				setState(252); flag();
				setState(253); match(DOTCOMA);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddContext extends ParserRuleContext {
		public AddMethodContext addMethod() {
			return getRuleContext(AddMethodContext.class,0);
		}
		public AddDefineContext addDefine() {
			return getRuleContext(AddDefineContext.class,0);
		}
		public TerminalNode ADD() { return getToken(FP4GParser.ADD, 0); }
		public AddContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitAdd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddContext add() throws RecognitionException {
		AddContext _localctx = new AddContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_add);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257); match(ADD);
			setState(260);
			switch (_input.LA(1)) {
			case MANAGER:
			case STATE:
			case BEHAVIOR:
			case ENTITY:
			case GOAL:
				{
				setState(258); addDefine();
				}
				break;
			case ID:
				{
				setState(259); addMethod();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddDefineContext extends ParserRuleContext {
		public DefineType type3 = null;
		public String addName = null;
		public Token ID;
		public ArrayContext exprParams;
		public TerminalNode GOAL() { return getToken(FP4GParser.GOAL, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public TerminalNode STATE() { return getToken(FP4GParser.STATE, 0); }
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public TerminalNode CIERRA_PAR() { return getToken(FP4GParser.CIERRA_PAR, 0); }
		public TerminalNode BEHAVIOR() { return getToken(FP4GParser.BEHAVIOR, 0); }
		public TerminalNode MANAGER() { return getToken(FP4GParser.MANAGER, 0); }
		public TerminalNode ENTITY() { return getToken(FP4GParser.ENTITY, 0); }
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public TerminalNode ABRE_PAR() { return getToken(FP4GParser.ABRE_PAR, 0); }
		public AddDefineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addDefine; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitAddDefine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddDefineContext addDefine() throws RecognitionException {
		AddDefineContext _localctx = new AddDefineContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_addDefine);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			switch (_input.LA(1)) {
			case MANAGER:
				{
				setState(262); match(MANAGER);
				 ((AddDefineContext)_localctx).type3 =  DefineTypes.MANAGER;  
				}
				break;
			case STATE:
				{
				setState(264); match(STATE);
				 ((AddDefineContext)_localctx).type3 =  DefineTypes.STATE;    
				}
				break;
			case BEHAVIOR:
				{
				setState(266); match(BEHAVIOR);
				 ((AddDefineContext)_localctx).type3 =  DefineTypes.BEHAVIOR; 
				}
				break;
			case ENTITY:
				{
				setState(268); match(ENTITY);
				 ((AddDefineContext)_localctx).type3 =  DefineTypes.ENTITY;  
				}
				break;
			case GOAL:
				{
				setState(270); match(GOAL);
				 ((AddDefineContext)_localctx).type3 =  DefineTypes.GOAL;  
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(274); ((AddDefineContext)_localctx).ID = match(ID);
			 ((AddDefineContext)_localctx).addName =  (((AddDefineContext)_localctx).ID!=null?((AddDefineContext)_localctx).ID.getText():null); 
			setState(281);
			_la = _input.LA(1);
			if (_la==ABRE_PAR) {
				{
				setState(276); match(ABRE_PAR);
				setState(278);
				_la = _input.LA(1);
				if (((((_la - 11)) & ~0x3f) == 0 && ((1L << (_la - 11)) & ((1L << (ON - 11)) | (1L << (TO - 11)) | (1L << (EMPTY - 11)) | (1L << (ABRE_PAR - 11)) | (1L << (ABRE_LLAV - 11)) | (1L << (MINUS - 11)) | (1L << (NOT - 11)) | (1L << (DIRECTCODE - 11)) | (1L << (INT_LITERAL - 11)) | (1L << (DECIMAL_LITERAL - 11)) | (1L << (STRING_LITERAL - 11)) | (1L << (BOOL_LITERAL - 11)) | (1L << (ID - 11)))) != 0)) {
					{
					setState(277); exprList();
					}
				}

				setState(280); match(CIERRA_PAR);
				}
			}

			setState(284);
			_la = _input.LA(1);
			if (_la==EMPTY || _la==ABRE_LLAV) {
				{
				setState(283); ((AddDefineContext)_localctx).exprParams = array();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddMethodContext extends ParserRuleContext {
		public String addName = null;
		public Token ID;
		public ArrayContext exprParams;
		public NameListContext nameList() {
			return getRuleContext(NameListContext.class,0);
		}
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public TerminalNode CIERRA_PAR() { return getToken(FP4GParser.CIERRA_PAR, 0); }
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public TerminalNode ABRE_PAR() { return getToken(FP4GParser.ABRE_PAR, 0); }
		public AddMethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addMethod; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitAddMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddMethodContext addMethod() throws RecognitionException {
		AddMethodContext _localctx = new AddMethodContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_addMethod);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286); ((AddMethodContext)_localctx).ID = match(ID);
			 ((AddMethodContext)_localctx).addName =  (((AddMethodContext)_localctx).ID!=null?((AddMethodContext)_localctx).ID.getText():null); 
			setState(288); match(ABRE_PAR);
			setState(290);
			_la = _input.LA(1);
			if (((((_la - 55)) & ~0x3f) == 0 && ((1L << (_la - 55)) & ((1L << (NUMBER_TYPE - 55)) | (1L << (STRING_TYPE - 55)) | (1L << (BOOL_TYPE - 55)) | (1L << (INTEGER_TYPE - 55)) | (1L << (DOUBLE_TYPE - 55)) | (1L << (FLOAT_TYPE - 55)) | (1L << (ID - 55)))) != 0)) {
				{
				setState(289); nameList();
				}
			}

			setState(292); match(CIERRA_PAR);
			setState(294);
			_la = _input.LA(1);
			if (_la==EMPTY || _la==ABRE_LLAV) {
				{
				setState(293); ((AddMethodContext)_localctx).exprParams = array();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Define2Context extends ParserRuleContext {
		public DefineType type3 = null;
		public String defName = null;
		public Token ID;
		public TerminalNode DEFINE() { return getToken(FP4GParser.DEFINE, 0); }
		public TerminalNode ABRE_COR() { return getToken(FP4GParser.ABRE_COR, 0); }
		public NameListContext nameList() {
			return getRuleContext(NameListContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(FP4GParser.ID); }
		public TerminalNode CIERRA_PAR() { return getToken(FP4GParser.CIERRA_PAR, 0); }
		public TerminalNode MANAGER() { return getToken(FP4GParser.MANAGER, 0); }
		public TerminalNode BEHAVIOR() { return getToken(FP4GParser.BEHAVIOR, 0); }
		public TerminalNode ABRE_PAR() { return getToken(FP4GParser.ABRE_PAR, 0); }
		public TerminalNode GOAL() { return getToken(FP4GParser.GOAL, 0); }
		public TerminalNode CIERRA_COR() { return getToken(FP4GParser.CIERRA_COR, 0); }
		public TerminalNode STATE() { return getToken(FP4GParser.STATE, 0); }
		public TerminalNode ENTITY() { return getToken(FP4GParser.ENTITY, 0); }
		public TerminalNode ASSET() { return getToken(FP4GParser.ASSET, 0); }
		public DefineValuesContext defineValues() {
			return getRuleContext(DefineValuesContext.class,0);
		}
		public TerminalNode MESSAGE() { return getToken(FP4GParser.MESSAGE, 0); }
		public TerminalNode ID(int i) {
			return getToken(FP4GParser.ID, i);
		}
		public Define2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define2; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitDefine2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Define2Context define2() throws RecognitionException {
		Define2Context _localctx = new Define2Context(_ctx, getState());
		enterRule(_localctx, 36, RULE_define2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296); match(DEFINE);
			setState(313);
			switch (_input.LA(1)) {
			case MANAGER:
				{
				setState(297); match(MANAGER);
				 ((Define2Context)_localctx).type3 =  DefineTypes.MANAGER; 
				}
				break;
			case STATE:
				{
				setState(299); match(STATE);
				 ((Define2Context)_localctx).type3 =  DefineTypes.STATE;   
				}
				break;
			case BEHAVIOR:
				{
				setState(301); match(BEHAVIOR);
				 ((Define2Context)_localctx).type3 =  DefineTypes.BEHAVIOR;
				}
				break;
			case ENTITY:
				{
				setState(303); match(ENTITY);
				 ((Define2Context)_localctx).type3 =  DefineTypes.ENTITY;  
				}
				break;
			case GOAL:
				{
				setState(305); match(GOAL);
				 ((Define2Context)_localctx).type3 =  DefineTypes.GOAL;    
				}
				break;
			case MESSAGE:
				{
				setState(307); match(MESSAGE);
				 ((Define2Context)_localctx).type3 =  DefineTypes.MESSAGE; 
				}
				break;
			case ASSET:
				{
				setState(309); match(ASSET);
				 ((Define2Context)_localctx).type3 =  DefineTypes.ASSET;   
				}
				break;
			case ID:
				{
				setState(311); ((Define2Context)_localctx).ID = match(ID);
				 ((Define2Context)_localctx).type3 =  DefineTypes.getDefineTypeByName((((Define2Context)_localctx).ID!=null?((Define2Context)_localctx).ID.getText():null));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(315); ((Define2Context)_localctx).ID = match(ID);
			 ((Define2Context)_localctx).defName =  (((Define2Context)_localctx).ID!=null?((Define2Context)_localctx).ID.getText():null); 
			setState(321);
			_la = _input.LA(1);
			if (_la==ABRE_PAR) {
				{
				setState(317); match(ABRE_PAR);
				setState(318); nameList();
				setState(319); match(CIERRA_PAR);
				}
			}

			setState(323); match(ABRE_COR);
			setState(324); defineValues();
			setState(325); match(CIERRA_COR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OnContext extends ParserRuleContext {
		public String messageName;
		public Message message;
		public OrFilters orFilters;
		public Token ID;
		public OnFiltersContext filters;
		public TerminalNode DOUBLEDOT() { return getToken(FP4GParser.DOUBLEDOT, 0); }
		public TerminalNode ABRE_COR() { return getToken(FP4GParser.ABRE_COR, 0); }
		public TerminalNode ON() { return getToken(FP4GParser.ON, 0); }
		public TerminalNode CIERRA_COR() { return getToken(FP4GParser.CIERRA_COR, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public OnFiltersContext onFilters() {
			return getRuleContext(OnFiltersContext.class,0);
		}
		public OnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_on; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitOn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OnContext on() throws RecognitionException {
		OnContext _localctx = new OnContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_on);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327); match(ON);
			setState(328); ((OnContext)_localctx).ID = match(ID);
			((OnContext)_localctx).messageName =  (((OnContext)_localctx).ID!=null?((OnContext)_localctx).ID.getText():null); 
			setState(332);
			_la = _input.LA(1);
			if (_la==DOUBLEDOT) {
				{
				setState(330); match(DOUBLEDOT);
				setState(331); ((OnContext)_localctx).filters = onFilters();
				}
			}

			setState(334); match(ABRE_COR);
			setState(335); statements();
			setState(336); match(CIERRA_COR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementsContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public TerminalNode DOTCOMA(int i) {
			return getToken(FP4GParser.DOTCOMA, i);
		}
		public List<TerminalNode> DOTCOMA() { return getTokens(FP4GParser.DOTCOMA); }
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(338); statement();
				setState(339); match(DOTCOMA);
				}
				}
				setState(345);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_statement);
		try {
			setState(348);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(346); functionCall();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(347); assign();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallContext extends ParserRuleContext {
		public Token name;
		public FunctionExprListContext functionExprList() {
			return getRuleContext(FunctionExprListContext.class,0);
		}
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350); ((FunctionCallContext)_localctx).name = match(ID);
			setState(352);
			_la = _input.LA(1);
			if (((((_la - 11)) & ~0x3f) == 0 && ((1L << (_la - 11)) & ((1L << (ON - 11)) | (1L << (TO - 11)) | (1L << (EMPTY - 11)) | (1L << (ABRE_PAR - 11)) | (1L << (ABRE_LLAV - 11)) | (1L << (MINUS - 11)) | (1L << (NOT - 11)) | (1L << (DIRECTCODE - 11)) | (1L << (INT_LITERAL - 11)) | (1L << (DECIMAL_LITERAL - 11)) | (1L << (STRING_LITERAL - 11)) | (1L << (BOOL_LITERAL - 11)) | (1L << (ID - 11)))) != 0)) {
				{
				setState(351); functionExprList();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionExprListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FunctionExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionExprList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitFunctionExprList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionExprListContext functionExprList() throws RecognitionException {
		FunctionExprListContext _localctx = new FunctionExprListContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_functionExprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(354); expr(0);
				}
				}
				setState(357); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 11)) & ~0x3f) == 0 && ((1L << (_la - 11)) & ((1L << (ON - 11)) | (1L << (TO - 11)) | (1L << (EMPTY - 11)) | (1L << (ABRE_PAR - 11)) | (1L << (ABRE_LLAV - 11)) | (1L << (MINUS - 11)) | (1L << (NOT - 11)) | (1L << (DIRECTCODE - 11)) | (1L << (INT_LITERAL - 11)) | (1L << (DECIMAL_LITERAL - 11)) | (1L << (STRING_LITERAL - 11)) | (1L << (BOOL_LITERAL - 11)) | (1L << (ID - 11)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignContext extends ParserRuleContext {
		public Token varName;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public TerminalNode EQUAL() { return getToken(FP4GParser.EQUAL, 0); }
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(359); ((AssignContext)_localctx).varName = match(ID);
			setState(360); match(EQUAL);
			setState(361); expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OnFiltersContext extends ParserRuleContext {
		public OrFilters orFilters;
		public Message message;
		public List<FilterContext> filter() {
			return getRuleContexts(FilterContext.class);
		}
		public FilterContext filter(int i) {
			return getRuleContext(FilterContext.class,i);
		}
		public OnFiltersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_onFilters; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitOnFilters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OnFiltersContext onFilters() throws RecognitionException {
		OnFiltersContext _localctx = new OnFiltersContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_onFilters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363); filter();
			setState(367);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(364); filter();
				}
				}
				setState(369);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FilterContext extends ParserRuleContext {
		public String filterName;;
		public Message message;
		public Token ID;
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public TerminalNode CIERRA_PAR() { return getToken(FP4GParser.CIERRA_PAR, 0); }
		public TerminalNode ABRE_PAR() { return getToken(FP4GParser.ABRE_PAR, 0); }
		public FilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FilterContext filter() throws RecognitionException {
		FilterContext _localctx = new FilterContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_filter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370); ((FilterContext)_localctx).ID = match(ID);
			((FilterContext)_localctx).filterName =  (((FilterContext)_localctx).ID!=null?((FilterContext)_localctx).ID.getText():null);
			setState(377);
			_la = _input.LA(1);
			if (_la==ABRE_PAR) {
				{
				setState(372); match(ABRE_PAR);
				setState(374);
				_la = _input.LA(1);
				if (((((_la - 11)) & ~0x3f) == 0 && ((1L << (_la - 11)) & ((1L << (ON - 11)) | (1L << (TO - 11)) | (1L << (EMPTY - 11)) | (1L << (ABRE_PAR - 11)) | (1L << (ABRE_LLAV - 11)) | (1L << (MINUS - 11)) | (1L << (NOT - 11)) | (1L << (DIRECTCODE - 11)) | (1L << (INT_LITERAL - 11)) | (1L << (DECIMAL_LITERAL - 11)) | (1L << (STRING_LITERAL - 11)) | (1L << (BOOL_LITERAL - 11)) | (1L << (ID - 11)))) != 0)) {
					{
					setState(373); exprList();
					}
				}

				setState(376); match(CIERRA_PAR);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefineValuesContext extends ParserRuleContext {
		public DefineValueContext defineValue(int i) {
			return getRuleContext(DefineValueContext.class,i);
		}
		public List<DefineValueContext> defineValue() {
			return getRuleContexts(DefineValueContext.class);
		}
		public DefineValuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defineValues; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitDefineValues(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefineValuesContext defineValues() throws RecognitionException {
		DefineValuesContext _localctx = new DefineValuesContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_defineValues);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SET) | (1L << ADD) | (1L << ON) | (1L << ASSETS) | (1L << FLAG) | (1L << WHEN))) != 0)) {
				{
				{
				setState(379); defineValue();
				}
				}
				setState(384);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefineValueContext extends ParserRuleContext {
		public OnContext on() {
			return getRuleContext(OnContext.class,0);
		}
		public FlagContext flag() {
			return getRuleContext(FlagContext.class,0);
		}
		public AddContext add() {
			return getRuleContext(AddContext.class,0);
		}
		public TerminalNode DOTCOMA() { return getToken(FP4GParser.DOTCOMA, 0); }
		public AssetsContext assets() {
			return getRuleContext(AssetsContext.class,0);
		}
		public WhenContext when() {
			return getRuleContext(WhenContext.class,0);
		}
		public SetContext set() {
			return getRuleContext(SetContext.class,0);
		}
		public DefineValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defineValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitDefineValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefineValueContext defineValue() throws RecognitionException {
		DefineValueContext _localctx = new DefineValueContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_defineValue);
		try {
			setState(399);
			switch (_input.LA(1)) {
			case ASSETS:
				enterOuterAlt(_localctx, 1);
				{
				setState(385); assets();
				}
				break;
			case ADD:
				enterOuterAlt(_localctx, 2);
				{
				setState(386); add();
				setState(387); match(DOTCOMA);
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 3);
				{
				setState(389); set(null);
				setState(390); match(DOTCOMA);
				}
				break;
			case FLAG:
				enterOuterAlt(_localctx, 4);
				{
				setState(392); flag();
				setState(393); match(DOTCOMA);
				}
				break;
			case WHEN:
				enterOuterAlt(_localctx, 5);
				{
				setState(395); when();
				setState(396); match(DOTCOMA);
				}
				break;
			case ON:
				enterOuterAlt(_localctx, 6);
				{
				setState(398); on();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(FP4GParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(FP4GParser.COMA, i);
		}
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitExprList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(401); expr(0);
			setState(406);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(402); match(COMA);
				setState(403); expr(0);
				}
				}
				setState(408);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NameListContext extends ParserRuleContext {
		public DeclareVarContext declareVar(int i) {
			return getRuleContext(DeclareVarContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(FP4GParser.COMA); }
		public List<DeclareVarContext> declareVar() {
			return getRuleContexts(DeclareVarContext.class);
		}
		public TerminalNode COMA(int i) {
			return getToken(FP4GParser.COMA, i);
		}
		public NameListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nameList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitNameList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameListContext nameList() throws RecognitionException {
		NameListContext _localctx = new NameListContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_nameList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(409); declareVar();
			setState(414);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(410); match(COMA);
				setState(411); declareVar();
				}
				}
				setState(416);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclareVarContext extends ParserRuleContext {
		public Token varName;
		public ExprContext initValue;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public TerminalNode EQUAL() { return getToken(FP4GParser.EQUAL, 0); }
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public DeclareVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declareVar; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitDeclareVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclareVarContext declareVar() throws RecognitionException {
		DeclareVarContext _localctx = new DeclareVarContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_declareVar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(417); varType();
			setState(418); ((DeclareVarContext)_localctx).varName = match(ID);
			setState(421);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(419); match(EQUAL);
				setState(420); ((DeclareVarContext)_localctx).initValue = expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarTypeContext extends ParserRuleContext {
		public VarType type3 = null;
		public DefineIDContext id;
		public TerminalNode DOUBLE_TYPE() { return getToken(FP4GParser.DOUBLE_TYPE, 0); }
		public TerminalNode INTEGER_TYPE() { return getToken(FP4GParser.INTEGER_TYPE, 0); }
		public TerminalNode NUMBER_TYPE() { return getToken(FP4GParser.NUMBER_TYPE, 0); }
		public TerminalNode FLOAT_TYPE() { return getToken(FP4GParser.FLOAT_TYPE, 0); }
		public TerminalNode STRING_TYPE() { return getToken(FP4GParser.STRING_TYPE, 0); }
		public DefineIDContext defineID() {
			return getRuleContext(DefineIDContext.class,0);
		}
		public TerminalNode BOOL_TYPE() { return getToken(FP4GParser.BOOL_TYPE, 0); }
		public VarTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitVarType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarTypeContext varType() throws RecognitionException {
		VarTypeContext _localctx = new VarTypeContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_varType);
		try {
			setState(438);
			switch (_input.LA(1)) {
			case NUMBER_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(423); match(NUMBER_TYPE);
				((VarTypeContext)_localctx).type3 =  BasicType.Number;
				}
				break;
			case BOOL_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(425); match(BOOL_TYPE);
				((VarTypeContext)_localctx).type3 =  BasicType.Bool;
				}
				break;
			case STRING_TYPE:
				enterOuterAlt(_localctx, 3);
				{
				setState(427); match(STRING_TYPE);
				((VarTypeContext)_localctx).type3 =  BasicType.String;
				}
				break;
			case INTEGER_TYPE:
				enterOuterAlt(_localctx, 4);
				{
				setState(429); match(INTEGER_TYPE);
				((VarTypeContext)_localctx).type3 =  BasicType.Integer;
				}
				break;
			case DOUBLE_TYPE:
				enterOuterAlt(_localctx, 5);
				{
				setState(431); match(DOUBLE_TYPE);
				((VarTypeContext)_localctx).type3 =  BasicType.Double;
				}
				break;
			case FLOAT_TYPE:
				enterOuterAlt(_localctx, 6);
				{
				setState(433); match(FLOAT_TYPE);
				((VarTypeContext)_localctx).type3 =  BasicType.Float;
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 7);
				{
				setState(435); ((VarTypeContext)_localctx).id = defineID();
				((VarTypeContext)_localctx).type3 =  new CustomType((((VarTypeContext)_localctx).id.type3 != null)?DefineTypes.getDefineTypeByName(((VarTypeContext)_localctx).id.type3):DefineTypes.STRUCT, ((VarTypeContext)_localctx).id.name);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefineIDContext extends ParserRuleContext {
		public String type3;
		public String name;
		public Token defineType;
		public Token defineName;
		public TerminalNode DOUBLEDOT() { return getToken(FP4GParser.DOUBLEDOT, 0); }
		public List<TerminalNode> ID() { return getTokens(FP4GParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FP4GParser.ID, i);
		}
		public DefineIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defineID; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitDefineID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefineIDContext defineID() throws RecognitionException {
		DefineIDContext _localctx = new DefineIDContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_defineID);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(443);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(440); ((DefineIDContext)_localctx).defineType = match(ID);
				setState(441); match(DOUBLEDOT);
				((DefineIDContext)_localctx).type3 =  (((DefineIDContext)_localctx).defineType!=null?((DefineIDContext)_localctx).defineType.getText():null);
				}
				break;
			}
			setState(445); ((DefineIDContext)_localctx).defineName = match(ID);
			((DefineIDContext)_localctx).name =  (((DefineIDContext)_localctx).defineName!=null?((DefineIDContext)_localctx).defineName.getText():null);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssetsContext extends ParserRuleContext {
		public TerminalNode ABRE_COR() { return getToken(FP4GParser.ABRE_COR, 0); }
		public AssetValueWithInnerValueContext assetValueWithInnerValue(int i) {
			return getRuleContext(AssetValueWithInnerValueContext.class,i);
		}
		public TerminalNode CIERRA_COR() { return getToken(FP4GParser.CIERRA_COR, 0); }
		public List<AssetValueWithInnerValueContext> assetValueWithInnerValue() {
			return getRuleContexts(AssetValueWithInnerValueContext.class);
		}
		public TerminalNode ASSETS() { return getToken(FP4GParser.ASSETS, 0); }
		public List<TerminalNode> COMA() { return getTokens(FP4GParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(FP4GParser.COMA, i);
		}
		public AssetsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assets; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitAssets(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssetsContext assets() throws RecognitionException {
		AssetsContext _localctx = new AssetsContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_assets);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(448); match(ASSETS);
			setState(449); match(ABRE_COR);
			setState(450); assetValueWithInnerValue();
			setState(455);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(451); match(COMA);
					setState(452); assetValueWithInnerValue();
					}
					} 
				}
				setState(457);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			}
			setState(459);
			_la = _input.LA(1);
			if (_la==COMA) {
				{
				setState(458); match(COMA);
				}
			}

			setState(461); match(CIERRA_COR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssetValueWithInnerValueContext extends ParserRuleContext {
		public AssetValueContext value;
		public AssetValuesInnerContext innerAssets;
		public AssetValueContext assetValue() {
			return getRuleContext(AssetValueContext.class,0);
		}
		public AssetValuesInnerContext assetValuesInner() {
			return getRuleContext(AssetValuesInnerContext.class,0);
		}
		public AssetValueWithInnerValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assetValueWithInnerValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitAssetValueWithInnerValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssetValueWithInnerValueContext assetValueWithInnerValue() throws RecognitionException {
		AssetValueWithInnerValueContext _localctx = new AssetValueWithInnerValueContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_assetValueWithInnerValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(463); ((AssetValueWithInnerValueContext)_localctx).value = assetValue();
			setState(465);
			_la = _input.LA(1);
			if (_la==ABRE_COR) {
				{
				setState(464); ((AssetValueWithInnerValueContext)_localctx).innerAssets = assetValuesInner();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssetValueContext extends ParserRuleContext {
		public Token assetType;
		public Token assetName;
		public Token assetPath;
		public ArrayContext exprParams;
		public TerminalNode DOUBLEDOT() { return getToken(FP4GParser.DOUBLEDOT, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(FP4GParser.STRING_LITERAL, 0); }
		public List<TerminalNode> ID() { return getTokens(FP4GParser.ID); }
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public TerminalNode ID(int i) {
			return getToken(FP4GParser.ID, i);
		}
		public AssetValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assetValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitAssetValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssetValueContext assetValue() throws RecognitionException {
		AssetValueContext _localctx = new AssetValueContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_assetValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(467); ((AssetValueContext)_localctx).assetType = match(ID);
			setState(469);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(468); ((AssetValueContext)_localctx).assetName = match(ID);
				}
			}

			setState(471); match(DOUBLEDOT);
			setState(472); ((AssetValueContext)_localctx).assetPath = match(STRING_LITERAL);
			setState(474);
			_la = _input.LA(1);
			if (_la==EMPTY || _la==ABRE_LLAV) {
				{
				setState(473); ((AssetValueContext)_localctx).exprParams = array();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssetValuesInnerContext extends ParserRuleContext {
		public AssetValueContext assetValue(int i) {
			return getRuleContext(AssetValueContext.class,i);
		}
		public TerminalNode ABRE_COR() { return getToken(FP4GParser.ABRE_COR, 0); }
		public List<AssetValueContext> assetValue() {
			return getRuleContexts(AssetValueContext.class);
		}
		public TerminalNode CIERRA_COR() { return getToken(FP4GParser.CIERRA_COR, 0); }
		public List<TerminalNode> COMA() { return getTokens(FP4GParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(FP4GParser.COMA, i);
		}
		public AssetValuesInnerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assetValuesInner; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitAssetValuesInner(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssetValuesInnerContext assetValuesInner() throws RecognitionException {
		AssetValuesInnerContext _localctx = new AssetValuesInnerContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_assetValuesInner);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(476); match(ABRE_COR);
			setState(477); assetValue();
			setState(482);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(478); match(COMA);
					setState(479); assetValue();
					}
					} 
				}
				setState(484);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			}
			setState(486);
			_la = _input.LA(1);
			if (_la==COMA) {
				{
				setState(485); match(COMA);
				}
			}

			setState(488); match(CIERRA_COR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FlagContext extends ParserRuleContext {
		public TerminalNode FLAG() { return getToken(FP4GParser.FLAG, 0); }
		public DeclareVarContext declareVar() {
			return getRuleContext(DeclareVarContext.class,0);
		}
		public FlagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flag; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitFlag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FlagContext flag() throws RecognitionException {
		FlagContext _localctx = new FlagContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_flag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(490); match(FLAG);
			setState(491); declareVar();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhenContext extends ParserRuleContext {
		public ExprContext condition;
		public StatementContext stmnt;
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode THEN() { return getToken(FP4GParser.THEN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode WHEN() { return getToken(FP4GParser.WHEN, 0); }
		public WhenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_when; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitWhen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhenContext when() throws RecognitionException {
		WhenContext _localctx = new WhenContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_when);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(493); match(WHEN);
			setState(494); ((WhenContext)_localctx).condition = expr(0);
			setState(495); match(THEN);
			setState(496); ((WhenContext)_localctx).stmnt = statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public int _p;
		public Expresion value;
		public ExprContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExprContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
			this._p = ctx._p;
			this.value = ctx.value;
		}
	}
	public static class MultExprContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MULTIPLY() { return getToken(FP4GParser.MULTIPLY, 0); }
		public MultExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitMultExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LessThanExprContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public TerminalNode LESS_THAN() { return getToken(FP4GParser.LESS_THAN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LessThanExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitLessThanExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualExprContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQUAL() { return getToken(FP4GParser.EQUAL, 0); }
		public EqualExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitEqualExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MessageExprContext extends ExprContext {
		public Token methodName;
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public TerminalNode CIERRA_PAR() { return getToken(FP4GParser.CIERRA_PAR, 0); }
		public TerminalNode ABRE_PAR() { return getToken(FP4GParser.ABRE_PAR, 0); }
		public MessageExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitMessageExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DefineAddExprContext extends ExprContext {
		public Token defineName;
		public Token addName;
		public TerminalNode DOUBLEDOT() { return getToken(FP4GParser.DOUBLEDOT, 0); }
		public TerminalNode ON() { return getToken(FP4GParser.ON, 0); }
		public List<TerminalNode> ID() { return getTokens(FP4GParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FP4GParser.ID, i);
		}
		public DefineAddExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitDefineAddExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DirectCodeContext extends ExprContext {
		public TerminalNode DIRECTCODE() { return getToken(FP4GParser.DIRECTCODE, 0); }
		public DirectCodeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitDirectCode(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ToExprContext extends ExprContext {
		public Token otherTo;
		public Token selfTo;
		public Token gameTo;
		public Token idTo;
		public TerminalNode OTHER() { return getToken(FP4GParser.OTHER, 0); }
		public TerminalNode GAME() { return getToken(FP4GParser.GAME, 0); }
		public TerminalNode SELF() { return getToken(FP4GParser.SELF, 0); }
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public TerminalNode TO() { return getToken(FP4GParser.TO, 0); }
		public ToExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitToExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringLiteralContext extends ExprContext {
		public TerminalNode STRING_LITERAL() { return getToken(FP4GParser.STRING_LITERAL, 0); }
		public StringLiteralContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DecimalLiteralContext extends ExprContext {
		public TerminalNode DECIMAL_LITERAL() { return getToken(FP4GParser.DECIMAL_LITERAL, 0); }
		public DecimalLiteralContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitDecimalLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayExprContext extends ExprContext {
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public ArrayExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitArrayExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParExprContext extends ExprContext {
		public ExprContext op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CIERRA_PAR() { return getToken(FP4GParser.CIERRA_PAR, 0); }
		public TerminalNode ABRE_PAR() { return getToken(FP4GParser.ABRE_PAR, 0); }
		public ParExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitParExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MinusExprContext extends ExprContext {
		public ExprContext op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(FP4GParser.MINUS, 0); }
		public MinusExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitMinusExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MoreThanExprContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MORE_THAN() { return getToken(FP4GParser.MORE_THAN, 0); }
		public MoreThanExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitMoreThanExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolLiteralContext extends ExprContext {
		public TerminalNode BOOL_LITERAL() { return getToken(FP4GParser.BOOL_LITERAL, 0); }
		public BoolLiteralContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitBoolLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubExprContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MINUS() { return getToken(FP4GParser.MINUS, 0); }
		public SubExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitSubExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddExprContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(FP4GParser.PLUS, 0); }
		public AddExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitAddExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntLiteralContext extends ExprContext {
		public TerminalNode INT_LITERAL() { return getToken(FP4GParser.INT_LITERAL, 0); }
		public IntLiteralContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitIntLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AccessOpExprContext extends ExprContext {
		public AccessOpContext accessOp() {
			return getRuleContext(AccessOpContext.class,0);
		}
		public AccessOpExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitAccessOpExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotExprContext extends ExprContext {
		public ExprContext op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NOT() { return getToken(FP4GParser.NOT, 0); }
		public NotExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitNotExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DivExprContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DIVIDE() { return getToken(FP4GParser.DIVIDE, 0); }
		public DivExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitDivExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState, _p);
		ExprContext _prevctx = _localctx;
		int _startState = 80;
		enterRecursionRule(_localctx, RULE_expr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(531);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(499); match(NOT);
				setState(500); ((NotExprContext)_localctx).op = expr(19);
				}
				break;

			case 2:
				{
				_localctx = new MinusExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(501); match(MINUS);
				setState(502); ((MinusExprContext)_localctx).op = expr(13);
				}
				break;

			case 3:
				{
				_localctx = new ArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(503); array();
				}
				break;

			case 4:
				{
				_localctx = new ToExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(504); match(TO);
				setState(509);
				switch (_input.LA(1)) {
				case OTHER:
					{
					setState(505); ((ToExprContext)_localctx).otherTo = match(OTHER);
					}
					break;
				case SELF:
					{
					setState(506); ((ToExprContext)_localctx).selfTo = match(SELF);
					}
					break;
				case GAME:
					{
					setState(507); ((ToExprContext)_localctx).gameTo = match(GAME);
					}
					break;
				case ID:
					{
					setState(508); ((ToExprContext)_localctx).idTo = match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;

			case 5:
				{
				_localctx = new ParExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(511); match(ABRE_PAR);
				setState(512); ((ParExprContext)_localctx).op = expr(0);
				setState(513); match(CIERRA_PAR);
				}
				break;

			case 6:
				{
				_localctx = new IntLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(515); match(INT_LITERAL);
				}
				break;

			case 7:
				{
				_localctx = new DecimalLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(516); match(DECIMAL_LITERAL);
				}
				break;

			case 8:
				{
				_localctx = new StringLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(517); match(STRING_LITERAL);
				}
				break;

			case 9:
				{
				_localctx = new BoolLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(518); match(BOOL_LITERAL);
				}
				break;

			case 10:
				{
				_localctx = new DirectCodeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(519); match(DIRECTCODE);
				}
				break;

			case 11:
				{
				_localctx = new DefineAddExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(520); match(ON);
				setState(521); ((DefineAddExprContext)_localctx).defineName = match(ID);
				setState(522); match(DOUBLEDOT);
				setState(523); ((DefineAddExprContext)_localctx).addName = match(ID);
				}
				break;

			case 12:
				{
				_localctx = new MessageExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(524); ((MessageExprContext)_localctx).methodName = match(ID);
				{
				setState(525); match(ABRE_PAR);
				setState(527);
				_la = _input.LA(1);
				if (((((_la - 11)) & ~0x3f) == 0 && ((1L << (_la - 11)) & ((1L << (ON - 11)) | (1L << (TO - 11)) | (1L << (EMPTY - 11)) | (1L << (ABRE_PAR - 11)) | (1L << (ABRE_LLAV - 11)) | (1L << (MINUS - 11)) | (1L << (NOT - 11)) | (1L << (DIRECTCODE - 11)) | (1L << (INT_LITERAL - 11)) | (1L << (DECIMAL_LITERAL - 11)) | (1L << (STRING_LITERAL - 11)) | (1L << (BOOL_LITERAL - 11)) | (1L << (ID - 11)))) != 0)) {
					{
					setState(526); exprList();
					}
				}

				setState(529); match(CIERRA_PAR);
				}
				}
				break;

			case 13:
				{
				_localctx = new AccessOpExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(530); accessOp();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(556);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(554);
					switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
					case 1:
						{
						_localctx = new LessThanExprContext(new ExprContext(_parentctx, _parentState, _p));
						((LessThanExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(533);
						if (!(17 >= _localctx._p)) throw new FailedPredicateException(this, "17 >= $_p");
						setState(534); match(LESS_THAN);
						setState(535); ((LessThanExprContext)_localctx).right = expr(18);
						}
						break;

					case 2:
						{
						_localctx = new MoreThanExprContext(new ExprContext(_parentctx, _parentState, _p));
						((MoreThanExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(536);
						if (!(16 >= _localctx._p)) throw new FailedPredicateException(this, "16 >= $_p");
						setState(537); match(MORE_THAN);
						setState(538); ((MoreThanExprContext)_localctx).right = expr(17);
						}
						break;

					case 3:
						{
						_localctx = new EqualExprContext(new ExprContext(_parentctx, _parentState, _p));
						((EqualExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(539);
						if (!(15 >= _localctx._p)) throw new FailedPredicateException(this, "15 >= $_p");
						setState(540); match(EQUAL);
						setState(541); ((EqualExprContext)_localctx).right = expr(16);
						}
						break;

					case 4:
						{
						_localctx = new MultExprContext(new ExprContext(_parentctx, _parentState, _p));
						((MultExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(542);
						if (!(12 >= _localctx._p)) throw new FailedPredicateException(this, "12 >= $_p");
						setState(543); match(MULTIPLY);
						setState(544); ((MultExprContext)_localctx).right = expr(13);
						}
						break;

					case 5:
						{
						_localctx = new DivExprContext(new ExprContext(_parentctx, _parentState, _p));
						((DivExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(545);
						if (!(11 >= _localctx._p)) throw new FailedPredicateException(this, "11 >= $_p");
						setState(546); match(DIVIDE);
						setState(547); ((DivExprContext)_localctx).right = expr(12);
						}
						break;

					case 6:
						{
						_localctx = new AddExprContext(new ExprContext(_parentctx, _parentState, _p));
						((AddExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(548);
						if (!(10 >= _localctx._p)) throw new FailedPredicateException(this, "10 >= $_p");
						setState(549); match(PLUS);
						setState(550); ((AddExprContext)_localctx).right = expr(11);
						}
						break;

					case 7:
						{
						_localctx = new SubExprContext(new ExprContext(_parentctx, _parentState, _p));
						((SubExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(551);
						if (!(9 >= _localctx._p)) throw new FailedPredicateException(this, "9 >= $_p");
						setState(552); match(MINUS);
						setState(553); ((SubExprContext)_localctx).right = expr(10);
						}
						break;
					}
					} 
				}
				setState(558);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AccessOpContext extends ParserRuleContext {
		public LinkedList<String> list = new LinkedList<String>();;
		public Token varName;
		public Token childVarName;
		public List<TerminalNode> DOT() { return getTokens(FP4GParser.DOT); }
		public List<TerminalNode> ID() { return getTokens(FP4GParser.ID); }
		public TerminalNode DOT(int i) {
			return getToken(FP4GParser.DOT, i);
		}
		public TerminalNode ID(int i) {
			return getToken(FP4GParser.ID, i);
		}
		public AccessOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessOp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitAccessOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccessOpContext accessOp() throws RecognitionException {
		AccessOpContext _localctx = new AccessOpContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_accessOp);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(559); ((AccessOpContext)_localctx).varName = match(ID);
			setState(565);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(560); match(DOT);
					setState(561); ((AccessOpContext)_localctx).childVarName = match(ID);
					_localctx.list.add((((AccessOpContext)_localctx).childVarName!=null?((AccessOpContext)_localctx).childVarName.getText():null));
					}
					} 
				}
				setState(567);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayContext extends ParserRuleContext {
		public ArrayBodyContext arrayBody() {
			return getRuleContext(ArrayBodyContext.class,0);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_array);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(568); arrayBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayBodyContext extends ParserRuleContext {
		public String bean;
		public ArrayBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayBody; }
	 
		public ArrayBodyContext() { }
		public void copyFrom(ArrayBodyContext ctx) {
			super.copyFrom(ctx);
			this.bean = ctx.bean;
		}
	}
	public static class ListArrayContext extends ArrayBodyContext {
		public Token ID;
		public TerminalNode AS() { return getToken(FP4GParser.AS, 0); }
		public List<ItemArrayContext> itemArray() {
			return getRuleContexts(ItemArrayContext.class);
		}
		public TerminalNode ABRE_LLAV() { return getToken(FP4GParser.ABRE_LLAV, 0); }
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public List<TerminalNode> COMA() { return getTokens(FP4GParser.COMA); }
		public ItemArrayContext itemArray(int i) {
			return getRuleContext(ItemArrayContext.class,i);
		}
		public TerminalNode COMA(int i) {
			return getToken(FP4GParser.COMA, i);
		}
		public TerminalNode CIERRA_LLAV() { return getToken(FP4GParser.CIERRA_LLAV, 0); }
		public ListArrayContext(ArrayBodyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitListArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EmptyArrayContext extends ArrayBodyContext {
		public Token ID;
		public TerminalNode AS() { return getToken(FP4GParser.AS, 0); }
		public TerminalNode EMPTY() { return getToken(FP4GParser.EMPTY, 0); }
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public EmptyArrayContext(ArrayBodyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitEmptyArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssocArrayContext extends ArrayBodyContext {
		public Token ID;
		public TerminalNode AS() { return getToken(FP4GParser.AS, 0); }
		public List<ParArrayContext> parArray() {
			return getRuleContexts(ParArrayContext.class);
		}
		public ParArrayContext parArray(int i) {
			return getRuleContext(ParArrayContext.class,i);
		}
		public TerminalNode ABRE_LLAV() { return getToken(FP4GParser.ABRE_LLAV, 0); }
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public List<TerminalNode> COMA() { return getTokens(FP4GParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(FP4GParser.COMA, i);
		}
		public TerminalNode CIERRA_LLAV() { return getToken(FP4GParser.CIERRA_LLAV, 0); }
		public AssocArrayContext(ArrayBodyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitAssocArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayBodyContext arrayBody() throws RecognitionException {
		ArrayBodyContext _localctx = new ArrayBodyContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_arrayBody);
		int _la;
		try {
			int _alt;
			setState(610);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				_localctx = new AssocArrayContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(570); match(ABRE_LLAV);
				{
				setState(571); parArray();
				setState(576);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(572); match(COMA);
						setState(573); parArray();
						}
						} 
					}
					setState(578);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
				}
				setState(580);
				_la = _input.LA(1);
				if (_la==COMA) {
					{
					setState(579); match(COMA);
					}
				}

				}
				setState(582); match(CIERRA_LLAV);
				setState(586);
				switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
				case 1:
					{
					setState(583); match(AS);
					setState(584); ((AssocArrayContext)_localctx).ID = match(ID);
					((AssocArrayContext)_localctx).bean =  (((AssocArrayContext)_localctx).ID!=null?((AssocArrayContext)_localctx).ID.getText():null);
					}
					break;
				}
				}
				break;

			case 2:
				_localctx = new ListArrayContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(588); match(ABRE_LLAV);
				{
				setState(589); itemArray();
				setState(594);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(590); match(COMA);
						setState(591); itemArray();
						}
						} 
					}
					setState(596);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
				}
				setState(598);
				_la = _input.LA(1);
				if (_la==COMA) {
					{
					setState(597); match(COMA);
					}
				}

				}
				setState(600); match(CIERRA_LLAV);
				setState(604);
				switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
				case 1:
					{
					setState(601); match(AS);
					setState(602); ((ListArrayContext)_localctx).ID = match(ID);
					((ListArrayContext)_localctx).bean =  (((ListArrayContext)_localctx).ID!=null?((ListArrayContext)_localctx).ID.getText():null);
					}
					break;
				}
				}
				break;

			case 3:
				_localctx = new EmptyArrayContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(606); match(EMPTY);
				setState(607); match(AS);
				setState(608); ((EmptyArrayContext)_localctx).ID = match(ID);
				((EmptyArrayContext)_localctx).bean =  (((EmptyArrayContext)_localctx).ID!=null?((EmptyArrayContext)_localctx).ID.getText():null);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ItemArrayContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ItemArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_itemArray; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitItemArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ItemArrayContext itemArray() throws RecognitionException {
		ItemArrayContext _localctx = new ItemArrayContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_itemArray);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(612); expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParArrayContext extends ParserRuleContext {
		public String key;
		public Token ID;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public TerminalNode EQUAL() { return getToken(FP4GParser.EQUAL, 0); }
		public ParArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parArray; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitParArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParArrayContext parArray() throws RecognitionException {
		ParArrayContext _localctx = new ParArrayContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_parArray);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(614); ((ParArrayContext)_localctx).ID = match(ID);
			 ((ParArrayContext)_localctx).key =  (((ParArrayContext)_localctx).ID!=null?((ParArrayContext)_localctx).ID.getText():null); 
			setState(616); match(EQUAL);
			setState(617); expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 40: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 17 >= _localctx._p;

		case 1: return 16 >= _localctx._p;

		case 2: return 15 >= _localctx._p;

		case 3: return 12 >= _localctx._p;

		case 4: return 11 >= _localctx._p;

		case 5: return 10 >= _localctx._p;

		case 6: return 9 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3G\u026e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\2\3\3\3\3\3\3\3\4\7\4f\n\4\f\4\16\4i"+
		"\13\4\3\5\3\5\3\5\3\5\7\5o\n\5\f\5\16\5r\13\5\3\6\3\6\3\6\3\6\3\6\7\6"+
		"y\n\6\f\6\16\6|\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u009a"+
		"\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00a3\n\t\f\t\16\t\u00a6\13\t\3\t"+
		"\3\t\3\t\7\t\u00ab\n\t\f\t\16\t\u00ae\13\t\3\t\3\t\5\t\u00b2\n\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00cf\n\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\5\13\u00d7\n\13\3\f\7\f\u00da\n\f\f\f\16\f\u00dd"+
		"\13\f\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00e5\n\r\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\17\7\17\u00f0\n\17\f\17\16\17\u00f3\13\17\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0102\n\20"+
		"\3\21\3\21\3\21\5\21\u0107\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\5\22\u0113\n\22\3\22\3\22\3\22\3\22\5\22\u0119\n\22\3\22\5"+
		"\22\u011c\n\22\3\22\5\22\u011f\n\22\3\23\3\23\3\23\3\23\5\23\u0125\n\23"+
		"\3\23\3\23\5\23\u0129\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u013c\n\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\5\24\u0144\n\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\3\25\5\25\u014f\n\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\7\26\u0158\n"+
		"\26\f\26\16\26\u015b\13\26\3\27\3\27\5\27\u015f\n\27\3\30\3\30\5\30\u0163"+
		"\n\30\3\31\6\31\u0166\n\31\r\31\16\31\u0167\3\32\3\32\3\32\3\32\3\33\3"+
		"\33\7\33\u0170\n\33\f\33\16\33\u0173\13\33\3\34\3\34\3\34\3\34\5\34\u0179"+
		"\n\34\3\34\5\34\u017c\n\34\3\35\7\35\u017f\n\35\f\35\16\35\u0182\13\35"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\5\36\u0192\n\36\3\37\3\37\3\37\7\37\u0197\n\37\f\37\16\37\u019a\13\37"+
		"\3 \3 \3 \7 \u019f\n \f \16 \u01a2\13 \3!\3!\3!\3!\5!\u01a8\n!\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u01b9\n\"\3#"+
		"\3#\3#\5#\u01be\n#\3#\3#\3#\3$\3$\3$\3$\3$\7$\u01c8\n$\f$\16$\u01cb\13"+
		"$\3$\5$\u01ce\n$\3$\3$\3%\3%\5%\u01d4\n%\3&\3&\5&\u01d8\n&\3&\3&\3&\5"+
		"&\u01dd\n&\3\'\3\'\3\'\3\'\7\'\u01e3\n\'\f\'\16\'\u01e6\13\'\3\'\5\'\u01e9"+
		"\n\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*"+
		"\5*\u0200\n*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\5*\u0212"+
		"\n*\3*\3*\5*\u0216\n*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*"+
		"\3*\3*\3*\3*\3*\7*\u022d\n*\f*\16*\u0230\13*\3+\3+\3+\3+\7+\u0236\n+\f"+
		"+\16+\u0239\13+\3,\3,\3-\3-\3-\3-\7-\u0241\n-\f-\16-\u0244\13-\3-\5-\u0247"+
		"\n-\3-\3-\3-\3-\5-\u024d\n-\3-\3-\3-\3-\7-\u0253\n-\f-\16-\u0256\13-\3"+
		"-\5-\u0259\n-\3-\3-\3-\3-\5-\u025f\n-\3-\3-\3-\3-\5-\u0265\n-\3.\3.\3"+
		"/\3/\3/\3/\3/\3/\2\60\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,."+
		"\60\62\64\668:<>@BDFHJLNPRTVXZ\\\2\2\u02aa\2^\3\2\2\2\4a\3\2\2\2\6g\3"+
		"\2\2\2\bp\3\2\2\2\nz\3\2\2\2\f}\3\2\2\2\16\u0083\3\2\2\2\20\u009b\3\2"+
		"\2\2\22\u00b9\3\2\2\2\24\u00bf\3\2\2\2\26\u00db\3\2\2\2\30\u00e4\3\2\2"+
		"\2\32\u00e6\3\2\2\2\34\u00f1\3\2\2\2\36\u0101\3\2\2\2 \u0103\3\2\2\2\""+
		"\u0112\3\2\2\2$\u0120\3\2\2\2&\u012a\3\2\2\2(\u0149\3\2\2\2*\u0159\3\2"+
		"\2\2,\u015e\3\2\2\2.\u0160\3\2\2\2\60\u0165\3\2\2\2\62\u0169\3\2\2\2\64"+
		"\u016d\3\2\2\2\66\u0174\3\2\2\28\u0180\3\2\2\2:\u0191\3\2\2\2<\u0193\3"+
		"\2\2\2>\u019b\3\2\2\2@\u01a3\3\2\2\2B\u01b8\3\2\2\2D\u01bd\3\2\2\2F\u01c2"+
		"\3\2\2\2H\u01d1\3\2\2\2J\u01d5\3\2\2\2L\u01de\3\2\2\2N\u01ec\3\2\2\2P"+
		"\u01ef\3\2\2\2R\u0215\3\2\2\2T\u0231\3\2\2\2V\u023a\3\2\2\2X\u0264\3\2"+
		"\2\2Z\u0266\3\2\2\2\\\u0268\3\2\2\2^_\5\n\6\2_`\7\2\2\3`\3\3\2\2\2ab\5"+
		"\b\5\2bc\7\2\2\3c\5\3\2\2\2df\5\24\13\2ed\3\2\2\2fi\3\2\2\2ge\3\2\2\2"+
		"gh\3\2\2\2h\7\3\2\2\2ig\3\2\2\2jk\5\22\n\2kl\7-\2\2lo\3\2\2\2mo\5\16\b"+
		"\2nj\3\2\2\2nm\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2q\t\3\2\2\2rp\3\2"+
		"\2\2st\5\22\n\2tu\7-\2\2uy\3\2\2\2vy\5\32\16\2wy\5\16\b\2xs\3\2\2\2xv"+
		"\3\2\2\2xw\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{\13\3\2\2\2|z\3\2\2\2"+
		"}~\7\5\2\2~\177\7%\2\2\177\u0080\7E\2\2\u0080\u0081\7(\2\2\u0081\u0082"+
		"\b\7\1\2\u0082\r\3\2\2\2\u0083\u0099\7\7\2\2\u0084\u0085\7\5\2\2\u0085"+
		"\u0086\7E\2\2\u0086\u009a\b\b\1\2\u0087\u0088\7\b\2\2\u0088\u0089\7E\2"+
		"\2\u0089\u008a\7%\2\2\u008a\u008b\7B\2\2\u008b\u008c\7(\2\2\u008c\u009a"+
		"\b\b\1\2\u008d\u008e\7\t\2\2\u008e\u008f\7E\2\2\u008f\u0090\7%\2\2\u0090"+
		"\u0091\7B\2\2\u0091\u0092\7(\2\2\u0092\u009a\b\b\1\2\u0093\u0094\7\n\2"+
		"\2\u0094\u0095\7E\2\2\u0095\u0096\7%\2\2\u0096\u0097\7B\2\2\u0097\u0098"+
		"\7(\2\2\u0098\u009a\b\b\1\2\u0099\u0084\3\2\2\2\u0099\u0087\3\2\2\2\u0099"+
		"\u008d\3\2\2\2\u0099\u0093\3\2\2\2\u009a\17\3\2\2\2\u009b\u009c\7\6\2"+
		"\2\u009c\u009d\7E\2\2\u009d\u009e\b\t\1\2\u009e\u00a4\7$\2\2\u009f\u00a0"+
		"\5\22\n\2\u00a0\u00a1\7-\2\2\u00a1\u00a3\3\2\2\2\u00a2\u009f\3\2\2\2\u00a3"+
		"\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00ac\3\2"+
		"\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00a8\7B\2\2\u00a8\u00a9\7*\2\2\u00a9\u00ab"+
		"\b\t\1\2\u00aa\u00a7\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac"+
		"\u00ad\3\2\2\2\u00ad\u00b1\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b0\7B"+
		"\2\2\u00b0\u00b2\b\t\1\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2"+
		"\u00b3\3\2\2\2\u00b3\u00b4\7-\2\2\u00b4\u00b5\7\'\2\2\u00b5\u00b6\7\23"+
		"\2\2\u00b6\u00b7\5\f\7\2\u00b7\u00b8\b\t\1\2\u00b8\21\3\2\2\2\u00b9\u00ba"+
		"\7\13\2\2\u00ba\u00bb\7E\2\2\u00bb\u00bc\7+\2\2\u00bc\u00bd\5R*\2\u00bd"+
		"\u00be\b\n\1\2\u00be\23\3\2\2\2\u00bf\u00ce\7\16\2\2\u00c0\u00c1\7\24"+
		"\2\2\u00c1\u00cf\b\13\1\2\u00c2\u00c3\7\26\2\2\u00c3\u00cf\b\13\1\2\u00c4"+
		"\u00c5\7\30\2\2\u00c5\u00cf\b\13\1\2\u00c6\u00c7\7\31\2\2\u00c7\u00cf"+
		"\b\13\1\2\u00c8\u00c9\7\32\2\2\u00c9\u00cf\b\13\1\2\u00ca\u00cb\7\33\2"+
		"\2\u00cb\u00cf\b\13\1\2\u00cc\u00cd\7E\2\2\u00cd\u00cf\b\13\1\2\u00ce"+
		"\u00c0\3\2\2\2\u00ce\u00c2\3\2\2\2\u00ce\u00c4\3\2\2\2\u00ce\u00c6\3\2"+
		"\2\2\u00ce\u00c8\3\2\2\2\u00ce\u00ca\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf"+
		"\u00d0\3\2\2\2\u00d0\u00d6\7E\2\2\u00d1\u00d7\7-\2\2\u00d2\u00d3\7$\2"+
		"\2\u00d3\u00d4\5\26\f\2\u00d4\u00d5\7\'\2\2\u00d5\u00d7\3\2\2\2\u00d6"+
		"\u00d1\3\2\2\2\u00d6\u00d2\3\2\2\2\u00d7\25\3\2\2\2\u00d8\u00da\5\30\r"+
		"\2\u00d9\u00d8\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc"+
		"\3\2\2\2\u00dc\27\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00df\5 \21\2\u00df"+
		"\u00e0\7-\2\2\u00e0\u00e5\3\2\2\2\u00e1\u00e2\5\22\n\2\u00e2\u00e3\7-"+
		"\2\2\u00e3\u00e5\3\2\2\2\u00e4\u00de\3\2\2\2\u00e4\u00e1\3\2\2\2\u00e5"+
		"\31\3\2\2\2\u00e6\u00e7\7\7\2\2\u00e7\u00e8\7\25\2\2\u00e8\u00e9\7E\2"+
		"\2\u00e9\u00ea\b\16\1\2\u00ea\u00eb\7$\2\2\u00eb\u00ec\5\34\17\2\u00ec"+
		"\u00ed\7\'\2\2\u00ed\33\3\2\2\2\u00ee\u00f0\5\36\20\2\u00ef\u00ee\3\2"+
		"\2\2\u00f0\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2"+
		"\35\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00f5\5 \21\2\u00f5\u00f6\7-\2\2"+
		"\u00f6\u0102\3\2\2\2\u00f7\u00f8\5\22\n\2\u00f8\u00f9\7-\2\2\u00f9\u0102"+
		"\3\2\2\2\u00fa\u00fb\5P)\2\u00fb\u00fc\7-\2\2\u00fc\u0102\3\2\2\2\u00fd"+
		"\u0102\5(\25\2\u00fe\u00ff\5N(\2\u00ff\u0100\7-\2\2\u0100\u0102\3\2\2"+
		"\2\u0101\u00f4\3\2\2\2\u0101\u00f7\3\2\2\2\u0101\u00fa\3\2\2\2\u0101\u00fd"+
		"\3\2\2\2\u0101\u00fe\3\2\2\2\u0102\37\3\2\2\2\u0103\u0106\7\f\2\2\u0104"+
		"\u0107\5\"\22\2\u0105\u0107\5$\23\2\u0106\u0104\3\2\2\2\u0106\u0105\3"+
		"\2\2\2\u0107!\3\2\2\2\u0108\u0109\7\24\2\2\u0109\u0113\b\22\1\2\u010a"+
		"\u010b\7\26\2\2\u010b\u0113\b\22\1\2\u010c\u010d\7\30\2\2\u010d\u0113"+
		"\b\22\1\2\u010e\u010f\7\31\2\2\u010f\u0113\b\22\1\2\u0110\u0111\7\32\2"+
		"\2\u0111\u0113\b\22\1\2\u0112\u0108\3\2\2\2\u0112\u010a\3\2\2\2\u0112"+
		"\u010c\3\2\2\2\u0112\u010e\3\2\2\2\u0112\u0110\3\2\2\2\u0113\u0114\3\2"+
		"\2\2\u0114\u0115\7E\2\2\u0115\u011b\b\22\1\2\u0116\u0118\7%\2\2\u0117"+
		"\u0119\5<\37\2\u0118\u0117\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011a\3\2"+
		"\2\2\u011a\u011c\7(\2\2\u011b\u0116\3\2\2\2\u011b\u011c\3\2\2\2\u011c"+
		"\u011e\3\2\2\2\u011d\u011f\5V,\2\u011e\u011d\3\2\2\2\u011e\u011f\3\2\2"+
		"\2\u011f#\3\2\2\2\u0120\u0121\7E\2\2\u0121\u0122\b\23\1\2\u0122\u0124"+
		"\7%\2\2\u0123\u0125\5> \2\u0124\u0123\3\2\2\2\u0124\u0125\3\2\2\2\u0125"+
		"\u0126\3\2\2\2\u0126\u0128\7(\2\2\u0127\u0129\5V,\2\u0128\u0127\3\2\2"+
		"\2\u0128\u0129\3\2\2\2\u0129%\3\2\2\2\u012a\u013b\7\7\2\2\u012b\u012c"+
		"\7\24\2\2\u012c\u013c\b\24\1\2\u012d\u012e\7\26\2\2\u012e\u013c\b\24\1"+
		"\2\u012f\u0130\7\30\2\2\u0130\u013c\b\24\1\2\u0131\u0132\7\31\2\2\u0132"+
		"\u013c\b\24\1\2\u0133\u0134\7\32\2\2\u0134\u013c\b\24\1\2\u0135\u0136"+
		"\7\33\2\2\u0136\u013c\b\24\1\2\u0137\u0138\7\27\2\2\u0138\u013c\b\24\1"+
		"\2\u0139\u013a\7E\2\2\u013a\u013c\b\24\1\2\u013b\u012b\3\2\2\2\u013b\u012d"+
		"\3\2\2\2\u013b\u012f\3\2\2\2\u013b\u0131\3\2\2\2\u013b\u0133\3\2\2\2\u013b"+
		"\u0135\3\2\2\2\u013b\u0137\3\2\2\2\u013b\u0139\3\2\2\2\u013c\u013d\3\2"+
		"\2\2\u013d\u013e\7E\2\2\u013e\u0143\b\24\1\2\u013f\u0140\7%\2\2\u0140"+
		"\u0141\5> \2\u0141\u0142\7(\2\2\u0142\u0144\3\2\2\2\u0143\u013f\3\2\2"+
		"\2\u0143\u0144\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0146\7$\2\2\u0146\u0147"+
		"\58\35\2\u0147\u0148\7\'\2\2\u0148\'\3\2\2\2\u0149\u014a\7\r\2\2\u014a"+
		"\u014b\7E\2\2\u014b\u014e\b\25\1\2\u014c\u014d\7.\2\2\u014d\u014f\5\64"+
		"\33\2\u014e\u014c\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0150\3\2\2\2\u0150"+
		"\u0151\7$\2\2\u0151\u0152\5*\26\2\u0152\u0153\7\'\2\2\u0153)\3\2\2\2\u0154"+
		"\u0155\5,\27\2\u0155\u0156\7-\2\2\u0156\u0158\3\2\2\2\u0157\u0154\3\2"+
		"\2\2\u0158\u015b\3\2\2\2\u0159\u0157\3\2\2\2\u0159\u015a\3\2\2\2\u015a"+
		"+\3\2\2\2\u015b\u0159\3\2\2\2\u015c\u015f\5.\30\2\u015d\u015f\5\62\32"+
		"\2\u015e\u015c\3\2\2\2\u015e\u015d\3\2\2\2\u015f-\3\2\2\2\u0160\u0162"+
		"\7E\2\2\u0161\u0163\5\60\31\2\u0162\u0161\3\2\2\2\u0162\u0163\3\2\2\2"+
		"\u0163/\3\2\2\2\u0164\u0166\5R*\2\u0165\u0164\3\2\2\2\u0166\u0167\3\2"+
		"\2\2\u0167\u0165\3\2\2\2\u0167\u0168\3\2\2\2\u0168\61\3\2\2\2\u0169\u016a"+
		"\7E\2\2\u016a\u016b\7+\2\2\u016b\u016c\5R*\2\u016c\63\3\2\2\2\u016d\u0171"+
		"\5\66\34\2\u016e\u0170\5\66\34\2\u016f\u016e\3\2\2\2\u0170\u0173\3\2\2"+
		"\2\u0171\u016f\3\2\2\2\u0171\u0172\3\2\2\2\u0172\65\3\2\2\2\u0173\u0171"+
		"\3\2\2\2\u0174\u0175\7E\2\2\u0175\u017b\b\34\1\2\u0176\u0178\7%\2\2\u0177"+
		"\u0179\5<\37\2\u0178\u0177\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017a\3\2"+
		"\2\2\u017a\u017c\7(\2\2\u017b\u0176\3\2\2\2\u017b\u017c\3\2\2\2\u017c"+
		"\67\3\2\2\2\u017d\u017f\5:\36\2\u017e\u017d\3\2\2\2\u017f\u0182\3\2\2"+
		"\2\u0180\u017e\3\2\2\2\u0180\u0181\3\2\2\2\u01819\3\2\2\2\u0182\u0180"+
		"\3\2\2\2\u0183\u0192\5F$\2\u0184\u0185\5 \21\2\u0185\u0186\7-\2\2\u0186"+
		"\u0192\3\2\2\2\u0187\u0188\5\22\n\2\u0188\u0189\7-\2\2\u0189\u0192\3\2"+
		"\2\2\u018a\u018b\5N(\2\u018b\u018c\7-\2\2\u018c\u0192\3\2\2\2\u018d\u018e"+
		"\5P)\2\u018e\u018f\7-\2\2\u018f\u0192\3\2\2\2\u0190\u0192\5(\25\2\u0191"+
		"\u0183\3\2\2\2\u0191\u0184\3\2\2\2\u0191\u0187\3\2\2\2\u0191\u018a\3\2"+
		"\2\2\u0191\u018d\3\2\2\2\u0191\u0190\3\2\2\2\u0192;\3\2\2\2\u0193\u0198"+
		"\5R*\2\u0194\u0195\7*\2\2\u0195\u0197\5R*\2\u0196\u0194\3\2\2\2\u0197"+
		"\u019a\3\2\2\2\u0198\u0196\3\2\2\2\u0198\u0199\3\2\2\2\u0199=\3\2\2\2"+
		"\u019a\u0198\3\2\2\2\u019b\u01a0\5@!\2\u019c\u019d\7*\2\2\u019d\u019f"+
		"\5@!\2\u019e\u019c\3\2\2\2\u019f\u01a2\3\2\2\2\u01a0\u019e\3\2\2\2\u01a0"+
		"\u01a1\3\2\2\2\u01a1?\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a3\u01a4\5B\"\2\u01a4"+
		"\u01a7\7E\2\2\u01a5\u01a6\7+\2\2\u01a6\u01a8\5R*\2\u01a7\u01a5\3\2\2\2"+
		"\u01a7\u01a8\3\2\2\2\u01a8A\3\2\2\2\u01a9\u01aa\79\2\2\u01aa\u01b9\b\""+
		"\1\2\u01ab\u01ac\7;\2\2\u01ac\u01b9\b\"\1\2\u01ad\u01ae\7:\2\2\u01ae\u01b9"+
		"\b\"\1\2\u01af\u01b0\7<\2\2\u01b0\u01b9\b\"\1\2\u01b1\u01b2\7=\2\2\u01b2"+
		"\u01b9\b\"\1\2\u01b3\u01b4\7>\2\2\u01b4\u01b9\b\"\1\2\u01b5\u01b6\5D#"+
		"\2\u01b6\u01b7\b\"\1\2\u01b7\u01b9\3\2\2\2\u01b8\u01a9\3\2\2\2\u01b8\u01ab"+
		"\3\2\2\2\u01b8\u01ad\3\2\2\2\u01b8\u01af\3\2\2\2\u01b8\u01b1\3\2\2\2\u01b8"+
		"\u01b3\3\2\2\2\u01b8\u01b5\3\2\2\2\u01b9C\3\2\2\2\u01ba\u01bb\7E\2\2\u01bb"+
		"\u01bc\7.\2\2\u01bc\u01be\b#\1\2\u01bd\u01ba\3\2\2\2\u01bd\u01be\3\2\2"+
		"\2\u01be\u01bf\3\2\2\2\u01bf\u01c0\7E\2\2\u01c0\u01c1\b#\1\2\u01c1E\3"+
		"\2\2\2\u01c2\u01c3\7\20\2\2\u01c3\u01c4\7$\2\2\u01c4\u01c9\5H%\2\u01c5"+
		"\u01c6\7*\2\2\u01c6\u01c8\5H%\2\u01c7\u01c5\3\2\2\2\u01c8\u01cb\3\2\2"+
		"\2\u01c9\u01c7\3\2\2\2\u01c9\u01ca\3\2\2\2\u01ca\u01cd\3\2\2\2\u01cb\u01c9"+
		"\3\2\2\2\u01cc\u01ce\7*\2\2\u01cd\u01cc\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce"+
		"\u01cf\3\2\2\2\u01cf\u01d0\7\'\2\2\u01d0G\3\2\2\2\u01d1\u01d3\5J&\2\u01d2"+
		"\u01d4\5L\'\2\u01d3\u01d2\3\2\2\2\u01d3\u01d4\3\2\2\2\u01d4I\3\2\2\2\u01d5"+
		"\u01d7\7E\2\2\u01d6\u01d8\7E\2\2\u01d7\u01d6\3\2\2\2\u01d7\u01d8\3\2\2"+
		"\2\u01d8\u01d9\3\2\2\2\u01d9\u01da\7.\2\2\u01da\u01dc\7B\2\2\u01db\u01dd"+
		"\5V,\2\u01dc\u01db\3\2\2\2\u01dc\u01dd\3\2\2\2\u01ddK\3\2\2\2\u01de\u01df"+
		"\7$\2\2\u01df\u01e4\5J&\2\u01e0\u01e1\7*\2\2\u01e1\u01e3\5J&\2\u01e2\u01e0"+
		"\3\2\2\2\u01e3\u01e6\3\2\2\2\u01e4\u01e2\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5"+
		"\u01e8\3\2\2\2\u01e6\u01e4\3\2\2\2\u01e7\u01e9\7*\2\2\u01e8\u01e7\3\2"+
		"\2\2\u01e8\u01e9\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01eb\7\'\2\2\u01eb"+
		"M\3\2\2\2\u01ec\u01ed\7\21\2\2\u01ed\u01ee\5@!\2\u01eeO\3\2\2\2\u01ef"+
		"\u01f0\7\22\2\2\u01f0\u01f1\5R*\2\u01f1\u01f2\7#\2\2\u01f2\u01f3\5,\27"+
		"\2\u01f3Q\3\2\2\2\u01f4\u01f5\b*\1\2\u01f5\u01f6\78\2\2\u01f6\u0216\5"+
		"R*\2\u01f7\u01f8\7\60\2\2\u01f8\u0216\5R*\2\u01f9\u0216\5V,\2\u01fa\u01ff"+
		"\7\35\2\2\u01fb\u0200\7 \2\2\u01fc\u0200\7!\2\2\u01fd\u0200\7\25\2\2\u01fe"+
		"\u0200\7E\2\2\u01ff\u01fb\3\2\2\2\u01ff\u01fc\3\2\2\2\u01ff\u01fd\3\2"+
		"\2\2\u01ff\u01fe\3\2\2\2\u0200\u0216\3\2\2\2\u0201\u0202\7%\2\2\u0202"+
		"\u0203\5R*\2\u0203\u0204\7(\2\2\u0204\u0216\3\2\2\2\u0205\u0216\7@\2\2"+
		"\u0206\u0216\7A\2\2\u0207\u0216\7B\2\2\u0208\u0216\7C\2\2\u0209\u0216"+
		"\7?\2\2\u020a\u020b\7\r\2\2\u020b\u020c\7E\2\2\u020c\u020d\7.\2\2\u020d"+
		"\u0216\7E\2\2\u020e\u020f\7E\2\2\u020f\u0211\7%\2\2\u0210\u0212\5<\37"+
		"\2\u0211\u0210\3\2\2\2\u0211\u0212\3\2\2\2\u0212\u0213\3\2\2\2\u0213\u0216"+
		"\7(\2\2\u0214\u0216\5T+\2\u0215\u01f4\3\2\2\2\u0215\u01f7\3\2\2\2\u0215"+
		"\u01f9\3\2\2\2\u0215\u01fa\3\2\2\2\u0215\u0201\3\2\2\2\u0215\u0205\3\2"+
		"\2\2\u0215\u0206\3\2\2\2\u0215\u0207\3\2\2\2\u0215\u0208\3\2\2\2\u0215"+
		"\u0209\3\2\2\2\u0215\u020a\3\2\2\2\u0215\u020e\3\2\2\2\u0215\u0214\3\2"+
		"\2\2\u0216\u022e\3\2\2\2\u0217\u0218\6*\2\3\u0218\u0219\7\64\2\2\u0219"+
		"\u022d\5R*\2\u021a\u021b\6*\3\3\u021b\u021c\7\63\2\2\u021c\u022d\5R*\2"+
		"\u021d\u021e\6*\4\3\u021e\u021f\7+\2\2\u021f\u022d\5R*\2\u0220\u0221\6"+
		"*\5\3\u0221\u0222\7\61\2\2\u0222\u022d\5R*\2\u0223\u0224\6*\6\3\u0224"+
		"\u0225\7\62\2\2\u0225\u022d\5R*\2\u0226\u0227\6*\7\3\u0227\u0228\7/\2"+
		"\2\u0228\u022d\5R*\2\u0229\u022a\6*\b\3\u022a\u022b\7\60\2\2\u022b\u022d"+
		"\5R*\2\u022c\u0217\3\2\2\2\u022c\u021a\3\2\2\2\u022c\u021d\3\2\2\2\u022c"+
		"\u0220\3\2\2\2\u022c\u0223\3\2\2\2\u022c\u0226\3\2\2\2\u022c\u0229\3\2"+
		"\2\2\u022d\u0230\3\2\2\2\u022e\u022c\3\2\2\2\u022e\u022f\3\2\2\2\u022f"+
		"S\3\2\2\2\u0230\u022e\3\2\2\2\u0231\u0237\7E\2\2\u0232\u0233\7,\2\2\u0233"+
		"\u0234\7E\2\2\u0234\u0236\b+\1\2\u0235\u0232\3\2\2\2\u0236\u0239\3\2\2"+
		"\2\u0237\u0235\3\2\2\2\u0237\u0238\3\2\2\2\u0238U\3\2\2\2\u0239\u0237"+
		"\3\2\2\2\u023a\u023b\5X-\2\u023bW\3\2\2\2\u023c\u023d\7&\2\2\u023d\u0242"+
		"\5\\/\2\u023e\u023f\7*\2\2\u023f\u0241\5\\/\2\u0240\u023e\3\2\2\2\u0241"+
		"\u0244\3\2\2\2\u0242\u0240\3\2\2\2\u0242\u0243\3\2\2\2\u0243\u0246\3\2"+
		"\2\2\u0244\u0242\3\2\2\2\u0245\u0247\7*\2\2\u0246\u0245\3\2\2\2\u0246"+
		"\u0247\3\2\2\2\u0247\u0248\3\2\2\2\u0248\u024c\7)\2\2\u0249\u024a\7\37"+
		"\2\2\u024a\u024b\7E\2\2\u024b\u024d\b-\1\2\u024c\u0249\3\2\2\2\u024c\u024d"+
		"\3\2\2\2\u024d\u0265\3\2\2\2\u024e\u024f\7&\2\2\u024f\u0254\5Z.\2\u0250"+
		"\u0251\7*\2\2\u0251\u0253\5Z.\2\u0252\u0250\3\2\2\2\u0253\u0256\3\2\2"+
		"\2\u0254\u0252\3\2\2\2\u0254\u0255\3\2\2\2\u0255\u0258\3\2\2\2\u0256\u0254"+
		"\3\2\2\2\u0257\u0259\7*\2\2\u0258\u0257\3\2\2\2\u0258\u0259\3\2\2\2\u0259"+
		"\u025a\3\2\2\2\u025a\u025e\7)\2\2\u025b\u025c\7\37\2\2\u025c\u025d\7E"+
		"\2\2\u025d\u025f\b-\1\2\u025e\u025b\3\2\2\2\u025e\u025f\3\2\2\2\u025f"+
		"\u0265\3\2\2\2\u0260\u0261\7\"\2\2\u0261\u0262\7\37\2\2\u0262\u0263\7"+
		"E\2\2\u0263\u0265\b-\1\2\u0264\u023c\3\2\2\2\u0264\u024e\3\2\2\2\u0264"+
		"\u0260\3\2\2\2\u0265Y\3\2\2\2\u0266\u0267\5R*\2\u0267[\3\2\2\2\u0268\u0269"+
		"\7E\2\2\u0269\u026a\b/\1\2\u026a\u026b\7+\2\2\u026b\u026c\5R*\2\u026c"+
		"]\3\2\2\2=gnpxz\u0099\u00a4\u00ac\u00b1\u00ce\u00d6\u00db\u00e4\u00f1"+
		"\u0101\u0106\u0112\u0118\u011b\u011e\u0124\u0128\u013b\u0143\u014e\u0159"+
		"\u015e\u0162\u0167\u0171\u0178\u017b\u0180\u0191\u0198\u01a0\u01a7\u01b8"+
		"\u01bd\u01c9\u01cd\u01d3\u01d7\u01dc\u01e4\u01e8\u01ff\u0211\u0215\u022c"+
		"\u022e\u0237\u0242\u0246\u024c\u0254\u0258\u025e\u0264";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}