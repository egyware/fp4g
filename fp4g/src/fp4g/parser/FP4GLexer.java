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
		SINGLE_LINE_COMMENT=1, MULTI_LINE_COMMENT=2, DEFINE=3, ADD=4, ON=5, SEND=6, 
		GROUP=7, SUBSCRIBE=8, UNSUBSCRIBE=9, START=10, RESUME=11, PAUSE=12, USING=13, 
		EXIT=14, MANAGER=15, GAME=16, STATE=17, BEHAVIOR=18, ENTITY=19, GOAL=20, 
		MESSAGE=21, BASE=22, TO=23, SOURCE=24, ABRE_COR=25, ABRE_PAR=26, CIERRA_COR=27, 
		CIERRA_PAR=28, COMA=29, EQUAL=30, DOT=31, DOTCOMA=32, DOBLEDOT=33, PLUS=34, 
		MINUS=35, MULTIPLY=36, DIVIDE=37, AND=38, OR=39, XOR=40, NOT=41, INT_LITERAL=42, 
		DECIMAL_LITERAL=43, STRING_LITERAL=44, BOOL_LITERAL=45, ID=46, NL=47, 
		WS=48;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT", "'DEFINE'", "'ADD'", "'ON'", 
		"'SEND'", "'GROUP'", "'SUBSCRIBE'", "'UNSUBSCRIBE'", "'START'", "'RESUME'", 
		"'PAUSE'", "'USING'", "'EXIT'", "'MANAGER'", "'GAME'", "'STATE'", "'BEHAVIOR'", 
		"'ENTITY'", "'GOAL'", "'MESSAGE'", "'BASE'", "'TO'", "'SOURCE'", "'['", 
		"'('", "']'", "')'", "','", "'='", "'.'", "';'", "':'", "'+'", "'-'", 
		"'*'", "'/'", "'AND'", "'OR'", "'XOR'", "'NOT'", "INT_LITERAL", "DECIMAL_LITERAL", 
		"STRING_LITERAL", "BOOL_LITERAL", "ID", "NL", "WS"
	};
	public static final String[] ruleNames = {
		"SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT", "DEFINE", "ADD", "ON", "SEND", 
		"GROUP", "SUBSCRIBE", "UNSUBSCRIBE", "START", "RESUME", "PAUSE", "USING", 
		"EXIT", "MANAGER", "GAME", "STATE", "BEHAVIOR", "ENTITY", "GOAL", "MESSAGE", 
		"BASE", "TO", "SOURCE", "ABRE_COR", "ABRE_PAR", "CIERRA_COR", "CIERRA_PAR", 
		"COMA", "EQUAL", "DOT", "DOTCOMA", "DOBLEDOT", "PLUS", "MINUS", "MULTIPLY", 
		"DIVIDE", "AND", "OR", "XOR", "NOT", "INT_LITERAL", "DECIMAL_LITERAL", 
		"STRING_LITERAL", "BOOL_LITERAL", "DIGIT", "ID", "NL", "WS"
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

		case 47: NL_action((RuleContext)_localctx, actionIndex); break;

		case 48: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\62\u017b\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\3\2\3\2\3"+
		"\2\3\2\7\2k\n\2\f\2\16\2n\13\2\5\2p\n\2\3\2\5\2s\n\2\3\2\3\2\3\2\3\2\3"+
		"\3\3\3\7\3{\n\3\f\3\16\3~\13\3\3\3\7\3\u0081\n\3\f\3\16\3\u0084\13\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3"+
		"\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'"+
		"\3\'\3\'\3(\3(\3(\3)\3)\3)\3)\3*\3*\3*\3*\3+\6+\u0141\n+\r+\16+\u0142"+
		"\3,\7,\u0146\n,\f,\16,\u0149\13,\3,\3,\6,\u014d\n,\r,\16,\u014e\3-\3-"+
		"\7-\u0153\n-\f-\16-\u0156\13-\3-\3-\3.\3.\3.\3.\3.\3.\3.\3.\3.\5.\u0163"+
		"\n.\3/\3/\3\60\3\60\7\60\u0169\n\60\f\60\16\60\u016c\13\60\3\61\6\61\u016f"+
		"\n\61\r\61\16\61\u0170\3\61\3\61\3\62\6\62\u0176\n\62\r\62\16\62\u0177"+
		"\3\62\3\62\5l\u0082\u0154\63\3\3\2\5\4\3\7\5\1\t\6\1\13\7\1\r\b\1\17\t"+
		"\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1"+
		"#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1\67"+
		"\35\19\36\1;\37\1= \1?!\1A\"\1C#\1E$\1G%\1I&\1K\'\1M(\1O)\1Q*\1S+\1U,"+
		"\1W-\1Y.\1[/\1]\2\1_\60\1a\61\4c\62\5\3\2\7\4\2\f\f\17\17\3\2\62;\5\2"+
		"C\\aac|\6\2\62;C\\aac|\4\2\13\13\"\"\u0186\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2"+
		"\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M"+
		"\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2"+
		"\2\2\2[\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\3e\3\2\2\2\5|\3\2\2\2"+
		"\7\u008a\3\2\2\2\t\u0091\3\2\2\2\13\u0095\3\2\2\2\r\u0098\3\2\2\2\17\u009d"+
		"\3\2\2\2\21\u00a3\3\2\2\2\23\u00ad\3\2\2\2\25\u00b9\3\2\2\2\27\u00bf\3"+
		"\2\2\2\31\u00c6\3\2\2\2\33\u00cc\3\2\2\2\35\u00d2\3\2\2\2\37\u00d7\3\2"+
		"\2\2!\u00df\3\2\2\2#\u00e4\3\2\2\2%\u00ea\3\2\2\2\'\u00f3\3\2\2\2)\u00fa"+
		"\3\2\2\2+\u00ff\3\2\2\2-\u0107\3\2\2\2/\u010c\3\2\2\2\61\u010f\3\2\2\2"+
		"\63\u0116\3\2\2\2\65\u0118\3\2\2\2\67\u011a\3\2\2\29\u011c\3\2\2\2;\u011e"+
		"\3\2\2\2=\u0120\3\2\2\2?\u0122\3\2\2\2A\u0124\3\2\2\2C\u0126\3\2\2\2E"+
		"\u0128\3\2\2\2G\u012a\3\2\2\2I\u012c\3\2\2\2K\u012e\3\2\2\2M\u0130\3\2"+
		"\2\2O\u0134\3\2\2\2Q\u0137\3\2\2\2S\u013b\3\2\2\2U\u0140\3\2\2\2W\u0147"+
		"\3\2\2\2Y\u0150\3\2\2\2[\u0162\3\2\2\2]\u0164\3\2\2\2_\u0166\3\2\2\2a"+
		"\u016e\3\2\2\2c\u0175\3\2\2\2ef\7\61\2\2fg\7\61\2\2go\3\2\2\2hp\t\2\2"+
		"\2ik\13\2\2\2ji\3\2\2\2kn\3\2\2\2lm\3\2\2\2lj\3\2\2\2mp\3\2\2\2nl\3\2"+
		"\2\2oh\3\2\2\2ol\3\2\2\2pr\3\2\2\2qs\7\17\2\2rq\3\2\2\2rs\3\2\2\2st\3"+
		"\2\2\2tu\7\f\2\2uv\3\2\2\2vw\b\2\2\2w\4\3\2\2\2xy\7\61\2\2y{\7,\2\2zx"+
		"\3\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\u0082\3\2\2\2~|\3\2\2\2\177\u0081"+
		"\13\2\2\2\u0080\177\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0083\3\2\2\2\u0082"+
		"\u0080\3\2\2\2\u0083\u0085\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0086\7,"+
		"\2\2\u0086\u0087\7\61\2\2\u0087\u0088\3\2\2\2\u0088\u0089\b\3\3\2\u0089"+
		"\6\3\2\2\2\u008a\u008b\7F\2\2\u008b\u008c\7G\2\2\u008c\u008d\7H\2\2\u008d"+
		"\u008e\7K\2\2\u008e\u008f\7P\2\2\u008f\u0090\7G\2\2\u0090\b\3\2\2\2\u0091"+
		"\u0092\7C\2\2\u0092\u0093\7F\2\2\u0093\u0094\7F\2\2\u0094\n\3\2\2\2\u0095"+
		"\u0096\7Q\2\2\u0096\u0097\7P\2\2\u0097\f\3\2\2\2\u0098\u0099\7U\2\2\u0099"+
		"\u009a\7G\2\2\u009a\u009b\7P\2\2\u009b\u009c\7F\2\2\u009c\16\3\2\2\2\u009d"+
		"\u009e\7I\2\2\u009e\u009f\7T\2\2\u009f\u00a0\7Q\2\2\u00a0\u00a1\7W\2\2"+
		"\u00a1\u00a2\7R\2\2\u00a2\20\3\2\2\2\u00a3\u00a4\7U\2\2\u00a4\u00a5\7"+
		"W\2\2\u00a5\u00a6\7D\2\2\u00a6\u00a7\7U\2\2\u00a7\u00a8\7E\2\2\u00a8\u00a9"+
		"\7T\2\2\u00a9\u00aa\7K\2\2\u00aa\u00ab\7D\2\2\u00ab\u00ac\7G\2\2\u00ac"+
		"\22\3\2\2\2\u00ad\u00ae\7W\2\2\u00ae\u00af\7P\2\2\u00af\u00b0\7U\2\2\u00b0"+
		"\u00b1\7W\2\2\u00b1\u00b2\7D\2\2\u00b2\u00b3\7U\2\2\u00b3\u00b4\7E\2\2"+
		"\u00b4\u00b5\7T\2\2\u00b5\u00b6\7K\2\2\u00b6\u00b7\7D\2\2\u00b7\u00b8"+
		"\7G\2\2\u00b8\24\3\2\2\2\u00b9\u00ba\7U\2\2\u00ba\u00bb\7V\2\2\u00bb\u00bc"+
		"\7C\2\2\u00bc\u00bd\7T\2\2\u00bd\u00be\7V\2\2\u00be\26\3\2\2\2\u00bf\u00c0"+
		"\7T\2\2\u00c0\u00c1\7G\2\2\u00c1\u00c2\7U\2\2\u00c2\u00c3\7W\2\2\u00c3"+
		"\u00c4\7O\2\2\u00c4\u00c5\7G\2\2\u00c5\30\3\2\2\2\u00c6\u00c7\7R\2\2\u00c7"+
		"\u00c8\7C\2\2\u00c8\u00c9\7W\2\2\u00c9\u00ca\7U\2\2\u00ca\u00cb\7G\2\2"+
		"\u00cb\32\3\2\2\2\u00cc\u00cd\7W\2\2\u00cd\u00ce\7U\2\2\u00ce\u00cf\7"+
		"K\2\2\u00cf\u00d0\7P\2\2\u00d0\u00d1\7I\2\2\u00d1\34\3\2\2\2\u00d2\u00d3"+
		"\7G\2\2\u00d3\u00d4\7Z\2\2\u00d4\u00d5\7K\2\2\u00d5\u00d6\7V\2\2\u00d6"+
		"\36\3\2\2\2\u00d7\u00d8\7O\2\2\u00d8\u00d9\7C\2\2\u00d9\u00da\7P\2\2\u00da"+
		"\u00db\7C\2\2\u00db\u00dc\7I\2\2\u00dc\u00dd\7G\2\2\u00dd\u00de\7T\2\2"+
		"\u00de \3\2\2\2\u00df\u00e0\7I\2\2\u00e0\u00e1\7C\2\2\u00e1\u00e2\7O\2"+
		"\2\u00e2\u00e3\7G\2\2\u00e3\"\3\2\2\2\u00e4\u00e5\7U\2\2\u00e5\u00e6\7"+
		"V\2\2\u00e6\u00e7\7C\2\2\u00e7\u00e8\7V\2\2\u00e8\u00e9\7G\2\2\u00e9$"+
		"\3\2\2\2\u00ea\u00eb\7D\2\2\u00eb\u00ec\7G\2\2\u00ec\u00ed\7J\2\2\u00ed"+
		"\u00ee\7C\2\2\u00ee\u00ef\7X\2\2\u00ef\u00f0\7K\2\2\u00f0\u00f1\7Q\2\2"+
		"\u00f1\u00f2\7T\2\2\u00f2&\3\2\2\2\u00f3\u00f4\7G\2\2\u00f4\u00f5\7P\2"+
		"\2\u00f5\u00f6\7V\2\2\u00f6\u00f7\7K\2\2\u00f7\u00f8\7V\2\2\u00f8\u00f9"+
		"\7[\2\2\u00f9(\3\2\2\2\u00fa\u00fb\7I\2\2\u00fb\u00fc\7Q\2\2\u00fc\u00fd"+
		"\7C\2\2\u00fd\u00fe\7N\2\2\u00fe*\3\2\2\2\u00ff\u0100\7O\2\2\u0100\u0101"+
		"\7G\2\2\u0101\u0102\7U\2\2\u0102\u0103\7U\2\2\u0103\u0104\7C\2\2\u0104"+
		"\u0105\7I\2\2\u0105\u0106\7G\2\2\u0106,\3\2\2\2\u0107\u0108\7D\2\2\u0108"+
		"\u0109\7C\2\2\u0109\u010a\7U\2\2\u010a\u010b\7G\2\2\u010b.\3\2\2\2\u010c"+
		"\u010d\7V\2\2\u010d\u010e\7Q\2\2\u010e\60\3\2\2\2\u010f\u0110\7U\2\2\u0110"+
		"\u0111\7Q\2\2\u0111\u0112\7W\2\2\u0112\u0113\7T\2\2\u0113\u0114\7E\2\2"+
		"\u0114\u0115\7G\2\2\u0115\62\3\2\2\2\u0116\u0117\7]\2\2\u0117\64\3\2\2"+
		"\2\u0118\u0119\7*\2\2\u0119\66\3\2\2\2\u011a\u011b\7_\2\2\u011b8\3\2\2"+
		"\2\u011c\u011d\7+\2\2\u011d:\3\2\2\2\u011e\u011f\7.\2\2\u011f<\3\2\2\2"+
		"\u0120\u0121\7?\2\2\u0121>\3\2\2\2\u0122\u0123\7\60\2\2\u0123@\3\2\2\2"+
		"\u0124\u0125\7=\2\2\u0125B\3\2\2\2\u0126\u0127\7<\2\2\u0127D\3\2\2\2\u0128"+
		"\u0129\7-\2\2\u0129F\3\2\2\2\u012a\u012b\7/\2\2\u012bH\3\2\2\2\u012c\u012d"+
		"\7,\2\2\u012dJ\3\2\2\2\u012e\u012f\7\61\2\2\u012fL\3\2\2\2\u0130\u0131"+
		"\7C\2\2\u0131\u0132\7P\2\2\u0132\u0133\7F\2\2\u0133N\3\2\2\2\u0134\u0135"+
		"\7Q\2\2\u0135\u0136\7T\2\2\u0136P\3\2\2\2\u0137\u0138\7Z\2\2\u0138\u0139"+
		"\7Q\2\2\u0139\u013a\7T\2\2\u013aR\3\2\2\2\u013b\u013c\7P\2\2\u013c\u013d"+
		"\7Q\2\2\u013d\u013e\7V\2\2\u013eT\3\2\2\2\u013f\u0141\5]/\2\u0140\u013f"+
		"\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143"+
		"V\3\2\2\2\u0144\u0146\5]/\2\u0145\u0144\3\2\2\2\u0146\u0149\3\2\2\2\u0147"+
		"\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u014a\3\2\2\2\u0149\u0147\3\2"+
		"\2\2\u014a\u014c\7\60\2\2\u014b\u014d\5]/\2\u014c\u014b\3\2\2\2\u014d"+
		"\u014e\3\2\2\2\u014e\u014c\3\2\2\2\u014e\u014f\3\2\2\2\u014fX\3\2\2\2"+
		"\u0150\u0154\7$\2\2\u0151\u0153\13\2\2\2\u0152\u0151\3\2\2\2\u0153\u0156"+
		"\3\2\2\2\u0154\u0155\3\2\2\2\u0154\u0152\3\2\2\2\u0155\u0157\3\2\2\2\u0156"+
		"\u0154\3\2\2\2\u0157\u0158\7$\2\2\u0158Z\3\2\2\2\u0159\u015a\7v\2\2\u015a"+
		"\u015b\7t\2\2\u015b\u015c\7w\2\2\u015c\u0163\7g\2\2\u015d\u015e\7h\2\2"+
		"\u015e\u015f\7c\2\2\u015f\u0160\7n\2\2\u0160\u0161\7u\2\2\u0161\u0163"+
		"\7g\2\2\u0162\u0159\3\2\2\2\u0162\u015d\3\2\2\2\u0163\\\3\2\2\2\u0164"+
		"\u0165\t\3\2\2\u0165^\3\2\2\2\u0166\u016a\t\4\2\2\u0167\u0169\t\5\2\2"+
		"\u0168\u0167\3\2\2\2\u0169\u016c\3\2\2\2\u016a\u0168\3\2\2\2\u016a\u016b"+
		"\3\2\2\2\u016b`\3\2\2\2\u016c\u016a\3\2\2\2\u016d\u016f\t\2\2\2\u016e"+
		"\u016d\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u016e\3\2\2\2\u0170\u0171\3\2"+
		"\2\2\u0171\u0172\3\2\2\2\u0172\u0173\b\61\4\2\u0173b\3\2\2\2\u0174\u0176"+
		"\t\6\2\2\u0175\u0174\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u0175\3\2\2\2\u0177"+
		"\u0178\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017a\b\62\5\2\u017ad\3\2\2\2"+
		"\20\2lor|\u0082\u0142\u0147\u014e\u0154\u0162\u016a\u0170\u0177";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}