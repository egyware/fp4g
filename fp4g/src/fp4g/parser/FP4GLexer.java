// Generated from C:\Users\Edgardo\Git\fp4g-src\fp4g\src/fp4g/parser/FP4G.g by ANTLR 4.1

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
		SET=14, START=15, MANAGER=16, GAME=17, STATE=18, BEHAVIOR=19, ENTITY=20, 
		GOAL=21, MESSAGE=22, BASE=23, TO=24, SOURCE=25, ABRE_COR=26, ABRE_PAR=27, 
		ABRE_LLAV=28, CIERRA_COR=29, CIERRA_PAR=30, CIERRA_LLAV=31, COMA=32, EQUAL=33, 
		DOT=34, DOTCOMA=35, DOUBLEDOT=36, PLUS=37, MINUS=38, MULTIPLY=39, DIVIDE=40, 
		AND=41, OR=42, XOR=43, NOT=44, INT_TYPE=45, DEC_TYPE=46, STRING_TYPE=47, 
		BOOL_TYPE=48, ENTITY_TYPE=49, DIRECTCODE=50, INT_LITERAL=51, DECIMAL_LITERAL=52, 
		STRING_LITERAL=53, BOOL_LITERAL=54, ID=55, NL=56, WS=57;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT", "'DEFINE'", "'ADD'", "'ON'", 
		"'SEND'", "'GROUP'", "'SUBSCRIBE'", "'UNSUBSCRIBE'", "'RESUME'", "'PAUSE'", 
		"'USING'", "'EXIT'", "'SET'", "'START'", "'MANAGER'", "'GAME'", "'STATE'", 
		"'BEHAVIOR'", "'ENTITY'", "'GOAL'", "'MESSAGE'", "'BASE'", "'TO'", "'SOURCE'", 
		"'['", "'('", "'{'", "']'", "')'", "'}'", "','", "'='", "'.'", "';'", 
		"':'", "'+'", "'-'", "'*'", "'/'", "'AND'", "'OR'", "'XOR'", "'NOT'", 
		"'Int'", "'Dec'", "'String'", "'Bool'", "'Entity'", "DIRECTCODE", "INT_LITERAL", 
		"DECIMAL_LITERAL", "STRING_LITERAL", "BOOL_LITERAL", "ID", "NL", "WS"
	};
	public static final String[] ruleNames = {
		"SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT", "DEFINE", "ADD", "ON", "SEND", 
		"GROUP", "SUBSCRIBE", "UNSUBSCRIBE", "RESUME", "PAUSE", "USING", "EXIT", 
		"SET", "START", "MANAGER", "GAME", "STATE", "BEHAVIOR", "ENTITY", "GOAL", 
		"MESSAGE", "BASE", "TO", "SOURCE", "ABRE_COR", "ABRE_PAR", "ABRE_LLAV", 
		"CIERRA_COR", "CIERRA_PAR", "CIERRA_LLAV", "COMA", "EQUAL", "DOT", "DOTCOMA", 
		"DOUBLEDOT", "PLUS", "MINUS", "MULTIPLY", "DIVIDE", "AND", "OR", "XOR", 
		"NOT", "INT_TYPE", "DEC_TYPE", "STRING_TYPE", "BOOL_TYPE", "ENTITY_TYPE", 
		"DIRECTCODE", "INT_LITERAL", "DECIMAL_LITERAL", "STRING_LITERAL", "BOOL_LITERAL", 
		"DIGIT", "ID", "NL", "WS"
	};


	public FP4GLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FP4G.g"; }

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

		case 56: NL_action((RuleContext)_localctx, actionIndex); break;

		case 57: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2;\u01b7\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\3\2\3\2\3\2"+
		"\3\2\3\2\7\2}\n\2\f\2\16\2\u0080\13\2\5\2\u0082\n\2\3\2\5\2\u0085\n\2"+
		"\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3\u008f\n\3\f\3\16\3\u0092\13\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3"+
		"\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3"+
		"\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3"+
		"\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3"+
		"\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&"+
		"\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3*\3*\3+\3+\3+\3,\3,\3,\3,\3-\3-\3-\3-\3"+
		".\3.\3.\3.\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3"+
		"\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\7"+
		"\63\u0175\n\63\f\63\16\63\u0178\13\63\3\63\3\63\3\64\6\64\u017d\n\64\r"+
		"\64\16\64\u017e\3\65\7\65\u0182\n\65\f\65\16\65\u0185\13\65\3\65\3\65"+
		"\6\65\u0189\n\65\r\65\16\65\u018a\3\66\3\66\7\66\u018f\n\66\f\66\16\66"+
		"\u0192\13\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\5"+
		"\67\u019f\n\67\38\38\39\39\79\u01a5\n9\f9\169\u01a8\139\3:\6:\u01ab\n"+
		":\r:\16:\u01ac\3:\3:\3;\6;\u01b2\n;\r;\16;\u01b3\3;\3;\6~\u0090\u0176"+
		"\u0190<\3\3\2\5\4\3\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25"+
		"\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)"+
		"\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1\67\35\19\36\1;\37\1= "+
		"\1?!\1A\"\1C#\1E$\1G%\1I&\1K\'\1M(\1O)\1Q*\1S+\1U,\1W-\1Y.\1[/\1]\60\1"+
		"_\61\1a\62\1c\63\1e\64\1g\65\1i\66\1k\67\1m8\1o\2\1q9\1s:\4u;\5\3\2\7"+
		"\4\2\f\f\17\17\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\4\2\13\13\"\"\u01c2\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2"+
		"\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2"+
		"\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U"+
		"\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2"+
		"\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2"+
		"\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\3w\3\2\2\2\5\u008a\3\2\2\2\7\u0098\3"+
		"\2\2\2\t\u009f\3\2\2\2\13\u00a3\3\2\2\2\r\u00a6\3\2\2\2\17\u00ab\3\2\2"+
		"\2\21\u00b1\3\2\2\2\23\u00bb\3\2\2\2\25\u00c7\3\2\2\2\27\u00ce\3\2\2\2"+
		"\31\u00d4\3\2\2\2\33\u00da\3\2\2\2\35\u00df\3\2\2\2\37\u00e3\3\2\2\2!"+
		"\u00e9\3\2\2\2#\u00f1\3\2\2\2%\u00f6\3\2\2\2\'\u00fc\3\2\2\2)\u0105\3"+
		"\2\2\2+\u010c\3\2\2\2-\u0111\3\2\2\2/\u0119\3\2\2\2\61\u011e\3\2\2\2\63"+
		"\u0121\3\2\2\2\65\u0128\3\2\2\2\67\u012a\3\2\2\29\u012c\3\2\2\2;\u012e"+
		"\3\2\2\2=\u0130\3\2\2\2?\u0132\3\2\2\2A\u0134\3\2\2\2C\u0136\3\2\2\2E"+
		"\u0138\3\2\2\2G\u013a\3\2\2\2I\u013c\3\2\2\2K\u013e\3\2\2\2M\u0140\3\2"+
		"\2\2O\u0142\3\2\2\2Q\u0144\3\2\2\2S\u0146\3\2\2\2U\u014a\3\2\2\2W\u014d"+
		"\3\2\2\2Y\u0151\3\2\2\2[\u0155\3\2\2\2]\u0159\3\2\2\2_\u015d\3\2\2\2a"+
		"\u0164\3\2\2\2c\u0169\3\2\2\2e\u0170\3\2\2\2g\u017c\3\2\2\2i\u0183\3\2"+
		"\2\2k\u018c\3\2\2\2m\u019e\3\2\2\2o\u01a0\3\2\2\2q\u01a2\3\2\2\2s\u01aa"+
		"\3\2\2\2u\u01b1\3\2\2\2wx\7\61\2\2xy\7\61\2\2y\u0081\3\2\2\2z\u0082\t"+
		"\2\2\2{}\13\2\2\2|{\3\2\2\2}\u0080\3\2\2\2~\177\3\2\2\2~|\3\2\2\2\177"+
		"\u0082\3\2\2\2\u0080~\3\2\2\2\u0081z\3\2\2\2\u0081~\3\2\2\2\u0082\u0084"+
		"\3\2\2\2\u0083\u0085\7\17\2\2\u0084\u0083\3\2\2\2\u0084\u0085\3\2\2\2"+
		"\u0085\u0086\3\2\2\2\u0086\u0087\7\f\2\2\u0087\u0088\3\2\2\2\u0088\u0089"+
		"\b\2\2\2\u0089\4\3\2\2\2\u008a\u008b\7\61\2\2\u008b\u008c\7,\2\2\u008c"+
		"\u0090\3\2\2\2\u008d\u008f\13\2\2\2\u008e\u008d\3\2\2\2\u008f\u0092\3"+
		"\2\2\2\u0090\u0091\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0093\3\2\2\2\u0092"+
		"\u0090\3\2\2\2\u0093\u0094\7,\2\2\u0094\u0095\7\61\2\2\u0095\u0096\3\2"+
		"\2\2\u0096\u0097\b\3\3\2\u0097\6\3\2\2\2\u0098\u0099\7F\2\2\u0099\u009a"+
		"\7G\2\2\u009a\u009b\7H\2\2\u009b\u009c\7K\2\2\u009c\u009d\7P\2\2\u009d"+
		"\u009e\7G\2\2\u009e\b\3\2\2\2\u009f\u00a0\7C\2\2\u00a0\u00a1\7F\2\2\u00a1"+
		"\u00a2\7F\2\2\u00a2\n\3\2\2\2\u00a3\u00a4\7Q\2\2\u00a4\u00a5\7P\2\2\u00a5"+
		"\f\3\2\2\2\u00a6\u00a7\7U\2\2\u00a7\u00a8\7G\2\2\u00a8\u00a9\7P\2\2\u00a9"+
		"\u00aa\7F\2\2\u00aa\16\3\2\2\2\u00ab\u00ac\7I\2\2\u00ac\u00ad\7T\2\2\u00ad"+
		"\u00ae\7Q\2\2\u00ae\u00af\7W\2\2\u00af\u00b0\7R\2\2\u00b0\20\3\2\2\2\u00b1"+
		"\u00b2\7U\2\2\u00b2\u00b3\7W\2\2\u00b3\u00b4\7D\2\2\u00b4\u00b5\7U\2\2"+
		"\u00b5\u00b6\7E\2\2\u00b6\u00b7\7T\2\2\u00b7\u00b8\7K\2\2\u00b8\u00b9"+
		"\7D\2\2\u00b9\u00ba\7G\2\2\u00ba\22\3\2\2\2\u00bb\u00bc\7W\2\2\u00bc\u00bd"+
		"\7P\2\2\u00bd\u00be\7U\2\2\u00be\u00bf\7W\2\2\u00bf\u00c0\7D\2\2\u00c0"+
		"\u00c1\7U\2\2\u00c1\u00c2\7E\2\2\u00c2\u00c3\7T\2\2\u00c3\u00c4\7K\2\2"+
		"\u00c4\u00c5\7D\2\2\u00c5\u00c6\7G\2\2\u00c6\24\3\2\2\2\u00c7\u00c8\7"+
		"T\2\2\u00c8\u00c9\7G\2\2\u00c9\u00ca\7U\2\2\u00ca\u00cb\7W\2\2\u00cb\u00cc"+
		"\7O\2\2\u00cc\u00cd\7G\2\2\u00cd\26\3\2\2\2\u00ce\u00cf\7R\2\2\u00cf\u00d0"+
		"\7C\2\2\u00d0\u00d1\7W\2\2\u00d1\u00d2\7U\2\2\u00d2\u00d3\7G\2\2\u00d3"+
		"\30\3\2\2\2\u00d4\u00d5\7W\2\2\u00d5\u00d6\7U\2\2\u00d6\u00d7\7K\2\2\u00d7"+
		"\u00d8\7P\2\2\u00d8\u00d9\7I\2\2\u00d9\32\3\2\2\2\u00da\u00db\7G\2\2\u00db"+
		"\u00dc\7Z\2\2\u00dc\u00dd\7K\2\2\u00dd\u00de\7V\2\2\u00de\34\3\2\2\2\u00df"+
		"\u00e0\7U\2\2\u00e0\u00e1\7G\2\2\u00e1\u00e2\7V\2\2\u00e2\36\3\2\2\2\u00e3"+
		"\u00e4\7U\2\2\u00e4\u00e5\7V\2\2\u00e5\u00e6\7C\2\2\u00e6\u00e7\7T\2\2"+
		"\u00e7\u00e8\7V\2\2\u00e8 \3\2\2\2\u00e9\u00ea\7O\2\2\u00ea\u00eb\7C\2"+
		"\2\u00eb\u00ec\7P\2\2\u00ec\u00ed\7C\2\2\u00ed\u00ee\7I\2\2\u00ee\u00ef"+
		"\7G\2\2\u00ef\u00f0\7T\2\2\u00f0\"\3\2\2\2\u00f1\u00f2\7I\2\2\u00f2\u00f3"+
		"\7C\2\2\u00f3\u00f4\7O\2\2\u00f4\u00f5\7G\2\2\u00f5$\3\2\2\2\u00f6\u00f7"+
		"\7U\2\2\u00f7\u00f8\7V\2\2\u00f8\u00f9\7C\2\2\u00f9\u00fa\7V\2\2\u00fa"+
		"\u00fb\7G\2\2\u00fb&\3\2\2\2\u00fc\u00fd\7D\2\2\u00fd\u00fe\7G\2\2\u00fe"+
		"\u00ff\7J\2\2\u00ff\u0100\7C\2\2\u0100\u0101\7X\2\2\u0101\u0102\7K\2\2"+
		"\u0102\u0103\7Q\2\2\u0103\u0104\7T\2\2\u0104(\3\2\2\2\u0105\u0106\7G\2"+
		"\2\u0106\u0107\7P\2\2\u0107\u0108\7V\2\2\u0108\u0109\7K\2\2\u0109\u010a"+
		"\7V\2\2\u010a\u010b\7[\2\2\u010b*\3\2\2\2\u010c\u010d\7I\2\2\u010d\u010e"+
		"\7Q\2\2\u010e\u010f\7C\2\2\u010f\u0110\7N\2\2\u0110,\3\2\2\2\u0111\u0112"+
		"\7O\2\2\u0112\u0113\7G\2\2\u0113\u0114\7U\2\2\u0114\u0115\7U\2\2\u0115"+
		"\u0116\7C\2\2\u0116\u0117\7I\2\2\u0117\u0118\7G\2\2\u0118.\3\2\2\2\u0119"+
		"\u011a\7D\2\2\u011a\u011b\7C\2\2\u011b\u011c\7U\2\2\u011c\u011d\7G\2\2"+
		"\u011d\60\3\2\2\2\u011e\u011f\7V\2\2\u011f\u0120\7Q\2\2\u0120\62\3\2\2"+
		"\2\u0121\u0122\7U\2\2\u0122\u0123\7Q\2\2\u0123\u0124\7W\2\2\u0124\u0125"+
		"\7T\2\2\u0125\u0126\7E\2\2\u0126\u0127\7G\2\2\u0127\64\3\2\2\2\u0128\u0129"+
		"\7]\2\2\u0129\66\3\2\2\2\u012a\u012b\7*\2\2\u012b8\3\2\2\2\u012c\u012d"+
		"\7}\2\2\u012d:\3\2\2\2\u012e\u012f\7_\2\2\u012f<\3\2\2\2\u0130\u0131\7"+
		"+\2\2\u0131>\3\2\2\2\u0132\u0133\7\177\2\2\u0133@\3\2\2\2\u0134\u0135"+
		"\7.\2\2\u0135B\3\2\2\2\u0136\u0137\7?\2\2\u0137D\3\2\2\2\u0138\u0139\7"+
		"\60\2\2\u0139F\3\2\2\2\u013a\u013b\7=\2\2\u013bH\3\2\2\2\u013c\u013d\7"+
		"<\2\2\u013dJ\3\2\2\2\u013e\u013f\7-\2\2\u013fL\3\2\2\2\u0140\u0141\7/"+
		"\2\2\u0141N\3\2\2\2\u0142\u0143\7,\2\2\u0143P\3\2\2\2\u0144\u0145\7\61"+
		"\2\2\u0145R\3\2\2\2\u0146\u0147\7C\2\2\u0147\u0148\7P\2\2\u0148\u0149"+
		"\7F\2\2\u0149T\3\2\2\2\u014a\u014b\7Q\2\2\u014b\u014c\7T\2\2\u014cV\3"+
		"\2\2\2\u014d\u014e\7Z\2\2\u014e\u014f\7Q\2\2\u014f\u0150\7T\2\2\u0150"+
		"X\3\2\2\2\u0151\u0152\7P\2\2\u0152\u0153\7Q\2\2\u0153\u0154\7V\2\2\u0154"+
		"Z\3\2\2\2\u0155\u0156\7K\2\2\u0156\u0157\7p\2\2\u0157\u0158\7v\2\2\u0158"+
		"\\\3\2\2\2\u0159\u015a\7F\2\2\u015a\u015b\7g\2\2\u015b\u015c\7e\2\2\u015c"+
		"^\3\2\2\2\u015d\u015e\7U\2\2\u015e\u015f\7v\2\2\u015f\u0160\7t\2\2\u0160"+
		"\u0161\7k\2\2\u0161\u0162\7p\2\2\u0162\u0163\7i\2\2\u0163`\3\2\2\2\u0164"+
		"\u0165\7D\2\2\u0165\u0166\7q\2\2\u0166\u0167\7q\2\2\u0167\u0168\7n\2\2"+
		"\u0168b\3\2\2\2\u0169\u016a\7G\2\2\u016a\u016b\7p\2\2\u016b\u016c\7v\2"+
		"\2\u016c\u016d\7k\2\2\u016d\u016e\7v\2\2\u016e\u016f\7{\2\2\u016fd\3\2"+
		"\2\2\u0170\u0171\7B\2\2\u0171\u0172\7)\2\2\u0172\u0176\3\2\2\2\u0173\u0175"+
		"\13\2\2\2\u0174\u0173\3\2\2\2\u0175\u0178\3\2\2\2\u0176\u0177\3\2\2\2"+
		"\u0176\u0174\3\2\2\2\u0177\u0179\3\2\2\2\u0178\u0176\3\2\2\2\u0179\u017a"+
		"\7)\2\2\u017af\3\2\2\2\u017b\u017d\5o8\2\u017c\u017b\3\2\2\2\u017d\u017e"+
		"\3\2\2\2\u017e\u017c\3\2\2\2\u017e\u017f\3\2\2\2\u017fh\3\2\2\2\u0180"+
		"\u0182\5o8\2\u0181\u0180\3\2\2\2\u0182\u0185\3\2\2\2\u0183\u0181\3\2\2"+
		"\2\u0183\u0184\3\2\2\2\u0184\u0186\3\2\2\2\u0185\u0183\3\2\2\2\u0186\u0188"+
		"\7\60\2\2\u0187\u0189\5o8\2\u0188\u0187\3\2\2\2\u0189\u018a\3\2\2\2\u018a"+
		"\u0188\3\2\2\2\u018a\u018b\3\2\2\2\u018bj\3\2\2\2\u018c\u0190\7$\2\2\u018d"+
		"\u018f\13\2\2\2\u018e\u018d\3\2\2\2\u018f\u0192\3\2\2\2\u0190\u0191\3"+
		"\2\2\2\u0190\u018e\3\2\2\2\u0191\u0193\3\2\2\2\u0192\u0190\3\2\2\2\u0193"+
		"\u0194\7$\2\2\u0194l\3\2\2\2\u0195\u0196\7v\2\2\u0196\u0197\7t\2\2\u0197"+
		"\u0198\7w\2\2\u0198\u019f\7g\2\2\u0199\u019a\7h\2\2\u019a\u019b\7c\2\2"+
		"\u019b\u019c\7n\2\2\u019c\u019d\7u\2\2\u019d\u019f\7g\2\2\u019e\u0195"+
		"\3\2\2\2\u019e\u0199\3\2\2\2\u019fn\3\2\2\2\u01a0\u01a1\t\3\2\2\u01a1"+
		"p\3\2\2\2\u01a2\u01a6\t\4\2\2\u01a3\u01a5\t\5\2\2\u01a4\u01a3\3\2\2\2"+
		"\u01a5\u01a8\3\2\2\2\u01a6\u01a4\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7r\3"+
		"\2\2\2\u01a8\u01a6\3\2\2\2\u01a9\u01ab\t\2\2\2\u01aa\u01a9\3\2\2\2\u01ab"+
		"\u01ac\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad\u01ae\3\2"+
		"\2\2\u01ae\u01af\b:\4\2\u01aft\3\2\2\2\u01b0\u01b2\t\6\2\2\u01b1\u01b0"+
		"\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3\u01b1\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4"+
		"\u01b5\3\2\2\2\u01b5\u01b6\b;\5\2\u01b6v\3\2\2\2\20\2~\u0081\u0084\u0090"+
		"\u0176\u017e\u0183\u018a\u0190\u019e\u01a6\u01ac\u01b3";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}