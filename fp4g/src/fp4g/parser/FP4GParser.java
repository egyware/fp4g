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
		RULE_program = 0, RULE_usings = 1, RULE_using = 2, RULE_usingValues = 3, 
		RULE_usingValue = 4, RULE_game = 5, RULE_gameLib = 6, RULE_gameValues = 7, 
		RULE_gameValue = 8, RULE_set = 9, RULE_start = 10, RULE_subscribe = 11, 
		RULE_unsubscribe = 12, RULE_add = 13, RULE_addDefine = 14, RULE_addMethod = 15, 
		RULE_define = 16, RULE_on = 17, RULE_statements = 18, RULE_statement = 19, 
		RULE_assign = 20, RULE_destroy = 21, RULE_send = 22, RULE_onFilters = 23, 
		RULE_filter = 24, RULE_defineValues = 25, RULE_defineValue = 26, RULE_exprList = 27, 
		RULE_nameList = 28, RULE_declareVar = 29, RULE_varType = 30, RULE_defineID = 31, 
		RULE_assets = 32, RULE_assetValueWithInnerValue = 33, RULE_assetValue = 34, 
		RULE_assetValuesInner = 35, RULE_flag = 36, RULE_when = 37, RULE_expr = 38, 
		RULE_accessVarOp = 39, RULE_parentVarOp = 40, RULE_varOp = 41, RULE_varID = 42, 
		RULE_array = 43, RULE_arrayBody = 44, RULE_itemArray = 45, RULE_parArray = 46;
	public static final String[] ruleNames = {
		"program", "usings", "using", "usingValues", "usingValue", "game", "gameLib", 
		"gameValues", "gameValue", "set", "start", "subscribe", "unsubscribe", 
		"add", "addDefine", "addMethod", "define", "on", "statements", "statement", 
		"assign", "destroy", "send", "onFilters", "filter", "defineValues", "defineValue", 
		"exprList", "nameList", "declareVar", "varType", "defineID", "assets", 
		"assetValueWithInnerValue", "assetValue", "assetValuesInner", "flag", 
		"when", "expr", "accessVarOp", "parentVarOp", "varOp", "varID", "array", 
		"arrayBody", "itemArray", "parArray"
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
		public UsingsContext usings() {
			return getRuleContext(UsingsContext.class,0);
		}
		public GameContext game() {
			return getRuleContext(GameContext.class,0);
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
			setState(94); usings();
			setState(95); game();
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
		enterRule(_localctx, 2, RULE_usings);
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
		enterRule(_localctx, 4, RULE_using);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104); match(USING);
			setState(119);
			switch (_input.LA(1)) {
			case MANAGER:
				{
				setState(105); match(MANAGER);
				 ((UsingContext)_localctx).type =  DefineType.MANAGER; 
				}
				break;
			case STATE:
				{
				setState(107); match(STATE);
				 ((UsingContext)_localctx).type =  DefineType.STATE;   
				}
				break;
			case BEHAVIOR:
				{
				setState(109); match(BEHAVIOR);
				 ((UsingContext)_localctx).type =  DefineType.BEHAVIOR;
				}
				break;
			case ENTITY:
				{
				setState(111); match(ENTITY);
				 ((UsingContext)_localctx).type =  DefineType.ENTITY;  
				}
				break;
			case GOAL:
				{
				setState(113); match(GOAL);
				 ((UsingContext)_localctx).type =  DefineType.GOAL;    
				}
				break;
			case MESSAGE:
				{
				setState(115); match(MESSAGE);
				 ((UsingContext)_localctx).type =  DefineType.MESSAGE; 
				}
				break;
			case ID:
				{
				setState(117); ((UsingContext)_localctx).ID = match(ID);
				 ((UsingContext)_localctx).type =  DefineType.valueOf((((UsingContext)_localctx).ID!=null?((UsingContext)_localctx).ID.getText():null));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(121); ((UsingContext)_localctx).name = match(ID);
			setState(127);
			switch (_input.LA(1)) {
			case DOTCOMA:
				{
				setState(122); match(DOTCOMA);
				}
				break;
			case ABRE_COR:
				{
				setState(123); match(ABRE_COR);
				setState(124); usingValues();
				setState(125); match(CIERRA_COR);
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
		enterRule(_localctx, 6, RULE_usingValues);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD || _la==SET) {
				{
				{
				setState(129); usingValue();
				}
				}
				setState(134);
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
		enterRule(_localctx, 8, RULE_usingValue);
		try {
			setState(141);
			switch (_input.LA(1)) {
			case ADD:
				enterOuterAlt(_localctx, 1);
				{
				setState(135); add();
				setState(136); match(DOTCOMA);
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 2);
				{
				setState(138); set();
				setState(139); match(DOTCOMA);
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
		enterRule(_localctx, 10, RULE_game);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143); match(DEFINE);
			setState(144); match(GAME);
			setState(145); ((GameContext)_localctx).ID = match(ID);
			 ((GameContext)_localctx).name =  (((GameContext)_localctx).ID!=null?((GameContext)_localctx).ID.getText():null); 
			setState(147); match(ABRE_COR);
			setState(148); gameValues();
			setState(149); match(CIERRA_COR);
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
		public TerminalNode ABRE_COR() { return getToken(FP4GParser.ABRE_COR, 0); }
		public TerminalNode GAME() { return getToken(FP4GParser.GAME, 0); }
		public TerminalNode DEFINE() { return getToken(FP4GParser.DEFINE, 0); }
		public TerminalNode CIERRA_COR() { return getToken(FP4GParser.CIERRA_COR, 0); }
		public GameValuesContext gameValues() {
			return getRuleContext(GameValuesContext.class,0);
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
		enterRule(_localctx, 12, RULE_gameLib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151); match(DEFINE);
			setState(152); match(GAME);
			setState(153); match(ABRE_COR);
			setState(154); gameValues();
			setState(155); match(CIERRA_COR);
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
		enterRule(_localctx, 14, RULE_gameValues);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << ON) | (1L << SET) | (1L << START) | (1L << FLAG) | (1L << WHEN))) != 0)) {
				{
				{
				setState(157); gameValue();
				}
				}
				setState(162);
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
		enterRule(_localctx, 16, RULE_gameValue);
		try {
			setState(179);
			switch (_input.LA(1)) {
			case ADD:
				enterOuterAlt(_localctx, 1);
				{
				setState(163); add();
				setState(164); match(DOTCOMA);
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 2);
				{
				setState(166); set();
				setState(167); match(DOTCOMA);
				}
				break;
			case START:
				enterOuterAlt(_localctx, 3);
				{
				setState(169); start();
				setState(170); match(DOTCOMA);
				}
				break;
			case WHEN:
				enterOuterAlt(_localctx, 4);
				{
				setState(172); when();
				setState(173); match(DOTCOMA);
				}
				break;
			case ON:
				enterOuterAlt(_localctx, 5);
				{
				setState(175); on();
				}
				break;
			case FLAG:
				enterOuterAlt(_localctx, 6);
				{
				setState(176); flag();
				setState(177); match(DOTCOMA);
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
		enterRule(_localctx, 18, RULE_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181); match(SET);
			setState(182); ((SetContext)_localctx).ID = match(ID);
			 ((SetContext)_localctx).key =  (((SetContext)_localctx).ID!=null?((SetContext)_localctx).ID.getText():null); 
			setState(184); match(EQUAL);
			setState(185); expr(0);
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
		enterRule(_localctx, 20, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187); match(START);
			setState(188); ((StartContext)_localctx).ID = match(ID);
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
		enterRule(_localctx, 22, RULE_subscribe);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191); match(SUBSCRIBE);
			setState(192); ((SubscribeContext)_localctx).where = match(ID);
			setState(193); match(ON);
			setState(194); ((SubscribeContext)_localctx).message = match(ID);
			setState(197);
			_la = _input.LA(1);
			if (_la==DOUBLEDOT) {
				{
				setState(195); match(DOUBLEDOT);
				setState(196); ((SubscribeContext)_localctx).method = match(ID);
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
		enterRule(_localctx, 24, RULE_unsubscribe);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199); match(UNSUBSCRIBE);
			setState(200); ((UnsubscribeContext)_localctx).where = match(ID);
			setState(201); match(ON);
			setState(202); ((UnsubscribeContext)_localctx).message = match(ID);
			setState(205);
			_la = _input.LA(1);
			if (_la==DOUBLEDOT) {
				{
				setState(203); match(DOUBLEDOT);
				setState(204); ((UnsubscribeContext)_localctx).method = match(ID);
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
		enterRule(_localctx, 26, RULE_add);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207); match(ADD);
			setState(210);
			switch (_input.LA(1)) {
			case MANAGER:
			case STATE:
			case BEHAVIOR:
			case ENTITY:
			case GOAL:
				{
				setState(208); addDefine();
				}
				break;
			case ID:
				{
				setState(209); addMethod();
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
		enterRule(_localctx, 28, RULE_addDefine);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			switch (_input.LA(1)) {
			case MANAGER:
				{
				setState(212); match(MANAGER);
				 ((AddDefineContext)_localctx).type =  DefineType.MANAGER;  
				}
				break;
			case STATE:
				{
				setState(214); match(STATE);
				 ((AddDefineContext)_localctx).type =  DefineType.STATE;    
				}
				break;
			case BEHAVIOR:
				{
				setState(216); match(BEHAVIOR);
				 ((AddDefineContext)_localctx).type =  DefineType.BEHAVIOR; 
				}
				break;
			case ENTITY:
				{
				setState(218); match(ENTITY);
				 ((AddDefineContext)_localctx).type =  DefineType.ENTITY;  
				}
				break;
			case GOAL:
				{
				setState(220); match(GOAL);
				 ((AddDefineContext)_localctx).type =  DefineType.GOAL;  
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(224); ((AddDefineContext)_localctx).ID = match(ID);
			 ((AddDefineContext)_localctx).addName =  (((AddDefineContext)_localctx).ID!=null?((AddDefineContext)_localctx).ID.getText():null); 
			setState(231);
			_la = _input.LA(1);
			if (_la==ABRE_PAR) {
				{
				setState(226); match(ABRE_PAR);
				setState(228);
				_la = _input.LA(1);
				if (((((_la - 20)) & ~0x3f) == 0 && ((1L << (_la - 20)) & ((1L << (MANAGER - 20)) | (1L << (GAME - 20)) | (1L << (STATE - 20)) | (1L << (ASSET - 20)) | (1L << (BEHAVIOR - 20)) | (1L << (ENTITY - 20)) | (1L << (GOAL - 20)) | (1L << (MESSAGE - 20)) | (1L << (EMPTY - 20)) | (1L << (ABRE_PAR - 20)) | (1L << (ABRE_LLAV - 20)) | (1L << (MINUS - 20)) | (1L << (NOT - 20)) | (1L << (DIRECTCODE - 20)) | (1L << (INT_LITERAL - 20)) | (1L << (DECIMAL_LITERAL - 20)) | (1L << (STRING_LITERAL - 20)) | (1L << (BOOL_LITERAL - 20)) | (1L << (CURRENT_LITERAL - 20)) | (1L << (ID - 20)))) != 0)) {
					{
					setState(227); exprList();
					}
				}

				setState(230); match(CIERRA_PAR);
				}
			}

			setState(234);
			_la = _input.LA(1);
			if (_la==EMPTY || _la==ABRE_LLAV) {
				{
				setState(233); ((AddDefineContext)_localctx).exprParams = array();
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
		enterRule(_localctx, 30, RULE_addMethod);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236); ((AddMethodContext)_localctx).ID = match(ID);
			 ((AddMethodContext)_localctx).addName =  (((AddMethodContext)_localctx).ID!=null?((AddMethodContext)_localctx).ID.getText():null); 
			setState(238); match(ABRE_PAR);
			setState(240);
			_la = _input.LA(1);
			if (((((_la - 56)) & ~0x3f) == 0 && ((1L << (_la - 56)) & ((1L << (NUMBER_TYPE - 56)) | (1L << (STRING_TYPE - 56)) | (1L << (BOOL_TYPE - 56)) | (1L << (INTEGER_TYPE - 56)) | (1L << (DOUBLE_TYPE - 56)) | (1L << (FLOAT_TYPE - 56)) | (1L << (ID - 56)))) != 0)) {
				{
				setState(239); nameList();
				}
			}

			setState(242); match(CIERRA_PAR);
			setState(244);
			_la = _input.LA(1);
			if (_la==EMPTY || _la==ABRE_LLAV) {
				{
				setState(243); ((AddMethodContext)_localctx).exprParams = array();
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
		enterRule(_localctx, 32, RULE_define);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246); match(DEFINE);
			setState(263);
			switch (_input.LA(1)) {
			case MANAGER:
				{
				setState(247); match(MANAGER);
				 ((DefineContext)_localctx).type =  DefineType.MANAGER; 
				}
				break;
			case STATE:
				{
				setState(249); match(STATE);
				 ((DefineContext)_localctx).type =  DefineType.STATE;   
				}
				break;
			case BEHAVIOR:
				{
				setState(251); match(BEHAVIOR);
				 ((DefineContext)_localctx).type =  DefineType.BEHAVIOR;
				}
				break;
			case ENTITY:
				{
				setState(253); match(ENTITY);
				 ((DefineContext)_localctx).type =  DefineType.ENTITY;  
				}
				break;
			case GOAL:
				{
				setState(255); match(GOAL);
				 ((DefineContext)_localctx).type =  DefineType.GOAL;    
				}
				break;
			case MESSAGE:
				{
				setState(257); match(MESSAGE);
				 ((DefineContext)_localctx).type =  DefineType.MESSAGE; 
				}
				break;
			case ASSET:
				{
				setState(259); match(ASSET);
				 ((DefineContext)_localctx).type =  DefineType.ASSET;   
				}
				break;
			case ID:
				{
				setState(261); ((DefineContext)_localctx).ID = match(ID);
				 ((DefineContext)_localctx).type =  DefineType.valueOf((((DefineContext)_localctx).ID!=null?((DefineContext)_localctx).ID.getText():null));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(265); ((DefineContext)_localctx).ID = match(ID);
			 ((DefineContext)_localctx).defName =  (((DefineContext)_localctx).ID!=null?((DefineContext)_localctx).ID.getText():null); 
			setState(271);
			_la = _input.LA(1);
			if (_la==ABRE_PAR) {
				{
				setState(267); match(ABRE_PAR);
				setState(268); nameList();
				setState(269); match(CIERRA_PAR);
				}
			}

			setState(273); match(ABRE_COR);
			setState(274); defineValues();
			setState(275); match(CIERRA_COR);
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
		enterRule(_localctx, 34, RULE_on);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277); match(ON);
			setState(278); ((OnContext)_localctx).ID = match(ID);
			((OnContext)_localctx).messageName =  (((OnContext)_localctx).ID!=null?((OnContext)_localctx).ID.getText():null); 
			setState(282);
			_la = _input.LA(1);
			if (_la==DOUBLEDOT) {
				{
				setState(280); match(DOUBLEDOT);
				setState(281); ((OnContext)_localctx).filters = onFilters();
				}
			}

			setState(284); match(ABRE_COR);
			setState(285); statements();
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
		enterRule(_localctx, 36, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 6)) & ~0x3f) == 0 && ((1L << (_la - 6)) & ((1L << (SEND - 6)) | (1L << (DESTROY - 6)) | (1L << (SUBSCRIBE - 6)) | (1L << (UNSUBSCRIBE - 6)) | (1L << (ID - 6)))) != 0)) {
				{
				{
				setState(288); statement();
				setState(289); match(DOTCOMA);
				}
				}
				setState(295);
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
		enterRule(_localctx, 38, RULE_statement);
		try {
			setState(301);
			switch (_input.LA(1)) {
			case SEND:
				enterOuterAlt(_localctx, 1);
				{
				setState(296); send();
				}
				break;
			case DESTROY:
				enterOuterAlt(_localctx, 2);
				{
				setState(297); destroy();
				}
				break;
			case SUBSCRIBE:
				enterOuterAlt(_localctx, 3);
				{
				setState(298); subscribe();
				}
				break;
			case UNSUBSCRIBE:
				enterOuterAlt(_localctx, 4);
				{
				setState(299); unsubscribe();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(300); assign();
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
		enterRule(_localctx, 40, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303); ((AssignContext)_localctx).varName = match(ID);
			setState(304); match(EQUAL);
			setState(305); expr(0);
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
		enterRule(_localctx, 42, RULE_destroy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307); match(DESTROY);
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
		enterRule(_localctx, 44, RULE_send);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((SendContext)_localctx).receiverType =  Instance.Self;
			setState(310); match(SEND);
			setState(311); ((SendContext)_localctx).method = match(ID);
			((SendContext)_localctx).messageMethodName =  (((SendContext)_localctx).method!=null?((SendContext)_localctx).method.getText():null);
			setState(318);
			_la = _input.LA(1);
			if (_la==ABRE_PAR) {
				{
				setState(313); match(ABRE_PAR);
				setState(315);
				_la = _input.LA(1);
				if (((((_la - 20)) & ~0x3f) == 0 && ((1L << (_la - 20)) & ((1L << (MANAGER - 20)) | (1L << (GAME - 20)) | (1L << (STATE - 20)) | (1L << (ASSET - 20)) | (1L << (BEHAVIOR - 20)) | (1L << (ENTITY - 20)) | (1L << (GOAL - 20)) | (1L << (MESSAGE - 20)) | (1L << (EMPTY - 20)) | (1L << (ABRE_PAR - 20)) | (1L << (ABRE_LLAV - 20)) | (1L << (MINUS - 20)) | (1L << (NOT - 20)) | (1L << (DIRECTCODE - 20)) | (1L << (INT_LITERAL - 20)) | (1L << (DECIMAL_LITERAL - 20)) | (1L << (STRING_LITERAL - 20)) | (1L << (BOOL_LITERAL - 20)) | (1L << (CURRENT_LITERAL - 20)) | (1L << (ID - 20)))) != 0)) {
					{
					setState(314); exprList();
					}
				}

				setState(317); match(CIERRA_PAR);
				}
			}

			setState(330);
			_la = _input.LA(1);
			if (_la==TO) {
				{
				setState(320); match(TO);
				setState(327);
				switch (_input.LA(1)) {
				case OTHER:
					{
					setState(321); ((SendContext)_localctx).receiver = match(OTHER);
					((SendContext)_localctx).receiverType =  Instance.Other;
					}
					break;
				case GAME:
					{
					setState(323); ((SendContext)_localctx).receiver = match(GAME);
					((SendContext)_localctx).receiverType =  Instance.Game;
					}
					break;
				case ID:
					{
					setState(325); ((SendContext)_localctx).receiver = match(ID);
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
		enterRule(_localctx, 46, RULE_onFilters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332); filter();
			setState(336);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(333); filter();
				}
				}
				setState(338);
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
		enterRule(_localctx, 48, RULE_filter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339); ((FilterContext)_localctx).ID = match(ID);
			((FilterContext)_localctx).filterName =  (((FilterContext)_localctx).ID!=null?((FilterContext)_localctx).ID.getText():null);
			setState(346);
			_la = _input.LA(1);
			if (_la==ABRE_PAR) {
				{
				setState(341); match(ABRE_PAR);
				setState(343);
				_la = _input.LA(1);
				if (((((_la - 20)) & ~0x3f) == 0 && ((1L << (_la - 20)) & ((1L << (MANAGER - 20)) | (1L << (GAME - 20)) | (1L << (STATE - 20)) | (1L << (ASSET - 20)) | (1L << (BEHAVIOR - 20)) | (1L << (ENTITY - 20)) | (1L << (GOAL - 20)) | (1L << (MESSAGE - 20)) | (1L << (EMPTY - 20)) | (1L << (ABRE_PAR - 20)) | (1L << (ABRE_LLAV - 20)) | (1L << (MINUS - 20)) | (1L << (NOT - 20)) | (1L << (DIRECTCODE - 20)) | (1L << (INT_LITERAL - 20)) | (1L << (DECIMAL_LITERAL - 20)) | (1L << (STRING_LITERAL - 20)) | (1L << (BOOL_LITERAL - 20)) | (1L << (CURRENT_LITERAL - 20)) | (1L << (ID - 20)))) != 0)) {
					{
					setState(342); exprList();
					}
				}

				setState(345); match(CIERRA_PAR);
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
		enterRule(_localctx, 50, RULE_defineValues);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(351);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << ON) | (1L << SET) | (1L << ASSETS) | (1L << FLAG) | (1L << WHEN))) != 0)) {
				{
				{
				setState(348); defineValue();
				}
				}
				setState(353);
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
		enterRule(_localctx, 52, RULE_defineValue);
		try {
			setState(368);
			switch (_input.LA(1)) {
			case ADD:
				enterOuterAlt(_localctx, 1);
				{
				setState(354); add();
				setState(355); match(DOTCOMA);
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 2);
				{
				setState(357); set();
				setState(358); match(DOTCOMA);
				}
				break;
			case FLAG:
				enterOuterAlt(_localctx, 3);
				{
				setState(360); flag();
				setState(361); match(DOTCOMA);
				}
				break;
			case WHEN:
				enterOuterAlt(_localctx, 4);
				{
				setState(363); when();
				setState(364); match(DOTCOMA);
				}
				break;
			case ON:
				enterOuterAlt(_localctx, 5);
				{
				setState(366); on();
				}
				break;
			case ASSETS:
				enterOuterAlt(_localctx, 6);
				{
				setState(367); assets();
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
		enterRule(_localctx, 54, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370); expr(0);
			setState(375);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(371); match(COMA);
				setState(372); expr(0);
				}
				}
				setState(377);
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
		enterRule(_localctx, 56, RULE_nameList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378); declareVar();
			setState(383);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(379); match(COMA);
				setState(380); declareVar();
				}
				}
				setState(385);
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
		enterRule(_localctx, 58, RULE_declareVar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(386); varType();
			setState(387); ((DeclareVarContext)_localctx).varName = match(ID);
			setState(390);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(388); match(EQUAL);
				setState(389); ((DeclareVarContext)_localctx).initValue = expr(0);
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
		enterRule(_localctx, 60, RULE_varType);
		try {
			setState(407);
			switch (_input.LA(1)) {
			case NUMBER_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(392); match(NUMBER_TYPE);
				((VarTypeContext)_localctx).type =  BasicType.Number;
				}
				break;
			case BOOL_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(394); match(BOOL_TYPE);
				((VarTypeContext)_localctx).type =  BasicType.Bool;
				}
				break;
			case STRING_TYPE:
				enterOuterAlt(_localctx, 3);
				{
				setState(396); match(STRING_TYPE);
				((VarTypeContext)_localctx).type =  BasicType.String;
				}
				break;
			case INTEGER_TYPE:
				enterOuterAlt(_localctx, 4);
				{
				setState(398); match(INTEGER_TYPE);
				((VarTypeContext)_localctx).type =  BasicType.Integer;
				}
				break;
			case DOUBLE_TYPE:
				enterOuterAlt(_localctx, 5);
				{
				setState(400); match(DOUBLE_TYPE);
				((VarTypeContext)_localctx).type =  BasicType.Double;
				}
				break;
			case FLOAT_TYPE:
				enterOuterAlt(_localctx, 6);
				{
				setState(402); match(FLOAT_TYPE);
				((VarTypeContext)_localctx).type =  BasicType.Float;
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 7);
				{
				setState(404); ((VarTypeContext)_localctx).id = defineID();
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
		enterRule(_localctx, 62, RULE_defineID);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(412);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(409); ((DefineIDContext)_localctx).defineType = match(ID);
				setState(410); match(DOUBLEDOT);
				((DefineIDContext)_localctx).type =  (((DefineIDContext)_localctx).defineType!=null?((DefineIDContext)_localctx).defineType.getText():null);
				}
				break;
			}
			setState(414); ((DefineIDContext)_localctx).defineName = match(ID);
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
		enterRule(_localctx, 64, RULE_assets);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(417); match(ASSETS);
			setState(418); match(ABRE_COR);
			setState(419); assetValueWithInnerValue();
			setState(424);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(420); match(COMA);
					setState(421); assetValueWithInnerValue();
					}
					} 
				}
				setState(426);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			}
			setState(428);
			_la = _input.LA(1);
			if (_la==COMA) {
				{
				setState(427); match(COMA);
				}
			}

			setState(430); match(CIERRA_COR);
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
		enterRule(_localctx, 66, RULE_assetValueWithInnerValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(432); ((AssetValueWithInnerValueContext)_localctx).value = assetValue();
			setState(434);
			_la = _input.LA(1);
			if (_la==ABRE_COR) {
				{
				setState(433); ((AssetValueWithInnerValueContext)_localctx).innerAssets = assetValuesInner();
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
		enterRule(_localctx, 68, RULE_assetValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(436); ((AssetValueContext)_localctx).assetType = match(ID);
			setState(438);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(437); ((AssetValueContext)_localctx).assetName = match(ID);
				}
			}

			setState(440); match(DOUBLEDOT);
			setState(441); ((AssetValueContext)_localctx).assetPath = match(STRING_LITERAL);
			setState(443);
			_la = _input.LA(1);
			if (_la==EMPTY || _la==ABRE_LLAV) {
				{
				setState(442); ((AssetValueContext)_localctx).exprParams = array();
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
		enterRule(_localctx, 70, RULE_assetValuesInner);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(445); match(ABRE_COR);
			setState(446); assetValue();
			setState(451);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(447); match(COMA);
					setState(448); assetValue();
					}
					} 
				}
				setState(453);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			}
			setState(455);
			_la = _input.LA(1);
			if (_la==COMA) {
				{
				setState(454); match(COMA);
				}
			}

			setState(457); match(CIERRA_COR);
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
		enterRule(_localctx, 72, RULE_flag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(459); match(FLAG);
			setState(460); declareVar();
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
		enterRule(_localctx, 74, RULE_when);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(462); match(WHEN);
			setState(463); ((WhenContext)_localctx).condition = expr(0);
			setState(464); match(THEN);
			setState(465); ((WhenContext)_localctx).stmnt = statement();
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
		int _startState = 76;
		enterRecursionRule(_localctx, RULE_expr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(489);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(468); match(NOT);
				setState(469); ((NotExprContext)_localctx).op = expr(17);
				}
				break;

			case 2:
				{
				_localctx = new MinusExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(470); match(MINUS);
				setState(471); ((MinusExprContext)_localctx).op = expr(12);
				}
				break;

			case 3:
				{
				_localctx = new ArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(472); array();
				}
				break;

			case 4:
				{
				_localctx = new ParExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(473); match(ABRE_PAR);
				setState(474); ((ParExprContext)_localctx).op = expr(0);
				setState(475); match(CIERRA_PAR);
				}
				break;

			case 5:
				{
				_localctx = new IntLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(477); match(INT_LITERAL);
				}
				break;

			case 6:
				{
				_localctx = new DecimalLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(478); match(DECIMAL_LITERAL);
				}
				break;

			case 7:
				{
				_localctx = new StringLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(479); match(STRING_LITERAL);
				}
				break;

			case 8:
				{
				_localctx = new BoolLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(480); match(BOOL_LITERAL);
				}
				break;

			case 9:
				{
				_localctx = new DirectCodeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(481); match(DIRECTCODE);
				}
				break;

			case 10:
				{
				_localctx = new FunctionCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(482); ((FunctionCallExprContext)_localctx).functionName = match(ID);
				setState(483); match(ABRE_PAR);
				setState(485);
				_la = _input.LA(1);
				if (((((_la - 20)) & ~0x3f) == 0 && ((1L << (_la - 20)) & ((1L << (MANAGER - 20)) | (1L << (GAME - 20)) | (1L << (STATE - 20)) | (1L << (ASSET - 20)) | (1L << (BEHAVIOR - 20)) | (1L << (ENTITY - 20)) | (1L << (GOAL - 20)) | (1L << (MESSAGE - 20)) | (1L << (EMPTY - 20)) | (1L << (ABRE_PAR - 20)) | (1L << (ABRE_LLAV - 20)) | (1L << (MINUS - 20)) | (1L << (NOT - 20)) | (1L << (DIRECTCODE - 20)) | (1L << (INT_LITERAL - 20)) | (1L << (DECIMAL_LITERAL - 20)) | (1L << (STRING_LITERAL - 20)) | (1L << (BOOL_LITERAL - 20)) | (1L << (CURRENT_LITERAL - 20)) | (1L << (ID - 20)))) != 0)) {
					{
					setState(484); exprList();
					}
				}

				setState(487); match(CIERRA_PAR);
				}
				break;

			case 11:
				{
				_localctx = new VarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(488); accessVarOp();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(514);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(512);
					switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
					case 1:
						{
						_localctx = new LessThanExprContext(new ExprContext(_parentctx, _parentState, _p));
						((LessThanExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(491);
						if (!(16 >= _localctx._p)) throw new FailedPredicateException(this, "16 >= $_p");
						setState(492); match(LESS_THAN);
						setState(493); ((LessThanExprContext)_localctx).right = expr(17);
						}
						break;

					case 2:
						{
						_localctx = new MoreThanExprContext(new ExprContext(_parentctx, _parentState, _p));
						((MoreThanExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(494);
						if (!(15 >= _localctx._p)) throw new FailedPredicateException(this, "15 >= $_p");
						setState(495); match(MORE_THAN);
						setState(496); ((MoreThanExprContext)_localctx).right = expr(16);
						}
						break;

					case 3:
						{
						_localctx = new EqualExprContext(new ExprContext(_parentctx, _parentState, _p));
						((EqualExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(497);
						if (!(14 >= _localctx._p)) throw new FailedPredicateException(this, "14 >= $_p");
						setState(498); match(EQUAL);
						setState(499); ((EqualExprContext)_localctx).right = expr(15);
						}
						break;

					case 4:
						{
						_localctx = new MultExprContext(new ExprContext(_parentctx, _parentState, _p));
						((MultExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(500);
						if (!(11 >= _localctx._p)) throw new FailedPredicateException(this, "11 >= $_p");
						setState(501); match(MULTIPLY);
						setState(502); ((MultExprContext)_localctx).right = expr(12);
						}
						break;

					case 5:
						{
						_localctx = new DivExprContext(new ExprContext(_parentctx, _parentState, _p));
						((DivExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(503);
						if (!(10 >= _localctx._p)) throw new FailedPredicateException(this, "10 >= $_p");
						setState(504); match(DIVIDE);
						setState(505); ((DivExprContext)_localctx).right = expr(11);
						}
						break;

					case 6:
						{
						_localctx = new AddExprContext(new ExprContext(_parentctx, _parentState, _p));
						((AddExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(506);
						if (!(9 >= _localctx._p)) throw new FailedPredicateException(this, "9 >= $_p");
						setState(507); match(PLUS);
						setState(508); ((AddExprContext)_localctx).right = expr(10);
						}
						break;

					case 7:
						{
						_localctx = new SubExprContext(new ExprContext(_parentctx, _parentState, _p));
						((SubExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(509);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(510); match(MINUS);
						setState(511); ((SubExprContext)_localctx).right = expr(9);
						}
						break;
					}
					} 
				}
				setState(516);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
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
		enterRule(_localctx, 78, RULE_accessVarOp);
		try {
			setState(522);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				_localctx = new AccessVarNameContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(517); ((AccessVarNameContext)_localctx).var = varOp();
				}
				break;

			case 2:
				_localctx = new AccessVarOperatorContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(518); ((AccessVarOperatorContext)_localctx).pVar = parentVarOp();
				setState(519); match(DOT);
				setState(520); ((AccessVarOperatorContext)_localctx).propertyAccess = accessVarOp();
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
		enterRule(_localctx, 80, RULE_parentVarOp);
		try {
			setState(528);
			switch (_input.LA(1)) {
			case CURRENT_LITERAL:
				_localctx = new CurrentOperatorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(524); match(CURRENT_LITERAL);
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
				setState(525); ((VarNameOperatorContext)_localctx).varName = varID();
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
		enterRule(_localctx, 82, RULE_varOp);
		try {
			setState(532);
			switch (_input.LA(1)) {
			case CURRENT_LITERAL:
				_localctx = new VarCurrentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(530); match(CURRENT_LITERAL);
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
				setState(531); ((VarNameContext)_localctx).varName = varID();
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
		enterRule(_localctx, 84, RULE_varID);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(534);
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
		enterRule(_localctx, 86, RULE_array);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(536); arrayBody();
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
		enterRule(_localctx, 88, RULE_arrayBody);
		int _la;
		try {
			int _alt;
			setState(578);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				_localctx = new AssocArrayContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(538); match(ABRE_LLAV);
				{
				setState(539); parArray();
				setState(544);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(540); match(COMA);
						setState(541); parArray();
						}
						} 
					}
					setState(546);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
				}
				setState(548);
				_la = _input.LA(1);
				if (_la==COMA) {
					{
					setState(547); match(COMA);
					}
				}

				}
				setState(550); match(CIERRA_LLAV);
				setState(554);
				switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
				case 1:
					{
					setState(551); match(AS);
					setState(552); ((AssocArrayContext)_localctx).ID = match(ID);
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
				setState(556); match(ABRE_LLAV);
				{
				setState(557); itemArray();
				setState(562);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(558); match(COMA);
						setState(559); itemArray();
						}
						} 
					}
					setState(564);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
				}
				setState(566);
				_la = _input.LA(1);
				if (_la==COMA) {
					{
					setState(565); match(COMA);
					}
				}

				}
				setState(568); match(CIERRA_LLAV);
				setState(572);
				switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
				case 1:
					{
					setState(569); match(AS);
					setState(570); ((ListArrayContext)_localctx).ID = match(ID);
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
				setState(574); match(EMPTY);
				setState(575); match(AS);
				setState(576); ((EmptyArrayContext)_localctx).ID = match(ID);
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
		enterRule(_localctx, 90, RULE_itemArray);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(580); expr(0);
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
		enterRule(_localctx, 92, RULE_parArray);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(582); ((ParArrayContext)_localctx).ID = match(ID);
			 ((ParArrayContext)_localctx).key =  (((ParArrayContext)_localctx).ID!=null?((ParArrayContext)_localctx).ID.getText():null); 
			setState(584); match(EQUAL);
			setState(585); expr(0);
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
		case 38: return expr_sempred((ExprContext)_localctx, predIndex);
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3H\u024e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\2\3\2\3\3\7\3f\n\3\f\3\16\3"+
		"i\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4"+
		"z\n\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0082\n\4\3\5\7\5\u0085\n\5\f\5\16\5"+
		"\u0088\13\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u0090\n\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\7\t\u00a1\n\t\f\t\16\t\u00a4"+
		"\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\5\n\u00b6\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\5\r\u00c8\n\r\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00d0"+
		"\n\16\3\17\3\17\3\17\5\17\u00d5\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\5\20\u00e1\n\20\3\20\3\20\3\20\3\20\5\20\u00e7\n\20\3"+
		"\20\5\20\u00ea\n\20\3\20\5\20\u00ed\n\20\3\21\3\21\3\21\3\21\5\21\u00f3"+
		"\n\21\3\21\3\21\5\21\u00f7\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u010a\n\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\5\22\u0112\n\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\23\3\23\5\23\u011d\n\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\7\24\u0126"+
		"\n\24\f\24\16\24\u0129\13\24\3\25\3\25\3\25\3\25\3\25\5\25\u0130\n\25"+
		"\3\26\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u013e"+
		"\n\30\3\30\5\30\u0141\n\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u014a"+
		"\n\30\3\30\5\30\u014d\n\30\3\31\3\31\7\31\u0151\n\31\f\31\16\31\u0154"+
		"\13\31\3\32\3\32\3\32\3\32\5\32\u015a\n\32\3\32\5\32\u015d\n\32\3\33\7"+
		"\33\u0160\n\33\f\33\16\33\u0163\13\33\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0173\n\34\3\35\3\35\3\35"+
		"\7\35\u0178\n\35\f\35\16\35\u017b\13\35\3\36\3\36\3\36\7\36\u0180\n\36"+
		"\f\36\16\36\u0183\13\36\3\37\3\37\3\37\3\37\5\37\u0189\n\37\3 \3 \3 \3"+
		" \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u019a\n \3!\3!\3!\5!\u019f\n!\3"+
		"!\3!\3!\3\"\3\"\3\"\3\"\3\"\7\"\u01a9\n\"\f\"\16\"\u01ac\13\"\3\"\5\""+
		"\u01af\n\"\3\"\3\"\3#\3#\5#\u01b5\n#\3$\3$\5$\u01b9\n$\3$\3$\3$\5$\u01be"+
		"\n$\3%\3%\3%\3%\7%\u01c4\n%\f%\16%\u01c7\13%\3%\5%\u01ca\n%\3%\3%\3&\3"+
		"&\3&\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3("+
		"\3(\3(\3(\5(\u01e8\n(\3(\3(\5(\u01ec\n(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3("+
		"\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\7(\u0203\n(\f(\16(\u0206\13(\3)\3)\3"+
		")\3)\3)\5)\u020d\n)\3*\3*\3*\3*\5*\u0213\n*\3+\3+\5+\u0217\n+\3,\3,\3"+
		"-\3-\3.\3.\3.\3.\7.\u0221\n.\f.\16.\u0224\13.\3.\5.\u0227\n.\3.\3.\3."+
		"\3.\5.\u022d\n.\3.\3.\3.\3.\7.\u0233\n.\f.\16.\u0236\13.\3.\5.\u0239\n"+
		".\3.\3.\3.\3.\5.\u023f\n.\3.\3.\3.\3.\5.\u0245\n.\3/\3/\3\60\3\60\3\60"+
		"\3\60\3\60\3\60\2\61\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<>@BDFHJLNPRTVXZ\\^\2\3\4\2\26\35FF\u0284\2`\3\2\2\2\4g\3\2"+
		"\2\2\6j\3\2\2\2\b\u0086\3\2\2\2\n\u008f\3\2\2\2\f\u0091\3\2\2\2\16\u0099"+
		"\3\2\2\2\20\u00a2\3\2\2\2\22\u00b5\3\2\2\2\24\u00b7\3\2\2\2\26\u00bd\3"+
		"\2\2\2\30\u00c1\3\2\2\2\32\u00c9\3\2\2\2\34\u00d1\3\2\2\2\36\u00e0\3\2"+
		"\2\2 \u00ee\3\2\2\2\"\u00f8\3\2\2\2$\u0117\3\2\2\2&\u0127\3\2\2\2(\u012f"+
		"\3\2\2\2*\u0131\3\2\2\2,\u0135\3\2\2\2.\u0137\3\2\2\2\60\u014e\3\2\2\2"+
		"\62\u0155\3\2\2\2\64\u0161\3\2\2\2\66\u0172\3\2\2\28\u0174\3\2\2\2:\u017c"+
		"\3\2\2\2<\u0184\3\2\2\2>\u0199\3\2\2\2@\u019e\3\2\2\2B\u01a3\3\2\2\2D"+
		"\u01b2\3\2\2\2F\u01b6\3\2\2\2H\u01bf\3\2\2\2J\u01cd\3\2\2\2L\u01d0\3\2"+
		"\2\2N\u01eb\3\2\2\2P\u020c\3\2\2\2R\u0212\3\2\2\2T\u0216\3\2\2\2V\u0218"+
		"\3\2\2\2X\u021a\3\2\2\2Z\u0244\3\2\2\2\\\u0246\3\2\2\2^\u0248\3\2\2\2"+
		"`a\5\4\3\2ab\5\f\7\2bc\7\2\2\3c\3\3\2\2\2df\5\6\4\2ed\3\2\2\2fi\3\2\2"+
		"\2ge\3\2\2\2gh\3\2\2\2h\5\3\2\2\2ig\3\2\2\2jy\7\17\2\2kl\7\26\2\2lz\b"+
		"\4\1\2mn\7\30\2\2nz\b\4\1\2op\7\32\2\2pz\b\4\1\2qr\7\33\2\2rz\b\4\1\2"+
		"st\7\34\2\2tz\b\4\1\2uv\7\35\2\2vz\b\4\1\2wx\7F\2\2xz\b\4\1\2yk\3\2\2"+
		"\2ym\3\2\2\2yo\3\2\2\2yq\3\2\2\2ys\3\2\2\2yu\3\2\2\2yw\3\2\2\2z{\3\2\2"+
		"\2{\u0081\7F\2\2|\u0082\7.\2\2}~\7%\2\2~\177\5\b\5\2\177\u0080\7(\2\2"+
		"\u0080\u0082\3\2\2\2\u0081|\3\2\2\2\u0081}\3\2\2\2\u0082\7\3\2\2\2\u0083"+
		"\u0085\5\n\6\2\u0084\u0083\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2"+
		"\2\2\u0086\u0087\3\2\2\2\u0087\t\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008a"+
		"\5\34\17\2\u008a\u008b\7.\2\2\u008b\u0090\3\2\2\2\u008c\u008d\5\24\13"+
		"\2\u008d\u008e\7.\2\2\u008e\u0090\3\2\2\2\u008f\u0089\3\2\2\2\u008f\u008c"+
		"\3\2\2\2\u0090\13\3\2\2\2\u0091\u0092\7\5\2\2\u0092\u0093\7\27\2\2\u0093"+
		"\u0094\7F\2\2\u0094\u0095\b\7\1\2\u0095\u0096\7%\2\2\u0096\u0097\5\20"+
		"\t\2\u0097\u0098\7(\2\2\u0098\r\3\2\2\2\u0099\u009a\7\5\2\2\u009a\u009b"+
		"\7\27\2\2\u009b\u009c\7%\2\2\u009c\u009d\5\20\t\2\u009d\u009e\7(\2\2\u009e"+
		"\17\3\2\2\2\u009f\u00a1\5\22\n\2\u00a0\u009f\3\2\2\2\u00a1\u00a4\3\2\2"+
		"\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\21\3\2\2\2\u00a4\u00a2"+
		"\3\2\2\2\u00a5\u00a6\5\34\17\2\u00a6\u00a7\7.\2\2\u00a7\u00b6\3\2\2\2"+
		"\u00a8\u00a9\5\24\13\2\u00a9\u00aa\7.\2\2\u00aa\u00b6\3\2\2\2\u00ab\u00ac"+
		"\5\26\f\2\u00ac\u00ad\7.\2\2\u00ad\u00b6\3\2\2\2\u00ae\u00af\5L\'\2\u00af"+
		"\u00b0\7.\2\2\u00b0\u00b6\3\2\2\2\u00b1\u00b6\5$\23\2\u00b2\u00b3\5J&"+
		"\2\u00b3\u00b4\7.\2\2\u00b4\u00b6\3\2\2\2\u00b5\u00a5\3\2\2\2\u00b5\u00a8"+
		"\3\2\2\2\u00b5\u00ab\3\2\2\2\u00b5\u00ae\3\2\2\2\u00b5\u00b1\3\2\2\2\u00b5"+
		"\u00b2\3\2\2\2\u00b6\23\3\2\2\2\u00b7\u00b8\7\21\2\2\u00b8\u00b9\7F\2"+
		"\2\u00b9\u00ba\b\13\1\2\u00ba\u00bb\7,\2\2\u00bb\u00bc\5N(\2\u00bc\25"+
		"\3\2\2\2\u00bd\u00be\7\22\2\2\u00be\u00bf\7F\2\2\u00bf\u00c0\b\f\1\2\u00c0"+
		"\27\3\2\2\2\u00c1\u00c2\7\13\2\2\u00c2\u00c3\7F\2\2\u00c3\u00c4\7\7\2"+
		"\2\u00c4\u00c7\7F\2\2\u00c5\u00c6\7/\2\2\u00c6\u00c8\7F\2\2\u00c7\u00c5"+
		"\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\31\3\2\2\2\u00c9\u00ca\7\f\2\2\u00ca"+
		"\u00cb\7F\2\2\u00cb\u00cc\7\7\2\2\u00cc\u00cf\7F\2\2\u00cd\u00ce\7/\2"+
		"\2\u00ce\u00d0\7F\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\33"+
		"\3\2\2\2\u00d1\u00d4\7\6\2\2\u00d2\u00d5\5\36\20\2\u00d3\u00d5\5 \21\2"+
		"\u00d4\u00d2\3\2\2\2\u00d4\u00d3\3\2\2\2\u00d5\35\3\2\2\2\u00d6\u00d7"+
		"\7\26\2\2\u00d7\u00e1\b\20\1\2\u00d8\u00d9\7\30\2\2\u00d9\u00e1\b\20\1"+
		"\2\u00da\u00db\7\32\2\2\u00db\u00e1\b\20\1\2\u00dc\u00dd\7\33\2\2\u00dd"+
		"\u00e1\b\20\1\2\u00de\u00df\7\34\2\2\u00df\u00e1\b\20\1\2\u00e0\u00d6"+
		"\3\2\2\2\u00e0\u00d8\3\2\2\2\u00e0\u00da\3\2\2\2\u00e0\u00dc\3\2\2\2\u00e0"+
		"\u00de\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\7F\2\2\u00e3\u00e9\b\20"+
		"\1\2\u00e4\u00e6\7&\2\2\u00e5\u00e7\58\35\2\u00e6\u00e5\3\2\2\2\u00e6"+
		"\u00e7\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00ea\7)\2\2\u00e9\u00e4\3\2"+
		"\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00ec\3\2\2\2\u00eb\u00ed\5X-\2\u00ec\u00eb"+
		"\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\37\3\2\2\2\u00ee\u00ef\7F\2\2\u00ef"+
		"\u00f0\b\21\1\2\u00f0\u00f2\7&\2\2\u00f1\u00f3\5:\36\2\u00f2\u00f1\3\2"+
		"\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f6\7)\2\2\u00f5"+
		"\u00f7\5X-\2\u00f6\u00f5\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7!\3\2\2\2\u00f8"+
		"\u0109\7\5\2\2\u00f9\u00fa\7\26\2\2\u00fa\u010a\b\22\1\2\u00fb\u00fc\7"+
		"\30\2\2\u00fc\u010a\b\22\1\2\u00fd\u00fe\7\32\2\2\u00fe\u010a\b\22\1\2"+
		"\u00ff\u0100\7\33\2\2\u0100\u010a\b\22\1\2\u0101\u0102\7\34\2\2\u0102"+
		"\u010a\b\22\1\2\u0103\u0104\7\35\2\2\u0104\u010a\b\22\1\2\u0105\u0106"+
		"\7\31\2\2\u0106\u010a\b\22\1\2\u0107\u0108\7F\2\2\u0108\u010a\b\22\1\2"+
		"\u0109\u00f9\3\2\2\2\u0109\u00fb\3\2\2\2\u0109\u00fd\3\2\2\2\u0109\u00ff"+
		"\3\2\2\2\u0109\u0101\3\2\2\2\u0109\u0103\3\2\2\2\u0109\u0105\3\2\2\2\u0109"+
		"\u0107\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010c\7F\2\2\u010c\u0111\b\22"+
		"\1\2\u010d\u010e\7&\2\2\u010e\u010f\5:\36\2\u010f\u0110\7)\2\2\u0110\u0112"+
		"\3\2\2\2\u0111\u010d\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0113\3\2\2\2\u0113"+
		"\u0114\7%\2\2\u0114\u0115\5\64\33\2\u0115\u0116\7(\2\2\u0116#\3\2\2\2"+
		"\u0117\u0118\7\7\2\2\u0118\u0119\7F\2\2\u0119\u011c\b\23\1\2\u011a\u011b"+
		"\7/\2\2\u011b\u011d\5\60\31\2\u011c\u011a\3\2\2\2\u011c\u011d\3\2\2\2"+
		"\u011d\u011e\3\2\2\2\u011e\u011f\7%\2\2\u011f\u0120\5&\24\2\u0120\u0121"+
		"\7(\2\2\u0121%\3\2\2\2\u0122\u0123\5(\25\2\u0123\u0124\7.\2\2\u0124\u0126"+
		"\3\2\2\2\u0125\u0122\3\2\2\2\u0126\u0129\3\2\2\2\u0127\u0125\3\2\2\2\u0127"+
		"\u0128\3\2\2\2\u0128\'\3\2\2\2\u0129\u0127\3\2\2\2\u012a\u0130\5.\30\2"+
		"\u012b\u0130\5,\27\2\u012c\u0130\5\30\r\2\u012d\u0130\5\32\16\2\u012e"+
		"\u0130\5*\26\2\u012f\u012a\3\2\2\2\u012f\u012b\3\2\2\2\u012f\u012c\3\2"+
		"\2\2\u012f\u012d\3\2\2\2\u012f\u012e\3\2\2\2\u0130)\3\2\2\2\u0131\u0132"+
		"\7F\2\2\u0132\u0133\7,\2\2\u0133\u0134\5N(\2\u0134+\3\2\2\2\u0135\u0136"+
		"\7\t\2\2\u0136-\3\2\2\2\u0137\u0138\b\30\1\2\u0138\u0139\7\b\2\2\u0139"+
		"\u013a\7F\2\2\u013a\u0140\b\30\1\2\u013b\u013d\7&\2\2\u013c\u013e\58\35"+
		"\2\u013d\u013c\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u0141"+
		"\7)\2\2\u0140\u013b\3\2\2\2\u0140\u0141\3\2\2\2\u0141\u014c\3\2\2\2\u0142"+
		"\u0149\7\37\2\2\u0143\u0144\7\"\2\2\u0144\u014a\b\30\1\2\u0145\u0146\7"+
		"\27\2\2\u0146\u014a\b\30\1\2\u0147\u0148\7F\2\2\u0148\u014a\b\30\1\2\u0149"+
		"\u0143\3\2\2\2\u0149\u0145\3\2\2\2\u0149\u0147\3\2\2\2\u014a\u014b\3\2"+
		"\2\2\u014b\u014d\b\30\1\2\u014c\u0142\3\2\2\2\u014c\u014d\3\2\2\2\u014d"+
		"/\3\2\2\2\u014e\u0152\5\62\32\2\u014f\u0151\5\62\32\2\u0150\u014f\3\2"+
		"\2\2\u0151\u0154\3\2\2\2\u0152\u0150\3\2\2\2\u0152\u0153\3\2\2\2\u0153"+
		"\61\3\2\2\2\u0154\u0152\3\2\2\2\u0155\u0156\7F\2\2\u0156\u015c\b\32\1"+
		"\2\u0157\u0159\7&\2\2\u0158\u015a\58\35\2\u0159\u0158\3\2\2\2\u0159\u015a"+
		"\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u015d\7)\2\2\u015c\u0157\3\2\2\2\u015c"+
		"\u015d\3\2\2\2\u015d\63\3\2\2\2\u015e\u0160\5\66\34\2\u015f\u015e\3\2"+
		"\2\2\u0160\u0163\3\2\2\2\u0161\u015f\3\2\2\2\u0161\u0162\3\2\2\2\u0162"+
		"\65\3\2\2\2\u0163\u0161\3\2\2\2\u0164\u0165\5\34\17\2\u0165\u0166\7.\2"+
		"\2\u0166\u0173\3\2\2\2\u0167\u0168\5\24\13\2\u0168\u0169\7.\2\2\u0169"+
		"\u0173\3\2\2\2\u016a\u016b\5J&\2\u016b\u016c\7.\2\2\u016c\u0173\3\2\2"+
		"\2\u016d\u016e\5L\'\2\u016e\u016f\7.\2\2\u016f\u0173\3\2\2\2\u0170\u0173"+
		"\5$\23\2\u0171\u0173\5B\"\2\u0172\u0164\3\2\2\2\u0172\u0167\3\2\2\2\u0172"+
		"\u016a\3\2\2\2\u0172\u016d\3\2\2\2\u0172\u0170\3\2\2\2\u0172\u0171\3\2"+
		"\2\2\u0173\67\3\2\2\2\u0174\u0179\5N(\2\u0175\u0176\7+\2\2\u0176\u0178"+
		"\5N(\2\u0177\u0175\3\2\2\2\u0178\u017b\3\2\2\2\u0179\u0177\3\2\2\2\u0179"+
		"\u017a\3\2\2\2\u017a9\3\2\2\2\u017b\u0179\3\2\2\2\u017c\u0181\5<\37\2"+
		"\u017d\u017e\7+\2\2\u017e\u0180\5<\37\2\u017f\u017d\3\2\2\2\u0180\u0183"+
		"\3\2\2\2\u0181\u017f\3\2\2\2\u0181\u0182\3\2\2\2\u0182;\3\2\2\2\u0183"+
		"\u0181\3\2\2\2\u0184\u0185\5> \2\u0185\u0188\7F\2\2\u0186\u0187\7,\2\2"+
		"\u0187\u0189\5N(\2\u0188\u0186\3\2\2\2\u0188\u0189\3\2\2\2\u0189=\3\2"+
		"\2\2\u018a\u018b\7:\2\2\u018b\u019a\b \1\2\u018c\u018d\7<\2\2\u018d\u019a"+
		"\b \1\2\u018e\u018f\7;\2\2\u018f\u019a\b \1\2\u0190\u0191\7=\2\2\u0191"+
		"\u019a\b \1\2\u0192\u0193\7>\2\2\u0193\u019a\b \1\2\u0194\u0195\7?\2\2"+
		"\u0195\u019a\b \1\2\u0196\u0197\5@!\2\u0197\u0198\b \1\2\u0198\u019a\3"+
		"\2\2\2\u0199\u018a\3\2\2\2\u0199\u018c\3\2\2\2\u0199\u018e\3\2\2\2\u0199"+
		"\u0190\3\2\2\2\u0199\u0192\3\2\2\2\u0199\u0194\3\2\2\2\u0199\u0196\3\2"+
		"\2\2\u019a?\3\2\2\2\u019b\u019c\7F\2\2\u019c\u019d\7/\2\2\u019d\u019f"+
		"\b!\1\2\u019e\u019b\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0"+
		"\u01a1\7F\2\2\u01a1\u01a2\b!\1\2\u01a2A\3\2\2\2\u01a3\u01a4\7\23\2\2\u01a4"+
		"\u01a5\7%\2\2\u01a5\u01aa\5D#\2\u01a6\u01a7\7+\2\2\u01a7\u01a9\5D#\2\u01a8"+
		"\u01a6\3\2\2\2\u01a9\u01ac\3\2\2\2\u01aa\u01a8\3\2\2\2\u01aa\u01ab\3\2"+
		"\2\2\u01ab\u01ae\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ad\u01af\7+\2\2\u01ae"+
		"\u01ad\3\2\2\2\u01ae\u01af\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b1\7("+
		"\2\2\u01b1C\3\2\2\2\u01b2\u01b4\5F$\2\u01b3\u01b5\5H%\2\u01b4\u01b3\3"+
		"\2\2\2\u01b4\u01b5\3\2\2\2\u01b5E\3\2\2\2\u01b6\u01b8\7F\2\2\u01b7\u01b9"+
		"\7F\2\2\u01b8\u01b7\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba"+
		"\u01bb\7/\2\2\u01bb\u01bd\7C\2\2\u01bc\u01be\5X-\2\u01bd\u01bc\3\2\2\2"+
		"\u01bd\u01be\3\2\2\2\u01beG\3\2\2\2\u01bf\u01c0\7%\2\2\u01c0\u01c5\5F"+
		"$\2\u01c1\u01c2\7+\2\2\u01c2\u01c4\5F$\2\u01c3\u01c1\3\2\2\2\u01c4\u01c7"+
		"\3\2\2\2\u01c5\u01c3\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01c9\3\2\2\2\u01c7"+
		"\u01c5\3\2\2\2\u01c8\u01ca\7+\2\2\u01c9\u01c8\3\2\2\2\u01c9\u01ca\3\2"+
		"\2\2\u01ca\u01cb\3\2\2\2\u01cb\u01cc\7(\2\2\u01ccI\3\2\2\2\u01cd\u01ce"+
		"\7\24\2\2\u01ce\u01cf\5<\37\2\u01cfK\3\2\2\2\u01d0\u01d1\7\25\2\2\u01d1"+
		"\u01d2\5N(\2\u01d2\u01d3\7$\2\2\u01d3\u01d4\5(\25\2\u01d4M\3\2\2\2\u01d5"+
		"\u01d6\b(\1\2\u01d6\u01d7\79\2\2\u01d7\u01ec\5N(\2\u01d8\u01d9\7\61\2"+
		"\2\u01d9\u01ec\5N(\2\u01da\u01ec\5X-\2\u01db\u01dc\7&\2\2\u01dc\u01dd"+
		"\5N(\2\u01dd\u01de\7)\2\2\u01de\u01ec\3\2\2\2\u01df\u01ec\7A\2\2\u01e0"+
		"\u01ec\7B\2\2\u01e1\u01ec\7C\2\2\u01e2\u01ec\7D\2\2\u01e3\u01ec\7@\2\2"+
		"\u01e4\u01e5\7F\2\2\u01e5\u01e7\7&\2\2\u01e6\u01e8\58\35\2\u01e7\u01e6"+
		"\3\2\2\2\u01e7\u01e8\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9\u01ec\7)\2\2\u01ea"+
		"\u01ec\5P)\2\u01eb\u01d5\3\2\2\2\u01eb\u01d8\3\2\2\2\u01eb\u01da\3\2\2"+
		"\2\u01eb\u01db\3\2\2\2\u01eb\u01df\3\2\2\2\u01eb\u01e0\3\2\2\2\u01eb\u01e1"+
		"\3\2\2\2\u01eb\u01e2\3\2\2\2\u01eb\u01e3\3\2\2\2\u01eb\u01e4\3\2\2\2\u01eb"+
		"\u01ea\3\2\2\2\u01ec\u0204\3\2\2\2\u01ed\u01ee\6(\2\3\u01ee\u01ef\7\65"+
		"\2\2\u01ef\u0203\5N(\2\u01f0\u01f1\6(\3\3\u01f1\u01f2\7\64\2\2\u01f2\u0203"+
		"\5N(\2\u01f3\u01f4\6(\4\3\u01f4\u01f5\7,\2\2\u01f5\u0203\5N(\2\u01f6\u01f7"+
		"\6(\5\3\u01f7\u01f8\7\62\2\2\u01f8\u0203\5N(\2\u01f9\u01fa\6(\6\3\u01fa"+
		"\u01fb\7\63\2\2\u01fb\u0203\5N(\2\u01fc\u01fd\6(\7\3\u01fd\u01fe\7\60"+
		"\2\2\u01fe\u0203\5N(\2\u01ff\u0200\6(\b\3\u0200\u0201\7\61\2\2\u0201\u0203"+
		"\5N(\2\u0202\u01ed\3\2\2\2\u0202\u01f0\3\2\2\2\u0202\u01f3\3\2\2\2\u0202"+
		"\u01f6\3\2\2\2\u0202\u01f9\3\2\2\2\u0202\u01fc\3\2\2\2\u0202\u01ff\3\2"+
		"\2\2\u0203\u0206\3\2\2\2\u0204\u0202\3\2\2\2\u0204\u0205\3\2\2\2\u0205"+
		"O\3\2\2\2\u0206\u0204\3\2\2\2\u0207\u020d\5T+\2\u0208\u0209\5R*\2\u0209"+
		"\u020a\7-\2\2\u020a\u020b\5P)\2\u020b\u020d\3\2\2\2\u020c\u0207\3\2\2"+
		"\2\u020c\u0208\3\2\2\2\u020dQ\3\2\2\2\u020e\u0213\7E\2\2\u020f\u0210\5"+
		"V,\2\u0210\u0211\b*\1\2\u0211\u0213\3\2\2\2\u0212\u020e\3\2\2\2\u0212"+
		"\u020f\3\2\2\2\u0213S\3\2\2\2\u0214\u0217\7E\2\2\u0215\u0217\5V,\2\u0216"+
		"\u0214\3\2\2\2\u0216\u0215\3\2\2\2\u0217U\3\2\2\2\u0218\u0219\t\2\2\2"+
		"\u0219W\3\2\2\2\u021a\u021b\5Z.\2\u021bY\3\2\2\2\u021c\u021d\7\'\2\2\u021d"+
		"\u0222\5^\60\2\u021e\u021f\7+\2\2\u021f\u0221\5^\60\2\u0220\u021e\3\2"+
		"\2\2\u0221\u0224\3\2\2\2\u0222\u0220\3\2\2\2\u0222\u0223\3\2\2\2\u0223"+
		"\u0226\3\2\2\2\u0224\u0222\3\2\2\2\u0225\u0227\7+\2\2\u0226\u0225\3\2"+
		"\2\2\u0226\u0227\3\2\2\2\u0227\u0228\3\2\2\2\u0228\u022c\7*\2\2\u0229"+
		"\u022a\7!\2\2\u022a\u022b\7F\2\2\u022b\u022d\b.\1\2\u022c\u0229\3\2\2"+
		"\2\u022c\u022d\3\2\2\2\u022d\u0245\3\2\2\2\u022e\u022f\7\'\2\2\u022f\u0234"+
		"\5\\/\2\u0230\u0231\7+\2\2\u0231\u0233\5\\/\2\u0232\u0230\3\2\2\2\u0233"+
		"\u0236\3\2\2\2\u0234\u0232\3\2\2\2\u0234\u0235\3\2\2\2\u0235\u0238\3\2"+
		"\2\2\u0236\u0234\3\2\2\2\u0237\u0239\7+\2\2\u0238\u0237\3\2\2\2\u0238"+
		"\u0239\3\2\2\2\u0239\u023a\3\2\2\2\u023a\u023e\7*\2\2\u023b\u023c\7!\2"+
		"\2\u023c\u023d\7F\2\2\u023d\u023f\b.\1\2\u023e\u023b\3\2\2\2\u023e\u023f"+
		"\3\2\2\2\u023f\u0245\3\2\2\2\u0240\u0241\7#\2\2\u0241\u0242\7!\2\2\u0242"+
		"\u0243\7F\2\2\u0243\u0245\b.\1\2\u0244\u021c\3\2\2\2\u0244\u022e\3\2\2"+
		"\2\u0244\u0240\3\2\2\2\u0245[\3\2\2\2\u0246\u0247\5N(\2\u0247]\3\2\2\2"+
		"\u0248\u0249\7F\2\2\u0249\u024a\b\60\1\2\u024a\u024b\7,\2\2\u024b\u024c"+
		"\5N(\2\u024c_\3\2\2\2:gy\u0081\u0086\u008f\u00a2\u00b5\u00c7\u00cf\u00d4"+
		"\u00e0\u00e6\u00e9\u00ec\u00f2\u00f6\u0109\u0111\u011c\u0127\u012f\u013d"+
		"\u0140\u0149\u014c\u0152\u0159\u015c\u0161\u0172\u0179\u0181\u0188\u0199"+
		"\u019e\u01aa\u01ae\u01b4\u01b8\u01bd\u01c5\u01c9\u01e7\u01eb\u0202\u0204"+
		"\u020c\u0212\u0216\u0222\u0226\u022c\u0234\u0238\u023e\u0244";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}