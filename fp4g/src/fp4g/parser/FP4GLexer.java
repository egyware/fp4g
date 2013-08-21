// Generated from C:\Users\Edgardo\Git\fp4g-src\fp4g\src/fp4g/parser/FP4G.g by ANTLR 4.1

package fp4g.parser;

import static fp4g.Log.*;

import fp4g.data.*;
import fp4g.data.define.*;
import fp4g.data.managers.*;


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
		T__0=1, SINGLE_LINE_COMMENT=2, MULTI_LINE_COMMENT=3, DEFINE=4, ADD=5, 
		ON=6, SEND=7, GROUP=8, SUBSCRIBE=9, UNSUBSCRIBE=10, START=11, RESUME=12, 
		PAUSE=13, USING=14, EXIT=15, MANAGER=16, GAME=17, STATE=18, BEHAVIOR=19, 
		ENTITY=20, GOAL=21, MESSAGE=22, BASE=23, TO=24, SOURCE=25, ABRE_COR=26, 
		ABRE_PAR=27, CIERRA_COR=28, CIERRA_PAR=29, COMA=30, EQUAL=31, DOT=32, 
		DOTCOMA=33, DOBLEDOT=34, PLUS=35, MINUS=36, MULTIPLY=37, DIVIDE=38, AND=39, 
		OR=40, XOR=41, NOT=42, INT_TYPE=43, DEC_TYPE=44, BOOL_TYPE=45, ENTITY_TYPE=46, 
		INT_LITERAL=47, DECIMAL_LITERAL=48, STRING_LITERAL=49, BOOL_LITERAL=50, 
		ID=51, NL=52, WS=53;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'KeyMap'", "SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT", "'DEFINE'", "'ADD'", 
		"'ON'", "'SEND'", "'GROUP'", "'SUBSCRIBE'", "'UNSUBSCRIBE'", "'START'", 
		"'RESUME'", "'PAUSE'", "'USING'", "'EXIT'", "'MANAGER'", "'GAME'", "'STATE'", 
		"'BEHAVIOR'", "'ENTITY'", "'GOAL'", "'MESSAGE'", "'BASE'", "'TO'", "'SOURCE'", 
		"'['", "'('", "']'", "')'", "','", "'='", "'.'", "';'", "':'", "'+'", 
		"'-'", "'*'", "'/'", "'AND'", "'OR'", "'XOR'", "'NOT'", "'Int'", "'Dec'", 
		"'Bool'", "'Entity'", "INT_LITERAL", "DECIMAL_LITERAL", "STRING_LITERAL", 
		"BOOL_LITERAL", "ID", "NL", "WS"
	};
	public static final String[] ruleNames = {
		"T__0", "SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT", "DEFINE", "ADD", 
		"ON", "SEND", "GROUP", "SUBSCRIBE", "UNSUBSCRIBE", "START", "RESUME", 
		"PAUSE", "USING", "EXIT", "MANAGER", "GAME", "STATE", "BEHAVIOR", "ENTITY", 
		"GOAL", "MESSAGE", "BASE", "TO", "SOURCE", "ABRE_COR", "ABRE_PAR", "CIERRA_COR", 
		"CIERRA_PAR", "COMA", "EQUAL", "DOT", "DOTCOMA", "DOBLEDOT", "PLUS", "MINUS", 
		"MULTIPLY", "DIVIDE", "AND", "OR", "XOR", "NOT", "INT_TYPE", "DEC_TYPE", 
		"BOOL_TYPE", "ENTITY_TYPE", "INT_LITERAL", "DECIMAL_LITERAL", "STRING_LITERAL", 
		"BOOL_LITERAL", "DIGIT", "ID", "NL", "WS"
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
		case 1: SINGLE_LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 2: MULTI_LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 52: NL_action((RuleContext)_localctx, actionIndex); break;

		case 53: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\67\u01a0\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\3\3\7\3|\n\3\f\3\16\3\177\13\3\5\3\u0081\n\3\3\3\5\3\u0084"+
		"\n\3\3\3\3\3\3\3\3\3\3\4\3\4\7\4\u008c\n\4\f\4\16\4\u008f\13\4\3\4\7\4"+
		"\u0092\n\4\f\4\16\4\u0095\13\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\""+
		"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3*\3*\3*\3*"+
		"\3+\3+\3+\3+\3,\3,\3,\3,\3-\3-\3-\3-\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/"+
		"\3/\3\60\6\60\u0166\n\60\r\60\16\60\u0167\3\61\7\61\u016b\n\61\f\61\16"+
		"\61\u016e\13\61\3\61\3\61\6\61\u0172\n\61\r\61\16\61\u0173\3\62\3\62\7"+
		"\62\u0178\n\62\f\62\16\62\u017b\13\62\3\62\3\62\3\63\3\63\3\63\3\63\3"+
		"\63\3\63\3\63\3\63\3\63\5\63\u0188\n\63\3\64\3\64\3\65\3\65\7\65\u018e"+
		"\n\65\f\65\16\65\u0191\13\65\3\66\6\66\u0194\n\66\r\66\16\66\u0195\3\66"+
		"\3\66\3\67\6\67\u019b\n\67\r\67\16\67\u019c\3\67\3\67\5}\u0093\u01798"+
		"\3\3\1\5\4\2\7\5\3\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27"+
		"\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27"+
		"\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1\67\35\19\36\1;\37\1= \1?!\1A\""+
		"\1C#\1E$\1G%\1I&\1K\'\1M(\1O)\1Q*\1S+\1U,\1W-\1Y.\1[/\1]\60\1_\61\1a\62"+
		"\1c\63\1e\64\1g\2\1i\65\1k\66\4m\67\5\3\2\7\4\2\f\f\17\17\3\2\62;\5\2"+
		"C\\aac|\6\2\62;C\\aac|\4\2\13\13\"\"\u01ab\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2"+
		"\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M"+
		"\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2"+
		"\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2"+
		"\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\3o\3\2\2\2\5v\3\2\2\2\7\u008d\3\2\2"+
		"\2\t\u009b\3\2\2\2\13\u00a2\3\2\2\2\r\u00a6\3\2\2\2\17\u00a9\3\2\2\2\21"+
		"\u00ae\3\2\2\2\23\u00b4\3\2\2\2\25\u00be\3\2\2\2\27\u00ca\3\2\2\2\31\u00d0"+
		"\3\2\2\2\33\u00d7\3\2\2\2\35\u00dd\3\2\2\2\37\u00e3\3\2\2\2!\u00e8\3\2"+
		"\2\2#\u00f0\3\2\2\2%\u00f5\3\2\2\2\'\u00fb\3\2\2\2)\u0104\3\2\2\2+\u010b"+
		"\3\2\2\2-\u0110\3\2\2\2/\u0118\3\2\2\2\61\u011d\3\2\2\2\63\u0120\3\2\2"+
		"\2\65\u0127\3\2\2\2\67\u0129\3\2\2\29\u012b\3\2\2\2;\u012d\3\2\2\2=\u012f"+
		"\3\2\2\2?\u0131\3\2\2\2A\u0133\3\2\2\2C\u0135\3\2\2\2E\u0137\3\2\2\2G"+
		"\u0139\3\2\2\2I\u013b\3\2\2\2K\u013d\3\2\2\2M\u013f\3\2\2\2O\u0141\3\2"+
		"\2\2Q\u0145\3\2\2\2S\u0148\3\2\2\2U\u014c\3\2\2\2W\u0150\3\2\2\2Y\u0154"+
		"\3\2\2\2[\u0158\3\2\2\2]\u015d\3\2\2\2_\u0165\3\2\2\2a\u016c\3\2\2\2c"+
		"\u0175\3\2\2\2e\u0187\3\2\2\2g\u0189\3\2\2\2i\u018b\3\2\2\2k\u0193\3\2"+
		"\2\2m\u019a\3\2\2\2op\7M\2\2pq\7g\2\2qr\7{\2\2rs\7O\2\2st\7c\2\2tu\7r"+
		"\2\2u\4\3\2\2\2vw\7\61\2\2wx\7\61\2\2x\u0080\3\2\2\2y\u0081\t\2\2\2z|"+
		"\13\2\2\2{z\3\2\2\2|\177\3\2\2\2}~\3\2\2\2}{\3\2\2\2~\u0081\3\2\2\2\177"+
		"}\3\2\2\2\u0080y\3\2\2\2\u0080}\3\2\2\2\u0081\u0083\3\2\2\2\u0082\u0084"+
		"\7\17\2\2\u0083\u0082\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\3\2\2\2"+
		"\u0085\u0086\7\f\2\2\u0086\u0087\3\2\2\2\u0087\u0088\b\3\2\2\u0088\6\3"+
		"\2\2\2\u0089\u008a\7\61\2\2\u008a\u008c\7,\2\2\u008b\u0089\3\2\2\2\u008c"+
		"\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0093\3\2"+
		"\2\2\u008f\u008d\3\2\2\2\u0090\u0092\13\2\2\2\u0091\u0090\3\2\2\2\u0092"+
		"\u0095\3\2\2\2\u0093\u0094\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0096\3\2"+
		"\2\2\u0095\u0093\3\2\2\2\u0096\u0097\7,\2\2\u0097\u0098\7\61\2\2\u0098"+
		"\u0099\3\2\2\2\u0099\u009a\b\4\3\2\u009a\b\3\2\2\2\u009b\u009c\7F\2\2"+
		"\u009c\u009d\7G\2\2\u009d\u009e\7H\2\2\u009e\u009f\7K\2\2\u009f\u00a0"+
		"\7P\2\2\u00a0\u00a1\7G\2\2\u00a1\n\3\2\2\2\u00a2\u00a3\7C\2\2\u00a3\u00a4"+
		"\7F\2\2\u00a4\u00a5\7F\2\2\u00a5\f\3\2\2\2\u00a6\u00a7\7Q\2\2\u00a7\u00a8"+
		"\7P\2\2\u00a8\16\3\2\2\2\u00a9\u00aa\7U\2\2\u00aa\u00ab\7G\2\2\u00ab\u00ac"+
		"\7P\2\2\u00ac\u00ad\7F\2\2\u00ad\20\3\2\2\2\u00ae\u00af\7I\2\2\u00af\u00b0"+
		"\7T\2\2\u00b0\u00b1\7Q\2\2\u00b1\u00b2\7W\2\2\u00b2\u00b3\7R\2\2\u00b3"+
		"\22\3\2\2\2\u00b4\u00b5\7U\2\2\u00b5\u00b6\7W\2\2\u00b6\u00b7\7D\2\2\u00b7"+
		"\u00b8\7U\2\2\u00b8\u00b9\7E\2\2\u00b9\u00ba\7T\2\2\u00ba\u00bb\7K\2\2"+
		"\u00bb\u00bc\7D\2\2\u00bc\u00bd\7G\2\2\u00bd\24\3\2\2\2\u00be\u00bf\7"+
		"W\2\2\u00bf\u00c0\7P\2\2\u00c0\u00c1\7U\2\2\u00c1\u00c2\7W\2\2\u00c2\u00c3"+
		"\7D\2\2\u00c3\u00c4\7U\2\2\u00c4\u00c5\7E\2\2\u00c5\u00c6\7T\2\2\u00c6"+
		"\u00c7\7K\2\2\u00c7\u00c8\7D\2\2\u00c8\u00c9\7G\2\2\u00c9\26\3\2\2\2\u00ca"+
		"\u00cb\7U\2\2\u00cb\u00cc\7V\2\2\u00cc\u00cd\7C\2\2\u00cd\u00ce\7T\2\2"+
		"\u00ce\u00cf\7V\2\2\u00cf\30\3\2\2\2\u00d0\u00d1\7T\2\2\u00d1\u00d2\7"+
		"G\2\2\u00d2\u00d3\7U\2\2\u00d3\u00d4\7W\2\2\u00d4\u00d5\7O\2\2\u00d5\u00d6"+
		"\7G\2\2\u00d6\32\3\2\2\2\u00d7\u00d8\7R\2\2\u00d8\u00d9\7C\2\2\u00d9\u00da"+
		"\7W\2\2\u00da\u00db\7U\2\2\u00db\u00dc\7G\2\2\u00dc\34\3\2\2\2\u00dd\u00de"+
		"\7W\2\2\u00de\u00df\7U\2\2\u00df\u00e0\7K\2\2\u00e0\u00e1\7P\2\2\u00e1"+
		"\u00e2\7I\2\2\u00e2\36\3\2\2\2\u00e3\u00e4\7G\2\2\u00e4\u00e5\7Z\2\2\u00e5"+
		"\u00e6\7K\2\2\u00e6\u00e7\7V\2\2\u00e7 \3\2\2\2\u00e8\u00e9\7O\2\2\u00e9"+
		"\u00ea\7C\2\2\u00ea\u00eb\7P\2\2\u00eb\u00ec\7C\2\2\u00ec\u00ed\7I\2\2"+
		"\u00ed\u00ee\7G\2\2\u00ee\u00ef\7T\2\2\u00ef\"\3\2\2\2\u00f0\u00f1\7I"+
		"\2\2\u00f1\u00f2\7C\2\2\u00f2\u00f3\7O\2\2\u00f3\u00f4\7G\2\2\u00f4$\3"+
		"\2\2\2\u00f5\u00f6\7U\2\2\u00f6\u00f7\7V\2\2\u00f7\u00f8\7C\2\2\u00f8"+
		"\u00f9\7V\2\2\u00f9\u00fa\7G\2\2\u00fa&\3\2\2\2\u00fb\u00fc\7D\2\2\u00fc"+
		"\u00fd\7G\2\2\u00fd\u00fe\7J\2\2\u00fe\u00ff\7C\2\2\u00ff\u0100\7X\2\2"+
		"\u0100\u0101\7K\2\2\u0101\u0102\7Q\2\2\u0102\u0103\7T\2\2\u0103(\3\2\2"+
		"\2\u0104\u0105\7G\2\2\u0105\u0106\7P\2\2\u0106\u0107\7V\2\2\u0107\u0108"+
		"\7K\2\2\u0108\u0109\7V\2\2\u0109\u010a\7[\2\2\u010a*\3\2\2\2\u010b\u010c"+
		"\7I\2\2\u010c\u010d\7Q\2\2\u010d\u010e\7C\2\2\u010e\u010f\7N\2\2\u010f"+
		",\3\2\2\2\u0110\u0111\7O\2\2\u0111\u0112\7G\2\2\u0112\u0113\7U\2\2\u0113"+
		"\u0114\7U\2\2\u0114\u0115\7C\2\2\u0115\u0116\7I\2\2\u0116\u0117\7G\2\2"+
		"\u0117.\3\2\2\2\u0118\u0119\7D\2\2\u0119\u011a\7C\2\2\u011a\u011b\7U\2"+
		"\2\u011b\u011c\7G\2\2\u011c\60\3\2\2\2\u011d\u011e\7V\2\2\u011e\u011f"+
		"\7Q\2\2\u011f\62\3\2\2\2\u0120\u0121\7U\2\2\u0121\u0122\7Q\2\2\u0122\u0123"+
		"\7W\2\2\u0123\u0124\7T\2\2\u0124\u0125\7E\2\2\u0125\u0126\7G\2\2\u0126"+
		"\64\3\2\2\2\u0127\u0128\7]\2\2\u0128\66\3\2\2\2\u0129\u012a\7*\2\2\u012a"+
		"8\3\2\2\2\u012b\u012c\7_\2\2\u012c:\3\2\2\2\u012d\u012e\7+\2\2\u012e<"+
		"\3\2\2\2\u012f\u0130\7.\2\2\u0130>\3\2\2\2\u0131\u0132\7?\2\2\u0132@\3"+
		"\2\2\2\u0133\u0134\7\60\2\2\u0134B\3\2\2\2\u0135\u0136\7=\2\2\u0136D\3"+
		"\2\2\2\u0137\u0138\7<\2\2\u0138F\3\2\2\2\u0139\u013a\7-\2\2\u013aH\3\2"+
		"\2\2\u013b\u013c\7/\2\2\u013cJ\3\2\2\2\u013d\u013e\7,\2\2\u013eL\3\2\2"+
		"\2\u013f\u0140\7\61\2\2\u0140N\3\2\2\2\u0141\u0142\7C\2\2\u0142\u0143"+
		"\7P\2\2\u0143\u0144\7F\2\2\u0144P\3\2\2\2\u0145\u0146\7Q\2\2\u0146\u0147"+
		"\7T\2\2\u0147R\3\2\2\2\u0148\u0149\7Z\2\2\u0149\u014a\7Q\2\2\u014a\u014b"+
		"\7T\2\2\u014bT\3\2\2\2\u014c\u014d\7P\2\2\u014d\u014e\7Q\2\2\u014e\u014f"+
		"\7V\2\2\u014fV\3\2\2\2\u0150\u0151\7K\2\2\u0151\u0152\7p\2\2\u0152\u0153"+
		"\7v\2\2\u0153X\3\2\2\2\u0154\u0155\7F\2\2\u0155\u0156\7g\2\2\u0156\u0157"+
		"\7e\2\2\u0157Z\3\2\2\2\u0158\u0159\7D\2\2\u0159\u015a\7q\2\2\u015a\u015b"+
		"\7q\2\2\u015b\u015c\7n\2\2\u015c\\\3\2\2\2\u015d\u015e\7G\2\2\u015e\u015f"+
		"\7p\2\2\u015f\u0160\7v\2\2\u0160\u0161\7k\2\2\u0161\u0162\7v\2\2\u0162"+
		"\u0163\7{\2\2\u0163^\3\2\2\2\u0164\u0166\5g\64\2\u0165\u0164\3\2\2\2\u0166"+
		"\u0167\3\2\2\2\u0167\u0165\3\2\2\2\u0167\u0168\3\2\2\2\u0168`\3\2\2\2"+
		"\u0169\u016b\5g\64\2\u016a\u0169\3\2\2\2\u016b\u016e\3\2\2\2\u016c\u016a"+
		"\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u016f\3\2\2\2\u016e\u016c\3\2\2\2\u016f"+
		"\u0171\7\60\2\2\u0170\u0172\5g\64\2\u0171\u0170\3\2\2\2\u0172\u0173\3"+
		"\2\2\2\u0173\u0171\3\2\2\2\u0173\u0174\3\2\2\2\u0174b\3\2\2\2\u0175\u0179"+
		"\7$\2\2\u0176\u0178\13\2\2\2\u0177\u0176\3\2\2\2\u0178\u017b\3\2\2\2\u0179"+
		"\u017a\3\2\2\2\u0179\u0177\3\2\2\2\u017a\u017c\3\2\2\2\u017b\u0179\3\2"+
		"\2\2\u017c\u017d\7$\2\2\u017dd\3\2\2\2\u017e\u017f\7v\2\2\u017f\u0180"+
		"\7t\2\2\u0180\u0181\7w\2\2\u0181\u0188\7g\2\2\u0182\u0183\7h\2\2\u0183"+
		"\u0184\7c\2\2\u0184\u0185\7n\2\2\u0185\u0186\7u\2\2\u0186\u0188\7g\2\2"+
		"\u0187\u017e\3\2\2\2\u0187\u0182\3\2\2\2\u0188f\3\2\2\2\u0189\u018a\t"+
		"\3\2\2\u018ah\3\2\2\2\u018b\u018f\t\4\2\2\u018c\u018e\t\5\2\2\u018d\u018c"+
		"\3\2\2\2\u018e\u0191\3\2\2\2\u018f\u018d\3\2\2\2\u018f\u0190\3\2\2\2\u0190"+
		"j\3\2\2\2\u0191\u018f\3\2\2\2\u0192\u0194\t\2\2\2\u0193\u0192\3\2\2\2"+
		"\u0194\u0195\3\2\2\2\u0195\u0193\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0197"+
		"\3\2\2\2\u0197\u0198\b\66\4\2\u0198l\3\2\2\2\u0199\u019b\t\6\2\2\u019a"+
		"\u0199\3\2\2\2\u019b\u019c\3\2\2\2\u019c\u019a\3\2\2\2\u019c\u019d\3\2"+
		"\2\2\u019d\u019e\3\2\2\2\u019e\u019f\b\67\5\2\u019fn\3\2\2\2\20\2}\u0080"+
		"\u0083\u008d\u0093\u0167\u016c\u0173\u0179\u0187\u018f\u0195\u019c";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}