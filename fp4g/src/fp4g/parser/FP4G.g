grammar FP4G;
 
@header
{
package fp4g.parser;

import fp4g.data.*;
import fp4g.data.define.*;
import fp4g.data.managers.*;
}

// **** PARSER ****
program : usings game EOF;

usings  : (using)*;

using   : USING ( MANAGER | STATE | BEHAVIOR | ENTITY | GOAL | MESSAGE ) ID DOTCOMA;

game 
returns[String name]  
		 :
		 DEFINE GAME ID { $name = $ID.text; } 
		 ABRE_COR values CIERRA_COR		 
		 ;

values  : value ( value)*?;

value   :  define
		 | add DOTCOMA
		;

add     : ADD ( MANAGER | STATE | BEHAVIOR | ENTITY | GOAL ) ID ( ABRE_PAR exprlist CIERRA_PAR )? 
		;
	

define  : DEFINE ( MANAGER | STATE | BEHAVIOR | ENTITY | GOAL | MESSAGE ) ID ( ABRE_PAR namelist CIERRA_PAR )?
          ABRE_COR values CIERRA_COR
        ; 

exprlist: expr ( COMA expr)*;

namelist: declareVar ( COMA declareVar)*;

expr    : expr binary expr 			# binaryExpr
		 | unary expr  				# unaryExpr
		 | ABRE_PAR expr CIERRA_PAR # parExpr
		 | INT_LITERAL  			#intLiteral
         | DECIMAL_LITERAL 			#decimalLiteral
         | STRING_LITERAL 			#stringLiteral
         | BOOL_LITERAL				#boolLiteral
		 | ID						#id
		 ;

binary  : MULTIPLY
		 | DIVIDE
		 | PLUS
         | MINUS
         | AND
         | OR
         | XOR
        ;

unary   : NOT
        ;
		 
		 

declareVar
		: ID DOBLEDOT ID; 

 
/*assignment : ID '=' expression;
 
//***** LEXER *****

/* comentarios */
SINGLE_LINE_COMMENT: '//' ('\n' | '\r' | .*? ) '\r'? '\n' -> skip;
MULTI_LINE_COMMENT: '/*' * .*? '*/' -> skip;

/* keywords */

DEFINE     : 'DEFINE';
ADD        : 'ADD';
ON         : 'ON';
SEND       : 'SEND';
GROUP      : 'GROUP';
SUBSCRIBE  : 'SUBSCRIBE';
UNSUBSCRIBE: 'UNSUBSCRIBE';
START      : 'START';
RESUME     : 'RESUME';
PAUSE      : 'PAUSE';
USING      : 'USING'; 
EXIT       : 'EXIT';

/* auxiliars keywords */
MANAGER : 'MANAGER';
GAME    : 'GAME';
STATE   : 'STATE';
BEHAVIOR: 'BEHAVIOR';
ENTITY  : 'ENTITY';
GOAL    : 'GOAL';
MESSAGE : 'MESSAGE';
BASE    : 'BASE';
TO      : 'TO';
SOURCE  : 'SOURCE';	

/* separators */
ABRE_COR  : '['; 
ABRE_PAR  : '(';
CIERRA_COR: ']';
CIERRA_PAR: ')';
COMA      : ',';
EQUAL     : '=';
DOT       : '.';
DOTCOMA   : ';';
DOBLEDOT  : ':';

/* OPERATORS */
PLUS  : '+';
MINUS : '-';
MULTIPLY : '*';
DIVIDE : '/';
AND : 'AND';
OR  : 'OR';
XOR : 'XOR';
NOT : 'NOT';

/* Literales */
INT_LITERAL 	: ( DIGIT)+;
DECIMAL_LITERAL : ( DIGIT)*'.'(DIGIT)+;
STRING_LITERAL  : '"'*?'"';
BOOL_LITERAL 	: ('true'|'false'); 
fragment DIGIT   : [0-9];

/* Identificador */
ID : [a-zA-Z_][a-zA-Z_0-9]*;


NL: [\r\n]+ -> skip;
/* ignore */
WS: [ \t]+ -> skip;