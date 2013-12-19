// Generated from C:\Users\Edgardo\Git\fp4g-src\fp4g\src/fp4g/parser/FP4G.g4 by ANTLR 4.1

package fp4g.parser;

import static fp4g.Log.*;

import fp4g.data.*;
import fp4g.data.define.*;

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
		SET=14, START=15, ASSETS=16, MANAGER=17, GAME=18, STATE=19, BEHAVIOR=20, 
		ENTITY=21, GOAL=22, MESSAGE=23, BASE=24, TO=25, SOURCE=26, AS=27, ABRE_COR=28, 
		ABRE_PAR=29, ABRE_LLAV=30, CIERRA_COR=31, CIERRA_PAR=32, CIERRA_LLAV=33, 
		COMA=34, EQUAL=35, DOT=36, DOTCOMA=37, DOUBLEDOT=38, PLUS=39, MINUS=40, 
		MULTIPLY=41, DIVIDE=42, AND=43, OR=44, XOR=45, NOT=46, INT_TYPE=47, DEC_TYPE=48, 
		STRING_TYPE=49, BOOL_TYPE=50, ENTITY_TYPE=51, TEXTURE_TYPE=52, SPRITE_TYPE=53, 
		ATLAS_TYPE=54, DIRECTCODE=55, INT_LITERAL=56, DECIMAL_LITERAL=57, STRING_LITERAL=58, 
		BOOL_LITERAL=59, PARENT_LITERAL=60, CURRENT_LITERAL=61, ID=62, NL=63, 
		WS=64;
	public static final String[] tokenNames = {
		"<INVALID>", "SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT", "'DEFINE'", 
		"'ADD'", "'ON'", "'SEND'", "'GROUP'", "'SUBSCRIBE'", "'UNSUBSCRIBE'", 
		"'RESUME'", "'PAUSE'", "'USING'", "'EXIT'", "'SET'", "'START'", "'ASSETS'", 
		"'MANAGER'", "'GAME'", "'STATE'", "'BEHAVIOR'", "'ENTITY'", "'GOAL'", 
		"'MESSAGE'", "'BASE'", "'TO'", "'SOURCE'", "'AS'", "'['", "'('", "'{'", 
		"']'", "')'", "'}'", "','", "'='", "'.'", "';'", "':'", "'+'", "'-'", 
		"'*'", "'/'", "'AND'", "'OR'", "'XOR'", "'NOT'", "'Int'", "'Dec'", "'String'", 
		"'Bool'", "'Entity'", "'Texture'", "'Sprite'", "'Atlas'", "DIRECTCODE", 
		"INT_LITERAL", "DECIMAL_LITERAL", "STRING_LITERAL", "BOOL_LITERAL", "'parent'", 
		"'current'", "ID", "NL", "WS"
	};
	public static final int
		RULE_program = 0, RULE_usings = 1, RULE_using = 2, RULE_game = 3, RULE_gameLib = 4, 
		RULE_gameValues = 5, RULE_gameValue = 6, RULE_set = 7, RULE_start = 8, 
		RULE_add = 9, RULE_define = 10, RULE_on = 11, RULE_onStatement = 12, RULE_send = 13, 
		RULE_onFilters = 14, RULE_filter = 15, RULE_defineValues = 16, RULE_defineValue = 17, 
		RULE_exprList = 18, RULE_nameList = 19, RULE_declareVar = 20, RULE_varType = 21, 
		RULE_assetType = 22, RULE_assets = 23, RULE_assetValue = 24, RULE_assetValuesInner = 25, 
		RULE_assetValueInner = 26, RULE_expr = 27, RULE_accessVarOp = 28, RULE_parentVarOp = 29, 
		RULE_varOp = 30, RULE_array = 31, RULE_parArray = 32;
	public static final String[] ruleNames = {
		"program", "usings", "using", "game", "gameLib", "gameValues", "gameValue", 
		"set", "start", "add", "define", "on", "onStatement", "send", "onFilters", 
		"filter", "defineValues", "defineValue", "exprList", "nameList", "declareVar", 
		"varType", "assetType", "assets", "assetValue", "assetValuesInner", "assetValueInner", 
		"expr", "accessVarOp", "parentVarOp", "varOp", "array", "parArray"
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
			setState(66); usings();
			setState(67); game();
			setState(68); match(EOF);
			}
		}
		catch (RecognitionException re) {
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
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==USING) {
				{
				{
				setState(70); using();
				}
				}
				setState(75);
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
			setState(76); match(USING);
			setState(77);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MANAGER) | (1L << STATE) | (1L << BEHAVIOR) | (1L << ENTITY) | (1L << GOAL) | (1L << MESSAGE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(78); match(ID);
			setState(79); match(DOTCOMA);
			}
		}
		catch (RecognitionException re) {
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
			setState(81); match(DEFINE);
			setState(82); match(GAME);
			setState(83); ((GameContext)_localctx).ID = match(ID);
			 ((GameContext)_localctx).name =  (((GameContext)_localctx).ID!=null?((GameContext)_localctx).ID.getText():null); 
			setState(85); match(ABRE_COR);
			setState(86); gameValues();
			setState(87); match(CIERRA_COR);
			}
		}
		catch (RecognitionException re) {
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
			setState(89); match(DEFINE);
			setState(90); match(GAME);
			setState(91); match(ABRE_COR);
			setState(92); gameValues();
			setState(93); match(CIERRA_COR);
			}
		}
		catch (RecognitionException re) {
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
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DEFINE) | (1L << ADD) | (1L << ON) | (1L << SET) | (1L << START) | (1L << ID))) != 0)) {
				{
				{
				setState(95); gameValue();
				}
				}
				setState(100);
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
			setState(112);
			switch (_input.LA(1)) {
			case DEFINE:
				enterOuterAlt(_localctx, 1);
				{
				setState(101); define();
				}
				break;
			case ADD:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(102); add();
				setState(103); match(DOTCOMA);
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 3);
				{
				setState(105); set();
				setState(106); match(DOTCOMA);
				}
				break;
			case START:
				enterOuterAlt(_localctx, 4);
				{
				setState(108); start();
				setState(109); match(DOTCOMA);
				}
				break;
			case ON:
				enterOuterAlt(_localctx, 5);
				{
				setState(111); on();
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
			setState(114); match(SET);
			setState(115); ((SetContext)_localctx).ID = match(ID);
			 ((SetContext)_localctx).key =  (((SetContext)_localctx).ID!=null?((SetContext)_localctx).ID.getText():null); 
			setState(117); match(EQUAL);
			setState(118); expr(0);
			}
		}
		catch (RecognitionException re) {
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
			setState(120); match(START);
			setState(121); ((StartContext)_localctx).ID = match(ID);
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
			setState(127);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(124); ((AddContext)_localctx).ID = match(ID);
				setState(125); match(EQUAL);
				((AddContext)_localctx).varName =  (((AddContext)_localctx).ID!=null?((AddContext)_localctx).ID.getText():null);
				}
			}

			setState(129); match(ADD);
			setState(140);
			switch (_input.LA(1)) {
			case MANAGER:
				{
				setState(130); match(MANAGER);
				 ((AddContext)_localctx).type =  DefineType.MANAGER;  
				}
				break;
			case STATE:
				{
				setState(132); match(STATE);
				 ((AddContext)_localctx).type =  DefineType.STATE;    
				}
				break;
			case BEHAVIOR:
				{
				setState(134); match(BEHAVIOR);
				 ((AddContext)_localctx).type =  DefineType.BEHAVIOR; 
				}
				break;
			case ENTITY:
				{
				setState(136); match(ENTITY);
				 ((AddContext)_localctx).type =  DefineType.ENTITY;  
				}
				break;
			case GOAL:
				{
				setState(138); match(GOAL);
				 ((AddContext)_localctx).type =  DefineType.GOAL;  
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(142); ((AddContext)_localctx).ID = match(ID);
			 ((AddContext)_localctx).addName =  (((AddContext)_localctx).ID!=null?((AddContext)_localctx).ID.getText():null); 
			setState(148);
			_la = _input.LA(1);
			if (_la==ABRE_PAR) {
				{
				setState(144); match(ABRE_PAR);
				setState(145); exprList();
				setState(146); match(CIERRA_PAR);
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
			setState(150); match(DEFINE);
			setState(163);
			switch (_input.LA(1)) {
			case MANAGER:
				{
				setState(151); match(MANAGER);
				 ((DefineContext)_localctx).type =  DefineType.MANAGER; 
				}
				break;
			case STATE:
				{
				setState(153); match(STATE);
				 ((DefineContext)_localctx).type =  DefineType.STATE;   
				}
				break;
			case BEHAVIOR:
				{
				setState(155); match(BEHAVIOR);
				 ((DefineContext)_localctx).type =  DefineType.BEHAVIOR;
				}
				break;
			case ENTITY:
				{
				setState(157); match(ENTITY);
				 ((DefineContext)_localctx).type =  DefineType.ENTITY;  
				}
				break;
			case GOAL:
				{
				setState(159); match(GOAL);
				 ((DefineContext)_localctx).type =  DefineType.GOAL;    
				}
				break;
			case MESSAGE:
				{
				setState(161); match(MESSAGE);
				 ((DefineContext)_localctx).type =  DefineType.MESSAGE; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(165); ((DefineContext)_localctx).ID = match(ID);
			 ((DefineContext)_localctx).defName =  (((DefineContext)_localctx).ID!=null?((DefineContext)_localctx).ID.getText():null); 
			setState(171);
			_la = _input.LA(1);
			if (_la==ABRE_PAR) {
				{
				setState(167); match(ABRE_PAR);
				setState(168); nameList();
				setState(169); match(CIERRA_PAR);
				}
			}

			setState(173); match(ABRE_COR);
			setState(174); defineValues();
			setState(175); match(CIERRA_COR);
			}
		}
		catch (RecognitionException re) {
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
			setState(177); match(ON);
			setState(178); ((OnContext)_localctx).ID = match(ID);
			((OnContext)_localctx).messageName =  (((OnContext)_localctx).ID!=null?((OnContext)_localctx).ID.getText():null); 
			setState(182);
			_la = _input.LA(1);
			if (_la==DOUBLEDOT) {
				{
				setState(180); match(DOUBLEDOT);
				setState(181); ((OnContext)_localctx).filters = onFilters();
				}
			}

			setState(184); match(ABRE_COR);
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEND) {
				{
				{
				setState(185); onStatement();
				setState(186); match(DOTCOMA);
				}
				}
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(193); match(CIERRA_COR);
			}
		}
		catch (RecognitionException re) {
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
			setState(195); send();
			}
		}
		catch (RecognitionException re) {
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
			setState(197); match(SEND);
			setState(198); ((SendContext)_localctx).method = match(ID);
			((SendContext)_localctx).messageMethodName =  (((SendContext)_localctx).method!=null?((SendContext)_localctx).method.getText():null);
			setState(204);
			_la = _input.LA(1);
			if (_la==ABRE_PAR) {
				{
				setState(200); match(ABRE_PAR);
				setState(201); exprList();
				setState(202); match(CIERRA_PAR);
				}
			}

			setState(209);
			_la = _input.LA(1);
			if (_la==TO) {
				{
				setState(206); match(TO);
				setState(207); ((SendContext)_localctx).receiver = match(ID);
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
			setState(211); ((OnFiltersContext)_localctx).filter = filter();
			_localctx.or.add(((OnFiltersContext)_localctx).filter.filters);
			setState(218);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(213); ((OnFiltersContext)_localctx).filter = filter();
				_localctx.or.add(((OnFiltersContext)_localctx).filter.filters);
				}
				}
				setState(220);
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
			setState(221); ((FilterContext)_localctx).ID = match(ID);
			_localctx.filters.add((((FilterContext)_localctx).ID!=null?((FilterContext)_localctx).ID.getText():null));
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(223); match(COMA);
				setState(224); ((FilterContext)_localctx).ID = match(ID);
				_localctx.filters.add((((FilterContext)_localctx).ID!=null?((FilterContext)_localctx).ID.getText():null));
				}
				}
				setState(230);
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
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << ON) | (1L << SET) | (1L << ASSETS) | (1L << ID))) != 0)) {
				{
				{
				setState(231); defineValue();
				}
				}
				setState(236);
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
			setState(245);
			switch (_input.LA(1)) {
			case ADD:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(237); add();
				setState(238); match(DOTCOMA);
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 2);
				{
				setState(240); set();
				setState(241); match(DOTCOMA);
				}
				break;
			case ON:
				enterOuterAlt(_localctx, 3);
				{
				setState(243); on();
				}
				break;
			case ASSETS:
				enterOuterAlt(_localctx, 4);
				{
				setState(244); assets();
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
			setState(247); expr(0);
			setState(252);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(248); match(COMA);
				setState(249); expr(0);
				}
				}
				setState(254);
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
			setState(255); declareVar();
			setState(260);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(256); match(COMA);
				setState(257); declareVar();
				}
				}
				setState(262);
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
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263); varType();
			setState(264); match(ID);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode ENTITY_TYPE() { return getToken(FP4GParser.ENTITY_TYPE, 0); }
		public TerminalNode INT_TYPE() { return getToken(FP4GParser.INT_TYPE, 0); }
		public TerminalNode DEC_TYPE() { return getToken(FP4GParser.DEC_TYPE, 0); }
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
			setState(278);
			switch (_input.LA(1)) {
			case INT_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(266); match(INT_TYPE);
				((VarTypeContext)_localctx).type =  VarType.Integer;
				}
				break;
			case DEC_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(268); match(DEC_TYPE);
				((VarTypeContext)_localctx).type =  VarType.Decimal;
				}
				break;
			case BOOL_TYPE:
				enterOuterAlt(_localctx, 3);
				{
				setState(270); match(BOOL_TYPE);
				((VarTypeContext)_localctx).type =  VarType.Bool;
				}
				break;
			case ENTITY_TYPE:
				enterOuterAlt(_localctx, 4);
				{
				setState(272); match(ENTITY_TYPE);
				((VarTypeContext)_localctx).type =  VarType.Entity;
				}
				break;
			case STRING_TYPE:
				enterOuterAlt(_localctx, 5);
				{
				setState(274); match(STRING_TYPE);
				((VarTypeContext)_localctx).type =  VarType.String;
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 6);
				{
				setState(276); match(ID);
				((VarTypeContext)_localctx).type =  VarType.Custom;
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

	public static class AssetTypeContext extends ParserRuleContext {
		public AssetType type = null;
		public TerminalNode SPRITE_TYPE() { return getToken(FP4GParser.SPRITE_TYPE, 0); }
		public TerminalNode ATLAS_TYPE() { return getToken(FP4GParser.ATLAS_TYPE, 0); }
		public TerminalNode TEXTURE_TYPE() { return getToken(FP4GParser.TEXTURE_TYPE, 0); }
		public AssetTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assetType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitAssetType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssetTypeContext assetType() throws RecognitionException {
		AssetTypeContext _localctx = new AssetTypeContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_assetType);
		try {
			setState(286);
			switch (_input.LA(1)) {
			case TEXTURE_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(280); match(TEXTURE_TYPE);
				((AssetTypeContext)_localctx).type =  AssetType.Texture;
				}
				break;
			case SPRITE_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(282); match(SPRITE_TYPE);
				((AssetTypeContext)_localctx).type =  AssetType.Sprite;
				}
				break;
			case ATLAS_TYPE:
				enterOuterAlt(_localctx, 3);
				{
				setState(284); match(ATLAS_TYPE);
				((AssetTypeContext)_localctx).type =  AssetType.Atlas;
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
		enterRule(_localctx, 46, RULE_assets);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(288); match(ASSETS);
			setState(289); match(ABRE_COR);
			setState(290); assetValue();
			setState(295);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(291); match(COMA);
					setState(292); assetValue();
					}
					} 
				}
				setState(297);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			setState(299);
			_la = _input.LA(1);
			if (_la==COMA) {
				{
				setState(298); match(COMA);
				}
			}

			setState(301); match(CIERRA_COR);
			}
		}
		catch (RecognitionException re) {
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
		public Token assetName;
		public Token asset;
		public TerminalNode DOUBLEDOT() { return getToken(FP4GParser.DOUBLEDOT, 0); }
		public AssetTypeContext assetType() {
			return getRuleContext(AssetTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(FP4GParser.STRING_LITERAL, 0); }
		public AssetValuesInnerContext assetValuesInner() {
			return getRuleContext(AssetValuesInnerContext.class,0);
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
		enterRule(_localctx, 48, RULE_assetValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303); assetType();
			setState(305);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(304); ((AssetValueContext)_localctx).assetName = match(ID);
				}
			}

			setState(307); match(DOUBLEDOT);
			setState(308); ((AssetValueContext)_localctx).asset = match(STRING_LITERAL);
			setState(310);
			_la = _input.LA(1);
			if (_la==ABRE_COR) {
				{
				setState(309); assetValuesInner();
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
		enterRule(_localctx, 50, RULE_assetValuesInner);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(312); match(ABRE_COR);
			setState(313); assetValueInner();
			setState(318);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(314); match(COMA);
					setState(315); assetValueInner();
					}
					} 
				}
				setState(320);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			setState(322);
			_la = _input.LA(1);
			if (_la==COMA) {
				{
				setState(321); match(COMA);
				}
			}

			setState(324); match(CIERRA_COR);
			}
		}
		catch (RecognitionException re) {
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
		public Token assetName;
		public Token asset;
		public TerminalNode DOUBLEDOT() { return getToken(FP4GParser.DOUBLEDOT, 0); }
		public AssetTypeContext assetType() {
			return getRuleContext(AssetTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(FP4GParser.STRING_LITERAL, 0); }
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
		enterRule(_localctx, 52, RULE_assetValueInner);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326); assetType();
			setState(328);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(327); ((AssetValueInnerContext)_localctx).assetName = match(ID);
				}
			}

			setState(330); match(DOUBLEDOT);
			setState(331); ((AssetValueInnerContext)_localctx).asset = match(STRING_LITERAL);
			}
		}
		catch (RecognitionException re) {
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
		int _startState = 54;
		enterRecursionRule(_localctx, RULE_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(334); match(NOT);
				setState(335); ((NotExprContext)_localctx).op = expr(13);
				}
				break;

			case 2:
				{
				_localctx = new MinusExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(336); match(MINUS);
				setState(337); ((MinusExprContext)_localctx).op = expr(12);
				}
				break;

			case 3:
				{
				_localctx = new ArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(338); array();
				}
				break;

			case 4:
				{
				_localctx = new ParExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(339); match(ABRE_PAR);
				setState(340); ((ParExprContext)_localctx).op = expr(0);
				setState(341); match(CIERRA_PAR);
				}
				break;

			case 5:
				{
				_localctx = new IntLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(343); match(INT_LITERAL);
				}
				break;

			case 6:
				{
				_localctx = new DecimalLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(344); match(DECIMAL_LITERAL);
				}
				break;

			case 7:
				{
				_localctx = new BoolLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(345); match(BOOL_LITERAL);
				}
				break;

			case 8:
				{
				_localctx = new StringLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(346); match(STRING_LITERAL);
				}
				break;

			case 9:
				{
				_localctx = new DirectCodeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(347); match(DIRECTCODE);
				}
				break;

			case 10:
				{
				_localctx = new FunctionCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(348); ((FunctionCallExprContext)_localctx).functionName = match(ID);
				setState(349); match(ABRE_PAR);
				setState(350); exprList();
				setState(351); match(CIERRA_PAR);
				}
				break;

			case 11:
				{
				_localctx = new VarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(353); accessVarOp();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(370);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(368);
					switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
					case 1:
						{
						_localctx = new MultExprContext(new ExprContext(_parentctx, _parentState, _p));
						((MultExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(356);
						if (!(11 >= _localctx._p)) throw new FailedPredicateException(this, "11 >= $_p");
						setState(357); match(MULTIPLY);
						setState(358); ((MultExprContext)_localctx).right = expr(12);
						}
						break;

					case 2:
						{
						_localctx = new DivExprContext(new ExprContext(_parentctx, _parentState, _p));
						((DivExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(359);
						if (!(10 >= _localctx._p)) throw new FailedPredicateException(this, "10 >= $_p");
						setState(360); match(DIVIDE);
						setState(361); ((DivExprContext)_localctx).right = expr(11);
						}
						break;

					case 3:
						{
						_localctx = new AddExprContext(new ExprContext(_parentctx, _parentState, _p));
						((AddExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(362);
						if (!(9 >= _localctx._p)) throw new FailedPredicateException(this, "9 >= $_p");
						setState(363); match(PLUS);
						setState(364); ((AddExprContext)_localctx).right = expr(10);
						}
						break;

					case 4:
						{
						_localctx = new SubExprContext(new ExprContext(_parentctx, _parentState, _p));
						((SubExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(365);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(366); match(MINUS);
						setState(367); ((SubExprContext)_localctx).right = expr(9);
						}
						break;
					}
					} 
				}
				setState(372);
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
		enterRule(_localctx, 56, RULE_accessVarOp);
		try {
			setState(379);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				_localctx = new AccessVarNameContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(373); ((AccessVarNameContext)_localctx).var = varOp();
				}
				break;

			case 2:
				_localctx = new AccessVarOperatorContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(374); ((AccessVarOperatorContext)_localctx).pVar = parentVarOp();
				setState(377);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					setState(375); match(DOT);
					setState(376); ((AccessVarOperatorContext)_localctx).propertyAccess = accessVarOp();
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
		enterRule(_localctx, 58, RULE_parentVarOp);
		try {
			setState(385);
			switch (_input.LA(1)) {
			case CURRENT_LITERAL:
				_localctx = new CurrentOperatorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(381); match(CURRENT_LITERAL);
				}
				break;
			case PARENT_LITERAL:
				_localctx = new ParentOperatorContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(382); match(PARENT_LITERAL);
				}
				break;
			case ID:
				_localctx = new VarNameOperatorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(383); ((VarNameOperatorContext)_localctx).varName = match(ID);
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
		enterRule(_localctx, 60, RULE_varOp);
		try {
			setState(390);
			switch (_input.LA(1)) {
			case CURRENT_LITERAL:
				_localctx = new VarCurrentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(387); match(CURRENT_LITERAL);
				}
				break;
			case PARENT_LITERAL:
				_localctx = new VarParentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(388); match(PARENT_LITERAL);
				}
				break;
			case ID:
				_localctx = new VarNameContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(389); ((VarNameContext)_localctx).varName = match(ID);
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
		enterRule(_localctx, 62, RULE_array);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(392); match(ABRE_LLAV);
			setState(393); parArray();
			setState(398);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(394); match(COMA);
					setState(395); parArray();
					}
					} 
				}
				setState(400);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			}
			setState(402);
			_la = _input.LA(1);
			if (_la==COMA) {
				{
				setState(401); match(COMA);
				}
			}

			setState(404); match(CIERRA_LLAV);
			setState(408);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(405); match(AS);
				setState(406); ((ArrayContext)_localctx).ID = match(ID);
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
		enterRule(_localctx, 64, RULE_parArray);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(410); ((ParArrayContext)_localctx).ID = match(ID);
			 ((ParArrayContext)_localctx).key =  (((ParArrayContext)_localctx).ID!=null?((ParArrayContext)_localctx).ID.getText():null); 
			setState(412); match(EQUAL);
			setState(413); expr(0);
			}
		}
		catch (RecognitionException re) {
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
		case 27: return expr_sempred((ExprContext)_localctx, predIndex);
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3B\u01a2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\2\3\2\3\3\7\3J\n\3\f\3\16\3M\13\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\7\7"+
		"c\n\7\f\7\16\7f\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bs"+
		"\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\5\13\u0082"+
		"\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u008f"+
		"\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0097\n\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00a6\n\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\5\f\u00ae\n\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\5\r\u00b9\n\r\3\r"+
		"\3\r\3\r\3\r\7\r\u00bf\n\r\f\r\16\r\u00c2\13\r\3\r\3\r\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00cf\n\17\3\17\3\17\3\17\5\17\u00d4"+
		"\n\17\3\20\3\20\3\20\3\20\3\20\7\20\u00db\n\20\f\20\16\20\u00de\13\20"+
		"\3\21\3\21\3\21\3\21\3\21\7\21\u00e5\n\21\f\21\16\21\u00e8\13\21\3\22"+
		"\7\22\u00eb\n\22\f\22\16\22\u00ee\13\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\5\23\u00f8\n\23\3\24\3\24\3\24\7\24\u00fd\n\24\f\24\16\24\u0100"+
		"\13\24\3\25\3\25\3\25\7\25\u0105\n\25\f\25\16\25\u0108\13\25\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27"+
		"\u0119\n\27\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0121\n\30\3\31\3\31\3"+
		"\31\3\31\3\31\7\31\u0128\n\31\f\31\16\31\u012b\13\31\3\31\5\31\u012e\n"+
		"\31\3\31\3\31\3\32\3\32\5\32\u0134\n\32\3\32\3\32\3\32\5\32\u0139\n\32"+
		"\3\33\3\33\3\33\3\33\7\33\u013f\n\33\f\33\16\33\u0142\13\33\3\33\5\33"+
		"\u0145\n\33\3\33\3\33\3\34\3\34\5\34\u014b\n\34\3\34\3\34\3\34\3\35\3"+
		"\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3"+
		"\35\3\35\3\35\3\35\3\35\3\35\5\35\u0165\n\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\7\35\u0173\n\35\f\35\16\35\u0176\13"+
		"\35\3\36\3\36\3\36\3\36\5\36\u017c\n\36\5\36\u017e\n\36\3\37\3\37\3\37"+
		"\3\37\5\37\u0184\n\37\3 \3 \3 \5 \u0189\n \3!\3!\3!\3!\7!\u018f\n!\f!"+
		"\16!\u0192\13!\3!\5!\u0195\n!\3!\3!\3!\3!\5!\u019b\n!\3\"\3\"\3\"\3\""+
		"\3\"\3\"\2#\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66"+
		"8:<>@B\2\3\4\2\23\23\25\31\u01c3\2D\3\2\2\2\4K\3\2\2\2\6N\3\2\2\2\bS\3"+
		"\2\2\2\n[\3\2\2\2\fd\3\2\2\2\16r\3\2\2\2\20t\3\2\2\2\22z\3\2\2\2\24\u0081"+
		"\3\2\2\2\26\u0098\3\2\2\2\30\u00b3\3\2\2\2\32\u00c5\3\2\2\2\34\u00c7\3"+
		"\2\2\2\36\u00d5\3\2\2\2 \u00df\3\2\2\2\"\u00ec\3\2\2\2$\u00f7\3\2\2\2"+
		"&\u00f9\3\2\2\2(\u0101\3\2\2\2*\u0109\3\2\2\2,\u0118\3\2\2\2.\u0120\3"+
		"\2\2\2\60\u0122\3\2\2\2\62\u0131\3\2\2\2\64\u013a\3\2\2\2\66\u0148\3\2"+
		"\2\28\u0164\3\2\2\2:\u017d\3\2\2\2<\u0183\3\2\2\2>\u0188\3\2\2\2@\u018a"+
		"\3\2\2\2B\u019c\3\2\2\2DE\5\4\3\2EF\5\b\5\2FG\7\2\2\3G\3\3\2\2\2HJ\5\6"+
		"\4\2IH\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2L\5\3\2\2\2MK\3\2\2\2NO\7"+
		"\16\2\2OP\t\2\2\2PQ\7@\2\2QR\7\'\2\2R\7\3\2\2\2ST\7\5\2\2TU\7\24\2\2U"+
		"V\7@\2\2VW\b\5\1\2WX\7\36\2\2XY\5\f\7\2YZ\7!\2\2Z\t\3\2\2\2[\\\7\5\2\2"+
		"\\]\7\24\2\2]^\7\36\2\2^_\5\f\7\2_`\7!\2\2`\13\3\2\2\2ac\5\16\b\2ba\3"+
		"\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2e\r\3\2\2\2fd\3\2\2\2gs\5\26\f\2h"+
		"i\5\24\13\2ij\7\'\2\2js\3\2\2\2kl\5\20\t\2lm\7\'\2\2ms\3\2\2\2no\5\22"+
		"\n\2op\7\'\2\2ps\3\2\2\2qs\5\30\r\2rg\3\2\2\2rh\3\2\2\2rk\3\2\2\2rn\3"+
		"\2\2\2rq\3\2\2\2s\17\3\2\2\2tu\7\20\2\2uv\7@\2\2vw\b\t\1\2wx\7%\2\2xy"+
		"\58\35\2y\21\3\2\2\2z{\7\21\2\2{|\7@\2\2|}\b\n\1\2}\23\3\2\2\2~\177\7"+
		"@\2\2\177\u0080\7%\2\2\u0080\u0082\b\13\1\2\u0081~\3\2\2\2\u0081\u0082"+
		"\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u008e\7\6\2\2\u0084\u0085\7\23\2\2"+
		"\u0085\u008f\b\13\1\2\u0086\u0087\7\25\2\2\u0087\u008f\b\13\1\2\u0088"+
		"\u0089\7\26\2\2\u0089\u008f\b\13\1\2\u008a\u008b\7\27\2\2\u008b\u008f"+
		"\b\13\1\2\u008c\u008d\7\30\2\2\u008d\u008f\b\13\1\2\u008e\u0084\3\2\2"+
		"\2\u008e\u0086\3\2\2\2\u008e\u0088\3\2\2\2\u008e\u008a\3\2\2\2\u008e\u008c"+
		"\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\7@\2\2\u0091\u0096\b\13\1\2\u0092"+
		"\u0093\7\37\2\2\u0093\u0094\5&\24\2\u0094\u0095\7\"\2\2\u0095\u0097\3"+
		"\2\2\2\u0096\u0092\3\2\2\2\u0096\u0097\3\2\2\2\u0097\25\3\2\2\2\u0098"+
		"\u00a5\7\5\2\2\u0099\u009a\7\23\2\2\u009a\u00a6\b\f\1\2\u009b\u009c\7"+
		"\25\2\2\u009c\u00a6\b\f\1\2\u009d\u009e\7\26\2\2\u009e\u00a6\b\f\1\2\u009f"+
		"\u00a0\7\27\2\2\u00a0\u00a6\b\f\1\2\u00a1\u00a2\7\30\2\2\u00a2\u00a6\b"+
		"\f\1\2\u00a3\u00a4\7\31\2\2\u00a4\u00a6\b\f\1\2\u00a5\u0099\3\2\2\2\u00a5"+
		"\u009b\3\2\2\2\u00a5\u009d\3\2\2\2\u00a5\u009f\3\2\2\2\u00a5\u00a1\3\2"+
		"\2\2\u00a5\u00a3\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\7@\2\2\u00a8"+
		"\u00ad\b\f\1\2\u00a9\u00aa\7\37\2\2\u00aa\u00ab\5(\25\2\u00ab\u00ac\7"+
		"\"\2\2\u00ac\u00ae\3\2\2\2\u00ad\u00a9\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae"+
		"\u00af\3\2\2\2\u00af\u00b0\7\36\2\2\u00b0\u00b1\5\"\22\2\u00b1\u00b2\7"+
		"!\2\2\u00b2\27\3\2\2\2\u00b3\u00b4\7\7\2\2\u00b4\u00b5\7@\2\2\u00b5\u00b8"+
		"\b\r\1\2\u00b6\u00b7\7(\2\2\u00b7\u00b9\5\36\20\2\u00b8\u00b6\3\2\2\2"+
		"\u00b8\u00b9\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00c0\7\36\2\2\u00bb\u00bc"+
		"\5\32\16\2\u00bc\u00bd\7\'\2\2\u00bd\u00bf\3\2\2\2\u00be\u00bb\3\2\2\2"+
		"\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c3"+
		"\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00c4\7!\2\2\u00c4\31\3\2\2\2\u00c5"+
		"\u00c6\5\34\17\2\u00c6\33\3\2\2\2\u00c7\u00c8\7\b\2\2\u00c8\u00c9\7@\2"+
		"\2\u00c9\u00ce\b\17\1\2\u00ca\u00cb\7\37\2\2\u00cb\u00cc\5&\24\2\u00cc"+
		"\u00cd\7\"\2\2\u00cd\u00cf\3\2\2\2\u00ce\u00ca\3\2\2\2\u00ce\u00cf\3\2"+
		"\2\2\u00cf\u00d3\3\2\2\2\u00d0\u00d1\7\33\2\2\u00d1\u00d2\7@\2\2\u00d2"+
		"\u00d4\b\17\1\2\u00d3\u00d0\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\35\3\2\2"+
		"\2\u00d5\u00d6\5 \21\2\u00d6\u00dc\b\20\1\2\u00d7\u00d8\5 \21\2\u00d8"+
		"\u00d9\b\20\1\2\u00d9\u00db\3\2\2\2\u00da\u00d7\3\2\2\2\u00db\u00de\3"+
		"\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\37\3\2\2\2\u00de"+
		"\u00dc\3\2\2\2\u00df\u00e0\7@\2\2\u00e0\u00e6\b\21\1\2\u00e1\u00e2\7$"+
		"\2\2\u00e2\u00e3\7@\2\2\u00e3\u00e5\b\21\1\2\u00e4\u00e1\3\2\2\2\u00e5"+
		"\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7!\3\2\2\2"+
		"\u00e8\u00e6\3\2\2\2\u00e9\u00eb\5$\23\2\u00ea\u00e9\3\2\2\2\u00eb\u00ee"+
		"\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed#\3\2\2\2\u00ee"+
		"\u00ec\3\2\2\2\u00ef\u00f0\5\24\13\2\u00f0\u00f1\7\'\2\2\u00f1\u00f8\3"+
		"\2\2\2\u00f2\u00f3\5\20\t\2\u00f3\u00f4\7\'\2\2\u00f4\u00f8\3\2\2\2\u00f5"+
		"\u00f8\5\30\r\2\u00f6\u00f8\5\60\31\2\u00f7\u00ef\3\2\2\2\u00f7\u00f2"+
		"\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f6\3\2\2\2\u00f8%\3\2\2\2\u00f9"+
		"\u00fe\58\35\2\u00fa\u00fb\7$\2\2\u00fb\u00fd\58\35\2\u00fc\u00fa\3\2"+
		"\2\2\u00fd\u0100\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff"+
		"\'\3\2\2\2\u0100\u00fe\3\2\2\2\u0101\u0106\5*\26\2\u0102\u0103\7$\2\2"+
		"\u0103\u0105\5*\26\2\u0104\u0102\3\2\2\2\u0105\u0108\3\2\2\2\u0106\u0104"+
		"\3\2\2\2\u0106\u0107\3\2\2\2\u0107)\3\2\2\2\u0108\u0106\3\2\2\2\u0109"+
		"\u010a\5,\27\2\u010a\u010b\7@\2\2\u010b+\3\2\2\2\u010c\u010d\7\61\2\2"+
		"\u010d\u0119\b\27\1\2\u010e\u010f\7\62\2\2\u010f\u0119\b\27\1\2\u0110"+
		"\u0111\7\64\2\2\u0111\u0119\b\27\1\2\u0112\u0113\7\65\2\2\u0113\u0119"+
		"\b\27\1\2\u0114\u0115\7\63\2\2\u0115\u0119\b\27\1\2\u0116\u0117\7@\2\2"+
		"\u0117\u0119\b\27\1\2\u0118\u010c\3\2\2\2\u0118\u010e\3\2\2\2\u0118\u0110"+
		"\3\2\2\2\u0118\u0112\3\2\2\2\u0118\u0114\3\2\2\2\u0118\u0116\3\2\2\2\u0119"+
		"-\3\2\2\2\u011a\u011b\7\66\2\2\u011b\u0121\b\30\1\2\u011c\u011d\7\67\2"+
		"\2\u011d\u0121\b\30\1\2\u011e\u011f\78\2\2\u011f\u0121\b\30\1\2\u0120"+
		"\u011a\3\2\2\2\u0120\u011c\3\2\2\2\u0120\u011e\3\2\2\2\u0121/\3\2\2\2"+
		"\u0122\u0123\7\22\2\2\u0123\u0124\7\36\2\2\u0124\u0129\5\62\32\2\u0125"+
		"\u0126\7$\2\2\u0126\u0128\5\62\32\2\u0127\u0125\3\2\2\2\u0128\u012b\3"+
		"\2\2\2\u0129\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012d\3\2\2\2\u012b"+
		"\u0129\3\2\2\2\u012c\u012e\7$\2\2\u012d\u012c\3\2\2\2\u012d\u012e\3\2"+
		"\2\2\u012e\u012f\3\2\2\2\u012f\u0130\7!\2\2\u0130\61\3\2\2\2\u0131\u0133"+
		"\5.\30\2\u0132\u0134\7@\2\2\u0133\u0132\3\2\2\2\u0133\u0134\3\2\2\2\u0134"+
		"\u0135\3\2\2\2\u0135\u0136\7(\2\2\u0136\u0138\7<\2\2\u0137\u0139\5\64"+
		"\33\2\u0138\u0137\3\2\2\2\u0138\u0139\3\2\2\2\u0139\63\3\2\2\2\u013a\u013b"+
		"\7\36\2\2\u013b\u0140\5\66\34\2\u013c\u013d\7$\2\2\u013d\u013f\5\66\34"+
		"\2\u013e\u013c\3\2\2\2\u013f\u0142\3\2\2\2\u0140\u013e\3\2\2\2\u0140\u0141"+
		"\3\2\2\2\u0141\u0144\3\2\2\2\u0142\u0140\3\2\2\2\u0143\u0145\7$\2\2\u0144"+
		"\u0143\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0146\3\2\2\2\u0146\u0147\7!"+
		"\2\2\u0147\65\3\2\2\2\u0148\u014a\5.\30\2\u0149\u014b\7@\2\2\u014a\u0149"+
		"\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u014d\7(\2\2\u014d"+
		"\u014e\7<\2\2\u014e\67\3\2\2\2\u014f\u0150\b\35\1\2\u0150\u0151\7\60\2"+
		"\2\u0151\u0165\58\35\2\u0152\u0153\7*\2\2\u0153\u0165\58\35\2\u0154\u0165"+
		"\5@!\2\u0155\u0156\7\37\2\2\u0156\u0157\58\35\2\u0157\u0158\7\"\2\2\u0158"+
		"\u0165\3\2\2\2\u0159\u0165\7:\2\2\u015a\u0165\7;\2\2\u015b\u0165\7=\2"+
		"\2\u015c\u0165\7<\2\2\u015d\u0165\79\2\2\u015e\u015f\7@\2\2\u015f\u0160"+
		"\7\37\2\2\u0160\u0161\5&\24\2\u0161\u0162\7\"\2\2\u0162\u0165\3\2\2\2"+
		"\u0163\u0165\5:\36\2\u0164\u014f\3\2\2\2\u0164\u0152\3\2\2\2\u0164\u0154"+
		"\3\2\2\2\u0164\u0155\3\2\2\2\u0164\u0159\3\2\2\2\u0164\u015a\3\2\2\2\u0164"+
		"\u015b\3\2\2\2\u0164\u015c\3\2\2\2\u0164\u015d\3\2\2\2\u0164\u015e\3\2"+
		"\2\2\u0164\u0163\3\2\2\2\u0165\u0174\3\2\2\2\u0166\u0167\6\35\2\3\u0167"+
		"\u0168\7+\2\2\u0168\u0173\58\35\2\u0169\u016a\6\35\3\3\u016a\u016b\7,"+
		"\2\2\u016b\u0173\58\35\2\u016c\u016d\6\35\4\3\u016d\u016e\7)\2\2\u016e"+
		"\u0173\58\35\2\u016f\u0170\6\35\5\3\u0170\u0171\7*\2\2\u0171\u0173\58"+
		"\35\2\u0172\u0166\3\2\2\2\u0172\u0169\3\2\2\2\u0172\u016c\3\2\2\2\u0172"+
		"\u016f\3\2\2\2\u0173\u0176\3\2\2\2\u0174\u0172\3\2\2\2\u0174\u0175\3\2"+
		"\2\2\u01759\3\2\2\2\u0176\u0174\3\2\2\2\u0177\u017e\5> \2\u0178\u017b"+
		"\5<\37\2\u0179\u017a\7&\2\2\u017a\u017c\5:\36\2\u017b\u0179\3\2\2\2\u017b"+
		"\u017c\3\2\2\2\u017c\u017e\3\2\2\2\u017d\u0177\3\2\2\2\u017d\u0178\3\2"+
		"\2\2\u017e;\3\2\2\2\u017f\u0184\7?\2\2\u0180\u0184\7>\2\2\u0181\u0182"+
		"\7@\2\2\u0182\u0184\b\37\1\2\u0183\u017f\3\2\2\2\u0183\u0180\3\2\2\2\u0183"+
		"\u0181\3\2\2\2\u0184=\3\2\2\2\u0185\u0189\7?\2\2\u0186\u0189\7>\2\2\u0187"+
		"\u0189\7@\2\2\u0188\u0185\3\2\2\2\u0188\u0186\3\2\2\2\u0188\u0187\3\2"+
		"\2\2\u0189?\3\2\2\2\u018a\u018b\7 \2\2\u018b\u0190\5B\"\2\u018c\u018d"+
		"\7$\2\2\u018d\u018f\5B\"\2\u018e\u018c\3\2\2\2\u018f\u0192\3\2\2\2\u0190"+
		"\u018e\3\2\2\2\u0190\u0191\3\2\2\2\u0191\u0194\3\2\2\2\u0192\u0190\3\2"+
		"\2\2\u0193\u0195\7$\2\2\u0194\u0193\3\2\2\2\u0194\u0195\3\2\2\2\u0195"+
		"\u0196\3\2\2\2\u0196\u019a\7#\2\2\u0197\u0198\7\35\2\2\u0198\u0199\7@"+
		"\2\2\u0199\u019b\b!\1\2\u019a\u0197\3\2\2\2\u019a\u019b\3\2\2\2\u019b"+
		"A\3\2\2\2\u019c\u019d\7@\2\2\u019d\u019e\b\"\1\2\u019e\u019f\7%\2\2\u019f"+
		"\u01a0\58\35\2\u01a0C\3\2\2\2\'Kdr\u0081\u008e\u0096\u00a5\u00ad\u00b8"+
		"\u00c0\u00ce\u00d3\u00dc\u00e6\u00ec\u00f7\u00fe\u0106\u0118\u0120\u0129"+
		"\u012d\u0133\u0138\u0140\u0144\u014a\u0164\u0172\u0174\u017b\u017d\u0183"+
		"\u0188\u0190\u0194\u019a";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}