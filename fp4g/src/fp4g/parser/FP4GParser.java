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
		STRING_LITERAL=65, BOOL_LITERAL=66, PARENT_LITERAL=67, CURRENT_LITERAL=68, 
		ID=69, NL=70, WS=71;
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
		"STRING_LITERAL", "BOOL_LITERAL", "'parent'", "'current'", "ID", "NL", 
		"WS"
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
		RULE_assetValuesInner = 35, RULE_flags = 36, RULE_flag = 37, RULE_when = 38, 
		RULE_expr = 39, RULE_accessVarOp = 40, RULE_parentVarOp = 41, RULE_varOp = 42, 
		RULE_varID = 43, RULE_array = 44, RULE_arrayBody = 45, RULE_itemArray = 46, 
		RULE_parArray = 47;
	public static final String[] ruleNames = {
		"program", "usings", "using", "usingValues", "usingValue", "game", "gameLib", 
		"gameValues", "gameValue", "set", "start", "subscribe", "unsubscribe", 
		"add", "addDefine", "addMethod", "define", "on", "statements", "statement", 
		"assign", "destroy", "send", "onFilters", "filter", "defineValues", "defineValue", 
		"exprList", "nameList", "declareVar", "varType", "defineID", "assets", 
		"assetValueWithInnerValue", "assetValue", "assetValuesInner", "flags", 
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
			setState(96); usings();
			setState(97); game();
			setState(98); match(EOF);
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
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==USING) {
				{
				{
				setState(100); using();
				}
				}
				setState(105);
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
			setState(106); match(USING);
			setState(121);
			switch (_input.LA(1)) {
			case MANAGER:
				{
				setState(107); match(MANAGER);
				 ((UsingContext)_localctx).type =  DefineType.MANAGER; 
				}
				break;
			case STATE:
				{
				setState(109); match(STATE);
				 ((UsingContext)_localctx).type =  DefineType.STATE;   
				}
				break;
			case BEHAVIOR:
				{
				setState(111); match(BEHAVIOR);
				 ((UsingContext)_localctx).type =  DefineType.BEHAVIOR;
				}
				break;
			case ENTITY:
				{
				setState(113); match(ENTITY);
				 ((UsingContext)_localctx).type =  DefineType.ENTITY;  
				}
				break;
			case GOAL:
				{
				setState(115); match(GOAL);
				 ((UsingContext)_localctx).type =  DefineType.GOAL;    
				}
				break;
			case MESSAGE:
				{
				setState(117); match(MESSAGE);
				 ((UsingContext)_localctx).type =  DefineType.MESSAGE; 
				}
				break;
			case ID:
				{
				setState(119); ((UsingContext)_localctx).ID = match(ID);
				 ((UsingContext)_localctx).type =  DefineType.valueOf((((UsingContext)_localctx).ID!=null?((UsingContext)_localctx).ID.getText():null));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(123); ((UsingContext)_localctx).name = match(ID);
			setState(129);
			switch (_input.LA(1)) {
			case DOTCOMA:
				{
				setState(124); match(DOTCOMA);
				}
				break;
			case ABRE_COR:
				{
				setState(125); match(ABRE_COR);
				setState(126); usingValues();
				setState(127); match(CIERRA_COR);
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
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD || _la==SET) {
				{
				{
				setState(131); usingValue();
				}
				}
				setState(136);
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
			setState(143);
			switch (_input.LA(1)) {
			case ADD:
				enterOuterAlt(_localctx, 1);
				{
				setState(137); add();
				setState(138); match(DOTCOMA);
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 2);
				{
				setState(140); set();
				setState(141); match(DOTCOMA);
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
			setState(145); match(DEFINE);
			setState(146); match(GAME);
			setState(147); ((GameContext)_localctx).ID = match(ID);
			 ((GameContext)_localctx).name =  (((GameContext)_localctx).ID!=null?((GameContext)_localctx).ID.getText():null); 
			setState(149); match(ABRE_COR);
			setState(150); gameValues();
			setState(151); match(CIERRA_COR);
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
			setState(153); match(DEFINE);
			setState(154); match(GAME);
			setState(155); match(ABRE_COR);
			setState(156); gameValues();
			setState(157); match(CIERRA_COR);
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
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DEFINE) | (1L << ADD) | (1L << ON) | (1L << SET) | (1L << START) | (1L << FLAG) | (1L << WHEN))) != 0)) {
				{
				{
				setState(159); gameValue();
				}
				}
				setState(164);
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
		public AddContext add() {
			return getRuleContext(AddContext.class,0);
		}
		public TerminalNode DOTCOMA() { return getToken(FP4GParser.DOTCOMA, 0); }
		public FlagsContext flags() {
			return getRuleContext(FlagsContext.class,0);
		}
		public DefineContext define() {
			return getRuleContext(DefineContext.class,0);
		}
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
			setState(180);
			switch (_input.LA(1)) {
			case DEFINE:
				enterOuterAlt(_localctx, 1);
				{
				setState(165); define();
				}
				break;
			case ADD:
				enterOuterAlt(_localctx, 2);
				{
				setState(166); add();
				setState(167); match(DOTCOMA);
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 3);
				{
				setState(169); set();
				setState(170); match(DOTCOMA);
				}
				break;
			case START:
				enterOuterAlt(_localctx, 4);
				{
				setState(172); start();
				setState(173); match(DOTCOMA);
				}
				break;
			case WHEN:
				enterOuterAlt(_localctx, 5);
				{
				setState(175); when();
				setState(176); match(DOTCOMA);
				}
				break;
			case ON:
				enterOuterAlt(_localctx, 6);
				{
				setState(178); on();
				}
				break;
			case FLAG:
				enterOuterAlt(_localctx, 7);
				{
				setState(179); flags();
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
			setState(182); match(SET);
			setState(183); ((SetContext)_localctx).ID = match(ID);
			 ((SetContext)_localctx).key =  (((SetContext)_localctx).ID!=null?((SetContext)_localctx).ID.getText():null); 
			setState(185); match(EQUAL);
			setState(186); expr(0);
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
			setState(188); match(START);
			setState(189); ((StartContext)_localctx).ID = match(ID);
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
			setState(192); match(SUBSCRIBE);
			setState(193); ((SubscribeContext)_localctx).where = match(ID);
			setState(194); match(ON);
			setState(195); ((SubscribeContext)_localctx).message = match(ID);
			setState(198);
			_la = _input.LA(1);
			if (_la==DOUBLEDOT) {
				{
				setState(196); match(DOUBLEDOT);
				setState(197); ((SubscribeContext)_localctx).method = match(ID);
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
			setState(200); match(UNSUBSCRIBE);
			setState(201); ((UnsubscribeContext)_localctx).where = match(ID);
			setState(202); match(ON);
			setState(203); ((UnsubscribeContext)_localctx).message = match(ID);
			setState(206);
			_la = _input.LA(1);
			if (_la==DOUBLEDOT) {
				{
				setState(204); match(DOUBLEDOT);
				setState(205); ((UnsubscribeContext)_localctx).method = match(ID);
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
			setState(208); match(ADD);
			setState(211);
			switch (_input.LA(1)) {
			case MANAGER:
			case STATE:
			case BEHAVIOR:
			case ENTITY:
			case GOAL:
				{
				setState(209); addDefine();
				}
				break;
			case ID:
				{
				setState(210); addMethod();
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
			setState(223);
			switch (_input.LA(1)) {
			case MANAGER:
				{
				setState(213); match(MANAGER);
				 ((AddDefineContext)_localctx).type =  DefineType.MANAGER;  
				}
				break;
			case STATE:
				{
				setState(215); match(STATE);
				 ((AddDefineContext)_localctx).type =  DefineType.STATE;    
				}
				break;
			case BEHAVIOR:
				{
				setState(217); match(BEHAVIOR);
				 ((AddDefineContext)_localctx).type =  DefineType.BEHAVIOR; 
				}
				break;
			case ENTITY:
				{
				setState(219); match(ENTITY);
				 ((AddDefineContext)_localctx).type =  DefineType.ENTITY;  
				}
				break;
			case GOAL:
				{
				setState(221); match(GOAL);
				 ((AddDefineContext)_localctx).type =  DefineType.GOAL;  
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(225); ((AddDefineContext)_localctx).ID = match(ID);
			 ((AddDefineContext)_localctx).addName =  (((AddDefineContext)_localctx).ID!=null?((AddDefineContext)_localctx).ID.getText():null); 
			setState(232);
			_la = _input.LA(1);
			if (_la==ABRE_PAR) {
				{
				setState(227); match(ABRE_PAR);
				setState(229);
				_la = _input.LA(1);
				if (((((_la - 20)) & ~0x3f) == 0 && ((1L << (_la - 20)) & ((1L << (MANAGER - 20)) | (1L << (GAME - 20)) | (1L << (STATE - 20)) | (1L << (ASSET - 20)) | (1L << (BEHAVIOR - 20)) | (1L << (ENTITY - 20)) | (1L << (GOAL - 20)) | (1L << (MESSAGE - 20)) | (1L << (EMPTY - 20)) | (1L << (ABRE_PAR - 20)) | (1L << (ABRE_LLAV - 20)) | (1L << (MINUS - 20)) | (1L << (NOT - 20)) | (1L << (DIRECTCODE - 20)) | (1L << (INT_LITERAL - 20)) | (1L << (DECIMAL_LITERAL - 20)) | (1L << (STRING_LITERAL - 20)) | (1L << (BOOL_LITERAL - 20)) | (1L << (PARENT_LITERAL - 20)) | (1L << (CURRENT_LITERAL - 20)) | (1L << (ID - 20)))) != 0)) {
					{
					setState(228); exprList();
					}
				}

				setState(231); match(CIERRA_PAR);
				}
			}

			setState(235);
			_la = _input.LA(1);
			if (_la==EMPTY || _la==ABRE_LLAV) {
				{
				setState(234); ((AddDefineContext)_localctx).exprParams = array();
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
			setState(237); ((AddMethodContext)_localctx).ID = match(ID);
			 ((AddMethodContext)_localctx).addName =  (((AddMethodContext)_localctx).ID!=null?((AddMethodContext)_localctx).ID.getText():null); 
			setState(239); match(ABRE_PAR);
			setState(241);
			_la = _input.LA(1);
			if (((((_la - 56)) & ~0x3f) == 0 && ((1L << (_la - 56)) & ((1L << (NUMBER_TYPE - 56)) | (1L << (STRING_TYPE - 56)) | (1L << (BOOL_TYPE - 56)) | (1L << (INTEGER_TYPE - 56)) | (1L << (DOUBLE_TYPE - 56)) | (1L << (FLOAT_TYPE - 56)) | (1L << (ID - 56)))) != 0)) {
				{
				setState(240); nameList();
				}
			}

			setState(243); match(CIERRA_PAR);
			setState(245);
			_la = _input.LA(1);
			if (_la==EMPTY || _la==ABRE_LLAV) {
				{
				setState(244); ((AddMethodContext)_localctx).exprParams = array();
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
			setState(247); match(DEFINE);
			setState(264);
			switch (_input.LA(1)) {
			case MANAGER:
				{
				setState(248); match(MANAGER);
				 ((DefineContext)_localctx).type =  DefineType.MANAGER; 
				}
				break;
			case STATE:
				{
				setState(250); match(STATE);
				 ((DefineContext)_localctx).type =  DefineType.STATE;   
				}
				break;
			case BEHAVIOR:
				{
				setState(252); match(BEHAVIOR);
				 ((DefineContext)_localctx).type =  DefineType.BEHAVIOR;
				}
				break;
			case ENTITY:
				{
				setState(254); match(ENTITY);
				 ((DefineContext)_localctx).type =  DefineType.ENTITY;  
				}
				break;
			case GOAL:
				{
				setState(256); match(GOAL);
				 ((DefineContext)_localctx).type =  DefineType.GOAL;    
				}
				break;
			case MESSAGE:
				{
				setState(258); match(MESSAGE);
				 ((DefineContext)_localctx).type =  DefineType.MESSAGE; 
				}
				break;
			case ASSET:
				{
				setState(260); match(ASSET);
				 ((DefineContext)_localctx).type =  DefineType.ASSET;   
				}
				break;
			case ID:
				{
				setState(262); ((DefineContext)_localctx).ID = match(ID);
				 ((DefineContext)_localctx).type =  DefineType.valueOf((((DefineContext)_localctx).ID!=null?((DefineContext)_localctx).ID.getText():null));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(266); ((DefineContext)_localctx).ID = match(ID);
			 ((DefineContext)_localctx).defName =  (((DefineContext)_localctx).ID!=null?((DefineContext)_localctx).ID.getText():null); 
			setState(272);
			_la = _input.LA(1);
			if (_la==ABRE_PAR) {
				{
				setState(268); match(ABRE_PAR);
				setState(269); nameList();
				setState(270); match(CIERRA_PAR);
				}
			}

			setState(274); match(ABRE_COR);
			setState(275); defineValues();
			setState(276); match(CIERRA_COR);
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
			setState(278); match(ON);
			setState(279); ((OnContext)_localctx).ID = match(ID);
			((OnContext)_localctx).messageName =  (((OnContext)_localctx).ID!=null?((OnContext)_localctx).ID.getText():null); 
			setState(283);
			_la = _input.LA(1);
			if (_la==DOUBLEDOT) {
				{
				setState(281); match(DOUBLEDOT);
				setState(282); ((OnContext)_localctx).filters = onFilters();
				}
			}

			setState(285); match(ABRE_COR);
			setState(286); statements();
			setState(287); match(CIERRA_COR);
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
			setState(294);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 6)) & ~0x3f) == 0 && ((1L << (_la - 6)) & ((1L << (SEND - 6)) | (1L << (DESTROY - 6)) | (1L << (SUBSCRIBE - 6)) | (1L << (UNSUBSCRIBE - 6)) | (1L << (ID - 6)))) != 0)) {
				{
				{
				setState(289); statement();
				setState(290); match(DOTCOMA);
				}
				}
				setState(296);
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
			setState(302);
			switch (_input.LA(1)) {
			case SEND:
				enterOuterAlt(_localctx, 1);
				{
				setState(297); send();
				}
				break;
			case DESTROY:
				enterOuterAlt(_localctx, 2);
				{
				setState(298); destroy();
				}
				break;
			case SUBSCRIBE:
				enterOuterAlt(_localctx, 3);
				{
				setState(299); subscribe();
				}
				break;
			case UNSUBSCRIBE:
				enterOuterAlt(_localctx, 4);
				{
				setState(300); unsubscribe();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(301); assign();
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
			setState(304); ((AssignContext)_localctx).varName = match(ID);
			setState(305); match(EQUAL);
			setState(306); expr(0);
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
			setState(308); match(DESTROY);
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
			setState(311); match(SEND);
			setState(312); ((SendContext)_localctx).method = match(ID);
			((SendContext)_localctx).messageMethodName =  (((SendContext)_localctx).method!=null?((SendContext)_localctx).method.getText():null);
			setState(319);
			_la = _input.LA(1);
			if (_la==ABRE_PAR) {
				{
				setState(314); match(ABRE_PAR);
				setState(316);
				_la = _input.LA(1);
				if (((((_la - 20)) & ~0x3f) == 0 && ((1L << (_la - 20)) & ((1L << (MANAGER - 20)) | (1L << (GAME - 20)) | (1L << (STATE - 20)) | (1L << (ASSET - 20)) | (1L << (BEHAVIOR - 20)) | (1L << (ENTITY - 20)) | (1L << (GOAL - 20)) | (1L << (MESSAGE - 20)) | (1L << (EMPTY - 20)) | (1L << (ABRE_PAR - 20)) | (1L << (ABRE_LLAV - 20)) | (1L << (MINUS - 20)) | (1L << (NOT - 20)) | (1L << (DIRECTCODE - 20)) | (1L << (INT_LITERAL - 20)) | (1L << (DECIMAL_LITERAL - 20)) | (1L << (STRING_LITERAL - 20)) | (1L << (BOOL_LITERAL - 20)) | (1L << (PARENT_LITERAL - 20)) | (1L << (CURRENT_LITERAL - 20)) | (1L << (ID - 20)))) != 0)) {
					{
					setState(315); exprList();
					}
				}

				setState(318); match(CIERRA_PAR);
				}
			}

			setState(331);
			_la = _input.LA(1);
			if (_la==TO) {
				{
				setState(321); match(TO);
				setState(328);
				switch (_input.LA(1)) {
				case OTHER:
					{
					setState(322); ((SendContext)_localctx).receiver = match(OTHER);
					((SendContext)_localctx).receiverType =  Instance.Other;
					}
					break;
				case GAME:
					{
					setState(324); ((SendContext)_localctx).receiver = match(GAME);
					((SendContext)_localctx).receiverType =  Instance.Game;
					}
					break;
				case ID:
					{
					setState(326); ((SendContext)_localctx).receiver = match(ID);
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
			setState(333); filter();
			setState(337);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(334); filter();
				}
				}
				setState(339);
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
			setState(340); ((FilterContext)_localctx).ID = match(ID);
			((FilterContext)_localctx).filterName =  (((FilterContext)_localctx).ID!=null?((FilterContext)_localctx).ID.getText():null);
			setState(347);
			_la = _input.LA(1);
			if (_la==ABRE_PAR) {
				{
				setState(342); match(ABRE_PAR);
				setState(344);
				_la = _input.LA(1);
				if (((((_la - 20)) & ~0x3f) == 0 && ((1L << (_la - 20)) & ((1L << (MANAGER - 20)) | (1L << (GAME - 20)) | (1L << (STATE - 20)) | (1L << (ASSET - 20)) | (1L << (BEHAVIOR - 20)) | (1L << (ENTITY - 20)) | (1L << (GOAL - 20)) | (1L << (MESSAGE - 20)) | (1L << (EMPTY - 20)) | (1L << (ABRE_PAR - 20)) | (1L << (ABRE_LLAV - 20)) | (1L << (MINUS - 20)) | (1L << (NOT - 20)) | (1L << (DIRECTCODE - 20)) | (1L << (INT_LITERAL - 20)) | (1L << (DECIMAL_LITERAL - 20)) | (1L << (STRING_LITERAL - 20)) | (1L << (BOOL_LITERAL - 20)) | (1L << (PARENT_LITERAL - 20)) | (1L << (CURRENT_LITERAL - 20)) | (1L << (ID - 20)))) != 0)) {
					{
					setState(343); exprList();
					}
				}

				setState(346); match(CIERRA_PAR);
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
			setState(352);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << ON) | (1L << SET) | (1L << ASSETS) | (1L << FLAG) | (1L << WHEN))) != 0)) {
				{
				{
				setState(349); defineValue();
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

	public static class DefineValueContext extends ParserRuleContext {
		public OnContext on() {
			return getRuleContext(OnContext.class,0);
		}
		public AddContext add() {
			return getRuleContext(AddContext.class,0);
		}
		public TerminalNode DOTCOMA() { return getToken(FP4GParser.DOTCOMA, 0); }
		public FlagsContext flags() {
			return getRuleContext(FlagsContext.class,0);
		}
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
			setState(367);
			switch (_input.LA(1)) {
			case ADD:
				enterOuterAlt(_localctx, 1);
				{
				setState(355); add();
				setState(356); match(DOTCOMA);
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 2);
				{
				setState(358); set();
				setState(359); match(DOTCOMA);
				}
				break;
			case ON:
				enterOuterAlt(_localctx, 3);
				{
				setState(361); on();
				}
				break;
			case ASSETS:
				enterOuterAlt(_localctx, 4);
				{
				setState(362); assets();
				}
				break;
			case FLAG:
				enterOuterAlt(_localctx, 5);
				{
				setState(363); flags();
				}
				break;
			case WHEN:
				enterOuterAlt(_localctx, 6);
				{
				setState(364); when();
				setState(365); match(DOTCOMA);
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
			setState(369); expr(0);
			setState(374);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(370); match(COMA);
				setState(371); expr(0);
				}
				}
				setState(376);
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
			setState(377); declareVar();
			setState(382);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(378); match(COMA);
				setState(379); declareVar();
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
			setState(385); varType();
			setState(386); ((DeclareVarContext)_localctx).varName = match(ID);
			setState(389);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(387); match(EQUAL);
				setState(388); ((DeclareVarContext)_localctx).initValue = expr(0);
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
			setState(406);
			switch (_input.LA(1)) {
			case NUMBER_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(391); match(NUMBER_TYPE);
				((VarTypeContext)_localctx).type =  BasicType.Number;
				}
				break;
			case BOOL_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(393); match(BOOL_TYPE);
				((VarTypeContext)_localctx).type =  BasicType.Bool;
				}
				break;
			case STRING_TYPE:
				enterOuterAlt(_localctx, 3);
				{
				setState(395); match(STRING_TYPE);
				((VarTypeContext)_localctx).type =  BasicType.String;
				}
				break;
			case INTEGER_TYPE:
				enterOuterAlt(_localctx, 4);
				{
				setState(397); match(INTEGER_TYPE);
				((VarTypeContext)_localctx).type =  BasicType.Integer;
				}
				break;
			case DOUBLE_TYPE:
				enterOuterAlt(_localctx, 5);
				{
				setState(399); match(DOUBLE_TYPE);
				((VarTypeContext)_localctx).type =  BasicType.Double;
				}
				break;
			case FLOAT_TYPE:
				enterOuterAlt(_localctx, 6);
				{
				setState(401); match(FLOAT_TYPE);
				((VarTypeContext)_localctx).type =  BasicType.Float;
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 7);
				{
				setState(403); ((VarTypeContext)_localctx).id = defineID();
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
			setState(411);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(408); ((DefineIDContext)_localctx).defineType = match(ID);
				setState(409); match(DOUBLEDOT);
				((DefineIDContext)_localctx).type =  (((DefineIDContext)_localctx).defineType!=null?((DefineIDContext)_localctx).defineType.getText():null);
				}
				break;
			}
			setState(413); ((DefineIDContext)_localctx).defineName = match(ID);
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
			setState(416); match(ASSETS);
			setState(417); match(ABRE_COR);
			setState(418); assetValueWithInnerValue();
			setState(423);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(419); match(COMA);
					setState(420); assetValueWithInnerValue();
					}
					} 
				}
				setState(425);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			}
			setState(427);
			_la = _input.LA(1);
			if (_la==COMA) {
				{
				setState(426); match(COMA);
				}
			}

			setState(429); match(CIERRA_COR);
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
			setState(431); ((AssetValueWithInnerValueContext)_localctx).value = assetValue();
			setState(433);
			_la = _input.LA(1);
			if (_la==ABRE_COR) {
				{
				setState(432); ((AssetValueWithInnerValueContext)_localctx).innerAssets = assetValuesInner();
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
			setState(435); ((AssetValueContext)_localctx).assetType = match(ID);
			setState(437);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(436); ((AssetValueContext)_localctx).assetName = match(ID);
				}
			}

			setState(439); match(DOUBLEDOT);
			setState(440); ((AssetValueContext)_localctx).assetPath = match(STRING_LITERAL);
			setState(442);
			_la = _input.LA(1);
			if (_la==EMPTY || _la==ABRE_LLAV) {
				{
				setState(441); ((AssetValueContext)_localctx).exprParams = array();
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
			setState(444); match(ABRE_COR);
			setState(445); assetValue();
			setState(450);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(446); match(COMA);
					setState(447); assetValue();
					}
					} 
				}
				setState(452);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			}
			setState(454);
			_la = _input.LA(1);
			if (_la==COMA) {
				{
				setState(453); match(COMA);
				}
			}

			setState(456); match(CIERRA_COR);
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

	public static class FlagsContext extends ParserRuleContext {
		public FlagContext flag(int i) {
			return getRuleContext(FlagContext.class,i);
		}
		public TerminalNode DOTCOMA(int i) {
			return getToken(FP4GParser.DOTCOMA, i);
		}
		public List<FlagContext> flag() {
			return getRuleContexts(FlagContext.class);
		}
		public List<TerminalNode> DOTCOMA() { return getTokens(FP4GParser.DOTCOMA); }
		public FlagsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flags; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitFlags(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FlagsContext flags() throws RecognitionException {
		FlagsContext _localctx = new FlagsContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_flags);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(458); flag();
			setState(459); match(DOTCOMA);
			setState(465);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(460); flag();
					setState(461); match(DOTCOMA);
					}
					} 
				}
				setState(467);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
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
		enterRule(_localctx, 74, RULE_flag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(468); match(FLAG);
			setState(469); declareVar();
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
		enterRule(_localctx, 76, RULE_when);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471); match(WHEN);
			setState(472); ((WhenContext)_localctx).condition = expr(0);
			setState(473); match(THEN);
			setState(474); ((WhenContext)_localctx).stmnt = statement();
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
		int _startState = 78;
		enterRecursionRule(_localctx, RULE_expr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(498);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(477); match(NOT);
				setState(478); ((NotExprContext)_localctx).op = expr(17);
				}
				break;

			case 2:
				{
				_localctx = new MinusExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(479); match(MINUS);
				setState(480); ((MinusExprContext)_localctx).op = expr(12);
				}
				break;

			case 3:
				{
				_localctx = new ArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(481); array();
				}
				break;

			case 4:
				{
				_localctx = new ParExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(482); match(ABRE_PAR);
				setState(483); ((ParExprContext)_localctx).op = expr(0);
				setState(484); match(CIERRA_PAR);
				}
				break;

			case 5:
				{
				_localctx = new IntLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(486); match(INT_LITERAL);
				}
				break;

			case 6:
				{
				_localctx = new DecimalLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(487); match(DECIMAL_LITERAL);
				}
				break;

			case 7:
				{
				_localctx = new StringLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(488); match(STRING_LITERAL);
				}
				break;

			case 8:
				{
				_localctx = new BoolLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(489); match(BOOL_LITERAL);
				}
				break;

			case 9:
				{
				_localctx = new DirectCodeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(490); match(DIRECTCODE);
				}
				break;

			case 10:
				{
				_localctx = new FunctionCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(491); ((FunctionCallExprContext)_localctx).functionName = match(ID);
				setState(492); match(ABRE_PAR);
				setState(494);
				_la = _input.LA(1);
				if (((((_la - 20)) & ~0x3f) == 0 && ((1L << (_la - 20)) & ((1L << (MANAGER - 20)) | (1L << (GAME - 20)) | (1L << (STATE - 20)) | (1L << (ASSET - 20)) | (1L << (BEHAVIOR - 20)) | (1L << (ENTITY - 20)) | (1L << (GOAL - 20)) | (1L << (MESSAGE - 20)) | (1L << (EMPTY - 20)) | (1L << (ABRE_PAR - 20)) | (1L << (ABRE_LLAV - 20)) | (1L << (MINUS - 20)) | (1L << (NOT - 20)) | (1L << (DIRECTCODE - 20)) | (1L << (INT_LITERAL - 20)) | (1L << (DECIMAL_LITERAL - 20)) | (1L << (STRING_LITERAL - 20)) | (1L << (BOOL_LITERAL - 20)) | (1L << (PARENT_LITERAL - 20)) | (1L << (CURRENT_LITERAL - 20)) | (1L << (ID - 20)))) != 0)) {
					{
					setState(493); exprList();
					}
				}

				setState(496); match(CIERRA_PAR);
				}
				break;

			case 11:
				{
				_localctx = new VarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(497); accessVarOp();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(523);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(521);
					switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
					case 1:
						{
						_localctx = new LessThanExprContext(new ExprContext(_parentctx, _parentState, _p));
						((LessThanExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(500);
						if (!(16 >= _localctx._p)) throw new FailedPredicateException(this, "16 >= $_p");
						setState(501); match(LESS_THAN);
						setState(502); ((LessThanExprContext)_localctx).right = expr(17);
						}
						break;

					case 2:
						{
						_localctx = new MoreThanExprContext(new ExprContext(_parentctx, _parentState, _p));
						((MoreThanExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(503);
						if (!(15 >= _localctx._p)) throw new FailedPredicateException(this, "15 >= $_p");
						setState(504); match(MORE_THAN);
						setState(505); ((MoreThanExprContext)_localctx).right = expr(16);
						}
						break;

					case 3:
						{
						_localctx = new EqualExprContext(new ExprContext(_parentctx, _parentState, _p));
						((EqualExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(506);
						if (!(14 >= _localctx._p)) throw new FailedPredicateException(this, "14 >= $_p");
						setState(507); match(EQUAL);
						setState(508); ((EqualExprContext)_localctx).right = expr(15);
						}
						break;

					case 4:
						{
						_localctx = new MultExprContext(new ExprContext(_parentctx, _parentState, _p));
						((MultExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(509);
						if (!(11 >= _localctx._p)) throw new FailedPredicateException(this, "11 >= $_p");
						setState(510); match(MULTIPLY);
						setState(511); ((MultExprContext)_localctx).right = expr(12);
						}
						break;

					case 5:
						{
						_localctx = new DivExprContext(new ExprContext(_parentctx, _parentState, _p));
						((DivExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(512);
						if (!(10 >= _localctx._p)) throw new FailedPredicateException(this, "10 >= $_p");
						setState(513); match(DIVIDE);
						setState(514); ((DivExprContext)_localctx).right = expr(11);
						}
						break;

					case 6:
						{
						_localctx = new AddExprContext(new ExprContext(_parentctx, _parentState, _p));
						((AddExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(515);
						if (!(9 >= _localctx._p)) throw new FailedPredicateException(this, "9 >= $_p");
						setState(516); match(PLUS);
						setState(517); ((AddExprContext)_localctx).right = expr(10);
						}
						break;

					case 7:
						{
						_localctx = new SubExprContext(new ExprContext(_parentctx, _parentState, _p));
						((SubExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(518);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(519); match(MINUS);
						setState(520); ((SubExprContext)_localctx).right = expr(9);
						}
						break;
					}
					} 
				}
				setState(525);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
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
		enterRule(_localctx, 80, RULE_accessVarOp);
		try {
			setState(532);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				_localctx = new AccessVarNameContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(526); ((AccessVarNameContext)_localctx).var = varOp();
				}
				break;

			case 2:
				_localctx = new AccessVarOperatorContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(527); ((AccessVarOperatorContext)_localctx).pVar = parentVarOp();
				setState(530);
				switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
				case 1:
					{
					setState(528); match(DOT);
					setState(529); ((AccessVarOperatorContext)_localctx).propertyAccess = accessVarOp();
					}
					break;
				}
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
	public static class ParentOperatorContext extends ParentVarOpContext {
		public TerminalNode PARENT_LITERAL() { return getToken(FP4GParser.PARENT_LITERAL, 0); }
		public ParentOperatorContext(ParentVarOpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitParentOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParentVarOpContext parentVarOp() throws RecognitionException {
		ParentVarOpContext _localctx = new ParentVarOpContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_parentVarOp);
		try {
			setState(539);
			switch (_input.LA(1)) {
			case CURRENT_LITERAL:
				_localctx = new CurrentOperatorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(534); match(CURRENT_LITERAL);
				}
				break;
			case PARENT_LITERAL:
				_localctx = new ParentOperatorContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(535); match(PARENT_LITERAL);
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
				enterOuterAlt(_localctx, 3);
				{
				setState(536); ((VarNameOperatorContext)_localctx).varName = varID();
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
	public static class VarParentContext extends VarOpContext {
		public TerminalNode PARENT_LITERAL() { return getToken(FP4GParser.PARENT_LITERAL, 0); }
		public VarParentContext(VarOpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitVarParent(this);
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
		enterRule(_localctx, 84, RULE_varOp);
		try {
			setState(544);
			switch (_input.LA(1)) {
			case CURRENT_LITERAL:
				_localctx = new VarCurrentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(541); match(CURRENT_LITERAL);
				}
				break;
			case PARENT_LITERAL:
				_localctx = new VarParentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(542); match(PARENT_LITERAL);
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
				enterOuterAlt(_localctx, 3);
				{
				setState(543); ((VarNameContext)_localctx).varName = varID();
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
		enterRule(_localctx, 86, RULE_varID);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(546);
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
		enterRule(_localctx, 88, RULE_array);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(548); arrayBody();
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
		enterRule(_localctx, 90, RULE_arrayBody);
		int _la;
		try {
			int _alt;
			setState(590);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				_localctx = new AssocArrayContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(550); match(ABRE_LLAV);
				{
				setState(551); parArray();
				setState(556);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(552); match(COMA);
						setState(553); parArray();
						}
						} 
					}
					setState(558);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
				}
				setState(560);
				_la = _input.LA(1);
				if (_la==COMA) {
					{
					setState(559); match(COMA);
					}
				}

				}
				setState(562); match(CIERRA_LLAV);
				setState(566);
				switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
				case 1:
					{
					setState(563); match(AS);
					setState(564); ((AssocArrayContext)_localctx).ID = match(ID);
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
				setState(568); match(ABRE_LLAV);
				{
				setState(569); itemArray();
				setState(574);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(570); match(COMA);
						setState(571); itemArray();
						}
						} 
					}
					setState(576);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
				}
				setState(578);
				_la = _input.LA(1);
				if (_la==COMA) {
					{
					setState(577); match(COMA);
					}
				}

				}
				setState(580); match(CIERRA_LLAV);
				setState(584);
				switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
				case 1:
					{
					setState(581); match(AS);
					setState(582); ((ListArrayContext)_localctx).ID = match(ID);
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
				setState(586); match(EMPTY);
				setState(587); match(AS);
				setState(588); ((EmptyArrayContext)_localctx).ID = match(ID);
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
		enterRule(_localctx, 92, RULE_itemArray);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(592); expr(0);
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
		enterRule(_localctx, 94, RULE_parArray);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(594); ((ParArrayContext)_localctx).ID = match(ID);
			 ((ParArrayContext)_localctx).key =  (((ParArrayContext)_localctx).ID!=null?((ParArrayContext)_localctx).ID.getText():null); 
			setState(596); match(EQUAL);
			setState(597); expr(0);
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
		case 39: return expr_sempred((ExprContext)_localctx, predIndex);
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3I\u025a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\3\2\3\2\3\2\3\2\3\3\7\3h\n"+
		"\3\f\3\16\3k\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\5\4|\n\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0084\n\4\3\5\7\5\u0087"+
		"\n\5\f\5\16\5\u008a\13\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u0092\n\6\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\7\t\u00a3\n\t\f\t"+
		"\16\t\u00a6\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\5\n\u00b7\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\5\r\u00c9\n\r\3\16\3\16\3\16\3\16\3\16\3\16\5\16"+
		"\u00d1\n\16\3\17\3\17\3\17\5\17\u00d6\n\17\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\5\20\u00e2\n\20\3\20\3\20\3\20\3\20\5\20\u00e8"+
		"\n\20\3\20\5\20\u00eb\n\20\3\20\5\20\u00ee\n\20\3\21\3\21\3\21\3\21\5"+
		"\21\u00f4\n\21\3\21\3\21\5\21\u00f8\n\21\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u010b\n\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0113\n\22\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\3\23\5\23\u011e\n\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24"+
		"\7\24\u0127\n\24\f\24\16\24\u012a\13\24\3\25\3\25\3\25\3\25\3\25\5\25"+
		"\u0131\n\25\3\26\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\5\30\u013f\n\30\3\30\5\30\u0142\n\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\5\30\u014b\n\30\3\30\5\30\u014e\n\30\3\31\3\31\7\31\u0152\n\31\f\31"+
		"\16\31\u0155\13\31\3\32\3\32\3\32\3\32\5\32\u015b\n\32\3\32\5\32\u015e"+
		"\n\32\3\33\7\33\u0161\n\33\f\33\16\33\u0164\13\33\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0172\n\34\3\35\3\35\3\35"+
		"\7\35\u0177\n\35\f\35\16\35\u017a\13\35\3\36\3\36\3\36\7\36\u017f\n\36"+
		"\f\36\16\36\u0182\13\36\3\37\3\37\3\37\3\37\5\37\u0188\n\37\3 \3 \3 \3"+
		" \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u0199\n \3!\3!\3!\5!\u019e\n!\3"+
		"!\3!\3!\3\"\3\"\3\"\3\"\3\"\7\"\u01a8\n\"\f\"\16\"\u01ab\13\"\3\"\5\""+
		"\u01ae\n\"\3\"\3\"\3#\3#\5#\u01b4\n#\3$\3$\5$\u01b8\n$\3$\3$\3$\5$\u01bd"+
		"\n$\3%\3%\3%\3%\7%\u01c3\n%\f%\16%\u01c6\13%\3%\5%\u01c9\n%\3%\3%\3&\3"+
		"&\3&\3&\3&\7&\u01d2\n&\f&\16&\u01d5\13&\3\'\3\'\3\'\3(\3(\3(\3(\3(\3)"+
		"\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\5)\u01f1\n)\3)\3)"+
		"\5)\u01f5\n)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)"+
		"\3)\3)\7)\u020c\n)\f)\16)\u020f\13)\3*\3*\3*\3*\5*\u0215\n*\5*\u0217\n"+
		"*\3+\3+\3+\3+\3+\5+\u021e\n+\3,\3,\3,\5,\u0223\n,\3-\3-\3.\3.\3/\3/\3"+
		"/\3/\7/\u022d\n/\f/\16/\u0230\13/\3/\5/\u0233\n/\3/\3/\3/\3/\5/\u0239"+
		"\n/\3/\3/\3/\3/\7/\u023f\n/\f/\16/\u0242\13/\3/\5/\u0245\n/\3/\3/\3/\3"+
		"/\5/\u024b\n/\3/\3/\3/\3/\5/\u0251\n/\3\60\3\60\3\61\3\61\3\61\3\61\3"+
		"\61\3\61\2\62\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
		"\668:<>@BDFHJLNPRTVXZ\\^`\2\3\4\2\26\35GG\u0294\2b\3\2\2\2\4i\3\2\2\2"+
		"\6l\3\2\2\2\b\u0088\3\2\2\2\n\u0091\3\2\2\2\f\u0093\3\2\2\2\16\u009b\3"+
		"\2\2\2\20\u00a4\3\2\2\2\22\u00b6\3\2\2\2\24\u00b8\3\2\2\2\26\u00be\3\2"+
		"\2\2\30\u00c2\3\2\2\2\32\u00ca\3\2\2\2\34\u00d2\3\2\2\2\36\u00e1\3\2\2"+
		"\2 \u00ef\3\2\2\2\"\u00f9\3\2\2\2$\u0118\3\2\2\2&\u0128\3\2\2\2(\u0130"+
		"\3\2\2\2*\u0132\3\2\2\2,\u0136\3\2\2\2.\u0138\3\2\2\2\60\u014f\3\2\2\2"+
		"\62\u0156\3\2\2\2\64\u0162\3\2\2\2\66\u0171\3\2\2\28\u0173\3\2\2\2:\u017b"+
		"\3\2\2\2<\u0183\3\2\2\2>\u0198\3\2\2\2@\u019d\3\2\2\2B\u01a2\3\2\2\2D"+
		"\u01b1\3\2\2\2F\u01b5\3\2\2\2H\u01be\3\2\2\2J\u01cc\3\2\2\2L\u01d6\3\2"+
		"\2\2N\u01d9\3\2\2\2P\u01f4\3\2\2\2R\u0216\3\2\2\2T\u021d\3\2\2\2V\u0222"+
		"\3\2\2\2X\u0224\3\2\2\2Z\u0226\3\2\2\2\\\u0250\3\2\2\2^\u0252\3\2\2\2"+
		"`\u0254\3\2\2\2bc\5\4\3\2cd\5\f\7\2de\7\2\2\3e\3\3\2\2\2fh\5\6\4\2gf\3"+
		"\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2j\5\3\2\2\2ki\3\2\2\2l{\7\17\2\2m"+
		"n\7\26\2\2n|\b\4\1\2op\7\30\2\2p|\b\4\1\2qr\7\32\2\2r|\b\4\1\2st\7\33"+
		"\2\2t|\b\4\1\2uv\7\34\2\2v|\b\4\1\2wx\7\35\2\2x|\b\4\1\2yz\7G\2\2z|\b"+
		"\4\1\2{m\3\2\2\2{o\3\2\2\2{q\3\2\2\2{s\3\2\2\2{u\3\2\2\2{w\3\2\2\2{y\3"+
		"\2\2\2|}\3\2\2\2}\u0083\7G\2\2~\u0084\7.\2\2\177\u0080\7%\2\2\u0080\u0081"+
		"\5\b\5\2\u0081\u0082\7(\2\2\u0082\u0084\3\2\2\2\u0083~\3\2\2\2\u0083\177"+
		"\3\2\2\2\u0084\7\3\2\2\2\u0085\u0087\5\n\6\2\u0086\u0085\3\2\2\2\u0087"+
		"\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\t\3\2\2\2"+
		"\u008a\u0088\3\2\2\2\u008b\u008c\5\34\17\2\u008c\u008d\7.\2\2\u008d\u0092"+
		"\3\2\2\2\u008e\u008f\5\24\13\2\u008f\u0090\7.\2\2\u0090\u0092\3\2\2\2"+
		"\u0091\u008b\3\2\2\2\u0091\u008e\3\2\2\2\u0092\13\3\2\2\2\u0093\u0094"+
		"\7\5\2\2\u0094\u0095\7\27\2\2\u0095\u0096\7G\2\2\u0096\u0097\b\7\1\2\u0097"+
		"\u0098\7%\2\2\u0098\u0099\5\20\t\2\u0099\u009a\7(\2\2\u009a\r\3\2\2\2"+
		"\u009b\u009c\7\5\2\2\u009c\u009d\7\27\2\2\u009d\u009e\7%\2\2\u009e\u009f"+
		"\5\20\t\2\u009f\u00a0\7(\2\2\u00a0\17\3\2\2\2\u00a1\u00a3\5\22\n\2\u00a2"+
		"\u00a1\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2"+
		"\2\2\u00a5\21\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00b7\5\"\22\2\u00a8\u00a9"+
		"\5\34\17\2\u00a9\u00aa\7.\2\2\u00aa\u00b7\3\2\2\2\u00ab\u00ac\5\24\13"+
		"\2\u00ac\u00ad\7.\2\2\u00ad\u00b7\3\2\2\2\u00ae\u00af\5\26\f\2\u00af\u00b0"+
		"\7.\2\2\u00b0\u00b7\3\2\2\2\u00b1\u00b2\5N(\2\u00b2\u00b3\7.\2\2\u00b3"+
		"\u00b7\3\2\2\2\u00b4\u00b7\5$\23\2\u00b5\u00b7\5J&\2\u00b6\u00a7\3\2\2"+
		"\2\u00b6\u00a8\3\2\2\2\u00b6\u00ab\3\2\2\2\u00b6\u00ae\3\2\2\2\u00b6\u00b1"+
		"\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b5\3\2\2\2\u00b7\23\3\2\2\2\u00b8"+
		"\u00b9\7\21\2\2\u00b9\u00ba\7G\2\2\u00ba\u00bb\b\13\1\2\u00bb\u00bc\7"+
		",\2\2\u00bc\u00bd\5P)\2\u00bd\25\3\2\2\2\u00be\u00bf\7\22\2\2\u00bf\u00c0"+
		"\7G\2\2\u00c0\u00c1\b\f\1\2\u00c1\27\3\2\2\2\u00c2\u00c3\7\13\2\2\u00c3"+
		"\u00c4\7G\2\2\u00c4\u00c5\7\7\2\2\u00c5\u00c8\7G\2\2\u00c6\u00c7\7/\2"+
		"\2\u00c7\u00c9\7G\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\31"+
		"\3\2\2\2\u00ca\u00cb\7\f\2\2\u00cb\u00cc\7G\2\2\u00cc\u00cd\7\7\2\2\u00cd"+
		"\u00d0\7G\2\2\u00ce\u00cf\7/\2\2\u00cf\u00d1\7G\2\2\u00d0\u00ce\3\2\2"+
		"\2\u00d0\u00d1\3\2\2\2\u00d1\33\3\2\2\2\u00d2\u00d5\7\6\2\2\u00d3\u00d6"+
		"\5\36\20\2\u00d4\u00d6\5 \21\2\u00d5\u00d3\3\2\2\2\u00d5\u00d4\3\2\2\2"+
		"\u00d6\35\3\2\2\2\u00d7\u00d8\7\26\2\2\u00d8\u00e2\b\20\1\2\u00d9\u00da"+
		"\7\30\2\2\u00da\u00e2\b\20\1\2\u00db\u00dc\7\32\2\2\u00dc\u00e2\b\20\1"+
		"\2\u00dd\u00de\7\33\2\2\u00de\u00e2\b\20\1\2\u00df\u00e0\7\34\2\2\u00e0"+
		"\u00e2\b\20\1\2\u00e1\u00d7\3\2\2\2\u00e1\u00d9\3\2\2\2\u00e1\u00db\3"+
		"\2\2\2\u00e1\u00dd\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3"+
		"\u00e4\7G\2\2\u00e4\u00ea\b\20\1\2\u00e5\u00e7\7&\2\2\u00e6\u00e8\58\35"+
		"\2\u00e7\u00e6\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00eb"+
		"\7)\2\2\u00ea\u00e5\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ed\3\2\2\2\u00ec"+
		"\u00ee\5Z.\2\u00ed\u00ec\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\37\3\2\2\2"+
		"\u00ef\u00f0\7G\2\2\u00f0\u00f1\b\21\1\2\u00f1\u00f3\7&\2\2\u00f2\u00f4"+
		"\5:\36\2\u00f3\u00f2\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5"+
		"\u00f7\7)\2\2\u00f6\u00f8\5Z.\2\u00f7\u00f6\3\2\2\2\u00f7\u00f8\3\2\2"+
		"\2\u00f8!\3\2\2\2\u00f9\u010a\7\5\2\2\u00fa\u00fb\7\26\2\2\u00fb\u010b"+
		"\b\22\1\2\u00fc\u00fd\7\30\2\2\u00fd\u010b\b\22\1\2\u00fe\u00ff\7\32\2"+
		"\2\u00ff\u010b\b\22\1\2\u0100\u0101\7\33\2\2\u0101\u010b\b\22\1\2\u0102"+
		"\u0103\7\34\2\2\u0103\u010b\b\22\1\2\u0104\u0105\7\35\2\2\u0105\u010b"+
		"\b\22\1\2\u0106\u0107\7\31\2\2\u0107\u010b\b\22\1\2\u0108\u0109\7G\2\2"+
		"\u0109\u010b\b\22\1\2\u010a\u00fa\3\2\2\2\u010a\u00fc\3\2\2\2\u010a\u00fe"+
		"\3\2\2\2\u010a\u0100\3\2\2\2\u010a\u0102\3\2\2\2\u010a\u0104\3\2\2\2\u010a"+
		"\u0106\3\2\2\2\u010a\u0108\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010d\7G"+
		"\2\2\u010d\u0112\b\22\1\2\u010e\u010f\7&\2\2\u010f\u0110\5:\36\2\u0110"+
		"\u0111\7)\2\2\u0111\u0113\3\2\2\2\u0112\u010e\3\2\2\2\u0112\u0113\3\2"+
		"\2\2\u0113\u0114\3\2\2\2\u0114\u0115\7%\2\2\u0115\u0116\5\64\33\2\u0116"+
		"\u0117\7(\2\2\u0117#\3\2\2\2\u0118\u0119\7\7\2\2\u0119\u011a\7G\2\2\u011a"+
		"\u011d\b\23\1\2\u011b\u011c\7/\2\2\u011c\u011e\5\60\31\2\u011d\u011b\3"+
		"\2\2\2\u011d\u011e\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0120\7%\2\2\u0120"+
		"\u0121\5&\24\2\u0121\u0122\7(\2\2\u0122%\3\2\2\2\u0123\u0124\5(\25\2\u0124"+
		"\u0125\7.\2\2\u0125\u0127\3\2\2\2\u0126\u0123\3\2\2\2\u0127\u012a\3\2"+
		"\2\2\u0128\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129\'\3\2\2\2\u012a\u0128"+
		"\3\2\2\2\u012b\u0131\5.\30\2\u012c\u0131\5,\27\2\u012d\u0131\5\30\r\2"+
		"\u012e\u0131\5\32\16\2\u012f\u0131\5*\26\2\u0130\u012b\3\2\2\2\u0130\u012c"+
		"\3\2\2\2\u0130\u012d\3\2\2\2\u0130\u012e\3\2\2\2\u0130\u012f\3\2\2\2\u0131"+
		")\3\2\2\2\u0132\u0133\7G\2\2\u0133\u0134\7,\2\2\u0134\u0135\5P)\2\u0135"+
		"+\3\2\2\2\u0136\u0137\7\t\2\2\u0137-\3\2\2\2\u0138\u0139\b\30\1\2\u0139"+
		"\u013a\7\b\2\2\u013a\u013b\7G\2\2\u013b\u0141\b\30\1\2\u013c\u013e\7&"+
		"\2\2\u013d\u013f\58\35\2\u013e\u013d\3\2\2\2\u013e\u013f\3\2\2\2\u013f"+
		"\u0140\3\2\2\2\u0140\u0142\7)\2\2\u0141\u013c\3\2\2\2\u0141\u0142\3\2"+
		"\2\2\u0142\u014d\3\2\2\2\u0143\u014a\7\37\2\2\u0144\u0145\7\"\2\2\u0145"+
		"\u014b\b\30\1\2\u0146\u0147\7\27\2\2\u0147\u014b\b\30\1\2\u0148\u0149"+
		"\7G\2\2\u0149\u014b\b\30\1\2\u014a\u0144\3\2\2\2\u014a\u0146\3\2\2\2\u014a"+
		"\u0148\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u014e\b\30\1\2\u014d\u0143\3"+
		"\2\2\2\u014d\u014e\3\2\2\2\u014e/\3\2\2\2\u014f\u0153\5\62\32\2\u0150"+
		"\u0152\5\62\32\2\u0151\u0150\3\2\2\2\u0152\u0155\3\2\2\2\u0153\u0151\3"+
		"\2\2\2\u0153\u0154\3\2\2\2\u0154\61\3\2\2\2\u0155\u0153\3\2\2\2\u0156"+
		"\u0157\7G\2\2\u0157\u015d\b\32\1\2\u0158\u015a\7&\2\2\u0159\u015b\58\35"+
		"\2\u015a\u0159\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015e"+
		"\7)\2\2\u015d\u0158\3\2\2\2\u015d\u015e\3\2\2\2\u015e\63\3\2\2\2\u015f"+
		"\u0161\5\66\34\2\u0160\u015f\3\2\2\2\u0161\u0164\3\2\2\2\u0162\u0160\3"+
		"\2\2\2\u0162\u0163\3\2\2\2\u0163\65\3\2\2\2\u0164\u0162\3\2\2\2\u0165"+
		"\u0166\5\34\17\2\u0166\u0167\7.\2\2\u0167\u0172\3\2\2\2\u0168\u0169\5"+
		"\24\13\2\u0169\u016a\7.\2\2\u016a\u0172\3\2\2\2\u016b\u0172\5$\23\2\u016c"+
		"\u0172\5B\"\2\u016d\u0172\5J&\2\u016e\u016f\5N(\2\u016f\u0170\7.\2\2\u0170"+
		"\u0172\3\2\2\2\u0171\u0165\3\2\2\2\u0171\u0168\3\2\2\2\u0171\u016b\3\2"+
		"\2\2\u0171\u016c\3\2\2\2\u0171\u016d\3\2\2\2\u0171\u016e\3\2\2\2\u0172"+
		"\67\3\2\2\2\u0173\u0178\5P)\2\u0174\u0175\7+\2\2\u0175\u0177\5P)\2\u0176"+
		"\u0174\3\2\2\2\u0177\u017a\3\2\2\2\u0178\u0176\3\2\2\2\u0178\u0179\3\2"+
		"\2\2\u01799\3\2\2\2\u017a\u0178\3\2\2\2\u017b\u0180\5<\37\2\u017c\u017d"+
		"\7+\2\2\u017d\u017f\5<\37\2\u017e\u017c\3\2\2\2\u017f\u0182\3\2\2\2\u0180"+
		"\u017e\3\2\2\2\u0180\u0181\3\2\2\2\u0181;\3\2\2\2\u0182\u0180\3\2\2\2"+
		"\u0183\u0184\5> \2\u0184\u0187\7G\2\2\u0185\u0186\7,\2\2\u0186\u0188\5"+
		"P)\2\u0187\u0185\3\2\2\2\u0187\u0188\3\2\2\2\u0188=\3\2\2\2\u0189\u018a"+
		"\7:\2\2\u018a\u0199\b \1\2\u018b\u018c\7<\2\2\u018c\u0199\b \1\2\u018d"+
		"\u018e\7;\2\2\u018e\u0199\b \1\2\u018f\u0190\7=\2\2\u0190\u0199\b \1\2"+
		"\u0191\u0192\7>\2\2\u0192\u0199\b \1\2\u0193\u0194\7?\2\2\u0194\u0199"+
		"\b \1\2\u0195\u0196\5@!\2\u0196\u0197\b \1\2\u0197\u0199\3\2\2\2\u0198"+
		"\u0189\3\2\2\2\u0198\u018b\3\2\2\2\u0198\u018d\3\2\2\2\u0198\u018f\3\2"+
		"\2\2\u0198\u0191\3\2\2\2\u0198\u0193\3\2\2\2\u0198\u0195\3\2\2\2\u0199"+
		"?\3\2\2\2\u019a\u019b\7G\2\2\u019b\u019c\7/\2\2\u019c\u019e\b!\1\2\u019d"+
		"\u019a\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u01a0\7G"+
		"\2\2\u01a0\u01a1\b!\1\2\u01a1A\3\2\2\2\u01a2\u01a3\7\23\2\2\u01a3\u01a4"+
		"\7%\2\2\u01a4\u01a9\5D#\2\u01a5\u01a6\7+\2\2\u01a6\u01a8\5D#\2\u01a7\u01a5"+
		"\3\2\2\2\u01a8\u01ab\3\2\2\2\u01a9\u01a7\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa"+
		"\u01ad\3\2\2\2\u01ab\u01a9\3\2\2\2\u01ac\u01ae\7+\2\2\u01ad\u01ac\3\2"+
		"\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01af\3\2\2\2\u01af\u01b0\7(\2\2\u01b0"+
		"C\3\2\2\2\u01b1\u01b3\5F$\2\u01b2\u01b4\5H%\2\u01b3\u01b2\3\2\2\2\u01b3"+
		"\u01b4\3\2\2\2\u01b4E\3\2\2\2\u01b5\u01b7\7G\2\2\u01b6\u01b8\7G\2\2\u01b7"+
		"\u01b6\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01ba\7/"+
		"\2\2\u01ba\u01bc\7C\2\2\u01bb\u01bd\5Z.\2\u01bc\u01bb\3\2\2\2\u01bc\u01bd"+
		"\3\2\2\2\u01bdG\3\2\2\2\u01be\u01bf\7%\2\2\u01bf\u01c4\5F$\2\u01c0\u01c1"+
		"\7+\2\2\u01c1\u01c3\5F$\2\u01c2\u01c0\3\2\2\2\u01c3\u01c6\3\2\2\2\u01c4"+
		"\u01c2\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c8\3\2\2\2\u01c6\u01c4\3\2"+
		"\2\2\u01c7\u01c9\7+\2\2\u01c8\u01c7\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9"+
		"\u01ca\3\2\2\2\u01ca\u01cb\7(\2\2\u01cbI\3\2\2\2\u01cc\u01cd\5L\'\2\u01cd"+
		"\u01d3\7.\2\2\u01ce\u01cf\5L\'\2\u01cf\u01d0\7.\2\2\u01d0\u01d2\3\2\2"+
		"\2\u01d1\u01ce\3\2\2\2\u01d2\u01d5\3\2\2\2\u01d3\u01d1\3\2\2\2\u01d3\u01d4"+
		"\3\2\2\2\u01d4K\3\2\2\2\u01d5\u01d3\3\2\2\2\u01d6\u01d7\7\24\2\2\u01d7"+
		"\u01d8\5<\37\2\u01d8M\3\2\2\2\u01d9\u01da\7\25\2\2\u01da\u01db\5P)\2\u01db"+
		"\u01dc\7$\2\2\u01dc\u01dd\5(\25\2\u01ddO\3\2\2\2\u01de\u01df\b)\1\2\u01df"+
		"\u01e0\79\2\2\u01e0\u01f5\5P)\2\u01e1\u01e2\7\61\2\2\u01e2\u01f5\5P)\2"+
		"\u01e3\u01f5\5Z.\2\u01e4\u01e5\7&\2\2\u01e5\u01e6\5P)\2\u01e6\u01e7\7"+
		")\2\2\u01e7\u01f5\3\2\2\2\u01e8\u01f5\7A\2\2\u01e9\u01f5\7B\2\2\u01ea"+
		"\u01f5\7C\2\2\u01eb\u01f5\7D\2\2\u01ec\u01f5\7@\2\2\u01ed\u01ee\7G\2\2"+
		"\u01ee\u01f0\7&\2\2\u01ef\u01f1\58\35\2\u01f0\u01ef\3\2\2\2\u01f0\u01f1"+
		"\3\2\2\2\u01f1\u01f2\3\2\2\2\u01f2\u01f5\7)\2\2\u01f3\u01f5\5R*\2\u01f4"+
		"\u01de\3\2\2\2\u01f4\u01e1\3\2\2\2\u01f4\u01e3\3\2\2\2\u01f4\u01e4\3\2"+
		"\2\2\u01f4\u01e8\3\2\2\2\u01f4\u01e9\3\2\2\2\u01f4\u01ea\3\2\2\2\u01f4"+
		"\u01eb\3\2\2\2\u01f4\u01ec\3\2\2\2\u01f4\u01ed\3\2\2\2\u01f4\u01f3\3\2"+
		"\2\2\u01f5\u020d\3\2\2\2\u01f6\u01f7\6)\2\3\u01f7\u01f8\7\65\2\2\u01f8"+
		"\u020c\5P)\2\u01f9\u01fa\6)\3\3\u01fa\u01fb\7\64\2\2\u01fb\u020c\5P)\2"+
		"\u01fc\u01fd\6)\4\3\u01fd\u01fe\7,\2\2\u01fe\u020c\5P)\2\u01ff\u0200\6"+
		")\5\3\u0200\u0201\7\62\2\2\u0201\u020c\5P)\2\u0202\u0203\6)\6\3\u0203"+
		"\u0204\7\63\2\2\u0204\u020c\5P)\2\u0205\u0206\6)\7\3\u0206\u0207\7\60"+
		"\2\2\u0207\u020c\5P)\2\u0208\u0209\6)\b\3\u0209\u020a\7\61\2\2\u020a\u020c"+
		"\5P)\2\u020b\u01f6\3\2\2\2\u020b\u01f9\3\2\2\2\u020b\u01fc\3\2\2\2\u020b"+
		"\u01ff\3\2\2\2\u020b\u0202\3\2\2\2\u020b\u0205\3\2\2\2\u020b\u0208\3\2"+
		"\2\2\u020c\u020f\3\2\2\2\u020d\u020b\3\2\2\2\u020d\u020e\3\2\2\2\u020e"+
		"Q\3\2\2\2\u020f\u020d\3\2\2\2\u0210\u0217\5V,\2\u0211\u0214\5T+\2\u0212"+
		"\u0213\7-\2\2\u0213\u0215\5R*\2\u0214\u0212\3\2\2\2\u0214\u0215\3\2\2"+
		"\2\u0215\u0217\3\2\2\2\u0216\u0210\3\2\2\2\u0216\u0211\3\2\2\2\u0217S"+
		"\3\2\2\2\u0218\u021e\7F\2\2\u0219\u021e\7E\2\2\u021a\u021b\5X-\2\u021b"+
		"\u021c\b+\1\2\u021c\u021e\3\2\2\2\u021d\u0218\3\2\2\2\u021d\u0219\3\2"+
		"\2\2\u021d\u021a\3\2\2\2\u021eU\3\2\2\2\u021f\u0223\7F\2\2\u0220\u0223"+
		"\7E\2\2\u0221\u0223\5X-\2\u0222\u021f\3\2\2\2\u0222\u0220\3\2\2\2\u0222"+
		"\u0221\3\2\2\2\u0223W\3\2\2\2\u0224\u0225\t\2\2\2\u0225Y\3\2\2\2\u0226"+
		"\u0227\5\\/\2\u0227[\3\2\2\2\u0228\u0229\7\'\2\2\u0229\u022e\5`\61\2\u022a"+
		"\u022b\7+\2\2\u022b\u022d\5`\61\2\u022c\u022a\3\2\2\2\u022d\u0230\3\2"+
		"\2\2\u022e\u022c\3\2\2\2\u022e\u022f\3\2\2\2\u022f\u0232\3\2\2\2\u0230"+
		"\u022e\3\2\2\2\u0231\u0233\7+\2\2\u0232\u0231\3\2\2\2\u0232\u0233\3\2"+
		"\2\2\u0233\u0234\3\2\2\2\u0234\u0238\7*\2\2\u0235\u0236\7!\2\2\u0236\u0237"+
		"\7G\2\2\u0237\u0239\b/\1\2\u0238\u0235\3\2\2\2\u0238\u0239\3\2\2\2\u0239"+
		"\u0251\3\2\2\2\u023a\u023b\7\'\2\2\u023b\u0240\5^\60\2\u023c\u023d\7+"+
		"\2\2\u023d\u023f\5^\60\2\u023e\u023c\3\2\2\2\u023f\u0242\3\2\2\2\u0240"+
		"\u023e\3\2\2\2\u0240\u0241\3\2\2\2\u0241\u0244\3\2\2\2\u0242\u0240\3\2"+
		"\2\2\u0243\u0245\7+\2\2\u0244\u0243\3\2\2\2\u0244\u0245\3\2\2\2\u0245"+
		"\u0246\3\2\2\2\u0246\u024a\7*\2\2\u0247\u0248\7!\2\2\u0248\u0249\7G\2"+
		"\2\u0249\u024b\b/\1\2\u024a\u0247\3\2\2\2\u024a\u024b\3\2\2\2\u024b\u0251"+
		"\3\2\2\2\u024c\u024d\7#\2\2\u024d\u024e\7!\2\2\u024e\u024f\7G\2\2\u024f"+
		"\u0251\b/\1\2\u0250\u0228\3\2\2\2\u0250\u023a\3\2\2\2\u0250\u024c\3\2"+
		"\2\2\u0251]\3\2\2\2\u0252\u0253\5P)\2\u0253_\3\2\2\2\u0254\u0255\7G\2"+
		"\2\u0255\u0256\b\61\1\2\u0256\u0257\7,\2\2\u0257\u0258\5P)\2\u0258a\3"+
		"\2\2\2<i{\u0083\u0088\u0091\u00a4\u00b6\u00c8\u00d0\u00d5\u00e1\u00e7"+
		"\u00ea\u00ed\u00f3\u00f7\u010a\u0112\u011d\u0128\u0130\u013e\u0141\u014a"+
		"\u014d\u0153\u015a\u015d\u0162\u0171\u0178\u0180\u0187\u0198\u019d\u01a9"+
		"\u01ad\u01b3\u01b7\u01bc\u01c4\u01c8\u01d3\u01f0\u01f4\u020b\u020d\u0214"+
		"\u0216\u021d\u0222\u022e\u0232\u0238\u0240\u0244\u024a\u0250";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}