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
		USING=13, EXIT=14, SET=15, START=16, ASSETS=17, FLAG=18, WHEN=19, MANAGER=20, 
		GAME=21, STATE=22, ASSET=23, BEHAVIOR=24, ENTITY=25, GOAL=26, MESSAGE=27, 
		BASE=28, TO=29, SOURCE=30, AS=31, OTHER=32, EMPTY=33, THEN=34, ABRE_COR=35, 
		ABRE_PAR=36, ABRE_LLAV=37, CIERRA_COR=38, CIERRA_PAR=39, CIERRA_LLAV=40, 
		COMA=41, EQUAL=42, DOT=43, DOTCOMA=44, DOUBLEDOT=45, PLUS=46, MINUS=47, 
		MULTIPLY=48, DIVIDE=49, MORE_THAN=50, LESS_THAN=51, AND=52, OR=53, XOR=54, 
		NOT=55, NUMBER_TYPE=56, STRING_TYPE=57, BOOL_TYPE=58, INTEGER_TYPE=59, 
		DOUBLE_TYPE=60, FLOAT_TYPE=61, DIRECTCODE=62, INT_LITERAL=63, DECIMAL_LITERAL=64, 
		STRING_LITERAL=65, BOOL_LITERAL=66, CURRENT_LITERAL=67, ID=68, NL=69, 
		WS=70;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT", "'DEFINE'", "'ADD'", "'ON'", 
		"'SEND'", "'DESTROY'", "'GROUP'", "'SUBSCRIBE'", "'UNSUBSCRIBE'", "'RESUME'", 
		"'PAUSE'", "'USING'", "'EXIT'", "'SET'", "'START'", "'ASSETS'", "'FLAG'", 
		"'WHEN'", "'MANAGER'", "'GAME'", "'STATE'", "'ASSET'", "'BEHAVIOR'", "'ENTITY'", 
		"'GOAL'", "'MESSAGE'", "'BASE'", "'TO'", "'SOURCE'", "'AS'", "'OTHER'", 
		"'EMPTY'", "'THEN'", "'['", "'('", "'{'", "']'", "')'", "'}'", "','", 
		"'='", "'.'", "';'", "':'", "'+'", "'-'", "'*'", "'/'", "'>'", "'<'", 
		"'AND'", "'OR'", "'XOR'", "'NOT'", "'Number'", "'String'", "'Bool'", "'Integer'", 
		"'Double'", "'Float'", "DIRECTCODE", "INT_LITERAL", "DECIMAL_LITERAL", 
		"STRING_LITERAL", "BOOL_LITERAL", "'current'", "ID", "NL", "WS"
	};
	public static final String[] ruleNames = {
		"SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT", "DEFINE", "ADD", "ON", "SEND", 
		"DESTROY", "GROUP", "SUBSCRIBE", "UNSUBSCRIBE", "RESUME", "PAUSE", "USING", 
		"EXIT", "SET", "START", "ASSETS", "FLAG", "WHEN", "MANAGER", "GAME", "STATE", 
		"ASSET", "BEHAVIOR", "ENTITY", "GOAL", "MESSAGE", "BASE", "TO", "SOURCE", 
		"AS", "OTHER", "EMPTY", "THEN", "ABRE_COR", "ABRE_PAR", "ABRE_LLAV", "CIERRA_COR", 
		"CIERRA_PAR", "CIERRA_LLAV", "COMA", "EQUAL", "DOT", "DOTCOMA", "DOUBLEDOT", 
		"PLUS", "MINUS", "MULTIPLY", "DIVIDE", "MORE_THAN", "LESS_THAN", "AND", 
		"OR", "XOR", "NOT", "NUMBER_TYPE", "STRING_TYPE", "BOOL_TYPE", "INTEGER_TYPE", 
		"DOUBLE_TYPE", "FLOAT_TYPE", "DIRECTCODE", "INT_LITERAL", "DECIMAL_LITERAL", 
		"STRING_LITERAL", "BOOL_LITERAL", "CURRENT_LITERAL", "DIGIT", "ID", "NL", 
		"WS"
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

		case 69: NL_action((RuleContext)_localctx, actionIndex); break;

		case 70: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2H\u021d\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\3\2"+
		"\3\2\3\2\3\2\3\2\7\2\u0097\n\2\f\2\16\2\u009a\13\2\5\2\u009c\n\2\3\2\5"+
		"\2\u009f\n\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3\u00a9\n\3\f\3\16\3\u00ac"+
		"\13\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24"+
		"\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3 \3 \3 \3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3"+
		"#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3."+
		"\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\65"+
		"\3\65\3\66\3\66\3\66\3\67\3\67\3\67\3\67\38\38\38\38\39\39\39\39\39\3"+
		"9\39\3:\3:\3:\3:\3:\3:\3:\3;\3;\3;\3;\3;\3<\3<\3<\3<\3<\3<\3<\3<\3=\3"+
		"=\3=\3=\3=\3=\3=\3>\3>\3>\3>\3>\3>\3?\3?\3?\3?\7?\u01d3\n?\f?\16?\u01d6"+
		"\13?\3?\3?\3@\6@\u01db\n@\r@\16@\u01dc\3A\7A\u01e0\nA\fA\16A\u01e3\13"+
		"A\3A\3A\6A\u01e7\nA\rA\16A\u01e8\3B\3B\7B\u01ed\nB\fB\16B\u01f0\13B\3"+
		"B\3B\3C\3C\3C\3C\3C\3C\3C\3C\3C\5C\u01fd\nC\3D\3D\3D\3D\3D\3D\3D\3D\3"+
		"E\3E\3F\3F\7F\u020b\nF\fF\16F\u020e\13F\3G\6G\u0211\nG\rG\16G\u0212\3"+
		"G\3G\3H\6H\u0218\nH\rH\16H\u0219\3H\3H\6\u0098\u00aa\u01d4\u01eeI\3\3"+
		"\2\5\4\3\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1"+
		"\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1"+
		"-\30\1/\31\1\61\32\1\63\33\1\65\34\1\67\35\19\36\1;\37\1= \1?!\1A\"\1"+
		"C#\1E$\1G%\1I&\1K\'\1M(\1O)\1Q*\1S+\1U,\1W-\1Y.\1[/\1]\60\1_\61\1a\62"+
		"\1c\63\1e\64\1g\65\1i\66\1k\67\1m8\1o9\1q:\1s;\1u<\1w=\1y>\1{?\1}@\1\177"+
		"A\1\u0081B\1\u0083C\1\u0085D\1\u0087E\1\u0089\2\1\u008bF\1\u008dG\4\u008f"+
		"H\5\3\2\7\4\2\f\f\17\17\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\4\2\13\13\""+
		"\"\u0228\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S"+
		"\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2"+
		"\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2"+
		"\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y"+
		"\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3"+
		"\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2"+
		"\2\u008f\3\2\2\2\3\u0091\3\2\2\2\5\u00a4\3\2\2\2\7\u00b2\3\2\2\2\t\u00b9"+
		"\3\2\2\2\13\u00bd\3\2\2\2\r\u00c0\3\2\2\2\17\u00c5\3\2\2\2\21\u00cd\3"+
		"\2\2\2\23\u00d3\3\2\2\2\25\u00dd\3\2\2\2\27\u00e9\3\2\2\2\31\u00f0\3\2"+
		"\2\2\33\u00f6\3\2\2\2\35\u00fc\3\2\2\2\37\u0101\3\2\2\2!\u0105\3\2\2\2"+
		"#\u010b\3\2\2\2%\u0112\3\2\2\2\'\u0117\3\2\2\2)\u011c\3\2\2\2+\u0124\3"+
		"\2\2\2-\u0129\3\2\2\2/\u012f\3\2\2\2\61\u0135\3\2\2\2\63\u013e\3\2\2\2"+
		"\65\u0145\3\2\2\2\67\u014a\3\2\2\29\u0152\3\2\2\2;\u0157\3\2\2\2=\u015a"+
		"\3\2\2\2?\u0161\3\2\2\2A\u0164\3\2\2\2C\u016a\3\2\2\2E\u0170\3\2\2\2G"+
		"\u0175\3\2\2\2I\u0177\3\2\2\2K\u0179\3\2\2\2M\u017b\3\2\2\2O\u017d\3\2"+
		"\2\2Q\u017f\3\2\2\2S\u0181\3\2\2\2U\u0183\3\2\2\2W\u0185\3\2\2\2Y\u0187"+
		"\3\2\2\2[\u0189\3\2\2\2]\u018b\3\2\2\2_\u018d\3\2\2\2a\u018f\3\2\2\2c"+
		"\u0191\3\2\2\2e\u0193\3\2\2\2g\u0195\3\2\2\2i\u0197\3\2\2\2k\u019b\3\2"+
		"\2\2m\u019e\3\2\2\2o\u01a2\3\2\2\2q\u01a6\3\2\2\2s\u01ad\3\2\2\2u\u01b4"+
		"\3\2\2\2w\u01b9\3\2\2\2y\u01c1\3\2\2\2{\u01c8\3\2\2\2}\u01ce\3\2\2\2\177"+
		"\u01da\3\2\2\2\u0081\u01e1\3\2\2\2\u0083\u01ea\3\2\2\2\u0085\u01fc\3\2"+
		"\2\2\u0087\u01fe\3\2\2\2\u0089\u0206\3\2\2\2\u008b\u0208\3\2\2\2\u008d"+
		"\u0210\3\2\2\2\u008f\u0217\3\2\2\2\u0091\u0092\7\61\2\2\u0092\u0093\7"+
		"\61\2\2\u0093\u009b\3\2\2\2\u0094\u009c\t\2\2\2\u0095\u0097\13\2\2\2\u0096"+
		"\u0095\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0099\3\2\2\2\u0098\u0096\3\2"+
		"\2\2\u0099\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u0094\3\2\2\2\u009b"+
		"\u0098\3\2\2\2\u009c\u009e\3\2\2\2\u009d\u009f\7\17\2\2\u009e\u009d\3"+
		"\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\7\f\2\2\u00a1"+
		"\u00a2\3\2\2\2\u00a2\u00a3\b\2\2\2\u00a3\4\3\2\2\2\u00a4\u00a5\7\61\2"+
		"\2\u00a5\u00a6\7,\2\2\u00a6\u00aa\3\2\2\2\u00a7\u00a9\13\2\2\2\u00a8\u00a7"+
		"\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00ab\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab"+
		"\u00ad\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00ae\7,\2\2\u00ae\u00af\7\61"+
		"\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\b\3\3\2\u00b1\6\3\2\2\2\u00b2\u00b3"+
		"\7F\2\2\u00b3\u00b4\7G\2\2\u00b4\u00b5\7H\2\2\u00b5\u00b6\7K\2\2\u00b6"+
		"\u00b7\7P\2\2\u00b7\u00b8\7G\2\2\u00b8\b\3\2\2\2\u00b9\u00ba\7C\2\2\u00ba"+
		"\u00bb\7F\2\2\u00bb\u00bc\7F\2\2\u00bc\n\3\2\2\2\u00bd\u00be\7Q\2\2\u00be"+
		"\u00bf\7P\2\2\u00bf\f\3\2\2\2\u00c0\u00c1\7U\2\2\u00c1\u00c2\7G\2\2\u00c2"+
		"\u00c3\7P\2\2\u00c3\u00c4\7F\2\2\u00c4\16\3\2\2\2\u00c5\u00c6\7F\2\2\u00c6"+
		"\u00c7\7G\2\2\u00c7\u00c8\7U\2\2\u00c8\u00c9\7V\2\2\u00c9\u00ca\7T\2\2"+
		"\u00ca\u00cb\7Q\2\2\u00cb\u00cc\7[\2\2\u00cc\20\3\2\2\2\u00cd\u00ce\7"+
		"I\2\2\u00ce\u00cf\7T\2\2\u00cf\u00d0\7Q\2\2\u00d0\u00d1\7W\2\2\u00d1\u00d2"+
		"\7R\2\2\u00d2\22\3\2\2\2\u00d3\u00d4\7U\2\2\u00d4\u00d5\7W\2\2\u00d5\u00d6"+
		"\7D\2\2\u00d6\u00d7\7U\2\2\u00d7\u00d8\7E\2\2\u00d8\u00d9\7T\2\2\u00d9"+
		"\u00da\7K\2\2\u00da\u00db\7D\2\2\u00db\u00dc\7G\2\2\u00dc\24\3\2\2\2\u00dd"+
		"\u00de\7W\2\2\u00de\u00df\7P\2\2\u00df\u00e0\7U\2\2\u00e0\u00e1\7W\2\2"+
		"\u00e1\u00e2\7D\2\2\u00e2\u00e3\7U\2\2\u00e3\u00e4\7E\2\2\u00e4\u00e5"+
		"\7T\2\2\u00e5\u00e6\7K\2\2\u00e6\u00e7\7D\2\2\u00e7\u00e8\7G\2\2\u00e8"+
		"\26\3\2\2\2\u00e9\u00ea\7T\2\2\u00ea\u00eb\7G\2\2\u00eb\u00ec\7U\2\2\u00ec"+
		"\u00ed\7W\2\2\u00ed\u00ee\7O\2\2\u00ee\u00ef\7G\2\2\u00ef\30\3\2\2\2\u00f0"+
		"\u00f1\7R\2\2\u00f1\u00f2\7C\2\2\u00f2\u00f3\7W\2\2\u00f3\u00f4\7U\2\2"+
		"\u00f4\u00f5\7G\2\2\u00f5\32\3\2\2\2\u00f6\u00f7\7W\2\2\u00f7\u00f8\7"+
		"U\2\2\u00f8\u00f9\7K\2\2\u00f9\u00fa\7P\2\2\u00fa\u00fb\7I\2\2\u00fb\34"+
		"\3\2\2\2\u00fc\u00fd\7G\2\2\u00fd\u00fe\7Z\2\2\u00fe\u00ff\7K\2\2\u00ff"+
		"\u0100\7V\2\2\u0100\36\3\2\2\2\u0101\u0102\7U\2\2\u0102\u0103\7G\2\2\u0103"+
		"\u0104\7V\2\2\u0104 \3\2\2\2\u0105\u0106\7U\2\2\u0106\u0107\7V\2\2\u0107"+
		"\u0108\7C\2\2\u0108\u0109\7T\2\2\u0109\u010a\7V\2\2\u010a\"\3\2\2\2\u010b"+
		"\u010c\7C\2\2\u010c\u010d\7U\2\2\u010d\u010e\7U\2\2\u010e\u010f\7G\2\2"+
		"\u010f\u0110\7V\2\2\u0110\u0111\7U\2\2\u0111$\3\2\2\2\u0112\u0113\7H\2"+
		"\2\u0113\u0114\7N\2\2\u0114\u0115\7C\2\2\u0115\u0116\7I\2\2\u0116&\3\2"+
		"\2\2\u0117\u0118\7Y\2\2\u0118\u0119\7J\2\2\u0119\u011a\7G\2\2\u011a\u011b"+
		"\7P\2\2\u011b(\3\2\2\2\u011c\u011d\7O\2\2\u011d\u011e\7C\2\2\u011e\u011f"+
		"\7P\2\2\u011f\u0120\7C\2\2\u0120\u0121\7I\2\2\u0121\u0122\7G\2\2\u0122"+
		"\u0123\7T\2\2\u0123*\3\2\2\2\u0124\u0125\7I\2\2\u0125\u0126\7C\2\2\u0126"+
		"\u0127\7O\2\2\u0127\u0128\7G\2\2\u0128,\3\2\2\2\u0129\u012a\7U\2\2\u012a"+
		"\u012b\7V\2\2\u012b\u012c\7C\2\2\u012c\u012d\7V\2\2\u012d\u012e\7G\2\2"+
		"\u012e.\3\2\2\2\u012f\u0130\7C\2\2\u0130\u0131\7U\2\2\u0131\u0132\7U\2"+
		"\2\u0132\u0133\7G\2\2\u0133\u0134\7V\2\2\u0134\60\3\2\2\2\u0135\u0136"+
		"\7D\2\2\u0136\u0137\7G\2\2\u0137\u0138\7J\2\2\u0138\u0139\7C\2\2\u0139"+
		"\u013a\7X\2\2\u013a\u013b\7K\2\2\u013b\u013c\7Q\2\2\u013c\u013d\7T\2\2"+
		"\u013d\62\3\2\2\2\u013e\u013f\7G\2\2\u013f\u0140\7P\2\2\u0140\u0141\7"+
		"V\2\2\u0141\u0142\7K\2\2\u0142\u0143\7V\2\2\u0143\u0144\7[\2\2\u0144\64"+
		"\3\2\2\2\u0145\u0146\7I\2\2\u0146\u0147\7Q\2\2\u0147\u0148\7C\2\2\u0148"+
		"\u0149\7N\2\2\u0149\66\3\2\2\2\u014a\u014b\7O\2\2\u014b\u014c\7G\2\2\u014c"+
		"\u014d\7U\2\2\u014d\u014e\7U\2\2\u014e\u014f\7C\2\2\u014f\u0150\7I\2\2"+
		"\u0150\u0151\7G\2\2\u01518\3\2\2\2\u0152\u0153\7D\2\2\u0153\u0154\7C\2"+
		"\2\u0154\u0155\7U\2\2\u0155\u0156\7G\2\2\u0156:\3\2\2\2\u0157\u0158\7"+
		"V\2\2\u0158\u0159\7Q\2\2\u0159<\3\2\2\2\u015a\u015b\7U\2\2\u015b\u015c"+
		"\7Q\2\2\u015c\u015d\7W\2\2\u015d\u015e\7T\2\2\u015e\u015f\7E\2\2\u015f"+
		"\u0160\7G\2\2\u0160>\3\2\2\2\u0161\u0162\7C\2\2\u0162\u0163\7U\2\2\u0163"+
		"@\3\2\2\2\u0164\u0165\7Q\2\2\u0165\u0166\7V\2\2\u0166\u0167\7J\2\2\u0167"+
		"\u0168\7G\2\2\u0168\u0169\7T\2\2\u0169B\3\2\2\2\u016a\u016b\7G\2\2\u016b"+
		"\u016c\7O\2\2\u016c\u016d\7R\2\2\u016d\u016e\7V\2\2\u016e\u016f\7[\2\2"+
		"\u016fD\3\2\2\2\u0170\u0171\7V\2\2\u0171\u0172\7J\2\2\u0172\u0173\7G\2"+
		"\2\u0173\u0174\7P\2\2\u0174F\3\2\2\2\u0175\u0176\7]\2\2\u0176H\3\2\2\2"+
		"\u0177\u0178\7*\2\2\u0178J\3\2\2\2\u0179\u017a\7}\2\2\u017aL\3\2\2\2\u017b"+
		"\u017c\7_\2\2\u017cN\3\2\2\2\u017d\u017e\7+\2\2\u017eP\3\2\2\2\u017f\u0180"+
		"\7\177\2\2\u0180R\3\2\2\2\u0181\u0182\7.\2\2\u0182T\3\2\2\2\u0183\u0184"+
		"\7?\2\2\u0184V\3\2\2\2\u0185\u0186\7\60\2\2\u0186X\3\2\2\2\u0187\u0188"+
		"\7=\2\2\u0188Z\3\2\2\2\u0189\u018a\7<\2\2\u018a\\\3\2\2\2\u018b\u018c"+
		"\7-\2\2\u018c^\3\2\2\2\u018d\u018e\7/\2\2\u018e`\3\2\2\2\u018f\u0190\7"+
		",\2\2\u0190b\3\2\2\2\u0191\u0192\7\61\2\2\u0192d\3\2\2\2\u0193\u0194\7"+
		"@\2\2\u0194f\3\2\2\2\u0195\u0196\7>\2\2\u0196h\3\2\2\2\u0197\u0198\7C"+
		"\2\2\u0198\u0199\7P\2\2\u0199\u019a\7F\2\2\u019aj\3\2\2\2\u019b\u019c"+
		"\7Q\2\2\u019c\u019d\7T\2\2\u019dl\3\2\2\2\u019e\u019f\7Z\2\2\u019f\u01a0"+
		"\7Q\2\2\u01a0\u01a1\7T\2\2\u01a1n\3\2\2\2\u01a2\u01a3\7P\2\2\u01a3\u01a4"+
		"\7Q\2\2\u01a4\u01a5\7V\2\2\u01a5p\3\2\2\2\u01a6\u01a7\7P\2\2\u01a7\u01a8"+
		"\7w\2\2\u01a8\u01a9\7o\2\2\u01a9\u01aa\7d\2\2\u01aa\u01ab\7g\2\2\u01ab"+
		"\u01ac\7t\2\2\u01acr\3\2\2\2\u01ad\u01ae\7U\2\2\u01ae\u01af\7v\2\2\u01af"+
		"\u01b0\7t\2\2\u01b0\u01b1\7k\2\2\u01b1\u01b2\7p\2\2\u01b2\u01b3\7i\2\2"+
		"\u01b3t\3\2\2\2\u01b4\u01b5\7D\2\2\u01b5\u01b6\7q\2\2\u01b6\u01b7\7q\2"+
		"\2\u01b7\u01b8\7n\2\2\u01b8v\3\2\2\2\u01b9\u01ba\7K\2\2\u01ba\u01bb\7"+
		"p\2\2\u01bb\u01bc\7v\2\2\u01bc\u01bd\7g\2\2\u01bd\u01be\7i\2\2\u01be\u01bf"+
		"\7g\2\2\u01bf\u01c0\7t\2\2\u01c0x\3\2\2\2\u01c1\u01c2\7F\2\2\u01c2\u01c3"+
		"\7q\2\2\u01c3\u01c4\7w\2\2\u01c4\u01c5\7d\2\2\u01c5\u01c6\7n\2\2\u01c6"+
		"\u01c7\7g\2\2\u01c7z\3\2\2\2\u01c8\u01c9\7H\2\2\u01c9\u01ca\7n\2\2\u01ca"+
		"\u01cb\7q\2\2\u01cb\u01cc\7c\2\2\u01cc\u01cd\7v\2\2\u01cd|\3\2\2\2\u01ce"+
		"\u01cf\7B\2\2\u01cf\u01d0\7)\2\2\u01d0\u01d4\3\2\2\2\u01d1\u01d3\13\2"+
		"\2\2\u01d2\u01d1\3\2\2\2\u01d3\u01d6\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d4"+
		"\u01d2\3\2\2\2\u01d5\u01d7\3\2\2\2\u01d6\u01d4\3\2\2\2\u01d7\u01d8\7)"+
		"\2\2\u01d8~\3\2\2\2\u01d9\u01db\5\u0089E\2\u01da\u01d9\3\2\2\2\u01db\u01dc"+
		"\3\2\2\2\u01dc\u01da\3\2\2\2\u01dc\u01dd\3\2\2\2\u01dd\u0080\3\2\2\2\u01de"+
		"\u01e0\5\u0089E\2\u01df\u01de\3\2\2\2\u01e0\u01e3\3\2\2\2\u01e1\u01df"+
		"\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2\u01e4\3\2\2\2\u01e3\u01e1\3\2\2\2\u01e4"+
		"\u01e6\7\60\2\2\u01e5\u01e7\5\u0089E\2\u01e6\u01e5\3\2\2\2\u01e7\u01e8"+
		"\3\2\2\2\u01e8\u01e6\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9\u0082\3\2\2\2\u01ea"+
		"\u01ee\7$\2\2\u01eb\u01ed\13\2\2\2\u01ec\u01eb\3\2\2\2\u01ed\u01f0\3\2"+
		"\2\2\u01ee\u01ef\3\2\2\2\u01ee\u01ec\3\2\2\2\u01ef\u01f1\3\2\2\2\u01f0"+
		"\u01ee\3\2\2\2\u01f1\u01f2\7$\2\2\u01f2\u0084\3\2\2\2\u01f3\u01f4\7v\2"+
		"\2\u01f4\u01f5\7t\2\2\u01f5\u01f6\7w\2\2\u01f6\u01fd\7g\2\2\u01f7\u01f8"+
		"\7h\2\2\u01f8\u01f9\7c\2\2\u01f9\u01fa\7n\2\2\u01fa\u01fb\7u\2\2\u01fb"+
		"\u01fd\7g\2\2\u01fc\u01f3\3\2\2\2\u01fc\u01f7\3\2\2\2\u01fd\u0086\3\2"+
		"\2\2\u01fe\u01ff\7e\2\2\u01ff\u0200\7w\2\2\u0200\u0201\7t\2\2\u0201\u0202"+
		"\7t\2\2\u0202\u0203\7g\2\2\u0203\u0204\7p\2\2\u0204\u0205\7v\2\2\u0205"+
		"\u0088\3\2\2\2\u0206\u0207\t\3\2\2\u0207\u008a\3\2\2\2\u0208\u020c\t\4"+
		"\2\2\u0209\u020b\t\5\2\2\u020a\u0209\3\2\2\2\u020b\u020e\3\2\2\2\u020c"+
		"\u020a\3\2\2\2\u020c\u020d\3\2\2\2\u020d\u008c\3\2\2\2\u020e\u020c\3\2"+
		"\2\2\u020f\u0211\t\2\2\2\u0210\u020f\3\2\2\2\u0211\u0212\3\2\2\2\u0212"+
		"\u0210\3\2\2\2\u0212\u0213\3\2\2\2\u0213\u0214\3\2\2\2\u0214\u0215\bG"+
		"\4\2\u0215\u008e\3\2\2\2\u0216\u0218\t\6\2\2\u0217\u0216\3\2\2\2\u0218"+
		"\u0219\3\2\2\2\u0219\u0217\3\2\2\2\u0219\u021a\3\2\2\2\u021a\u021b\3\2"+
		"\2\2\u021b\u021c\bH\5\2\u021c\u0090\3\2\2\2\20\2\u0098\u009b\u009e\u00aa"+
		"\u01d4\u01dc\u01e1\u01e8\u01ee\u01fc\u020c\u0212\u0219";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}