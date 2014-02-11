lexer grammar Lexer;

/* comentarios */
SINGLE_LINE_COMMENT: '//' ('\n' | '\r' | .*? ) '\r'? '\n' -> skip;
MULTI_LINE_COMMENT: '/*' .*? '*/' -> skip;

/* keywords */

DEFINE     : 'DEFINE';
ADD        : 'ADD';
ON         : 'ON';
SEND       : 'SEND';
DESTROY    : 'DESTROY';
GROUP      : 'GROUP';
SUBSCRIBE  : 'SUBSCRIBE';
UNSUBSCRIBE: 'UNSUBSCRIBE';
RESUME     : 'RESUME';
PAUSE      : 'PAUSE';
USING      : 'USING'; 
EXIT       : 'EXIT';
SET        : 'SET';
START      : 'START';
ASSETS     : 'ASSETS';

/* auxiliars keywords */
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
PLUS  : '+';
MINUS : '-';
MULTIPLY : '*';
DIVIDE : '/';
AND : 'AND';
OR  : 'OR';
XOR : 'XOR';
NOT : 'NOT';

/* Tipos */
NUMBER_TYPE : 'Number';
STRING_TYPE : 'String';
BOOL_TYPE   : 'Bool';

/* Literales */
DIRECTCODE      : '@\'' .*? '\''; 
INT_LITERAL 	: ( DIGIT)+;
DECIMAL_LITERAL : ( DIGIT)*'.'(DIGIT)+;
STRING_LITERAL  : '"' .*? '"';
BOOL_LITERAL 	: ('true'|'false');
PARENT_LITERAL  : 'parent';
CURRENT_LITERAL : 'current';
fragment DIGIT  : [0-9];

/* Identificador */
ID : [a-zA-Z_][a-zA-Z_0-9]*;



/* ignore */
NL: [\r\n]+ -> skip;
WS: [ \t]+ -> skip;