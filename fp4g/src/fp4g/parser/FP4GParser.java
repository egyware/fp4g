// Generated from C:\Users\Edgardo\Git\fp4g-src\fp4g\src/fp4g/parser/FP4G.g by ANTLR 4.1

package fp4g.parser;

import static fp4g.Log.*;

import fp4g.data.*;
import fp4g.data.define.*;
import fp4g.data.managers.*;


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
		T__0=1, SINGLE_LINE_COMMENT=2, MULTI_LINE_COMMENT=3, DEFINE=4, ADD=5, 
		ON=6, SEND=7, GROUP=8, SUBSCRIBE=9, UNSUBSCRIBE=10, START=11, RESUME=12, 
		PAUSE=13, USING=14, EXIT=15, MANAGER=16, GAME=17, STATE=18, BEHAVIOR=19, 
		ENTITY=20, GOAL=21, MESSAGE=22, BASE=23, TO=24, SOURCE=25, ABRE_COR=26, 
		ABRE_PAR=27, CIERRA_COR=28, CIERRA_PAR=29, COMA=30, EQUAL=31, DOT=32, 
		DOTCOMA=33, DOBLEDOT=34, PLUS=35, MINUS=36, MULTIPLY=37, DIVIDE=38, AND=39, 
		OR=40, XOR=41, NOT=42, INT_TYPE=43, DEC_TYPE=44, BOOL_TYPE=45, ENTITY_TYPE=46, 
		INT_LITERAL=47, DECIMAL_LITERAL=48, STRING_LITERAL=49, BOOL_LITERAL=50, 
		ID=51, NL=52, WS=53;
	public static final String[] tokenNames = {
		"<INVALID>", "'KeyMap'", "SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT", 
		"'DEFINE'", "'ADD'", "'ON'", "'SEND'", "'GROUP'", "'SUBSCRIBE'", "'UNSUBSCRIBE'", 
		"'START'", "'RESUME'", "'PAUSE'", "'USING'", "'EXIT'", "'MANAGER'", "'GAME'", 
		"'STATE'", "'BEHAVIOR'", "'ENTITY'", "'GOAL'", "'MESSAGE'", "'BASE'", 
		"'TO'", "'SOURCE'", "'['", "'('", "']'", "')'", "','", "'='", "'.'", "';'", 
		"':'", "'+'", "'-'", "'*'", "'/'", "'AND'", "'OR'", "'XOR'", "'NOT'", 
		"'Int'", "'Dec'", "'Bool'", "'Entity'", "INT_LITERAL", "DECIMAL_LITERAL", 
		"STRING_LITERAL", "BOOL_LITERAL", "ID", "NL", "WS"
	};
	public static final int
		RULE_program = 0, RULE_usings = 1, RULE_using = 2, RULE_game = 3, RULE_gameValues = 4, 
		RULE_gameValue = 5, RULE_add = 6, RULE_define = 7, RULE_on = 8, RULE_defineValues = 9, 
		RULE_defineValue = 10, RULE_exprList = 11, RULE_nameList = 12, RULE_expr = 13, 
		RULE_declareVar = 14, RULE_varType = 15;
	public static final String[] ruleNames = {
		"program", "usings", "using", "game", "gameValues", "gameValue", "add", 
		"define", "on", "defineValues", "defineValue", "exprList", "nameList", 
		"expr", "declareVar", "varType"
	};

	@Override
	public String getGrammarFileName() { return "FP4G.g"; }

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
			setState(32); usings();
			setState(33); game();
			setState(34); match(EOF);
			}
		}
		catch (RecognitionException re) {
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
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==USING) {
				{
				{
				setState(36); using();
				}
				}
				setState(41);
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
			setState(42); match(USING);
			setState(43);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MANAGER) | (1L << STATE) | (1L << BEHAVIOR) | (1L << ENTITY) | (1L << GOAL) | (1L << MESSAGE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(44); match(ID);
			setState(45); match(DOTCOMA);
			}
		}
		catch (RecognitionException re) {
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
			setState(47); match(DEFINE);
			setState(48); match(GAME);
			setState(49); ((GameContext)_localctx).ID = match(ID);
			 ((GameContext)_localctx).name =  (((GameContext)_localctx).ID!=null?((GameContext)_localctx).ID.getText():null); 
			setState(51); match(ABRE_COR);
			setState(52); gameValues();
			setState(53); match(CIERRA_COR);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 8, RULE_gameValues);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55); gameValue();
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DEFINE) | (1L << ADD) | (1L << ON) | (1L << ID))) != 0)) {
				{
				{
				setState(56); gameValue();
				}
				}
				setState(61);
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
		enterRule(_localctx, 10, RULE_gameValue);
		try {
			setState(67);
			switch (_input.LA(1)) {
			case DEFINE:
				enterOuterAlt(_localctx, 1);
				{
				setState(62); define();
				}
				break;
			case ADD:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(63); add();
				setState(64); match(DOTCOMA);
				}
				break;
			case ON:
				enterOuterAlt(_localctx, 3);
				{
				setState(66); on();
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
		public ObjectType type = null;
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
		enterRule(_localctx, 12, RULE_add);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(69); ((AddContext)_localctx).ID = match(ID);
				setState(70); match(EQUAL);
				((AddContext)_localctx).varName =  (((AddContext)_localctx).ID!=null?((AddContext)_localctx).ID.getText():null);
				}
			}

			setState(74); match(ADD);
			setState(85);
			switch (_input.LA(1)) {
			case MANAGER:
				{
				setState(75); match(MANAGER);
				 ((AddContext)_localctx).type =  ObjectType.MANAGER;  
				}
				break;
			case STATE:
				{
				setState(77); match(STATE);
				 ((AddContext)_localctx).type =  ObjectType.STATE;    
				}
				break;
			case BEHAVIOR:
				{
				setState(79); match(BEHAVIOR);
				 ((AddContext)_localctx).type =  ObjectType.BEHAVIOR; 
				}
				break;
			case ENTITY:
				{
				setState(81); match(ENTITY);
				 ((AddContext)_localctx).type =  ObjectType.ENTITY;  
				}
				break;
			case GOAL:
				{
				setState(83); match(GOAL);
				 ((AddContext)_localctx).type =  ObjectType.GOAL;  
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(87); ((AddContext)_localctx).ID = match(ID);
			 ((AddContext)_localctx).addName =  (((AddContext)_localctx).ID!=null?((AddContext)_localctx).ID.getText():null); 
			setState(93);
			_la = _input.LA(1);
			if (_la==ABRE_PAR) {
				{
				setState(89); match(ABRE_PAR);
				setState(90); exprList();
				setState(91); match(CIERRA_PAR);
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
		public ObjectType type = null;
		public String defName = null;
		public Token ID;
		public TerminalNode GOAL() { return getToken(FP4GParser.GOAL, 0); }
		public TerminalNode ABRE_COR() { return getToken(FP4GParser.ABRE_COR, 0); }
		public TerminalNode DEFINE() { return getToken(FP4GParser.DEFINE, 0); }
		public NameListContext nameList() {
			return getRuleContext(NameListContext.class,0);
		}
		public TerminalNode STATE() { return getToken(FP4GParser.STATE, 0); }
		public TerminalNode CIERRA_COR() { return getToken(FP4GParser.CIERRA_COR, 0); }
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public TerminalNode CIERRA_PAR() { return getToken(FP4GParser.CIERRA_PAR, 0); }
		public TerminalNode BEHAVIOR() { return getToken(FP4GParser.BEHAVIOR, 0); }
		public TerminalNode MANAGER() { return getToken(FP4GParser.MANAGER, 0); }
		public TerminalNode ENTITY() { return getToken(FP4GParser.ENTITY, 0); }
		public DefineValuesContext defineValues() {
			return getRuleContext(DefineValuesContext.class,0);
		}
		public TerminalNode ABRE_PAR() { return getToken(FP4GParser.ABRE_PAR, 0); }
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
		enterRule(_localctx, 14, RULE_define);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95); match(DEFINE);
			setState(108);
			switch (_input.LA(1)) {
			case MANAGER:
				{
				setState(96); match(MANAGER);
				 ((DefineContext)_localctx).type =  ObjectType.MANAGER; 
				}
				break;
			case STATE:
				{
				setState(98); match(STATE);
				 ((DefineContext)_localctx).type =  ObjectType.STATE;   
				}
				break;
			case BEHAVIOR:
				{
				setState(100); match(BEHAVIOR);
				 ((DefineContext)_localctx).type =  ObjectType.BEHAVIOR;
				}
				break;
			case ENTITY:
				{
				setState(102); match(ENTITY);
				 ((DefineContext)_localctx).type =  ObjectType.ENTITY;  
				}
				break;
			case GOAL:
				{
				setState(104); match(GOAL);
				 ((DefineContext)_localctx).type =  ObjectType.GOAL;    
				}
				break;
			case MESSAGE:
				{
				setState(106); match(MESSAGE);
				 ((DefineContext)_localctx).type =  ObjectType.MESSAGE; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(110); ((DefineContext)_localctx).ID = match(ID);
			 ((DefineContext)_localctx).defName =  (((DefineContext)_localctx).ID!=null?((DefineContext)_localctx).ID.getText():null); 
			setState(116);
			_la = _input.LA(1);
			if (_la==ABRE_PAR) {
				{
				setState(112); match(ABRE_PAR);
				setState(113); nameList();
				setState(114); match(CIERRA_PAR);
				}
			}

			setState(118); match(ABRE_COR);
			setState(119); defineValues();
			setState(120); match(CIERRA_COR);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode ABRE_COR() { return getToken(FP4GParser.ABRE_COR, 0); }
		public TerminalNode ON() { return getToken(FP4GParser.ON, 0); }
		public TerminalNode CIERRA_COR() { return getToken(FP4GParser.CIERRA_COR, 0); }
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
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
		enterRule(_localctx, 16, RULE_on);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122); match(ON);
			setState(123); ((OnContext)_localctx).ID = match(ID);
			((OnContext)_localctx).messageName =  (((OnContext)_localctx).ID!=null?((OnContext)_localctx).ID.getText():null); 
			setState(125); match(ABRE_COR);
			setState(126); match(CIERRA_COR);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 18, RULE_defineValues);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128); defineValue();
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << ON) | (1L << ID))) != 0)) {
				{
				{
				setState(129); defineValue();
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

	public static class DefineValueContext extends ParserRuleContext {
		public OnContext on() {
			return getRuleContext(OnContext.class,0);
		}
		public AddContext add() {
			return getRuleContext(AddContext.class,0);
		}
		public TerminalNode DOTCOMA() { return getToken(FP4GParser.DOTCOMA, 0); }
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
		enterRule(_localctx, 20, RULE_defineValue);
		try {
			setState(139);
			switch (_input.LA(1)) {
			case ADD:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(135); add();
				setState(136); match(DOTCOMA);
				}
				break;
			case ON:
				enterOuterAlt(_localctx, 2);
				{
				setState(138); on();
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
		enterRule(_localctx, 22, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141); expr(0);
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(142); match(COMA);
				setState(143); expr(0);
				}
				}
				setState(148);
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
		enterRule(_localctx, 24, RULE_nameList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149); declareVar();
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(150); match(COMA);
				setState(151); declareVar();
				}
				}
				setState(156);
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
	public static class IdContext extends ExprContext {
		public TerminalNode ID() { return getToken(FP4GParser.ID, 0); }
		public IdContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FP4GVisitor ) return ((FP4GVisitor<? extends T>)visitor).visitId(this);
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
		int _startState = 26;
		enterRecursionRule(_localctx, RULE_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			switch (_input.LA(1)) {
			case NOT:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(158); match(NOT);
				setState(159); ((NotExprContext)_localctx).op = expr(11);
				}
				break;
			case MINUS:
				{
				_localctx = new MinusExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(160); match(MINUS);
				setState(161); ((MinusExprContext)_localctx).op = expr(10);
				}
				break;
			case ABRE_PAR:
				{
				_localctx = new ParExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(162); match(ABRE_PAR);
				setState(163); ((ParExprContext)_localctx).op = expr(0);
				setState(164); match(CIERRA_PAR);
				}
				break;
			case INT_LITERAL:
				{
				_localctx = new IntLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(166); match(INT_LITERAL);
				}
				break;
			case DECIMAL_LITERAL:
				{
				_localctx = new DecimalLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(167); match(DECIMAL_LITERAL);
				}
				break;
			case STRING_LITERAL:
				{
				_localctx = new StringLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(168); match(STRING_LITERAL);
				}
				break;
			case ID:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(169); match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(186);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(184);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new MultExprContext(new ExprContext(_parentctx, _parentState, _p));
						((MultExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(172);
						if (!(9 >= _localctx._p)) throw new FailedPredicateException(this, "9 >= $_p");
						setState(173); match(MULTIPLY);
						setState(174); ((MultExprContext)_localctx).right = expr(10);
						}
						break;

					case 2:
						{
						_localctx = new DivExprContext(new ExprContext(_parentctx, _parentState, _p));
						((DivExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(175);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(176); match(DIVIDE);
						setState(177); ((DivExprContext)_localctx).right = expr(9);
						}
						break;

					case 3:
						{
						_localctx = new AddExprContext(new ExprContext(_parentctx, _parentState, _p));
						((AddExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(178);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(179); match(PLUS);
						setState(180); ((AddExprContext)_localctx).right = expr(8);
						}
						break;

					case 4:
						{
						_localctx = new SubExprContext(new ExprContext(_parentctx, _parentState, _p));
						((SubExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(181);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(182); match(MINUS);
						setState(183); ((SubExprContext)_localctx).right = expr(7);
						}
						break;
					}
					} 
				}
				setState(188);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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
		enterRule(_localctx, 28, RULE_declareVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189); varType();
			setState(190); match(ID);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 30, RULE_varType);
		try {
			setState(202);
			switch (_input.LA(1)) {
			case INT_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(192); match(INT_TYPE);
				((VarTypeContext)_localctx).type =  VarType.Integer;
				}
				break;
			case DEC_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(194); match(DEC_TYPE);
				((VarTypeContext)_localctx).type =  VarType.Decimal;
				}
				break;
			case BOOL_TYPE:
				enterOuterAlt(_localctx, 3);
				{
				setState(196); match(BOOL_TYPE);
				((VarTypeContext)_localctx).type =  VarType.Bool;
				}
				break;
			case ENTITY_TYPE:
				enterOuterAlt(_localctx, 4);
				{
				setState(198); match(ENTITY_TYPE);
				((VarTypeContext)_localctx).type =  VarType.Entity;
				}
				break;
			case 1:
				enterOuterAlt(_localctx, 5);
				{
				setState(200); match(1);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 13: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 9 >= _localctx._p;

		case 1: return 8 >= _localctx._p;

		case 2: return 7 >= _localctx._p;

		case 3: return 6 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\67\u00cf\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2"+
		"\3\2\3\2\3\3\7\3(\n\3\f\3\16\3+\13\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\6\3\6\7\6<\n\6\f\6\16\6?\13\6\3\7\3\7\3\7\3\7\3\7"+
		"\5\7F\n\7\3\b\3\b\3\b\5\bK\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\5\bX\n\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b`\n\b\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\to\n\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tw\n\t"+
		"\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\7\13\u0085\n\13\f\13"+
		"\16\13\u0088\13\13\3\f\3\f\3\f\3\f\5\f\u008e\n\f\3\r\3\r\3\r\7\r\u0093"+
		"\n\r\f\r\16\r\u0096\13\r\3\16\3\16\3\16\7\16\u009b\n\16\f\16\16\16\u009e"+
		"\13\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\5\17\u00ad\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\7\17\u00bb\n\17\f\17\16\17\u00be\13\17\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00cd\n\21\3\21\2\22\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\3\4\2\22\22\24\30\u00e0\2\"\3\2"+
		"\2\2\4)\3\2\2\2\6,\3\2\2\2\b\61\3\2\2\2\n9\3\2\2\2\fE\3\2\2\2\16J\3\2"+
		"\2\2\20a\3\2\2\2\22|\3\2\2\2\24\u0082\3\2\2\2\26\u008d\3\2\2\2\30\u008f"+
		"\3\2\2\2\32\u0097\3\2\2\2\34\u00ac\3\2\2\2\36\u00bf\3\2\2\2 \u00cc\3\2"+
		"\2\2\"#\5\4\3\2#$\5\b\5\2$%\7\2\2\3%\3\3\2\2\2&(\5\6\4\2\'&\3\2\2\2(+"+
		"\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*\5\3\2\2\2+)\3\2\2\2,-\7\20\2\2-.\t\2\2"+
		"\2./\7\65\2\2/\60\7#\2\2\60\7\3\2\2\2\61\62\7\6\2\2\62\63\7\23\2\2\63"+
		"\64\7\65\2\2\64\65\b\5\1\2\65\66\7\34\2\2\66\67\5\n\6\2\678\7\36\2\28"+
		"\t\3\2\2\29=\5\f\7\2:<\5\f\7\2;:\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2"+
		">\13\3\2\2\2?=\3\2\2\2@F\5\20\t\2AB\5\16\b\2BC\7#\2\2CF\3\2\2\2DF\5\22"+
		"\n\2E@\3\2\2\2EA\3\2\2\2ED\3\2\2\2F\r\3\2\2\2GH\7\65\2\2HI\7!\2\2IK\b"+
		"\b\1\2JG\3\2\2\2JK\3\2\2\2KL\3\2\2\2LW\7\7\2\2MN\7\22\2\2NX\b\b\1\2OP"+
		"\7\24\2\2PX\b\b\1\2QR\7\25\2\2RX\b\b\1\2ST\7\26\2\2TX\b\b\1\2UV\7\27\2"+
		"\2VX\b\b\1\2WM\3\2\2\2WO\3\2\2\2WQ\3\2\2\2WS\3\2\2\2WU\3\2\2\2XY\3\2\2"+
		"\2YZ\7\65\2\2Z_\b\b\1\2[\\\7\35\2\2\\]\5\30\r\2]^\7\37\2\2^`\3\2\2\2_"+
		"[\3\2\2\2_`\3\2\2\2`\17\3\2\2\2an\7\6\2\2bc\7\22\2\2co\b\t\1\2de\7\24"+
		"\2\2eo\b\t\1\2fg\7\25\2\2go\b\t\1\2hi\7\26\2\2io\b\t\1\2jk\7\27\2\2ko"+
		"\b\t\1\2lm\7\30\2\2mo\b\t\1\2nb\3\2\2\2nd\3\2\2\2nf\3\2\2\2nh\3\2\2\2"+
		"nj\3\2\2\2nl\3\2\2\2op\3\2\2\2pq\7\65\2\2qv\b\t\1\2rs\7\35\2\2st\5\32"+
		"\16\2tu\7\37\2\2uw\3\2\2\2vr\3\2\2\2vw\3\2\2\2wx\3\2\2\2xy\7\34\2\2yz"+
		"\5\24\13\2z{\7\36\2\2{\21\3\2\2\2|}\7\b\2\2}~\7\65\2\2~\177\b\n\1\2\177"+
		"\u0080\7\34\2\2\u0080\u0081\7\36\2\2\u0081\23\3\2\2\2\u0082\u0086\5\26"+
		"\f\2\u0083\u0085\5\26\f\2\u0084\u0083\3\2\2\2\u0085\u0088\3\2\2\2\u0086"+
		"\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\25\3\2\2\2\u0088\u0086\3\2\2"+
		"\2\u0089\u008a\5\16\b\2\u008a\u008b\7#\2\2\u008b\u008e\3\2\2\2\u008c\u008e"+
		"\5\22\n\2\u008d\u0089\3\2\2\2\u008d\u008c\3\2\2\2\u008e\27\3\2\2\2\u008f"+
		"\u0094\5\34\17\2\u0090\u0091\7 \2\2\u0091\u0093\5\34\17\2\u0092\u0090"+
		"\3\2\2\2\u0093\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095"+
		"\31\3\2\2\2\u0096\u0094\3\2\2\2\u0097\u009c\5\36\20\2\u0098\u0099\7 \2"+
		"\2\u0099\u009b\5\36\20\2\u009a\u0098\3\2\2\2\u009b\u009e\3\2\2\2\u009c"+
		"\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\33\3\2\2\2\u009e\u009c\3\2\2"+
		"\2\u009f\u00a0\b\17\1\2\u00a0\u00a1\7,\2\2\u00a1\u00ad\5\34\17\2\u00a2"+
		"\u00a3\7&\2\2\u00a3\u00ad\5\34\17\2\u00a4\u00a5\7\35\2\2\u00a5\u00a6\5"+
		"\34\17\2\u00a6\u00a7\7\37\2\2\u00a7\u00ad\3\2\2\2\u00a8\u00ad\7\61\2\2"+
		"\u00a9\u00ad\7\62\2\2\u00aa\u00ad\7\63\2\2\u00ab\u00ad\7\65\2\2\u00ac"+
		"\u009f\3\2\2\2\u00ac\u00a2\3\2\2\2\u00ac\u00a4\3\2\2\2\u00ac\u00a8\3\2"+
		"\2\2\u00ac\u00a9\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ab\3\2\2\2\u00ad"+
		"\u00bc\3\2\2\2\u00ae\u00af\6\17\2\3\u00af\u00b0\7\'\2\2\u00b0\u00bb\5"+
		"\34\17\2\u00b1\u00b2\6\17\3\3\u00b2\u00b3\7(\2\2\u00b3\u00bb\5\34\17\2"+
		"\u00b4\u00b5\6\17\4\3\u00b5\u00b6\7%\2\2\u00b6\u00bb\5\34\17\2\u00b7\u00b8"+
		"\6\17\5\3\u00b8\u00b9\7&\2\2\u00b9\u00bb\5\34\17\2\u00ba\u00ae\3\2\2\2"+
		"\u00ba\u00b1\3\2\2\2\u00ba\u00b4\3\2\2\2\u00ba\u00b7\3\2\2\2\u00bb\u00be"+
		"\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\35\3\2\2\2\u00be"+
		"\u00bc\3\2\2\2\u00bf\u00c0\5 \21\2\u00c0\u00c1\7\65\2\2\u00c1\37\3\2\2"+
		"\2\u00c2\u00c3\7-\2\2\u00c3\u00cd\b\21\1\2\u00c4\u00c5\7.\2\2\u00c5\u00cd"+
		"\b\21\1\2\u00c6\u00c7\7/\2\2\u00c7\u00cd\b\21\1\2\u00c8\u00c9\7\60\2\2"+
		"\u00c9\u00cd\b\21\1\2\u00ca\u00cb\7\3\2\2\u00cb\u00cd\b\21\1\2\u00cc\u00c2"+
		"\3\2\2\2\u00cc\u00c4\3\2\2\2\u00cc\u00c6\3\2\2\2\u00cc\u00c8\3\2\2\2\u00cc"+
		"\u00ca\3\2\2\2\u00cd!\3\2\2\2\22)=EJW_nv\u0086\u008d\u0094\u009c\u00ac"+
		"\u00ba\u00bc\u00cc";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}