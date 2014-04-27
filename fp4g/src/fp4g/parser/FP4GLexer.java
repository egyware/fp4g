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
		SOURCE=28, AS=29, OTHER=30, EMPTY=31, ABRE_COR=32, ABRE_PAR=33, ABRE_LLAV=34, 
		CIERRA_COR=35, CIERRA_PAR=36, CIERRA_LLAV=37, COMA=38, EQUAL=39, DOT=40, 
		DOTCOMA=41, DOUBLEDOT=42, PLUS=43, MINUS=44, MULTIPLY=45, DIVIDE=46, MORE_THAN=47, 
		LESS_THAN=48, AND=49, OR=50, XOR=51, NOT=52, NUMBER_TYPE=53, STRING_TYPE=54, 
		BOOL_TYPE=55, DIRECTCODE=56, INT_LITERAL=57, DECIMAL_LITERAL=58, STRING_LITERAL=59, 
		BOOL_LITERAL=60, PARENT_LITERAL=61, CURRENT_LITERAL=62, ID=63, NL=64, 
		WS=65;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT", "'DEFINE'", "'ADD'", "'ON'", 
		"'SEND'", "'DESTROY'", "'GROUP'", "'SUBSCRIBE'", "'UNSUBSCRIBE'", "'RESUME'", 
		"'PAUSE'", "'USING'", "'EXIT'", "'SET'", "'START'", "'ASSETS'", "'MANAGER'", 
		"'GAME'", "'STATE'", "'ASSET'", "'BEHAVIOR'", "'ENTITY'", "'GOAL'", "'MESSAGE'", 
		"'BASE'", "'TO'", "'SOURCE'", "'AS'", "'OTHER'", "'EMPTY'", "'['", "'('", 
		"'{'", "']'", "')'", "'}'", "','", "'='", "'.'", "';'", "':'", "'+'", 
		"'-'", "'*'", "'/'", "'>'", "'<'", "'AND'", "'OR'", "'XOR'", "'NOT'", 
		"'Number'", "'String'", "'Bool'", "DIRECTCODE", "INT_LITERAL", "DECIMAL_LITERAL", 
		"STRING_LITERAL", "BOOL_LITERAL", "'parent'", "'current'", "ID", "NL", 
		"WS"
	};
	public static final String[] ruleNames = {
		"SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT", "DEFINE", "ADD", "ON", "SEND", 
		"DESTROY", "GROUP", "SUBSCRIBE", "UNSUBSCRIBE", "RESUME", "PAUSE", "USING", 
		"EXIT", "SET", "START", "ASSETS", "MANAGER", "GAME", "STATE", "ASSET", 
		"BEHAVIOR", "ENTITY", "GOAL", "MESSAGE", "BASE", "TO", "SOURCE", "AS", 
		"OTHER", "EMPTY", "ABRE_COR", "ABRE_PAR", "ABRE_LLAV", "CIERRA_COR", "CIERRA_PAR", 
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

		case 64: NL_action((RuleContext)_localctx, actionIndex); break;

		case 65: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2C\u01f6\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\3\2\3\2\3\2\3\2\3\2\7\2\u008d\n\2"+
		"\f\2\16\2\u0090\13\2\5\2\u0092\n\2\3\2\5\2\u0095\n\2\3\2\3\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\7\3\u009f\n\3\f\3\16\3\u00a2\13\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7"+
		"\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3"+
		"\33\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3"+
		"\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3!\3!\3"+
		"\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3"+
		"-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\62\3\62\3\63\3\63\3\63"+
		"\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\66"+
		"\3\66\3\67\3\67\3\67\3\67\3\67\3\67\3\67\38\38\38\38\38\39\39\39\39\7"+
		"9\u01a5\n9\f9\169\u01a8\139\39\39\3:\6:\u01ad\n:\r:\16:\u01ae\3;\7;\u01b2"+
		"\n;\f;\16;\u01b5\13;\3;\3;\6;\u01b9\n;\r;\16;\u01ba\3<\3<\7<\u01bf\n<"+
		"\f<\16<\u01c2\13<\3<\3<\3=\3=\3=\3=\3=\3=\3=\3=\3=\5=\u01cf\n=\3>\3>\3"+
		">\3>\3>\3>\3>\3?\3?\3?\3?\3?\3?\3?\3?\3@\3@\3A\3A\7A\u01e4\nA\fA\16A\u01e7"+
		"\13A\3B\6B\u01ea\nB\rB\16B\u01eb\3B\3B\3C\6C\u01f1\nC\rC\16C\u01f2\3C"+
		"\3C\6\u008e\u00a0\u01a6\u01c0D\3\3\2\5\4\3\7\5\1\t\6\1\13\7\1\r\b\1\17"+
		"\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22"+
		"\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1"+
		"\67\35\19\36\1;\37\1= \1?!\1A\"\1C#\1E$\1G%\1I&\1K\'\1M(\1O)\1Q*\1S+\1"+
		"U,\1W-\1Y.\1[/\1]\60\1_\61\1a\62\1c\63\1e\64\1g\65\1i\66\1k\67\1m8\1o"+
		"9\1q:\1s;\1u<\1w=\1y>\1{?\1}@\1\177\2\1\u0081A\1\u0083B\4\u0085C\5\3\2"+
		"\7\4\2\f\f\17\17\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\4\2\13\13\"\"\u0201"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3"+
		"\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2"+
		"\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2"+
		"{\3\2\2\2\2}\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\3"+
		"\u0087\3\2\2\2\5\u009a\3\2\2\2\7\u00a8\3\2\2\2\t\u00af\3\2\2\2\13\u00b3"+
		"\3\2\2\2\r\u00b6\3\2\2\2\17\u00bb\3\2\2\2\21\u00c3\3\2\2\2\23\u00c9\3"+
		"\2\2\2\25\u00d3\3\2\2\2\27\u00df\3\2\2\2\31\u00e6\3\2\2\2\33\u00ec\3\2"+
		"\2\2\35\u00f2\3\2\2\2\37\u00f7\3\2\2\2!\u00fb\3\2\2\2#\u0101\3\2\2\2%"+
		"\u0108\3\2\2\2\'\u0110\3\2\2\2)\u0115\3\2\2\2+\u011b\3\2\2\2-\u0121\3"+
		"\2\2\2/\u012a\3\2\2\2\61\u0131\3\2\2\2\63\u0136\3\2\2\2\65\u013e\3\2\2"+
		"\2\67\u0143\3\2\2\29\u0146\3\2\2\2;\u014d\3\2\2\2=\u0150\3\2\2\2?\u0156"+
		"\3\2\2\2A\u015c\3\2\2\2C\u015e\3\2\2\2E\u0160\3\2\2\2G\u0162\3\2\2\2I"+
		"\u0164\3\2\2\2K\u0166\3\2\2\2M\u0168\3\2\2\2O\u016a\3\2\2\2Q\u016c\3\2"+
		"\2\2S\u016e\3\2\2\2U\u0170\3\2\2\2W\u0172\3\2\2\2Y\u0174\3\2\2\2[\u0176"+
		"\3\2\2\2]\u0178\3\2\2\2_\u017a\3\2\2\2a\u017c\3\2\2\2c\u017e\3\2\2\2e"+
		"\u0182\3\2\2\2g\u0185\3\2\2\2i\u0189\3\2\2\2k\u018d\3\2\2\2m\u0194\3\2"+
		"\2\2o\u019b\3\2\2\2q\u01a0\3\2\2\2s\u01ac\3\2\2\2u\u01b3\3\2\2\2w\u01bc"+
		"\3\2\2\2y\u01ce\3\2\2\2{\u01d0\3\2\2\2}\u01d7\3\2\2\2\177\u01df\3\2\2"+
		"\2\u0081\u01e1\3\2\2\2\u0083\u01e9\3\2\2\2\u0085\u01f0\3\2\2\2\u0087\u0088"+
		"\7\61\2\2\u0088\u0089\7\61\2\2\u0089\u0091\3\2\2\2\u008a\u0092\t\2\2\2"+
		"\u008b\u008d\13\2\2\2\u008c\u008b\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008f"+
		"\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0091"+
		"\u008a\3\2\2\2\u0091\u008e\3\2\2\2\u0092\u0094\3\2\2\2\u0093\u0095\7\17"+
		"\2\2\u0094\u0093\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\3\2\2\2\u0096"+
		"\u0097\7\f\2\2\u0097\u0098\3\2\2\2\u0098\u0099\b\2\2\2\u0099\4\3\2\2\2"+
		"\u009a\u009b\7\61\2\2\u009b\u009c\7,\2\2\u009c\u00a0\3\2\2\2\u009d\u009f"+
		"\13\2\2\2\u009e\u009d\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u00a1\3\2\2\2"+
		"\u00a0\u009e\3\2\2\2\u00a1\u00a3\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a4"+
		"\7,\2\2\u00a4\u00a5\7\61\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\b\3\3\2\u00a7"+
		"\6\3\2\2\2\u00a8\u00a9\7F\2\2\u00a9\u00aa\7G\2\2\u00aa\u00ab\7H\2\2\u00ab"+
		"\u00ac\7K\2\2\u00ac\u00ad\7P\2\2\u00ad\u00ae\7G\2\2\u00ae\b\3\2\2\2\u00af"+
		"\u00b0\7C\2\2\u00b0\u00b1\7F\2\2\u00b1\u00b2\7F\2\2\u00b2\n\3\2\2\2\u00b3"+
		"\u00b4\7Q\2\2\u00b4\u00b5\7P\2\2\u00b5\f\3\2\2\2\u00b6\u00b7\7U\2\2\u00b7"+
		"\u00b8\7G\2\2\u00b8\u00b9\7P\2\2\u00b9\u00ba\7F\2\2\u00ba\16\3\2\2\2\u00bb"+
		"\u00bc\7F\2\2\u00bc\u00bd\7G\2\2\u00bd\u00be\7U\2\2\u00be\u00bf\7V\2\2"+
		"\u00bf\u00c0\7T\2\2\u00c0\u00c1\7Q\2\2\u00c1\u00c2\7[\2\2\u00c2\20\3\2"+
		"\2\2\u00c3\u00c4\7I\2\2\u00c4\u00c5\7T\2\2\u00c5\u00c6\7Q\2\2\u00c6\u00c7"+
		"\7W\2\2\u00c7\u00c8\7R\2\2\u00c8\22\3\2\2\2\u00c9\u00ca\7U\2\2\u00ca\u00cb"+
		"\7W\2\2\u00cb\u00cc\7D\2\2\u00cc\u00cd\7U\2\2\u00cd\u00ce\7E\2\2\u00ce"+
		"\u00cf\7T\2\2\u00cf\u00d0\7K\2\2\u00d0\u00d1\7D\2\2\u00d1\u00d2\7G\2\2"+
		"\u00d2\24\3\2\2\2\u00d3\u00d4\7W\2\2\u00d4\u00d5\7P\2\2\u00d5\u00d6\7"+
		"U\2\2\u00d6\u00d7\7W\2\2\u00d7\u00d8\7D\2\2\u00d8\u00d9\7U\2\2\u00d9\u00da"+
		"\7E\2\2\u00da\u00db\7T\2\2\u00db\u00dc\7K\2\2\u00dc\u00dd\7D\2\2\u00dd"+
		"\u00de\7G\2\2\u00de\26\3\2\2\2\u00df\u00e0\7T\2\2\u00e0\u00e1\7G\2\2\u00e1"+
		"\u00e2\7U\2\2\u00e2\u00e3\7W\2\2\u00e3\u00e4\7O\2\2\u00e4\u00e5\7G\2\2"+
		"\u00e5\30\3\2\2\2\u00e6\u00e7\7R\2\2\u00e7\u00e8\7C\2\2\u00e8\u00e9\7"+
		"W\2\2\u00e9\u00ea\7U\2\2\u00ea\u00eb\7G\2\2\u00eb\32\3\2\2\2\u00ec\u00ed"+
		"\7W\2\2\u00ed\u00ee\7U\2\2\u00ee\u00ef\7K\2\2\u00ef\u00f0\7P\2\2\u00f0"+
		"\u00f1\7I\2\2\u00f1\34\3\2\2\2\u00f2\u00f3\7G\2\2\u00f3\u00f4\7Z\2\2\u00f4"+
		"\u00f5\7K\2\2\u00f5\u00f6\7V\2\2\u00f6\36\3\2\2\2\u00f7\u00f8\7U\2\2\u00f8"+
		"\u00f9\7G\2\2\u00f9\u00fa\7V\2\2\u00fa \3\2\2\2\u00fb\u00fc\7U\2\2\u00fc"+
		"\u00fd\7V\2\2\u00fd\u00fe\7C\2\2\u00fe\u00ff\7T\2\2\u00ff\u0100\7V\2\2"+
		"\u0100\"\3\2\2\2\u0101\u0102\7C\2\2\u0102\u0103\7U\2\2\u0103\u0104\7U"+
		"\2\2\u0104\u0105\7G\2\2\u0105\u0106\7V\2\2\u0106\u0107\7U\2\2\u0107$\3"+
		"\2\2\2\u0108\u0109\7O\2\2\u0109\u010a\7C\2\2\u010a\u010b\7P\2\2\u010b"+
		"\u010c\7C\2\2\u010c\u010d\7I\2\2\u010d\u010e\7G\2\2\u010e\u010f\7T\2\2"+
		"\u010f&\3\2\2\2\u0110\u0111\7I\2\2\u0111\u0112\7C\2\2\u0112\u0113\7O\2"+
		"\2\u0113\u0114\7G\2\2\u0114(\3\2\2\2\u0115\u0116\7U\2\2\u0116\u0117\7"+
		"V\2\2\u0117\u0118\7C\2\2\u0118\u0119\7V\2\2\u0119\u011a\7G\2\2\u011a*"+
		"\3\2\2\2\u011b\u011c\7C\2\2\u011c\u011d\7U\2\2\u011d\u011e\7U\2\2\u011e"+
		"\u011f\7G\2\2\u011f\u0120\7V\2\2\u0120,\3\2\2\2\u0121\u0122\7D\2\2\u0122"+
		"\u0123\7G\2\2\u0123\u0124\7J\2\2\u0124\u0125\7C\2\2\u0125\u0126\7X\2\2"+
		"\u0126\u0127\7K\2\2\u0127\u0128\7Q\2\2\u0128\u0129\7T\2\2\u0129.\3\2\2"+
		"\2\u012a\u012b\7G\2\2\u012b\u012c\7P\2\2\u012c\u012d\7V\2\2\u012d\u012e"+
		"\7K\2\2\u012e\u012f\7V\2\2\u012f\u0130\7[\2\2\u0130\60\3\2\2\2\u0131\u0132"+
		"\7I\2\2\u0132\u0133\7Q\2\2\u0133\u0134\7C\2\2\u0134\u0135\7N\2\2\u0135"+
		"\62\3\2\2\2\u0136\u0137\7O\2\2\u0137\u0138\7G\2\2\u0138\u0139\7U\2\2\u0139"+
		"\u013a\7U\2\2\u013a\u013b\7C\2\2\u013b\u013c\7I\2\2\u013c\u013d\7G\2\2"+
		"\u013d\64\3\2\2\2\u013e\u013f\7D\2\2\u013f\u0140\7C\2\2\u0140\u0141\7"+
		"U\2\2\u0141\u0142\7G\2\2\u0142\66\3\2\2\2\u0143\u0144\7V\2\2\u0144\u0145"+
		"\7Q\2\2\u01458\3\2\2\2\u0146\u0147\7U\2\2\u0147\u0148\7Q\2\2\u0148\u0149"+
		"\7W\2\2\u0149\u014a\7T\2\2\u014a\u014b\7E\2\2\u014b\u014c\7G\2\2\u014c"+
		":\3\2\2\2\u014d\u014e\7C\2\2\u014e\u014f\7U\2\2\u014f<\3\2\2\2\u0150\u0151"+
		"\7Q\2\2\u0151\u0152\7V\2\2\u0152\u0153\7J\2\2\u0153\u0154\7G\2\2\u0154"+
		"\u0155\7T\2\2\u0155>\3\2\2\2\u0156\u0157\7G\2\2\u0157\u0158\7O\2\2\u0158"+
		"\u0159\7R\2\2\u0159\u015a\7V\2\2\u015a\u015b\7[\2\2\u015b@\3\2\2\2\u015c"+
		"\u015d\7]\2\2\u015dB\3\2\2\2\u015e\u015f\7*\2\2\u015fD\3\2\2\2\u0160\u0161"+
		"\7}\2\2\u0161F\3\2\2\2\u0162\u0163\7_\2\2\u0163H\3\2\2\2\u0164\u0165\7"+
		"+\2\2\u0165J\3\2\2\2\u0166\u0167\7\177\2\2\u0167L\3\2\2\2\u0168\u0169"+
		"\7.\2\2\u0169N\3\2\2\2\u016a\u016b\7?\2\2\u016bP\3\2\2\2\u016c\u016d\7"+
		"\60\2\2\u016dR\3\2\2\2\u016e\u016f\7=\2\2\u016fT\3\2\2\2\u0170\u0171\7"+
		"<\2\2\u0171V\3\2\2\2\u0172\u0173\7-\2\2\u0173X\3\2\2\2\u0174\u0175\7/"+
		"\2\2\u0175Z\3\2\2\2\u0176\u0177\7,\2\2\u0177\\\3\2\2\2\u0178\u0179\7\61"+
		"\2\2\u0179^\3\2\2\2\u017a\u017b\7@\2\2\u017b`\3\2\2\2\u017c\u017d\7>\2"+
		"\2\u017db\3\2\2\2\u017e\u017f\7C\2\2\u017f\u0180\7P\2\2\u0180\u0181\7"+
		"F\2\2\u0181d\3\2\2\2\u0182\u0183\7Q\2\2\u0183\u0184\7T\2\2\u0184f\3\2"+
		"\2\2\u0185\u0186\7Z\2\2\u0186\u0187\7Q\2\2\u0187\u0188\7T\2\2\u0188h\3"+
		"\2\2\2\u0189\u018a\7P\2\2\u018a\u018b\7Q\2\2\u018b\u018c\7V\2\2\u018c"+
		"j\3\2\2\2\u018d\u018e\7P\2\2\u018e\u018f\7w\2\2\u018f\u0190\7o\2\2\u0190"+
		"\u0191\7d\2\2\u0191\u0192\7g\2\2\u0192\u0193\7t\2\2\u0193l\3\2\2\2\u0194"+
		"\u0195\7U\2\2\u0195\u0196\7v\2\2\u0196\u0197\7t\2\2\u0197\u0198\7k\2\2"+
		"\u0198\u0199\7p\2\2\u0199\u019a\7i\2\2\u019an\3\2\2\2\u019b\u019c\7D\2"+
		"\2\u019c\u019d\7q\2\2\u019d\u019e\7q\2\2\u019e\u019f\7n\2\2\u019fp\3\2"+
		"\2\2\u01a0\u01a1\7B\2\2\u01a1\u01a2\7)\2\2\u01a2\u01a6\3\2\2\2\u01a3\u01a5"+
		"\13\2\2\2\u01a4\u01a3\3\2\2\2\u01a5\u01a8\3\2\2\2\u01a6\u01a7\3\2\2\2"+
		"\u01a6\u01a4\3\2\2\2\u01a7\u01a9\3\2\2\2\u01a8\u01a6\3\2\2\2\u01a9\u01aa"+
		"\7)\2\2\u01aar\3\2\2\2\u01ab\u01ad\5\177@\2\u01ac\u01ab\3\2\2\2\u01ad"+
		"\u01ae\3\2\2\2\u01ae\u01ac\3\2\2\2\u01ae\u01af\3\2\2\2\u01aft\3\2\2\2"+
		"\u01b0\u01b2\5\177@\2\u01b1\u01b0\3\2\2\2\u01b2\u01b5\3\2\2\2\u01b3\u01b1"+
		"\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01b6\3\2\2\2\u01b5\u01b3\3\2\2\2\u01b6"+
		"\u01b8\7\60\2\2\u01b7\u01b9\5\177@\2\u01b8\u01b7\3\2\2\2\u01b9\u01ba\3"+
		"\2\2\2\u01ba\u01b8\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bbv\3\2\2\2\u01bc\u01c0"+
		"\7$\2\2\u01bd\u01bf\13\2\2\2\u01be\u01bd\3\2\2\2\u01bf\u01c2\3\2\2\2\u01c0"+
		"\u01c1\3\2\2\2\u01c0\u01be\3\2\2\2\u01c1\u01c3\3\2\2\2\u01c2\u01c0\3\2"+
		"\2\2\u01c3\u01c4\7$\2\2\u01c4x\3\2\2\2\u01c5\u01c6\7v\2\2\u01c6\u01c7"+
		"\7t\2\2\u01c7\u01c8\7w\2\2\u01c8\u01cf\7g\2\2\u01c9\u01ca\7h\2\2\u01ca"+
		"\u01cb\7c\2\2\u01cb\u01cc\7n\2\2\u01cc\u01cd\7u\2\2\u01cd\u01cf\7g\2\2"+
		"\u01ce\u01c5\3\2\2\2\u01ce\u01c9\3\2\2\2\u01cfz\3\2\2\2\u01d0\u01d1\7"+
		"r\2\2\u01d1\u01d2\7c\2\2\u01d2\u01d3\7t\2\2\u01d3\u01d4\7g\2\2\u01d4\u01d5"+
		"\7p\2\2\u01d5\u01d6\7v\2\2\u01d6|\3\2\2\2\u01d7\u01d8\7e\2\2\u01d8\u01d9"+
		"\7w\2\2\u01d9\u01da\7t\2\2\u01da\u01db\7t\2\2\u01db\u01dc\7g\2\2\u01dc"+
		"\u01dd\7p\2\2\u01dd\u01de\7v\2\2\u01de~\3\2\2\2\u01df\u01e0\t\3\2\2\u01e0"+
		"\u0080\3\2\2\2\u01e1\u01e5\t\4\2\2\u01e2\u01e4\t\5\2\2\u01e3\u01e2\3\2"+
		"\2\2\u01e4\u01e7\3\2\2\2\u01e5\u01e3\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6"+
		"\u0082\3\2\2\2\u01e7\u01e5\3\2\2\2\u01e8\u01ea\t\2\2\2\u01e9\u01e8\3\2"+
		"\2\2\u01ea\u01eb\3\2\2\2\u01eb\u01e9\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec"+
		"\u01ed\3\2\2\2\u01ed\u01ee\bB\4\2\u01ee\u0084\3\2\2\2\u01ef\u01f1\t\6"+
		"\2\2\u01f0\u01ef\3\2\2\2\u01f1\u01f2\3\2\2\2\u01f2\u01f0\3\2\2\2\u01f2"+
		"\u01f3\3\2\2\2\u01f3\u01f4\3\2\2\2\u01f4\u01f5\bC\5\2\u01f5\u0086\3\2"+
		"\2\2\20\2\u008e\u0091\u0094\u00a0\u01a6\u01ae\u01b3\u01ba\u01c0\u01ce"+
		"\u01e5\u01eb\u01f2";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}