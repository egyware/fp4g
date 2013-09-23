grammar FP4G;
 
@header
{
package fp4g.parser;

import static fp4g.Log.*;

import fp4g.data.*;
import fp4g.data.define.*;
import fp4g.data.managers.*;

import java.util.LinkedList;

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
		| set DOTCOMA
		| on
		;
		
set
returns
[ String key ]
		: SET ID { $key = $ID.text; } EQUAL expr 
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
		(DOUBLEDOT filters = onFilters)?
		ABRE_COR CIERRA_COR 
		; 
//filtros On:pressA pressB (parsea la disyuncion pressA or pressB)
onFilters
returns
[
	List<List<String>> or = new LinkedList<>();
]
		:
		filter  {$or.add($filter.filters);} 
		(filter {$or.add($filter.filters);})*		
		;

//filtros y On:pressA,pressB (parsea la conjunción pressA and pressB)
filter
returns
[
	List<String> filters = new LinkedList<>();
]
		:
		ID       {$filters.add($ID.text);}
		(COMA ID {$filters.add($ID.text);})*			
		;

 
defineValues
	    :
	    defineValue (defineValue)* 
	    ;

defineValue
		:
		add DOTCOMA
		| set DOTCOMA
		| on		
		;

exprList: expr (COMA expr)*;

nameList: declareVar ( COMA declareVar)*;

// sin operaciones booleanes por ahora
expr  
		 :  NOT   op=expr  				 #notExpr
		 | MINUS op=expr 				 #minusExpr
		 | left=expr MULTIPLY right=expr #multExpr
		 | left=expr DIVIDE   right=expr #divExpr
		 | left=expr PLUS     right=expr #addExpr
		 | left=expr MINUS    right=expr #subExpr
		 | ABRE_PAR op=expr CIERRA_PAR   #parExpr
		 | functionName=ID 
		   ABRE_PAR exprList CIERRA_PAR  #functionCallExpr
		 
		 | array           #arrayExpr
		 | INT_LITERAL     #intLiteral
         | DECIMAL_LITERAL #decimalLiteral
         | STRING_LITERAL  #stringLiteral
         | DIRECTCODE      #directCode
		 | ID			   #id
		 ;
		 
array    :
		 ABRE_LLAV
		 parArray  
		 (COMA parArray)*
		 CIERRA_LLAV 	
   		 ;
   		 
parArray 
returns
[
	String key	
]
		 :
		 ID { $key = $ID.text; } EQUAL expr
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
		 | STRING_TYPE {$type = VarType.String;}
		 //tipos temporales
		 | 'KeyMap'    {$type = VarType.Custom;}
        ;

//***** LEXER *****

/* comentarios */
SINGLE_LINE_COMMENT: '//' ('\n' | '\r' | .*? ) '\r'? '\n' -> skip;
MULTI_LINE_COMMENT: '/*' .*? '*/' -> skip;

/* keywords */

DEFINE     : 'DEFINE';
ADD        : 'ADD';
ON         : 'ON';
SEND       : 'SEND';
GROUP      : 'GROUP';
SUBSCRIBE  : 'SUBSCRIBE';
UNSUBSCRIBE: 'UNSUBSCRIBE';
RESUME     : 'RESUME';
PAUSE      : 'PAUSE';
USING      : 'USING'; 
EXIT       : 'EXIT';
SET        : 'SET';

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
INT_TYPE    : 'Int';
DEC_TYPE    : 'Dec';
STRING_TYPE : 'String';
BOOL_TYPE   : 'Bool';
ENTITY_TYPE : 'Entity';

/* Literales */
DIRECTCODE      : '@\'' .*? '\''; 
INT_LITERAL 	: ( DIGIT)+;
DECIMAL_LITERAL : ( DIGIT)*'.'(DIGIT)+;
STRING_LITERAL  : '"' .*? '"';
BOOL_LITERAL 	: ('true'|'false'); 
fragment DIGIT  : [0-9];

/* Identificador */
ID : [a-zA-Z_][a-zA-Z_0-9]*;


/* ignore */
NL: [\r\n]+ -> skip;
WS: [ \t]+ -> skip;