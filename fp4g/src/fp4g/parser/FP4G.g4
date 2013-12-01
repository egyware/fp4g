grammar FP4G;
 
@header
{
package fp4g.parser;

import static fp4g.Log.*;

import fp4g.data.*;
import fp4g.data.define.*;

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
		| start DOTCOMA
		| on
		;
		
set
returns
[ String key ]
		: SET ID { $key = $ID.text; } EQUAL expr 
		;
start
returns
[ String state ]
	:
	START ID { $state = $ID.text; }
;

add 
returns
[
	DefineType type = null,
	String addName = null,
	String varName = null,	
]
	    :
	      (ID EQUAL {$varName = $ID.text;})?	
		  ADD 
		  ( 
			  	MANAGER  { $type = DefineType.MANAGER;  }			  	
			  | STATE    { $type = DefineType.STATE;    }
			  | BEHAVIOR { $type = DefineType.BEHAVIOR; }
			  | ENTITY   { $type = DefineType.ENTITY;  }
			  | GOAL     { $type = DefineType.GOAL;  }
		  )
		  ID { $addName = $ID.text; }
		  ( ABRE_PAR exprList CIERRA_PAR )? 
		;	

define  
returns
[
	
	DefineType type = null,
	String defName = null
]
		: 
		  DEFINE 
		  	( 
		  		 MANAGER    { $type = DefineType.MANAGER; }
		  		| STATE     { $type = DefineType.STATE;   }
		  		| BEHAVIOR  { $type = DefineType.BEHAVIOR;}
		  		| ENTITY    { $type = DefineType.ENTITY;  }
		  		| GOAL      { $type = DefineType.GOAL;    }
		  		| MESSAGE   { $type = DefineType.MESSAGE; }		  		
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
		ABRE_COR
		on_statements 
		CIERRA_COR 
		;
on_statements
			:
			(on_statement DOTCOMA) *
			;
on_statement:
			send 
			;
send
returns
[String messageMethodName,String receiverName]
	:
		SEND method=ID {$messageMethodName = $method.text;} (ABRE_PAR exprList CIERRA_PAR)? (TO receiver=ID {$receiverName = $receiver.text;})?
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
//filtro methodValue
filter
returns
[
	List<String> filters = new LinkedList<>();
]
		:
		ID      {$filters.add($ID.text);}
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
		| assets
		;

exprList: expr (COMA expr)*;

nameList: declareVar ( COMA declareVar)*;

// sin operaciones booleanes por ahora
expr  
		 :  NOT  op=expr  				 #notExpr
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
		 
array   
returns [ String bean ] 
		:
		 ABRE_LLAV
		 parArray  
		 (COMA parArray)*
		 CIERRA_LLAV
		 (AS ID {$bean = $ID.text;})?
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
		 | ID          {$type = VarType.Custom;} // solo Define del tipo Type
        ;

assetType
returns
[
	AssetType type = null
]
		:
		   TEXTURE_TYPE {$type = AssetType.Texture;}
		 |  SPRITE_TYPE {$type = AssetType.Sprite;}
		 |   ATLAS_TYPE {$type = AssetType.Atlas;}		 
		;
        
assets:
	ASSETS
	ABRE_COR assetValue (COMA assetValue)* COMA? CIERRA_COR
;

assetValue:
	assetType assetName=ID? DOUBLEDOT asset=STRING_LITERAL (assetValuesInner)?	
;

/** diseñadas para no permitir otro nivel adicional de profundidad en los assets */
assetValuesInner:
	ABRE_COR assetValueInner (COMA assetValueInner)* COMA? CIERRA_COR
;

assetValueInner:
	assetType assetName=ID? DOUBLEDOT asset=STRING_LITERAL
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
START      : 'START';
ASSETS     : 'ASSETS';

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
AS		: 'AS';

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

/* Tipos de Assets */
TEXTURE_TYPE: 'Texture';
SPRITE_TYPE : 'Sprite';
ATLAS_TYPE  : 'Atlas';

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