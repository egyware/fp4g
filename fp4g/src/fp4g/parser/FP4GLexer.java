// Generated from C:\Users\Edgardo\Git\fp4g-src\fp4g\src/fp4g/parser/FP4G.g4 by ANTLR 4.1

package fp4g.parser;

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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT", "'DEFINE'", "'ADD'", "'ON'", 
		"'SEND'", "'DESTROY'", "'GROUP'", "'SUBSCRIBE'", "'UNSUBSCRIBE'", "'RESUME'", 
		"'PAUSE'", "'USING'", "'EXIT'", "'SET'", "'START'", "'ASSETS'", "'MANAGER'", 
		"'GAME'", "'STATE'", "'ASSET'", "'BEHAVIOR'", "'ENTITY'", "'GOAL'", "'MESSAGE'", 
		"'BASE'", "'TO'", "'SOURCE'", "'AS'", "'OTHER'", "'['", "'('", "'{'", 
		"']'", "')'", "'}'", "','", "'='", "'.'", "';'", "':'", "'+'", "'-'", 
		"'*'", "'/'", "'>'", "'<'", "'AND'", "'OR'", "'XOR'", "'NOT'", "'Number'", 
		"'String'", "'Bool'", "DIRECTCODE", "INT_LITERAL", "DECIMAL_LITERAL", 
		"STRING_LITERAL", "BOOL_LITERAL", "'parent'", "'current'", "ID", "NL", 
		"WS"
	};
	public static final String[] ruleNames = {
		"SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT", "DEFINE", "ADD", "ON", "SEND", 
		"DESTROY", "GROUP", "SUBSCRIBE", "UNSUBSCRIBE", "RESUME", "PAUSE", "USING", 
		"EXIT", "SET", "START", "ASSETS", "MANAGER", "GAME", "STATE", "ASSET", 
		"BEHAVIOR", "ENTITY", "GOAL", "MESSAGE", "BASE", "TO", "SOURCE", "AS", 
		"OTHER", "ABRE_COR", "ABRE_PAR", "ABRE_LLAV", "CIERRA_COR", "CIERRA_PAR", 
		"CIERRA_LLAV", "COMA", "EQUAL", "DOT", "DOTCOMA", "DOUBLEDOT", "PLUS", 
		"MINUS", "MULTIPLY", "DIVIDE", "MORE_THAN", "LESS_THAN", "AND", "OR", 
		"XOR", "NOT", "NUMBER_TYPE", "STRING_TYPE", "BOOL_TYPE", "DIRECTCODE", 
		"INT_LITERAL", "DECIMAL_LITERAL", "STRING_LITERAL", "BOOL_LITERAL", "PARENT_LITERAL", 
		"CURRENT_LITERAL", "DIGIT", "ID", "NL", "WS"
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

		case 63: NL_action((RuleContext)_localctx, actionIndex); break;

		case 64: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2B\u01ee\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\3\2\3\2\3\2\3\2\3\2\7\2\u008b\n\2\f\2\16"+
		"\2\u008e\13\2\5\2\u0090\n\2\3\2\5\2\u0093\n\2\3\2\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\7\3\u009d\n\3\f\3\16\3\u00a0\13\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3"+
		"\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3"+
		"\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3"+
		"\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3"+
		"\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3"+
		"$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/"+
		"\3\60\3\60\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\64"+
		"\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66"+
		"\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\38\38\38\38\78\u019d\n8\f8\16"+
		"8\u01a0\138\38\38\39\69\u01a5\n9\r9\169\u01a6\3:\7:\u01aa\n:\f:\16:\u01ad"+
		"\13:\3:\3:\6:\u01b1\n:\r:\16:\u01b2\3;\3;\7;\u01b7\n;\f;\16;\u01ba\13"+
		";\3;\3;\3<\3<\3<\3<\3<\3<\3<\3<\3<\5<\u01c7\n<\3=\3=\3=\3=\3=\3=\3=\3"+
		">\3>\3>\3>\3>\3>\3>\3>\3?\3?\3@\3@\7@\u01dc\n@\f@\16@\u01df\13@\3A\6A"+
		"\u01e2\nA\rA\16A\u01e3\3A\3A\3B\6B\u01e9\nB\rB\16B\u01ea\3B\3B\6\u008c"+
		"\u009e\u019e\u01b8C\3\3\2\5\4\3\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1"+
		"\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24"+
		"\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1\67\35\19\36"+
		"\1;\37\1= \1?!\1A\"\1C#\1E$\1G%\1I&\1K\'\1M(\1O)\1Q*\1S+\1U,\1W-\1Y.\1"+
		"[/\1]\60\1_\61\1a\62\1c\63\1e\64\1g\65\1i\66\1k\67\1m8\1o9\1q:\1s;\1u"+
		"<\1w=\1y>\1{?\1}\2\1\177@\1\u0081A\4\u0083B\5\3\2\7\4\2\f\f\17\17\3\2"+
		"\62;\5\2C\\aac|\6\2\62;C\\aac|\4\2\13\13\"\"\u01f9\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2"+
		"Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3"+
		"\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2"+
		"\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2\177\3\2\2"+
		"\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\3\u0085\3\2\2\2\5\u0098\3\2\2\2\7\u00a6"+
		"\3\2\2\2\t\u00ad\3\2\2\2\13\u00b1\3\2\2\2\r\u00b4\3\2\2\2\17\u00b9\3\2"+
		"\2\2\21\u00c1\3\2\2\2\23\u00c7\3\2\2\2\25\u00d1\3\2\2\2\27\u00dd\3\2\2"+
		"\2\31\u00e4\3\2\2\2\33\u00ea\3\2\2\2\35\u00f0\3\2\2\2\37\u00f5\3\2\2\2"+
		"!\u00f9\3\2\2\2#\u00ff\3\2\2\2%\u0106\3\2\2\2\'\u010e\3\2\2\2)\u0113\3"+
		"\2\2\2+\u0119\3\2\2\2-\u011f\3\2\2\2/\u0128\3\2\2\2\61\u012f\3\2\2\2\63"+
		"\u0134\3\2\2\2\65\u013c\3\2\2\2\67\u0141\3\2\2\29\u0144\3\2\2\2;\u014b"+
		"\3\2\2\2=\u014e\3\2\2\2?\u0154\3\2\2\2A\u0156\3\2\2\2C\u0158\3\2\2\2E"+
		"\u015a\3\2\2\2G\u015c\3\2\2\2I\u015e\3\2\2\2K\u0160\3\2\2\2M\u0162\3\2"+
		"\2\2O\u0164\3\2\2\2Q\u0166\3\2\2\2S\u0168\3\2\2\2U\u016a\3\2\2\2W\u016c"+
		"\3\2\2\2Y\u016e\3\2\2\2[\u0170\3\2\2\2]\u0172\3\2\2\2_\u0174\3\2\2\2a"+
		"\u0176\3\2\2\2c\u017a\3\2\2\2e\u017d\3\2\2\2g\u0181\3\2\2\2i\u0185\3\2"+
		"\2\2k\u018c\3\2\2\2m\u0193\3\2\2\2o\u0198\3\2\2\2q\u01a4\3\2\2\2s\u01ab"+
		"\3\2\2\2u\u01b4\3\2\2\2w\u01c6\3\2\2\2y\u01c8\3\2\2\2{\u01cf\3\2\2\2}"+
		"\u01d7\3\2\2\2\177\u01d9\3\2\2\2\u0081\u01e1\3\2\2\2\u0083\u01e8\3\2\2"+
		"\2\u0085\u0086\7\61\2\2\u0086\u0087\7\61\2\2\u0087\u008f\3\2\2\2\u0088"+
		"\u0090\t\2\2\2\u0089\u008b\13\2\2\2\u008a\u0089\3\2\2\2\u008b\u008e\3"+
		"\2\2\2\u008c\u008d\3\2\2\2\u008c\u008a\3\2\2\2\u008d\u0090\3\2\2\2\u008e"+
		"\u008c\3\2\2\2\u008f\u0088\3\2\2\2\u008f\u008c\3\2\2\2\u0090\u0092\3\2"+
		"\2\2\u0091\u0093\7\17\2\2\u0092\u0091\3\2\2\2\u0092\u0093\3\2\2\2\u0093"+
		"\u0094\3\2\2\2\u0094\u0095\7\f\2\2\u0095\u0096\3\2\2\2\u0096\u0097\b\2"+
		"\2\2\u0097\4\3\2\2\2\u0098\u0099\7\61\2\2\u0099\u009a\7,\2\2\u009a\u009e"+
		"\3\2\2\2\u009b\u009d\13\2\2\2\u009c\u009b\3\2\2\2\u009d\u00a0\3\2\2\2"+
		"\u009e\u009f\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a1\3\2\2\2\u00a0\u009e"+
		"\3\2\2\2\u00a1\u00a2\7,\2\2\u00a2\u00a3\7\61\2\2\u00a3\u00a4\3\2\2\2\u00a4"+
		"\u00a5\b\3\3\2\u00a5\6\3\2\2\2\u00a6\u00a7\7F\2\2\u00a7\u00a8\7G\2\2\u00a8"+
		"\u00a9\7H\2\2\u00a9\u00aa\7K\2\2\u00aa\u00ab\7P\2\2\u00ab\u00ac\7G\2\2"+
		"\u00ac\b\3\2\2\2\u00ad\u00ae\7C\2\2\u00ae\u00af\7F\2\2\u00af\u00b0\7F"+
		"\2\2\u00b0\n\3\2\2\2\u00b1\u00b2\7Q\2\2\u00b2\u00b3\7P\2\2\u00b3\f\3\2"+
		"\2\2\u00b4\u00b5\7U\2\2\u00b5\u00b6\7G\2\2\u00b6\u00b7\7P\2\2\u00b7\u00b8"+
		"\7F\2\2\u00b8\16\3\2\2\2\u00b9\u00ba\7F\2\2\u00ba\u00bb\7G\2\2\u00bb\u00bc"+
		"\7U\2\2\u00bc\u00bd\7V\2\2\u00bd\u00be\7T\2\2\u00be\u00bf\7Q\2\2\u00bf"+
		"\u00c0\7[\2\2\u00c0\20\3\2\2\2\u00c1\u00c2\7I\2\2\u00c2\u00c3\7T\2\2\u00c3"+
		"\u00c4\7Q\2\2\u00c4\u00c5\7W\2\2\u00c5\u00c6\7R\2\2\u00c6\22\3\2\2\2\u00c7"+
		"\u00c8\7U\2\2\u00c8\u00c9\7W\2\2\u00c9\u00ca\7D\2\2\u00ca\u00cb\7U\2\2"+
		"\u00cb\u00cc\7E\2\2\u00cc\u00cd\7T\2\2\u00cd\u00ce\7K\2\2\u00ce\u00cf"+
		"\7D\2\2\u00cf\u00d0\7G\2\2\u00d0\24\3\2\2\2\u00d1\u00d2\7W\2\2\u00d2\u00d3"+
		"\7P\2\2\u00d3\u00d4\7U\2\2\u00d4\u00d5\7W\2\2\u00d5\u00d6\7D\2\2\u00d6"+
		"\u00d7\7U\2\2\u00d7\u00d8\7E\2\2\u00d8\u00d9\7T\2\2\u00d9\u00da\7K\2\2"+
		"\u00da\u00db\7D\2\2\u00db\u00dc\7G\2\2\u00dc\26\3\2\2\2\u00dd\u00de\7"+
		"T\2\2\u00de\u00df\7G\2\2\u00df\u00e0\7U\2\2\u00e0\u00e1\7W\2\2\u00e1\u00e2"+
		"\7O\2\2\u00e2\u00e3\7G\2\2\u00e3\30\3\2\2\2\u00e4\u00e5\7R\2\2\u00e5\u00e6"+
		"\7C\2\2\u00e6\u00e7\7W\2\2\u00e7\u00e8\7U\2\2\u00e8\u00e9\7G\2\2\u00e9"+
		"\32\3\2\2\2\u00ea\u00eb\7W\2\2\u00eb\u00ec\7U\2\2\u00ec\u00ed\7K\2\2\u00ed"+
		"\u00ee\7P\2\2\u00ee\u00ef\7I\2\2\u00ef\34\3\2\2\2\u00f0\u00f1\7G\2\2\u00f1"+
		"\u00f2\7Z\2\2\u00f2\u00f3\7K\2\2\u00f3\u00f4\7V\2\2\u00f4\36\3\2\2\2\u00f5"+
		"\u00f6\7U\2\2\u00f6\u00f7\7G\2\2\u00f7\u00f8\7V\2\2\u00f8 \3\2\2\2\u00f9"+
		"\u00fa\7U\2\2\u00fa\u00fb\7V\2\2\u00fb\u00fc\7C\2\2\u00fc\u00fd\7T\2\2"+
		"\u00fd\u00fe\7V\2\2\u00fe\"\3\2\2\2\u00ff\u0100\7C\2\2\u0100\u0101\7U"+
		"\2\2\u0101\u0102\7U\2\2\u0102\u0103\7G\2\2\u0103\u0104\7V\2\2\u0104\u0105"+
		"\7U\2\2\u0105$\3\2\2\2\u0106\u0107\7O\2\2\u0107\u0108\7C\2\2\u0108\u0109"+
		"\7P\2\2\u0109\u010a\7C\2\2\u010a\u010b\7I\2\2\u010b\u010c\7G\2\2\u010c"+
		"\u010d\7T\2\2\u010d&\3\2\2\2\u010e\u010f\7I\2\2\u010f\u0110\7C\2\2\u0110"+
		"\u0111\7O\2\2\u0111\u0112\7G\2\2\u0112(\3\2\2\2\u0113\u0114\7U\2\2\u0114"+
		"\u0115\7V\2\2\u0115\u0116\7C\2\2\u0116\u0117\7V\2\2\u0117\u0118\7G\2\2"+
		"\u0118*\3\2\2\2\u0119\u011a\7C\2\2\u011a\u011b\7U\2\2\u011b\u011c\7U\2"+
		"\2\u011c\u011d\7G\2\2\u011d\u011e\7V\2\2\u011e,\3\2\2\2\u011f\u0120\7"+
		"D\2\2\u0120\u0121\7G\2\2\u0121\u0122\7J\2\2\u0122\u0123\7C\2\2\u0123\u0124"+
		"\7X\2\2\u0124\u0125\7K\2\2\u0125\u0126\7Q\2\2\u0126\u0127\7T\2\2\u0127"+
		".\3\2\2\2\u0128\u0129\7G\2\2\u0129\u012a\7P\2\2\u012a\u012b\7V\2\2\u012b"+
		"\u012c\7K\2\2\u012c\u012d\7V\2\2\u012d\u012e\7[\2\2\u012e\60\3\2\2\2\u012f"+
		"\u0130\7I\2\2\u0130\u0131\7Q\2\2\u0131\u0132\7C\2\2\u0132\u0133\7N\2\2"+
		"\u0133\62\3\2\2\2\u0134\u0135\7O\2\2\u0135\u0136\7G\2\2\u0136\u0137\7"+
		"U\2\2\u0137\u0138\7U\2\2\u0138\u0139\7C\2\2\u0139\u013a\7I\2\2\u013a\u013b"+
		"\7G\2\2\u013b\64\3\2\2\2\u013c\u013d\7D\2\2\u013d\u013e\7C\2\2\u013e\u013f"+
		"\7U\2\2\u013f\u0140\7G\2\2\u0140\66\3\2\2\2\u0141\u0142\7V\2\2\u0142\u0143"+
		"\7Q\2\2\u01438\3\2\2\2\u0144\u0145\7U\2\2\u0145\u0146\7Q\2\2\u0146\u0147"+
		"\7W\2\2\u0147\u0148\7T\2\2\u0148\u0149\7E\2\2\u0149\u014a\7G\2\2\u014a"+
		":\3\2\2\2\u014b\u014c\7C\2\2\u014c\u014d\7U\2\2\u014d<\3\2\2\2\u014e\u014f"+
		"\7Q\2\2\u014f\u0150\7V\2\2\u0150\u0151\7J\2\2\u0151\u0152\7G\2\2\u0152"+
		"\u0153\7T\2\2\u0153>\3\2\2\2\u0154\u0155\7]\2\2\u0155@\3\2\2\2\u0156\u0157"+
		"\7*\2\2\u0157B\3\2\2\2\u0158\u0159\7}\2\2\u0159D\3\2\2\2\u015a\u015b\7"+
		"_\2\2\u015bF\3\2\2\2\u015c\u015d\7+\2\2\u015dH\3\2\2\2\u015e\u015f\7\177"+
		"\2\2\u015fJ\3\2\2\2\u0160\u0161\7.\2\2\u0161L\3\2\2\2\u0162\u0163\7?\2"+
		"\2\u0163N\3\2\2\2\u0164\u0165\7\60\2\2\u0165P\3\2\2\2\u0166\u0167\7=\2"+
		"\2\u0167R\3\2\2\2\u0168\u0169\7<\2\2\u0169T\3\2\2\2\u016a\u016b\7-\2\2"+
		"\u016bV\3\2\2\2\u016c\u016d\7/\2\2\u016dX\3\2\2\2\u016e\u016f\7,\2\2\u016f"+
		"Z\3\2\2\2\u0170\u0171\7\61\2\2\u0171\\\3\2\2\2\u0172\u0173\7@\2\2\u0173"+
		"^\3\2\2\2\u0174\u0175\7>\2\2\u0175`\3\2\2\2\u0176\u0177\7C\2\2\u0177\u0178"+
		"\7P\2\2\u0178\u0179\7F\2\2\u0179b\3\2\2\2\u017a\u017b\7Q\2\2\u017b\u017c"+
		"\7T\2\2\u017cd\3\2\2\2\u017d\u017e\7Z\2\2\u017e\u017f\7Q\2\2\u017f\u0180"+
		"\7T\2\2\u0180f\3\2\2\2\u0181\u0182\7P\2\2\u0182\u0183\7Q\2\2\u0183\u0184"+
		"\7V\2\2\u0184h\3\2\2\2\u0185\u0186\7P\2\2\u0186\u0187\7w\2\2\u0187\u0188"+
		"\7o\2\2\u0188\u0189\7d\2\2\u0189\u018a\7g\2\2\u018a\u018b\7t\2\2\u018b"+
		"j\3\2\2\2\u018c\u018d\7U\2\2\u018d\u018e\7v\2\2\u018e\u018f\7t\2\2\u018f"+
		"\u0190\7k\2\2\u0190\u0191\7p\2\2\u0191\u0192\7i\2\2\u0192l\3\2\2\2\u0193"+
		"\u0194\7D\2\2\u0194\u0195\7q\2\2\u0195\u0196\7q\2\2\u0196\u0197\7n\2\2"+
		"\u0197n\3\2\2\2\u0198\u0199\7B\2\2\u0199\u019a\7)\2\2\u019a\u019e\3\2"+
		"\2\2\u019b\u019d\13\2\2\2\u019c\u019b\3\2\2\2\u019d\u01a0\3\2\2\2\u019e"+
		"\u019f\3\2\2\2\u019e\u019c\3\2\2\2\u019f\u01a1\3\2\2\2\u01a0\u019e\3\2"+
		"\2\2\u01a1\u01a2\7)\2\2\u01a2p\3\2\2\2\u01a3\u01a5\5}?\2\u01a4\u01a3\3"+
		"\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a4\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7"+
		"r\3\2\2\2\u01a8\u01aa\5}?\2\u01a9\u01a8\3\2\2\2\u01aa\u01ad\3\2\2\2\u01ab"+
		"\u01a9\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac\u01ae\3\2\2\2\u01ad\u01ab\3\2"+
		"\2\2\u01ae\u01b0\7\60\2\2\u01af\u01b1\5}?\2\u01b0\u01af\3\2\2\2\u01b1"+
		"\u01b2\3\2\2\2\u01b2\u01b0\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3t\3\2\2\2"+
		"\u01b4\u01b8\7$\2\2\u01b5\u01b7\13\2\2\2\u01b6\u01b5\3\2\2\2\u01b7\u01ba"+
		"\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b8\u01b6\3\2\2\2\u01b9\u01bb\3\2\2\2\u01ba"+
		"\u01b8\3\2\2\2\u01bb\u01bc\7$\2\2\u01bcv\3\2\2\2\u01bd\u01be\7v\2\2\u01be"+
		"\u01bf\7t\2\2\u01bf\u01c0\7w\2\2\u01c0\u01c7\7g\2\2\u01c1\u01c2\7h\2\2"+
		"\u01c2\u01c3\7c\2\2\u01c3\u01c4\7n\2\2\u01c4\u01c5\7u\2\2\u01c5\u01c7"+
		"\7g\2\2\u01c6\u01bd\3\2\2\2\u01c6\u01c1\3\2\2\2\u01c7x\3\2\2\2\u01c8\u01c9"+
		"\7r\2\2\u01c9\u01ca\7c\2\2\u01ca\u01cb\7t\2\2\u01cb\u01cc\7g\2\2\u01cc"+
		"\u01cd\7p\2\2\u01cd\u01ce\7v\2\2\u01cez\3\2\2\2\u01cf\u01d0\7e\2\2\u01d0"+
		"\u01d1\7w\2\2\u01d1\u01d2\7t\2\2\u01d2\u01d3\7t\2\2\u01d3\u01d4\7g\2\2"+
		"\u01d4\u01d5\7p\2\2\u01d5\u01d6\7v\2\2\u01d6|\3\2\2\2\u01d7\u01d8\t\3"+
		"\2\2\u01d8~\3\2\2\2\u01d9\u01dd\t\4\2\2\u01da\u01dc\t\5\2\2\u01db\u01da"+
		"\3\2\2\2\u01dc\u01df\3\2\2\2\u01dd\u01db\3\2\2\2\u01dd\u01de\3\2\2\2\u01de"+
		"\u0080\3\2\2\2\u01df\u01dd\3\2\2\2\u01e0\u01e2\t\2\2\2\u01e1\u01e0\3\2"+
		"\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e1\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4"+
		"\u01e5\3\2\2\2\u01e5\u01e6\bA\4\2\u01e6\u0082\3\2\2\2\u01e7\u01e9\t\6"+
		"\2\2\u01e8\u01e7\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01e8\3\2\2\2\u01ea"+
		"\u01eb\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec\u01ed\bB\5\2\u01ed\u0084\3\2"+
		"\2\2\20\2\u008c\u008f\u0092\u009e\u019e\u01a6\u01ab\u01b2\u01b8\u01c6"+
		"\u01dd\u01e3\u01ea";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}