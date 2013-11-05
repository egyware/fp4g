// Generated from C:\Users\Edgardo\Git\fp4g-src\fp4g\src/fp4g/parser/FP4G.g4 by ANTLR 4.1

package fp4g.parser;

import static fp4g.Log.*;

import fp4g.data.*;
import fp4g.data.define.*;
import fp4g.data.managers.*;

import java.util.LinkedList;


import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FP4GLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SINGLE_LINE_COMMENT=1, MULTI_LINE_COMMENT=2, DEFINE=3, ADD=4, ON=5, SEND=6, 
		GROUP=7, SUBSCRIBE=8, UNSUBSCRIBE=9, RESUME=10, PAUSE=11, USING=12, EXIT=13, 
		SET=14, START=15, ASSET=16, MANAGER=17, GAME=18, STATE=19, BEHAVIOR=20, 
		ENTITY=21, GOAL=22, MESSAGE=23, BASE=24, TO=25, SOURCE=26, ABRE_COR=27, 
		ABRE_PAR=28, ABRE_LLAV=29, CIERRA_COR=30, CIERRA_PAR=31, CIERRA_LLAV=32, 
		COMA=33, EQUAL=34, DOT=35, DOTCOMA=36, DOUBLEDOT=37, PLUS=38, MINUS=39, 
		MULTIPLY=40, DIVIDE=41, AND=42, OR=43, XOR=44, NOT=45, INT_TYPE=46, DEC_TYPE=47, 
		STRING_TYPE=48, BOOL_TYPE=49, ENTITY_TYPE=50, TEXTURE_TYPE=51, DIRECTCODE=52, 
		INT_LITERAL=53, DECIMAL_LITERAL=54, STRING_LITERAL=55, BOOL_LITERAL=56, 
		ID=57, NL=58, WS=59;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT", "'DEFINE'", "'ADD'", "'ON'", 
		"'SEND'", "'GROUP'", "'SUBSCRIBE'", "'UNSUBSCRIBE'", "'RESUME'", "'PAUSE'", 
		"'USING'", "'EXIT'", "'SET'", "'START'", "'ASSET'", "'MANAGER'", "'GAME'", 
		"'STATE'", "'BEHAVIOR'", "'ENTITY'", "'GOAL'", "'MESSAGE'", "'BASE'", 
		"'TO'", "'SOURCE'", "'['", "'('", "'{'", "']'", "')'", "'}'", "','", "'='", 
		"'.'", "';'", "':'", "'+'", "'-'", "'*'", "'/'", "'AND'", "'OR'", "'XOR'", 
		"'NOT'", "'Int'", "'Dec'", "'String'", "'Bool'", "'Entity'", "'Texture'", 
		"DIRECTCODE", "INT_LITERAL", "DECIMAL_LITERAL", "STRING_LITERAL", "BOOL_LITERAL", 
		"ID", "NL", "WS"
	};
	public static final String[] ruleNames = {
		"SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT", "DEFINE", "ADD", "ON", "SEND", 
		"GROUP", "SUBSCRIBE", "UNSUBSCRIBE", "RESUME", "PAUSE", "USING", "EXIT", 
		"SET", "START", "ASSET", "MANAGER", "GAME", "STATE", "BEHAVIOR", "ENTITY", 
		"GOAL", "MESSAGE", "BASE", "TO", "SOURCE", "ABRE_COR", "ABRE_PAR", "ABRE_LLAV", 
		"CIERRA_COR", "CIERRA_PAR", "CIERRA_LLAV", "COMA", "EQUAL", "DOT", "DOTCOMA", 
		"DOUBLEDOT", "PLUS", "MINUS", "MULTIPLY", "DIVIDE", "AND", "OR", "XOR", 
		"NOT", "INT_TYPE", "DEC_TYPE", "STRING_TYPE", "BOOL_TYPE", "ENTITY_TYPE", 
		"TEXTURE_TYPE", "DIRECTCODE", "INT_LITERAL", "DECIMAL_LITERAL", "STRING_LITERAL", 
		"BOOL_LITERAL", "DIGIT", "ID", "NL", "WS"
	};


	public FP4GLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FP4G.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 0: SINGLE_LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 1: MULTI_LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 58: NL_action((RuleContext)_localctx, actionIndex); break;

		case 59: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3: skip();  break;
		}
	}
	private void SINGLE_LINE_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}
	private void NL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: skip();  break;
		}
	}
	private void MULTI_LINE_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2=\u01c9\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\3\2\3\2\3\2\3\2\3\2\7\2\u0081\n\2\f\2\16\2\u0084\13\2\5\2\u0086\n\2\3"+
		"\2\5\2\u0089\n\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3\u0093\n\3\f\3\16"+
		"\3\u0096\13\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3"+
		" \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3"+
		"+\3+\3+\3,\3,\3,\3-\3-\3-\3-\3.\3.\3.\3.\3/\3/\3/\3/\3\60\3\60\3\60\3"+
		"\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\63\3"+
		"\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3"+
		"\65\3\65\3\65\3\65\7\65\u0187\n\65\f\65\16\65\u018a\13\65\3\65\3\65\3"+
		"\66\6\66\u018f\n\66\r\66\16\66\u0190\3\67\7\67\u0194\n\67\f\67\16\67\u0197"+
		"\13\67\3\67\3\67\6\67\u019b\n\67\r\67\16\67\u019c\38\38\78\u01a1\n8\f"+
		"8\168\u01a4\138\38\38\39\39\39\39\39\39\39\39\39\59\u01b1\n9\3:\3:\3;"+
		"\3;\7;\u01b7\n;\f;\16;\u01ba\13;\3<\6<\u01bd\n<\r<\16<\u01be\3<\3<\3="+
		"\6=\u01c4\n=\r=\16=\u01c5\3=\3=\6\u0082\u0094\u0188\u01a2>\3\3\2\5\4\3"+
		"\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1"+
		"\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31"+
		"\1\61\32\1\63\33\1\65\34\1\67\35\19\36\1;\37\1= \1?!\1A\"\1C#\1E$\1G%"+
		"\1I&\1K\'\1M(\1O)\1Q*\1S+\1U,\1W-\1Y.\1[/\1]\60\1_\61\1a\62\1c\63\1e\64"+
		"\1g\65\1i\66\1k\67\1m8\1o9\1q:\1s\2\1u;\1w<\4y=\5\3\2\7\4\2\f\f\17\17"+
		"\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\4\2\13\13\"\"\u01d4\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2"+
		"\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2"+
		"\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K"+
		"\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2"+
		"\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2"+
		"\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q"+
		"\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\3{\3\2\2\2\5\u008e\3\2\2\2\7"+
		"\u009c\3\2\2\2\t\u00a3\3\2\2\2\13\u00a7\3\2\2\2\r\u00aa\3\2\2\2\17\u00af"+
		"\3\2\2\2\21\u00b5\3\2\2\2\23\u00bf\3\2\2\2\25\u00cb\3\2\2\2\27\u00d2\3"+
		"\2\2\2\31\u00d8\3\2\2\2\33\u00de\3\2\2\2\35\u00e3\3\2\2\2\37\u00e7\3\2"+
		"\2\2!\u00ed\3\2\2\2#\u00f3\3\2\2\2%\u00fb\3\2\2\2\'\u0100\3\2\2\2)\u0106"+
		"\3\2\2\2+\u010f\3\2\2\2-\u0116\3\2\2\2/\u011b\3\2\2\2\61\u0123\3\2\2\2"+
		"\63\u0128\3\2\2\2\65\u012b\3\2\2\2\67\u0132\3\2\2\29\u0134\3\2\2\2;\u0136"+
		"\3\2\2\2=\u0138\3\2\2\2?\u013a\3\2\2\2A\u013c\3\2\2\2C\u013e\3\2\2\2E"+
		"\u0140\3\2\2\2G\u0142\3\2\2\2I\u0144\3\2\2\2K\u0146\3\2\2\2M\u0148\3\2"+
		"\2\2O\u014a\3\2\2\2Q\u014c\3\2\2\2S\u014e\3\2\2\2U\u0150\3\2\2\2W\u0154"+
		"\3\2\2\2Y\u0157\3\2\2\2[\u015b\3\2\2\2]\u015f\3\2\2\2_\u0163\3\2\2\2a"+
		"\u0167\3\2\2\2c\u016e\3\2\2\2e\u0173\3\2\2\2g\u017a\3\2\2\2i\u0182\3\2"+
		"\2\2k\u018e\3\2\2\2m\u0195\3\2\2\2o\u019e\3\2\2\2q\u01b0\3\2\2\2s\u01b2"+
		"\3\2\2\2u\u01b4\3\2\2\2w\u01bc\3\2\2\2y\u01c3\3\2\2\2{|\7\61\2\2|}\7\61"+
		"\2\2}\u0085\3\2\2\2~\u0086\t\2\2\2\177\u0081\13\2\2\2\u0080\177\3\2\2"+
		"\2\u0081\u0084\3\2\2\2\u0082\u0083\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0086"+
		"\3\2\2\2\u0084\u0082\3\2\2\2\u0085~\3\2\2\2\u0085\u0082\3\2\2\2\u0086"+
		"\u0088\3\2\2\2\u0087\u0089\7\17\2\2\u0088\u0087\3\2\2\2\u0088\u0089\3"+
		"\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\7\f\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\u008d\b\2\2\2\u008d\4\3\2\2\2\u008e\u008f\7\61\2\2\u008f\u0090\7,\2\2"+
		"\u0090\u0094\3\2\2\2\u0091\u0093\13\2\2\2\u0092\u0091\3\2\2\2\u0093\u0096"+
		"\3\2\2\2\u0094\u0095\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u0097\3\2\2\2\u0096"+
		"\u0094\3\2\2\2\u0097\u0098\7,\2\2\u0098\u0099\7\61\2\2\u0099\u009a\3\2"+
		"\2\2\u009a\u009b\b\3\3\2\u009b\6\3\2\2\2\u009c\u009d\7F\2\2\u009d\u009e"+
		"\7G\2\2\u009e\u009f\7H\2\2\u009f\u00a0\7K\2\2\u00a0\u00a1\7P\2\2\u00a1"+
		"\u00a2\7G\2\2\u00a2\b\3\2\2\2\u00a3\u00a4\7C\2\2\u00a4\u00a5\7F\2\2\u00a5"+
		"\u00a6\7F\2\2\u00a6\n\3\2\2\2\u00a7\u00a8\7Q\2\2\u00a8\u00a9\7P\2\2\u00a9"+
		"\f\3\2\2\2\u00aa\u00ab\7U\2\2\u00ab\u00ac\7G\2\2\u00ac\u00ad\7P\2\2\u00ad"+
		"\u00ae\7F\2\2\u00ae\16\3\2\2\2\u00af\u00b0\7I\2\2\u00b0\u00b1\7T\2\2\u00b1"+
		"\u00b2\7Q\2\2\u00b2\u00b3\7W\2\2\u00b3\u00b4\7R\2\2\u00b4\20\3\2\2\2\u00b5"+
		"\u00b6\7U\2\2\u00b6\u00b7\7W\2\2\u00b7\u00b8\7D\2\2\u00b8\u00b9\7U\2\2"+
		"\u00b9\u00ba\7E\2\2\u00ba\u00bb\7T\2\2\u00bb\u00bc\7K\2\2\u00bc\u00bd"+
		"\7D\2\2\u00bd\u00be\7G\2\2\u00be\22\3\2\2\2\u00bf\u00c0\7W\2\2\u00c0\u00c1"+
		"\7P\2\2\u00c1\u00c2\7U\2\2\u00c2\u00c3\7W\2\2\u00c3\u00c4\7D\2\2\u00c4"+
		"\u00c5\7U\2\2\u00c5\u00c6\7E\2\2\u00c6\u00c7\7T\2\2\u00c7\u00c8\7K\2\2"+
		"\u00c8\u00c9\7D\2\2\u00c9\u00ca\7G\2\2\u00ca\24\3\2\2\2\u00cb\u00cc\7"+
		"T\2\2\u00cc\u00cd\7G\2\2\u00cd\u00ce\7U\2\2\u00ce\u00cf\7W\2\2\u00cf\u00d0"+
		"\7O\2\2\u00d0\u00d1\7G\2\2\u00d1\26\3\2\2\2\u00d2\u00d3\7R\2\2\u00d3\u00d4"+
		"\7C\2\2\u00d4\u00d5\7W\2\2\u00d5\u00d6\7U\2\2\u00d6\u00d7\7G\2\2\u00d7"+
		"\30\3\2\2\2\u00d8\u00d9\7W\2\2\u00d9\u00da\7U\2\2\u00da\u00db\7K\2\2\u00db"+
		"\u00dc\7P\2\2\u00dc\u00dd\7I\2\2\u00dd\32\3\2\2\2\u00de\u00df\7G\2\2\u00df"+
		"\u00e0\7Z\2\2\u00e0\u00e1\7K\2\2\u00e1\u00e2\7V\2\2\u00e2\34\3\2\2\2\u00e3"+
		"\u00e4\7U\2\2\u00e4\u00e5\7G\2\2\u00e5\u00e6\7V\2\2\u00e6\36\3\2\2\2\u00e7"+
		"\u00e8\7U\2\2\u00e8\u00e9\7V\2\2\u00e9\u00ea\7C\2\2\u00ea\u00eb\7T\2\2"+
		"\u00eb\u00ec\7V\2\2\u00ec \3\2\2\2\u00ed\u00ee\7C\2\2\u00ee\u00ef\7U\2"+
		"\2\u00ef\u00f0\7U\2\2\u00f0\u00f1\7G\2\2\u00f1\u00f2\7V\2\2\u00f2\"\3"+
		"\2\2\2\u00f3\u00f4\7O\2\2\u00f4\u00f5\7C\2\2\u00f5\u00f6\7P\2\2\u00f6"+
		"\u00f7\7C\2\2\u00f7\u00f8\7I\2\2\u00f8\u00f9\7G\2\2\u00f9\u00fa\7T\2\2"+
		"\u00fa$\3\2\2\2\u00fb\u00fc\7I\2\2\u00fc\u00fd\7C\2\2\u00fd\u00fe\7O\2"+
		"\2\u00fe\u00ff\7G\2\2\u00ff&\3\2\2\2\u0100\u0101\7U\2\2\u0101\u0102\7"+
		"V\2\2\u0102\u0103\7C\2\2\u0103\u0104\7V\2\2\u0104\u0105\7G\2\2\u0105("+
		"\3\2\2\2\u0106\u0107\7D\2\2\u0107\u0108\7G\2\2\u0108\u0109\7J\2\2\u0109"+
		"\u010a\7C\2\2\u010a\u010b\7X\2\2\u010b\u010c\7K\2\2\u010c\u010d\7Q\2\2"+
		"\u010d\u010e\7T\2\2\u010e*\3\2\2\2\u010f\u0110\7G\2\2\u0110\u0111\7P\2"+
		"\2\u0111\u0112\7V\2\2\u0112\u0113\7K\2\2\u0113\u0114\7V\2\2\u0114\u0115"+
		"\7[\2\2\u0115,\3\2\2\2\u0116\u0117\7I\2\2\u0117\u0118\7Q\2\2\u0118\u0119"+
		"\7C\2\2\u0119\u011a\7N\2\2\u011a.\3\2\2\2\u011b\u011c\7O\2\2\u011c\u011d"+
		"\7G\2\2\u011d\u011e\7U\2\2\u011e\u011f\7U\2\2\u011f\u0120\7C\2\2\u0120"+
		"\u0121\7I\2\2\u0121\u0122\7G\2\2\u0122\60\3\2\2\2\u0123\u0124\7D\2\2\u0124"+
		"\u0125\7C\2\2\u0125\u0126\7U\2\2\u0126\u0127\7G\2\2\u0127\62\3\2\2\2\u0128"+
		"\u0129\7V\2\2\u0129\u012a\7Q\2\2\u012a\64\3\2\2\2\u012b\u012c\7U\2\2\u012c"+
		"\u012d\7Q\2\2\u012d\u012e\7W\2\2\u012e\u012f\7T\2\2\u012f\u0130\7E\2\2"+
		"\u0130\u0131\7G\2\2\u0131\66\3\2\2\2\u0132\u0133\7]\2\2\u01338\3\2\2\2"+
		"\u0134\u0135\7*\2\2\u0135:\3\2\2\2\u0136\u0137\7}\2\2\u0137<\3\2\2\2\u0138"+
		"\u0139\7_\2\2\u0139>\3\2\2\2\u013a\u013b\7+\2\2\u013b@\3\2\2\2\u013c\u013d"+
		"\7\177\2\2\u013dB\3\2\2\2\u013e\u013f\7.\2\2\u013fD\3\2\2\2\u0140\u0141"+
		"\7?\2\2\u0141F\3\2\2\2\u0142\u0143\7\60\2\2\u0143H\3\2\2\2\u0144\u0145"+
		"\7=\2\2\u0145J\3\2\2\2\u0146\u0147\7<\2\2\u0147L\3\2\2\2\u0148\u0149\7"+
		"-\2\2\u0149N\3\2\2\2\u014a\u014b\7/\2\2\u014bP\3\2\2\2\u014c\u014d\7,"+
		"\2\2\u014dR\3\2\2\2\u014e\u014f\7\61\2\2\u014fT\3\2\2\2\u0150\u0151\7"+
		"C\2\2\u0151\u0152\7P\2\2\u0152\u0153\7F\2\2\u0153V\3\2\2\2\u0154\u0155"+
		"\7Q\2\2\u0155\u0156\7T\2\2\u0156X\3\2\2\2\u0157\u0158\7Z\2\2\u0158\u0159"+
		"\7Q\2\2\u0159\u015a\7T\2\2\u015aZ\3\2\2\2\u015b\u015c\7P\2\2\u015c\u015d"+
		"\7Q\2\2\u015d\u015e\7V\2\2\u015e\\\3\2\2\2\u015f\u0160\7K\2\2\u0160\u0161"+
		"\7p\2\2\u0161\u0162\7v\2\2\u0162^\3\2\2\2\u0163\u0164\7F\2\2\u0164\u0165"+
		"\7g\2\2\u0165\u0166\7e\2\2\u0166`\3\2\2\2\u0167\u0168\7U\2\2\u0168\u0169"+
		"\7v\2\2\u0169\u016a\7t\2\2\u016a\u016b\7k\2\2\u016b\u016c\7p\2\2\u016c"+
		"\u016d\7i\2\2\u016db\3\2\2\2\u016e\u016f\7D\2\2\u016f\u0170\7q\2\2\u0170"+
		"\u0171\7q\2\2\u0171\u0172\7n\2\2\u0172d\3\2\2\2\u0173\u0174\7G\2\2\u0174"+
		"\u0175\7p\2\2\u0175\u0176\7v\2\2\u0176\u0177\7k\2\2\u0177\u0178\7v\2\2"+
		"\u0178\u0179\7{\2\2\u0179f\3\2\2\2\u017a\u017b\7V\2\2\u017b\u017c\7g\2"+
		"\2\u017c\u017d\7z\2\2\u017d\u017e\7v\2\2\u017e\u017f\7w\2\2\u017f\u0180"+
		"\7t\2\2\u0180\u0181\7g\2\2\u0181h\3\2\2\2\u0182\u0183\7B\2\2\u0183\u0184"+
		"\7)\2\2\u0184\u0188\3\2\2\2\u0185\u0187\13\2\2\2\u0186\u0185\3\2\2\2\u0187"+
		"\u018a\3\2\2\2\u0188\u0189\3\2\2\2\u0188\u0186\3\2\2\2\u0189\u018b\3\2"+
		"\2\2\u018a\u0188\3\2\2\2\u018b\u018c\7)\2\2\u018cj\3\2\2\2\u018d\u018f"+
		"\5s:\2\u018e\u018d\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u018e\3\2\2\2\u0190"+
		"\u0191\3\2\2\2\u0191l\3\2\2\2\u0192\u0194\5s:\2\u0193\u0192\3\2\2\2\u0194"+
		"\u0197\3\2\2\2\u0195\u0193\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0198\3\2"+
		"\2\2\u0197\u0195\3\2\2\2\u0198\u019a\7\60\2\2\u0199\u019b\5s:\2\u019a"+
		"\u0199\3\2\2\2\u019b\u019c\3\2\2\2\u019c\u019a\3\2\2\2\u019c\u019d\3\2"+
		"\2\2\u019dn\3\2\2\2\u019e\u01a2\7$\2\2\u019f\u01a1\13\2\2\2\u01a0\u019f"+
		"\3\2\2\2\u01a1\u01a4\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a3"+
		"\u01a5\3\2\2\2\u01a4\u01a2\3\2\2\2\u01a5\u01a6\7$\2\2\u01a6p\3\2\2\2\u01a7"+
		"\u01a8\7v\2\2\u01a8\u01a9\7t\2\2\u01a9\u01aa\7w\2\2\u01aa\u01b1\7g\2\2"+
		"\u01ab\u01ac\7h\2\2\u01ac\u01ad\7c\2\2\u01ad\u01ae\7n\2\2\u01ae\u01af"+
		"\7u\2\2\u01af\u01b1\7g\2\2\u01b0\u01a7\3\2\2\2\u01b0\u01ab\3\2\2\2\u01b1"+
		"r\3\2\2\2\u01b2\u01b3\t\3\2\2\u01b3t\3\2\2\2\u01b4\u01b8\t\4\2\2\u01b5"+
		"\u01b7\t\5\2\2\u01b6\u01b5\3\2\2\2\u01b7\u01ba\3\2\2\2\u01b8\u01b6\3\2"+
		"\2\2\u01b8\u01b9\3\2\2\2\u01b9v\3\2\2\2\u01ba\u01b8\3\2\2\2\u01bb\u01bd"+
		"\t\2\2\2\u01bc\u01bb\3\2\2\2\u01bd\u01be\3\2\2\2\u01be\u01bc\3\2\2\2\u01be"+
		"\u01bf\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01c1\b<\4\2\u01c1x\3\2\2\2\u01c2"+
		"\u01c4\t\6\2\2\u01c3\u01c2\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c3\3\2"+
		"\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7\u01c8\b=\5\2\u01c8"+
		"z\3\2\2\2\20\2\u0082\u0085\u0088\u0094\u0188\u0190\u0195\u019c\u01a2\u01b0"+
		"\u01b8\u01be\u01c5";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}