// Generated from C:\Users\Edgardo\Git\fp4g-src\fp4g\src/fp4g/parser/FP4G.g4 by ANTLR 4.1

package fp4g.parser;

import static fp4g.Log.*;

import fp4g.data.*;
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
		GROUP=7, SUBSCRIBE=8, UNSUBSCRIBE=9, RESUME=10, PAUSE=11, USING=12, EXIT=13, 
		SET=14, START=15, ASSET=16, ASSETS=17, MANAGER=18, GAME=19, STATE=20, 
		BEHAVIOR=21, ENTITY=22, GOAL=23, MESSAGE=24, BASE=25, TO=26, SOURCE=27, 
		AS=28, ABRE_COR=29, ABRE_PAR=30, ABRE_LLAV=31, CIERRA_COR=32, CIERRA_PAR=33, 
		CIERRA_LLAV=34, COMA=35, EQUAL=36, DOT=37, DOTCOMA=38, DOUBLEDOT=39, PLUS=40, 
		MINUS=41, MULTIPLY=42, DIVIDE=43, AND=44, OR=45, XOR=46, NOT=47, NUMBER_TYPE=48, 
		STRING_TYPE=49, BOOL_TYPE=50, ENTITY_TYPE=51, DIRECTCODE=52, INT_LITERAL=53, 
		DECIMAL_LITERAL=54, STRING_LITERAL=55, BOOL_LITERAL=56, PARENT_LITERAL=57, 
		CURRENT_LITERAL=58, ID=59, NL=60, WS=61;
	public static final String[] tokenNames = {
		"<INVALID>", "SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT", "'DEFINE'", 
		"'ADD'", "'ON'", "'SEND'", "'GROUP'", "'SUBSCRIBE'", "'UNSUBSCRIBE'", 
		"'RESUME'", "'PAUSE'", "'USING'", "'EXIT'", "'SET'", "'START'", "'ASSET'", 
		"'ASSETS'", "'MANAGER'", "'GAME'", "'STATE'", "'BEHAVIOR'", "'ENTITY'", 
		"'GOAL'", "'MESSAGE'", "'BASE'", "'TO'", "'SOURCE'", "'AS'", "'['", "'('", 
		"'{'", "']'", "')'", "'}'", "','", "'='", "'.'", "';'", "':'", "'+'", 
		"'-'", "'*'", "'/'", "'AND'", "'OR'", "'XOR'", "'NOT'", "'Number'", "'String'", 
		"'Bool'", "'Entity'", "DIRECTCODE", "INT_LITERAL", "DECIMAL_LITERAL", 
		"STRING_LITERAL", "BOOL_LITERAL", "'parent'", "'current'", "ID", "NL", 
		"WS"
	};
	public static final int
		RULE_program = 0, RULE_usings = 1, RULE_using = 2, RULE_game = 3, RULE_gameLib = 4, 
		RULE_gameValues = 5, RULE_gameValue = 6, RULE_set = 7, RULE_start = 8, 
		RULE_add = 9, RULE_define = 10, RULE_on = 11, RULE_onStatement = 12, RULE_send = 13, 
		RULE_onFilters = 14, RULE_filter = 15, RULE_defineValues = 16, RULE_defineValue = 17, 
		RULE_exprList = 18, RULE_nameList = 19, RULE_declareVar = 20, RULE_varType = 21, 
		RULE_assets = 22, RULE_assetValue = 23, RULE_assetValuesInner = 24, RULE_assetValueInner = 25, 
		RULE_expr = 26, RULE_accessVarOp = 27, RULE_parentVarOp = 28, RULE_varOp = 29, 
		RULE_array = 30, RULE_arrayBody = 31, RULE_itemArray = 32, RULE_parArray = 33;
	public static final String[] ruleNames = {
		"program", "usings", "using", "game", "gameLib", "gameValues", "gameValue", 
		"set", "start", "add", "define", "on", "onStatement", "send", "onFilters", 
		"filter", "defineValues", "defineValue", "exprList", "nameList", "declareVar", 
		"varType", "assets", "assetValue", "assetValuesInner", "assetValueInner", 
		"expr", "accessVarOp", "parentVarOp", "varOp", "array", "arrayBody", "itemArray", 
		"parArray"
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
			setState(68); usings();
			setState(69); game();
			setState(70); match(EOF);
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
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==USING) {
				{
				{
				setState(72); using();
				}
				}
				setState(77);
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
		public TerminalNode GOAL() { return getToken(FP4GParser.GOAL, 0); }
		public TerminalNode STATE() { return getToken(FP4GParser.STATE, 0); }
		public TerminalNode DOTCOMA() { return getToken(FP4GParser.DOTCOMA, 0); }
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public TerminalNode BEHAVIOR() { return getToken(FP4GParser.BEHAVIOR, 0); }
		public TerminalNode MANAGER() { return getToken(FP4GParser.MANAGER, 0); }
		public TerminalNode USING() { return getToken(FP4GParser.USING, 0); }
		public TerminalNode ENTITY() { return getToken(FP4GParser.ENTITY, 0); }
		public TerminalNode MESSAGE() { return getToken(FP4GParser.MESSAGE, 0); }
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78); match(USING);
			setState(79);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MANAGER) | (1L << STATE) | (1L << BEHAVIOR) | (1L << ENTITY) | (1L << GOAL) | (1L << MESSAGE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(80); match(ID);
			setState(81); match(DOTCOMA);
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
		enterRule(_localctx, 6, RULE_game);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83); match(DEFINE);
			setState(84); match(GAME);
			setState(85); ((GameContext)_localctx).ID = match(ID);
			 ((GameContext)_localctx).name =  (((GameContext)_localctx).ID!=null?((GameContext)_localctx).ID.getText():null); 
			setState(87); match(ABRE_COR);
			setState(88); gameValues();
			setState(89); match(CIERRA_COR);
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
		enterRule(_localctx, 8, RULE_gameLib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91); match(DEFINE);
			setState(92); match(GAME);
			setState(93); match(ABRE_COR);
			setState(94); gameValues();
			setState(95); match(CIERRA_COR);
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
		enterRule(_localctx, 10, RULE_gameValues);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DEFINE) | (1L << ADD) | (1L << ON) | (1L << SET) | (1L << START) | (1L << ID))) != 0)) {
				{
				{
				setState(97); gameValue();
				}
				}
				setState(102);
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
		public DefineContext define() {
			return getRuleContext(DefineContext.class,0);
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
		enterRule(_localctx, 12, RULE_gameValue);
		try {
			setState(114);
			switch (_input.LA(1)) {
			case DEFINE:
				enterOuterAlt(_localctx, 1);
				{
				setState(103); define();
				}
				break;
			case ADD:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(104); add();
				setState(105); match(DOTCOMA);
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 3);
				{
				setState(107); set();
				setState(108); match(DOTCOMA);
				}
				break;
			case START:
				enterOuterAlt(_localctx, 4);
				{
				setState(110); start();
				setState(111); match(DOTCOMA);
				}
				break;
			case ON:
				enterOuterAlt(_localctx, 5);
				{
				setState(113); on();
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
		enterRule(_localctx, 14, RULE_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116); match(SET);
			setState(117); ((SetContext)_localctx).ID = match(ID);
			 ((SetContext)_localctx).key =  (((SetContext)_localctx).ID!=null?((SetContext)_localctx).ID.getText():null); 
			setState(119); match(EQUAL);
			setState(120); expr(0);
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
		enterRule(_localctx, 16, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122); match(START);
			setState(123); ((StartContext)_localctx).ID = match(ID);
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

	public static class AddContext extends ParserRuleContext {
		public DefineType type = null;
		public String addName = null;
		public String varName = null;
		public Token ID;
		public TerminalNode GOAL() { return getToken(FP4GParser.GOAL, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public TerminalNode STATE() { return getToken(FP4GParser.STATE, 0); }
		public List<TerminalNode> ID() { return getTokens(FP4GParser.ID); }
		public TerminalNode CIERRA_PAR() { return getToken(FP4GParser.CIERRA_PAR, 0); }
		public TerminalNode BEHAVIOR() { return getToken(FP4GParser.BEHAVIOR, 0); }
		public TerminalNode MANAGER() { return getToken(FP4GParser.MANAGER, 0); }
		public TerminalNode ENTITY() { return getToken(FP4GParser.ENTITY, 0); }
		public TerminalNode EQUAL() { return getToken(FP4GParser.EQUAL, 0); }
		public TerminalNode ABRE_PAR() { return getToken(FP4GParser.ABRE_PAR, 0); }
		public TerminalNode ID(int i) {
			return getToken(FP4GParser.ID, i);
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
		enterRule(_localctx, 18, RULE_add);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(126); ((AddContext)_localctx).ID = match(ID);
				setState(127); match(EQUAL);
				((AddContext)_localctx).varName =  (((AddContext)_localctx).ID!=null?((AddContext)_localctx).ID.getText():null);
				}
			}

			setState(131); match(ADD);
			setState(142);
			switch (_input.LA(1)) {
			case MANAGER:
				{
				setState(132); match(MANAGER);
				 ((AddContext)_localctx).type =  DefineType.MANAGER;  
				}
				break;
			case STATE:
				{
				setState(134); match(STATE);
				 ((AddContext)_localctx).type =  DefineType.STATE;    
				}
				break;
			case BEHAVIOR:
				{
				setState(136); match(BEHAVIOR);
				 ((AddContext)_localctx).type =  DefineType.BEHAVIOR; 
				}
				break;
			case ENTITY:
				{
				setState(138); match(ENTITY);
				 ((AddContext)_localctx).type =  DefineType.ENTITY;  
				}
				break;
			case GOAL:
				{
				setState(140); match(GOAL);
				 ((AddContext)_localctx).type =  DefineType.GOAL;  
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(144); ((AddContext)_localctx).ID = match(ID);
			 ((AddContext)_localctx).addName =  (((AddContext)_localctx).ID!=null?((AddContext)_localctx).ID.getText():null); 
			setState(150);
			_la = _input.LA(1);
			if (_la==ABRE_PAR) {
				{
				setState(146); match(ABRE_PAR);
				setState(147); exprList();
				setState(148); match(CIERRA_PAR);
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
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
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
		enterRule(_localctx, 20, RULE_define);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152); match(DEFINE);
			setState(167);
			switch (_input.LA(1)) {
			case MANAGER:
				{
				setState(153); match(MANAGER);
				 ((DefineContext)_localctx).type =  DefineType.MANAGER; 
				}
				break;
			case STATE:
				{
				setState(155); match(STATE);
				 ((DefineContext)_localctx).type =  DefineType.STATE;   
				}
				break;
			case BEHAVIOR:
				{
				setState(157); match(BEHAVIOR);
				 ((DefineContext)_localctx).type =  DefineType.BEHAVIOR;
				}
				break;
			case ENTITY:
				{
				setState(159); match(ENTITY);
				 ((DefineContext)_localctx).type =  DefineType.ENTITY;  
				}
				break;
			case GOAL:
				{
				setState(161); match(GOAL);
				 ((DefineContext)_localctx).type =  DefineType.GOAL;    
				}
				break;
			case MESSAGE:
				{
				setState(163); match(MESSAGE);
				 ((DefineContext)_localctx).type =  DefineType.MESSAGE; 
				}
				break;
			case ASSET:
				{
				setState(165); match(ASSET);
				 ((DefineContext)_localctx).type =  DefineType.ASSET;   
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(169); ((DefineContext)_localctx).ID = match(ID);
			 ((DefineContext)_localctx).defName =  (((DefineContext)_localctx).ID!=null?((DefineContext)_localctx).ID.getText():null); 
			setState(175);
			_la = _input.LA(1);
			if (_la==ABRE_PAR) {
				{
				setState(171); match(ABRE_PAR);
				setState(172); nameList();
				setState(173); match(CIERRA_PAR);
				}
			}

			setState(177); match(ABRE_COR);
			setState(178); defineValues();
			setState(179); match(CIERRA_COR);
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
		public Token ID;
		public OnFiltersContext filters;
		public TerminalNode DOUBLEDOT() { return getToken(FP4GParser.DOUBLEDOT, 0); }
		public TerminalNode ABRE_COR() { return getToken(FP4GParser.ABRE_COR, 0); }
		public TerminalNode ON() { return getToken(FP4GParser.ON, 0); }
		public TerminalNode DOTCOMA(int i) {
			return getToken(FP4GParser.DOTCOMA, i);
		}
		public OnStatementContext onStatement(int i) {
			return getRuleContext(OnStatementContext.class,i);
		}
		public TerminalNode CIERRA_COR() { return getToken(FP4GParser.CIERRA_COR, 0); }
		public List<TerminalNode> DOTCOMA() { return getTokens(FP4GParser.DOTCOMA); }
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public List<OnStatementContext> onStatement() {
			return getRuleContexts(OnStatementContext.class);
		}
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
		enterRule(_localctx, 22, RULE_on);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181); match(ON);
			setState(182); ((OnContext)_localctx).ID = match(ID);
			((OnContext)_localctx).messageName =  (((OnContext)_localctx).ID!=null?((OnContext)_localctx).ID.getText():null); 
			setState(186);
			_la = _input.LA(1);
			if (_la==DOUBLEDOT) {
				{
				setState(184); match(DOUBLEDOT);
				setState(185); ((OnContext)_localctx).filters = onFilters();
				}
			}

			setState(188); match(ABRE_COR);
			setState(194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEND) {
				{
				{
				setState(189); onStatement();
				setState(190); match(DOTCOMA);
				}
				}
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(197); match(CIERRA_COR);
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

	public static class OnStatementContext extends ParserRuleContext {
		public SendContext send() {
			return getRuleContext(SendContext.class,0);
		}
		public OnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_onStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitOnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OnStatementContext onStatement() throws RecognitionException {
		OnStatementContext _localctx = new OnStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_onStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199); send();
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
		public Token method;
		public Token receiver;
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
		enterRule(_localctx, 26, RULE_send);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201); match(SEND);
			setState(202); ((SendContext)_localctx).method = match(ID);
			((SendContext)_localctx).messageMethodName =  (((SendContext)_localctx).method!=null?((SendContext)_localctx).method.getText():null);
			setState(208);
			_la = _input.LA(1);
			if (_la==ABRE_PAR) {
				{
				setState(204); match(ABRE_PAR);
				setState(205); exprList();
				setState(206); match(CIERRA_PAR);
				}
			}

			setState(213);
			_la = _input.LA(1);
			if (_la==TO) {
				{
				setState(210); match(TO);
				setState(211); ((SendContext)_localctx).receiver = match(ID);
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
		public List<List<String>> or = new LinkedList<List<String>>();;
		public FilterContext filter;
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
		enterRule(_localctx, 28, RULE_onFilters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215); ((OnFiltersContext)_localctx).filter = filter();
			_localctx.or.add(((OnFiltersContext)_localctx).filter.filters);
			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(217); ((OnFiltersContext)_localctx).filter = filter();
				_localctx.or.add(((OnFiltersContext)_localctx).filter.filters);
				}
				}
				setState(224);
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
		public List<String> filters = new LinkedList<String>();;
		public Token ID;
		public List<TerminalNode> ID() { return getTokens(FP4GParser.ID); }
		public List<TerminalNode> COMA() { return getTokens(FP4GParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(FP4GParser.COMA, i);
		}
		public TerminalNode ID(int i) {
			return getToken(FP4GParser.ID, i);
		}
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
		enterRule(_localctx, 30, RULE_filter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225); ((FilterContext)_localctx).ID = match(ID);
			_localctx.filters.add((((FilterContext)_localctx).ID!=null?((FilterContext)_localctx).ID.getText():null));
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(227); match(COMA);
				setState(228); ((FilterContext)_localctx).ID = match(ID);
				_localctx.filters.add((((FilterContext)_localctx).ID!=null?((FilterContext)_localctx).ID.getText():null));
				}
				}
				setState(234);
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
		enterRule(_localctx, 32, RULE_defineValues);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << ON) | (1L << SET) | (1L << ASSETS) | (1L << ID))) != 0)) {
				{
				{
				setState(235); defineValue();
				}
				}
				setState(240);
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
		public AssetsContext assets() {
			return getRuleContext(AssetsContext.class,0);
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
		enterRule(_localctx, 34, RULE_defineValue);
		try {
			setState(249);
			switch (_input.LA(1)) {
			case ADD:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(241); add();
				setState(242); match(DOTCOMA);
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 2);
				{
				setState(244); set();
				setState(245); match(DOTCOMA);
				}
				break;
			case ON:
				enterOuterAlt(_localctx, 3);
				{
				setState(247); on();
				}
				break;
			case ASSETS:
				enterOuterAlt(_localctx, 4);
				{
				setState(248); assets();
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
		enterRule(_localctx, 36, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251); expr(0);
			setState(256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(252); match(COMA);
				setState(253); expr(0);
				}
				}
				setState(258);
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
		enterRule(_localctx, 38, RULE_nameList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259); declareVar();
			setState(264);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(260); match(COMA);
				setState(261); declareVar();
				}
				}
				setState(266);
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
		enterRule(_localctx, 40, RULE_declareVar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267); varType();
			setState(268); ((DeclareVarContext)_localctx).varName = match(ID);
			setState(271);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(269); match(EQUAL);
				setState(270); ((DeclareVarContext)_localctx).initValue = expr(0);
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
		public Token ID;
		public TerminalNode ENTITY_TYPE() { return getToken(FP4GParser.ENTITY_TYPE, 0); }
		public TerminalNode NUMBER_TYPE() { return getToken(FP4GParser.NUMBER_TYPE, 0); }
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public TerminalNode STRING_TYPE() { return getToken(FP4GParser.STRING_TYPE, 0); }
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
		enterRule(_localctx, 42, RULE_varType);
		try {
			setState(283);
			switch (_input.LA(1)) {
			case NUMBER_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(273); match(NUMBER_TYPE);
				((VarTypeContext)_localctx).type =  BasicType.Number;
				}
				break;
			case BOOL_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(275); match(BOOL_TYPE);
				((VarTypeContext)_localctx).type =  BasicType.Bool;
				}
				break;
			case ENTITY_TYPE:
				enterOuterAlt(_localctx, 3);
				{
				setState(277); match(ENTITY_TYPE);
				((VarTypeContext)_localctx).type =  BasicType.Entity;
				}
				break;
			case STRING_TYPE:
				enterOuterAlt(_localctx, 4);
				{
				setState(279); match(STRING_TYPE);
				((VarTypeContext)_localctx).type =  BasicType.String;
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(281); ((VarTypeContext)_localctx).ID = match(ID);
				((VarTypeContext)_localctx).type =  new CustomType((((VarTypeContext)_localctx).ID!=null?((VarTypeContext)_localctx).ID.getText():null));
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

	public static class AssetsContext extends ParserRuleContext {
		public AssetValueContext assetValue(int i) {
			return getRuleContext(AssetValueContext.class,i);
		}
		public TerminalNode ABRE_COR() { return getToken(FP4GParser.ABRE_COR, 0); }
		public List<AssetValueContext> assetValue() {
			return getRuleContexts(AssetValueContext.class);
		}
		public TerminalNode CIERRA_COR() { return getToken(FP4GParser.CIERRA_COR, 0); }
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
		enterRule(_localctx, 44, RULE_assets);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(285); match(ASSETS);
			setState(286); match(ABRE_COR);
			setState(287); assetValue();
			setState(292);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(288); match(COMA);
					setState(289); assetValue();
					}
					} 
				}
				setState(294);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			setState(296);
			_la = _input.LA(1);
			if (_la==COMA) {
				{
				setState(295); match(COMA);
				}
			}

			setState(298); match(CIERRA_COR);
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
		public Token asset;
		public AssetValuesInnerContext innerAssetValues;
		public TerminalNode DOUBLEDOT() { return getToken(FP4GParser.DOUBLEDOT, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(FP4GParser.STRING_LITERAL, 0); }
		public List<TerminalNode> ID() { return getTokens(FP4GParser.ID); }
		public AssetValuesInnerContext assetValuesInner() {
			return getRuleContext(AssetValuesInnerContext.class,0);
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
		enterRule(_localctx, 46, RULE_assetValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300); ((AssetValueContext)_localctx).assetType = match(ID);
			setState(302);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(301); ((AssetValueContext)_localctx).assetName = match(ID);
				}
			}

			setState(304); match(DOUBLEDOT);
			setState(305); ((AssetValueContext)_localctx).asset = match(STRING_LITERAL);
			setState(307);
			_la = _input.LA(1);
			if (_la==ABRE_COR) {
				{
				setState(306); ((AssetValueContext)_localctx).innerAssetValues = assetValuesInner();
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
		public AssetValueInnerContext assetValueInner(int i) {
			return getRuleContext(AssetValueInnerContext.class,i);
		}
		public TerminalNode ABRE_COR() { return getToken(FP4GParser.ABRE_COR, 0); }
		public List<AssetValueInnerContext> assetValueInner() {
			return getRuleContexts(AssetValueInnerContext.class);
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
		enterRule(_localctx, 48, RULE_assetValuesInner);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(309); match(ABRE_COR);
			setState(310); assetValueInner();
			setState(315);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(311); match(COMA);
					setState(312); assetValueInner();
					}
					} 
				}
				setState(317);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			setState(319);
			_la = _input.LA(1);
			if (_la==COMA) {
				{
				setState(318); match(COMA);
				}
			}

			setState(321); match(CIERRA_COR);
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

	public static class AssetValueInnerContext extends ParserRuleContext {
		public Token assetType;
		public Token assetName;
		public Token asset;
		public TerminalNode DOUBLEDOT() { return getToken(FP4GParser.DOUBLEDOT, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(FP4GParser.STRING_LITERAL, 0); }
		public List<TerminalNode> ID() { return getTokens(FP4GParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FP4GParser.ID, i);
		}
		public AssetValueInnerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assetValueInner; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitAssetValueInner(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssetValueInnerContext assetValueInner() throws RecognitionException {
		AssetValueInnerContext _localctx = new AssetValueInnerContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_assetValueInner);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323); ((AssetValueInnerContext)_localctx).assetType = match(ID);
			setState(325);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(324); ((AssetValueInnerContext)_localctx).assetName = match(ID);
				}
			}

			setState(327); match(DOUBLEDOT);
			setState(328); ((AssetValueInnerContext)_localctx).asset = match(STRING_LITERAL);
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

	public final ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState, _p);
		ExprContext _prevctx = _localctx;
		int _startState = 52;
		enterRecursionRule(_localctx, RULE_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(351);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(331); match(NOT);
				setState(332); ((NotExprContext)_localctx).op = expr(13);
				}
				break;

			case 2:
				{
				_localctx = new MinusExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(333); match(MINUS);
				setState(334); ((MinusExprContext)_localctx).op = expr(12);
				}
				break;

			case 3:
				{
				_localctx = new ArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(335); array();
				}
				break;

			case 4:
				{
				_localctx = new ParExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(336); match(ABRE_PAR);
				setState(337); ((ParExprContext)_localctx).op = expr(0);
				setState(338); match(CIERRA_PAR);
				}
				break;

			case 5:
				{
				_localctx = new IntLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(340); match(INT_LITERAL);
				}
				break;

			case 6:
				{
				_localctx = new DecimalLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(341); match(DECIMAL_LITERAL);
				}
				break;

			case 7:
				{
				_localctx = new BoolLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(342); match(BOOL_LITERAL);
				}
				break;

			case 8:
				{
				_localctx = new StringLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(343); match(STRING_LITERAL);
				}
				break;

			case 9:
				{
				_localctx = new DirectCodeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(344); match(DIRECTCODE);
				}
				break;

			case 10:
				{
				_localctx = new FunctionCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(345); ((FunctionCallExprContext)_localctx).functionName = match(ID);
				setState(346); match(ABRE_PAR);
				setState(347); exprList();
				setState(348); match(CIERRA_PAR);
				}
				break;

			case 11:
				{
				_localctx = new VarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(350); accessVarOp();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(367);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(365);
					switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
					case 1:
						{
						_localctx = new MultExprContext(new ExprContext(_parentctx, _parentState, _p));
						((MultExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(353);
						if (!(11 >= _localctx._p)) throw new FailedPredicateException(this, "11 >= $_p");
						setState(354); match(MULTIPLY);
						setState(355); ((MultExprContext)_localctx).right = expr(12);
						}
						break;

					case 2:
						{
						_localctx = new DivExprContext(new ExprContext(_parentctx, _parentState, _p));
						((DivExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(356);
						if (!(10 >= _localctx._p)) throw new FailedPredicateException(this, "10 >= $_p");
						setState(357); match(DIVIDE);
						setState(358); ((DivExprContext)_localctx).right = expr(11);
						}
						break;

					case 3:
						{
						_localctx = new AddExprContext(new ExprContext(_parentctx, _parentState, _p));
						((AddExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(359);
						if (!(9 >= _localctx._p)) throw new FailedPredicateException(this, "9 >= $_p");
						setState(360); match(PLUS);
						setState(361); ((AddExprContext)_localctx).right = expr(10);
						}
						break;

					case 4:
						{
						_localctx = new SubExprContext(new ExprContext(_parentctx, _parentState, _p));
						((SubExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(362);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(363); match(MINUS);
						setState(364); ((SubExprContext)_localctx).right = expr(9);
						}
						break;
					}
					} 
				}
				setState(369);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
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
		enterRule(_localctx, 54, RULE_accessVarOp);
		try {
			setState(376);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				_localctx = new AccessVarNameContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(370); ((AccessVarNameContext)_localctx).var = varOp();
				}
				break;

			case 2:
				_localctx = new AccessVarOperatorContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(371); ((AccessVarOperatorContext)_localctx).pVar = parentVarOp();
				setState(374);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					setState(372); match(DOT);
					setState(373); ((AccessVarOperatorContext)_localctx).propertyAccess = accessVarOp();
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
		public Token varName;
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
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
		enterRule(_localctx, 56, RULE_parentVarOp);
		try {
			setState(382);
			switch (_input.LA(1)) {
			case CURRENT_LITERAL:
				_localctx = new CurrentOperatorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(378); match(CURRENT_LITERAL);
				}
				break;
			case PARENT_LITERAL:
				_localctx = new ParentOperatorContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(379); match(PARENT_LITERAL);
				}
				break;
			case ID:
				_localctx = new VarNameOperatorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(380); ((VarNameOperatorContext)_localctx).varName = match(ID);
				((VarNameOperatorContext)_localctx).name = (((VarNameOperatorContext)_localctx).varName!=null?((VarNameOperatorContext)_localctx).varName.getText():null);
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
		public Token varName;
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
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
		enterRule(_localctx, 58, RULE_varOp);
		try {
			setState(387);
			switch (_input.LA(1)) {
			case CURRENT_LITERAL:
				_localctx = new VarCurrentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(384); match(CURRENT_LITERAL);
				}
				break;
			case PARENT_LITERAL:
				_localctx = new VarParentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(385); match(PARENT_LITERAL);
				}
				break;
			case ID:
				_localctx = new VarNameContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(386); ((VarNameContext)_localctx).varName = match(ID);
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

	public static class ArrayContext extends ParserRuleContext {
		public String bean;
		public Token ID;
		public TerminalNode AS() { return getToken(FP4GParser.AS, 0); }
		public TerminalNode ABRE_LLAV() { return getToken(FP4GParser.ABRE_LLAV, 0); }
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public ArrayBodyContext arrayBody() {
			return getRuleContext(ArrayBodyContext.class,0);
		}
		public TerminalNode CIERRA_LLAV() { return getToken(FP4GParser.CIERRA_LLAV, 0); }
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
		enterRule(_localctx, 60, RULE_array);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(389); match(ABRE_LLAV);
			setState(390); arrayBody();
			setState(391); match(CIERRA_LLAV);
			setState(395);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(392); match(AS);
				setState(393); ((ArrayContext)_localctx).ID = match(ID);
				((ArrayContext)_localctx).bean =  (((ArrayContext)_localctx).ID!=null?((ArrayContext)_localctx).ID.getText():null);
				}
				break;
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
		public List<ItemArrayContext> itemArray() {
			return getRuleContexts(ItemArrayContext.class);
		}
		public List<TerminalNode> COMA() { return getTokens(FP4GParser.COMA); }
		public ItemArrayContext itemArray(int i) {
			return getRuleContext(ItemArrayContext.class,i);
		}
		public TerminalNode COMA(int i) {
			return getToken(FP4GParser.COMA, i);
		}
		public ListArrayContext(ArrayBodyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitListArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssocArrayContext extends ArrayBodyContext {
		public List<ParArrayContext> parArray() {
			return getRuleContexts(ParArrayContext.class);
		}
		public ParArrayContext parArray(int i) {
			return getRuleContext(ParArrayContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(FP4GParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(FP4GParser.COMA, i);
		}
		public AssocArrayContext(ArrayBodyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitAssocArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayBodyContext arrayBody() throws RecognitionException {
		ArrayBodyContext _localctx = new ArrayBodyContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_arrayBody);
		int _la;
		try {
			int _alt;
			setState(419);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				_localctx = new AssocArrayContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(397); parArray();
				setState(402);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(398); match(COMA);
						setState(399); parArray();
						}
						} 
					}
					setState(404);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
				}
				setState(406);
				_la = _input.LA(1);
				if (_la==COMA) {
					{
					setState(405); match(COMA);
					}
				}

				}
				}
				break;

			case 2:
				_localctx = new ListArrayContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(408); itemArray();
				setState(413);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(409); match(COMA);
						setState(410); itemArray();
						}
						} 
					}
					setState(415);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
				}
				setState(417);
				_la = _input.LA(1);
				if (_la==COMA) {
					{
					setState(416); match(COMA);
					}
				}

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
		enterRule(_localctx, 64, RULE_itemArray);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(421); expr(0);
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
		enterRule(_localctx, 66, RULE_parArray);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(423); ((ParArrayContext)_localctx).ID = match(ID);
			 ((ParArrayContext)_localctx).key =  (((ParArrayContext)_localctx).ID!=null?((ParArrayContext)_localctx).ID.getText():null); 
			setState(425); match(EQUAL);
			setState(426); expr(0);
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
		case 26: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 11 >= _localctx._p;

		case 1: return 10 >= _localctx._p;

		case 2: return 9 >= _localctx._p;

		case 3: return 8 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3?\u01af\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\3\2\3\3\7\3L\n\3\f\3\16\3O\13\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\7\7\7e\n\7\f\7\16\7h\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\5\bu\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\5\13"+
		"\u0084\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13"+
		"\u0091\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0099\n\13\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00aa\n\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\5\f\u00b2\n\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\5\r"+
		"\u00bd\n\r\3\r\3\r\3\r\3\r\7\r\u00c3\n\r\f\r\16\r\u00c6\13\r\3\r\3\r\3"+
		"\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00d3\n\17\3\17\3\17"+
		"\3\17\5\17\u00d8\n\17\3\20\3\20\3\20\3\20\3\20\7\20\u00df\n\20\f\20\16"+
		"\20\u00e2\13\20\3\21\3\21\3\21\3\21\3\21\7\21\u00e9\n\21\f\21\16\21\u00ec"+
		"\13\21\3\22\7\22\u00ef\n\22\f\22\16\22\u00f2\13\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\5\23\u00fc\n\23\3\24\3\24\3\24\7\24\u0101\n\24\f"+
		"\24\16\24\u0104\13\24\3\25\3\25\3\25\7\25\u0109\n\25\f\25\16\25\u010c"+
		"\13\25\3\26\3\26\3\26\3\26\5\26\u0112\n\26\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\5\27\u011e\n\27\3\30\3\30\3\30\3\30\3\30\7\30"+
		"\u0125\n\30\f\30\16\30\u0128\13\30\3\30\5\30\u012b\n\30\3\30\3\30\3\31"+
		"\3\31\5\31\u0131\n\31\3\31\3\31\3\31\5\31\u0136\n\31\3\32\3\32\3\32\3"+
		"\32\7\32\u013c\n\32\f\32\16\32\u013f\13\32\3\32\5\32\u0142\n\32\3\32\3"+
		"\32\3\33\3\33\5\33\u0148\n\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\5\34\u0162\n\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\7\34\u0170\n\34\f\34\16\34\u0173\13\34\3\35\3\35\3\35"+
		"\3\35\5\35\u0179\n\35\5\35\u017b\n\35\3\36\3\36\3\36\3\36\5\36\u0181\n"+
		"\36\3\37\3\37\3\37\5\37\u0186\n\37\3 \3 \3 \3 \3 \3 \5 \u018e\n \3!\3"+
		"!\3!\7!\u0193\n!\f!\16!\u0196\13!\3!\5!\u0199\n!\3!\3!\3!\7!\u019e\n!"+
		"\f!\16!\u01a1\13!\3!\5!\u01a4\n!\5!\u01a6\n!\3\"\3\"\3#\3#\3#\3#\3#\3"+
		"#\2$\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@"+
		"BD\2\3\4\2\24\24\26\32\u01d1\2F\3\2\2\2\4M\3\2\2\2\6P\3\2\2\2\bU\3\2\2"+
		"\2\n]\3\2\2\2\ff\3\2\2\2\16t\3\2\2\2\20v\3\2\2\2\22|\3\2\2\2\24\u0083"+
		"\3\2\2\2\26\u009a\3\2\2\2\30\u00b7\3\2\2\2\32\u00c9\3\2\2\2\34\u00cb\3"+
		"\2\2\2\36\u00d9\3\2\2\2 \u00e3\3\2\2\2\"\u00f0\3\2\2\2$\u00fb\3\2\2\2"+
		"&\u00fd\3\2\2\2(\u0105\3\2\2\2*\u010d\3\2\2\2,\u011d\3\2\2\2.\u011f\3"+
		"\2\2\2\60\u012e\3\2\2\2\62\u0137\3\2\2\2\64\u0145\3\2\2\2\66\u0161\3\2"+
		"\2\28\u017a\3\2\2\2:\u0180\3\2\2\2<\u0185\3\2\2\2>\u0187\3\2\2\2@\u01a5"+
		"\3\2\2\2B\u01a7\3\2\2\2D\u01a9\3\2\2\2FG\5\4\3\2GH\5\b\5\2HI\7\2\2\3I"+
		"\3\3\2\2\2JL\5\6\4\2KJ\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2N\5\3\2\2"+
		"\2OM\3\2\2\2PQ\7\16\2\2QR\t\2\2\2RS\7=\2\2ST\7(\2\2T\7\3\2\2\2UV\7\5\2"+
		"\2VW\7\25\2\2WX\7=\2\2XY\b\5\1\2YZ\7\37\2\2Z[\5\f\7\2[\\\7\"\2\2\\\t\3"+
		"\2\2\2]^\7\5\2\2^_\7\25\2\2_`\7\37\2\2`a\5\f\7\2ab\7\"\2\2b\13\3\2\2\2"+
		"ce\5\16\b\2dc\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2g\r\3\2\2\2hf\3\2\2"+
		"\2iu\5\26\f\2jk\5\24\13\2kl\7(\2\2lu\3\2\2\2mn\5\20\t\2no\7(\2\2ou\3\2"+
		"\2\2pq\5\22\n\2qr\7(\2\2ru\3\2\2\2su\5\30\r\2ti\3\2\2\2tj\3\2\2\2tm\3"+
		"\2\2\2tp\3\2\2\2ts\3\2\2\2u\17\3\2\2\2vw\7\20\2\2wx\7=\2\2xy\b\t\1\2y"+
		"z\7&\2\2z{\5\66\34\2{\21\3\2\2\2|}\7\21\2\2}~\7=\2\2~\177\b\n\1\2\177"+
		"\23\3\2\2\2\u0080\u0081\7=\2\2\u0081\u0082\7&\2\2\u0082\u0084\b\13\1\2"+
		"\u0083\u0080\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0090"+
		"\7\6\2\2\u0086\u0087\7\24\2\2\u0087\u0091\b\13\1\2\u0088\u0089\7\26\2"+
		"\2\u0089\u0091\b\13\1\2\u008a\u008b\7\27\2\2\u008b\u0091\b\13\1\2\u008c"+
		"\u008d\7\30\2\2\u008d\u0091\b\13\1\2\u008e\u008f\7\31\2\2\u008f\u0091"+
		"\b\13\1\2\u0090\u0086\3\2\2\2\u0090\u0088\3\2\2\2\u0090\u008a\3\2\2\2"+
		"\u0090\u008c\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093"+
		"\7=\2\2\u0093\u0098\b\13\1\2\u0094\u0095\7 \2\2\u0095\u0096\5&\24\2\u0096"+
		"\u0097\7#\2\2\u0097\u0099\3\2\2\2\u0098\u0094\3\2\2\2\u0098\u0099\3\2"+
		"\2\2\u0099\25\3\2\2\2\u009a\u00a9\7\5\2\2\u009b\u009c\7\24\2\2\u009c\u00aa"+
		"\b\f\1\2\u009d\u009e\7\26\2\2\u009e\u00aa\b\f\1\2\u009f\u00a0\7\27\2\2"+
		"\u00a0\u00aa\b\f\1\2\u00a1\u00a2\7\30\2\2\u00a2\u00aa\b\f\1\2\u00a3\u00a4"+
		"\7\31\2\2\u00a4\u00aa\b\f\1\2\u00a5\u00a6\7\32\2\2\u00a6\u00aa\b\f\1\2"+
		"\u00a7\u00a8\7\22\2\2\u00a8\u00aa\b\f\1\2\u00a9\u009b\3\2\2\2\u00a9\u009d"+
		"\3\2\2\2\u00a9\u009f\3\2\2\2\u00a9\u00a1\3\2\2\2\u00a9\u00a3\3\2\2\2\u00a9"+
		"\u00a5\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\7="+
		"\2\2\u00ac\u00b1\b\f\1\2\u00ad\u00ae\7 \2\2\u00ae\u00af\5(\25\2\u00af"+
		"\u00b0\7#\2\2\u00b0\u00b2\3\2\2\2\u00b1\u00ad\3\2\2\2\u00b1\u00b2\3\2"+
		"\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\7\37\2\2\u00b4\u00b5\5\"\22\2\u00b5"+
		"\u00b6\7\"\2\2\u00b6\27\3\2\2\2\u00b7\u00b8\7\7\2\2\u00b8\u00b9\7=\2\2"+
		"\u00b9\u00bc\b\r\1\2\u00ba\u00bb\7)\2\2\u00bb\u00bd\5\36\20\2\u00bc\u00ba"+
		"\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00c4\7\37\2\2"+
		"\u00bf\u00c0\5\32\16\2\u00c0\u00c1\7(\2\2\u00c1\u00c3\3\2\2\2\u00c2\u00bf"+
		"\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		"\u00c7\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c7\u00c8\7\"\2\2\u00c8\31\3\2\2"+
		"\2\u00c9\u00ca\5\34\17\2\u00ca\33\3\2\2\2\u00cb\u00cc\7\b\2\2\u00cc\u00cd"+
		"\7=\2\2\u00cd\u00d2\b\17\1\2\u00ce\u00cf\7 \2\2\u00cf\u00d0\5&\24\2\u00d0"+
		"\u00d1\7#\2\2\u00d1\u00d3\3\2\2\2\u00d2\u00ce\3\2\2\2\u00d2\u00d3\3\2"+
		"\2\2\u00d3\u00d7\3\2\2\2\u00d4\u00d5\7\34\2\2\u00d5\u00d6\7=\2\2\u00d6"+
		"\u00d8\b\17\1\2\u00d7\u00d4\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\35\3\2\2"+
		"\2\u00d9\u00da\5 \21\2\u00da\u00e0\b\20\1\2\u00db\u00dc\5 \21\2\u00dc"+
		"\u00dd\b\20\1\2\u00dd\u00df\3\2\2\2\u00de\u00db\3\2\2\2\u00df\u00e2\3"+
		"\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\37\3\2\2\2\u00e2"+
		"\u00e0\3\2\2\2\u00e3\u00e4\7=\2\2\u00e4\u00ea\b\21\1\2\u00e5\u00e6\7%"+
		"\2\2\u00e6\u00e7\7=\2\2\u00e7\u00e9\b\21\1\2\u00e8\u00e5\3\2\2\2\u00e9"+
		"\u00ec\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb!\3\2\2\2"+
		"\u00ec\u00ea\3\2\2\2\u00ed\u00ef\5$\23\2\u00ee\u00ed\3\2\2\2\u00ef\u00f2"+
		"\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1#\3\2\2\2\u00f2"+
		"\u00f0\3\2\2\2\u00f3\u00f4\5\24\13\2\u00f4\u00f5\7(\2\2\u00f5\u00fc\3"+
		"\2\2\2\u00f6\u00f7\5\20\t\2\u00f7\u00f8\7(\2\2\u00f8\u00fc\3\2\2\2\u00f9"+
		"\u00fc\5\30\r\2\u00fa\u00fc\5.\30\2\u00fb\u00f3\3\2\2\2\u00fb\u00f6\3"+
		"\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fa\3\2\2\2\u00fc%\3\2\2\2\u00fd\u0102"+
		"\5\66\34\2\u00fe\u00ff\7%\2\2\u00ff\u0101\5\66\34\2\u0100\u00fe\3\2\2"+
		"\2\u0101\u0104\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103\'"+
		"\3\2\2\2\u0104\u0102\3\2\2\2\u0105\u010a\5*\26\2\u0106\u0107\7%\2\2\u0107"+
		"\u0109\5*\26\2\u0108\u0106\3\2\2\2\u0109\u010c\3\2\2\2\u010a\u0108\3\2"+
		"\2\2\u010a\u010b\3\2\2\2\u010b)\3\2\2\2\u010c\u010a\3\2\2\2\u010d\u010e"+
		"\5,\27\2\u010e\u0111\7=\2\2\u010f\u0110\7&\2\2\u0110\u0112\5\66\34\2\u0111"+
		"\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112+\3\2\2\2\u0113\u0114\7\62\2\2"+
		"\u0114\u011e\b\27\1\2\u0115\u0116\7\64\2\2\u0116\u011e\b\27\1\2\u0117"+
		"\u0118\7\65\2\2\u0118\u011e\b\27\1\2\u0119\u011a\7\63\2\2\u011a\u011e"+
		"\b\27\1\2\u011b\u011c\7=\2\2\u011c\u011e\b\27\1\2\u011d\u0113\3\2\2\2"+
		"\u011d\u0115\3\2\2\2\u011d\u0117\3\2\2\2\u011d\u0119\3\2\2\2\u011d\u011b"+
		"\3\2\2\2\u011e-\3\2\2\2\u011f\u0120\7\23\2\2\u0120\u0121\7\37\2\2\u0121"+
		"\u0126\5\60\31\2\u0122\u0123\7%\2\2\u0123\u0125\5\60\31\2\u0124\u0122"+
		"\3\2\2\2\u0125\u0128\3\2\2\2\u0126\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127"+
		"\u012a\3\2\2\2\u0128\u0126\3\2\2\2\u0129\u012b\7%\2\2\u012a\u0129\3\2"+
		"\2\2\u012a\u012b\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u012d\7\"\2\2\u012d"+
		"/\3\2\2\2\u012e\u0130\7=\2\2\u012f\u0131\7=\2\2\u0130\u012f\3\2\2\2\u0130"+
		"\u0131\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0133\7)\2\2\u0133\u0135\79\2"+
		"\2\u0134\u0136\5\62\32\2\u0135\u0134\3\2\2\2\u0135\u0136\3\2\2\2\u0136"+
		"\61\3\2\2\2\u0137\u0138\7\37\2\2\u0138\u013d\5\64\33\2\u0139\u013a\7%"+
		"\2\2\u013a\u013c\5\64\33\2\u013b\u0139\3\2\2\2\u013c\u013f\3\2\2\2\u013d"+
		"\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u0141\3\2\2\2\u013f\u013d\3\2"+
		"\2\2\u0140\u0142\7%\2\2\u0141\u0140\3\2\2\2\u0141\u0142\3\2\2\2\u0142"+
		"\u0143\3\2\2\2\u0143\u0144\7\"\2\2\u0144\63\3\2\2\2\u0145\u0147\7=\2\2"+
		"\u0146\u0148\7=\2\2\u0147\u0146\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u0149"+
		"\3\2\2\2\u0149\u014a\7)\2\2\u014a\u014b\79\2\2\u014b\65\3\2\2\2\u014c"+
		"\u014d\b\34\1\2\u014d\u014e\7\61\2\2\u014e\u0162\5\66\34\2\u014f\u0150"+
		"\7+\2\2\u0150\u0162\5\66\34\2\u0151\u0162\5> \2\u0152\u0153\7 \2\2\u0153"+
		"\u0154\5\66\34\2\u0154\u0155\7#\2\2\u0155\u0162\3\2\2\2\u0156\u0162\7"+
		"\67\2\2\u0157\u0162\78\2\2\u0158\u0162\7:\2\2\u0159\u0162\79\2\2\u015a"+
		"\u0162\7\66\2\2\u015b\u015c\7=\2\2\u015c\u015d\7 \2\2\u015d\u015e\5&\24"+
		"\2\u015e\u015f\7#\2\2\u015f\u0162\3\2\2\2\u0160\u0162\58\35\2\u0161\u014c"+
		"\3\2\2\2\u0161\u014f\3\2\2\2\u0161\u0151\3\2\2\2\u0161\u0152\3\2\2\2\u0161"+
		"\u0156\3\2\2\2\u0161\u0157\3\2\2\2\u0161\u0158\3\2\2\2\u0161\u0159\3\2"+
		"\2\2\u0161\u015a\3\2\2\2\u0161\u015b\3\2\2\2\u0161\u0160\3\2\2\2\u0162"+
		"\u0171\3\2\2\2\u0163\u0164\6\34\2\3\u0164\u0165\7,\2\2\u0165\u0170\5\66"+
		"\34\2\u0166\u0167\6\34\3\3\u0167\u0168\7-\2\2\u0168\u0170\5\66\34\2\u0169"+
		"\u016a\6\34\4\3\u016a\u016b\7*\2\2\u016b\u0170\5\66\34\2\u016c\u016d\6"+
		"\34\5\3\u016d\u016e\7+\2\2\u016e\u0170\5\66\34\2\u016f\u0163\3\2\2\2\u016f"+
		"\u0166\3\2\2\2\u016f\u0169\3\2\2\2\u016f\u016c\3\2\2\2\u0170\u0173\3\2"+
		"\2\2\u0171\u016f\3\2\2\2\u0171\u0172\3\2\2\2\u0172\67\3\2\2\2\u0173\u0171"+
		"\3\2\2\2\u0174\u017b\5<\37\2\u0175\u0178\5:\36\2\u0176\u0177\7\'\2\2\u0177"+
		"\u0179\58\35\2\u0178\u0176\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017b\3\2"+
		"\2\2\u017a\u0174\3\2\2\2\u017a\u0175\3\2\2\2\u017b9\3\2\2\2\u017c\u0181"+
		"\7<\2\2\u017d\u0181\7;\2\2\u017e\u017f\7=\2\2\u017f\u0181\b\36\1\2\u0180"+
		"\u017c\3\2\2\2\u0180\u017d\3\2\2\2\u0180\u017e\3\2\2\2\u0181;\3\2\2\2"+
		"\u0182\u0186\7<\2\2\u0183\u0186\7;\2\2\u0184\u0186\7=\2\2\u0185\u0182"+
		"\3\2\2\2\u0185\u0183\3\2\2\2\u0185\u0184\3\2\2\2\u0186=\3\2\2\2\u0187"+
		"\u0188\7!\2\2\u0188\u0189\5@!\2\u0189\u018d\7$\2\2\u018a\u018b\7\36\2"+
		"\2\u018b\u018c\7=\2\2\u018c\u018e\b \1\2\u018d\u018a\3\2\2\2\u018d\u018e"+
		"\3\2\2\2\u018e?\3\2\2\2\u018f\u0194\5D#\2\u0190\u0191\7%\2\2\u0191\u0193"+
		"\5D#\2\u0192\u0190\3\2\2\2\u0193\u0196\3\2\2\2\u0194\u0192\3\2\2\2\u0194"+
		"\u0195\3\2\2\2\u0195\u0198\3\2\2\2\u0196\u0194\3\2\2\2\u0197\u0199\7%"+
		"\2\2\u0198\u0197\3\2\2\2\u0198\u0199\3\2\2\2\u0199\u01a6\3\2\2\2\u019a"+
		"\u019f\5B\"\2\u019b\u019c\7%\2\2\u019c\u019e\5B\"\2\u019d\u019b\3\2\2"+
		"\2\u019e\u01a1\3\2\2\2\u019f\u019d\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0\u01a3"+
		"\3\2\2\2\u01a1\u019f\3\2\2\2\u01a2\u01a4\7%\2\2\u01a3\u01a2\3\2\2\2\u01a3"+
		"\u01a4\3\2\2\2\u01a4\u01a6\3\2\2\2\u01a5\u018f\3\2\2\2\u01a5\u019a\3\2"+
		"\2\2\u01a6A\3\2\2\2\u01a7\u01a8\5\66\34\2\u01a8C\3\2\2\2\u01a9\u01aa\7"+
		"=\2\2\u01aa\u01ab\b#\1\2\u01ab\u01ac\7&\2\2\u01ac\u01ad\5\66\34\2\u01ad"+
		"E\3\2\2\2*Mft\u0083\u0090\u0098\u00a9\u00b1\u00bc\u00c4\u00d2\u00d7\u00e0"+
		"\u00ea\u00f0\u00fb\u0102\u010a\u0111\u011d\u0126\u012a\u0130\u0135\u013d"+
		"\u0141\u0147\u0161\u016f\u0171\u0178\u017a\u0180\u0185\u018d\u0194\u0198"+
		"\u019f\u01a3\u01a5";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}