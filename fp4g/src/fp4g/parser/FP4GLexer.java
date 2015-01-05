// Generated from C:\Users\edgardo.moreno\git\fp4g\fp4g\src/fp4g/parser/FP4G.g4 by ANTLR 4.4

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
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SINGLE_LINE_COMMENT=1, MULTI_LINE_COMMENT=2, TYPE=3, RESOLVER=4, DEFINE=5, 
		MODEL=6, CONTROLLER=7, VIEW=8, SET=9, ADD=10, ON=11, USING=12, START=13, 
		ASSETS=14, FLAG=15, WHEN=16, FOR=17, MANAGER=18, GAME=19, STATE=20, ASSET=21, 
		BEHAVIOR=22, ENTITY=23, GOAL=24, MESSAGE=25, BASE=26, TO=27, SOURCE=28, 
		AS=29, OTHER=30, SELF=31, EMPTY=32, THEN=33, ABRE_COR=34, ABRE_PAR=35, 
		ABRE_LLAV=36, CIERRA_COR=37, CIERRA_PAR=38, CIERRA_LLAV=39, COMA=40, EQUAL=41, 
		DOT=42, DOTCOMA=43, DOUBLEDOT=44, PLUS=45, MINUS=46, MULTIPLY=47, DIVIDE=48, 
		MORE_THAN=49, LESS_THAN=50, AND=51, OR=52, XOR=53, NOT=54, NUMBER_TYPE=55, 
		STRING_TYPE=56, BOOL_TYPE=57, INTEGER_TYPE=58, DOUBLE_TYPE=59, FLOAT_TYPE=60, 
		DIRECTCODE=61, INT_LITERAL=62, DECIMAL_LITERAL=63, STRING_LITERAL=64, 
		BOOL_LITERAL=65, CURRENT_LITERAL=66, ID=67, NL=68, WS=69;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'", "'#'", "'$'", "'%'", "'&'", "'''", 
		"'('", "')'", "'*'", "'+'", "','", "'-'", "'.'", "'/'", "'0'", "'1'", 
		"'2'", "'3'", "'4'", "'5'", "'6'", "'7'", "'8'", "'9'", "':'", "';'", 
		"'<'", "'='", "'>'", "'?'", "'@'", "'A'", "'B'", "'C'", "'D'", "'E'"
	};
	public static final String[] ruleNames = {
		"SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT", "TYPE", "RESOLVER", "DEFINE", 
		"MODEL", "CONTROLLER", "VIEW", "SET", "ADD", "ON", "USING", "START", "ASSETS", 
		"FLAG", "WHEN", "FOR", "MANAGER", "GAME", "STATE", "ASSET", "BEHAVIOR", 
		"ENTITY", "GOAL", "MESSAGE", "BASE", "TO", "SOURCE", "AS", "OTHER", "SELF", 
		"EMPTY", "THEN", "ABRE_COR", "ABRE_PAR", "ABRE_LLAV", "CIERRA_COR", "CIERRA_PAR", 
		"CIERRA_LLAV", "COMA", "EQUAL", "DOT", "DOTCOMA", "DOUBLEDOT", "PLUS", 
		"MINUS", "MULTIPLY", "DIVIDE", "MORE_THAN", "LESS_THAN", "AND", "OR", 
		"XOR", "NOT", "NUMBER_TYPE", "STRING_TYPE", "BOOL_TYPE", "INTEGER_TYPE", 
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
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2G\u020d\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\3\2\3\2\3"+
		"\2\3\2\3\2\7\2\u0095\n\2\f\2\16\2\u0098\13\2\5\2\u009a\n\2\3\2\5\2\u009d"+
		"\n\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3\u00a7\n\3\f\3\16\3\u00aa\13\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3"+
		"\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34"+
		"\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\""+
		"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-"+
		"\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\64"+
		"\3\64\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\38\38\38"+
		"\38\38\38\38\39\39\39\39\39\39\39\3:\3:\3:\3:\3:\3;\3;\3;\3;\3;\3;\3;"+
		"\3;\3<\3<\3<\3<\3<\3<\3<\3=\3=\3=\3=\3=\3=\3>\3>\3>\3>\7>\u01c3\n>\f>"+
		"\16>\u01c6\13>\3>\3>\3?\6?\u01cb\n?\r?\16?\u01cc\3@\7@\u01d0\n@\f@\16"+
		"@\u01d3\13@\3@\3@\6@\u01d7\n@\r@\16@\u01d8\3A\3A\7A\u01dd\nA\fA\16A\u01e0"+
		"\13A\3A\3A\3B\3B\3B\3B\3B\3B\3B\3B\3B\5B\u01ed\nB\3C\3C\3C\3C\3C\3C\3"+
		"C\3C\3D\3D\3E\3E\7E\u01fb\nE\fE\16E\u01fe\13E\3F\6F\u0201\nF\rF\16F\u0202"+
		"\3F\3F\3G\6G\u0208\nG\rG\16G\u0209\3G\3G\6\u0096\u00a8\u01c4\u01de\2H"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37"+
		"= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o"+
		"9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085D\u0087\2\u0089E\u008bF\u008d"+
		"G\3\2\7\4\2\f\f\17\17\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\4\2\13\13\"\""+
		"\u0218\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
		"\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2"+
		"G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3"+
		"\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2"+
		"\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2"+
		"m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3"+
		"\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2"+
		"\2\2\2\u0085\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\3"+
		"\u008f\3\2\2\2\5\u00a2\3\2\2\2\7\u00b0\3\2\2\2\t\u00b5\3\2\2\2\13\u00be"+
		"\3\2\2\2\r\u00c5\3\2\2\2\17\u00cb\3\2\2\2\21\u00d6\3\2\2\2\23\u00db\3"+
		"\2\2\2\25\u00df\3\2\2\2\27\u00e3\3\2\2\2\31\u00e6\3\2\2\2\33\u00ec\3\2"+
		"\2\2\35\u00f2\3\2\2\2\37\u00f9\3\2\2\2!\u00fe\3\2\2\2#\u0103\3\2\2\2%"+
		"\u0107\3\2\2\2\'\u010f\3\2\2\2)\u0114\3\2\2\2+\u011a\3\2\2\2-\u0120\3"+
		"\2\2\2/\u0129\3\2\2\2\61\u0130\3\2\2\2\63\u0135\3\2\2\2\65\u013d\3\2\2"+
		"\2\67\u0142\3\2\2\29\u0145\3\2\2\2;\u014c\3\2\2\2=\u014f\3\2\2\2?\u0155"+
		"\3\2\2\2A\u015a\3\2\2\2C\u0160\3\2\2\2E\u0165\3\2\2\2G\u0167\3\2\2\2I"+
		"\u0169\3\2\2\2K\u016b\3\2\2\2M\u016d\3\2\2\2O\u016f\3\2\2\2Q\u0171\3\2"+
		"\2\2S\u0173\3\2\2\2U\u0175\3\2\2\2W\u0177\3\2\2\2Y\u0179\3\2\2\2[\u017b"+
		"\3\2\2\2]\u017d\3\2\2\2_\u017f\3\2\2\2a\u0181\3\2\2\2c\u0183\3\2\2\2e"+
		"\u0185\3\2\2\2g\u0187\3\2\2\2i\u018b\3\2\2\2k\u018e\3\2\2\2m\u0192\3\2"+
		"\2\2o\u0196\3\2\2\2q\u019d\3\2\2\2s\u01a4\3\2\2\2u\u01a9\3\2\2\2w\u01b1"+
		"\3\2\2\2y\u01b8\3\2\2\2{\u01be\3\2\2\2}\u01ca\3\2\2\2\177\u01d1\3\2\2"+
		"\2\u0081\u01da\3\2\2\2\u0083\u01ec\3\2\2\2\u0085\u01ee\3\2\2\2\u0087\u01f6"+
		"\3\2\2\2\u0089\u01f8\3\2\2\2\u008b\u0200\3\2\2\2\u008d\u0207\3\2\2\2\u008f"+
		"\u0090\7\61\2\2\u0090\u0091\7\61\2\2\u0091\u0099\3\2\2\2\u0092\u009a\t"+
		"\2\2\2\u0093\u0095\13\2\2\2\u0094\u0093\3\2\2\2\u0095\u0098\3\2\2\2\u0096"+
		"\u0097\3\2\2\2\u0096\u0094\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2"+
		"\2\2\u0099\u0092\3\2\2\2\u0099\u0096\3\2\2\2\u009a\u009c\3\2\2\2\u009b"+
		"\u009d\7\17\2\2\u009c\u009b\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\3"+
		"\2\2\2\u009e\u009f\7\f\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\b\2\2\2\u00a1"+
		"\4\3\2\2\2\u00a2\u00a3\7\61\2\2\u00a3\u00a4\7,\2\2\u00a4\u00a8\3\2\2\2"+
		"\u00a5\u00a7\13\2\2\2\u00a6\u00a5\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a9"+
		"\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00ab\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab"+
		"\u00ac\7,\2\2\u00ac\u00ad\7\61\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\b\3"+
		"\2\2\u00af\6\3\2\2\2\u00b0\u00b1\7V\2\2\u00b1\u00b2\7[\2\2\u00b2\u00b3"+
		"\7R\2\2\u00b3\u00b4\7G\2\2\u00b4\b\3\2\2\2\u00b5\u00b6\7T\2\2\u00b6\u00b7"+
		"\7G\2\2\u00b7\u00b8\7U\2\2\u00b8\u00b9\7Q\2\2\u00b9\u00ba\7N\2\2\u00ba"+
		"\u00bb\7X\2\2\u00bb\u00bc\7G\2\2\u00bc\u00bd\7T\2\2\u00bd\n\3\2\2\2\u00be"+
		"\u00bf\7F\2\2\u00bf\u00c0\7G\2\2\u00c0\u00c1\7H\2\2\u00c1\u00c2\7K\2\2"+
		"\u00c2\u00c3\7P\2\2\u00c3\u00c4\7G\2\2\u00c4\f\3\2\2\2\u00c5\u00c6\7O"+
		"\2\2\u00c6\u00c7\7Q\2\2\u00c7\u00c8\7F\2\2\u00c8\u00c9\7G\2\2\u00c9\u00ca"+
		"\7N\2\2\u00ca\16\3\2\2\2\u00cb\u00cc\7E\2\2\u00cc\u00cd\7Q\2\2\u00cd\u00ce"+
		"\7P\2\2\u00ce\u00cf\7V\2\2\u00cf\u00d0\7T\2\2\u00d0\u00d1\7Q\2\2\u00d1"+
		"\u00d2\7N\2\2\u00d2\u00d3\7N\2\2\u00d3\u00d4\7G\2\2\u00d4\u00d5\7T\2\2"+
		"\u00d5\20\3\2\2\2\u00d6\u00d7\7X\2\2\u00d7\u00d8\7K\2\2\u00d8\u00d9\7"+
		"G\2\2\u00d9\u00da\7Y\2\2\u00da\22\3\2\2\2\u00db\u00dc\7U\2\2\u00dc\u00dd"+
		"\7G\2\2\u00dd\u00de\7V\2\2\u00de\24\3\2\2\2\u00df\u00e0\7C\2\2\u00e0\u00e1"+
		"\7F\2\2\u00e1\u00e2\7F\2\2\u00e2\26\3\2\2\2\u00e3\u00e4\7Q\2\2\u00e4\u00e5"+
		"\7P\2\2\u00e5\30\3\2\2\2\u00e6\u00e7\7W\2\2\u00e7\u00e8\7U\2\2\u00e8\u00e9"+
		"\7K\2\2\u00e9\u00ea\7P\2\2\u00ea\u00eb\7I\2\2\u00eb\32\3\2\2\2\u00ec\u00ed"+
		"\7U\2\2\u00ed\u00ee\7V\2\2\u00ee\u00ef\7C\2\2\u00ef\u00f0\7T\2\2\u00f0"+
		"\u00f1\7V\2\2\u00f1\34\3\2\2\2\u00f2\u00f3\7C\2\2\u00f3\u00f4\7U\2\2\u00f4"+
		"\u00f5\7U\2\2\u00f5\u00f6\7G\2\2\u00f6\u00f7\7V\2\2\u00f7\u00f8\7U\2\2"+
		"\u00f8\36\3\2\2\2\u00f9\u00fa\7H\2\2\u00fa\u00fb\7N\2\2\u00fb\u00fc\7"+
		"C\2\2\u00fc\u00fd\7I\2\2\u00fd \3\2\2\2\u00fe\u00ff\7Y\2\2\u00ff\u0100"+
		"\7J\2\2\u0100\u0101\7G\2\2\u0101\u0102\7P\2\2\u0102\"\3\2\2\2\u0103\u0104"+
		"\7H\2\2\u0104\u0105\7Q\2\2\u0105\u0106\7T\2\2\u0106$\3\2\2\2\u0107\u0108"+
		"\7O\2\2\u0108\u0109\7C\2\2\u0109\u010a\7P\2\2\u010a\u010b\7C\2\2\u010b"+
		"\u010c\7I\2\2\u010c\u010d\7G\2\2\u010d\u010e\7T\2\2\u010e&\3\2\2\2\u010f"+
		"\u0110\7I\2\2\u0110\u0111\7C\2\2\u0111\u0112\7O\2\2\u0112\u0113\7G\2\2"+
		"\u0113(\3\2\2\2\u0114\u0115\7U\2\2\u0115\u0116\7V\2\2\u0116\u0117\7C\2"+
		"\2\u0117\u0118\7V\2\2\u0118\u0119\7G\2\2\u0119*\3\2\2\2\u011a\u011b\7"+
		"C\2\2\u011b\u011c\7U\2\2\u011c\u011d\7U\2\2\u011d\u011e\7G\2\2\u011e\u011f"+
		"\7V\2\2\u011f,\3\2\2\2\u0120\u0121\7D\2\2\u0121\u0122\7G\2\2\u0122\u0123"+
		"\7J\2\2\u0123\u0124\7C\2\2\u0124\u0125\7X\2\2\u0125\u0126\7K\2\2\u0126"+
		"\u0127\7Q\2\2\u0127\u0128\7T\2\2\u0128.\3\2\2\2\u0129\u012a\7G\2\2\u012a"+
		"\u012b\7P\2\2\u012b\u012c\7V\2\2\u012c\u012d\7K\2\2\u012d\u012e\7V\2\2"+
		"\u012e\u012f\7[\2\2\u012f\60\3\2\2\2\u0130\u0131\7I\2\2\u0131\u0132\7"+
		"Q\2\2\u0132\u0133\7C\2\2\u0133\u0134\7N\2\2\u0134\62\3\2\2\2\u0135\u0136"+
		"\7O\2\2\u0136\u0137\7G\2\2\u0137\u0138\7U\2\2\u0138\u0139\7U\2\2\u0139"+
		"\u013a\7C\2\2\u013a\u013b\7I\2\2\u013b\u013c\7G\2\2\u013c\64\3\2\2\2\u013d"+
		"\u013e\7D\2\2\u013e\u013f\7C\2\2\u013f\u0140\7U\2\2\u0140\u0141\7G\2\2"+
		"\u0141\66\3\2\2\2\u0142\u0143\7V\2\2\u0143\u0144\7Q\2\2\u01448\3\2\2\2"+
		"\u0145\u0146\7U\2\2\u0146\u0147\7Q\2\2\u0147\u0148\7W\2\2\u0148\u0149"+
		"\7T\2\2\u0149\u014a\7E\2\2\u014a\u014b\7G\2\2\u014b:\3\2\2\2\u014c\u014d"+
		"\7C\2\2\u014d\u014e\7U\2\2\u014e<\3\2\2\2\u014f\u0150\7Q\2\2\u0150\u0151"+
		"\7V\2\2\u0151\u0152\7J\2\2\u0152\u0153\7G\2\2\u0153\u0154\7T\2\2\u0154"+
		">\3\2\2\2\u0155\u0156\7U\2\2\u0156\u0157\7G\2\2\u0157\u0158\7N\2\2\u0158"+
		"\u0159\7H\2\2\u0159@\3\2\2\2\u015a\u015b\7G\2\2\u015b\u015c\7O\2\2\u015c"+
		"\u015d\7R\2\2\u015d\u015e\7V\2\2\u015e\u015f\7[\2\2\u015fB\3\2\2\2\u0160"+
		"\u0161\7V\2\2\u0161\u0162\7J\2\2\u0162\u0163\7G\2\2\u0163\u0164\7P\2\2"+
		"\u0164D\3\2\2\2\u0165\u0166\7]\2\2\u0166F\3\2\2\2\u0167\u0168\7*\2\2\u0168"+
		"H\3\2\2\2\u0169\u016a\7}\2\2\u016aJ\3\2\2\2\u016b\u016c\7_\2\2\u016cL"+
		"\3\2\2\2\u016d\u016e\7+\2\2\u016eN\3\2\2\2\u016f\u0170\7\177\2\2\u0170"+
		"P\3\2\2\2\u0171\u0172\7.\2\2\u0172R\3\2\2\2\u0173\u0174\7?\2\2\u0174T"+
		"\3\2\2\2\u0175\u0176\7\60\2\2\u0176V\3\2\2\2\u0177\u0178\7=\2\2\u0178"+
		"X\3\2\2\2\u0179\u017a\7<\2\2\u017aZ\3\2\2\2\u017b\u017c\7-\2\2\u017c\\"+
		"\3\2\2\2\u017d\u017e\7/\2\2\u017e^\3\2\2\2\u017f\u0180\7,\2\2\u0180`\3"+
		"\2\2\2\u0181\u0182\7\61\2\2\u0182b\3\2\2\2\u0183\u0184\7@\2\2\u0184d\3"+
		"\2\2\2\u0185\u0186\7>\2\2\u0186f\3\2\2\2\u0187\u0188\7C\2\2\u0188\u0189"+
		"\7P\2\2\u0189\u018a\7F\2\2\u018ah\3\2\2\2\u018b\u018c\7Q\2\2\u018c\u018d"+
		"\7T\2\2\u018dj\3\2\2\2\u018e\u018f\7Z\2\2\u018f\u0190\7Q\2\2\u0190\u0191"+
		"\7T\2\2\u0191l\3\2\2\2\u0192\u0193\7P\2\2\u0193\u0194\7Q\2\2\u0194\u0195"+
		"\7V\2\2\u0195n\3\2\2\2\u0196\u0197\7P\2\2\u0197\u0198\7w\2\2\u0198\u0199"+
		"\7o\2\2\u0199\u019a\7d\2\2\u019a\u019b\7g\2\2\u019b\u019c\7t\2\2\u019c"+
		"p\3\2\2\2\u019d\u019e\7U\2\2\u019e\u019f\7v\2\2\u019f\u01a0\7t\2\2\u01a0"+
		"\u01a1\7k\2\2\u01a1\u01a2\7p\2\2\u01a2\u01a3\7i\2\2\u01a3r\3\2\2\2\u01a4"+
		"\u01a5\7D\2\2\u01a5\u01a6\7q\2\2\u01a6\u01a7\7q\2\2\u01a7\u01a8\7n\2\2"+
		"\u01a8t\3\2\2\2\u01a9\u01aa\7K\2\2\u01aa\u01ab\7p\2\2\u01ab\u01ac\7v\2"+
		"\2\u01ac\u01ad\7g\2\2\u01ad\u01ae\7i\2\2\u01ae\u01af\7g\2\2\u01af\u01b0"+
		"\7t\2\2\u01b0v\3\2\2\2\u01b1\u01b2\7F\2\2\u01b2\u01b3\7q\2\2\u01b3\u01b4"+
		"\7w\2\2\u01b4\u01b5\7d\2\2\u01b5\u01b6\7n\2\2\u01b6\u01b7\7g\2\2\u01b7"+
		"x\3\2\2\2\u01b8\u01b9\7H\2\2\u01b9\u01ba\7n\2\2\u01ba\u01bb\7q\2\2\u01bb"+
		"\u01bc\7c\2\2\u01bc\u01bd\7v\2\2\u01bdz\3\2\2\2\u01be\u01bf\7B\2\2\u01bf"+
		"\u01c0\7)\2\2\u01c0\u01c4\3\2\2\2\u01c1\u01c3\13\2\2\2\u01c2\u01c1\3\2"+
		"\2\2\u01c3\u01c6\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c5"+
		"\u01c7\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c7\u01c8\7)\2\2\u01c8|\3\2\2\2\u01c9"+
		"\u01cb\5\u0087D\2\u01ca\u01c9\3\2\2\2\u01cb\u01cc\3\2\2\2\u01cc\u01ca"+
		"\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd~\3\2\2\2\u01ce\u01d0\5\u0087D\2\u01cf"+
		"\u01ce\3\2\2\2\u01d0\u01d3\3\2\2\2\u01d1\u01cf\3\2\2\2\u01d1\u01d2\3\2"+
		"\2\2\u01d2\u01d4\3\2\2\2\u01d3\u01d1\3\2\2\2\u01d4\u01d6\7\60\2\2\u01d5"+
		"\u01d7\5\u0087D\2\u01d6\u01d5\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8\u01d6"+
		"\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9\u0080\3\2\2\2\u01da\u01de\7$\2\2\u01db"+
		"\u01dd\13\2\2\2\u01dc\u01db\3\2\2\2\u01dd\u01e0\3\2\2\2\u01de\u01df\3"+
		"\2\2\2\u01de\u01dc\3\2\2\2\u01df\u01e1\3\2\2\2\u01e0\u01de\3\2\2\2\u01e1"+
		"\u01e2\7$\2\2\u01e2\u0082\3\2\2\2\u01e3\u01e4\7v\2\2\u01e4\u01e5\7t\2"+
		"\2\u01e5\u01e6\7w\2\2\u01e6\u01ed\7g\2\2\u01e7\u01e8\7h\2\2\u01e8\u01e9"+
		"\7c\2\2\u01e9\u01ea\7n\2\2\u01ea\u01eb\7u\2\2\u01eb\u01ed\7g\2\2\u01ec"+
		"\u01e3\3\2\2\2\u01ec\u01e7\3\2\2\2\u01ed\u0084\3\2\2\2\u01ee\u01ef\7e"+
		"\2\2\u01ef\u01f0\7w\2\2\u01f0\u01f1\7t\2\2\u01f1\u01f2\7t\2\2\u01f2\u01f3"+
		"\7g\2\2\u01f3\u01f4\7p\2\2\u01f4\u01f5\7v\2\2\u01f5\u0086\3\2\2\2\u01f6"+
		"\u01f7\t\3\2\2\u01f7\u0088\3\2\2\2\u01f8\u01fc\t\4\2\2\u01f9\u01fb\t\5"+
		"\2\2\u01fa\u01f9\3\2\2\2\u01fb\u01fe\3\2\2\2\u01fc\u01fa\3\2\2\2\u01fc"+
		"\u01fd\3\2\2\2\u01fd\u008a\3\2\2\2\u01fe\u01fc\3\2\2\2\u01ff\u0201\t\2"+
		"\2\2\u0200\u01ff\3\2\2\2\u0201\u0202\3\2\2\2\u0202\u0200\3\2\2\2\u0202"+
		"\u0203\3\2\2\2\u0203\u0204\3\2\2\2\u0204\u0205\bF\2\2\u0205\u008c\3\2"+
		"\2\2\u0206\u0208\t\6\2\2\u0207\u0206\3\2\2\2\u0208\u0209\3\2\2\2\u0209"+
		"\u0207\3\2\2\2\u0209\u020a\3\2\2\2\u020a\u020b\3\2\2\2\u020b\u020c\bG"+
		"\2\2\u020c\u008e\3\2\2\2\20\2\u0096\u0099\u009c\u00a8\u01c4\u01cc\u01d1"+
		"\u01d8\u01de\u01ec\u01fc\u0202\u0209\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}