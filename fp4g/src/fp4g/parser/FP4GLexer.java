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
		STRING_LITERAL=65, BOOL_LITERAL=66, PARENT_LITERAL=67, CURRENT_LITERAL=68, 
		ID=69, NL=70, WS=71;
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
		"STRING_LITERAL", "BOOL_LITERAL", "'parent'", "'current'", "ID", "NL", 
		"WS"
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

		case 70: NL_action((RuleContext)_localctx, actionIndex); break;

		case 71: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2I\u0226\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\3\2\3\2\3\2\3\2\3\2\7\2\u0099\n\2\f\2\16\2\u009c\13\2\5\2\u009e\n"+
		"\2\3\2\5\2\u00a1\n\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3\u00ab\n\3\f\3"+
		"\16\3\u00ae\13\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24"+
		"\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26"+
		"\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3#"+
		"\3#\3#\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3"+
		"-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65"+
		"\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3\67\3\67\3\67\38\38\38\38\39\39\3"+
		"9\39\39\39\39\3:\3:\3:\3:\3:\3:\3:\3;\3;\3;\3;\3;\3<\3<\3<\3<\3<\3<\3"+
		"<\3<\3=\3=\3=\3=\3=\3=\3=\3>\3>\3>\3>\3>\3>\3?\3?\3?\3?\7?\u01d5\n?\f"+
		"?\16?\u01d8\13?\3?\3?\3@\6@\u01dd\n@\r@\16@\u01de\3A\7A\u01e2\nA\fA\16"+
		"A\u01e5\13A\3A\3A\6A\u01e9\nA\rA\16A\u01ea\3B\3B\7B\u01ef\nB\fB\16B\u01f2"+
		"\13B\3B\3B\3C\3C\3C\3C\3C\3C\3C\3C\3C\5C\u01ff\nC\3D\3D\3D\3D\3D\3D\3"+
		"D\3E\3E\3E\3E\3E\3E\3E\3E\3F\3F\3G\3G\7G\u0214\nG\fG\16G\u0217\13G\3H"+
		"\6H\u021a\nH\rH\16H\u021b\3H\3H\3I\6I\u0221\nI\rI\16I\u0222\3I\3I\6\u009a"+
		"\u00ac\u01d6\u01f0J\3\3\2\5\4\3\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1"+
		"\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24"+
		"\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1\67\35\19\36"+
		"\1;\37\1= \1?!\1A\"\1C#\1E$\1G%\1I&\1K\'\1M(\1O)\1Q*\1S+\1U,\1W-\1Y.\1"+
		"[/\1]\60\1_\61\1a\62\1c\63\1e\64\1g\65\1i\66\1k\67\1m8\1o9\1q:\1s;\1u"+
		"<\1w=\1y>\1{?\1}@\1\177A\1\u0081B\1\u0083C\1\u0085D\1\u0087E\1\u0089F"+
		"\1\u008b\2\1\u008dG\1\u008fH\4\u0091I\5\3\2\7\4\2\f\f\17\17\3\2\62;\5"+
		"\2C\\aac|\6\2\62;C\\aac|\4\2\13\13\"\"\u0231\2\3\3\2\2\2\2\5\3\2\2\2\2"+
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
		"\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2"+
		"\2\2\u0089\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\3\u0093"+
		"\3\2\2\2\5\u00a6\3\2\2\2\7\u00b4\3\2\2\2\t\u00bb\3\2\2\2\13\u00bf\3\2"+
		"\2\2\r\u00c2\3\2\2\2\17\u00c7\3\2\2\2\21\u00cf\3\2\2\2\23\u00d5\3\2\2"+
		"\2\25\u00df\3\2\2\2\27\u00eb\3\2\2\2\31\u00f2\3\2\2\2\33\u00f8\3\2\2\2"+
		"\35\u00fe\3\2\2\2\37\u0103\3\2\2\2!\u0107\3\2\2\2#\u010d\3\2\2\2%\u0114"+
		"\3\2\2\2\'\u0119\3\2\2\2)\u011e\3\2\2\2+\u0126\3\2\2\2-\u012b\3\2\2\2"+
		"/\u0131\3\2\2\2\61\u0137\3\2\2\2\63\u0140\3\2\2\2\65\u0147\3\2\2\2\67"+
		"\u014c\3\2\2\29\u0154\3\2\2\2;\u0159\3\2\2\2=\u015c\3\2\2\2?\u0163\3\2"+
		"\2\2A\u0166\3\2\2\2C\u016c\3\2\2\2E\u0172\3\2\2\2G\u0177\3\2\2\2I\u0179"+
		"\3\2\2\2K\u017b\3\2\2\2M\u017d\3\2\2\2O\u017f\3\2\2\2Q\u0181\3\2\2\2S"+
		"\u0183\3\2\2\2U\u0185\3\2\2\2W\u0187\3\2\2\2Y\u0189\3\2\2\2[\u018b\3\2"+
		"\2\2]\u018d\3\2\2\2_\u018f\3\2\2\2a\u0191\3\2\2\2c\u0193\3\2\2\2e\u0195"+
		"\3\2\2\2g\u0197\3\2\2\2i\u0199\3\2\2\2k\u019d\3\2\2\2m\u01a0\3\2\2\2o"+
		"\u01a4\3\2\2\2q\u01a8\3\2\2\2s\u01af\3\2\2\2u\u01b6\3\2\2\2w\u01bb\3\2"+
		"\2\2y\u01c3\3\2\2\2{\u01ca\3\2\2\2}\u01d0\3\2\2\2\177\u01dc\3\2\2\2\u0081"+
		"\u01e3\3\2\2\2\u0083\u01ec\3\2\2\2\u0085\u01fe\3\2\2\2\u0087\u0200\3\2"+
		"\2\2\u0089\u0207\3\2\2\2\u008b\u020f\3\2\2\2\u008d\u0211\3\2\2\2\u008f"+
		"\u0219\3\2\2\2\u0091\u0220\3\2\2\2\u0093\u0094\7\61\2\2\u0094\u0095\7"+
		"\61\2\2\u0095\u009d\3\2\2\2\u0096\u009e\t\2\2\2\u0097\u0099\13\2\2\2\u0098"+
		"\u0097\3\2\2\2\u0099\u009c\3\2\2\2\u009a\u009b\3\2\2\2\u009a\u0098\3\2"+
		"\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u0096\3\2\2\2\u009d"+
		"\u009a\3\2\2\2\u009e\u00a0\3\2\2\2\u009f\u00a1\7\17\2\2\u00a0\u009f\3"+
		"\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\7\f\2\2\u00a3"+
		"\u00a4\3\2\2\2\u00a4\u00a5\b\2\2\2\u00a5\4\3\2\2\2\u00a6\u00a7\7\61\2"+
		"\2\u00a7\u00a8\7,\2\2\u00a8\u00ac\3\2\2\2\u00a9\u00ab\13\2\2\2\u00aa\u00a9"+
		"\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad"+
		"\u00af\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b0\7,\2\2\u00b0\u00b1\7\61"+
		"\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\b\3\3\2\u00b3\6\3\2\2\2\u00b4\u00b5"+
		"\7F\2\2\u00b5\u00b6\7G\2\2\u00b6\u00b7\7H\2\2\u00b7\u00b8\7K\2\2\u00b8"+
		"\u00b9\7P\2\2\u00b9\u00ba\7G\2\2\u00ba\b\3\2\2\2\u00bb\u00bc\7C\2\2\u00bc"+
		"\u00bd\7F\2\2\u00bd\u00be\7F\2\2\u00be\n\3\2\2\2\u00bf\u00c0\7Q\2\2\u00c0"+
		"\u00c1\7P\2\2\u00c1\f\3\2\2\2\u00c2\u00c3\7U\2\2\u00c3\u00c4\7G\2\2\u00c4"+
		"\u00c5\7P\2\2\u00c5\u00c6\7F\2\2\u00c6\16\3\2\2\2\u00c7\u00c8\7F\2\2\u00c8"+
		"\u00c9\7G\2\2\u00c9\u00ca\7U\2\2\u00ca\u00cb\7V\2\2\u00cb\u00cc\7T\2\2"+
		"\u00cc\u00cd\7Q\2\2\u00cd\u00ce\7[\2\2\u00ce\20\3\2\2\2\u00cf\u00d0\7"+
		"I\2\2\u00d0\u00d1\7T\2\2\u00d1\u00d2\7Q\2\2\u00d2\u00d3\7W\2\2\u00d3\u00d4"+
		"\7R\2\2\u00d4\22\3\2\2\2\u00d5\u00d6\7U\2\2\u00d6\u00d7\7W\2\2\u00d7\u00d8"+
		"\7D\2\2\u00d8\u00d9\7U\2\2\u00d9\u00da\7E\2\2\u00da\u00db\7T\2\2\u00db"+
		"\u00dc\7K\2\2\u00dc\u00dd\7D\2\2\u00dd\u00de\7G\2\2\u00de\24\3\2\2\2\u00df"+
		"\u00e0\7W\2\2\u00e0\u00e1\7P\2\2\u00e1\u00e2\7U\2\2\u00e2\u00e3\7W\2\2"+
		"\u00e3\u00e4\7D\2\2\u00e4\u00e5\7U\2\2\u00e5\u00e6\7E\2\2\u00e6\u00e7"+
		"\7T\2\2\u00e7\u00e8\7K\2\2\u00e8\u00e9\7D\2\2\u00e9\u00ea\7G\2\2\u00ea"+
		"\26\3\2\2\2\u00eb\u00ec\7T\2\2\u00ec\u00ed\7G\2\2\u00ed\u00ee\7U\2\2\u00ee"+
		"\u00ef\7W\2\2\u00ef\u00f0\7O\2\2\u00f0\u00f1\7G\2\2\u00f1\30\3\2\2\2\u00f2"+
		"\u00f3\7R\2\2\u00f3\u00f4\7C\2\2\u00f4\u00f5\7W\2\2\u00f5\u00f6\7U\2\2"+
		"\u00f6\u00f7\7G\2\2\u00f7\32\3\2\2\2\u00f8\u00f9\7W\2\2\u00f9\u00fa\7"+
		"U\2\2\u00fa\u00fb\7K\2\2\u00fb\u00fc\7P\2\2\u00fc\u00fd\7I\2\2\u00fd\34"+
		"\3\2\2\2\u00fe\u00ff\7G\2\2\u00ff\u0100\7Z\2\2\u0100\u0101\7K\2\2\u0101"+
		"\u0102\7V\2\2\u0102\36\3\2\2\2\u0103\u0104\7U\2\2\u0104\u0105\7G\2\2\u0105"+
		"\u0106\7V\2\2\u0106 \3\2\2\2\u0107\u0108\7U\2\2\u0108\u0109\7V\2\2\u0109"+
		"\u010a\7C\2\2\u010a\u010b\7T\2\2\u010b\u010c\7V\2\2\u010c\"\3\2\2\2\u010d"+
		"\u010e\7C\2\2\u010e\u010f\7U\2\2\u010f\u0110\7U\2\2\u0110\u0111\7G\2\2"+
		"\u0111\u0112\7V\2\2\u0112\u0113\7U\2\2\u0113$\3\2\2\2\u0114\u0115\7H\2"+
		"\2\u0115\u0116\7N\2\2\u0116\u0117\7C\2\2\u0117\u0118\7I\2\2\u0118&\3\2"+
		"\2\2\u0119\u011a\7Y\2\2\u011a\u011b\7J\2\2\u011b\u011c\7G\2\2\u011c\u011d"+
		"\7P\2\2\u011d(\3\2\2\2\u011e\u011f\7O\2\2\u011f\u0120\7C\2\2\u0120\u0121"+
		"\7P\2\2\u0121\u0122\7C\2\2\u0122\u0123\7I\2\2\u0123\u0124\7G\2\2\u0124"+
		"\u0125\7T\2\2\u0125*\3\2\2\2\u0126\u0127\7I\2\2\u0127\u0128\7C\2\2\u0128"+
		"\u0129\7O\2\2\u0129\u012a\7G\2\2\u012a,\3\2\2\2\u012b\u012c\7U\2\2\u012c"+
		"\u012d\7V\2\2\u012d\u012e\7C\2\2\u012e\u012f\7V\2\2\u012f\u0130\7G\2\2"+
		"\u0130.\3\2\2\2\u0131\u0132\7C\2\2\u0132\u0133\7U\2\2\u0133\u0134\7U\2"+
		"\2\u0134\u0135\7G\2\2\u0135\u0136\7V\2\2\u0136\60\3\2\2\2\u0137\u0138"+
		"\7D\2\2\u0138\u0139\7G\2\2\u0139\u013a\7J\2\2\u013a\u013b\7C\2\2\u013b"+
		"\u013c\7X\2\2\u013c\u013d\7K\2\2\u013d\u013e\7Q\2\2\u013e\u013f\7T\2\2"+
		"\u013f\62\3\2\2\2\u0140\u0141\7G\2\2\u0141\u0142\7P\2\2\u0142\u0143\7"+
		"V\2\2\u0143\u0144\7K\2\2\u0144\u0145\7V\2\2\u0145\u0146\7[\2\2\u0146\64"+
		"\3\2\2\2\u0147\u0148\7I\2\2\u0148\u0149\7Q\2\2\u0149\u014a\7C\2\2\u014a"+
		"\u014b\7N\2\2\u014b\66\3\2\2\2\u014c\u014d\7O\2\2\u014d\u014e\7G\2\2\u014e"+
		"\u014f\7U\2\2\u014f\u0150\7U\2\2\u0150\u0151\7C\2\2\u0151\u0152\7I\2\2"+
		"\u0152\u0153\7G\2\2\u01538\3\2\2\2\u0154\u0155\7D\2\2\u0155\u0156\7C\2"+
		"\2\u0156\u0157\7U\2\2\u0157\u0158\7G\2\2\u0158:\3\2\2\2\u0159\u015a\7"+
		"V\2\2\u015a\u015b\7Q\2\2\u015b<\3\2\2\2\u015c\u015d\7U\2\2\u015d\u015e"+
		"\7Q\2\2\u015e\u015f\7W\2\2\u015f\u0160\7T\2\2\u0160\u0161\7E\2\2\u0161"+
		"\u0162\7G\2\2\u0162>\3\2\2\2\u0163\u0164\7C\2\2\u0164\u0165\7U\2\2\u0165"+
		"@\3\2\2\2\u0166\u0167\7Q\2\2\u0167\u0168\7V\2\2\u0168\u0169\7J\2\2\u0169"+
		"\u016a\7G\2\2\u016a\u016b\7T\2\2\u016bB\3\2\2\2\u016c\u016d\7G\2\2\u016d"+
		"\u016e\7O\2\2\u016e\u016f\7R\2\2\u016f\u0170\7V\2\2\u0170\u0171\7[\2\2"+
		"\u0171D\3\2\2\2\u0172\u0173\7V\2\2\u0173\u0174\7J\2\2\u0174\u0175\7G\2"+
		"\2\u0175\u0176\7P\2\2\u0176F\3\2\2\2\u0177\u0178\7]\2\2\u0178H\3\2\2\2"+
		"\u0179\u017a\7*\2\2\u017aJ\3\2\2\2\u017b\u017c\7}\2\2\u017cL\3\2\2\2\u017d"+
		"\u017e\7_\2\2\u017eN\3\2\2\2\u017f\u0180\7+\2\2\u0180P\3\2\2\2\u0181\u0182"+
		"\7\177\2\2\u0182R\3\2\2\2\u0183\u0184\7.\2\2\u0184T\3\2\2\2\u0185\u0186"+
		"\7?\2\2\u0186V\3\2\2\2\u0187\u0188\7\60\2\2\u0188X\3\2\2\2\u0189\u018a"+
		"\7=\2\2\u018aZ\3\2\2\2\u018b\u018c\7<\2\2\u018c\\\3\2\2\2\u018d\u018e"+
		"\7-\2\2\u018e^\3\2\2\2\u018f\u0190\7/\2\2\u0190`\3\2\2\2\u0191\u0192\7"+
		",\2\2\u0192b\3\2\2\2\u0193\u0194\7\61\2\2\u0194d\3\2\2\2\u0195\u0196\7"+
		"@\2\2\u0196f\3\2\2\2\u0197\u0198\7>\2\2\u0198h\3\2\2\2\u0199\u019a\7C"+
		"\2\2\u019a\u019b\7P\2\2\u019b\u019c\7F\2\2\u019cj\3\2\2\2\u019d\u019e"+
		"\7Q\2\2\u019e\u019f\7T\2\2\u019fl\3\2\2\2\u01a0\u01a1\7Z\2\2\u01a1\u01a2"+
		"\7Q\2\2\u01a2\u01a3\7T\2\2\u01a3n\3\2\2\2\u01a4\u01a5\7P\2\2\u01a5\u01a6"+
		"\7Q\2\2\u01a6\u01a7\7V\2\2\u01a7p\3\2\2\2\u01a8\u01a9\7P\2\2\u01a9\u01aa"+
		"\7w\2\2\u01aa\u01ab\7o\2\2\u01ab\u01ac\7d\2\2\u01ac\u01ad\7g\2\2\u01ad"+
		"\u01ae\7t\2\2\u01aer\3\2\2\2\u01af\u01b0\7U\2\2\u01b0\u01b1\7v\2\2\u01b1"+
		"\u01b2\7t\2\2\u01b2\u01b3\7k\2\2\u01b3\u01b4\7p\2\2\u01b4\u01b5\7i\2\2"+
		"\u01b5t\3\2\2\2\u01b6\u01b7\7D\2\2\u01b7\u01b8\7q\2\2\u01b8\u01b9\7q\2"+
		"\2\u01b9\u01ba\7n\2\2\u01bav\3\2\2\2\u01bb\u01bc\7K\2\2\u01bc\u01bd\7"+
		"p\2\2\u01bd\u01be\7v\2\2\u01be\u01bf\7g\2\2\u01bf\u01c0\7i\2\2\u01c0\u01c1"+
		"\7g\2\2\u01c1\u01c2\7t\2\2\u01c2x\3\2\2\2\u01c3\u01c4\7F\2\2\u01c4\u01c5"+
		"\7q\2\2\u01c5\u01c6\7w\2\2\u01c6\u01c7\7d\2\2\u01c7\u01c8\7n\2\2\u01c8"+
		"\u01c9\7g\2\2\u01c9z\3\2\2\2\u01ca\u01cb\7H\2\2\u01cb\u01cc\7n\2\2\u01cc"+
		"\u01cd\7q\2\2\u01cd\u01ce\7c\2\2\u01ce\u01cf\7v\2\2\u01cf|\3\2\2\2\u01d0"+
		"\u01d1\7B\2\2\u01d1\u01d2\7)\2\2\u01d2\u01d6\3\2\2\2\u01d3\u01d5\13\2"+
		"\2\2\u01d4\u01d3\3\2\2\2\u01d5\u01d8\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d6"+
		"\u01d4\3\2\2\2\u01d7\u01d9\3\2\2\2\u01d8\u01d6\3\2\2\2\u01d9\u01da\7)"+
		"\2\2\u01da~\3\2\2\2\u01db\u01dd\5\u008bF\2\u01dc\u01db\3\2\2\2\u01dd\u01de"+
		"\3\2\2\2\u01de\u01dc\3\2\2\2\u01de\u01df\3\2\2\2\u01df\u0080\3\2\2\2\u01e0"+
		"\u01e2\5\u008bF\2\u01e1\u01e0\3\2\2\2\u01e2\u01e5\3\2\2\2\u01e3\u01e1"+
		"\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01e6\3\2\2\2\u01e5\u01e3\3\2\2\2\u01e6"+
		"\u01e8\7\60\2\2\u01e7\u01e9\5\u008bF\2\u01e8\u01e7\3\2\2\2\u01e9\u01ea"+
		"\3\2\2\2\u01ea\u01e8\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb\u0082\3\2\2\2\u01ec"+
		"\u01f0\7$\2\2\u01ed\u01ef\13\2\2\2\u01ee\u01ed\3\2\2\2\u01ef\u01f2\3\2"+
		"\2\2\u01f0\u01f1\3\2\2\2\u01f0\u01ee\3\2\2\2\u01f1\u01f3\3\2\2\2\u01f2"+
		"\u01f0\3\2\2\2\u01f3\u01f4\7$\2\2\u01f4\u0084\3\2\2\2\u01f5\u01f6\7v\2"+
		"\2\u01f6\u01f7\7t\2\2\u01f7\u01f8\7w\2\2\u01f8\u01ff\7g\2\2\u01f9\u01fa"+
		"\7h\2\2\u01fa\u01fb\7c\2\2\u01fb\u01fc\7n\2\2\u01fc\u01fd\7u\2\2\u01fd"+
		"\u01ff\7g\2\2\u01fe\u01f5\3\2\2\2\u01fe\u01f9\3\2\2\2\u01ff\u0086\3\2"+
		"\2\2\u0200\u0201\7r\2\2\u0201\u0202\7c\2\2\u0202\u0203\7t\2\2\u0203\u0204"+
		"\7g\2\2\u0204\u0205\7p\2\2\u0205\u0206\7v\2\2\u0206\u0088\3\2\2\2\u0207"+
		"\u0208\7e\2\2\u0208\u0209\7w\2\2\u0209\u020a\7t\2\2\u020a\u020b\7t\2\2"+
		"\u020b\u020c\7g\2\2\u020c\u020d\7p\2\2\u020d\u020e\7v\2\2\u020e\u008a"+
		"\3\2\2\2\u020f\u0210\t\3\2\2\u0210\u008c\3\2\2\2\u0211\u0215\t\4\2\2\u0212"+
		"\u0214\t\5\2\2\u0213\u0212\3\2\2\2\u0214\u0217\3\2\2\2\u0215\u0213\3\2"+
		"\2\2\u0215\u0216\3\2\2\2\u0216\u008e\3\2\2\2\u0217\u0215\3\2\2\2\u0218"+
		"\u021a\t\2\2\2\u0219\u0218\3\2\2\2\u021a\u021b\3\2\2\2\u021b\u0219\3\2"+
		"\2\2\u021b\u021c\3\2\2\2\u021c\u021d\3\2\2\2\u021d\u021e\bH\4\2\u021e"+
		"\u0090\3\2\2\2\u021f\u0221\t\6\2\2\u0220\u021f\3\2\2\2\u0221\u0222\3\2"+
		"\2\2\u0222\u0220\3\2\2\2\u0222\u0223\3\2\2\2\u0223\u0224\3\2\2\2\u0224"+
		"\u0225\bI\5\2\u0225\u0092\3\2\2\2\20\2\u009a\u009d\u00a0\u00ac\u01d6\u01de"+
		"\u01e3\u01ea\u01f0\u01fe\u0215\u021b\u0222";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}