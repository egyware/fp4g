grammar FP4G;
 
@header
{
package fp4g.parser;

import static fp4g.Log.*;

import fp4g.data.*;
import fp4g.data.define.*;
import fp4g.data.managers.*;

}

// **** PARSER ****
program : usings game EOF;

usings  : (using)*;

using   : USING ( MANAGER | STATE | BEHAVIOR | ENTITY | GOAL | MESSAGE ) ID DOTCOMA;

game 
returns [String name]  
		:
		 DEFINE GAME ID { $name = $ID.text; } 
		 ABRE_COR gameValues CIERRA_COR		 
		;

gameValues
		:
		 gameValue (gameValue)*
		;

gameValue  
		: define
		| add DOTCOMA
		| on
		;

add 
returns
[
	ObjectType type = null,
	String addName = null,
	String varName = null,	
]
	    :
	      (ID EQUAL {$varName = $ID.text;})?	
		  ADD 
		  ( 
			  	MANAGER  { $type = ObjectType.MANAGER;  }			  	
			  | STATE    { $type = ObjectType.STATE;    }
			  | BEHAVIOR { $type = ObjectType.BEHAVIOR; }
			  | ENTITY   { $type = ObjectType.ENTITY;  }
			  | GOAL     { $type = ObjectType.GOAL;  }
		  )
		  ID { $addName = $ID.text; }
		  ( ABRE_PAR exprList CIERRA_PAR )? 
		;	

define  
returns
[
	
	ObjectType type = null,
	String defName = null
]
		: 
		  DEFINE 
		  	( 
		  		 MANAGER    { $type = ObjectType.MANAGER; }
		  		| STATE     { $type = ObjectType.STATE;   }
		  		| BEHAVIOR  { $type = ObjectType.BEHAVIOR;}
		  		| ENTITY    { $type = ObjectType.ENTITY;  }
		  		| GOAL      { $type = ObjectType.GOAL;    }
		  		| MESSAGE   { $type = ObjectType.MESSAGE; }
		  	) 
		  ID { $defName = $ID.text; } 
		  ( ABRE_PAR nameList CIERRA_PAR )?		  
          ABRE_COR defineValues CIERRA_COR         
        ;

on
returns
[
	String messageName	
]
		:
		ON 
		ID {$messageName = $ID.text; }
		ABRE_COR CIERRA_COR 
		; 
 
defineValues
	    :
	    	defineValue (defineValue)* 
	    ;

defineValue
		:
			add DOTCOMA
			|on
		;

exprList: expr (COMA expr)*;

nameList: declareVar ( COMA declareVar)*;

// sin operaciones booleanes por ahora
expr    :  NOT   op=expr  				 #notExpr
		 | MINUS op=expr 				 #minusExpr
		 | left=expr MULTIPLY right=expr #multExpr
		 | left=expr DIVIDE   right=expr #divExpr
		 | left=expr PLUS     right=expr #addExpr
		 | left=expr MINUS    right=expr #subExpr
		 | ABRE_PAR op=expr CIERRA_PAR   #parExpr
		 
		 | INT_LITERAL     #intLiteral
         | DECIMAL_LITERAL #decimalLiteral
         | STRING_LITERAL  #stringLiteral         
		 | ID			   #id
		 ;

declareVar
		: varType ID;

varType
returns
[
	
	VarType type = null
]
		:
		   INT_TYPE    {$type = VarType.Integer;}
		 | DEC_TYPE    {$type = VarType.Decimal;}
		 | BOOL_TYPE   {$type = VarType.Bool;}
		 | ENTITY_TYPE {$type = VarType.Entity;}
		 //tipos temporales
		 | 'KeyMap'    {$type = VarType.Custom;}
        ;

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

/* Tipos */
INT_TYPE    : 'Int';
DEC_TYPE    : 'Dec';
BOOL_TYPE   : 'Bool';
ENTITY_TYPE : 'Entity';

/* Literales */
INT_LITERAL 	: ( DIGIT)+;
DECIMAL_LITERAL : ( DIGIT)*'.'(DIGIT)+;
STRING_LITERAL  : '"' .*? '"';
BOOL_LITERAL 	: ('true'|'false'); 
fragment DIGIT   : [0-9];

/* Identificador */
ID : [a-zA-Z_][a-zA-Z_0-9]*;


/* ignore */
NL: [\r\n]+ -> skip;
WS: [ \t]+ -> skip;