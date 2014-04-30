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
		BOOL_TYPE=55, INTEGER_TYPE=56, DOUBLE_TYPE=57, FLOAT_TYPE=58, DIRECTCODE=59, 
		INT_LITERAL=60, DECIMAL_LITERAL=61, STRING_LITERAL=62, BOOL_LITERAL=63, 
		PARENT_LITERAL=64, CURRENT_LITERAL=65, ID=66, NL=67, WS=68;
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
		"'Number'", "'String'", "'Bool'", "'Integer'", "'Double'", "'Float'", 
		"DIRECTCODE", "INT_LITERAL", "DECIMAL_LITERAL", "STRING_LITERAL", "BOOL_LITERAL", 
		"'parent'", "'current'", "ID", "NL", "WS"
	};
	public static final String[] ruleNames = {
		"SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT", "DEFINE", "ADD", "ON", "SEND", 
		"DESTROY", "GROUP", "SUBSCRIBE", "UNSUBSCRIBE", "RESUME", "PAUSE", "USING", 
		"EXIT", "SET", "START", "ASSETS", "MANAGER", "GAME", "STATE", "ASSET", 
		"BEHAVIOR", "ENTITY", "GOAL", "MESSAGE", "BASE", "TO", "SOURCE", "AS", 
		"OTHER", "EMPTY", "ABRE_COR", "ABRE_PAR", "ABRE_LLAV", "CIERRA_COR", "CIERRA_PAR", 
		"CIERRA_LLAV", "COMA", "EQUAL", "DOT", "DOTCOMA", "DOUBLEDOT", "PLUS", 
		"MINUS", "MULTIPLY", "DIVIDE", "MORE_THAN", "LESS_THAN", "AND", "OR", 
		"XOR", "NOT", "NUMBER_TYPE", "STRING_TYPE", "BOOL_TYPE", "INTEGER_TYPE", 
		"DOUBLE_TYPE", "FLOAT_TYPE", "DIRECTCODE", "INT_LITERAL", "DECIMAL_LITERAL", 
		"STRING_LITERAL", "BOOL_LITERAL", "PARENT_LITERAL", "CURRENT_LITERAL", 
		"DIGIT", "ID", "NL", "WS"
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

		case 67: NL_action((RuleContext)_localctx, actionIndex); break;

		case 68: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2F\u0211\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\3\2\3\2\3\2\3\2"+
		"\3\2\7\2\u0093\n\2\f\2\16\2\u0096\13\2\5\2\u0098\n\2\3\2\5\2\u009b\n\2"+
		"\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3\u00a5\n\3\f\3\16\3\u00a8\13\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24"+
		"\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 "+
		"\3 \3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3"+
		"*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\62"+
		"\3\62\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\66\3\66"+
		"\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67\3\67\38\38\38"+
		"\38\38\39\39\39\39\39\39\39\39\3:\3:\3:\3:\3:\3:\3:\3;\3;\3;\3;\3;\3;"+
		"\3<\3<\3<\3<\7<\u01c0\n<\f<\16<\u01c3\13<\3<\3<\3=\6=\u01c8\n=\r=\16="+
		"\u01c9\3>\7>\u01cd\n>\f>\16>\u01d0\13>\3>\3>\6>\u01d4\n>\r>\16>\u01d5"+
		"\3?\3?\7?\u01da\n?\f?\16?\u01dd\13?\3?\3?\3@\3@\3@\3@\3@\3@\3@\3@\3@\5"+
		"@\u01ea\n@\3A\3A\3A\3A\3A\3A\3A\3B\3B\3B\3B\3B\3B\3B\3B\3C\3C\3D\3D\7"+
		"D\u01ff\nD\fD\16D\u0202\13D\3E\6E\u0205\nE\rE\16E\u0206\3E\3E\3F\6F\u020c"+
		"\nF\rF\16F\u020d\3F\3F\6\u0094\u00a6\u01c1\u01dbG\3\3\2\5\4\3\7\5\1\t"+
		"\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1"+
		"\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32"+
		"\1\63\33\1\65\34\1\67\35\19\36\1;\37\1= \1?!\1A\"\1C#\1E$\1G%\1I&\1K\'"+
		"\1M(\1O)\1Q*\1S+\1U,\1W-\1Y.\1[/\1]\60\1_\61\1a\62\1c\63\1e\64\1g\65\1"+
		"i\66\1k\67\1m8\1o9\1q:\1s;\1u<\1w=\1y>\1{?\1}@\1\177A\1\u0081B\1\u0083"+
		"C\1\u0085\2\1\u0087D\1\u0089E\4\u008bF\5\3\2\7\4\2\f\f\17\17\3\2\62;\5"+
		"\2C\\aac|\6\2\62;C\\aac|\4\2\13\13\"\"\u021c\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2"+
		"M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3"+
		"\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2"+
		"\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2"+
		"s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177"+
		"\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2"+
		"\2\2\u008b\3\2\2\2\3\u008d\3\2\2\2\5\u00a0\3\2\2\2\7\u00ae\3\2\2\2\t\u00b5"+
		"\3\2\2\2\13\u00b9\3\2\2\2\r\u00bc\3\2\2\2\17\u00c1\3\2\2\2\21\u00c9\3"+
		"\2\2\2\23\u00cf\3\2\2\2\25\u00d9\3\2\2\2\27\u00e5\3\2\2\2\31\u00ec\3\2"+
		"\2\2\33\u00f2\3\2\2\2\35\u00f8\3\2\2\2\37\u00fd\3\2\2\2!\u0101\3\2\2\2"+
		"#\u0107\3\2\2\2%\u010e\3\2\2\2\'\u0116\3\2\2\2)\u011b\3\2\2\2+\u0121\3"+
		"\2\2\2-\u0127\3\2\2\2/\u0130\3\2\2\2\61\u0137\3\2\2\2\63\u013c\3\2\2\2"+
		"\65\u0144\3\2\2\2\67\u0149\3\2\2\29\u014c\3\2\2\2;\u0153\3\2\2\2=\u0156"+
		"\3\2\2\2?\u015c\3\2\2\2A\u0162\3\2\2\2C\u0164\3\2\2\2E\u0166\3\2\2\2G"+
		"\u0168\3\2\2\2I\u016a\3\2\2\2K\u016c\3\2\2\2M\u016e\3\2\2\2O\u0170\3\2"+
		"\2\2Q\u0172\3\2\2\2S\u0174\3\2\2\2U\u0176\3\2\2\2W\u0178\3\2\2\2Y\u017a"+
		"\3\2\2\2[\u017c\3\2\2\2]\u017e\3\2\2\2_\u0180\3\2\2\2a\u0182\3\2\2\2c"+
		"\u0184\3\2\2\2e\u0188\3\2\2\2g\u018b\3\2\2\2i\u018f\3\2\2\2k\u0193\3\2"+
		"\2\2m\u019a\3\2\2\2o\u01a1\3\2\2\2q\u01a6\3\2\2\2s\u01ae\3\2\2\2u\u01b5"+
		"\3\2\2\2w\u01bb\3\2\2\2y\u01c7\3\2\2\2{\u01ce\3\2\2\2}\u01d7\3\2\2\2\177"+
		"\u01e9\3\2\2\2\u0081\u01eb\3\2\2\2\u0083\u01f2\3\2\2\2\u0085\u01fa\3\2"+
		"\2\2\u0087\u01fc\3\2\2\2\u0089\u0204\3\2\2\2\u008b\u020b\3\2\2\2\u008d"+
		"\u008e\7\61\2\2\u008e\u008f\7\61\2\2\u008f\u0097\3\2\2\2\u0090\u0098\t"+
		"\2\2\2\u0091\u0093\13\2\2\2\u0092\u0091\3\2\2\2\u0093\u0096\3\2\2\2\u0094"+
		"\u0095\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0094\3\2"+
		"\2\2\u0097\u0090\3\2\2\2\u0097\u0094\3\2\2\2\u0098\u009a\3\2\2\2\u0099"+
		"\u009b\7\17\2\2\u009a\u0099\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\3"+
		"\2\2\2\u009c\u009d\7\f\2\2\u009d\u009e\3\2\2\2\u009e\u009f\b\2\2\2\u009f"+
		"\4\3\2\2\2\u00a0\u00a1\7\61\2\2\u00a1\u00a2\7,\2\2\u00a2\u00a6\3\2\2\2"+
		"\u00a3\u00a5\13\2\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a7"+
		"\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00a9\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9"+
		"\u00aa\7,\2\2\u00aa\u00ab\7\61\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\b\3"+
		"\3\2\u00ad\6\3\2\2\2\u00ae\u00af\7F\2\2\u00af\u00b0\7G\2\2\u00b0\u00b1"+
		"\7H\2\2\u00b1\u00b2\7K\2\2\u00b2\u00b3\7P\2\2\u00b3\u00b4\7G\2\2\u00b4"+
		"\b\3\2\2\2\u00b5\u00b6\7C\2\2\u00b6\u00b7\7F\2\2\u00b7\u00b8\7F\2\2\u00b8"+
		"\n\3\2\2\2\u00b9\u00ba\7Q\2\2\u00ba\u00bb\7P\2\2\u00bb\f\3\2\2\2\u00bc"+
		"\u00bd\7U\2\2\u00bd\u00be\7G\2\2\u00be\u00bf\7P\2\2\u00bf\u00c0\7F\2\2"+
		"\u00c0\16\3\2\2\2\u00c1\u00c2\7F\2\2\u00c2\u00c3\7G\2\2\u00c3\u00c4\7"+
		"U\2\2\u00c4\u00c5\7V\2\2\u00c5\u00c6\7T\2\2\u00c6\u00c7\7Q\2\2\u00c7\u00c8"+
		"\7[\2\2\u00c8\20\3\2\2\2\u00c9\u00ca\7I\2\2\u00ca\u00cb\7T\2\2\u00cb\u00cc"+
		"\7Q\2\2\u00cc\u00cd\7W\2\2\u00cd\u00ce\7R\2\2\u00ce\22\3\2\2\2\u00cf\u00d0"+
		"\7U\2\2\u00d0\u00d1\7W\2\2\u00d1\u00d2\7D\2\2\u00d2\u00d3\7U\2\2\u00d3"+
		"\u00d4\7E\2\2\u00d4\u00d5\7T\2\2\u00d5\u00d6\7K\2\2\u00d6\u00d7\7D\2\2"+
		"\u00d7\u00d8\7G\2\2\u00d8\24\3\2\2\2\u00d9\u00da\7W\2\2\u00da\u00db\7"+
		"P\2\2\u00db\u00dc\7U\2\2\u00dc\u00dd\7W\2\2\u00dd\u00de\7D\2\2\u00de\u00df"+
		"\7U\2\2\u00df\u00e0\7E\2\2\u00e0\u00e1\7T\2\2\u00e1\u00e2\7K\2\2\u00e2"+
		"\u00e3\7D\2\2\u00e3\u00e4\7G\2\2\u00e4\26\3\2\2\2\u00e5\u00e6\7T\2\2\u00e6"+
		"\u00e7\7G\2\2\u00e7\u00e8\7U\2\2\u00e8\u00e9\7W\2\2\u00e9\u00ea\7O\2\2"+
		"\u00ea\u00eb\7G\2\2\u00eb\30\3\2\2\2\u00ec\u00ed\7R\2\2\u00ed\u00ee\7"+
		"C\2\2\u00ee\u00ef\7W\2\2\u00ef\u00f0\7U\2\2\u00f0\u00f1\7G\2\2\u00f1\32"+
		"\3\2\2\2\u00f2\u00f3\7W\2\2\u00f3\u00f4\7U\2\2\u00f4\u00f5\7K\2\2\u00f5"+
		"\u00f6\7P\2\2\u00f6\u00f7\7I\2\2\u00f7\34\3\2\2\2\u00f8\u00f9\7G\2\2\u00f9"+
		"\u00fa\7Z\2\2\u00fa\u00fb\7K\2\2\u00fb\u00fc\7V\2\2\u00fc\36\3\2\2\2\u00fd"+
		"\u00fe\7U\2\2\u00fe\u00ff\7G\2\2\u00ff\u0100\7V\2\2\u0100 \3\2\2\2\u0101"+
		"\u0102\7U\2\2\u0102\u0103\7V\2\2\u0103\u0104\7C\2\2\u0104\u0105\7T\2\2"+
		"\u0105\u0106\7V\2\2\u0106\"\3\2\2\2\u0107\u0108\7C\2\2\u0108\u0109\7U"+
		"\2\2\u0109\u010a\7U\2\2\u010a\u010b\7G\2\2\u010b\u010c\7V\2\2\u010c\u010d"+
		"\7U\2\2\u010d$\3\2\2\2\u010e\u010f\7O\2\2\u010f\u0110\7C\2\2\u0110\u0111"+
		"\7P\2\2\u0111\u0112\7C\2\2\u0112\u0113\7I\2\2\u0113\u0114\7G\2\2\u0114"+
		"\u0115\7T\2\2\u0115&\3\2\2\2\u0116\u0117\7I\2\2\u0117\u0118\7C\2\2\u0118"+
		"\u0119\7O\2\2\u0119\u011a\7G\2\2\u011a(\3\2\2\2\u011b\u011c\7U\2\2\u011c"+
		"\u011d\7V\2\2\u011d\u011e\7C\2\2\u011e\u011f\7V\2\2\u011f\u0120\7G\2\2"+
		"\u0120*\3\2\2\2\u0121\u0122\7C\2\2\u0122\u0123\7U\2\2\u0123\u0124\7U\2"+
		"\2\u0124\u0125\7G\2\2\u0125\u0126\7V\2\2\u0126,\3\2\2\2\u0127\u0128\7"+
		"D\2\2\u0128\u0129\7G\2\2\u0129\u012a\7J\2\2\u012a\u012b\7C\2\2\u012b\u012c"+
		"\7X\2\2\u012c\u012d\7K\2\2\u012d\u012e\7Q\2\2\u012e\u012f\7T\2\2\u012f"+
		".\3\2\2\2\u0130\u0131\7G\2\2\u0131\u0132\7P\2\2\u0132\u0133\7V\2\2\u0133"+
		"\u0134\7K\2\2\u0134\u0135\7V\2\2\u0135\u0136\7[\2\2\u0136\60\3\2\2\2\u0137"+
		"\u0138\7I\2\2\u0138\u0139\7Q\2\2\u0139\u013a\7C\2\2\u013a\u013b\7N\2\2"+
		"\u013b\62\3\2\2\2\u013c\u013d\7O\2\2\u013d\u013e\7G\2\2\u013e\u013f\7"+
		"U\2\2\u013f\u0140\7U\2\2\u0140\u0141\7C\2\2\u0141\u0142\7I\2\2\u0142\u0143"+
		"\7G\2\2\u0143\64\3\2\2\2\u0144\u0145\7D\2\2\u0145\u0146\7C\2\2\u0146\u0147"+
		"\7U\2\2\u0147\u0148\7G\2\2\u0148\66\3\2\2\2\u0149\u014a\7V\2\2\u014a\u014b"+
		"\7Q\2\2\u014b8\3\2\2\2\u014c\u014d\7U\2\2\u014d\u014e\7Q\2\2\u014e\u014f"+
		"\7W\2\2\u014f\u0150\7T\2\2\u0150\u0151\7E\2\2\u0151\u0152\7G\2\2\u0152"+
		":\3\2\2\2\u0153\u0154\7C\2\2\u0154\u0155\7U\2\2\u0155<\3\2\2\2\u0156\u0157"+
		"\7Q\2\2\u0157\u0158\7V\2\2\u0158\u0159\7J\2\2\u0159\u015a\7G\2\2\u015a"+
		"\u015b\7T\2\2\u015b>\3\2\2\2\u015c\u015d\7G\2\2\u015d\u015e\7O\2\2\u015e"+
		"\u015f\7R\2\2\u015f\u0160\7V\2\2\u0160\u0161\7[\2\2\u0161@\3\2\2\2\u0162"+
		"\u0163\7]\2\2\u0163B\3\2\2\2\u0164\u0165\7*\2\2\u0165D\3\2\2\2\u0166\u0167"+
		"\7}\2\2\u0167F\3\2\2\2\u0168\u0169\7_\2\2\u0169H\3\2\2\2\u016a\u016b\7"+
		"+\2\2\u016bJ\3\2\2\2\u016c\u016d\7\177\2\2\u016dL\3\2\2\2\u016e\u016f"+
		"\7.\2\2\u016fN\3\2\2\2\u0170\u0171\7?\2\2\u0171P\3\2\2\2\u0172\u0173\7"+
		"\60\2\2\u0173R\3\2\2\2\u0174\u0175\7=\2\2\u0175T\3\2\2\2\u0176\u0177\7"+
		"<\2\2\u0177V\3\2\2\2\u0178\u0179\7-\2\2\u0179X\3\2\2\2\u017a\u017b\7/"+
		"\2\2\u017bZ\3\2\2\2\u017c\u017d\7,\2\2\u017d\\\3\2\2\2\u017e\u017f\7\61"+
		"\2\2\u017f^\3\2\2\2\u0180\u0181\7@\2\2\u0181`\3\2\2\2\u0182\u0183\7>\2"+
		"\2\u0183b\3\2\2\2\u0184\u0185\7C\2\2\u0185\u0186\7P\2\2\u0186\u0187\7"+
		"F\2\2\u0187d\3\2\2\2\u0188\u0189\7Q\2\2\u0189\u018a\7T\2\2\u018af\3\2"+
		"\2\2\u018b\u018c\7Z\2\2\u018c\u018d\7Q\2\2\u018d\u018e\7T\2\2\u018eh\3"+
		"\2\2\2\u018f\u0190\7P\2\2\u0190\u0191\7Q\2\2\u0191\u0192\7V\2\2\u0192"+
		"j\3\2\2\2\u0193\u0194\7P\2\2\u0194\u0195\7w\2\2\u0195\u0196\7o\2\2\u0196"+
		"\u0197\7d\2\2\u0197\u0198\7g\2\2\u0198\u0199\7t\2\2\u0199l\3\2\2\2\u019a"+
		"\u019b\7U\2\2\u019b\u019c\7v\2\2\u019c\u019d\7t\2\2\u019d\u019e\7k\2\2"+
		"\u019e\u019f\7p\2\2\u019f\u01a0\7i\2\2\u01a0n\3\2\2\2\u01a1\u01a2\7D\2"+
		"\2\u01a2\u01a3\7q\2\2\u01a3\u01a4\7q\2\2\u01a4\u01a5\7n\2\2\u01a5p\3\2"+
		"\2\2\u01a6\u01a7\7K\2\2\u01a7\u01a8\7p\2\2\u01a8\u01a9\7v\2\2\u01a9\u01aa"+
		"\7g\2\2\u01aa\u01ab\7i\2\2\u01ab\u01ac\7g\2\2\u01ac\u01ad\7t\2\2\u01ad"+
		"r\3\2\2\2\u01ae\u01af\7F\2\2\u01af\u01b0\7q\2\2\u01b0\u01b1\7w\2\2\u01b1"+
		"\u01b2\7d\2\2\u01b2\u01b3\7n\2\2\u01b3\u01b4\7g\2\2\u01b4t\3\2\2\2\u01b5"+
		"\u01b6\7H\2\2\u01b6\u01b7\7n\2\2\u01b7\u01b8\7q\2\2\u01b8\u01b9\7c\2\2"+
		"\u01b9\u01ba\7v\2\2\u01bav\3\2\2\2\u01bb\u01bc\7B\2\2\u01bc\u01bd\7)\2"+
		"\2\u01bd\u01c1\3\2\2\2\u01be\u01c0\13\2\2\2\u01bf\u01be\3\2\2\2\u01c0"+
		"\u01c3\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c2\u01c4\3\2"+
		"\2\2\u01c3\u01c1\3\2\2\2\u01c4\u01c5\7)\2\2\u01c5x\3\2\2\2\u01c6\u01c8"+
		"\5\u0085C\2\u01c7\u01c6\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9\u01c7\3\2\2"+
		"\2\u01c9\u01ca\3\2\2\2\u01caz\3\2\2\2\u01cb\u01cd\5\u0085C\2\u01cc\u01cb"+
		"\3\2\2\2\u01cd\u01d0\3\2\2\2\u01ce\u01cc\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf"+
		"\u01d1\3\2\2\2\u01d0\u01ce\3\2\2\2\u01d1\u01d3\7\60\2\2\u01d2\u01d4\5"+
		"\u0085C\2\u01d3\u01d2\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d3\3\2\2\2"+
		"\u01d5\u01d6\3\2\2\2\u01d6|\3\2\2\2\u01d7\u01db\7$\2\2\u01d8\u01da\13"+
		"\2\2\2\u01d9\u01d8\3\2\2\2\u01da\u01dd\3\2\2\2\u01db\u01dc\3\2\2\2\u01db"+
		"\u01d9\3\2\2\2\u01dc\u01de\3\2\2\2\u01dd\u01db\3\2\2\2\u01de\u01df\7$"+
		"\2\2\u01df~\3\2\2\2\u01e0\u01e1\7v\2\2\u01e1\u01e2\7t\2\2\u01e2\u01e3"+
		"\7w\2\2\u01e3\u01ea\7g\2\2\u01e4\u01e5\7h\2\2\u01e5\u01e6\7c\2\2\u01e6"+
		"\u01e7\7n\2\2\u01e7\u01e8\7u\2\2\u01e8\u01ea\7g\2\2\u01e9\u01e0\3\2\2"+
		"\2\u01e9\u01e4\3\2\2\2\u01ea\u0080\3\2\2\2\u01eb\u01ec\7r\2\2\u01ec\u01ed"+
		"\7c\2\2\u01ed\u01ee\7t\2\2\u01ee\u01ef\7g\2\2\u01ef\u01f0\7p\2\2\u01f0"+
		"\u01f1\7v\2\2\u01f1\u0082\3\2\2\2\u01f2\u01f3\7e\2\2\u01f3\u01f4\7w\2"+
		"\2\u01f4\u01f5\7t\2\2\u01f5\u01f6\7t\2\2\u01f6\u01f7\7g\2\2\u01f7\u01f8"+
		"\7p\2\2\u01f8\u01f9\7v\2\2\u01f9\u0084\3\2\2\2\u01fa\u01fb\t\3\2\2\u01fb"+
		"\u0086\3\2\2\2\u01fc\u0200\t\4\2\2\u01fd\u01ff\t\5\2\2\u01fe\u01fd\3\2"+
		"\2\2\u01ff\u0202\3\2\2\2\u0200\u01fe\3\2\2\2\u0200\u0201\3\2\2\2\u0201"+
		"\u0088\3\2\2\2\u0202\u0200\3\2\2\2\u0203\u0205\t\2\2\2\u0204\u0203\3\2"+
		"\2\2\u0205\u0206\3\2\2\2\u0206\u0204\3\2\2\2\u0206\u0207\3\2\2\2\u0207"+
		"\u0208\3\2\2\2\u0208\u0209\bE\4\2\u0209\u008a\3\2\2\2\u020a\u020c\t\6"+
		"\2\2\u020b\u020a\3\2\2\2\u020c\u020d\3\2\2\2\u020d\u020b\3\2\2\2\u020d"+
		"\u020e\3\2\2\2\u020e\u020f\3\2\2\2\u020f\u0210\bF\5\2\u0210\u008c\3\2"+
		"\2\2\20\2\u0094\u0097\u009a\u00a6\u01c1\u01c9\u01ce\u01d5\u01db\u01e9"+
		"\u0200\u0206\u020d";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}