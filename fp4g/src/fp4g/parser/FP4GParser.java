// Generated from C:\Users\edgardo.moreno\git\fp4g\fp4g\src/fp4g/parser/FP4G.g4 by ANTLR 4.4

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
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

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
		RULE_program = 0, RULE_parseLib = 1, RULE_libBody = 2, RULE_programBody = 3, 
		RULE_type = 4, RULE_define = 5, RULE_defineValue = 6, RULE_modifiers = 7, 
		RULE_resolver = 8, RULE_set = 9, RULE_instantiator = 10, RULE_on = 11, 
		RULE_statements = 12, RULE_statement = 13, RULE_functionCall = 14, RULE_functionExprList = 15, 
		RULE_assign = 16, RULE_onFilters = 17, RULE_filter = 18, RULE_exprList = 19, 
		RULE_nameList = 20, RULE_declareVar = 21, RULE_varType = 22, RULE_defineID = 23, 
		RULE_assets = 24, RULE_assetValueWithInnerValue = 25, RULE_assetValue = 26, 
		RULE_assetValuesInner = 27, RULE_flag = 28, RULE_when = 29, RULE_expr = 30, 
		RULE_accessOp = 31, RULE_array = 32, RULE_arrayBody = 33, RULE_itemArray = 34, 
		RULE_parArray = 35;
	public static final String[] ruleNames = {
		"program", "parseLib", "libBody", "programBody", "type", "define", "defineValue", 
		"modifiers", "resolver", "set", "instantiator", "on", "statements", "statement", 
		"functionCall", "functionExprList", "assign", "onFilters", "filter", "exprList", 
		"nameList", "declareVar", "varType", "defineID", "assets", "assetValueWithInnerValue", 
		"assetValue", "assetValuesInner", "flag", "when", "expr", "accessOp", 
		"array", "arrayBody", "itemArray", "parArray"
	};

	@Override
	public String getGrammarFileName() { return "FP4G.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

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
		public ProgramBodyContext programBody() {
			return getRuleContext(ProgramBodyContext.class,0);
		}
		public TerminalNode EOF() { return getToken(FP4GParser.EOF, 0); }
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
			setState(72); programBody();
			setState(73); match(EOF);
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
			setState(75); libBody();
			setState(76); match(EOF);
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
		public DefineContext define(int i) {
			return getRuleContext(DefineContext.class,i);
		}
		public TerminalNode DOTCOMA(int i) {
			return getToken(FP4GParser.DOTCOMA, i);
		}
		public List<DefineContext> define() {
			return getRuleContexts(DefineContext.class);
		}
		public SetContext set(int i) {
			return getRuleContext(SetContext.class,i);
		}
		public List<TerminalNode> DOTCOMA() { return getTokens(FP4GParser.DOTCOMA); }
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
		enterRule(_localctx, 4, RULE_libBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DEFINE || _la==SET) {
				{
				setState(82);
				switch (_input.LA(1)) {
				case SET:
					{
					setState(78); set(lib);
					setState(79); match(DOTCOMA);
					}
					break;
				case DEFINE:
					{
					setState(81); define();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(86);
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
		public DefineContext define(int i) {
			return getRuleContext(DefineContext.class,i);
		}
		public TerminalNode DOTCOMA(int i) {
			return getToken(FP4GParser.DOTCOMA, i);
		}
		public List<DefineContext> define() {
			return getRuleContexts(DefineContext.class);
		}
		public SetContext set(int i) {
			return getRuleContext(SetContext.class,i);
		}
		public List<TerminalNode> DOTCOMA() { return getTokens(FP4GParser.DOTCOMA); }
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
		enterRule(_localctx, 6, RULE_programBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DEFINE || _la==SET) {
				{
				setState(91);
				switch (_input.LA(1)) {
				case SET:
					{
					setState(87); set(lib);
					setState(88); match(DOTCOMA);
					}
					break;
				case DEFINE:
					{
					setState(90); define();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(95);
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
		public Type ; value;
		public Token typeName;
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public TerminalNode CIERRA_PAR() { return getToken(FP4GParser.CIERRA_PAR, 0); }
		public TerminalNode TYPE() { return getToken(FP4GParser.TYPE, 0); }
		public TerminalNode ABRE_PAR() { return getToken(FP4GParser.ABRE_PAR, 0); }
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
		enterRule(_localctx, 8, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96); match(TYPE);
			setState(97); match(ABRE_PAR);
			setState(98); ((TypeContext)_localctx).typeName = match(ID);
			setState(99); match(CIERRA_PAR);
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
		public Define value;
		public String defName;
			DefineType ; t;
		public Token name;
		public List<TerminalNode> ID() { return getTokens(FP4GParser.ID); }
		public DefineValueContext defineValue(int i) {
			return getRuleContext(DefineValueContext.class,i);
		}
		public TerminalNode DEFINE() { return getToken(FP4GParser.DEFINE, 0); }
		public TerminalNode CIERRA_COR() { return getToken(FP4GParser.CIERRA_COR, 0); }
		public List<DefineValueContext> defineValue() {
			return getRuleContexts(DefineValueContext.class);
		}
		public TerminalNode ID(int i) {
			return getToken(FP4GParser.ID, i);
		}
		public TerminalNode ABRE_COR() { return getToken(FP4GParser.ABRE_COR, 0); }
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
		enterRule(_localctx, 10, RULE_define);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102); match(DEFINE);
			setState(103); match(ID);
			 ((DefineContext)_localctx).t =  DefineTypes.getDefineTypeByName((((DefineContext)_localctx).ID!=null?((DefineContext)_localctx).ID.getText():null));
			setState(105); ((DefineContext)_localctx).name = match(ID);
			 defName = (((DefineContext)_localctx).name!=null?((DefineContext)_localctx).name.getText():null); 
			setState(107); match(ABRE_COR);
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SET || _la==ID) {
				{
				{
				setState(108); defineValue(value);
				}
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(114); match(CIERRA_COR);
			}

				value = t.createInstance();

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
		public Define d;
		public TerminalNode DOTCOMA() { return getToken(FP4GParser.DOTCOMA, 0); }
		public SetContext set() {
			return getRuleContext(SetContext.class,0);
		}
		public ModifiersContext modifiers() {
			return getRuleContext(ModifiersContext.class,0);
		}
		public DefineValueContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public DefineValueContext(ParserRuleContext parent, int invokingState, Define d) {
			super(parent, invokingState);
			this.d = d;
		}
		@Override public int getRuleIndex() { return RULE_defineValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitDefineValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefineValueContext defineValue(Define d) throws RecognitionException {
		DefineValueContext _localctx = new DefineValueContext(_ctx, getState(), d);
		enterRule(_localctx, 12, RULE_defineValue);
		try {
			setState(122);
			switch (_input.LA(1)) {
			case SET:
				enterOuterAlt(_localctx, 1);
				{
				setState(116); set(d);
				setState(117); match(DOTCOMA);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(119); modifiers(d);
				setState(120); match(DOTCOMA);
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

	public static class ModifiersContext extends ParserRuleContext {
		public Define d;
		public InstantiatorContext instantiator() {
			return getRuleContext(InstantiatorContext.class,0);
		}
		public OnContext on() {
			return getRuleContext(OnContext.class,0);
		}
		public ModifiersContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ModifiersContext(ParserRuleContext parent, int invokingState, Define d) {
			super(parent, invokingState);
			this.d = d;
		}
		@Override public int getRuleIndex() { return RULE_modifiers; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitModifiers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModifiersContext modifiers(Define d) throws RecognitionException {
		ModifiersContext _localctx = new ModifiersContext(_ctx, getState(), d);
		enterRule(_localctx, 14, RULE_modifiers);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124); instantiator(d);
			setState(125); on();
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
		public Resolver r;
		public Type t;
		public Token string;
		public Token string2;
		public TerminalNode DOTCOMA(int i) {
			return getToken(FP4GParser.DOTCOMA, i);
		}
		public SetContext set(int i) {
			return getRuleContext(SetContext.class,i);
		}
		public TerminalNode CIERRA_COR() { return getToken(FP4GParser.CIERRA_COR, 0); }
		public TerminalNode COMA(int i) {
			return getToken(FP4GParser.COMA, i);
		}
		public List<TerminalNode> STRING_LITERAL() { return getTokens(FP4GParser.STRING_LITERAL); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> DOTCOMA() { return getTokens(FP4GParser.DOTCOMA); }
		public TerminalNode RESOLVER() { return getToken(FP4GParser.RESOLVER, 0); }
		public TerminalNode ABRE_COR() { return getToken(FP4GParser.ABRE_COR, 0); }
		public List<SetContext> set() {
			return getRuleContexts(SetContext.class);
		}
		public TerminalNode STRING_LITERAL(int i) {
			return getToken(FP4GParser.STRING_LITERAL, i);
		}
		public List<TerminalNode> COMA() { return getTokens(FP4GParser.COMA); }
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
		enterRule(_localctx, 16, RULE_resolver);
		 
			List<String> imports = new LinkedList<String>(); 

		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(127); match(RESOLVER);
			setState(128); type();
			 ((ResolverContext)_localctx).t =  ((ResolverContext)_localctx).type.value; 
			setState(130); match(ABRE_COR);
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SET) {
				{
				{
				setState(131); set(_localctx.r);
				setState(132); match(DOTCOMA);
				}
				}
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(144);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(139); ((ResolverContext)_localctx).string = match(STRING_LITERAL);
					setState(140); match(COMA);
					 imports.add((((ResolverContext)_localctx).string!=null?((ResolverContext)_localctx).string.getText():null)); 
					}
					} 
				}
				setState(146);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(149);
			_la = _input.LA(1);
			if (_la==STRING_LITERAL) {
				{
				setState(147); ((ResolverContext)_localctx).string2 = match(STRING_LITERAL);
				 imports.add((((ResolverContext)_localctx).string2!=null?((ResolverContext)_localctx).string2.getText():null)); 
				}
			}

			setState(151); match(DOTCOMA);
			setState(152); match(CIERRA_COR);
			}

				((ResolverContext)_localctx).r =  new Resolver(_localctx.t);
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
		public TerminalNode EQUAL() { return getToken(FP4GParser.EQUAL, 0); }
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SET() { return getToken(FP4GParser.SET, 0); }
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
		enterRule(_localctx, 18, RULE_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154); match(SET);
			setState(155); ((SetContext)_localctx).key = match(ID);
			setState(156); match(EQUAL);
			setState(157); expr(0);
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

	public static class InstantiatorContext extends ParserRuleContext {
		public Define d;
		public Token id;
		public Token name;
		public ArrayContext exprParams;
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(FP4GParser.ID); }
		public TerminalNode CIERRA_PAR() { return getToken(FP4GParser.CIERRA_PAR, 0); }
		public TerminalNode ABRE_PAR() { return getToken(FP4GParser.ABRE_PAR, 0); }
		public TerminalNode ID(int i) {
			return getToken(FP4GParser.ID, i);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public InstantiatorContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public InstantiatorContext(ParserRuleContext parent, int invokingState, Define d) {
			super(parent, invokingState);
			this.d = d;
		}
		@Override public int getRuleIndex() { return RULE_instantiator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitInstantiator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstantiatorContext instantiator(Define d) throws RecognitionException {
		InstantiatorContext _localctx = new InstantiatorContext(_ctx, getState(), d);
		enterRule(_localctx, 20, RULE_instantiator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160); ((InstantiatorContext)_localctx).id = match(ID);
			setState(161);
			if (!( lib.getType((((InstantiatorContext)_localctx).id!=null?((InstantiatorContext)_localctx).id.getText():null)) != null )) throw new FailedPredicateException(this, " lib.getType($id.text) != null ");
			setState(162); ((InstantiatorContext)_localctx).id = match(ID);
			setState(163); ((InstantiatorContext)_localctx).name = match(ID);
			setState(169);
			_la = _input.LA(1);
			if (_la==ABRE_PAR) {
				{
				setState(164); match(ABRE_PAR);
				setState(166);
				_la = _input.LA(1);
				if (((((_la - 11)) & ~0x3f) == 0 && ((1L << (_la - 11)) & ((1L << (ON - 11)) | (1L << (TO - 11)) | (1L << (EMPTY - 11)) | (1L << (ABRE_PAR - 11)) | (1L << (ABRE_LLAV - 11)) | (1L << (MINUS - 11)) | (1L << (NOT - 11)) | (1L << (DIRECTCODE - 11)) | (1L << (INT_LITERAL - 11)) | (1L << (DECIMAL_LITERAL - 11)) | (1L << (STRING_LITERAL - 11)) | (1L << (BOOL_LITERAL - 11)) | (1L << (ID - 11)))) != 0)) {
					{
					setState(165); exprList();
					}
				}

				setState(168); match(CIERRA_PAR);
				}
			}

			setState(172);
			_la = _input.LA(1);
			if (_la==EMPTY || _la==ABRE_LLAV) {
				{
				setState(171); ((InstantiatorContext)_localctx).exprParams = array();
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

	public static class OnContext extends ParserRuleContext {
		public String messageName;
		public Message message;
		public OrFilters orFilters;
		public OnFiltersContext filters;
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public TerminalNode ON() { return getToken(FP4GParser.ON, 0); }
		public OnFiltersContext onFilters() {
			return getRuleContext(OnFiltersContext.class,0);
		}
		public TerminalNode DOUBLEDOT() { return getToken(FP4GParser.DOUBLEDOT, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode CIERRA_COR() { return getToken(FP4GParser.CIERRA_COR, 0); }
		public TerminalNode ABRE_COR() { return getToken(FP4GParser.ABRE_COR, 0); }
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
		enterRule(_localctx, 22, RULE_on);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174); match(ON);
			setState(175); match(ID);
			((OnContext)_localctx).messageName =  (((OnContext)_localctx).ID!=null?((OnContext)_localctx).ID.getText():null); 
			setState(179);
			_la = _input.LA(1);
			if (_la==DOUBLEDOT) {
				{
				setState(177); match(DOUBLEDOT);
				setState(178); ((OnContext)_localctx).filters = onFilters();
				}
			}

			setState(181); match(ABRE_COR);
			setState(182); statements();
			setState(183); match(CIERRA_COR);
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
		public TerminalNode DOTCOMA(int i) {
			return getToken(FP4GParser.DOTCOMA, i);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> DOTCOMA() { return getTokens(FP4GParser.DOTCOMA); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
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
		enterRule(_localctx, 24, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(185); statement();
				setState(186); match(DOTCOMA);
				}
				}
				setState(192);
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
		enterRule(_localctx, 26, RULE_statement);
		try {
			setState(195);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(193); functionCall();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(194); assign();
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
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public FunctionExprListContext functionExprList() {
			return getRuleContext(FunctionExprListContext.class,0);
		}
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
		enterRule(_localctx, 28, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197); ((FunctionCallContext)_localctx).name = match(ID);
			setState(199);
			_la = _input.LA(1);
			if (((((_la - 11)) & ~0x3f) == 0 && ((1L << (_la - 11)) & ((1L << (ON - 11)) | (1L << (TO - 11)) | (1L << (EMPTY - 11)) | (1L << (ABRE_PAR - 11)) | (1L << (ABRE_LLAV - 11)) | (1L << (MINUS - 11)) | (1L << (NOT - 11)) | (1L << (DIRECTCODE - 11)) | (1L << (INT_LITERAL - 11)) | (1L << (DECIMAL_LITERAL - 11)) | (1L << (STRING_LITERAL - 11)) | (1L << (BOOL_LITERAL - 11)) | (1L << (ID - 11)))) != 0)) {
				{
				setState(198); functionExprList();
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
		enterRule(_localctx, 30, RULE_functionExprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(201); expr(0);
				}
				}
				setState(204); 
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
		public TerminalNode EQUAL() { return getToken(FP4GParser.EQUAL, 0); }
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
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
		enterRule(_localctx, 32, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206); ((AssignContext)_localctx).varName = match(ID);
			setState(207); match(EQUAL);
			setState(208); expr(0);
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
		enterRule(_localctx, 34, RULE_onFilters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210); filter();
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(211); filter();
				}
				}
				setState(216);
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
		public String ; filterName;
		public Message message;
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
		enterRule(_localctx, 36, RULE_filter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217); match(ID);
			((FilterContext)_localctx).filterName =  (((FilterContext)_localctx).ID!=null?((FilterContext)_localctx).ID.getText():null);
			setState(224);
			_la = _input.LA(1);
			if (_la==ABRE_PAR) {
				{
				setState(219); match(ABRE_PAR);
				setState(221);
				_la = _input.LA(1);
				if (((((_la - 11)) & ~0x3f) == 0 && ((1L << (_la - 11)) & ((1L << (ON - 11)) | (1L << (TO - 11)) | (1L << (EMPTY - 11)) | (1L << (ABRE_PAR - 11)) | (1L << (ABRE_LLAV - 11)) | (1L << (MINUS - 11)) | (1L << (NOT - 11)) | (1L << (DIRECTCODE - 11)) | (1L << (INT_LITERAL - 11)) | (1L << (DECIMAL_LITERAL - 11)) | (1L << (STRING_LITERAL - 11)) | (1L << (BOOL_LITERAL - 11)) | (1L << (ID - 11)))) != 0)) {
					{
					setState(220); exprList();
					}
				}

				setState(223); match(CIERRA_PAR);
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

	public static class ExprListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COMA(int i) {
			return getToken(FP4GParser.COMA, i);
		}
		public List<TerminalNode> COMA() { return getTokens(FP4GParser.COMA); }
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
		enterRule(_localctx, 38, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226); expr(0);
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(227); match(COMA);
				setState(228); expr(0);
				}
				}
				setState(233);
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
		public List<DeclareVarContext> declareVar() {
			return getRuleContexts(DeclareVarContext.class);
		}
		public DeclareVarContext declareVar(int i) {
			return getRuleContext(DeclareVarContext.class,i);
		}
		public TerminalNode COMA(int i) {
			return getToken(FP4GParser.COMA, i);
		}
		public List<TerminalNode> COMA() { return getTokens(FP4GParser.COMA); }
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
		enterRule(_localctx, 40, RULE_nameList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234); declareVar();
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(235); match(COMA);
				setState(236); declareVar();
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

	public static class DeclareVarContext extends ParserRuleContext {
		public Token varName;
		public ExprContext initValue;
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public TerminalNode EQUAL() { return getToken(FP4GParser.EQUAL, 0); }
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
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
		enterRule(_localctx, 42, RULE_declareVar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242); varType();
			setState(243); ((DeclareVarContext)_localctx).varName = match(ID);
			setState(246);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(244); match(EQUAL);
				setState(245); ((DeclareVarContext)_localctx).initValue = expr(0);
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
		public VarType type3;
		public DefineIDContext id;
		public TerminalNode FLOAT_TYPE() { return getToken(FP4GParser.FLOAT_TYPE, 0); }
		public TerminalNode NUMBER_TYPE() { return getToken(FP4GParser.NUMBER_TYPE, 0); }
		public TerminalNode DOUBLE_TYPE() { return getToken(FP4GParser.DOUBLE_TYPE, 0); }
		public TerminalNode STRING_TYPE() { return getToken(FP4GParser.STRING_TYPE, 0); }
		public TerminalNode INTEGER_TYPE() { return getToken(FP4GParser.INTEGER_TYPE, 0); }
		public TerminalNode BOOL_TYPE() { return getToken(FP4GParser.BOOL_TYPE, 0); }
		public DefineIDContext defineID() {
			return getRuleContext(DefineIDContext.class,0);
		}
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
		enterRule(_localctx, 44, RULE_varType);
		try {
			setState(263);
			switch (_input.LA(1)) {
			case NUMBER_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(248); match(NUMBER_TYPE);
				((VarTypeContext)_localctx).type3 =  BasicType.Number;
				}
				break;
			case BOOL_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(250); match(BOOL_TYPE);
				((VarTypeContext)_localctx).type3 =  BasicType.Bool;
				}
				break;
			case STRING_TYPE:
				enterOuterAlt(_localctx, 3);
				{
				setState(252); match(STRING_TYPE);
				((VarTypeContext)_localctx).type3 =  BasicType.String;
				}
				break;
			case INTEGER_TYPE:
				enterOuterAlt(_localctx, 4);
				{
				setState(254); match(INTEGER_TYPE);
				((VarTypeContext)_localctx).type3 =  BasicType.Integer;
				}
				break;
			case DOUBLE_TYPE:
				enterOuterAlt(_localctx, 5);
				{
				setState(256); match(DOUBLE_TYPE);
				((VarTypeContext)_localctx).type3 =  BasicType.Double;
				}
				break;
			case FLOAT_TYPE:
				enterOuterAlt(_localctx, 6);
				{
				setState(258); match(FLOAT_TYPE);
				((VarTypeContext)_localctx).type3 =  BasicType.Float;
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 7);
				{
				setState(260); ((VarTypeContext)_localctx).id = defineID();
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
		public List<TerminalNode> ID() { return getTokens(FP4GParser.ID); }
		public TerminalNode DOUBLEDOT() { return getToken(FP4GParser.DOUBLEDOT, 0); }
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
		enterRule(_localctx, 46, RULE_defineID);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(265); ((DefineIDContext)_localctx).defineType = match(ID);
				setState(266); match(DOUBLEDOT);
				((DefineIDContext)_localctx).type3 =  (((DefineIDContext)_localctx).defineType!=null?((DefineIDContext)_localctx).defineType.getText():null);
				}
				break;
			}
			setState(270); ((DefineIDContext)_localctx).defineName = match(ID);
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
		public TerminalNode ASSETS() { return getToken(FP4GParser.ASSETS, 0); }
		public List<AssetValueWithInnerValueContext> assetValueWithInnerValue() {
			return getRuleContexts(AssetValueWithInnerValueContext.class);
		}
		public TerminalNode CIERRA_COR() { return getToken(FP4GParser.CIERRA_COR, 0); }
		public TerminalNode COMA(int i) {
			return getToken(FP4GParser.COMA, i);
		}
		public AssetValueWithInnerValueContext assetValueWithInnerValue(int i) {
			return getRuleContext(AssetValueWithInnerValueContext.class,i);
		}
		public TerminalNode ABRE_COR() { return getToken(FP4GParser.ABRE_COR, 0); }
		public List<TerminalNode> COMA() { return getTokens(FP4GParser.COMA); }
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
		enterRule(_localctx, 48, RULE_assets);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(273); match(ASSETS);
			setState(274); match(ABRE_COR);
			setState(275); assetValueWithInnerValue();
			setState(280);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(276); match(COMA);
					setState(277); assetValueWithInnerValue();
					}
					} 
				}
				setState(282);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			setState(284);
			_la = _input.LA(1);
			if (_la==COMA) {
				{
				setState(283); match(COMA);
				}
			}

			setState(286); match(CIERRA_COR);
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
		public AssetValuesInnerContext assetValuesInner() {
			return getRuleContext(AssetValuesInnerContext.class,0);
		}
		public AssetValueContext assetValue() {
			return getRuleContext(AssetValueContext.class,0);
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
		enterRule(_localctx, 50, RULE_assetValueWithInnerValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288); ((AssetValueWithInnerValueContext)_localctx).value = assetValue();
			setState(290);
			_la = _input.LA(1);
			if (_la==ABRE_COR) {
				{
				setState(289); ((AssetValueWithInnerValueContext)_localctx).innerAssets = assetValuesInner();
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
		public List<TerminalNode> ID() { return getTokens(FP4GParser.ID); }
		public TerminalNode DOUBLEDOT() { return getToken(FP4GParser.DOUBLEDOT, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(FP4GParser.STRING_LITERAL, 0); }
		public TerminalNode ID(int i) {
			return getToken(FP4GParser.ID, i);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
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
		enterRule(_localctx, 52, RULE_assetValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292); ((AssetValueContext)_localctx).assetType = match(ID);
			setState(294);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(293); ((AssetValueContext)_localctx).assetName = match(ID);
				}
			}

			setState(296); match(DOUBLEDOT);
			setState(297); ((AssetValueContext)_localctx).assetPath = match(STRING_LITERAL);
			setState(299);
			_la = _input.LA(1);
			if (_la==EMPTY || _la==ABRE_LLAV) {
				{
				setState(298); ((AssetValueContext)_localctx).exprParams = array();
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
		public TerminalNode CIERRA_COR() { return getToken(FP4GParser.CIERRA_COR, 0); }
		public TerminalNode COMA(int i) {
			return getToken(FP4GParser.COMA, i);
		}
		public TerminalNode ABRE_COR() { return getToken(FP4GParser.ABRE_COR, 0); }
		public List<AssetValueContext> assetValue() {
			return getRuleContexts(AssetValueContext.class);
		}
		public List<TerminalNode> COMA() { return getTokens(FP4GParser.COMA); }
		public AssetValueContext assetValue(int i) {
			return getRuleContext(AssetValueContext.class,i);
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
		enterRule(_localctx, 54, RULE_assetValuesInner);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(301); match(ABRE_COR);
			setState(302); assetValue();
			setState(307);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(303); match(COMA);
					setState(304); assetValue();
					}
					} 
				}
				setState(309);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			}
			setState(311);
			_la = _input.LA(1);
			if (_la==COMA) {
				{
				setState(310); match(COMA);
				}
			}

			setState(313); match(CIERRA_COR);
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
		public DeclareVarContext declareVar() {
			return getRuleContext(DeclareVarContext.class,0);
		}
		public TerminalNode FLAG() { return getToken(FP4GParser.FLAG, 0); }
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
		enterRule(_localctx, 56, RULE_flag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315); match(FLAG);
			setState(316); declareVar();
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode THEN() { return getToken(FP4GParser.THEN, 0); }
		public TerminalNode WHEN() { return getToken(FP4GParser.WHEN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
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
		enterRule(_localctx, 58, RULE_when);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318); match(WHEN);
			setState(319); ((WhenContext)_localctx).condition = expr(0);
			setState(320); match(THEN);
			setState(321); ((WhenContext)_localctx).stmnt = statement();
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
		public Expresion value;
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
			this.value = ctx.value;
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
	public static class DefineAddExprContext extends ExprContext {
		public Token defineName;
		public Token addName;
		public List<TerminalNode> ID() { return getTokens(FP4GParser.ID); }
		public TerminalNode ON() { return getToken(FP4GParser.ON, 0); }
		public TerminalNode DOUBLEDOT() { return getToken(FP4GParser.DOUBLEDOT, 0); }
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
	public static class LessThanExprContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LESS_THAN() { return getToken(FP4GParser.LESS_THAN, 0); }
		public LessThanExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitLessThanExpr(this);
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
	public static class BoolLiteralContext extends ExprContext {
		public TerminalNode BOOL_LITERAL() { return getToken(FP4GParser.BOOL_LITERAL, 0); }
		public BoolLiteralContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitBoolLiteral(this);
			else return visitor.visitChildren(this);
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
	public static class ParExprContext extends ExprContext {
		public ExprContext op;
		public TerminalNode CIERRA_PAR() { return getToken(FP4GParser.CIERRA_PAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ABRE_PAR() { return getToken(FP4GParser.ABRE_PAR, 0); }
		public ParExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitParExpr(this);
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
	public static class NotExprContext extends ExprContext {
		public ExprContext op;
		public TerminalNode NOT() { return getToken(FP4GParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitNotExpr(this);
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
	public static class DirectCodeContext extends ExprContext {
		public TerminalNode DIRECTCODE() { return getToken(FP4GParser.DIRECTCODE, 0); }
		public DirectCodeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitDirectCode(this);
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
	public static class ToExprContext extends ExprContext {
		public Token otherTo;
		public Token selfTo;
		public Token gameTo;
		public Token idTo;
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public TerminalNode SELF() { return getToken(FP4GParser.SELF, 0); }
		public TerminalNode OTHER() { return getToken(FP4GParser.OTHER, 0); }
		public TerminalNode GAME() { return getToken(FP4GParser.GAME, 0); }
		public TerminalNode TO() { return getToken(FP4GParser.TO, 0); }
		public ToExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitToExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualExprContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public TerminalNode EQUAL() { return getToken(FP4GParser.EQUAL, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public EqualExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitEqualExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 60;
		enterRecursionRule(_localctx, 60, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(324); match(NOT);
				setState(325); ((NotExprContext)_localctx).op = expr(19);
				}
				break;
			case 2:
				{
				_localctx = new MinusExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(326); match(MINUS);
				setState(327); ((MinusExprContext)_localctx).op = expr(13);
				}
				break;
			case 3:
				{
				_localctx = new ArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(328); array();
				}
				break;
			case 4:
				{
				_localctx = new ToExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(329); match(TO);
				setState(334);
				switch (_input.LA(1)) {
				case OTHER:
					{
					setState(330); ((ToExprContext)_localctx).otherTo = match(OTHER);
					}
					break;
				case SELF:
					{
					setState(331); ((ToExprContext)_localctx).selfTo = match(SELF);
					}
					break;
				case GAME:
					{
					setState(332); ((ToExprContext)_localctx).gameTo = match(GAME);
					}
					break;
				case ID:
					{
					setState(333); ((ToExprContext)_localctx).idTo = match(ID);
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
				setState(336); match(ABRE_PAR);
				setState(337); ((ParExprContext)_localctx).op = expr(0);
				setState(338); match(CIERRA_PAR);
				}
				break;
			case 6:
				{
				_localctx = new IntLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(340); match(INT_LITERAL);
				}
				break;
			case 7:
				{
				_localctx = new DecimalLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(341); match(DECIMAL_LITERAL);
				}
				break;
			case 8:
				{
				_localctx = new StringLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(342); match(STRING_LITERAL);
				}
				break;
			case 9:
				{
				_localctx = new BoolLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(343); match(BOOL_LITERAL);
				}
				break;
			case 10:
				{
				_localctx = new DirectCodeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(344); match(DIRECTCODE);
				}
				break;
			case 11:
				{
				_localctx = new DefineAddExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(345); match(ON);
				setState(346); ((DefineAddExprContext)_localctx).defineName = match(ID);
				setState(347); match(DOUBLEDOT);
				setState(348); ((DefineAddExprContext)_localctx).addName = match(ID);
				}
				break;
			case 12:
				{
				_localctx = new MessageExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(349); ((MessageExprContext)_localctx).methodName = match(ID);
				{
				setState(350); match(ABRE_PAR);
				setState(352);
				_la = _input.LA(1);
				if (((((_la - 11)) & ~0x3f) == 0 && ((1L << (_la - 11)) & ((1L << (ON - 11)) | (1L << (TO - 11)) | (1L << (EMPTY - 11)) | (1L << (ABRE_PAR - 11)) | (1L << (ABRE_LLAV - 11)) | (1L << (MINUS - 11)) | (1L << (NOT - 11)) | (1L << (DIRECTCODE - 11)) | (1L << (INT_LITERAL - 11)) | (1L << (DECIMAL_LITERAL - 11)) | (1L << (STRING_LITERAL - 11)) | (1L << (BOOL_LITERAL - 11)) | (1L << (ID - 11)))) != 0)) {
					{
					setState(351); exprList();
					}
				}

				setState(354); match(CIERRA_PAR);
				}
				}
				break;
			case 13:
				{
				_localctx = new AccessOpExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(355); accessOp();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(381);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(379);
					switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
					case 1:
						{
						_localctx = new LessThanExprContext(new ExprContext(_parentctx, _parentState));
						((LessThanExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(358);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(359); match(LESS_THAN);
						setState(360); ((LessThanExprContext)_localctx).right = expr(18);
						}
						break;
					case 2:
						{
						_localctx = new MoreThanExprContext(new ExprContext(_parentctx, _parentState));
						((MoreThanExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(361);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(362); match(MORE_THAN);
						setState(363); ((MoreThanExprContext)_localctx).right = expr(17);
						}
						break;
					case 3:
						{
						_localctx = new EqualExprContext(new ExprContext(_parentctx, _parentState));
						((EqualExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(364);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(365); match(EQUAL);
						setState(366); ((EqualExprContext)_localctx).right = expr(16);
						}
						break;
					case 4:
						{
						_localctx = new MultExprContext(new ExprContext(_parentctx, _parentState));
						((MultExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(367);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(368); match(MULTIPLY);
						setState(369); ((MultExprContext)_localctx).right = expr(13);
						}
						break;
					case 5:
						{
						_localctx = new DivExprContext(new ExprContext(_parentctx, _parentState));
						((DivExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(370);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(371); match(DIVIDE);
						setState(372); ((DivExprContext)_localctx).right = expr(12);
						}
						break;
					case 6:
						{
						_localctx = new AddExprContext(new ExprContext(_parentctx, _parentState));
						((AddExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(373);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(374); match(PLUS);
						setState(375); ((AddExprContext)_localctx).right = expr(11);
						}
						break;
					case 7:
						{
						_localctx = new SubExprContext(new ExprContext(_parentctx, _parentState));
						((SubExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(376);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(377); match(MINUS);
						setState(378); ((SubExprContext)_localctx).right = expr(10);
						}
						break;
					}
					} 
				}
				setState(383);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
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
		public LinkedList<String> list;
		public Token varName;
		public Token childVarName;
		public List<TerminalNode> ID() { return getTokens(FP4GParser.ID); }
		public List<TerminalNode> DOT() { return getTokens(FP4GParser.DOT); }
		public TerminalNode ID(int i) {
			return getToken(FP4GParser.ID, i);
		}
		public TerminalNode DOT(int i) {
			return getToken(FP4GParser.DOT, i);
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
		enterRule(_localctx, 62, RULE_accessOp);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(384); ((AccessOpContext)_localctx).varName = match(ID);
			setState(390);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(385); match(DOT);
					setState(386); ((AccessOpContext)_localctx).childVarName = match(ID);
					_localctx.list.add((((AccessOpContext)_localctx).childVarName!=null?((AccessOpContext)_localctx).childVarName.getText():null));
					}
					} 
				}
				setState(392);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
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
		enterRule(_localctx, 64, RULE_array);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(393); arrayBody();
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
	public static class AssocArrayContext extends ArrayBodyContext {
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public TerminalNode CIERRA_LLAV() { return getToken(FP4GParser.CIERRA_LLAV, 0); }
		public TerminalNode COMA(int i) {
			return getToken(FP4GParser.COMA, i);
		}
		public ParArrayContext parArray(int i) {
			return getRuleContext(ParArrayContext.class,i);
		}
		public List<ParArrayContext> parArray() {
			return getRuleContexts(ParArrayContext.class);
		}
		public TerminalNode ABRE_LLAV() { return getToken(FP4GParser.ABRE_LLAV, 0); }
		public TerminalNode AS() { return getToken(FP4GParser.AS, 0); }
		public List<TerminalNode> COMA() { return getTokens(FP4GParser.COMA); }
		public AssocArrayContext(ArrayBodyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitAssocArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListArrayContext extends ArrayBodyContext {
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public TerminalNode CIERRA_LLAV() { return getToken(FP4GParser.CIERRA_LLAV, 0); }
		public ItemArrayContext itemArray(int i) {
			return getRuleContext(ItemArrayContext.class,i);
		}
		public TerminalNode COMA(int i) {
			return getToken(FP4GParser.COMA, i);
		}
		public TerminalNode ABRE_LLAV() { return getToken(FP4GParser.ABRE_LLAV, 0); }
		public TerminalNode AS() { return getToken(FP4GParser.AS, 0); }
		public List<TerminalNode> COMA() { return getTokens(FP4GParser.COMA); }
		public List<ItemArrayContext> itemArray() {
			return getRuleContexts(ItemArrayContext.class);
		}
		public ListArrayContext(ArrayBodyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitListArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EmptyArrayContext extends ArrayBodyContext {
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public TerminalNode EMPTY() { return getToken(FP4GParser.EMPTY, 0); }
		public TerminalNode AS() { return getToken(FP4GParser.AS, 0); }
		public EmptyArrayContext(ArrayBodyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitEmptyArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayBodyContext arrayBody() throws RecognitionException {
		ArrayBodyContext _localctx = new ArrayBodyContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_arrayBody);
		int _la;
		try {
			int _alt;
			setState(435);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				_localctx = new AssocArrayContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(395); match(ABRE_LLAV);
				{
				setState(396); parArray();
				setState(401);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(397); match(COMA);
						setState(398); parArray();
						}
						} 
					}
					setState(403);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
				}
				setState(405);
				_la = _input.LA(1);
				if (_la==COMA) {
					{
					setState(404); match(COMA);
					}
				}

				}
				setState(407); match(CIERRA_LLAV);
				setState(411);
				switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
				case 1:
					{
					setState(408); match(AS);
					setState(409); match(ID);
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
				setState(413); match(ABRE_LLAV);
				{
				setState(414); itemArray();
				setState(419);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(415); match(COMA);
						setState(416); itemArray();
						}
						} 
					}
					setState(421);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
				}
				setState(423);
				_la = _input.LA(1);
				if (_la==COMA) {
					{
					setState(422); match(COMA);
					}
				}

				}
				setState(425); match(CIERRA_LLAV);
				setState(429);
				switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
				case 1:
					{
					setState(426); match(AS);
					setState(427); match(ID);
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
				setState(431); match(EMPTY);
				setState(432); match(AS);
				setState(433); match(ID);
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
		enterRule(_localctx, 68, RULE_itemArray);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(437); expr(0);
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
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public TerminalNode EQUAL() { return getToken(FP4GParser.EQUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
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
		enterRule(_localctx, 70, RULE_parArray);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(439); match(ID);
			 ((ParArrayContext)_localctx).key =  (((ParArrayContext)_localctx).ID!=null?((ParArrayContext)_localctx).ID.getText():null); 
			setState(441); match(EQUAL);
			setState(442); expr(0);
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
		case 10: return instantiator_sempred((InstantiatorContext)_localctx, predIndex);
		case 30: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean instantiator_sempred(InstantiatorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return  lib.getType((((InstantiatorContext)_localctx).id!=null?((InstantiatorContext)_localctx).id.getText():null)) != null ;
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return precpred(_ctx, 17);
		case 2: return precpred(_ctx, 16);
		case 3: return precpred(_ctx, 15);
		case 4: return precpred(_ctx, 12);
		case 5: return precpred(_ctx, 11);
		case 6: return precpred(_ctx, 10);
		case 7: return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3G\u01bf\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\7\4U\n\4\f\4\16\4X\13\4\3\5\3\5\3\5\3\5\7\5^\n\5\f\5\16\5a\13\5\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7p\n\7\f\7\16\7s\13\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\5\b}\n\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\7\n\u0089\n\n\f\n\16\n\u008c\13\n\3\n\3\n\3\n\7\n\u0091\n"+
		"\n\f\n\16\n\u0094\13\n\3\n\3\n\5\n\u0098\n\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00a9\n\f\3\f\5\f\u00ac\n"+
		"\f\3\f\5\f\u00af\n\f\3\r\3\r\3\r\3\r\3\r\5\r\u00b6\n\r\3\r\3\r\3\r\3\r"+
		"\3\16\3\16\3\16\7\16\u00bf\n\16\f\16\16\16\u00c2\13\16\3\17\3\17\5\17"+
		"\u00c6\n\17\3\20\3\20\5\20\u00ca\n\20\3\21\6\21\u00cd\n\21\r\21\16\21"+
		"\u00ce\3\22\3\22\3\22\3\22\3\23\3\23\7\23\u00d7\n\23\f\23\16\23\u00da"+
		"\13\23\3\24\3\24\3\24\3\24\5\24\u00e0\n\24\3\24\5\24\u00e3\n\24\3\25\3"+
		"\25\3\25\7\25\u00e8\n\25\f\25\16\25\u00eb\13\25\3\26\3\26\3\26\7\26\u00f0"+
		"\n\26\f\26\16\26\u00f3\13\26\3\27\3\27\3\27\3\27\5\27\u00f9\n\27\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\5\30\u010a\n\30\3\31\3\31\3\31\5\31\u010f\n\31\3\31\3\31\3\31\3\32\3"+
		"\32\3\32\3\32\3\32\7\32\u0119\n\32\f\32\16\32\u011c\13\32\3\32\5\32\u011f"+
		"\n\32\3\32\3\32\3\33\3\33\5\33\u0125\n\33\3\34\3\34\5\34\u0129\n\34\3"+
		"\34\3\34\3\34\5\34\u012e\n\34\3\35\3\35\3\35\3\35\7\35\u0134\n\35\f\35"+
		"\16\35\u0137\13\35\3\35\5\35\u013a\n\35\3\35\3\35\3\36\3\36\3\36\3\37"+
		"\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u0151\n \3 \3"+
		" \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u0163\n \3 \3 \5 \u0167"+
		"\n \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \7 "+
		"\u017e\n \f \16 \u0181\13 \3!\3!\3!\3!\7!\u0187\n!\f!\16!\u018a\13!\3"+
		"\"\3\"\3#\3#\3#\3#\7#\u0192\n#\f#\16#\u0195\13#\3#\5#\u0198\n#\3#\3#\3"+
		"#\3#\5#\u019e\n#\3#\3#\3#\3#\7#\u01a4\n#\f#\16#\u01a7\13#\3#\5#\u01aa"+
		"\n#\3#\3#\3#\3#\5#\u01b0\n#\3#\3#\3#\3#\5#\u01b6\n#\3$\3$\3%\3%\3%\3%"+
		"\3%\3%\2\3>&\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
		"\668:<>@BDFH\2\2\u01df\2J\3\2\2\2\4M\3\2\2\2\6V\3\2\2\2\b_\3\2\2\2\nb"+
		"\3\2\2\2\fh\3\2\2\2\16|\3\2\2\2\20~\3\2\2\2\22\u0081\3\2\2\2\24\u009c"+
		"\3\2\2\2\26\u00a2\3\2\2\2\30\u00b0\3\2\2\2\32\u00c0\3\2\2\2\34\u00c5\3"+
		"\2\2\2\36\u00c7\3\2\2\2 \u00cc\3\2\2\2\"\u00d0\3\2\2\2$\u00d4\3\2\2\2"+
		"&\u00db\3\2\2\2(\u00e4\3\2\2\2*\u00ec\3\2\2\2,\u00f4\3\2\2\2.\u0109\3"+
		"\2\2\2\60\u010e\3\2\2\2\62\u0113\3\2\2\2\64\u0122\3\2\2\2\66\u0126\3\2"+
		"\2\28\u012f\3\2\2\2:\u013d\3\2\2\2<\u0140\3\2\2\2>\u0166\3\2\2\2@\u0182"+
		"\3\2\2\2B\u018b\3\2\2\2D\u01b5\3\2\2\2F\u01b7\3\2\2\2H\u01b9\3\2\2\2J"+
		"K\5\b\5\2KL\7\2\2\3L\3\3\2\2\2MN\5\6\4\2NO\7\2\2\3O\5\3\2\2\2PQ\5\24\13"+
		"\2QR\7-\2\2RU\3\2\2\2SU\5\f\7\2TP\3\2\2\2TS\3\2\2\2UX\3\2\2\2VT\3\2\2"+
		"\2VW\3\2\2\2W\7\3\2\2\2XV\3\2\2\2YZ\5\24\13\2Z[\7-\2\2[^\3\2\2\2\\^\5"+
		"\f\7\2]Y\3\2\2\2]\\\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`\t\3\2\2\2a"+
		"_\3\2\2\2bc\7\5\2\2cd\7%\2\2de\7E\2\2ef\7(\2\2fg\b\6\1\2g\13\3\2\2\2h"+
		"i\7\7\2\2ij\7E\2\2jk\b\7\1\2kl\7E\2\2lm\b\7\1\2mq\7$\2\2np\5\16\b\2on"+
		"\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2rt\3\2\2\2sq\3\2\2\2tu\7\'\2\2u"+
		"\r\3\2\2\2vw\5\24\13\2wx\7-\2\2x}\3\2\2\2yz\5\20\t\2z{\7-\2\2{}\3\2\2"+
		"\2|v\3\2\2\2|y\3\2\2\2}\17\3\2\2\2~\177\5\26\f\2\177\u0080\5\30\r\2\u0080"+
		"\21\3\2\2\2\u0081\u0082\7\6\2\2\u0082\u0083\5\n\6\2\u0083\u0084\b\n\1"+
		"\2\u0084\u008a\7$\2\2\u0085\u0086\5\24\13\2\u0086\u0087\7-\2\2\u0087\u0089"+
		"\3\2\2\2\u0088\u0085\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008b\u0092\3\2\2\2\u008c\u008a\3\2\2\2\u008d\u008e\7B"+
		"\2\2\u008e\u008f\7*\2\2\u008f\u0091\b\n\1\2\u0090\u008d\3\2\2\2\u0091"+
		"\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0097\3\2"+
		"\2\2\u0094\u0092\3\2\2\2\u0095\u0096\7B\2\2\u0096\u0098\b\n\1\2\u0097"+
		"\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\7-"+
		"\2\2\u009a\u009b\7\'\2\2\u009b\23\3\2\2\2\u009c\u009d\7\13\2\2\u009d\u009e"+
		"\7E\2\2\u009e\u009f\7+\2\2\u009f\u00a0\5> \2\u00a0\u00a1\b\13\1\2\u00a1"+
		"\25\3\2\2\2\u00a2\u00a3\7E\2\2\u00a3\u00a4\6\f\2\3\u00a4\u00a5\7E\2\2"+
		"\u00a5\u00ab\7E\2\2\u00a6\u00a8\7%\2\2\u00a7\u00a9\5(\25\2\u00a8\u00a7"+
		"\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ac\7(\2\2\u00ab"+
		"\u00a6\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ae\3\2\2\2\u00ad\u00af\5B"+
		"\"\2\u00ae\u00ad\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\27\3\2\2\2\u00b0\u00b1"+
		"\7\r\2\2\u00b1\u00b2\7E\2\2\u00b2\u00b5\b\r\1\2\u00b3\u00b4\7.\2\2\u00b4"+
		"\u00b6\5$\23\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\3\2"+
		"\2\2\u00b7\u00b8\7$\2\2\u00b8\u00b9\5\32\16\2\u00b9\u00ba\7\'\2\2\u00ba"+
		"\31\3\2\2\2\u00bb\u00bc\5\34\17\2\u00bc\u00bd\7-\2\2\u00bd\u00bf\3\2\2"+
		"\2\u00be\u00bb\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1"+
		"\3\2\2\2\u00c1\33\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00c6\5\36\20\2\u00c4"+
		"\u00c6\5\"\22\2\u00c5\u00c3\3\2\2\2\u00c5\u00c4\3\2\2\2\u00c6\35\3\2\2"+
		"\2\u00c7\u00c9\7E\2\2\u00c8\u00ca\5 \21\2\u00c9\u00c8\3\2\2\2\u00c9\u00ca"+
		"\3\2\2\2\u00ca\37\3\2\2\2\u00cb\u00cd\5> \2\u00cc\u00cb\3\2\2\2\u00cd"+
		"\u00ce\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf!\3\2\2\2"+
		"\u00d0\u00d1\7E\2\2\u00d1\u00d2\7+\2\2\u00d2\u00d3\5> \2\u00d3#\3\2\2"+
		"\2\u00d4\u00d8\5&\24\2\u00d5\u00d7\5&\24\2\u00d6\u00d5\3\2\2\2\u00d7\u00da"+
		"\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9%\3\2\2\2\u00da"+
		"\u00d8\3\2\2\2\u00db\u00dc\7E\2\2\u00dc\u00e2\b\24\1\2\u00dd\u00df\7%"+
		"\2\2\u00de\u00e0\5(\25\2\u00df\u00de\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0"+
		"\u00e1\3\2\2\2\u00e1\u00e3\7(\2\2\u00e2\u00dd\3\2\2\2\u00e2\u00e3\3\2"+
		"\2\2\u00e3\'\3\2\2\2\u00e4\u00e9\5> \2\u00e5\u00e6\7*\2\2\u00e6\u00e8"+
		"\5> \2\u00e7\u00e5\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9"+
		"\u00ea\3\2\2\2\u00ea)\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00f1\5,\27\2"+
		"\u00ed\u00ee\7*\2\2\u00ee\u00f0\5,\27\2\u00ef\u00ed\3\2\2\2\u00f0\u00f3"+
		"\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2+\3\2\2\2\u00f3"+
		"\u00f1\3\2\2\2\u00f4\u00f5\5.\30\2\u00f5\u00f8\7E\2\2\u00f6\u00f7\7+\2"+
		"\2\u00f7\u00f9\5> \2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9-\3"+
		"\2\2\2\u00fa\u00fb\79\2\2\u00fb\u010a\b\30\1\2\u00fc\u00fd\7;\2\2\u00fd"+
		"\u010a\b\30\1\2\u00fe\u00ff\7:\2\2\u00ff\u010a\b\30\1\2\u0100\u0101\7"+
		"<\2\2\u0101\u010a\b\30\1\2\u0102\u0103\7=\2\2\u0103\u010a\b\30\1\2\u0104"+
		"\u0105\7>\2\2\u0105\u010a\b\30\1\2\u0106\u0107\5\60\31\2\u0107\u0108\b"+
		"\30\1\2\u0108\u010a\3\2\2\2\u0109\u00fa\3\2\2\2\u0109\u00fc\3\2\2\2\u0109"+
		"\u00fe\3\2\2\2\u0109\u0100\3\2\2\2\u0109\u0102\3\2\2\2\u0109\u0104\3\2"+
		"\2\2\u0109\u0106\3\2\2\2\u010a/\3\2\2\2\u010b\u010c\7E\2\2\u010c\u010d"+
		"\7.\2\2\u010d\u010f\b\31\1\2\u010e\u010b\3\2\2\2\u010e\u010f\3\2\2\2\u010f"+
		"\u0110\3\2\2\2\u0110\u0111\7E\2\2\u0111\u0112\b\31\1\2\u0112\61\3\2\2"+
		"\2\u0113\u0114\7\20\2\2\u0114\u0115\7$\2\2\u0115\u011a\5\64\33\2\u0116"+
		"\u0117\7*\2\2\u0117\u0119\5\64\33\2\u0118\u0116\3\2\2\2\u0119\u011c\3"+
		"\2\2\2\u011a\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011e\3\2\2\2\u011c"+
		"\u011a\3\2\2\2\u011d\u011f\7*\2\2\u011e\u011d\3\2\2\2\u011e\u011f\3\2"+
		"\2\2\u011f\u0120\3\2\2\2\u0120\u0121\7\'\2\2\u0121\63\3\2\2\2\u0122\u0124"+
		"\5\66\34\2\u0123\u0125\58\35\2\u0124\u0123\3\2\2\2\u0124\u0125\3\2\2\2"+
		"\u0125\65\3\2\2\2\u0126\u0128\7E\2\2\u0127\u0129\7E\2\2\u0128\u0127\3"+
		"\2\2\2\u0128\u0129\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012b\7.\2\2\u012b"+
		"\u012d\7B\2\2\u012c\u012e\5B\"\2\u012d\u012c\3\2\2\2\u012d\u012e\3\2\2"+
		"\2\u012e\67\3\2\2\2\u012f\u0130\7$\2\2\u0130\u0135\5\66\34\2\u0131\u0132"+
		"\7*\2\2\u0132\u0134\5\66\34\2\u0133\u0131\3\2\2\2\u0134\u0137\3\2\2\2"+
		"\u0135\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0139\3\2\2\2\u0137\u0135"+
		"\3\2\2\2\u0138\u013a\7*\2\2\u0139\u0138\3\2\2\2\u0139\u013a\3\2\2\2\u013a"+
		"\u013b\3\2\2\2\u013b\u013c\7\'\2\2\u013c9\3\2\2\2\u013d\u013e\7\21\2\2"+
		"\u013e\u013f\5,\27\2\u013f;\3\2\2\2\u0140\u0141\7\22\2\2\u0141\u0142\5"+
		"> \2\u0142\u0143\7#\2\2\u0143\u0144\5\34\17\2\u0144=\3\2\2\2\u0145\u0146"+
		"\b \1\2\u0146\u0147\78\2\2\u0147\u0167\5> \25\u0148\u0149\7\60\2\2\u0149"+
		"\u0167\5> \17\u014a\u0167\5B\"\2\u014b\u0150\7\35\2\2\u014c\u0151\7 \2"+
		"\2\u014d\u0151\7!\2\2\u014e\u0151\7\25\2\2\u014f\u0151\7E\2\2\u0150\u014c"+
		"\3\2\2\2\u0150\u014d\3\2\2\2\u0150\u014e\3\2\2\2\u0150\u014f\3\2\2\2\u0151"+
		"\u0167\3\2\2\2\u0152\u0153\7%\2\2\u0153\u0154\5> \2\u0154\u0155\7(\2\2"+
		"\u0155\u0167\3\2\2\2\u0156\u0167\7@\2\2\u0157\u0167\7A\2\2\u0158\u0167"+
		"\7B\2\2\u0159\u0167\7C\2\2\u015a\u0167\7?\2\2\u015b\u015c\7\r\2\2\u015c"+
		"\u015d\7E\2\2\u015d\u015e\7.\2\2\u015e\u0167\7E\2\2\u015f\u0160\7E\2\2"+
		"\u0160\u0162\7%\2\2\u0161\u0163\5(\25\2\u0162\u0161\3\2\2\2\u0162\u0163"+
		"\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0167\7(\2\2\u0165\u0167\5@!\2\u0166"+
		"\u0145\3\2\2\2\u0166\u0148\3\2\2\2\u0166\u014a\3\2\2\2\u0166\u014b\3\2"+
		"\2\2\u0166\u0152\3\2\2\2\u0166\u0156\3\2\2\2\u0166\u0157\3\2\2\2\u0166"+
		"\u0158\3\2\2\2\u0166\u0159\3\2\2\2\u0166\u015a\3\2\2\2\u0166\u015b\3\2"+
		"\2\2\u0166\u015f\3\2\2\2\u0166\u0165\3\2\2\2\u0167\u017f\3\2\2\2\u0168"+
		"\u0169\f\23\2\2\u0169\u016a\7\64\2\2\u016a\u017e\5> \24\u016b\u016c\f"+
		"\22\2\2\u016c\u016d\7\63\2\2\u016d\u017e\5> \23\u016e\u016f\f\21\2\2\u016f"+
		"\u0170\7+\2\2\u0170\u017e\5> \22\u0171\u0172\f\16\2\2\u0172\u0173\7\61"+
		"\2\2\u0173\u017e\5> \17\u0174\u0175\f\r\2\2\u0175\u0176\7\62\2\2\u0176"+
		"\u017e\5> \16\u0177\u0178\f\f\2\2\u0178\u0179\7/\2\2\u0179\u017e\5> \r"+
		"\u017a\u017b\f\13\2\2\u017b\u017c\7\60\2\2\u017c\u017e\5> \f\u017d\u0168"+
		"\3\2\2\2\u017d\u016b\3\2\2\2\u017d\u016e\3\2\2\2\u017d\u0171\3\2\2\2\u017d"+
		"\u0174\3\2\2\2\u017d\u0177\3\2\2\2\u017d\u017a\3\2\2\2\u017e\u0181\3\2"+
		"\2\2\u017f\u017d\3\2\2\2\u017f\u0180\3\2\2\2\u0180?\3\2\2\2\u0181\u017f"+
		"\3\2\2\2\u0182\u0188\7E\2\2\u0183\u0184\7,\2\2\u0184\u0185\7E\2\2\u0185"+
		"\u0187\b!\1\2\u0186\u0183\3\2\2\2\u0187\u018a\3\2\2\2\u0188\u0186\3\2"+
		"\2\2\u0188\u0189\3\2\2\2\u0189A\3\2\2\2\u018a\u0188\3\2\2\2\u018b\u018c"+
		"\5D#\2\u018cC\3\2\2\2\u018d\u018e\7&\2\2\u018e\u0193\5H%\2\u018f\u0190"+
		"\7*\2\2\u0190\u0192\5H%\2\u0191\u018f\3\2\2\2\u0192\u0195\3\2\2\2\u0193"+
		"\u0191\3\2\2\2\u0193\u0194\3\2\2\2\u0194\u0197\3\2\2\2\u0195\u0193\3\2"+
		"\2\2\u0196\u0198\7*\2\2\u0197\u0196\3\2\2\2\u0197\u0198\3\2\2\2\u0198"+
		"\u0199\3\2\2\2\u0199\u019d\7)\2\2\u019a\u019b\7\37\2\2\u019b\u019c\7E"+
		"\2\2\u019c\u019e\b#\1\2\u019d\u019a\3\2\2\2\u019d\u019e\3\2\2\2\u019e"+
		"\u01b6\3\2\2\2\u019f\u01a0\7&\2\2\u01a0\u01a5\5F$\2\u01a1\u01a2\7*\2\2"+
		"\u01a2\u01a4\5F$\2\u01a3\u01a1\3\2\2\2\u01a4\u01a7\3\2\2\2\u01a5\u01a3"+
		"\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a9\3\2\2\2\u01a7\u01a5\3\2\2\2\u01a8"+
		"\u01aa\7*\2\2\u01a9\u01a8\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01ab\3\2"+
		"\2\2\u01ab\u01af\7)\2\2\u01ac\u01ad\7\37\2\2\u01ad\u01ae\7E\2\2\u01ae"+
		"\u01b0\b#\1\2\u01af\u01ac\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b6\3\2"+
		"\2\2\u01b1\u01b2\7\"\2\2\u01b2\u01b3\7\37\2\2\u01b3\u01b4\7E\2\2\u01b4"+
		"\u01b6\b#\1\2\u01b5\u018d\3\2\2\2\u01b5\u019f\3\2\2\2\u01b5\u01b1\3\2"+
		"\2\2\u01b6E\3\2\2\2\u01b7\u01b8\5> \2\u01b8G\3\2\2\2\u01b9\u01ba\7E\2"+
		"\2\u01ba\u01bb\b%\1\2\u01bb\u01bc\7+\2\2\u01bc\u01bd\5> \2\u01bdI\3\2"+
		"\2\2/TV]_q|\u008a\u0092\u0097\u00a8\u00ab\u00ae\u00b5\u00c0\u00c5\u00c9"+
		"\u00ce\u00d8\u00df\u00e2\u00e9\u00f1\u00f8\u0109\u010e\u011a\u011e\u0124"+
		"\u0128\u012d\u0135\u0139\u0150\u0162\u0166\u017d\u017f\u0188\u0193\u0197"+
		"\u019d\u01a5\u01a9\u01af\u01b5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}