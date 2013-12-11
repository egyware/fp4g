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
		BOOL_LITERAL=59, ID=60, NL=61, WS=62;
	public static final String[] tokenNames = {
		"<INVALID>", "SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT", "'DEFINE'", 
		"'ADD'", "'ON'", "'SEND'", "'GROUP'", "'SUBSCRIBE'", "'UNSUBSCRIBE'", 
		"'RESUME'", "'PAUSE'", "'USING'", "'EXIT'", "'SET'", "'START'", "'ASSETS'", 
		"'MANAGER'", "'GAME'", "'STATE'", "'BEHAVIOR'", "'ENTITY'", "'GOAL'", 
		"'MESSAGE'", "'BASE'", "'TO'", "'SOURCE'", "'AS'", "'['", "'('", "'{'", 
		"']'", "')'", "'}'", "','", "'='", "'.'", "';'", "':'", "'+'", "'-'", 
		"'*'", "'/'", "'AND'", "'OR'", "'XOR'", "'NOT'", "'Int'", "'Dec'", "'String'", 
		"'Bool'", "'Entity'", "'Texture'", "'Sprite'", "'Atlas'", "DIRECTCODE", 
		"INT_LITERAL", "DECIMAL_LITERAL", "STRING_LITERAL", "BOOL_LITERAL", "ID", 
		"NL", "WS"
	};
	public static final int
		RULE_program = 0, RULE_usings = 1, RULE_using = 2, RULE_game = 3, RULE_gameLib = 4, 
		RULE_gameValues = 5, RULE_gameValue = 6, RULE_set = 7, RULE_start = 8, 
		RULE_add = 9, RULE_define = 10, RULE_on = 11, RULE_onStatement = 12, RULE_send = 13, 
		RULE_onFilters = 14, RULE_filter = 15, RULE_defineValues = 16, RULE_defineValue = 17, 
		RULE_exprList = 18, RULE_nameList = 19, RULE_declareVar = 20, RULE_varType = 21, 
		RULE_assetType = 22, RULE_assets = 23, RULE_assetValue = 24, RULE_assetValuesInner = 25, 
		RULE_assetValueInner = 26, RULE_expr = 27, RULE_lExpr = 28, RULE_nExpr = 29, 
		RULE_accessVarOp = 30, RULE_variable = 31, RULE_array = 32, RULE_parArray = 33;
	public static final String[] ruleNames = {
		"program", "usings", "using", "game", "gameLib", "gameValues", "gameValue", 
		"set", "start", "add", "define", "on", "onStatement", "send", "onFilters", 
		"filter", "defineValues", "defineValue", "exprList", "nameList", "declareVar", 
		"varType", "assetType", "assets", "assetValue", "assetValuesInner", "assetValueInner", 
		"expr", "lExpr", "nExpr", "accessVarOp", "variable", "array", "parArray"
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
			setState(120); expr();
			}
		}
		catch (RecognitionException re) {
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
			setState(165);
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
			default:
				throw new NoViableAltException(this);
			}
			setState(167); ((DefineContext)_localctx).ID = match(ID);
			 ((DefineContext)_localctx).defName =  (((DefineContext)_localctx).ID!=null?((DefineContext)_localctx).ID.getText():null); 
			setState(173);
			_la = _input.LA(1);
			if (_la==ABRE_PAR) {
				{
				setState(169); match(ABRE_PAR);
				setState(170); nameList();
				setState(171); match(CIERRA_PAR);
				}
			}

			setState(175); match(ABRE_COR);
			setState(176); defineValues();
			setState(177); match(CIERRA_COR);
			}
		}
		catch (RecognitionException re) {
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
			setState(179); match(ON);
			setState(180); ((OnContext)_localctx).ID = match(ID);
			((OnContext)_localctx).messageName =  (((OnContext)_localctx).ID!=null?((OnContext)_localctx).ID.getText():null); 
			setState(184);
			_la = _input.LA(1);
			if (_la==DOUBLEDOT) {
				{
				setState(182); match(DOUBLEDOT);
				setState(183); ((OnContext)_localctx).filters = onFilters();
				}
			}

			setState(186); match(ABRE_COR);
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEND) {
				{
				{
				setState(187); onStatement();
				setState(188); match(DOTCOMA);
				}
				}
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(195); match(CIERRA_COR);
			}
		}
		catch (RecognitionException re) {
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
			setState(197); send();
			}
		}
		catch (RecognitionException re) {
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
			setState(199); match(SEND);
			setState(200); ((SendContext)_localctx).method = match(ID);
			((SendContext)_localctx).messageMethodName =  (((SendContext)_localctx).method!=null?((SendContext)_localctx).method.getText():null);
			setState(206);
			_la = _input.LA(1);
			if (_la==ABRE_PAR) {
				{
				setState(202); match(ABRE_PAR);
				setState(203); exprList();
				setState(204); match(CIERRA_PAR);
				}
			}

			setState(211);
			_la = _input.LA(1);
			if (_la==TO) {
				{
				setState(208); match(TO);
				setState(209); ((SendContext)_localctx).receiver = match(ID);
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
			setState(213); ((OnFiltersContext)_localctx).filter = filter();
			_localctx.or.add(((OnFiltersContext)_localctx).filter.filters);
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(215); ((OnFiltersContext)_localctx).filter = filter();
				_localctx.or.add(((OnFiltersContext)_localctx).filter.filters);
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
			setState(223); ((FilterContext)_localctx).ID = match(ID);
			_localctx.filters.add((((FilterContext)_localctx).ID!=null?((FilterContext)_localctx).ID.getText():null));
			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(225); match(COMA);
				setState(226); ((FilterContext)_localctx).ID = match(ID);
				_localctx.filters.add((((FilterContext)_localctx).ID!=null?((FilterContext)_localctx).ID.getText():null));
				}
				}
				setState(232);
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
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << ON) | (1L << SET) | (1L << ASSETS) | (1L << ID))) != 0)) {
				{
				{
				setState(233); defineValue();
				}
				}
				setState(238);
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
			setState(247);
			switch (_input.LA(1)) {
			case ADD:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(239); add();
				setState(240); match(DOTCOMA);
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 2);
				{
				setState(242); set();
				setState(243); match(DOTCOMA);
				}
				break;
			case ON:
				enterOuterAlt(_localctx, 3);
				{
				setState(245); on();
				}
				break;
			case ASSETS:
				enterOuterAlt(_localctx, 4);
				{
				setState(246); assets();
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
			setState(249); expr();
			setState(254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(250); match(COMA);
				setState(251); expr();
				}
				}
				setState(256);
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
			setState(257); declareVar();
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(258); match(COMA);
				setState(259); declareVar();
				}
				}
				setState(264);
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
			setState(265); varType();
			setState(266); match(ID);
			}
		}
		catch (RecognitionException re) {
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
			setState(280);
			switch (_input.LA(1)) {
			case INT_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(268); match(INT_TYPE);
				((VarTypeContext)_localctx).type =  VarType.Integer;
				}
				break;
			case DEC_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(270); match(DEC_TYPE);
				((VarTypeContext)_localctx).type =  VarType.Decimal;
				}
				break;
			case BOOL_TYPE:
				enterOuterAlt(_localctx, 3);
				{
				setState(272); match(BOOL_TYPE);
				((VarTypeContext)_localctx).type =  VarType.Bool;
				}
				break;
			case ENTITY_TYPE:
				enterOuterAlt(_localctx, 4);
				{
				setState(274); match(ENTITY_TYPE);
				((VarTypeContext)_localctx).type =  VarType.Entity;
				}
				break;
			case STRING_TYPE:
				enterOuterAlt(_localctx, 5);
				{
				setState(276); match(STRING_TYPE);
				((VarTypeContext)_localctx).type =  VarType.String;
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 6);
				{
				setState(278); match(ID);
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
			setState(288);
			switch (_input.LA(1)) {
			case TEXTURE_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(282); match(TEXTURE_TYPE);
				((AssetTypeContext)_localctx).type =  AssetType.Texture;
				}
				break;
			case SPRITE_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(284); match(SPRITE_TYPE);
				((AssetTypeContext)_localctx).type =  AssetType.Sprite;
				}
				break;
			case ATLAS_TYPE:
				enterOuterAlt(_localctx, 3);
				{
				setState(286); match(ATLAS_TYPE);
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
			setState(290); match(ASSETS);
			setState(291); match(ABRE_COR);
			setState(292); assetValue();
			setState(297);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(293); match(COMA);
					setState(294); assetValue();
					}
					} 
				}
				setState(299);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			setState(301);
			_la = _input.LA(1);
			if (_la==COMA) {
				{
				setState(300); match(COMA);
				}
			}

			setState(303); match(CIERRA_COR);
			}
		}
		catch (RecognitionException re) {
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
			setState(305); assetType();
			setState(307);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(306); ((AssetValueContext)_localctx).assetName = match(ID);
				}
			}

			setState(309); match(DOUBLEDOT);
			setState(310); ((AssetValueContext)_localctx).asset = match(STRING_LITERAL);
			setState(312);
			_la = _input.LA(1);
			if (_la==ABRE_COR) {
				{
				setState(311); assetValuesInner();
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
			setState(314); match(ABRE_COR);
			setState(315); assetValueInner();
			setState(320);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(316); match(COMA);
					setState(317); assetValueInner();
					}
					} 
				}
				setState(322);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			setState(324);
			_la = _input.LA(1);
			if (_la==COMA) {
				{
				setState(323); match(COMA);
				}
			}

			setState(326); match(CIERRA_COR);
			}
		}
		catch (RecognitionException re) {
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
			setState(328); assetType();
			setState(330);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(329); ((AssetValueInnerContext)_localctx).assetName = match(ID);
				}
			}

			setState(332); match(DOUBLEDOT);
			setState(333); ((AssetValueInnerContext)_localctx).asset = match(STRING_LITERAL);
			}
		}
		catch (RecognitionException re) {
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
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
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
	public static class NumericExprContext extends ExprContext {
		public NExprContext nExpr() {
			return getRuleContext(NExprContext.class,0);
		}
		public NumericExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitNumericExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicalExprContext extends ExprContext {
		public LExprContext lExpr() {
			return getRuleContext(LExprContext.class,0);
		}
		public LogicalExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitLogicalExpr(this);
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

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_expr);
		try {
			setState(346);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				_localctx = new LogicalExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(335); lExpr();
				}
				break;

			case 2:
				_localctx = new NumericExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(336); nExpr(0);
				}
				break;

			case 3:
				_localctx = new FunctionCallExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(337); ((FunctionCallExprContext)_localctx).functionName = match(ID);
				setState(338); match(ABRE_PAR);
				setState(339); exprList();
				setState(340); match(CIERRA_PAR);
				}
				break;

			case 4:
				_localctx = new ArrayExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(342); array();
				}
				break;

			case 5:
				_localctx = new StringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(343); match(STRING_LITERAL);
				}
				break;

			case 6:
				_localctx = new DirectCodeContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(344); match(DIRECTCODE);
				}
				break;

			case 7:
				_localctx = new VarExprContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(345); accessVarOp(0);
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

	public static class LExprContext extends ParserRuleContext {
		public LExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lExpr; }
	 
		public LExprContext() { }
		public void copyFrom(LExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarLExprContext extends LExprContext {
		public AccessVarOpContext accessVarOp() {
			return getRuleContext(AccessVarOpContext.class,0);
		}
		public VarLExprContext(LExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitVarLExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolLiteralContext extends LExprContext {
		public TerminalNode BOOL_LITERAL() { return getToken(FP4GParser.BOOL_LITERAL, 0); }
		public BoolLiteralContext(LExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitBoolLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotLExprContext extends LExprContext {
		public LExprContext op;
		public LExprContext lExpr() {
			return getRuleContext(LExprContext.class,0);
		}
		public TerminalNode NOT() { return getToken(FP4GParser.NOT, 0); }
		public NotLExprContext(LExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitNotLExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParLExprContext extends LExprContext {
		public LExprContext op;
		public LExprContext lExpr() {
			return getRuleContext(LExprContext.class,0);
		}
		public TerminalNode CIERRA_PAR() { return getToken(FP4GParser.CIERRA_PAR, 0); }
		public TerminalNode ABRE_PAR() { return getToken(FP4GParser.ABRE_PAR, 0); }
		public ParLExprContext(LExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitParLExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LExprContext lExpr() throws RecognitionException {
		LExprContext _localctx = new LExprContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_lExpr);
		try {
			setState(356);
			switch (_input.LA(1)) {
			case NOT:
				_localctx = new NotLExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(348); match(NOT);
				setState(349); ((NotLExprContext)_localctx).op = lExpr();
				}
				break;
			case ABRE_PAR:
				_localctx = new ParLExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(350); match(ABRE_PAR);
				setState(351); ((ParLExprContext)_localctx).op = lExpr();
				setState(352); match(CIERRA_PAR);
				}
				break;
			case BOOL_LITERAL:
				_localctx = new BoolLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(354); match(BOOL_LITERAL);
				}
				break;
			case ID:
				_localctx = new VarLExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(355); accessVarOp(0);
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

	public static class NExprContext extends ParserRuleContext {
		public int _p;
		public NExprContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public NExprContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_nExpr; }
	 
		public NExprContext() { }
		public void copyFrom(NExprContext ctx) {
			super.copyFrom(ctx);
			this._p = ctx._p;
		}
	}
	public static class MinusNExprContext extends NExprContext {
		public NExprContext op;
		public NExprContext nExpr() {
			return getRuleContext(NExprContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(FP4GParser.MINUS, 0); }
		public MinusNExprContext(NExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitMinusNExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DivNExprContext extends NExprContext {
		public NExprContext left;
		public NExprContext right;
		public NExprContext nExpr(int i) {
			return getRuleContext(NExprContext.class,i);
		}
		public List<NExprContext> nExpr() {
			return getRuleContexts(NExprContext.class);
		}
		public TerminalNode DIVIDE() { return getToken(FP4GParser.DIVIDE, 0); }
		public DivNExprContext(NExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitDivNExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarNExprContext extends NExprContext {
		public AccessVarOpContext accessVarOp() {
			return getRuleContext(AccessVarOpContext.class,0);
		}
		public VarNExprContext(NExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitVarNExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParNExprContext extends NExprContext {
		public NExprContext op;
		public NExprContext nExpr() {
			return getRuleContext(NExprContext.class,0);
		}
		public TerminalNode CIERRA_PAR() { return getToken(FP4GParser.CIERRA_PAR, 0); }
		public TerminalNode ABRE_PAR() { return getToken(FP4GParser.ABRE_PAR, 0); }
		public ParNExprContext(NExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitParNExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntLiteralContext extends NExprContext {
		public TerminalNode INT_LITERAL() { return getToken(FP4GParser.INT_LITERAL, 0); }
		public IntLiteralContext(NExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitIntLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultNExprContext extends NExprContext {
		public NExprContext left;
		public NExprContext right;
		public NExprContext nExpr(int i) {
			return getRuleContext(NExprContext.class,i);
		}
		public List<NExprContext> nExpr() {
			return getRuleContexts(NExprContext.class);
		}
		public TerminalNode MULTIPLY() { return getToken(FP4GParser.MULTIPLY, 0); }
		public MultNExprContext(NExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitMultNExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DecimalLiteralContext extends NExprContext {
		public TerminalNode DECIMAL_LITERAL() { return getToken(FP4GParser.DECIMAL_LITERAL, 0); }
		public DecimalLiteralContext(NExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitDecimalLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddNExprContext extends NExprContext {
		public NExprContext left;
		public NExprContext right;
		public NExprContext nExpr(int i) {
			return getRuleContext(NExprContext.class,i);
		}
		public List<NExprContext> nExpr() {
			return getRuleContexts(NExprContext.class);
		}
		public TerminalNode PLUS() { return getToken(FP4GParser.PLUS, 0); }
		public AddNExprContext(NExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitAddNExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubNExprContext extends NExprContext {
		public NExprContext left;
		public NExprContext right;
		public NExprContext nExpr(int i) {
			return getRuleContext(NExprContext.class,i);
		}
		public List<NExprContext> nExpr() {
			return getRuleContexts(NExprContext.class);
		}
		public TerminalNode MINUS() { return getToken(FP4GParser.MINUS, 0); }
		public SubNExprContext(NExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitSubNExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NExprContext nExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		NExprContext _localctx = new NExprContext(_ctx, _parentState, _p);
		NExprContext _prevctx = _localctx;
		int _startState = 58;
		enterRecursionRule(_localctx, RULE_nExpr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(368);
			switch (_input.LA(1)) {
			case MINUS:
				{
				_localctx = new MinusNExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(359); match(MINUS);
				setState(360); ((MinusNExprContext)_localctx).op = nExpr(9);
				}
				break;
			case ABRE_PAR:
				{
				_localctx = new ParNExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(361); match(ABRE_PAR);
				setState(362); ((ParNExprContext)_localctx).op = nExpr(0);
				setState(363); match(CIERRA_PAR);
				}
				break;
			case INT_LITERAL:
				{
				_localctx = new IntLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(365); match(INT_LITERAL);
				}
				break;
			case DECIMAL_LITERAL:
				{
				_localctx = new DecimalLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(366); match(DECIMAL_LITERAL);
				}
				break;
			case ID:
				{
				_localctx = new VarNExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(367); accessVarOp(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(384);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(382);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						_localctx = new MultNExprContext(new NExprContext(_parentctx, _parentState, _p));
						((MultNExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_nExpr);
						setState(370);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(371); match(MULTIPLY);
						setState(372); ((MultNExprContext)_localctx).right = nExpr(8);
						}
						break;

					case 2:
						{
						_localctx = new DivNExprContext(new NExprContext(_parentctx, _parentState, _p));
						((DivNExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_nExpr);
						setState(373);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(374); match(DIVIDE);
						setState(375); ((DivNExprContext)_localctx).right = nExpr(7);
						}
						break;

					case 3:
						{
						_localctx = new AddNExprContext(new NExprContext(_parentctx, _parentState, _p));
						((AddNExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_nExpr);
						setState(376);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(377); match(PLUS);
						setState(378); ((AddNExprContext)_localctx).right = nExpr(6);
						}
						break;

					case 4:
						{
						_localctx = new SubNExprContext(new NExprContext(_parentctx, _parentState, _p));
						((SubNExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_nExpr);
						setState(379);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(380); match(MINUS);
						setState(381); ((SubNExprContext)_localctx).right = nExpr(5);
						}
						break;
					}
					} 
				}
				setState(386);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
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
		public int _p;
		public AccessVarOpContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public AccessVarOpContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_accessVarOp; }
	 
		public AccessVarOpContext() { }
		public void copyFrom(AccessVarOpContext ctx) {
			super.copyFrom(ctx);
			this._p = ctx._p;
		}
	}
	public static class AccessVarOperatorContext extends AccessVarOpContext {
		public TerminalNode DOT() { return getToken(FP4GParser.DOT, 0); }
		public AccessVarOpContext accessVarOp() {
			return getRuleContext(AccessVarOpContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public AccessVarOperatorContext(AccessVarOpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitAccessVarOperator(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AccessVarContext extends AccessVarOpContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public AccessVarContext(AccessVarOpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitAccessVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccessVarOpContext accessVarOp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AccessVarOpContext _localctx = new AccessVarOpContext(_ctx, _parentState, _p);
		AccessVarOpContext _prevctx = _localctx;
		int _startState = 60;
		enterRecursionRule(_localctx, RULE_accessVarOp);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new AccessVarContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(388); variable();
			}
			_ctx.stop = _input.LT(-1);
			setState(395);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AccessVarOperatorContext(new AccessVarOpContext(_parentctx, _parentState, _p));
					pushNewRecursionContext(_localctx, _startState, RULE_accessVarOp);
					setState(390);
					if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
					setState(391); match(DOT);
					setState(392); variable();
					}
					} 
				}
				setState(397);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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

	public static class VariableContext extends ParserRuleContext {
		public Token var;
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(398); ((VariableContext)_localctx).var = match(ID);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 64, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(400); match(ABRE_LLAV);
			setState(401); parArray();
			setState(406);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(402); match(COMA);
				setState(403); parArray();
				}
				}
				setState(408);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(409); match(CIERRA_LLAV);
			setState(413);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(410); match(AS);
				setState(411); ((ArrayContext)_localctx).ID = match(ID);
				((ArrayContext)_localctx).bean =  (((ArrayContext)_localctx).ID!=null?((ArrayContext)_localctx).ID.getText():null);
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
			setState(415); ((ParArrayContext)_localctx).ID = match(ID);
			 ((ParArrayContext)_localctx).key =  (((ParArrayContext)_localctx).ID!=null?((ParArrayContext)_localctx).ID.getText():null); 
			setState(417); match(EQUAL);
			setState(418); expr();
			}
		}
		catch (RecognitionException re) {
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
		case 29: return nExpr_sempred((NExprContext)_localctx, predIndex);

		case 30: return accessVarOp_sempred((AccessVarOpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean accessVarOp_sempred(AccessVarOpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4: return 2 >= _localctx._p;
		}
		return true;
	}
	private boolean nExpr_sempred(NExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 7 >= _localctx._p;

		case 1: return 6 >= _localctx._p;

		case 2: return 5 >= _localctx._p;

		case 3: return 4 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3@\u01a7\4\2\t\2\4"+
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
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00a8\n\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\5\f\u00b0\n\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\5\r\u00bb\n"+
		"\r\3\r\3\r\3\r\3\r\7\r\u00c1\n\r\f\r\16\r\u00c4\13\r\3\r\3\r\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00d1\n\17\3\17\3\17\3\17\5\17"+
		"\u00d6\n\17\3\20\3\20\3\20\3\20\3\20\7\20\u00dd\n\20\f\20\16\20\u00e0"+
		"\13\20\3\21\3\21\3\21\3\21\3\21\7\21\u00e7\n\21\f\21\16\21\u00ea\13\21"+
		"\3\22\7\22\u00ed\n\22\f\22\16\22\u00f0\13\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\5\23\u00fa\n\23\3\24\3\24\3\24\7\24\u00ff\n\24\f\24\16"+
		"\24\u0102\13\24\3\25\3\25\3\25\7\25\u0107\n\25\f\25\16\25\u010a\13\25"+
		"\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\5\27\u011b\n\27\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0123\n\30\3"+
		"\31\3\31\3\31\3\31\3\31\7\31\u012a\n\31\f\31\16\31\u012d\13\31\3\31\5"+
		"\31\u0130\n\31\3\31\3\31\3\32\3\32\5\32\u0136\n\32\3\32\3\32\3\32\5\32"+
		"\u013b\n\32\3\33\3\33\3\33\3\33\7\33\u0141\n\33\f\33\16\33\u0144\13\33"+
		"\3\33\5\33\u0147\n\33\3\33\3\33\3\34\3\34\5\34\u014d\n\34\3\34\3\34\3"+
		"\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u015d"+
		"\n\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u0167\n\36\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u0173\n\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\7\37\u0181\n\37\f\37\16"+
		"\37\u0184\13\37\3 \3 \3 \3 \3 \3 \7 \u018c\n \f \16 \u018f\13 \3!\3!\3"+
		"\"\3\"\3\"\3\"\7\"\u0197\n\"\f\"\16\"\u019a\13\"\3\"\3\"\3\"\3\"\5\"\u01a0"+
		"\n\"\3#\3#\3#\3#\3#\3#\2$\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&"+
		"(*,.\60\62\64\668:<>@BD\2\3\4\2\23\23\25\31\u01c4\2F\3\2\2\2\4M\3\2\2"+
		"\2\6P\3\2\2\2\bU\3\2\2\2\n]\3\2\2\2\ff\3\2\2\2\16t\3\2\2\2\20v\3\2\2\2"+
		"\22|\3\2\2\2\24\u0083\3\2\2\2\26\u009a\3\2\2\2\30\u00b5\3\2\2\2\32\u00c7"+
		"\3\2\2\2\34\u00c9\3\2\2\2\36\u00d7\3\2\2\2 \u00e1\3\2\2\2\"\u00ee\3\2"+
		"\2\2$\u00f9\3\2\2\2&\u00fb\3\2\2\2(\u0103\3\2\2\2*\u010b\3\2\2\2,\u011a"+
		"\3\2\2\2.\u0122\3\2\2\2\60\u0124\3\2\2\2\62\u0133\3\2\2\2\64\u013c\3\2"+
		"\2\2\66\u014a\3\2\2\28\u015c\3\2\2\2:\u0166\3\2\2\2<\u0172\3\2\2\2>\u0185"+
		"\3\2\2\2@\u0190\3\2\2\2B\u0192\3\2\2\2D\u01a1\3\2\2\2FG\5\4\3\2GH\5\b"+
		"\5\2HI\7\2\2\3I\3\3\2\2\2JL\5\6\4\2KJ\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3"+
		"\2\2\2N\5\3\2\2\2OM\3\2\2\2PQ\7\16\2\2QR\t\2\2\2RS\7>\2\2ST\7\'\2\2T\7"+
		"\3\2\2\2UV\7\5\2\2VW\7\24\2\2WX\7>\2\2XY\b\5\1\2YZ\7\36\2\2Z[\5\f\7\2"+
		"[\\\7!\2\2\\\t\3\2\2\2]^\7\5\2\2^_\7\24\2\2_`\7\36\2\2`a\5\f\7\2ab\7!"+
		"\2\2b\13\3\2\2\2ce\5\16\b\2dc\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2g\r"+
		"\3\2\2\2hf\3\2\2\2iu\5\26\f\2jk\5\24\13\2kl\7\'\2\2lu\3\2\2\2mn\5\20\t"+
		"\2no\7\'\2\2ou\3\2\2\2pq\5\22\n\2qr\7\'\2\2ru\3\2\2\2su\5\30\r\2ti\3\2"+
		"\2\2tj\3\2\2\2tm\3\2\2\2tp\3\2\2\2ts\3\2\2\2u\17\3\2\2\2vw\7\20\2\2wx"+
		"\7>\2\2xy\b\t\1\2yz\7%\2\2z{\58\35\2{\21\3\2\2\2|}\7\21\2\2}~\7>\2\2~"+
		"\177\b\n\1\2\177\23\3\2\2\2\u0080\u0081\7>\2\2\u0081\u0082\7%\2\2\u0082"+
		"\u0084\b\13\1\2\u0083\u0080\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\3"+
		"\2\2\2\u0085\u0090\7\6\2\2\u0086\u0087\7\23\2\2\u0087\u0091\b\13\1\2\u0088"+
		"\u0089\7\25\2\2\u0089\u0091\b\13\1\2\u008a\u008b\7\26\2\2\u008b\u0091"+
		"\b\13\1\2\u008c\u008d\7\27\2\2\u008d\u0091\b\13\1\2\u008e\u008f\7\30\2"+
		"\2\u008f\u0091\b\13\1\2\u0090\u0086\3\2\2\2\u0090\u0088\3\2\2\2\u0090"+
		"\u008a\3\2\2\2\u0090\u008c\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0092\3\2"+
		"\2\2\u0092\u0093\7>\2\2\u0093\u0098\b\13\1\2\u0094\u0095\7\37\2\2\u0095"+
		"\u0096\5&\24\2\u0096\u0097\7\"\2\2\u0097\u0099\3\2\2\2\u0098\u0094\3\2"+
		"\2\2\u0098\u0099\3\2\2\2\u0099\25\3\2\2\2\u009a\u00a7\7\5\2\2\u009b\u009c"+
		"\7\23\2\2\u009c\u00a8\b\f\1\2\u009d\u009e\7\25\2\2\u009e\u00a8\b\f\1\2"+
		"\u009f\u00a0\7\26\2\2\u00a0\u00a8\b\f\1\2\u00a1\u00a2\7\27\2\2\u00a2\u00a8"+
		"\b\f\1\2\u00a3\u00a4\7\30\2\2\u00a4\u00a8\b\f\1\2\u00a5\u00a6\7\31\2\2"+
		"\u00a6\u00a8\b\f\1\2\u00a7\u009b\3\2\2\2\u00a7\u009d\3\2\2\2\u00a7\u009f"+
		"\3\2\2\2\u00a7\u00a1\3\2\2\2\u00a7\u00a3\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8"+
		"\u00a9\3\2\2\2\u00a9\u00aa\7>\2\2\u00aa\u00af\b\f\1\2\u00ab\u00ac\7\37"+
		"\2\2\u00ac\u00ad\5(\25\2\u00ad\u00ae\7\"\2\2\u00ae\u00b0\3\2\2\2\u00af"+
		"\u00ab\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\7\36"+
		"\2\2\u00b2\u00b3\5\"\22\2\u00b3\u00b4\7!\2\2\u00b4\27\3\2\2\2\u00b5\u00b6"+
		"\7\7\2\2\u00b6\u00b7\7>\2\2\u00b7\u00ba\b\r\1\2\u00b8\u00b9\7(\2\2\u00b9"+
		"\u00bb\5\36\20\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\3"+
		"\2\2\2\u00bc\u00c2\7\36\2\2\u00bd\u00be\5\32\16\2\u00be\u00bf\7\'\2\2"+
		"\u00bf\u00c1\3\2\2\2\u00c0\u00bd\3\2\2\2\u00c1\u00c4\3\2\2\2\u00c2\u00c0"+
		"\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c5\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c5"+
		"\u00c6\7!\2\2\u00c6\31\3\2\2\2\u00c7\u00c8\5\34\17\2\u00c8\33\3\2\2\2"+
		"\u00c9\u00ca\7\b\2\2\u00ca\u00cb\7>\2\2\u00cb\u00d0\b\17\1\2\u00cc\u00cd"+
		"\7\37\2\2\u00cd\u00ce\5&\24\2\u00ce\u00cf\7\"\2\2\u00cf\u00d1\3\2\2\2"+
		"\u00d0\u00cc\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d5\3\2\2\2\u00d2\u00d3"+
		"\7\33\2\2\u00d3\u00d4\7>\2\2\u00d4\u00d6\b\17\1\2\u00d5\u00d2\3\2\2\2"+
		"\u00d5\u00d6\3\2\2\2\u00d6\35\3\2\2\2\u00d7\u00d8\5 \21\2\u00d8\u00de"+
		"\b\20\1\2\u00d9\u00da\5 \21\2\u00da\u00db\b\20\1\2\u00db\u00dd\3\2\2\2"+
		"\u00dc\u00d9\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df"+
		"\3\2\2\2\u00df\37\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e2\7>\2\2\u00e2"+
		"\u00e8\b\21\1\2\u00e3\u00e4\7$\2\2\u00e4\u00e5\7>\2\2\u00e5\u00e7\b\21"+
		"\1\2\u00e6\u00e3\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8"+
		"\u00e9\3\2\2\2\u00e9!\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb\u00ed\5$\23\2"+
		"\u00ec\u00eb\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef"+
		"\3\2\2\2\u00ef#\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00f2\5\24\13\2\u00f2"+
		"\u00f3\7\'\2\2\u00f3\u00fa\3\2\2\2\u00f4\u00f5\5\20\t\2\u00f5\u00f6\7"+
		"\'\2\2\u00f6\u00fa\3\2\2\2\u00f7\u00fa\5\30\r\2\u00f8\u00fa\5\60\31\2"+
		"\u00f9\u00f1\3\2\2\2\u00f9\u00f4\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00f8"+
		"\3\2\2\2\u00fa%\3\2\2\2\u00fb\u0100\58\35\2\u00fc\u00fd\7$\2\2\u00fd\u00ff"+
		"\58\35\2\u00fe\u00fc\3\2\2\2\u00ff\u0102\3\2\2\2\u0100\u00fe\3\2\2\2\u0100"+
		"\u0101\3\2\2\2\u0101\'\3\2\2\2\u0102\u0100\3\2\2\2\u0103\u0108\5*\26\2"+
		"\u0104\u0105\7$\2\2\u0105\u0107\5*\26\2\u0106\u0104\3\2\2\2\u0107\u010a"+
		"\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109)\3\2\2\2\u010a"+
		"\u0108\3\2\2\2\u010b\u010c\5,\27\2\u010c\u010d\7>\2\2\u010d+\3\2\2\2\u010e"+
		"\u010f\7\61\2\2\u010f\u011b\b\27\1\2\u0110\u0111\7\62\2\2\u0111\u011b"+
		"\b\27\1\2\u0112\u0113\7\64\2\2\u0113\u011b\b\27\1\2\u0114\u0115\7\65\2"+
		"\2\u0115\u011b\b\27\1\2\u0116\u0117\7\63\2\2\u0117\u011b\b\27\1\2\u0118"+
		"\u0119\7>\2\2\u0119\u011b\b\27\1\2\u011a\u010e\3\2\2\2\u011a\u0110\3\2"+
		"\2\2\u011a\u0112\3\2\2\2\u011a\u0114\3\2\2\2\u011a\u0116\3\2\2\2\u011a"+
		"\u0118\3\2\2\2\u011b-\3\2\2\2\u011c\u011d\7\66\2\2\u011d\u0123\b\30\1"+
		"\2\u011e\u011f\7\67\2\2\u011f\u0123\b\30\1\2\u0120\u0121\78\2\2\u0121"+
		"\u0123\b\30\1\2\u0122\u011c\3\2\2\2\u0122\u011e\3\2\2\2\u0122\u0120\3"+
		"\2\2\2\u0123/\3\2\2\2\u0124\u0125\7\22\2\2\u0125\u0126\7\36\2\2\u0126"+
		"\u012b\5\62\32\2\u0127\u0128\7$\2\2\u0128\u012a\5\62\32\2\u0129\u0127"+
		"\3\2\2\2\u012a\u012d\3\2\2\2\u012b\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c"+
		"\u012f\3\2\2\2\u012d\u012b\3\2\2\2\u012e\u0130\7$\2\2\u012f\u012e\3\2"+
		"\2\2\u012f\u0130\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0132\7!\2\2\u0132"+
		"\61\3\2\2\2\u0133\u0135\5.\30\2\u0134\u0136\7>\2\2\u0135\u0134\3\2\2\2"+
		"\u0135\u0136\3\2\2\2\u0136\u0137\3\2\2\2\u0137\u0138\7(\2\2\u0138\u013a"+
		"\7<\2\2\u0139\u013b\5\64\33\2\u013a\u0139\3\2\2\2\u013a\u013b\3\2\2\2"+
		"\u013b\63\3\2\2\2\u013c\u013d\7\36\2\2\u013d\u0142\5\66\34\2\u013e\u013f"+
		"\7$\2\2\u013f\u0141\5\66\34\2\u0140\u013e\3\2\2\2\u0141\u0144\3\2\2\2"+
		"\u0142\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0146\3\2\2\2\u0144\u0142"+
		"\3\2\2\2\u0145\u0147\7$\2\2\u0146\u0145\3\2\2\2\u0146\u0147\3\2\2\2\u0147"+
		"\u0148\3\2\2\2\u0148\u0149\7!\2\2\u0149\65\3\2\2\2\u014a\u014c\5.\30\2"+
		"\u014b\u014d\7>\2\2\u014c\u014b\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014e"+
		"\3\2\2\2\u014e\u014f\7(\2\2\u014f\u0150\7<\2\2\u0150\67\3\2\2\2\u0151"+
		"\u015d\5:\36\2\u0152\u015d\5<\37\2\u0153\u0154\7>\2\2\u0154\u0155\7\37"+
		"\2\2\u0155\u0156\5&\24\2\u0156\u0157\7\"\2\2\u0157\u015d\3\2\2\2\u0158"+
		"\u015d\5B\"\2\u0159\u015d\7<\2\2\u015a\u015d\79\2\2\u015b\u015d\5> \2"+
		"\u015c\u0151\3\2\2\2\u015c\u0152\3\2\2\2\u015c\u0153\3\2\2\2\u015c\u0158"+
		"\3\2\2\2\u015c\u0159\3\2\2\2\u015c\u015a\3\2\2\2\u015c\u015b\3\2\2\2\u015d"+
		"9\3\2\2\2\u015e\u015f\7\60\2\2\u015f\u0167\5:\36\2\u0160\u0161\7\37\2"+
		"\2\u0161\u0162\5:\36\2\u0162\u0163\7\"\2\2\u0163\u0167\3\2\2\2\u0164\u0167"+
		"\7=\2\2\u0165\u0167\5> \2\u0166\u015e\3\2\2\2\u0166\u0160\3\2\2\2\u0166"+
		"\u0164\3\2\2\2\u0166\u0165\3\2\2\2\u0167;\3\2\2\2\u0168\u0169\b\37\1\2"+
		"\u0169\u016a\7*\2\2\u016a\u0173\5<\37\2\u016b\u016c\7\37\2\2\u016c\u016d"+
		"\5<\37\2\u016d\u016e\7\"\2\2\u016e\u0173\3\2\2\2\u016f\u0173\7:\2\2\u0170"+
		"\u0173\7;\2\2\u0171\u0173\5> \2\u0172\u0168\3\2\2\2\u0172\u016b\3\2\2"+
		"\2\u0172\u016f\3\2\2\2\u0172\u0170\3\2\2\2\u0172\u0171\3\2\2\2\u0173\u0182"+
		"\3\2\2\2\u0174\u0175\6\37\2\3\u0175\u0176\7+\2\2\u0176\u0181\5<\37\2\u0177"+
		"\u0178\6\37\3\3\u0178\u0179\7,\2\2\u0179\u0181\5<\37\2\u017a\u017b\6\37"+
		"\4\3\u017b\u017c\7)\2\2\u017c\u0181\5<\37\2\u017d\u017e\6\37\5\3\u017e"+
		"\u017f\7*\2\2\u017f\u0181\5<\37\2\u0180\u0174\3\2\2\2\u0180\u0177\3\2"+
		"\2\2\u0180\u017a\3\2\2\2\u0180\u017d\3\2\2\2\u0181\u0184\3\2\2\2\u0182"+
		"\u0180\3\2\2\2\u0182\u0183\3\2\2\2\u0183=\3\2\2\2\u0184\u0182\3\2\2\2"+
		"\u0185\u0186\b \1\2\u0186\u0187\5@!\2\u0187\u018d\3\2\2\2\u0188\u0189"+
		"\6 \6\3\u0189\u018a\7&\2\2\u018a\u018c\5@!\2\u018b\u0188\3\2\2\2\u018c"+
		"\u018f\3\2\2\2\u018d\u018b\3\2\2\2\u018d\u018e\3\2\2\2\u018e?\3\2\2\2"+
		"\u018f\u018d\3\2\2\2\u0190\u0191\7>\2\2\u0191A\3\2\2\2\u0192\u0193\7 "+
		"\2\2\u0193\u0198\5D#\2\u0194\u0195\7$\2\2\u0195\u0197\5D#\2\u0196\u0194"+
		"\3\2\2\2\u0197\u019a\3\2\2\2\u0198\u0196\3\2\2\2\u0198\u0199\3\2\2\2\u0199"+
		"\u019b\3\2\2\2\u019a\u0198\3\2\2\2\u019b\u019f\7#\2\2\u019c\u019d\7\35"+
		"\2\2\u019d\u019e\7>\2\2\u019e\u01a0\b\"\1\2\u019f\u019c\3\2\2\2\u019f"+
		"\u01a0\3\2\2\2\u01a0C\3\2\2\2\u01a1\u01a2\7>\2\2\u01a2\u01a3\b#\1\2\u01a3"+
		"\u01a4\7%\2\2\u01a4\u01a5\58\35\2\u01a5E\3\2\2\2%Mft\u0083\u0090\u0098"+
		"\u00a7\u00af\u00ba\u00c2\u00d0\u00d5\u00de\u00e8\u00ee\u00f9\u0100\u0108"+
		"\u011a\u0122\u012b\u012f\u0135\u013a\u0142\u0146\u014c\u015c\u0166\u0172"+
		"\u0180\u0182\u018d\u0198\u019f";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}