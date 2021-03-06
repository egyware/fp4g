lexer grammar Lexer;

/* comentarios */
SINGLE_LINE_COMMENT: '//' ('\n' | '\r' | .*? ) '\r'? '\n' -> skip;
MULTI_LINE_COMMENT: '/*' .*? '*/' -> skip;

/* keywords */

TYPE       : 'TYPE';
RESOLVER   : 'RESOLVER';
DEFINE     : 'DEFINE';
MODEL      : 'MODEL';
CONTROLLER : 'CONTROLLER';
VIEW       : 'VIEW';
SET        : 'SET'; 

ADD        : 'ADD';
ON         : 'ON';
USING      : 'USING';
START      : 'START';
ASSETS     : 'ASSETS';
FLAG       : 'FLAG';
WHEN       : 'WHEN';


/* auxiliars keywords */
FOR		: 'FOR';

MANAGER : 'MANAGER';
GAME    : 'GAME';
STATE   : 'STATE';
ASSET   : 'ASSET';
BEHAVIOR: 'BEHAVIOR';
ENTITY  : 'ENTITY';
GOAL    : 'GOAL';
MESSAGE : 'MESSAGE';
BASE    : 'BASE';
TO      : 'TO';
SOURCE  : 'SOURCE';	
AS		: 'AS';
OTHER   : 'OTHER';
SELF    : 'SELF';
EMPTY   : 'EMPTY';
THEN    : 'THEN';

/* separators */
ABRE_COR  : '['; 
ABRE_PAR  : '(';
ABRE_LLAV : '{';
CIERRA_COR: ']';
CIERRA_PAR: ')';
CIERRA_LLAV: '}';


COMA      : ',';
EQUAL     : '=';
DOT       : '.';
DOTCOMA   : ';';
DOUBLEDOT  : ':';

/* OPERATORS */
PLUS      : '+';
MINUS     : '-';
MULTIPLY  : '*';
DIVIDE    : '/';
MORE_THAN : '>';
LESS_THAN : '<';
AND       : 'AND';
OR        : 'OR';
XOR       : 'XOR';
NOT       : 'NOT';

/* Tipos */
NUMBER_TYPE : 'Number';
STRING_TYPE : 'String';
BOOL_TYPE   : 'Bool';
/* Tipos Basicos */
INTEGER_TYPE: 'Integer';
DOUBLE_TYPE : 'Double';
FLOAT_TYPE  : 'Float';


/* Literales */
DIRECTCODE      : '@\'' .*? '\''; 
INT_LITERAL 	: ( DIGIT)+;
DECIMAL_LITERAL : ( DIGIT)*'.'(DIGIT)+;
STRING_LITERAL  : '"' .*? '"';
BOOL_LITERAL 	: ('true'|'false');
CURRENT_LITERAL : 'current';
fragment DIGIT  : [0-9];

/* Identificador */
ID : [a-zA-Z_][a-zA-Z_0-9]*;


/* ignore */
NL: [\r\n]+ -> skip;
WS: [ \t]+ -> skip;