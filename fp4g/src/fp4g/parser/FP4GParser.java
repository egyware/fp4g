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
		RULE_gameValue = 5, RULE_add = 6, RULE_define = 7, RULE_defineValues = 8, 
		RULE_defineValue = 9, RULE_exprList = 10, RULE_nameList = 11, RULE_expr = 12, 
		RULE_declareVar = 13, RULE_varType = 14;
	public static final String[] ruleNames = {
		"program", "usings", "using", "game", "gameValues", "gameValue", "add", 
		"define", "defineValues", "defineValue", "exprList", "nameList", "expr", 
		"declareVar", "varType"
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
			setState(30); usings();
			setState(31); game();
			setState(32); match(EOF);
			}
		}
		catch (RecognitionException re) {
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
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==USING) {
				{
				{
				setState(34); using();
				}
				}
				setState(39);
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
			setState(40); match(USING);
			setState(41);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MANAGER) | (1L << STATE) | (1L << BEHAVIOR) | (1L << ENTITY) | (1L << GOAL) | (1L << MESSAGE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(42); match(ID);
			setState(43); match(DOTCOMA);
			}
		}
		catch (RecognitionException re) {
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
			setState(45); match(DEFINE);
			setState(46); match(GAME);
			setState(47); ((GameContext)_localctx).ID = match(ID);
			 ((GameContext)_localctx).name =  (((GameContext)_localctx).ID!=null?((GameContext)_localctx).ID.getText():null); 
			setState(49); match(ABRE_COR);
			setState(50); gameValues();
			setState(51); match(CIERRA_COR);
			}
		}
		catch (RecognitionException re) {
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
			setState(53); gameValue();
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DEFINE) | (1L << ADD) | (1L << ID))) != 0)) {
				{
				{
				setState(54); gameValue();
				}
				}
				setState(59);
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
			setState(64);
			switch (_input.LA(1)) {
			case DEFINE:
				enterOuterAlt(_localctx, 1);
				{
				setState(60); define();
				}
				break;
			case ADD:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(61); add();
				setState(62); match(DOTCOMA);
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
			setState(69);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(66); ((AddContext)_localctx).ID = match(ID);
				setState(67); match(EQUAL);
				((AddContext)_localctx).varName =  (((AddContext)_localctx).ID!=null?((AddContext)_localctx).ID.getText():null);
				}
			}

			setState(71); match(ADD);
			setState(82);
			switch (_input.LA(1)) {
			case MANAGER:
				{
				setState(72); match(MANAGER);
				 ((AddContext)_localctx).type =  ObjectType.MANAGER;  
				}
				break;
			case STATE:
				{
				setState(74); match(STATE);
				 ((AddContext)_localctx).type =  ObjectType.STATE;    
				}
				break;
			case BEHAVIOR:
				{
				setState(76); match(BEHAVIOR);
				 ((AddContext)_localctx).type =  ObjectType.BEHAVIOR; 
				}
				break;
			case ENTITY:
				{
				setState(78); match(ENTITY);
				 ((AddContext)_localctx).type =  ObjectType.ENTITY;  
				}
				break;
			case GOAL:
				{
				setState(80); match(GOAL);
				 ((AddContext)_localctx).type =  ObjectType.GOAL;  
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(84); ((AddContext)_localctx).ID = match(ID);
			 ((AddContext)_localctx).addName =  (((AddContext)_localctx).ID!=null?((AddContext)_localctx).ID.getText():null); 
			setState(90);
			_la = _input.LA(1);
			if (_la==ABRE_PAR) {
				{
				setState(86); match(ABRE_PAR);
				setState(87); exprList();
				setState(88); match(CIERRA_PAR);
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
			setState(92); match(DEFINE);
			setState(105);
			switch (_input.LA(1)) {
			case MANAGER:
				{
				setState(93); match(MANAGER);
				 ((DefineContext)_localctx).type =  ObjectType.MANAGER; 
				}
				break;
			case STATE:
				{
				setState(95); match(STATE);
				 ((DefineContext)_localctx).type =  ObjectType.STATE;   
				}
				break;
			case BEHAVIOR:
				{
				setState(97); match(BEHAVIOR);
				 ((DefineContext)_localctx).type =  ObjectType.BEHAVIOR;
				}
				break;
			case ENTITY:
				{
				setState(99); match(ENTITY);
				 ((DefineContext)_localctx).type =  ObjectType.ENTITY;  
				}
				break;
			case GOAL:
				{
				setState(101); match(GOAL);
				 ((DefineContext)_localctx).type =  ObjectType.GOAL;    
				}
				break;
			case MESSAGE:
				{
				setState(103); match(MESSAGE);
				 ((DefineContext)_localctx).type =  ObjectType.MESSAGE; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(107); ((DefineContext)_localctx).ID = match(ID);
			 ((DefineContext)_localctx).defName =  (((DefineContext)_localctx).ID!=null?((DefineContext)_localctx).ID.getText():null); 
			setState(113);
			_la = _input.LA(1);
			if (_la==ABRE_PAR) {
				{
				setState(109); match(ABRE_PAR);
				setState(110); nameList();
				setState(111); match(CIERRA_PAR);
				}
			}

			setState(115); match(ABRE_COR);
			setState(116); defineValues();
			setState(117); match(CIERRA_COR);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 16, RULE_defineValues);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119); defineValue();
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD || _la==ID) {
				{
				{
				setState(120); defineValue();
				}
				}
				setState(125);
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
		enterRule(_localctx, 18, RULE_defineValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126); add();
			setState(127); match(DOTCOMA);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 20, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129); expr(0);
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(130); match(COMA);
				setState(131); expr(0);
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
		enterRule(_localctx, 22, RULE_nameList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137); declareVar();
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(138); match(COMA);
				setState(139); declareVar();
				}
				}
				setState(144);
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
		int _startState = 24;
		enterRecursionRule(_localctx, RULE_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			switch (_input.LA(1)) {
			case NOT:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(146); match(NOT);
				setState(147); ((NotExprContext)_localctx).op = expr(11);
				}
				break;
			case MINUS:
				{
				_localctx = new MinusExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(148); match(MINUS);
				setState(149); ((MinusExprContext)_localctx).op = expr(10);
				}
				break;
			case ABRE_PAR:
				{
				_localctx = new ParExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(150); match(ABRE_PAR);
				setState(151); ((ParExprContext)_localctx).op = expr(0);
				setState(152); match(CIERRA_PAR);
				}
				break;
			case INT_LITERAL:
				{
				_localctx = new IntLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(154); match(INT_LITERAL);
				}
				break;
			case DECIMAL_LITERAL:
				{
				_localctx = new DecimalLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(155); match(DECIMAL_LITERAL);
				}
				break;
			case STRING_LITERAL:
				{
				_localctx = new StringLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(156); match(STRING_LITERAL);
				}
				break;
			case ID:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(157); match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(174);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(172);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new MultExprContext(new ExprContext(_parentctx, _parentState, _p));
						((MultExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(160);
						if (!(9 >= _localctx._p)) throw new FailedPredicateException(this, "9 >= $_p");
						setState(161); match(MULTIPLY);
						setState(162); ((MultExprContext)_localctx).right = expr(10);
						}
						break;

					case 2:
						{
						_localctx = new DivExprContext(new ExprContext(_parentctx, _parentState, _p));
						((DivExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(163);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(164); match(DIVIDE);
						setState(165); ((DivExprContext)_localctx).right = expr(9);
						}
						break;

					case 3:
						{
						_localctx = new AddExprContext(new ExprContext(_parentctx, _parentState, _p));
						((AddExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(166);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(167); match(PLUS);
						setState(168); ((AddExprContext)_localctx).right = expr(8);
						}
						break;

					case 4:
						{
						_localctx = new SubExprContext(new ExprContext(_parentctx, _parentState, _p));
						((SubExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(169);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(170); match(MINUS);
						setState(171); ((SubExprContext)_localctx).right = expr(7);
						}
						break;
					}
					} 
				}
				setState(176);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
		enterRule(_localctx, 26, RULE_declareVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177); varType();
			setState(178); match(ID);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 28, RULE_varType);
		try {
			setState(190);
			switch (_input.LA(1)) {
			case INT_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(180); match(INT_TYPE);
				((VarTypeContext)_localctx).type =  VarType.Integer;
				}
				break;
			case DEC_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(182); match(DEC_TYPE);
				((VarTypeContext)_localctx).type =  VarType.Decimal;
				}
				break;
			case BOOL_TYPE:
				enterOuterAlt(_localctx, 3);
				{
				setState(184); match(BOOL_TYPE);
				((VarTypeContext)_localctx).type =  VarType.Bool;
				}
				break;
			case ENTITY_TYPE:
				enterOuterAlt(_localctx, 4);
				{
				setState(186); match(ENTITY_TYPE);
				((VarTypeContext)_localctx).type =  VarType.Entity;
				}
				break;
			case 1:
				enterOuterAlt(_localctx, 5);
				{
				setState(188); match(1);
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
		case 12: return expr_sempred((ExprContext)_localctx, predIndex);
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\67\u00c3\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3"+
		"\3\7\3&\n\3\f\3\16\3)\13\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\7\6:\n\6\f\6\16\6=\13\6\3\7\3\7\3\7\3\7\5\7C\n\7\3\b"+
		"\3\b\3\b\5\bH\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bU\n\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\5\b]\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\5\tl\n\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tt\n\t\3\t\3\t\3\t"+
		"\3\t\3\n\3\n\7\n|\n\n\f\n\16\n\177\13\n\3\13\3\13\3\13\3\f\3\f\3\f\7\f"+
		"\u0087\n\f\f\f\16\f\u008a\13\f\3\r\3\r\3\r\7\r\u008f\n\r\f\r\16\r\u0092"+
		"\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\5\16\u00a1\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\7\16\u00af\n\16\f\16\16\16\u00b2\13\16\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00c1\n\20\3\20\2\21\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36\2\3\4\2\22\22\24\30\u00d3\2 \3\2\2"+
		"\2\4\'\3\2\2\2\6*\3\2\2\2\b/\3\2\2\2\n\67\3\2\2\2\fB\3\2\2\2\16G\3\2\2"+
		"\2\20^\3\2\2\2\22y\3\2\2\2\24\u0080\3\2\2\2\26\u0083\3\2\2\2\30\u008b"+
		"\3\2\2\2\32\u00a0\3\2\2\2\34\u00b3\3\2\2\2\36\u00c0\3\2\2\2 !\5\4\3\2"+
		"!\"\5\b\5\2\"#\7\2\2\3#\3\3\2\2\2$&\5\6\4\2%$\3\2\2\2&)\3\2\2\2\'%\3\2"+
		"\2\2\'(\3\2\2\2(\5\3\2\2\2)\'\3\2\2\2*+\7\20\2\2+,\t\2\2\2,-\7\65\2\2"+
		"-.\7#\2\2.\7\3\2\2\2/\60\7\6\2\2\60\61\7\23\2\2\61\62\7\65\2\2\62\63\b"+
		"\5\1\2\63\64\7\34\2\2\64\65\5\n\6\2\65\66\7\36\2\2\66\t\3\2\2\2\67;\5"+
		"\f\7\28:\5\f\7\298\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<\13\3\2\2\2="+
		";\3\2\2\2>C\5\20\t\2?@\5\16\b\2@A\7#\2\2AC\3\2\2\2B>\3\2\2\2B?\3\2\2\2"+
		"C\r\3\2\2\2DE\7\65\2\2EF\7!\2\2FH\b\b\1\2GD\3\2\2\2GH\3\2\2\2HI\3\2\2"+
		"\2IT\7\7\2\2JK\7\22\2\2KU\b\b\1\2LM\7\24\2\2MU\b\b\1\2NO\7\25\2\2OU\b"+
		"\b\1\2PQ\7\26\2\2QU\b\b\1\2RS\7\27\2\2SU\b\b\1\2TJ\3\2\2\2TL\3\2\2\2T"+
		"N\3\2\2\2TP\3\2\2\2TR\3\2\2\2UV\3\2\2\2VW\7\65\2\2W\\\b\b\1\2XY\7\35\2"+
		"\2YZ\5\26\f\2Z[\7\37\2\2[]\3\2\2\2\\X\3\2\2\2\\]\3\2\2\2]\17\3\2\2\2^"+
		"k\7\6\2\2_`\7\22\2\2`l\b\t\1\2ab\7\24\2\2bl\b\t\1\2cd\7\25\2\2dl\b\t\1"+
		"\2ef\7\26\2\2fl\b\t\1\2gh\7\27\2\2hl\b\t\1\2ij\7\30\2\2jl\b\t\1\2k_\3"+
		"\2\2\2ka\3\2\2\2kc\3\2\2\2ke\3\2\2\2kg\3\2\2\2ki\3\2\2\2lm\3\2\2\2mn\7"+
		"\65\2\2ns\b\t\1\2op\7\35\2\2pq\5\30\r\2qr\7\37\2\2rt\3\2\2\2so\3\2\2\2"+
		"st\3\2\2\2tu\3\2\2\2uv\7\34\2\2vw\5\22\n\2wx\7\36\2\2x\21\3\2\2\2y}\5"+
		"\24\13\2z|\5\24\13\2{z\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\23\3"+
		"\2\2\2\177}\3\2\2\2\u0080\u0081\5\16\b\2\u0081\u0082\7#\2\2\u0082\25\3"+
		"\2\2\2\u0083\u0088\5\32\16\2\u0084\u0085\7 \2\2\u0085\u0087\5\32\16\2"+
		"\u0086\u0084\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089"+
		"\3\2\2\2\u0089\27\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u0090\5\34\17\2\u008c"+
		"\u008d\7 \2\2\u008d\u008f\5\34\17\2\u008e\u008c\3\2\2\2\u008f\u0092\3"+
		"\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\31\3\2\2\2\u0092"+
		"\u0090\3\2\2\2\u0093\u0094\b\16\1\2\u0094\u0095\7,\2\2\u0095\u00a1\5\32"+
		"\16\2\u0096\u0097\7&\2\2\u0097\u00a1\5\32\16\2\u0098\u0099\7\35\2\2\u0099"+
		"\u009a\5\32\16\2\u009a\u009b\7\37\2\2\u009b\u00a1\3\2\2\2\u009c\u00a1"+
		"\7\61\2\2\u009d\u00a1\7\62\2\2\u009e\u00a1\7\63\2\2\u009f\u00a1\7\65\2"+
		"\2\u00a0\u0093\3\2\2\2\u00a0\u0096\3\2\2\2\u00a0\u0098\3\2\2\2\u00a0\u009c"+
		"\3\2\2\2\u00a0\u009d\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u009f\3\2\2\2\u00a1"+
		"\u00b0\3\2\2\2\u00a2\u00a3\6\16\2\3\u00a3\u00a4\7\'\2\2\u00a4\u00af\5"+
		"\32\16\2\u00a5\u00a6\6\16\3\3\u00a6\u00a7\7(\2\2\u00a7\u00af\5\32\16\2"+
		"\u00a8\u00a9\6\16\4\3\u00a9\u00aa\7%\2\2\u00aa\u00af\5\32\16\2\u00ab\u00ac"+
		"\6\16\5\3\u00ac\u00ad\7&\2\2\u00ad\u00af\5\32\16\2\u00ae\u00a2\3\2\2\2"+
		"\u00ae\u00a5\3\2\2\2\u00ae\u00a8\3\2\2\2\u00ae\u00ab\3\2\2\2\u00af\u00b2"+
		"\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\33\3\2\2\2\u00b2"+
		"\u00b0\3\2\2\2\u00b3\u00b4\5\36\20\2\u00b4\u00b5\7\65\2\2\u00b5\35\3\2"+
		"\2\2\u00b6\u00b7\7-\2\2\u00b7\u00c1\b\20\1\2\u00b8\u00b9\7.\2\2\u00b9"+
		"\u00c1\b\20\1\2\u00ba\u00bb\7/\2\2\u00bb\u00c1\b\20\1\2\u00bc\u00bd\7"+
		"\60\2\2\u00bd\u00c1\b\20\1\2\u00be\u00bf\7\3\2\2\u00bf\u00c1\b\20\1\2"+
		"\u00c0\u00b6\3\2\2\2\u00c0\u00b8\3\2\2\2\u00c0\u00ba\3\2\2\2\u00c0\u00bc"+
		"\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\37\3\2\2\2\21\';BGT\\ks}\u0088\u0090"+
		"\u00a0\u00ae\u00b0\u00c0";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}