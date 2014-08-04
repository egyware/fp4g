// Generated from C:\Users\Edgardo\Git\fp4g-src\fp4g\src/fp4g/parser/FP4G.g4 by ANTLR 4.1

package fp4g.parser;

import static fp4g.log.Log.*;

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
		SINGLE_LINE_COMMENT=1, MULTI_LINE_COMMENT=2, DEFINE=3, ADD=4, ON=5, SEND=6, 
		DESTROY=7, GROUP=8, SUBSCRIBE=9, UNSUBSCRIBE=10, RESUME=11, PAUSE=12, 
		USING=13, EXIT=14, SET=15, START=16, ASSETS=17, FLAG=18, WHEN=19, MANAGER=20, 
		GAME=21, STATE=22, ASSET=23, BEHAVIOR=24, ENTITY=25, GOAL=26, MESSAGE=27, 
		BASE=28, TO=29, SOURCE=30, AS=31, OTHER=32, EMPTY=33, THEN=34, ABRE_COR=35, 
		ABRE_PAR=36, ABRE_LLAV=37, CIERRA_COR=38, CIERRA_PAR=39, CIERRA_LLAV=40, 
		COMA=41, EQUAL=42, DOT=43, DOTCOMA=44, DOUBLEDOT=45, PLUS=46, MINUS=47, 
		MULTIPLY=48, DIVIDE=49, MORE_THAN=50, LESS_THAN=51, AND=52, OR=53, XOR=54, 
		NOT=55, NUMBER_TYPE=56, STRING_TYPE=57, BOOL_TYPE=58, INTEGER_TYPE=59, 
		DOUBLE_TYPE=60, FLOAT_TYPE=61, DIRECTCODE=62, INT_LITERAL=63, DECIMAL_LITERAL=64, 
		STRING_LITERAL=65, BOOL_LITERAL=66, CURRENT_LITERAL=67, ID=68, NL=69, 
		WS=70;
	public static final String[] tokenNames = {
		"<INVALID>", "SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT", "'DEFINE'", 
		"'ADD'", "'ON'", "'SEND'", "'DESTROY'", "'GROUP'", "'SUBSCRIBE'", "'UNSUBSCRIBE'", 
		"'RESUME'", "'PAUSE'", "'USING'", "'EXIT'", "'SET'", "'START'", "'ASSETS'", 
		"'FLAG'", "'WHEN'", "'MANAGER'", "'GAME'", "'STATE'", "'ASSET'", "'BEHAVIOR'", 
		"'ENTITY'", "'GOAL'", "'MESSAGE'", "'BASE'", "'TO'", "'SOURCE'", "'AS'", 
		"'OTHER'", "'EMPTY'", "'THEN'", "'['", "'('", "'{'", "']'", "')'", "'}'", 
		"','", "'='", "'.'", "';'", "':'", "'+'", "'-'", "'*'", "'/'", "'>'", 
		"'<'", "'AND'", "'OR'", "'XOR'", "'NOT'", "'Number'", "'String'", "'Bool'", 
		"'Integer'", "'Double'", "'Float'", "DIRECTCODE", "INT_LITERAL", "DECIMAL_LITERAL", 
		"STRING_LITERAL", "BOOL_LITERAL", "'current'", "ID", "NL", "WS"
	};
	public static final int
		RULE_program = 0, RULE_parseLib = 1, RULE_usings = 2, RULE_defines = 3, 
		RULE_using = 4, RULE_usingValues = 5, RULE_usingValue = 6, RULE_game = 7, 
		RULE_gameLib = 8, RULE_gameValues = 9, RULE_gameValue = 10, RULE_set = 11, 
		RULE_start = 12, RULE_subscribe = 13, RULE_unsubscribe = 14, RULE_add = 15, 
		RULE_addDefine = 16, RULE_addMethod = 17, RULE_define = 18, RULE_on = 19, 
		RULE_statements = 20, RULE_statement = 21, RULE_assign = 22, RULE_destroy = 23, 
		RULE_send = 24, RULE_onFilters = 25, RULE_filter = 26, RULE_defineValues = 27, 
		RULE_defineValue = 28, RULE_exprList = 29, RULE_nameList = 30, RULE_declareVar = 31, 
		RULE_varType = 32, RULE_defineID = 33, RULE_assets = 34, RULE_assetValueWithInnerValue = 35, 
		RULE_assetValue = 36, RULE_assetValuesInner = 37, RULE_flag = 38, RULE_when = 39, 
		RULE_expr = 40, RULE_accessVarOp = 41, RULE_parentVarOp = 42, RULE_varOp = 43, 
		RULE_varID = 44, RULE_array = 45, RULE_arrayBody = 46, RULE_itemArray = 47, 
		RULE_parArray = 48;
	public static final String[] ruleNames = {
		"program", "parseLib", "usings", "defines", "using", "usingValues", "usingValue", 
		"game", "gameLib", "gameValues", "gameValue", "set", "start", "subscribe", 
		"unsubscribe", "add", "addDefine", "addMethod", "define", "on", "statements", 
		"statement", "assign", "destroy", "send", "onFilters", "filter", "defineValues", 
		"defineValue", "exprList", "nameList", "declareVar", "varType", "defineID", 
		"assets", "assetValueWithInnerValue", "assetValue", "assetValuesInner", 
		"flag", "when", "expr", "accessVarOp", "parentVarOp", "varOp", "varID", 
		"array", "arrayBody", "itemArray", "parArray"
	};

	@Override
	public String getGrammarFileName() { return "FP4G.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public FP4GParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(FP4GParser.EOF, 0); }
		public DefinesContext defines() {
			return getRuleContext(DefinesContext.class,0);
		}
		public UsingsContext usings() {
			return getRuleContext(UsingsContext.class,0);
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
			setState(98); usings();
			setState(99); defines();
			setState(100); match(EOF);
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
		public GameLibContext gameLib() {
			return getRuleContext(GameLibContext.class,0);
		}
		public UsingsContext usings() {
			return getRuleContext(UsingsContext.class,0);
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
			setState(102); usings();
			setState(103); gameLib();
			setState(104); match(EOF);
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
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==USING) {
				{
				{
				setState(106); using();
				}
				}
				setState(111);
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

	public static class DefinesContext extends ParserRuleContext {
		public DefineContext define(int i) {
			return getRuleContext(DefineContext.class,i);
		}
		public List<DefineContext> define() {
			return getRuleContexts(DefineContext.class);
		}
		public GameContext game(int i) {
			return getRuleContext(GameContext.class,i);
		}
		public List<GameContext> game() {
			return getRuleContexts(GameContext.class);
		}
		public DefinesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defines; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitDefines(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinesContext defines() throws RecognitionException {
		DefinesContext _localctx = new DefinesContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_defines);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DEFINE) {
				{
				setState(114);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(112); game();
					}
					break;

				case 2:
					{
					setState(113); define();
					}
					break;
				}
				}
				setState(118);
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

	public static class UsingContext extends ParserRuleContext {
		public DefineType type = null;
		public Token ID;
		public Token name;
		public TerminalNode ABRE_COR() { return getToken(FP4GParser.ABRE_COR, 0); }
		public TerminalNode DOTCOMA() { return getToken(FP4GParser.DOTCOMA, 0); }
		public List<TerminalNode> ID() { return getTokens(FP4GParser.ID); }
		public TerminalNode MANAGER() { return getToken(FP4GParser.MANAGER, 0); }
		public TerminalNode BEHAVIOR() { return getToken(FP4GParser.BEHAVIOR, 0); }
		public TerminalNode GOAL() { return getToken(FP4GParser.GOAL, 0); }
		public TerminalNode STATE() { return getToken(FP4GParser.STATE, 0); }
		public TerminalNode CIERRA_COR() { return getToken(FP4GParser.CIERRA_COR, 0); }
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
		enterRule(_localctx, 8, RULE_using);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119); match(USING);
			setState(134);
			switch (_input.LA(1)) {
			case MANAGER:
				{
				setState(120); match(MANAGER);
				 ((UsingContext)_localctx).type =  DefineType.MANAGER; 
				}
				break;
			case STATE:
				{
				setState(122); match(STATE);
				 ((UsingContext)_localctx).type =  DefineType.STATE;   
				}
				break;
			case BEHAVIOR:
				{
				setState(124); match(BEHAVIOR);
				 ((UsingContext)_localctx).type =  DefineType.BEHAVIOR;
				}
				break;
			case ENTITY:
				{
				setState(126); match(ENTITY);
				 ((UsingContext)_localctx).type =  DefineType.ENTITY;  
				}
				break;
			case GOAL:
				{
				setState(128); match(GOAL);
				 ((UsingContext)_localctx).type =  DefineType.GOAL;    
				}
				break;
			case MESSAGE:
				{
				setState(130); match(MESSAGE);
				 ((UsingContext)_localctx).type =  DefineType.MESSAGE; 
				}
				break;
			case ID:
				{
				setState(132); ((UsingContext)_localctx).ID = match(ID);
				 ((UsingContext)_localctx).type =  DefineType.valueOf((((UsingContext)_localctx).ID!=null?((UsingContext)_localctx).ID.getText():null));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(136); ((UsingContext)_localctx).name = match(ID);
			setState(142);
			switch (_input.LA(1)) {
			case DOTCOMA:
				{
				setState(137); match(DOTCOMA);
				}
				break;
			case ABRE_COR:
				{
				setState(138); match(ABRE_COR);
				setState(139); usingValues();
				setState(140); match(CIERRA_COR);
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
		enterRule(_localctx, 10, RULE_usingValues);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD || _la==SET) {
				{
				{
				setState(144); usingValue();
				}
				}
				setState(149);
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
		enterRule(_localctx, 12, RULE_usingValue);
		try {
			setState(156);
			switch (_input.LA(1)) {
			case ADD:
				enterOuterAlt(_localctx, 1);
				{
				setState(150); add();
				setState(151); match(DOTCOMA);
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 2);
				{
				setState(153); set();
				setState(154); match(DOTCOMA);
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
		enterRule(_localctx, 14, RULE_game);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158); match(DEFINE);
			setState(159); match(GAME);
			setState(160); ((GameContext)_localctx).ID = match(ID);
			 ((GameContext)_localctx).name =  (((GameContext)_localctx).ID!=null?((GameContext)_localctx).ID.getText():null); 
			setState(162); match(ABRE_COR);
			setState(163); gameValues();
			setState(164); match(CIERRA_COR);
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

	public static class GameLibContext extends ParserRuleContext {
		public DefineContext define(int i) {
			return getRuleContext(DefineContext.class,i);
		}
		public List<DefineContext> define() {
			return getRuleContexts(DefineContext.class);
		}
		public GameValueContext gameValue(int i) {
			return getRuleContext(GameValueContext.class,i);
		}
		public List<GameValueContext> gameValue() {
			return getRuleContexts(GameValueContext.class);
		}
		public GameLibContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gameLib; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitGameLib(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GameLibContext gameLib() throws RecognitionException {
		GameLibContext _localctx = new GameLibContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_gameLib);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DEFINE) | (1L << ADD) | (1L << ON) | (1L << SET) | (1L << START) | (1L << FLAG) | (1L << WHEN))) != 0)) {
				{
				setState(168);
				switch (_input.LA(1)) {
				case ADD:
				case ON:
				case SET:
				case START:
				case FLAG:
				case WHEN:
					{
					setState(166); gameValue();
					}
					break;
				case DEFINE:
					{
					setState(167); define();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(172);
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
		enterRule(_localctx, 18, RULE_gameValues);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << ON) | (1L << SET) | (1L << START) | (1L << FLAG) | (1L << WHEN))) != 0)) {
				{
				{
				setState(173); gameValue();
				}
				}
				setState(178);
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
		public StartContext start() {
			return getRuleContext(StartContext.class,0);
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
		enterRule(_localctx, 20, RULE_gameValue);
		try {
			setState(195);
			switch (_input.LA(1)) {
			case ADD:
				enterOuterAlt(_localctx, 1);
				{
				setState(179); add();
				setState(180); match(DOTCOMA);
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 2);
				{
				setState(182); set();
				setState(183); match(DOTCOMA);
				}
				break;
			case START:
				enterOuterAlt(_localctx, 3);
				{
				setState(185); start();
				setState(186); match(DOTCOMA);
				}
				break;
			case WHEN:
				enterOuterAlt(_localctx, 4);
				{
				setState(188); when();
				setState(189); match(DOTCOMA);
				}
				break;
			case ON:
				enterOuterAlt(_localctx, 5);
				{
				setState(191); on();
				}
				break;
			case FLAG:
				enterOuterAlt(_localctx, 6);
				{
				setState(192); flag();
				setState(193); match(DOTCOMA);
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

	public static class SetContext extends ParserRuleContext {
		public String key;
		public Token ID;
		public TerminalNode SET() { return getToken(FP4GParser.SET, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public TerminalNode EQUAL() { return getToken(FP4GParser.EQUAL, 0); }
		public SetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetContext set() throws RecognitionException {
		SetContext _localctx = new SetContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197); match(SET);
			setState(198); ((SetContext)_localctx).ID = match(ID);
			 ((SetContext)_localctx).key =  (((SetContext)_localctx).ID!=null?((SetContext)_localctx).ID.getText():null); 
			setState(200); match(EQUAL);
			setState(201); expr(0);
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

	public static class StartContext extends ParserRuleContext {
		public String state;
		public Token ID;
		public TerminalNode START() { return getToken(FP4GParser.START, 0); }
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203); match(START);
			setState(204); ((StartContext)_localctx).ID = match(ID);
			 ((StartContext)_localctx).state =  (((StartContext)_localctx).ID!=null?((StartContext)_localctx).ID.getText():null); 
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

	public static class SubscribeContext extends ParserRuleContext {
		public Token where;
		public Token message;
		public Token method;
		public TerminalNode DOUBLEDOT() { return getToken(FP4GParser.DOUBLEDOT, 0); }
		public TerminalNode ON() { return getToken(FP4GParser.ON, 0); }
		public TerminalNode SUBSCRIBE() { return getToken(FP4GParser.SUBSCRIBE, 0); }
		public List<TerminalNode> ID() { return getTokens(FP4GParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FP4GParser.ID, i);
		}
		public SubscribeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subscribe; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitSubscribe(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubscribeContext subscribe() throws RecognitionException {
		SubscribeContext _localctx = new SubscribeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_subscribe);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207); match(SUBSCRIBE);
			setState(208); ((SubscribeContext)_localctx).where = match(ID);
			setState(209); match(ON);
			setState(210); ((SubscribeContext)_localctx).message = match(ID);
			setState(213);
			_la = _input.LA(1);
			if (_la==DOUBLEDOT) {
				{
				setState(211); match(DOUBLEDOT);
				setState(212); ((SubscribeContext)_localctx).method = match(ID);
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

	public static class UnsubscribeContext extends ParserRuleContext {
		public Token where;
		public Token message;
		public Token method;
		public TerminalNode DOUBLEDOT() { return getToken(FP4GParser.DOUBLEDOT, 0); }
		public TerminalNode ON() { return getToken(FP4GParser.ON, 0); }
		public TerminalNode UNSUBSCRIBE() { return getToken(FP4GParser.UNSUBSCRIBE, 0); }
		public List<TerminalNode> ID() { return getTokens(FP4GParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FP4GParser.ID, i);
		}
		public UnsubscribeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsubscribe; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitUnsubscribe(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnsubscribeContext unsubscribe() throws RecognitionException {
		UnsubscribeContext _localctx = new UnsubscribeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_unsubscribe);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215); match(UNSUBSCRIBE);
			setState(216); ((UnsubscribeContext)_localctx).where = match(ID);
			setState(217); match(ON);
			setState(218); ((UnsubscribeContext)_localctx).message = match(ID);
			setState(221);
			_la = _input.LA(1);
			if (_la==DOUBLEDOT) {
				{
				setState(219); match(DOUBLEDOT);
				setState(220); ((UnsubscribeContext)_localctx).method = match(ID);
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
			setState(223); match(ADD);
			setState(226);
			switch (_input.LA(1)) {
			case MANAGER:
			case STATE:
			case BEHAVIOR:
			case ENTITY:
			case GOAL:
				{
				setState(224); addDefine();
				}
				break;
			case ID:
				{
				setState(225); addMethod();
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
		public DefineType type = null;
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
			setState(238);
			switch (_input.LA(1)) {
			case MANAGER:
				{
				setState(228); match(MANAGER);
				 ((AddDefineContext)_localctx).type =  DefineType.MANAGER;  
				}
				break;
			case STATE:
				{
				setState(230); match(STATE);
				 ((AddDefineContext)_localctx).type =  DefineType.STATE;    
				}
				break;
			case BEHAVIOR:
				{
				setState(232); match(BEHAVIOR);
				 ((AddDefineContext)_localctx).type =  DefineType.BEHAVIOR; 
				}
				break;
			case ENTITY:
				{
				setState(234); match(ENTITY);
				 ((AddDefineContext)_localctx).type =  DefineType.ENTITY;  
				}
				break;
			case GOAL:
				{
				setState(236); match(GOAL);
				 ((AddDefineContext)_localctx).type =  DefineType.GOAL;  
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(240); ((AddDefineContext)_localctx).ID = match(ID);
			 ((AddDefineContext)_localctx).addName =  (((AddDefineContext)_localctx).ID!=null?((AddDefineContext)_localctx).ID.getText():null); 
			setState(247);
			_la = _input.LA(1);
			if (_la==ABRE_PAR) {
				{
				setState(242); match(ABRE_PAR);
				setState(244);
				_la = _input.LA(1);
				if (((((_la - 20)) & ~0x3f) == 0 && ((1L << (_la - 20)) & ((1L << (MANAGER - 20)) | (1L << (GAME - 20)) | (1L << (STATE - 20)) | (1L << (ASSET - 20)) | (1L << (BEHAVIOR - 20)) | (1L << (ENTITY - 20)) | (1L << (GOAL - 20)) | (1L << (MESSAGE - 20)) | (1L << (EMPTY - 20)) | (1L << (ABRE_PAR - 20)) | (1L << (ABRE_LLAV - 20)) | (1L << (MINUS - 20)) | (1L << (NOT - 20)) | (1L << (DIRECTCODE - 20)) | (1L << (INT_LITERAL - 20)) | (1L << (DECIMAL_LITERAL - 20)) | (1L << (STRING_LITERAL - 20)) | (1L << (BOOL_LITERAL - 20)) | (1L << (CURRENT_LITERAL - 20)) | (1L << (ID - 20)))) != 0)) {
					{
					setState(243); exprList();
					}
				}

				setState(246); match(CIERRA_PAR);
				}
			}

			setState(250);
			_la = _input.LA(1);
			if (_la==EMPTY || _la==ABRE_LLAV) {
				{
				setState(249); ((AddDefineContext)_localctx).exprParams = array();
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
			setState(252); ((AddMethodContext)_localctx).ID = match(ID);
			 ((AddMethodContext)_localctx).addName =  (((AddMethodContext)_localctx).ID!=null?((AddMethodContext)_localctx).ID.getText():null); 
			setState(254); match(ABRE_PAR);
			setState(256);
			_la = _input.LA(1);
			if (((((_la - 56)) & ~0x3f) == 0 && ((1L << (_la - 56)) & ((1L << (NUMBER_TYPE - 56)) | (1L << (STRING_TYPE - 56)) | (1L << (BOOL_TYPE - 56)) | (1L << (INTEGER_TYPE - 56)) | (1L << (DOUBLE_TYPE - 56)) | (1L << (FLOAT_TYPE - 56)) | (1L << (ID - 56)))) != 0)) {
				{
				setState(255); nameList();
				}
			}

			setState(258); match(CIERRA_PAR);
			setState(260);
			_la = _input.LA(1);
			if (_la==EMPTY || _la==ABRE_LLAV) {
				{
				setState(259); ((AddMethodContext)_localctx).exprParams = array();
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

	public static class DefineContext extends ParserRuleContext {
		public DefineType type = null;
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
		enterRule(_localctx, 36, RULE_define);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262); match(DEFINE);
			setState(279);
			switch (_input.LA(1)) {
			case MANAGER:
				{
				setState(263); match(MANAGER);
				 ((DefineContext)_localctx).type =  DefineType.MANAGER; 
				}
				break;
			case STATE:
				{
				setState(265); match(STATE);
				 ((DefineContext)_localctx).type =  DefineType.STATE;   
				}
				break;
			case BEHAVIOR:
				{
				setState(267); match(BEHAVIOR);
				 ((DefineContext)_localctx).type =  DefineType.BEHAVIOR;
				}
				break;
			case ENTITY:
				{
				setState(269); match(ENTITY);
				 ((DefineContext)_localctx).type =  DefineType.ENTITY;  
				}
				break;
			case GOAL:
				{
				setState(271); match(GOAL);
				 ((DefineContext)_localctx).type =  DefineType.GOAL;    
				}
				break;
			case MESSAGE:
				{
				setState(273); match(MESSAGE);
				 ((DefineContext)_localctx).type =  DefineType.MESSAGE; 
				}
				break;
			case ASSET:
				{
				setState(275); match(ASSET);
				 ((DefineContext)_localctx).type =  DefineType.ASSET;   
				}
				break;
			case ID:
				{
				setState(277); ((DefineContext)_localctx).ID = match(ID);
				 ((DefineContext)_localctx).type =  DefineType.valueOf((((DefineContext)_localctx).ID!=null?((DefineContext)_localctx).ID.getText():null));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(281); ((DefineContext)_localctx).ID = match(ID);
			 ((DefineContext)_localctx).defName =  (((DefineContext)_localctx).ID!=null?((DefineContext)_localctx).ID.getText():null); 
			setState(287);
			_la = _input.LA(1);
			if (_la==ABRE_PAR) {
				{
				setState(283); match(ABRE_PAR);
				setState(284); nameList();
				setState(285); match(CIERRA_PAR);
				}
			}

			setState(289); match(ABRE_COR);
			setState(290); defineValues();
			setState(291); match(CIERRA_COR);
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
			setState(293); match(ON);
			setState(294); ((OnContext)_localctx).ID = match(ID);
			((OnContext)_localctx).messageName =  (((OnContext)_localctx).ID!=null?((OnContext)_localctx).ID.getText():null); 
			setState(298);
			_la = _input.LA(1);
			if (_la==DOUBLEDOT) {
				{
				setState(296); match(DOUBLEDOT);
				setState(297); ((OnContext)_localctx).filters = onFilters();
				}
			}

			setState(300); match(ABRE_COR);
			setState(301); statements();
			setState(302); match(CIERRA_COR);
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
			setState(309);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 6)) & ~0x3f) == 0 && ((1L << (_la - 6)) & ((1L << (SEND - 6)) | (1L << (DESTROY - 6)) | (1L << (SUBSCRIBE - 6)) | (1L << (UNSUBSCRIBE - 6)) | (1L << (ID - 6)))) != 0)) {
				{
				{
				setState(304); statement();
				setState(305); match(DOTCOMA);
				}
				}
				setState(311);
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
		public SubscribeContext subscribe() {
			return getRuleContext(SubscribeContext.class,0);
		}
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public UnsubscribeContext unsubscribe() {
			return getRuleContext(UnsubscribeContext.class,0);
		}
		public SendContext send() {
			return getRuleContext(SendContext.class,0);
		}
		public DestroyContext destroy() {
			return getRuleContext(DestroyContext.class,0);
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
			setState(317);
			switch (_input.LA(1)) {
			case SEND:
				enterOuterAlt(_localctx, 1);
				{
				setState(312); send();
				}
				break;
			case DESTROY:
				enterOuterAlt(_localctx, 2);
				{
				setState(313); destroy();
				}
				break;
			case SUBSCRIBE:
				enterOuterAlt(_localctx, 3);
				{
				setState(314); subscribe();
				}
				break;
			case UNSUBSCRIBE:
				enterOuterAlt(_localctx, 4);
				{
				setState(315); unsubscribe();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(316); assign();
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
		enterRule(_localctx, 44, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319); ((AssignContext)_localctx).varName = match(ID);
			setState(320); match(EQUAL);
			setState(321); expr(0);
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

	public static class DestroyContext extends ParserRuleContext {
		public TerminalNode DESTROY() { return getToken(FP4GParser.DESTROY, 0); }
		public DestroyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_destroy; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitDestroy(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DestroyContext destroy() throws RecognitionException {
		DestroyContext _localctx = new DestroyContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_destroy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323); match(DESTROY);
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

	public static class SendContext extends ParserRuleContext {
		public String messageMethodName;
		public String receiverName;
		public Instance receiverType;
		public Token method;
		public Token receiver;
		public TerminalNode OTHER() { return getToken(FP4GParser.OTHER, 0); }
		public TerminalNode GAME() { return getToken(FP4GParser.GAME, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(FP4GParser.ID); }
		public TerminalNode SEND() { return getToken(FP4GParser.SEND, 0); }
		public TerminalNode CIERRA_PAR() { return getToken(FP4GParser.CIERRA_PAR, 0); }
		public TerminalNode TO() { return getToken(FP4GParser.TO, 0); }
		public TerminalNode ABRE_PAR() { return getToken(FP4GParser.ABRE_PAR, 0); }
		public TerminalNode ID(int i) {
			return getToken(FP4GParser.ID, i);
		}
		public SendContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_send; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitSend(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SendContext send() throws RecognitionException {
		SendContext _localctx = new SendContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_send);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((SendContext)_localctx).receiverType =  Instance.Self;
			setState(326); match(SEND);
			setState(327); ((SendContext)_localctx).method = match(ID);
			((SendContext)_localctx).messageMethodName =  (((SendContext)_localctx).method!=null?((SendContext)_localctx).method.getText():null);
			setState(334);
			_la = _input.LA(1);
			if (_la==ABRE_PAR) {
				{
				setState(329); match(ABRE_PAR);
				setState(331);
				_la = _input.LA(1);
				if (((((_la - 20)) & ~0x3f) == 0 && ((1L << (_la - 20)) & ((1L << (MANAGER - 20)) | (1L << (GAME - 20)) | (1L << (STATE - 20)) | (1L << (ASSET - 20)) | (1L << (BEHAVIOR - 20)) | (1L << (ENTITY - 20)) | (1L << (GOAL - 20)) | (1L << (MESSAGE - 20)) | (1L << (EMPTY - 20)) | (1L << (ABRE_PAR - 20)) | (1L << (ABRE_LLAV - 20)) | (1L << (MINUS - 20)) | (1L << (NOT - 20)) | (1L << (DIRECTCODE - 20)) | (1L << (INT_LITERAL - 20)) | (1L << (DECIMAL_LITERAL - 20)) | (1L << (STRING_LITERAL - 20)) | (1L << (BOOL_LITERAL - 20)) | (1L << (CURRENT_LITERAL - 20)) | (1L << (ID - 20)))) != 0)) {
					{
					setState(330); exprList();
					}
				}

				setState(333); match(CIERRA_PAR);
				}
			}

			setState(346);
			_la = _input.LA(1);
			if (_la==TO) {
				{
				setState(336); match(TO);
				setState(343);
				switch (_input.LA(1)) {
				case OTHER:
					{
					setState(337); ((SendContext)_localctx).receiver = match(OTHER);
					((SendContext)_localctx).receiverType =  Instance.Other;
					}
					break;
				case GAME:
					{
					setState(339); ((SendContext)_localctx).receiver = match(GAME);
					((SendContext)_localctx).receiverType =  Instance.Game;
					}
					break;
				case ID:
					{
					setState(341); ((SendContext)_localctx).receiver = match(ID);
					((SendContext)_localctx).receiverType =  null;
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				((SendContext)_localctx).receiverName =  (((SendContext)_localctx).receiver!=null?((SendContext)_localctx).receiver.getText():null);
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
			setState(348); filter();
			setState(352);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(349); filter();
				}
				}
				setState(354);
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
			setState(355); ((FilterContext)_localctx).ID = match(ID);
			((FilterContext)_localctx).filterName =  (((FilterContext)_localctx).ID!=null?((FilterContext)_localctx).ID.getText():null);
			setState(362);
			_la = _input.LA(1);
			if (_la==ABRE_PAR) {
				{
				setState(357); match(ABRE_PAR);
				setState(359);
				_la = _input.LA(1);
				if (((((_la - 20)) & ~0x3f) == 0 && ((1L << (_la - 20)) & ((1L << (MANAGER - 20)) | (1L << (GAME - 20)) | (1L << (STATE - 20)) | (1L << (ASSET - 20)) | (1L << (BEHAVIOR - 20)) | (1L << (ENTITY - 20)) | (1L << (GOAL - 20)) | (1L << (MESSAGE - 20)) | (1L << (EMPTY - 20)) | (1L << (ABRE_PAR - 20)) | (1L << (ABRE_LLAV - 20)) | (1L << (MINUS - 20)) | (1L << (NOT - 20)) | (1L << (DIRECTCODE - 20)) | (1L << (INT_LITERAL - 20)) | (1L << (DECIMAL_LITERAL - 20)) | (1L << (STRING_LITERAL - 20)) | (1L << (BOOL_LITERAL - 20)) | (1L << (CURRENT_LITERAL - 20)) | (1L << (ID - 20)))) != 0)) {
					{
					setState(358); exprList();
					}
				}

				setState(361); match(CIERRA_PAR);
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
			setState(367);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << ON) | (1L << SET) | (1L << ASSETS) | (1L << FLAG) | (1L << WHEN))) != 0)) {
				{
				{
				setState(364); defineValue();
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
			setState(384);
			switch (_input.LA(1)) {
			case ADD:
				enterOuterAlt(_localctx, 1);
				{
				setState(370); add();
				setState(371); match(DOTCOMA);
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 2);
				{
				setState(373); set();
				setState(374); match(DOTCOMA);
				}
				break;
			case FLAG:
				enterOuterAlt(_localctx, 3);
				{
				setState(376); flag();
				setState(377); match(DOTCOMA);
				}
				break;
			case WHEN:
				enterOuterAlt(_localctx, 4);
				{
				setState(379); when();
				setState(380); match(DOTCOMA);
				}
				break;
			case ON:
				enterOuterAlt(_localctx, 5);
				{
				setState(382); on();
				}
				break;
			case ASSETS:
				enterOuterAlt(_localctx, 6);
				{
				setState(383); assets();
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
			setState(386); expr(0);
			setState(391);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(387); match(COMA);
				setState(388); expr(0);
				}
				}
				setState(393);
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
			setState(394); declareVar();
			setState(399);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(395); match(COMA);
				setState(396); declareVar();
				}
				}
				setState(401);
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
			setState(402); varType();
			setState(403); ((DeclareVarContext)_localctx).varName = match(ID);
			setState(406);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(404); match(EQUAL);
				setState(405); ((DeclareVarContext)_localctx).initValue = expr(0);
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
		public VarType type = null;
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
			setState(423);
			switch (_input.LA(1)) {
			case NUMBER_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(408); match(NUMBER_TYPE);
				((VarTypeContext)_localctx).type =  BasicType.Number;
				}
				break;
			case BOOL_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(410); match(BOOL_TYPE);
				((VarTypeContext)_localctx).type =  BasicType.Bool;
				}
				break;
			case STRING_TYPE:
				enterOuterAlt(_localctx, 3);
				{
				setState(412); match(STRING_TYPE);
				((VarTypeContext)_localctx).type =  BasicType.String;
				}
				break;
			case INTEGER_TYPE:
				enterOuterAlt(_localctx, 4);
				{
				setState(414); match(INTEGER_TYPE);
				((VarTypeContext)_localctx).type =  BasicType.Integer;
				}
				break;
			case DOUBLE_TYPE:
				enterOuterAlt(_localctx, 5);
				{
				setState(416); match(DOUBLE_TYPE);
				((VarTypeContext)_localctx).type =  BasicType.Double;
				}
				break;
			case FLOAT_TYPE:
				enterOuterAlt(_localctx, 6);
				{
				setState(418); match(FLOAT_TYPE);
				((VarTypeContext)_localctx).type =  BasicType.Float;
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 7);
				{
				setState(420); ((VarTypeContext)_localctx).id = defineID();
				((VarTypeContext)_localctx).type =  new CustomType((((VarTypeContext)_localctx).id.type != null)?DefineType.valueOf(((VarTypeContext)_localctx).id.type):DefineType.STRUCT, ((VarTypeContext)_localctx).id.name);
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
		public String type;
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
			setState(428);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(425); ((DefineIDContext)_localctx).defineType = match(ID);
				setState(426); match(DOUBLEDOT);
				((DefineIDContext)_localctx).type =  (((DefineIDContext)_localctx).defineType!=null?((DefineIDContext)_localctx).defineType.getText():null);
				}
				break;
			}
			setState(430); ((DefineIDContext)_localctx).defineName = match(ID);
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
			setState(433); match(ASSETS);
			setState(434); match(ABRE_COR);
			setState(435); assetValueWithInnerValue();
			setState(440);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(436); match(COMA);
					setState(437); assetValueWithInnerValue();
					}
					} 
				}
				setState(442);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			}
			setState(444);
			_la = _input.LA(1);
			if (_la==COMA) {
				{
				setState(443); match(COMA);
				}
			}

			setState(446); match(CIERRA_COR);
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
			setState(448); ((AssetValueWithInnerValueContext)_localctx).value = assetValue();
			setState(450);
			_la = _input.LA(1);
			if (_la==ABRE_COR) {
				{
				setState(449); ((AssetValueWithInnerValueContext)_localctx).innerAssets = assetValuesInner();
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
			setState(452); ((AssetValueContext)_localctx).assetType = match(ID);
			setState(454);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(453); ((AssetValueContext)_localctx).assetName = match(ID);
				}
			}

			setState(456); match(DOUBLEDOT);
			setState(457); ((AssetValueContext)_localctx).assetPath = match(STRING_LITERAL);
			setState(459);
			_la = _input.LA(1);
			if (_la==EMPTY || _la==ABRE_LLAV) {
				{
				setState(458); ((AssetValueContext)_localctx).exprParams = array();
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
			setState(461); match(ABRE_COR);
			setState(462); assetValue();
			setState(467);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(463); match(COMA);
					setState(464); assetValue();
					}
					} 
				}
				setState(469);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			}
			setState(471);
			_la = _input.LA(1);
			if (_la==COMA) {
				{
				setState(470); match(COMA);
				}
			}

			setState(473); match(CIERRA_COR);
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
			setState(475); match(FLAG);
			setState(476); declareVar();
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
			setState(478); match(WHEN);
			setState(479); ((WhenContext)_localctx).condition = expr(0);
			setState(480); match(THEN);
			setState(481); ((WhenContext)_localctx).stmnt = statement();
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
	public static class FunctionCallExprContext extends ExprContext {
		public Token functionName;
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public TerminalNode CIERRA_PAR() { return getToken(FP4GParser.CIERRA_PAR, 0); }
		public TerminalNode ABRE_PAR() { return getToken(FP4GParser.ABRE_PAR, 0); }
		public FunctionCallExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitFunctionCallExpr(this);
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
	public static class VarExprContext extends ExprContext {
		public AccessVarOpContext accessVarOp() {
			return getRuleContext(AccessVarOpContext.class,0);
		}
		public VarExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitVarExpr(this);
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
			setState(505);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(484); match(NOT);
				setState(485); ((NotExprContext)_localctx).op = expr(17);
				}
				break;

			case 2:
				{
				_localctx = new MinusExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(486); match(MINUS);
				setState(487); ((MinusExprContext)_localctx).op = expr(12);
				}
				break;

			case 3:
				{
				_localctx = new ArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(488); array();
				}
				break;

			case 4:
				{
				_localctx = new ParExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(489); match(ABRE_PAR);
				setState(490); ((ParExprContext)_localctx).op = expr(0);
				setState(491); match(CIERRA_PAR);
				}
				break;

			case 5:
				{
				_localctx = new IntLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(493); match(INT_LITERAL);
				}
				break;

			case 6:
				{
				_localctx = new DecimalLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(494); match(DECIMAL_LITERAL);
				}
				break;

			case 7:
				{
				_localctx = new StringLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(495); match(STRING_LITERAL);
				}
				break;

			case 8:
				{
				_localctx = new BoolLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(496); match(BOOL_LITERAL);
				}
				break;

			case 9:
				{
				_localctx = new DirectCodeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(497); match(DIRECTCODE);
				}
				break;

			case 10:
				{
				_localctx = new FunctionCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(498); ((FunctionCallExprContext)_localctx).functionName = match(ID);
				setState(499); match(ABRE_PAR);
				setState(501);
				_la = _input.LA(1);
				if (((((_la - 20)) & ~0x3f) == 0 && ((1L << (_la - 20)) & ((1L << (MANAGER - 20)) | (1L << (GAME - 20)) | (1L << (STATE - 20)) | (1L << (ASSET - 20)) | (1L << (BEHAVIOR - 20)) | (1L << (ENTITY - 20)) | (1L << (GOAL - 20)) | (1L << (MESSAGE - 20)) | (1L << (EMPTY - 20)) | (1L << (ABRE_PAR - 20)) | (1L << (ABRE_LLAV - 20)) | (1L << (MINUS - 20)) | (1L << (NOT - 20)) | (1L << (DIRECTCODE - 20)) | (1L << (INT_LITERAL - 20)) | (1L << (DECIMAL_LITERAL - 20)) | (1L << (STRING_LITERAL - 20)) | (1L << (BOOL_LITERAL - 20)) | (1L << (CURRENT_LITERAL - 20)) | (1L << (ID - 20)))) != 0)) {
					{
					setState(500); exprList();
					}
				}

				setState(503); match(CIERRA_PAR);
				}
				break;

			case 11:
				{
				_localctx = new VarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(504); accessVarOp();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(530);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(528);
					switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
					case 1:
						{
						_localctx = new LessThanExprContext(new ExprContext(_parentctx, _parentState, _p));
						((LessThanExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(507);
						if (!(16 >= _localctx._p)) throw new FailedPredicateException(this, "16 >= $_p");
						setState(508); match(LESS_THAN);
						setState(509); ((LessThanExprContext)_localctx).right = expr(17);
						}
						break;

					case 2:
						{
						_localctx = new MoreThanExprContext(new ExprContext(_parentctx, _parentState, _p));
						((MoreThanExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(510);
						if (!(15 >= _localctx._p)) throw new FailedPredicateException(this, "15 >= $_p");
						setState(511); match(MORE_THAN);
						setState(512); ((MoreThanExprContext)_localctx).right = expr(16);
						}
						break;

					case 3:
						{
						_localctx = new EqualExprContext(new ExprContext(_parentctx, _parentState, _p));
						((EqualExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(513);
						if (!(14 >= _localctx._p)) throw new FailedPredicateException(this, "14 >= $_p");
						setState(514); match(EQUAL);
						setState(515); ((EqualExprContext)_localctx).right = expr(15);
						}
						break;

					case 4:
						{
						_localctx = new MultExprContext(new ExprContext(_parentctx, _parentState, _p));
						((MultExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(516);
						if (!(11 >= _localctx._p)) throw new FailedPredicateException(this, "11 >= $_p");
						setState(517); match(MULTIPLY);
						setState(518); ((MultExprContext)_localctx).right = expr(12);
						}
						break;

					case 5:
						{
						_localctx = new DivExprContext(new ExprContext(_parentctx, _parentState, _p));
						((DivExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(519);
						if (!(10 >= _localctx._p)) throw new FailedPredicateException(this, "10 >= $_p");
						setState(520); match(DIVIDE);
						setState(521); ((DivExprContext)_localctx).right = expr(11);
						}
						break;

					case 6:
						{
						_localctx = new AddExprContext(new ExprContext(_parentctx, _parentState, _p));
						((AddExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(522);
						if (!(9 >= _localctx._p)) throw new FailedPredicateException(this, "9 >= $_p");
						setState(523); match(PLUS);
						setState(524); ((AddExprContext)_localctx).right = expr(10);
						}
						break;

					case 7:
						{
						_localctx = new SubExprContext(new ExprContext(_parentctx, _parentState, _p));
						((SubExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(525);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(526); match(MINUS);
						setState(527); ((SubExprContext)_localctx).right = expr(9);
						}
						break;
					}
					} 
				}
				setState(532);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
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

	public static class AccessVarOpContext extends ParserRuleContext {
		public AccessVarOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessVarOp; }
	 
		public AccessVarOpContext() { }
		public void copyFrom(AccessVarOpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AccessVarOperatorContext extends AccessVarOpContext {
		public ParentVarOpContext pVar;
		public AccessVarOpContext propertyAccess;
		public AccessVarOpContext accessVarOp() {
			return getRuleContext(AccessVarOpContext.class,0);
		}
		public TerminalNode DOT() { return getToken(FP4GParser.DOT, 0); }
		public ParentVarOpContext parentVarOp() {
			return getRuleContext(ParentVarOpContext.class,0);
		}
		public AccessVarOperatorContext(AccessVarOpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitAccessVarOperator(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AccessVarNameContext extends AccessVarOpContext {
		public VarOpContext var;
		public VarOpContext varOp() {
			return getRuleContext(VarOpContext.class,0);
		}
		public AccessVarNameContext(AccessVarOpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitAccessVarName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccessVarOpContext accessVarOp() throws RecognitionException {
		AccessVarOpContext _localctx = new AccessVarOpContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_accessVarOp);
		try {
			setState(538);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				_localctx = new AccessVarNameContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(533); ((AccessVarNameContext)_localctx).var = varOp();
				}
				break;

			case 2:
				_localctx = new AccessVarOperatorContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(534); ((AccessVarOperatorContext)_localctx).pVar = parentVarOp();
				setState(535); match(DOT);
				setState(536); ((AccessVarOperatorContext)_localctx).propertyAccess = accessVarOp();
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

	public static class ParentVarOpContext extends ParserRuleContext {
		public String name;
		public ParentVarOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parentVarOp; }
	 
		public ParentVarOpContext() { }
		public void copyFrom(ParentVarOpContext ctx) {
			super.copyFrom(ctx);
			this.name = ctx.name;
		}
	}
	public static class VarNameOperatorContext extends ParentVarOpContext {
		public VarIDContext varName;
		public VarIDContext varID() {
			return getRuleContext(VarIDContext.class,0);
		}
		public VarNameOperatorContext(ParentVarOpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitVarNameOperator(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CurrentOperatorContext extends ParentVarOpContext {
		public TerminalNode CURRENT_LITERAL() { return getToken(FP4GParser.CURRENT_LITERAL, 0); }
		public CurrentOperatorContext(ParentVarOpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitCurrentOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParentVarOpContext parentVarOp() throws RecognitionException {
		ParentVarOpContext _localctx = new ParentVarOpContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_parentVarOp);
		try {
			setState(544);
			switch (_input.LA(1)) {
			case CURRENT_LITERAL:
				_localctx = new CurrentOperatorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(540); match(CURRENT_LITERAL);
				}
				break;
			case MANAGER:
			case GAME:
			case STATE:
			case ASSET:
			case BEHAVIOR:
			case ENTITY:
			case GOAL:
			case MESSAGE:
			case ID:
				_localctx = new VarNameOperatorContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(541); ((VarNameOperatorContext)_localctx).varName = varID();
				((VarNameOperatorContext)_localctx).name = (((VarNameOperatorContext)_localctx).varName!=null?_input.getText(((VarNameOperatorContext)_localctx).varName.start,((VarNameOperatorContext)_localctx).varName.stop):null);
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

	public static class VarOpContext extends ParserRuleContext {
		public VarOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varOp; }
	 
		public VarOpContext() { }
		public void copyFrom(VarOpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarNameContext extends VarOpContext {
		public VarIDContext varName;
		public VarIDContext varID() {
			return getRuleContext(VarIDContext.class,0);
		}
		public VarNameContext(VarOpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitVarName(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarCurrentContext extends VarOpContext {
		public TerminalNode CURRENT_LITERAL() { return getToken(FP4GParser.CURRENT_LITERAL, 0); }
		public VarCurrentContext(VarOpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitVarCurrent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarOpContext varOp() throws RecognitionException {
		VarOpContext _localctx = new VarOpContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_varOp);
		try {
			setState(548);
			switch (_input.LA(1)) {
			case CURRENT_LITERAL:
				_localctx = new VarCurrentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(546); match(CURRENT_LITERAL);
				}
				break;
			case MANAGER:
			case GAME:
			case STATE:
			case ASSET:
			case BEHAVIOR:
			case ENTITY:
			case GOAL:
			case MESSAGE:
			case ID:
				_localctx = new VarNameContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(547); ((VarNameContext)_localctx).varName = varID();
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

	public static class VarIDContext extends ParserRuleContext {
		public TerminalNode GOAL() { return getToken(FP4GParser.GOAL, 0); }
		public TerminalNode GAME() { return getToken(FP4GParser.GAME, 0); }
		public TerminalNode STATE() { return getToken(FP4GParser.STATE, 0); }
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public TerminalNode BEHAVIOR() { return getToken(FP4GParser.BEHAVIOR, 0); }
		public TerminalNode MANAGER() { return getToken(FP4GParser.MANAGER, 0); }
		public TerminalNode ENTITY() { return getToken(FP4GParser.ENTITY, 0); }
		public TerminalNode ASSET() { return getToken(FP4GParser.ASSET, 0); }
		public TerminalNode MESSAGE() { return getToken(FP4GParser.MESSAGE, 0); }
		public VarIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varID; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitVarID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarIDContext varID() throws RecognitionException {
		VarIDContext _localctx = new VarIDContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_varID);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(550);
			_la = _input.LA(1);
			if ( !(((((_la - 20)) & ~0x3f) == 0 && ((1L << (_la - 20)) & ((1L << (MANAGER - 20)) | (1L << (GAME - 20)) | (1L << (STATE - 20)) | (1L << (ASSET - 20)) | (1L << (BEHAVIOR - 20)) | (1L << (ENTITY - 20)) | (1L << (GOAL - 20)) | (1L << (MESSAGE - 20)) | (1L << (ID - 20)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
		enterRule(_localctx, 90, RULE_array);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(552); arrayBody();
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
		enterRule(_localctx, 92, RULE_arrayBody);
		int _la;
		try {
			int _alt;
			setState(594);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				_localctx = new AssocArrayContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(554); match(ABRE_LLAV);
				{
				setState(555); parArray();
				setState(560);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(556); match(COMA);
						setState(557); parArray();
						}
						} 
					}
					setState(562);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
				}
				setState(564);
				_la = _input.LA(1);
				if (_la==COMA) {
					{
					setState(563); match(COMA);
					}
				}

				}
				setState(566); match(CIERRA_LLAV);
				setState(570);
				switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
				case 1:
					{
					setState(567); match(AS);
					setState(568); ((AssocArrayContext)_localctx).ID = match(ID);
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
				setState(572); match(ABRE_LLAV);
				{
				setState(573); itemArray();
				setState(578);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(574); match(COMA);
						setState(575); itemArray();
						}
						} 
					}
					setState(580);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
				}
				setState(582);
				_la = _input.LA(1);
				if (_la==COMA) {
					{
					setState(581); match(COMA);
					}
				}

				}
				setState(584); match(CIERRA_LLAV);
				setState(588);
				switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
				case 1:
					{
					setState(585); match(AS);
					setState(586); ((ListArrayContext)_localctx).ID = match(ID);
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
				setState(590); match(EMPTY);
				setState(591); match(AS);
				setState(592); ((EmptyArrayContext)_localctx).ID = match(ID);
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
		enterRule(_localctx, 94, RULE_itemArray);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(596); expr(0);
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
		enterRule(_localctx, 96, RULE_parArray);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(598); ((ParArrayContext)_localctx).ID = match(ID);
			 ((ParArrayContext)_localctx).key =  (((ParArrayContext)_localctx).ID!=null?((ParArrayContext)_localctx).ID.getText():null); 
			setState(600); match(EQUAL);
			setState(601); expr(0);
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
		case 0: return 16 >= _localctx._p;

		case 1: return 15 >= _localctx._p;

		case 2: return 14 >= _localctx._p;

		case 3: return 11 >= _localctx._p;

		case 4: return 10 >= _localctx._p;

		case 5: return 9 >= _localctx._p;

		case 6: return 8 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3H\u025e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\3\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\4\7\4n\n\4\f\4\16\4q\13\4\3\5\3\5\7\5u\n\5\f\5\16\5x"+
		"\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6"+
		"\u0089\n\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u0091\n\6\3\7\7\7\u0094\n\7\f\7"+
		"\16\7\u0097\13\7\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u009f\n\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\n\3\n\7\n\u00ab\n\n\f\n\16\n\u00ae\13\n\3\13\7\13\u00b1"+
		"\n\13\f\13\16\13\u00b4\13\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\5\f\u00c6\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00d8\n\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\5\20\u00e0\n\20\3\21\3\21\3\21\5\21\u00e5\n\21\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00f1\n\22\3\22\3\22"+
		"\3\22\3\22\5\22\u00f7\n\22\3\22\5\22\u00fa\n\22\3\22\5\22\u00fd\n\22\3"+
		"\23\3\23\3\23\3\23\5\23\u0103\n\23\3\23\3\23\5\23\u0107\n\23\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\5\24\u011a\n\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0122\n\24\3"+
		"\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\5\25\u012d\n\25\3\25\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\7\26\u0136\n\26\f\26\16\26\u0139\13\26\3\27"+
		"\3\27\3\27\3\27\3\27\5\27\u0140\n\27\3\30\3\30\3\30\3\30\3\31\3\31\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\5\32\u014e\n\32\3\32\5\32\u0151\n\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\5\32\u015a\n\32\3\32\5\32\u015d\n\32\3\33"+
		"\3\33\7\33\u0161\n\33\f\33\16\33\u0164\13\33\3\34\3\34\3\34\3\34\5\34"+
		"\u016a\n\34\3\34\5\34\u016d\n\34\3\35\7\35\u0170\n\35\f\35\16\35\u0173"+
		"\13\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\5\36\u0183\n\36\3\37\3\37\3\37\7\37\u0188\n\37\f\37\16\37\u018b"+
		"\13\37\3 \3 \3 \7 \u0190\n \f \16 \u0193\13 \3!\3!\3!\3!\5!\u0199\n!\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u01aa\n"+
		"\"\3#\3#\3#\5#\u01af\n#\3#\3#\3#\3$\3$\3$\3$\3$\7$\u01b9\n$\f$\16$\u01bc"+
		"\13$\3$\5$\u01bf\n$\3$\3$\3%\3%\5%\u01c5\n%\3&\3&\5&\u01c9\n&\3&\3&\3"+
		"&\5&\u01ce\n&\3\'\3\'\3\'\3\'\7\'\u01d4\n\'\f\'\16\'\u01d7\13\'\3\'\5"+
		"\'\u01da\n\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3"+
		"*\3*\3*\3*\3*\3*\3*\3*\3*\3*\5*\u01f8\n*\3*\3*\5*\u01fc\n*\3*\3*\3*\3"+
		"*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\7*\u0213\n*\f*\16"+
		"*\u0216\13*\3+\3+\3+\3+\3+\5+\u021d\n+\3,\3,\3,\3,\5,\u0223\n,\3-\3-\5"+
		"-\u0227\n-\3.\3.\3/\3/\3\60\3\60\3\60\3\60\7\60\u0231\n\60\f\60\16\60"+
		"\u0234\13\60\3\60\5\60\u0237\n\60\3\60\3\60\3\60\3\60\5\60\u023d\n\60"+
		"\3\60\3\60\3\60\3\60\7\60\u0243\n\60\f\60\16\60\u0246\13\60\3\60\5\60"+
		"\u0249\n\60\3\60\3\60\3\60\3\60\5\60\u024f\n\60\3\60\3\60\3\60\3\60\5"+
		"\60\u0255\n\60\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\2\63\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\"+
		"^`b\2\3\4\2\26\35FF\u0296\2d\3\2\2\2\4h\3\2\2\2\6o\3\2\2\2\bv\3\2\2\2"+
		"\ny\3\2\2\2\f\u0095\3\2\2\2\16\u009e\3\2\2\2\20\u00a0\3\2\2\2\22\u00ac"+
		"\3\2\2\2\24\u00b2\3\2\2\2\26\u00c5\3\2\2\2\30\u00c7\3\2\2\2\32\u00cd\3"+
		"\2\2\2\34\u00d1\3\2\2\2\36\u00d9\3\2\2\2 \u00e1\3\2\2\2\"\u00f0\3\2\2"+
		"\2$\u00fe\3\2\2\2&\u0108\3\2\2\2(\u0127\3\2\2\2*\u0137\3\2\2\2,\u013f"+
		"\3\2\2\2.\u0141\3\2\2\2\60\u0145\3\2\2\2\62\u0147\3\2\2\2\64\u015e\3\2"+
		"\2\2\66\u0165\3\2\2\28\u0171\3\2\2\2:\u0182\3\2\2\2<\u0184\3\2\2\2>\u018c"+
		"\3\2\2\2@\u0194\3\2\2\2B\u01a9\3\2\2\2D\u01ae\3\2\2\2F\u01b3\3\2\2\2H"+
		"\u01c2\3\2\2\2J\u01c6\3\2\2\2L\u01cf\3\2\2\2N\u01dd\3\2\2\2P\u01e0\3\2"+
		"\2\2R\u01fb\3\2\2\2T\u021c\3\2\2\2V\u0222\3\2\2\2X\u0226\3\2\2\2Z\u0228"+
		"\3\2\2\2\\\u022a\3\2\2\2^\u0254\3\2\2\2`\u0256\3\2\2\2b\u0258\3\2\2\2"+
		"de\5\6\4\2ef\5\b\5\2fg\7\2\2\3g\3\3\2\2\2hi\5\6\4\2ij\5\22\n\2jk\7\2\2"+
		"\3k\5\3\2\2\2ln\5\n\6\2ml\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2p\7\3\2"+
		"\2\2qo\3\2\2\2ru\5\20\t\2su\5&\24\2tr\3\2\2\2ts\3\2\2\2ux\3\2\2\2vt\3"+
		"\2\2\2vw\3\2\2\2w\t\3\2\2\2xv\3\2\2\2y\u0088\7\17\2\2z{\7\26\2\2{\u0089"+
		"\b\6\1\2|}\7\30\2\2}\u0089\b\6\1\2~\177\7\32\2\2\177\u0089\b\6\1\2\u0080"+
		"\u0081\7\33\2\2\u0081\u0089\b\6\1\2\u0082\u0083\7\34\2\2\u0083\u0089\b"+
		"\6\1\2\u0084\u0085\7\35\2\2\u0085\u0089\b\6\1\2\u0086\u0087\7F\2\2\u0087"+
		"\u0089\b\6\1\2\u0088z\3\2\2\2\u0088|\3\2\2\2\u0088~\3\2\2\2\u0088\u0080"+
		"\3\2\2\2\u0088\u0082\3\2\2\2\u0088\u0084\3\2\2\2\u0088\u0086\3\2\2\2\u0089"+
		"\u008a\3\2\2\2\u008a\u0090\7F\2\2\u008b\u0091\7.\2\2\u008c\u008d\7%\2"+
		"\2\u008d\u008e\5\f\7\2\u008e\u008f\7(\2\2\u008f\u0091\3\2\2\2\u0090\u008b"+
		"\3\2\2\2\u0090\u008c\3\2\2\2\u0091\13\3\2\2\2\u0092\u0094\5\16\b\2\u0093"+
		"\u0092\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2"+
		"\2\2\u0096\r\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u0099\5 \21\2\u0099\u009a"+
		"\7.\2\2\u009a\u009f\3\2\2\2\u009b\u009c\5\30\r\2\u009c\u009d\7.\2\2\u009d"+
		"\u009f\3\2\2\2\u009e\u0098\3\2\2\2\u009e\u009b\3\2\2\2\u009f\17\3\2\2"+
		"\2\u00a0\u00a1\7\5\2\2\u00a1\u00a2\7\27\2\2\u00a2\u00a3\7F\2\2\u00a3\u00a4"+
		"\b\t\1\2\u00a4\u00a5\7%\2\2\u00a5\u00a6\5\24\13\2\u00a6\u00a7\7(\2\2\u00a7"+
		"\21\3\2\2\2\u00a8\u00ab\5\26\f\2\u00a9\u00ab\5&\24\2\u00aa\u00a8\3\2\2"+
		"\2\u00aa\u00a9\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad"+
		"\3\2\2\2\u00ad\23\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b1\5\26\f\2\u00b0"+
		"\u00af\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2"+
		"\2\2\u00b3\25\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b6\5 \21\2\u00b6\u00b7"+
		"\7.\2\2\u00b7\u00c6\3\2\2\2\u00b8\u00b9\5\30\r\2\u00b9\u00ba\7.\2\2\u00ba"+
		"\u00c6\3\2\2\2\u00bb\u00bc\5\32\16\2\u00bc\u00bd\7.\2\2\u00bd\u00c6\3"+
		"\2\2\2\u00be\u00bf\5P)\2\u00bf\u00c0\7.\2\2\u00c0\u00c6\3\2\2\2\u00c1"+
		"\u00c6\5(\25\2\u00c2\u00c3\5N(\2\u00c3\u00c4\7.\2\2\u00c4\u00c6\3\2\2"+
		"\2\u00c5\u00b5\3\2\2\2\u00c5\u00b8\3\2\2\2\u00c5\u00bb\3\2\2\2\u00c5\u00be"+
		"\3\2\2\2\u00c5\u00c1\3\2\2\2\u00c5\u00c2\3\2\2\2\u00c6\27\3\2\2\2\u00c7"+
		"\u00c8\7\21\2\2\u00c8\u00c9\7F\2\2\u00c9\u00ca\b\r\1\2\u00ca\u00cb\7,"+
		"\2\2\u00cb\u00cc\5R*\2\u00cc\31\3\2\2\2\u00cd\u00ce\7\22\2\2\u00ce\u00cf"+
		"\7F\2\2\u00cf\u00d0\b\16\1\2\u00d0\33\3\2\2\2\u00d1\u00d2\7\13\2\2\u00d2"+
		"\u00d3\7F\2\2\u00d3\u00d4\7\7\2\2\u00d4\u00d7\7F\2\2\u00d5\u00d6\7/\2"+
		"\2\u00d6\u00d8\7F\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\35"+
		"\3\2\2\2\u00d9\u00da\7\f\2\2\u00da\u00db\7F\2\2\u00db\u00dc\7\7\2\2\u00dc"+
		"\u00df\7F\2\2\u00dd\u00de\7/\2\2\u00de\u00e0\7F\2\2\u00df\u00dd\3\2\2"+
		"\2\u00df\u00e0\3\2\2\2\u00e0\37\3\2\2\2\u00e1\u00e4\7\6\2\2\u00e2\u00e5"+
		"\5\"\22\2\u00e3\u00e5\5$\23\2\u00e4\u00e2\3\2\2\2\u00e4\u00e3\3\2\2\2"+
		"\u00e5!\3\2\2\2\u00e6\u00e7\7\26\2\2\u00e7\u00f1\b\22\1\2\u00e8\u00e9"+
		"\7\30\2\2\u00e9\u00f1\b\22\1\2\u00ea\u00eb\7\32\2\2\u00eb\u00f1\b\22\1"+
		"\2\u00ec\u00ed\7\33\2\2\u00ed\u00f1\b\22\1\2\u00ee\u00ef\7\34\2\2\u00ef"+
		"\u00f1\b\22\1\2\u00f0\u00e6\3\2\2\2\u00f0\u00e8\3\2\2\2\u00f0\u00ea\3"+
		"\2\2\2\u00f0\u00ec\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2"+
		"\u00f3\7F\2\2\u00f3\u00f9\b\22\1\2\u00f4\u00f6\7&\2\2\u00f5\u00f7\5<\37"+
		"\2\u00f6\u00f5\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00fa"+
		"\7)\2\2\u00f9\u00f4\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fc\3\2\2\2\u00fb"+
		"\u00fd\5\\/\2\u00fc\u00fb\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd#\3\2\2\2\u00fe"+
		"\u00ff\7F\2\2\u00ff\u0100\b\23\1\2\u0100\u0102\7&\2\2\u0101\u0103\5> "+
		"\2\u0102\u0101\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0106"+
		"\7)\2\2\u0105\u0107\5\\/\2\u0106\u0105\3\2\2\2\u0106\u0107\3\2\2\2\u0107"+
		"%\3\2\2\2\u0108\u0119\7\5\2\2\u0109\u010a\7\26\2\2\u010a\u011a\b\24\1"+
		"\2\u010b\u010c\7\30\2\2\u010c\u011a\b\24\1\2\u010d\u010e\7\32\2\2\u010e"+
		"\u011a\b\24\1\2\u010f\u0110\7\33\2\2\u0110\u011a\b\24\1\2\u0111\u0112"+
		"\7\34\2\2\u0112\u011a\b\24\1\2\u0113\u0114\7\35\2\2\u0114\u011a\b\24\1"+
		"\2\u0115\u0116\7\31\2\2\u0116\u011a\b\24\1\2\u0117\u0118\7F\2\2\u0118"+
		"\u011a\b\24\1\2\u0119\u0109\3\2\2\2\u0119\u010b\3\2\2\2\u0119\u010d\3"+
		"\2\2\2\u0119\u010f\3\2\2\2\u0119\u0111\3\2\2\2\u0119\u0113\3\2\2\2\u0119"+
		"\u0115\3\2\2\2\u0119\u0117\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011c\7F"+
		"\2\2\u011c\u0121\b\24\1\2\u011d\u011e\7&\2\2\u011e\u011f\5> \2\u011f\u0120"+
		"\7)\2\2\u0120\u0122\3\2\2\2\u0121\u011d\3\2\2\2\u0121\u0122\3\2\2\2\u0122"+
		"\u0123\3\2\2\2\u0123\u0124\7%\2\2\u0124\u0125\58\35\2\u0125\u0126\7(\2"+
		"\2\u0126\'\3\2\2\2\u0127\u0128\7\7\2\2\u0128\u0129\7F\2\2\u0129\u012c"+
		"\b\25\1\2\u012a\u012b\7/\2\2\u012b\u012d\5\64\33\2\u012c\u012a\3\2\2\2"+
		"\u012c\u012d\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u012f\7%\2\2\u012f\u0130"+
		"\5*\26\2\u0130\u0131\7(\2\2\u0131)\3\2\2\2\u0132\u0133\5,\27\2\u0133\u0134"+
		"\7.\2\2\u0134\u0136\3\2\2\2\u0135\u0132\3\2\2\2\u0136\u0139\3\2\2\2\u0137"+
		"\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138+\3\2\2\2\u0139\u0137\3\2\2\2"+
		"\u013a\u0140\5\62\32\2\u013b\u0140\5\60\31\2\u013c\u0140\5\34\17\2\u013d"+
		"\u0140\5\36\20\2\u013e\u0140\5.\30\2\u013f\u013a\3\2\2\2\u013f\u013b\3"+
		"\2\2\2\u013f\u013c\3\2\2\2\u013f\u013d\3\2\2\2\u013f\u013e\3\2\2\2\u0140"+
		"-\3\2\2\2\u0141\u0142\7F\2\2\u0142\u0143\7,\2\2\u0143\u0144\5R*\2\u0144"+
		"/\3\2\2\2\u0145\u0146\7\t\2\2\u0146\61\3\2\2\2\u0147\u0148\b\32\1\2\u0148"+
		"\u0149\7\b\2\2\u0149\u014a\7F\2\2\u014a\u0150\b\32\1\2\u014b\u014d\7&"+
		"\2\2\u014c\u014e\5<\37\2\u014d\u014c\3\2\2\2\u014d\u014e\3\2\2\2\u014e"+
		"\u014f\3\2\2\2\u014f\u0151\7)\2\2\u0150\u014b\3\2\2\2\u0150\u0151\3\2"+
		"\2\2\u0151\u015c\3\2\2\2\u0152\u0159\7\37\2\2\u0153\u0154\7\"\2\2\u0154"+
		"\u015a\b\32\1\2\u0155\u0156\7\27\2\2\u0156\u015a\b\32\1\2\u0157\u0158"+
		"\7F\2\2\u0158\u015a\b\32\1\2\u0159\u0153\3\2\2\2\u0159\u0155\3\2\2\2\u0159"+
		"\u0157\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u015d\b\32\1\2\u015c\u0152\3"+
		"\2\2\2\u015c\u015d\3\2\2\2\u015d\63\3\2\2\2\u015e\u0162\5\66\34\2\u015f"+
		"\u0161\5\66\34\2\u0160\u015f\3\2\2\2\u0161\u0164\3\2\2\2\u0162\u0160\3"+
		"\2\2\2\u0162\u0163\3\2\2\2\u0163\65\3\2\2\2\u0164\u0162\3\2\2\2\u0165"+
		"\u0166\7F\2\2\u0166\u016c\b\34\1\2\u0167\u0169\7&\2\2\u0168\u016a\5<\37"+
		"\2\u0169\u0168\3\2\2\2\u0169\u016a\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u016d"+
		"\7)\2\2\u016c\u0167\3\2\2\2\u016c\u016d\3\2\2\2\u016d\67\3\2\2\2\u016e"+
		"\u0170\5:\36\2\u016f\u016e\3\2\2\2\u0170\u0173\3\2\2\2\u0171\u016f\3\2"+
		"\2\2\u0171\u0172\3\2\2\2\u01729\3\2\2\2\u0173\u0171\3\2\2\2\u0174\u0175"+
		"\5 \21\2\u0175\u0176\7.\2\2\u0176\u0183\3\2\2\2\u0177\u0178\5\30\r\2\u0178"+
		"\u0179\7.\2\2\u0179\u0183\3\2\2\2\u017a\u017b\5N(\2\u017b\u017c\7.\2\2"+
		"\u017c\u0183\3\2\2\2\u017d\u017e\5P)\2\u017e\u017f\7.\2\2\u017f\u0183"+
		"\3\2\2\2\u0180\u0183\5(\25\2\u0181\u0183\5F$\2\u0182\u0174\3\2\2\2\u0182"+
		"\u0177\3\2\2\2\u0182\u017a\3\2\2\2\u0182\u017d\3\2\2\2\u0182\u0180\3\2"+
		"\2\2\u0182\u0181\3\2\2\2\u0183;\3\2\2\2\u0184\u0189\5R*\2\u0185\u0186"+
		"\7+\2\2\u0186\u0188\5R*\2\u0187\u0185\3\2\2\2\u0188\u018b\3\2\2\2\u0189"+
		"\u0187\3\2\2\2\u0189\u018a\3\2\2\2\u018a=\3\2\2\2\u018b\u0189\3\2\2\2"+
		"\u018c\u0191\5@!\2\u018d\u018e\7+\2\2\u018e\u0190\5@!\2\u018f\u018d\3"+
		"\2\2\2\u0190\u0193\3\2\2\2\u0191\u018f\3\2\2\2\u0191\u0192\3\2\2\2\u0192"+
		"?\3\2\2\2\u0193\u0191\3\2\2\2\u0194\u0195\5B\"\2\u0195\u0198\7F\2\2\u0196"+
		"\u0197\7,\2\2\u0197\u0199\5R*\2\u0198\u0196\3\2\2\2\u0198\u0199\3\2\2"+
		"\2\u0199A\3\2\2\2\u019a\u019b\7:\2\2\u019b\u01aa\b\"\1\2\u019c\u019d\7"+
		"<\2\2\u019d\u01aa\b\"\1\2\u019e\u019f\7;\2\2\u019f\u01aa\b\"\1\2\u01a0"+
		"\u01a1\7=\2\2\u01a1\u01aa\b\"\1\2\u01a2\u01a3\7>\2\2\u01a3\u01aa\b\"\1"+
		"\2\u01a4\u01a5\7?\2\2\u01a5\u01aa\b\"\1\2\u01a6\u01a7\5D#\2\u01a7\u01a8"+
		"\b\"\1\2\u01a8\u01aa\3\2\2\2\u01a9\u019a\3\2\2\2\u01a9\u019c\3\2\2\2\u01a9"+
		"\u019e\3\2\2\2\u01a9\u01a0\3\2\2\2\u01a9\u01a2\3\2\2\2\u01a9\u01a4\3\2"+
		"\2\2\u01a9\u01a6\3\2\2\2\u01aaC\3\2\2\2\u01ab\u01ac\7F\2\2\u01ac\u01ad"+
		"\7/\2\2\u01ad\u01af\b#\1\2\u01ae\u01ab\3\2\2\2\u01ae\u01af\3\2\2\2\u01af"+
		"\u01b0\3\2\2\2\u01b0\u01b1\7F\2\2\u01b1\u01b2\b#\1\2\u01b2E\3\2\2\2\u01b3"+
		"\u01b4\7\23\2\2\u01b4\u01b5\7%\2\2\u01b5\u01ba\5H%\2\u01b6\u01b7\7+\2"+
		"\2\u01b7\u01b9\5H%\2\u01b8\u01b6\3\2\2\2\u01b9\u01bc\3\2\2\2\u01ba\u01b8"+
		"\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01be\3\2\2\2\u01bc\u01ba\3\2\2\2\u01bd"+
		"\u01bf\7+\2\2\u01be\u01bd\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf\u01c0\3\2"+
		"\2\2\u01c0\u01c1\7(\2\2\u01c1G\3\2\2\2\u01c2\u01c4\5J&\2\u01c3\u01c5\5"+
		"L\'\2\u01c4\u01c3\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5I\3\2\2\2\u01c6\u01c8"+
		"\7F\2\2\u01c7\u01c9\7F\2\2\u01c8\u01c7\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9"+
		"\u01ca\3\2\2\2\u01ca\u01cb\7/\2\2\u01cb\u01cd\7C\2\2\u01cc\u01ce\5\\/"+
		"\2\u01cd\u01cc\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ceK\3\2\2\2\u01cf\u01d0"+
		"\7%\2\2\u01d0\u01d5\5J&\2\u01d1\u01d2\7+\2\2\u01d2\u01d4\5J&\2\u01d3\u01d1"+
		"\3\2\2\2\u01d4\u01d7\3\2\2\2\u01d5\u01d3\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6"+
		"\u01d9\3\2\2\2\u01d7\u01d5\3\2\2\2\u01d8\u01da\7+\2\2\u01d9\u01d8\3\2"+
		"\2\2\u01d9\u01da\3\2\2\2\u01da\u01db\3\2\2\2\u01db\u01dc\7(\2\2\u01dc"+
		"M\3\2\2\2\u01dd\u01de\7\24\2\2\u01de\u01df\5@!\2\u01dfO\3\2\2\2\u01e0"+
		"\u01e1\7\25\2\2\u01e1\u01e2\5R*\2\u01e2\u01e3\7$\2\2\u01e3\u01e4\5,\27"+
		"\2\u01e4Q\3\2\2\2\u01e5\u01e6\b*\1\2\u01e6\u01e7\79\2\2\u01e7\u01fc\5"+
		"R*\2\u01e8\u01e9\7\61\2\2\u01e9\u01fc\5R*\2\u01ea\u01fc\5\\/\2\u01eb\u01ec"+
		"\7&\2\2\u01ec\u01ed\5R*\2\u01ed\u01ee\7)\2\2\u01ee\u01fc\3\2\2\2\u01ef"+
		"\u01fc\7A\2\2\u01f0\u01fc\7B\2\2\u01f1\u01fc\7C\2\2\u01f2\u01fc\7D\2\2"+
		"\u01f3\u01fc\7@\2\2\u01f4\u01f5\7F\2\2\u01f5\u01f7\7&\2\2\u01f6\u01f8"+
		"\5<\37\2\u01f7\u01f6\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f9"+
		"\u01fc\7)\2\2\u01fa\u01fc\5T+\2\u01fb\u01e5\3\2\2\2\u01fb\u01e8\3\2\2"+
		"\2\u01fb\u01ea\3\2\2\2\u01fb\u01eb\3\2\2\2\u01fb\u01ef\3\2\2\2\u01fb\u01f0"+
		"\3\2\2\2\u01fb\u01f1\3\2\2\2\u01fb\u01f2\3\2\2\2\u01fb\u01f3\3\2\2\2\u01fb"+
		"\u01f4\3\2\2\2\u01fb\u01fa\3\2\2\2\u01fc\u0214\3\2\2\2\u01fd\u01fe\6*"+
		"\2\3\u01fe\u01ff\7\65\2\2\u01ff\u0213\5R*\2\u0200\u0201\6*\3\3\u0201\u0202"+
		"\7\64\2\2\u0202\u0213\5R*\2\u0203\u0204\6*\4\3\u0204\u0205\7,\2\2\u0205"+
		"\u0213\5R*\2\u0206\u0207\6*\5\3\u0207\u0208\7\62\2\2\u0208\u0213\5R*\2"+
		"\u0209\u020a\6*\6\3\u020a\u020b\7\63\2\2\u020b\u0213\5R*\2\u020c\u020d"+
		"\6*\7\3\u020d\u020e\7\60\2\2\u020e\u0213\5R*\2\u020f\u0210\6*\b\3\u0210"+
		"\u0211\7\61\2\2\u0211\u0213\5R*\2\u0212\u01fd\3\2\2\2\u0212\u0200\3\2"+
		"\2\2\u0212\u0203\3\2\2\2\u0212\u0206\3\2\2\2\u0212\u0209\3\2\2\2\u0212"+
		"\u020c\3\2\2\2\u0212\u020f\3\2\2\2\u0213\u0216\3\2\2\2\u0214\u0212\3\2"+
		"\2\2\u0214\u0215\3\2\2\2\u0215S\3\2\2\2\u0216\u0214\3\2\2\2\u0217\u021d"+
		"\5X-\2\u0218\u0219\5V,\2\u0219\u021a\7-\2\2\u021a\u021b\5T+\2\u021b\u021d"+
		"\3\2\2\2\u021c\u0217\3\2\2\2\u021c\u0218\3\2\2\2\u021dU\3\2\2\2\u021e"+
		"\u0223\7E\2\2\u021f\u0220\5Z.\2\u0220\u0221\b,\1\2\u0221\u0223\3\2\2\2"+
		"\u0222\u021e\3\2\2\2\u0222\u021f\3\2\2\2\u0223W\3\2\2\2\u0224\u0227\7"+
		"E\2\2\u0225\u0227\5Z.\2\u0226\u0224\3\2\2\2\u0226\u0225\3\2\2\2\u0227"+
		"Y\3\2\2\2\u0228\u0229\t\2\2\2\u0229[\3\2\2\2\u022a\u022b\5^\60\2\u022b"+
		"]\3\2\2\2\u022c\u022d\7\'\2\2\u022d\u0232\5b\62\2\u022e\u022f\7+\2\2\u022f"+
		"\u0231\5b\62\2\u0230\u022e\3\2\2\2\u0231\u0234\3\2\2\2\u0232\u0230\3\2"+
		"\2\2\u0232\u0233\3\2\2\2\u0233\u0236\3\2\2\2\u0234\u0232\3\2\2\2\u0235"+
		"\u0237\7+\2\2\u0236\u0235\3\2\2\2\u0236\u0237\3\2\2\2\u0237\u0238\3\2"+
		"\2\2\u0238\u023c\7*\2\2\u0239\u023a\7!\2\2\u023a\u023b\7F\2\2\u023b\u023d"+
		"\b\60\1\2\u023c\u0239\3\2\2\2\u023c\u023d\3\2\2\2\u023d\u0255\3\2\2\2"+
		"\u023e\u023f\7\'\2\2\u023f\u0244\5`\61\2\u0240\u0241\7+\2\2\u0241\u0243"+
		"\5`\61\2\u0242\u0240\3\2\2\2\u0243\u0246\3\2\2\2\u0244\u0242\3\2\2\2\u0244"+
		"\u0245\3\2\2\2\u0245\u0248\3\2\2\2\u0246\u0244\3\2\2\2\u0247\u0249\7+"+
		"\2\2\u0248\u0247\3\2\2\2\u0248\u0249\3\2\2\2\u0249\u024a\3\2\2\2\u024a"+
		"\u024e\7*\2\2\u024b\u024c\7!\2\2\u024c\u024d\7F\2\2\u024d\u024f\b\60\1"+
		"\2\u024e\u024b\3\2\2\2\u024e\u024f\3\2\2\2\u024f\u0255\3\2\2\2\u0250\u0251"+
		"\7#\2\2\u0251\u0252\7!\2\2\u0252\u0253\7F\2\2\u0253\u0255\b\60\1\2\u0254"+
		"\u022c\3\2\2\2\u0254\u023e\3\2\2\2\u0254\u0250\3\2\2\2\u0255_\3\2\2\2"+
		"\u0256\u0257\5R*\2\u0257a\3\2\2\2\u0258\u0259\7F\2\2\u0259\u025a\b\62"+
		"\1\2\u025a\u025b\7,\2\2\u025b\u025c\5R*\2\u025cc\3\2\2\2>otv\u0088\u0090"+
		"\u0095\u009e\u00aa\u00ac\u00b2\u00c5\u00d7\u00df\u00e4\u00f0\u00f6\u00f9"+
		"\u00fc\u0102\u0106\u0119\u0121\u012c\u0137\u013f\u014d\u0150\u0159\u015c"+
		"\u0162\u0169\u016c\u0171\u0182\u0189\u0191\u0198\u01a9\u01ae\u01ba\u01be"+
		"\u01c4\u01c8\u01cd\u01d5\u01d9\u01f7\u01fb\u0212\u0214\u021c\u0222\u0226"+
		"\u0232\u0236\u023c\u0244\u0248\u024e\u0254";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}