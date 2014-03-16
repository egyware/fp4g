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
		USING=13, EXIT=14, SET=15, START=16, ASSETS=17, MANAGER=18, GAME=19, STATE=20, 
		ASSET=21, BEHAVIOR=22, ENTITY=23, GOAL=24, MESSAGE=25, BASE=26, TO=27, 
		SOURCE=28, AS=29, OTHER=30, ABRE_COR=31, ABRE_PAR=32, ABRE_LLAV=33, CIERRA_COR=34, 
		CIERRA_PAR=35, CIERRA_LLAV=36, COMA=37, EQUAL=38, DOT=39, DOTCOMA=40, 
		DOUBLEDOT=41, PLUS=42, MINUS=43, MULTIPLY=44, DIVIDE=45, MORE_THAN=46, 
		LESS_THAN=47, AND=48, OR=49, XOR=50, NOT=51, NUMBER_TYPE=52, STRING_TYPE=53, 
		BOOL_TYPE=54, DIRECTCODE=55, INT_LITERAL=56, DECIMAL_LITERAL=57, STRING_LITERAL=58, 
		BOOL_LITERAL=59, PARENT_LITERAL=60, CURRENT_LITERAL=61, ID=62, NL=63, 
		WS=64;
	public static final String[] tokenNames = {
		"<INVALID>", "SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT", "'DEFINE'", 
		"'ADD'", "'ON'", "'SEND'", "'DESTROY'", "'GROUP'", "'SUBSCRIBE'", "'UNSUBSCRIBE'", 
		"'RESUME'", "'PAUSE'", "'USING'", "'EXIT'", "'SET'", "'START'", "'ASSETS'", 
		"'MANAGER'", "'GAME'", "'STATE'", "'ASSET'", "'BEHAVIOR'", "'ENTITY'", 
		"'GOAL'", "'MESSAGE'", "'BASE'", "'TO'", "'SOURCE'", "'AS'", "'OTHER'", 
		"'['", "'('", "'{'", "']'", "')'", "'}'", "','", "'='", "'.'", "';'", 
		"':'", "'+'", "'-'", "'*'", "'/'", "'>'", "'<'", "'AND'", "'OR'", "'XOR'", 
		"'NOT'", "'Number'", "'String'", "'Bool'", "DIRECTCODE", "INT_LITERAL", 
		"DECIMAL_LITERAL", "STRING_LITERAL", "BOOL_LITERAL", "'parent'", "'current'", 
		"ID", "NL", "WS"
	};
	public static final int
		RULE_program = 0, RULE_usings = 1, RULE_using = 2, RULE_game = 3, RULE_gameLib = 4, 
		RULE_gameValues = 5, RULE_gameValue = 6, RULE_set = 7, RULE_start = 8, 
		RULE_add = 9, RULE_define = 10, RULE_on = 11, RULE_onStatements = 12, 
		RULE_onStatement = 13, RULE_destroy = 14, RULE_send = 15, RULE_onFilters = 16, 
		RULE_filter = 17, RULE_defineValues = 18, RULE_defineValue = 19, RULE_exprList = 20, 
		RULE_nameList = 21, RULE_declareVar = 22, RULE_varType = 23, RULE_assets = 24, 
		RULE_assetValueWithInnerValue = 25, RULE_assetValue = 26, RULE_assetValuesInner = 27, 
		RULE_expr = 28, RULE_accessVarOp = 29, RULE_parentVarOp = 30, RULE_varOp = 31, 
		RULE_varID = 32, RULE_array = 33, RULE_arrayBody = 34, RULE_itemArray = 35, 
		RULE_parArray = 36;
	public static final String[] ruleNames = {
		"program", "usings", "using", "game", "gameLib", "gameValues", "gameValue", 
		"set", "start", "add", "define", "on", "onStatements", "onStatement", 
		"destroy", "send", "onFilters", "filter", "defineValues", "defineValue", 
		"exprList", "nameList", "declareVar", "varType", "assets", "assetValueWithInnerValue", 
		"assetValue", "assetValuesInner", "expr", "accessVarOp", "parentVarOp", 
		"varOp", "varID", "array", "arrayBody", "itemArray", "parArray"
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
			setState(74); usings();
			setState(75); game();
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
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==USING) {
				{
				{
				setState(78); using();
				}
				}
				setState(83);
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
		public TerminalNode GOAL() { return getToken(FP4GParser.GOAL, 0); }
		public TerminalNode STATE() { return getToken(FP4GParser.STATE, 0); }
		public TerminalNode DOTCOMA() { return getToken(FP4GParser.DOTCOMA, 0); }
		public List<TerminalNode> ID() { return getTokens(FP4GParser.ID); }
		public TerminalNode BEHAVIOR() { return getToken(FP4GParser.BEHAVIOR, 0); }
		public TerminalNode MANAGER() { return getToken(FP4GParser.MANAGER, 0); }
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
			setState(84); match(USING);
			setState(99);
			switch (_input.LA(1)) {
			case MANAGER:
				{
				setState(85); match(MANAGER);
				 ((UsingContext)_localctx).type =  DefineType.MANAGER; 
				}
				break;
			case STATE:
				{
				setState(87); match(STATE);
				 ((UsingContext)_localctx).type =  DefineType.STATE;   
				}
				break;
			case BEHAVIOR:
				{
				setState(89); match(BEHAVIOR);
				 ((UsingContext)_localctx).type =  DefineType.BEHAVIOR;
				}
				break;
			case ENTITY:
				{
				setState(91); match(ENTITY);
				 ((UsingContext)_localctx).type =  DefineType.ENTITY;  
				}
				break;
			case GOAL:
				{
				setState(93); match(GOAL);
				 ((UsingContext)_localctx).type =  DefineType.GOAL;    
				}
				break;
			case MESSAGE:
				{
				setState(95); match(MESSAGE);
				 ((UsingContext)_localctx).type =  DefineType.MESSAGE; 
				}
				break;
			case ID:
				{
				setState(97); ((UsingContext)_localctx).ID = match(ID);
				 ((UsingContext)_localctx).type =  DefineType.valueOf((((UsingContext)_localctx).ID!=null?((UsingContext)_localctx).ID.getText():null));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(101); ((UsingContext)_localctx).name = match(ID);
			setState(102); match(DOTCOMA);
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
			setState(104); match(DEFINE);
			setState(105); match(GAME);
			setState(106); ((GameContext)_localctx).ID = match(ID);
			 ((GameContext)_localctx).name =  (((GameContext)_localctx).ID!=null?((GameContext)_localctx).ID.getText():null); 
			setState(108); match(ABRE_COR);
			setState(109); gameValues();
			setState(110); match(CIERRA_COR);
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
			setState(112); match(DEFINE);
			setState(113); match(GAME);
			setState(114); match(ABRE_COR);
			setState(115); gameValues();
			setState(116); match(CIERRA_COR);
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
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DEFINE) | (1L << ADD) | (1L << ON) | (1L << SET) | (1L << START) | (1L << ID))) != 0)) {
				{
				{
				setState(118); gameValue();
				}
				}
				setState(123);
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
			setState(135);
			switch (_input.LA(1)) {
			case DEFINE:
				enterOuterAlt(_localctx, 1);
				{
				setState(124); define();
				}
				break;
			case ADD:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(125); add();
				setState(126); match(DOTCOMA);
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 3);
				{
				setState(128); set();
				setState(129); match(DOTCOMA);
				}
				break;
			case START:
				enterOuterAlt(_localctx, 4);
				{
				setState(131); start();
				setState(132); match(DOTCOMA);
				}
				break;
			case ON:
				enterOuterAlt(_localctx, 5);
				{
				setState(134); on();
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
			setState(137); match(SET);
			setState(138); ((SetContext)_localctx).ID = match(ID);
			 ((SetContext)_localctx).key =  (((SetContext)_localctx).ID!=null?((SetContext)_localctx).ID.getText():null); 
			setState(140); match(EQUAL);
			setState(141); expr(0);
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
			setState(143); match(START);
			setState(144); ((StartContext)_localctx).ID = match(ID);
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
			setState(150);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(147); ((AddContext)_localctx).ID = match(ID);
				setState(148); match(EQUAL);
				((AddContext)_localctx).varName =  (((AddContext)_localctx).ID!=null?((AddContext)_localctx).ID.getText():null);
				}
			}

			setState(152); match(ADD);
			setState(163);
			switch (_input.LA(1)) {
			case MANAGER:
				{
				setState(153); match(MANAGER);
				 ((AddContext)_localctx).type =  DefineType.MANAGER;  
				}
				break;
			case STATE:
				{
				setState(155); match(STATE);
				 ((AddContext)_localctx).type =  DefineType.STATE;    
				}
				break;
			case BEHAVIOR:
				{
				setState(157); match(BEHAVIOR);
				 ((AddContext)_localctx).type =  DefineType.BEHAVIOR; 
				}
				break;
			case ENTITY:
				{
				setState(159); match(ENTITY);
				 ((AddContext)_localctx).type =  DefineType.ENTITY;  
				}
				break;
			case GOAL:
				{
				setState(161); match(GOAL);
				 ((AddContext)_localctx).type =  DefineType.GOAL;  
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(165); ((AddContext)_localctx).ID = match(ID);
			 ((AddContext)_localctx).addName =  (((AddContext)_localctx).ID!=null?((AddContext)_localctx).ID.getText():null); 
			setState(171);
			_la = _input.LA(1);
			if (_la==ABRE_PAR) {
				{
				setState(167); match(ABRE_PAR);
				setState(168); exprList();
				setState(169); match(CIERRA_PAR);
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
		enterRule(_localctx, 20, RULE_define);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173); match(DEFINE);
			setState(190);
			switch (_input.LA(1)) {
			case MANAGER:
				{
				setState(174); match(MANAGER);
				 ((DefineContext)_localctx).type =  DefineType.MANAGER; 
				}
				break;
			case STATE:
				{
				setState(176); match(STATE);
				 ((DefineContext)_localctx).type =  DefineType.STATE;   
				}
				break;
			case BEHAVIOR:
				{
				setState(178); match(BEHAVIOR);
				 ((DefineContext)_localctx).type =  DefineType.BEHAVIOR;
				}
				break;
			case ENTITY:
				{
				setState(180); match(ENTITY);
				 ((DefineContext)_localctx).type =  DefineType.ENTITY;  
				}
				break;
			case GOAL:
				{
				setState(182); match(GOAL);
				 ((DefineContext)_localctx).type =  DefineType.GOAL;    
				}
				break;
			case MESSAGE:
				{
				setState(184); match(MESSAGE);
				 ((DefineContext)_localctx).type =  DefineType.MESSAGE; 
				}
				break;
			case ASSET:
				{
				setState(186); match(ASSET);
				 ((DefineContext)_localctx).type =  DefineType.ASSET;   
				}
				break;
			case ID:
				{
				setState(188); ((DefineContext)_localctx).ID = match(ID);
				 ((DefineContext)_localctx).type =  DefineType.valueOf((((DefineContext)_localctx).ID!=null?((DefineContext)_localctx).ID.getText():null));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(192); ((DefineContext)_localctx).ID = match(ID);
			 ((DefineContext)_localctx).defName =  (((DefineContext)_localctx).ID!=null?((DefineContext)_localctx).ID.getText():null); 
			setState(198);
			_la = _input.LA(1);
			if (_la==ABRE_PAR) {
				{
				setState(194); match(ABRE_PAR);
				setState(195); nameList();
				setState(196); match(CIERRA_PAR);
				}
			}

			setState(200); match(ABRE_COR);
			setState(201); defineValues();
			setState(202); match(CIERRA_COR);
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
		public OnStatementsContext statements;
		public OnStatementsContext onStatements() {
			return getRuleContext(OnStatementsContext.class,0);
		}
		public TerminalNode DOUBLEDOT() { return getToken(FP4GParser.DOUBLEDOT, 0); }
		public TerminalNode ABRE_COR() { return getToken(FP4GParser.ABRE_COR, 0); }
		public TerminalNode ON() { return getToken(FP4GParser.ON, 0); }
		public TerminalNode CIERRA_COR() { return getToken(FP4GParser.CIERRA_COR, 0); }
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
		enterRule(_localctx, 22, RULE_on);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204); match(ON);
			setState(205); ((OnContext)_localctx).ID = match(ID);
			((OnContext)_localctx).messageName =  (((OnContext)_localctx).ID!=null?((OnContext)_localctx).ID.getText():null); 
			setState(209);
			_la = _input.LA(1);
			if (_la==DOUBLEDOT) {
				{
				setState(207); match(DOUBLEDOT);
				setState(208); ((OnContext)_localctx).filters = onFilters();
				}
			}

			setState(211); match(ABRE_COR);
			setState(212); ((OnContext)_localctx).statements = onStatements();
			setState(213); match(CIERRA_COR);
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

	public static class OnStatementsContext extends ParserRuleContext {
		public TerminalNode DOTCOMA(int i) {
			return getToken(FP4GParser.DOTCOMA, i);
		}
		public OnStatementContext onStatement(int i) {
			return getRuleContext(OnStatementContext.class,i);
		}
		public List<TerminalNode> DOTCOMA() { return getTokens(FP4GParser.DOTCOMA); }
		public List<OnStatementContext> onStatement() {
			return getRuleContexts(OnStatementContext.class);
		}
		public OnStatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_onStatements; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitOnStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OnStatementsContext onStatements() throws RecognitionException {
		OnStatementsContext _localctx = new OnStatementsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_onStatements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEND || _la==DESTROY) {
				{
				{
				setState(215); onStatement();
				setState(216); match(DOTCOMA);
				}
				}
				setState(222);
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

	public static class OnStatementContext extends ParserRuleContext {
		public SendContext send() {
			return getRuleContext(SendContext.class,0);
		}
		public DestroyContext destroy() {
			return getRuleContext(DestroyContext.class,0);
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
		enterRule(_localctx, 26, RULE_onStatement);
		try {
			setState(225);
			switch (_input.LA(1)) {
			case SEND:
				enterOuterAlt(_localctx, 1);
				{
				setState(223); send();
				}
				break;
			case DESTROY:
				enterOuterAlt(_localctx, 2);
				{
				setState(224); destroy();
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
		enterRule(_localctx, 28, RULE_destroy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227); match(DESTROY);
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
		public Send.SendTo receiverType;
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
		enterRule(_localctx, 30, RULE_send);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((SendContext)_localctx).receiverType =  Send.SendTo.Self;
			setState(230); match(SEND);
			setState(231); ((SendContext)_localctx).method = match(ID);
			((SendContext)_localctx).messageMethodName =  (((SendContext)_localctx).method!=null?((SendContext)_localctx).method.getText():null);
			setState(237);
			_la = _input.LA(1);
			if (_la==ABRE_PAR) {
				{
				setState(233); match(ABRE_PAR);
				setState(234); exprList();
				setState(235); match(CIERRA_PAR);
				}
			}

			setState(249);
			_la = _input.LA(1);
			if (_la==TO) {
				{
				setState(239); match(TO);
				setState(246);
				switch (_input.LA(1)) {
				case OTHER:
					{
					setState(240); ((SendContext)_localctx).receiver = match(OTHER);
					((SendContext)_localctx).receiverType =  Send.SendTo.Other;
					}
					break;
				case GAME:
					{
					setState(242); ((SendContext)_localctx).receiver = match(GAME);
					((SendContext)_localctx).receiverType =  Send.SendTo.Game;
					}
					break;
				case ID:
					{
					setState(244); ((SendContext)_localctx).receiver = match(ID);
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
		enterRule(_localctx, 32, RULE_onFilters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251); filter();
			setState(255);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(252); filter();
				}
				}
				setState(257);
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
		enterRule(_localctx, 34, RULE_filter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258); ((FilterContext)_localctx).ID = match(ID);
			((FilterContext)_localctx).filterName =  (((FilterContext)_localctx).ID!=null?((FilterContext)_localctx).ID.getText():null);
			setState(264);
			_la = _input.LA(1);
			if (_la==ABRE_PAR) {
				{
				setState(260); match(ABRE_PAR);
				setState(261); exprList();
				setState(262); match(CIERRA_PAR);
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
		enterRule(_localctx, 36, RULE_defineValues);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << ON) | (1L << SET) | (1L << ASSETS) | (1L << ID))) != 0)) {
				{
				{
				setState(266); defineValue();
				}
				}
				setState(271);
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
		enterRule(_localctx, 38, RULE_defineValue);
		try {
			setState(280);
			switch (_input.LA(1)) {
			case ADD:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(272); add();
				setState(273); match(DOTCOMA);
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 2);
				{
				setState(275); set();
				setState(276); match(DOTCOMA);
				}
				break;
			case ON:
				enterOuterAlt(_localctx, 3);
				{
				setState(278); on();
				}
				break;
			case ASSETS:
				enterOuterAlt(_localctx, 4);
				{
				setState(279); assets();
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
		enterRule(_localctx, 40, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282); expr(0);
			setState(287);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(283); match(COMA);
				setState(284); expr(0);
				}
				}
				setState(289);
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
		enterRule(_localctx, 42, RULE_nameList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290); declareVar();
			setState(295);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(291); match(COMA);
				setState(292); declareVar();
				}
				}
				setState(297);
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
		enterRule(_localctx, 44, RULE_declareVar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298); varType();
			setState(299); ((DeclareVarContext)_localctx).varName = match(ID);
			setState(302);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(300); match(EQUAL);
				setState(301); ((DeclareVarContext)_localctx).initValue = expr(0);
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
		enterRule(_localctx, 46, RULE_varType);
		try {
			setState(312);
			switch (_input.LA(1)) {
			case NUMBER_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(304); match(NUMBER_TYPE);
				((VarTypeContext)_localctx).type =  BasicType.Number;
				}
				break;
			case BOOL_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(306); match(BOOL_TYPE);
				((VarTypeContext)_localctx).type =  BasicType.Bool;
				}
				break;
			case STRING_TYPE:
				enterOuterAlt(_localctx, 3);
				{
				setState(308); match(STRING_TYPE);
				((VarTypeContext)_localctx).type =  BasicType.String;
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(310); ((VarTypeContext)_localctx).ID = match(ID);
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
		enterRule(_localctx, 48, RULE_assets);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(314); match(ASSETS);
			setState(315); match(ABRE_COR);
			setState(316); assetValueWithInnerValue();
			setState(321);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(317); match(COMA);
					setState(318); assetValueWithInnerValue();
					}
					} 
				}
				setState(323);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			setState(325);
			_la = _input.LA(1);
			if (_la==COMA) {
				{
				setState(324); match(COMA);
				}
			}

			setState(327); match(CIERRA_COR);
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
		enterRule(_localctx, 50, RULE_assetValueWithInnerValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329); ((AssetValueWithInnerValueContext)_localctx).value = assetValue();
			setState(331);
			_la = _input.LA(1);
			if (_la==ABRE_COR) {
				{
				setState(330); ((AssetValueWithInnerValueContext)_localctx).innerAssets = assetValuesInner();
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
		public Token asset;
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
		enterRule(_localctx, 52, RULE_assetValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333); ((AssetValueContext)_localctx).assetType = match(ID);
			setState(335);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(334); ((AssetValueContext)_localctx).assetName = match(ID);
				}
			}

			setState(337); match(DOUBLEDOT);
			setState(338); ((AssetValueContext)_localctx).asset = match(STRING_LITERAL);
			setState(340);
			_la = _input.LA(1);
			if (_la==ABRE_LLAV) {
				{
				setState(339); ((AssetValueContext)_localctx).exprParams = array();
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
		enterRule(_localctx, 54, RULE_assetValuesInner);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(342); match(ABRE_COR);
			setState(343); assetValue();
			setState(348);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(344); match(COMA);
					setState(345); assetValue();
					}
					} 
				}
				setState(350);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			setState(352);
			_la = _input.LA(1);
			if (_la==COMA) {
				{
				setState(351); match(COMA);
				}
			}

			setState(354); match(CIERRA_COR);
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
		int _startState = 56;
		enterRecursionRule(_localctx, RULE_expr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(357); match(NOT);
				setState(358); ((NotExprContext)_localctx).op = expr(16);
				}
				break;

			case 2:
				{
				_localctx = new MinusExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(359); match(MINUS);
				setState(360); ((MinusExprContext)_localctx).op = expr(15);
				}
				break;

			case 3:
				{
				_localctx = new ArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(361); array();
				}
				break;

			case 4:
				{
				_localctx = new ParExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(362); match(ABRE_PAR);
				setState(363); ((ParExprContext)_localctx).op = expr(0);
				setState(364); match(CIERRA_PAR);
				}
				break;

			case 5:
				{
				_localctx = new IntLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(366); match(INT_LITERAL);
				}
				break;

			case 6:
				{
				_localctx = new DecimalLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(367); match(DECIMAL_LITERAL);
				}
				break;

			case 7:
				{
				_localctx = new BoolLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(368); match(BOOL_LITERAL);
				}
				break;

			case 8:
				{
				_localctx = new StringLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(369); match(STRING_LITERAL);
				}
				break;

			case 9:
				{
				_localctx = new DirectCodeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(370); match(DIRECTCODE);
				}
				break;

			case 10:
				{
				_localctx = new FunctionCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(371); ((FunctionCallExprContext)_localctx).functionName = match(ID);
				setState(372); match(ABRE_PAR);
				setState(374);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MANAGER) | (1L << GAME) | (1L << STATE) | (1L << ASSET) | (1L << BEHAVIOR) | (1L << ENTITY) | (1L << GOAL) | (1L << MESSAGE) | (1L << ABRE_PAR) | (1L << ABRE_LLAV) | (1L << MINUS) | (1L << NOT) | (1L << DIRECTCODE) | (1L << INT_LITERAL) | (1L << DECIMAL_LITERAL) | (1L << STRING_LITERAL) | (1L << BOOL_LITERAL) | (1L << PARENT_LITERAL) | (1L << CURRENT_LITERAL) | (1L << ID))) != 0)) {
					{
					setState(373); exprList();
					}
				}

				setState(376); match(CIERRA_PAR);
				}
				break;

			case 11:
				{
				_localctx = new VarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(377); accessVarOp();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(403);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(401);
					switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
					case 1:
						{
						_localctx = new LessThanExprContext(new ExprContext(_parentctx, _parentState, _p));
						((LessThanExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(380);
						if (!(14 >= _localctx._p)) throw new FailedPredicateException(this, "14 >= $_p");
						setState(381); match(LESS_THAN);
						setState(382); ((LessThanExprContext)_localctx).right = expr(15);
						}
						break;

					case 2:
						{
						_localctx = new MoreThanExprContext(new ExprContext(_parentctx, _parentState, _p));
						((MoreThanExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(383);
						if (!(13 >= _localctx._p)) throw new FailedPredicateException(this, "13 >= $_p");
						setState(384); match(MORE_THAN);
						setState(385); ((MoreThanExprContext)_localctx).right = expr(14);
						}
						break;

					case 3:
						{
						_localctx = new EqualExprContext(new ExprContext(_parentctx, _parentState, _p));
						((EqualExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(386);
						if (!(12 >= _localctx._p)) throw new FailedPredicateException(this, "12 >= $_p");
						setState(387); match(EQUAL);
						setState(388); ((EqualExprContext)_localctx).right = expr(13);
						}
						break;

					case 4:
						{
						_localctx = new MultExprContext(new ExprContext(_parentctx, _parentState, _p));
						((MultExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(389);
						if (!(11 >= _localctx._p)) throw new FailedPredicateException(this, "11 >= $_p");
						setState(390); match(MULTIPLY);
						setState(391); ((MultExprContext)_localctx).right = expr(12);
						}
						break;

					case 5:
						{
						_localctx = new DivExprContext(new ExprContext(_parentctx, _parentState, _p));
						((DivExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(392);
						if (!(10 >= _localctx._p)) throw new FailedPredicateException(this, "10 >= $_p");
						setState(393); match(DIVIDE);
						setState(394); ((DivExprContext)_localctx).right = expr(11);
						}
						break;

					case 6:
						{
						_localctx = new AddExprContext(new ExprContext(_parentctx, _parentState, _p));
						((AddExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(395);
						if (!(9 >= _localctx._p)) throw new FailedPredicateException(this, "9 >= $_p");
						setState(396); match(PLUS);
						setState(397); ((AddExprContext)_localctx).right = expr(10);
						}
						break;

					case 7:
						{
						_localctx = new SubExprContext(new ExprContext(_parentctx, _parentState, _p));
						((SubExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(398);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(399); match(MINUS);
						setState(400); ((SubExprContext)_localctx).right = expr(9);
						}
						break;
					}
					} 
				}
				setState(405);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
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
		enterRule(_localctx, 58, RULE_accessVarOp);
		try {
			setState(412);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				_localctx = new AccessVarNameContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(406); ((AccessVarNameContext)_localctx).var = varOp();
				}
				break;

			case 2:
				_localctx = new AccessVarOperatorContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(407); ((AccessVarOperatorContext)_localctx).pVar = parentVarOp();
				setState(410);
				switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
				case 1:
					{
					setState(408); match(DOT);
					setState(409); ((AccessVarOperatorContext)_localctx).propertyAccess = accessVarOp();
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
		enterRule(_localctx, 60, RULE_parentVarOp);
		try {
			setState(419);
			switch (_input.LA(1)) {
			case CURRENT_LITERAL:
				_localctx = new CurrentOperatorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(414); match(CURRENT_LITERAL);
				}
				break;
			case PARENT_LITERAL:
				_localctx = new ParentOperatorContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(415); match(PARENT_LITERAL);
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
				setState(416); ((VarNameOperatorContext)_localctx).varName = varID();
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
		enterRule(_localctx, 62, RULE_varOp);
		try {
			setState(424);
			switch (_input.LA(1)) {
			case CURRENT_LITERAL:
				_localctx = new VarCurrentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(421); match(CURRENT_LITERAL);
				}
				break;
			case PARENT_LITERAL:
				_localctx = new VarParentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(422); match(PARENT_LITERAL);
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
				setState(423); ((VarNameContext)_localctx).varName = varID();
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
		enterRule(_localctx, 64, RULE_varID);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(426);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MANAGER) | (1L << GAME) | (1L << STATE) | (1L << ASSET) | (1L << BEHAVIOR) | (1L << ENTITY) | (1L << GOAL) | (1L << MESSAGE) | (1L << ID))) != 0)) ) {
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
		enterRule(_localctx, 66, RULE_array);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(428); match(ABRE_LLAV);
			setState(429); arrayBody();
			setState(430); match(CIERRA_LLAV);
			setState(434);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(431); match(AS);
				setState(432); ((ArrayContext)_localctx).ID = match(ID);
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
		enterRule(_localctx, 68, RULE_arrayBody);
		int _la;
		try {
			int _alt;
			setState(458);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				_localctx = new AssocArrayContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(436); parArray();
				setState(441);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(437); match(COMA);
						setState(438); parArray();
						}
						} 
					}
					setState(443);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
				}
				setState(445);
				_la = _input.LA(1);
				if (_la==COMA) {
					{
					setState(444); match(COMA);
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
				setState(447); itemArray();
				setState(452);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(448); match(COMA);
						setState(449); itemArray();
						}
						} 
					}
					setState(454);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
				}
				setState(456);
				_la = _input.LA(1);
				if (_la==COMA) {
					{
					setState(455); match(COMA);
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
		enterRule(_localctx, 70, RULE_itemArray);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(460); expr(0);
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
		enterRule(_localctx, 72, RULE_parArray);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(462); ((ParArrayContext)_localctx).ID = match(ID);
			 ((ParArrayContext)_localctx).key =  (((ParArrayContext)_localctx).ID!=null?((ParArrayContext)_localctx).ID.getText():null); 
			setState(464); match(EQUAL);
			setState(465); expr(0);
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
		case 28: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 14 >= _localctx._p;

		case 1: return 13 >= _localctx._p;

		case 2: return 12 >= _localctx._p;

		case 3: return 11 >= _localctx._p;

		case 4: return 10 >= _localctx._p;

		case 5: return 9 >= _localctx._p;

		case 6: return 8 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3B\u01d6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\2\3\2\3\3\7\3R\n\3\f\3\16"+
		"\3U\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5"+
		"\4f\n\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\7\7\7z\n\7\f\7\16\7}\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\5\b\u008a\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\5\13\u0099\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\5\13\u00a6\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00ae\n"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\5\f\u00c1\n\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00c9\n\f\3\f\3\f\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\3\r\5\r\u00d4\n\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\7\16"+
		"\u00dd\n\16\f\16\16\16\u00e0\13\16\3\17\3\17\5\17\u00e4\n\17\3\20\3\20"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00f0\n\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\5\21\u00f9\n\21\3\21\5\21\u00fc\n\21\3\22\3\22\7"+
		"\22\u0100\n\22\f\22\16\22\u0103\13\22\3\23\3\23\3\23\3\23\3\23\3\23\5"+
		"\23\u010b\n\23\3\24\7\24\u010e\n\24\f\24\16\24\u0111\13\24\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\5\25\u011b\n\25\3\26\3\26\3\26\7\26\u0120"+
		"\n\26\f\26\16\26\u0123\13\26\3\27\3\27\3\27\7\27\u0128\n\27\f\27\16\27"+
		"\u012b\13\27\3\30\3\30\3\30\3\30\5\30\u0131\n\30\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\5\31\u013b\n\31\3\32\3\32\3\32\3\32\3\32\7\32\u0142"+
		"\n\32\f\32\16\32\u0145\13\32\3\32\5\32\u0148\n\32\3\32\3\32\3\33\3\33"+
		"\5\33\u014e\n\33\3\34\3\34\5\34\u0152\n\34\3\34\3\34\3\34\5\34\u0157\n"+
		"\34\3\35\3\35\3\35\3\35\7\35\u015d\n\35\f\35\16\35\u0160\13\35\3\35\5"+
		"\35\u0163\n\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u0179\n\36\3\36\3\36"+
		"\5\36\u017d\n\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\7\36\u0194\n\36\f\36"+
		"\16\36\u0197\13\36\3\37\3\37\3\37\3\37\5\37\u019d\n\37\5\37\u019f\n\37"+
		"\3 \3 \3 \3 \3 \5 \u01a6\n \3!\3!\3!\5!\u01ab\n!\3\"\3\"\3#\3#\3#\3#\3"+
		"#\3#\5#\u01b5\n#\3$\3$\3$\7$\u01ba\n$\f$\16$\u01bd\13$\3$\5$\u01c0\n$"+
		"\3$\3$\3$\7$\u01c5\n$\f$\16$\u01c8\13$\3$\5$\u01cb\n$\5$\u01cd\n$\3%\3"+
		"%\3&\3&\3&\3&\3&\3&\2\'\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*"+
		",.\60\62\64\668:<>@BDFHJ\2\3\4\2\24\33@@\u0202\2L\3\2\2\2\4S\3\2\2\2\6"+
		"V\3\2\2\2\bj\3\2\2\2\nr\3\2\2\2\f{\3\2\2\2\16\u0089\3\2\2\2\20\u008b\3"+
		"\2\2\2\22\u0091\3\2\2\2\24\u0098\3\2\2\2\26\u00af\3\2\2\2\30\u00ce\3\2"+
		"\2\2\32\u00de\3\2\2\2\34\u00e3\3\2\2\2\36\u00e5\3\2\2\2 \u00e7\3\2\2\2"+
		"\"\u00fd\3\2\2\2$\u0104\3\2\2\2&\u010f\3\2\2\2(\u011a\3\2\2\2*\u011c\3"+
		"\2\2\2,\u0124\3\2\2\2.\u012c\3\2\2\2\60\u013a\3\2\2\2\62\u013c\3\2\2\2"+
		"\64\u014b\3\2\2\2\66\u014f\3\2\2\28\u0158\3\2\2\2:\u017c\3\2\2\2<\u019e"+
		"\3\2\2\2>\u01a5\3\2\2\2@\u01aa\3\2\2\2B\u01ac\3\2\2\2D\u01ae\3\2\2\2F"+
		"\u01cc\3\2\2\2H\u01ce\3\2\2\2J\u01d0\3\2\2\2LM\5\4\3\2MN\5\b\5\2NO\7\2"+
		"\2\3O\3\3\2\2\2PR\5\6\4\2QP\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2T\5\3"+
		"\2\2\2US\3\2\2\2Ve\7\17\2\2WX\7\24\2\2Xf\b\4\1\2YZ\7\26\2\2Zf\b\4\1\2"+
		"[\\\7\30\2\2\\f\b\4\1\2]^\7\31\2\2^f\b\4\1\2_`\7\32\2\2`f\b\4\1\2ab\7"+
		"\33\2\2bf\b\4\1\2cd\7@\2\2df\b\4\1\2eW\3\2\2\2eY\3\2\2\2e[\3\2\2\2e]\3"+
		"\2\2\2e_\3\2\2\2ea\3\2\2\2ec\3\2\2\2fg\3\2\2\2gh\7@\2\2hi\7*\2\2i\7\3"+
		"\2\2\2jk\7\5\2\2kl\7\25\2\2lm\7@\2\2mn\b\5\1\2no\7!\2\2op\5\f\7\2pq\7"+
		"$\2\2q\t\3\2\2\2rs\7\5\2\2st\7\25\2\2tu\7!\2\2uv\5\f\7\2vw\7$\2\2w\13"+
		"\3\2\2\2xz\5\16\b\2yx\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|\r\3\2\2\2"+
		"}{\3\2\2\2~\u008a\5\26\f\2\177\u0080\5\24\13\2\u0080\u0081\7*\2\2\u0081"+
		"\u008a\3\2\2\2\u0082\u0083\5\20\t\2\u0083\u0084\7*\2\2\u0084\u008a\3\2"+
		"\2\2\u0085\u0086\5\22\n\2\u0086\u0087\7*\2\2\u0087\u008a\3\2\2\2\u0088"+
		"\u008a\5\30\r\2\u0089~\3\2\2\2\u0089\177\3\2\2\2\u0089\u0082\3\2\2\2\u0089"+
		"\u0085\3\2\2\2\u0089\u0088\3\2\2\2\u008a\17\3\2\2\2\u008b\u008c\7\21\2"+
		"\2\u008c\u008d\7@\2\2\u008d\u008e\b\t\1\2\u008e\u008f\7(\2\2\u008f\u0090"+
		"\5:\36\2\u0090\21\3\2\2\2\u0091\u0092\7\22\2\2\u0092\u0093\7@\2\2\u0093"+
		"\u0094\b\n\1\2\u0094\23\3\2\2\2\u0095\u0096\7@\2\2\u0096\u0097\7(\2\2"+
		"\u0097\u0099\b\13\1\2\u0098\u0095\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a"+
		"\3\2\2\2\u009a\u00a5\7\6\2\2\u009b\u009c\7\24\2\2\u009c\u00a6\b\13\1\2"+
		"\u009d\u009e\7\26\2\2\u009e\u00a6\b\13\1\2\u009f\u00a0\7\30\2\2\u00a0"+
		"\u00a6\b\13\1\2\u00a1\u00a2\7\31\2\2\u00a2\u00a6\b\13\1\2\u00a3\u00a4"+
		"\7\32\2\2\u00a4\u00a6\b\13\1\2\u00a5\u009b\3\2\2\2\u00a5\u009d\3\2\2\2"+
		"\u00a5\u009f\3\2\2\2\u00a5\u00a1\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6\u00a7"+
		"\3\2\2\2\u00a7\u00a8\7@\2\2\u00a8\u00ad\b\13\1\2\u00a9\u00aa\7\"\2\2\u00aa"+
		"\u00ab\5*\26\2\u00ab\u00ac\7%\2\2\u00ac\u00ae\3\2\2\2\u00ad\u00a9\3\2"+
		"\2\2\u00ad\u00ae\3\2\2\2\u00ae\25\3\2\2\2\u00af\u00c0\7\5\2\2\u00b0\u00b1"+
		"\7\24\2\2\u00b1\u00c1\b\f\1\2\u00b2\u00b3\7\26\2\2\u00b3\u00c1\b\f\1\2"+
		"\u00b4\u00b5\7\30\2\2\u00b5\u00c1\b\f\1\2\u00b6\u00b7\7\31\2\2\u00b7\u00c1"+
		"\b\f\1\2\u00b8\u00b9\7\32\2\2\u00b9\u00c1\b\f\1\2\u00ba\u00bb\7\33\2\2"+
		"\u00bb\u00c1\b\f\1\2\u00bc\u00bd\7\27\2\2\u00bd\u00c1\b\f\1\2\u00be\u00bf"+
		"\7@\2\2\u00bf\u00c1\b\f\1\2\u00c0\u00b0\3\2\2\2\u00c0\u00b2\3\2\2\2\u00c0"+
		"\u00b4\3\2\2\2\u00c0\u00b6\3\2\2\2\u00c0\u00b8\3\2\2\2\u00c0\u00ba\3\2"+
		"\2\2\u00c0\u00bc\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2"+
		"\u00c3\7@\2\2\u00c3\u00c8\b\f\1\2\u00c4\u00c5\7\"\2\2\u00c5\u00c6\5,\27"+
		"\2\u00c6\u00c7\7%\2\2\u00c7\u00c9\3\2\2\2\u00c8\u00c4\3\2\2\2\u00c8\u00c9"+
		"\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\7!\2\2\u00cb\u00cc\5&\24\2\u00cc"+
		"\u00cd\7$\2\2\u00cd\27\3\2\2\2\u00ce\u00cf\7\7\2\2\u00cf\u00d0\7@\2\2"+
		"\u00d0\u00d3\b\r\1\2\u00d1\u00d2\7+\2\2\u00d2\u00d4\5\"\22\2\u00d3\u00d1"+
		"\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\7!\2\2\u00d6"+
		"\u00d7\5\32\16\2\u00d7\u00d8\7$\2\2\u00d8\31\3\2\2\2\u00d9\u00da\5\34"+
		"\17\2\u00da\u00db\7*\2\2\u00db\u00dd\3\2\2\2\u00dc\u00d9\3\2\2\2\u00dd"+
		"\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\33\3\2\2"+
		"\2\u00e0\u00de\3\2\2\2\u00e1\u00e4\5 \21\2\u00e2\u00e4\5\36\20\2\u00e3"+
		"\u00e1\3\2\2\2\u00e3\u00e2\3\2\2\2\u00e4\35\3\2\2\2\u00e5\u00e6\7\t\2"+
		"\2\u00e6\37\3\2\2\2\u00e7\u00e8\b\21\1\2\u00e8\u00e9\7\b\2\2\u00e9\u00ea"+
		"\7@\2\2\u00ea\u00ef\b\21\1\2\u00eb\u00ec\7\"\2\2\u00ec\u00ed\5*\26\2\u00ed"+
		"\u00ee\7%\2\2\u00ee\u00f0\3\2\2\2\u00ef\u00eb\3\2\2\2\u00ef\u00f0\3\2"+
		"\2\2\u00f0\u00fb\3\2\2\2\u00f1\u00f8\7\35\2\2\u00f2\u00f3\7 \2\2\u00f3"+
		"\u00f9\b\21\1\2\u00f4\u00f5\7\25\2\2\u00f5\u00f9\b\21\1\2\u00f6\u00f7"+
		"\7@\2\2\u00f7\u00f9\b\21\1\2\u00f8\u00f2\3\2\2\2\u00f8\u00f4\3\2\2\2\u00f8"+
		"\u00f6\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fc\b\21\1\2\u00fb\u00f1\3"+
		"\2\2\2\u00fb\u00fc\3\2\2\2\u00fc!\3\2\2\2\u00fd\u0101\5$\23\2\u00fe\u0100"+
		"\5$\23\2\u00ff\u00fe\3\2\2\2\u0100\u0103\3\2\2\2\u0101\u00ff\3\2\2\2\u0101"+
		"\u0102\3\2\2\2\u0102#\3\2\2\2\u0103\u0101\3\2\2\2\u0104\u0105\7@\2\2\u0105"+
		"\u010a\b\23\1\2\u0106\u0107\7\"\2\2\u0107\u0108\5*\26\2\u0108\u0109\7"+
		"%\2\2\u0109\u010b\3\2\2\2\u010a\u0106\3\2\2\2\u010a\u010b\3\2\2\2\u010b"+
		"%\3\2\2\2\u010c\u010e\5(\25\2\u010d\u010c\3\2\2\2\u010e\u0111\3\2\2\2"+
		"\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\'\3\2\2\2\u0111\u010f\3"+
		"\2\2\2\u0112\u0113\5\24\13\2\u0113\u0114\7*\2\2\u0114\u011b\3\2\2\2\u0115"+
		"\u0116\5\20\t\2\u0116\u0117\7*\2\2\u0117\u011b\3\2\2\2\u0118\u011b\5\30"+
		"\r\2\u0119\u011b\5\62\32\2\u011a\u0112\3\2\2\2\u011a\u0115\3\2\2\2\u011a"+
		"\u0118\3\2\2\2\u011a\u0119\3\2\2\2\u011b)\3\2\2\2\u011c\u0121\5:\36\2"+
		"\u011d\u011e\7\'\2\2\u011e\u0120\5:\36\2\u011f\u011d\3\2\2\2\u0120\u0123"+
		"\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122+\3\2\2\2\u0123"+
		"\u0121\3\2\2\2\u0124\u0129\5.\30\2\u0125\u0126\7\'\2\2\u0126\u0128\5."+
		"\30\2\u0127\u0125\3\2\2\2\u0128\u012b\3\2\2\2\u0129\u0127\3\2\2\2\u0129"+
		"\u012a\3\2\2\2\u012a-\3\2\2\2\u012b\u0129\3\2\2\2\u012c\u012d\5\60\31"+
		"\2\u012d\u0130\7@\2\2\u012e\u012f\7(\2\2\u012f\u0131\5:\36\2\u0130\u012e"+
		"\3\2\2\2\u0130\u0131\3\2\2\2\u0131/\3\2\2\2\u0132\u0133\7\66\2\2\u0133"+
		"\u013b\b\31\1\2\u0134\u0135\78\2\2\u0135\u013b\b\31\1\2\u0136\u0137\7"+
		"\67\2\2\u0137\u013b\b\31\1\2\u0138\u0139\7@\2\2\u0139\u013b\b\31\1\2\u013a"+
		"\u0132\3\2\2\2\u013a\u0134\3\2\2\2\u013a\u0136\3\2\2\2\u013a\u0138\3\2"+
		"\2\2\u013b\61\3\2\2\2\u013c\u013d\7\23\2\2\u013d\u013e\7!\2\2\u013e\u0143"+
		"\5\64\33\2\u013f\u0140\7\'\2\2\u0140\u0142\5\64\33\2\u0141\u013f\3\2\2"+
		"\2\u0142\u0145\3\2\2\2\u0143\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0147"+
		"\3\2\2\2\u0145\u0143\3\2\2\2\u0146\u0148\7\'\2\2\u0147\u0146\3\2\2\2\u0147"+
		"\u0148\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u014a\7$\2\2\u014a\63\3\2\2\2"+
		"\u014b\u014d\5\66\34\2\u014c\u014e\58\35\2\u014d\u014c\3\2\2\2\u014d\u014e"+
		"\3\2\2\2\u014e\65\3\2\2\2\u014f\u0151\7@\2\2\u0150\u0152\7@\2\2\u0151"+
		"\u0150\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0154\7+"+
		"\2\2\u0154\u0156\7<\2\2\u0155\u0157\5D#\2\u0156\u0155\3\2\2\2\u0156\u0157"+
		"\3\2\2\2\u0157\67\3\2\2\2\u0158\u0159\7!\2\2\u0159\u015e\5\66\34\2\u015a"+
		"\u015b\7\'\2\2\u015b\u015d\5\66\34\2\u015c\u015a\3\2\2\2\u015d\u0160\3"+
		"\2\2\2\u015e\u015c\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u0162\3\2\2\2\u0160"+
		"\u015e\3\2\2\2\u0161\u0163\7\'\2\2\u0162\u0161\3\2\2\2\u0162\u0163\3\2"+
		"\2\2\u0163\u0164\3\2\2\2\u0164\u0165\7$\2\2\u01659\3\2\2\2\u0166\u0167"+
		"\b\36\1\2\u0167\u0168\7\65\2\2\u0168\u017d\5:\36\2\u0169\u016a\7-\2\2"+
		"\u016a\u017d\5:\36\2\u016b\u017d\5D#\2\u016c\u016d\7\"\2\2\u016d\u016e"+
		"\5:\36\2\u016e\u016f\7%\2\2\u016f\u017d\3\2\2\2\u0170\u017d\7:\2\2\u0171"+
		"\u017d\7;\2\2\u0172\u017d\7=\2\2\u0173\u017d\7<\2\2\u0174\u017d\79\2\2"+
		"\u0175\u0176\7@\2\2\u0176\u0178\7\"\2\2\u0177\u0179\5*\26\2\u0178\u0177"+
		"\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u017d\7%\2\2\u017b"+
		"\u017d\5<\37\2\u017c\u0166\3\2\2\2\u017c\u0169\3\2\2\2\u017c\u016b\3\2"+
		"\2\2\u017c\u016c\3\2\2\2\u017c\u0170\3\2\2\2\u017c\u0171\3\2\2\2\u017c"+
		"\u0172\3\2\2\2\u017c\u0173\3\2\2\2\u017c\u0174\3\2\2\2\u017c\u0175\3\2"+
		"\2\2\u017c\u017b\3\2\2\2\u017d\u0195\3\2\2\2\u017e\u017f\6\36\2\3\u017f"+
		"\u0180\7\61\2\2\u0180\u0194\5:\36\2\u0181\u0182\6\36\3\3\u0182\u0183\7"+
		"\60\2\2\u0183\u0194\5:\36\2\u0184\u0185\6\36\4\3\u0185\u0186\7(\2\2\u0186"+
		"\u0194\5:\36\2\u0187\u0188\6\36\5\3\u0188\u0189\7.\2\2\u0189\u0194\5:"+
		"\36\2\u018a\u018b\6\36\6\3\u018b\u018c\7/\2\2\u018c\u0194\5:\36\2\u018d"+
		"\u018e\6\36\7\3\u018e\u018f\7,\2\2\u018f\u0194\5:\36\2\u0190\u0191\6\36"+
		"\b\3\u0191\u0192\7-\2\2\u0192\u0194\5:\36\2\u0193\u017e\3\2\2\2\u0193"+
		"\u0181\3\2\2\2\u0193\u0184\3\2\2\2\u0193\u0187\3\2\2\2\u0193\u018a\3\2"+
		"\2\2\u0193\u018d\3\2\2\2\u0193\u0190\3\2\2\2\u0194\u0197\3\2\2\2\u0195"+
		"\u0193\3\2\2\2\u0195\u0196\3\2\2\2\u0196;\3\2\2\2\u0197\u0195\3\2\2\2"+
		"\u0198\u019f\5@!\2\u0199\u019c\5> \2\u019a\u019b\7)\2\2\u019b\u019d\5"+
		"<\37\2\u019c\u019a\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u019f\3\2\2\2\u019e"+
		"\u0198\3\2\2\2\u019e\u0199\3\2\2\2\u019f=\3\2\2\2\u01a0\u01a6\7?\2\2\u01a1"+
		"\u01a6\7>\2\2\u01a2\u01a3\5B\"\2\u01a3\u01a4\b \1\2\u01a4\u01a6\3\2\2"+
		"\2\u01a5\u01a0\3\2\2\2\u01a5\u01a1\3\2\2\2\u01a5\u01a2\3\2\2\2\u01a6?"+
		"\3\2\2\2\u01a7\u01ab\7?\2\2\u01a8\u01ab\7>\2\2\u01a9\u01ab\5B\"\2\u01aa"+
		"\u01a7\3\2\2\2\u01aa\u01a8\3\2\2\2\u01aa\u01a9\3\2\2\2\u01abA\3\2\2\2"+
		"\u01ac\u01ad\t\2\2\2\u01adC\3\2\2\2\u01ae\u01af\7#\2\2\u01af\u01b0\5F"+
		"$\2\u01b0\u01b4\7&\2\2\u01b1\u01b2\7\37\2\2\u01b2\u01b3\7@\2\2\u01b3\u01b5"+
		"\b#\1\2\u01b4\u01b1\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5E\3\2\2\2\u01b6\u01bb"+
		"\5J&\2\u01b7\u01b8\7\'\2\2\u01b8\u01ba\5J&\2\u01b9\u01b7\3\2\2\2\u01ba"+
		"\u01bd\3\2\2\2\u01bb\u01b9\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc\u01bf\3\2"+
		"\2\2\u01bd\u01bb\3\2\2\2\u01be\u01c0\7\'\2\2\u01bf\u01be\3\2\2\2\u01bf"+
		"\u01c0\3\2\2\2\u01c0\u01cd\3\2\2\2\u01c1\u01c6\5H%\2\u01c2\u01c3\7\'\2"+
		"\2\u01c3\u01c5\5H%\2\u01c4\u01c2\3\2\2\2\u01c5\u01c8\3\2\2\2\u01c6\u01c4"+
		"\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7\u01ca\3\2\2\2\u01c8\u01c6\3\2\2\2\u01c9"+
		"\u01cb\7\'\2\2\u01ca\u01c9\3\2\2\2\u01ca\u01cb\3\2\2\2\u01cb\u01cd\3\2"+
		"\2\2\u01cc\u01b6\3\2\2\2\u01cc\u01c1\3\2\2\2\u01cdG\3\2\2\2\u01ce\u01cf"+
		"\5:\36\2\u01cfI\3\2\2\2\u01d0\u01d1\7@\2\2\u01d1\u01d2\b&\1\2\u01d2\u01d3"+
		"\7(\2\2\u01d3\u01d4\5:\36\2\u01d4K\3\2\2\2.Se{\u0089\u0098\u00a5\u00ad"+
		"\u00c0\u00c8\u00d3\u00de\u00e3\u00ef\u00f8\u00fb\u0101\u010a\u010f\u011a"+
		"\u0121\u0129\u0130\u013a\u0143\u0147\u014d\u0151\u0156\u015e\u0162\u0178"+
		"\u017c\u0193\u0195\u019c\u019e\u01a5\u01aa\u01b4\u01bb\u01bf\u01c6\u01ca"+
		"\u01cc";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}