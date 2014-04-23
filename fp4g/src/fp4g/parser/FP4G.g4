grammar FP4G;
import Lexer,Expr; 
 
@parser::header
{
package fp4g.parser;

import static fp4g.log.Log.*;

import fp4g.data.*;
import fp4g.data.statements.*;
import fp4g.data.define.*;
import fp4g.data.vartypes.*;

import java.util.LinkedList;
}

@lexer::header
{
package fp4g.parser;
}

// **** PARSER ****
program : usings game EOF;

usings  : (using)*;

using
returns
[
	DefineType type = null,
]   
		: USING 
			(
			   MANAGER  { $type = DefineType.MANAGER; }
			 | STATE    { $type = DefineType.STATE;   }
			 | BEHAVIOR { $type = DefineType.BEHAVIOR;}
			 | ENTITY   { $type = DefineType.ENTITY;  }
			 | GOAL     { $type = DefineType.GOAL;    }
			 | MESSAGE  { $type = DefineType.MESSAGE; }
			 | ID       { $type = DefineType.valueOf($ID.text);}
			) 
		  name = ID DOTCOMA
		  (ABRE_COR usingValues CIERRA_COR)?
		;
usingValues
:
	(usingValue)*
;

usingValue
:
	  add DOTCOMA
	| set DOTCOMA			
;

game 
returns [String name]  
		:
		 DEFINE GAME ID { $name = $ID.text; } 
		 ABRE_COR gameValues CIERRA_COR		 
		;

//Util para las futuras bibliotecas de FP4G		
gameLib
		:
		 DEFINE GAME
		 ABRE_COR gameValues CIERRA_COR		 
		;

gameValues
		:
		  (gameValue)* 
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

subscribe
    :
    SUBSCRIBE where=ID ON message=ID (DOUBLEDOT method=ID)?
;

unsubscribe
    :
    UNSUBSCRIBE where=ID ON message=ID (DOUBLEDOT method=ID)?    
;

add 
:	      	
	  ADD
	  addDefine |
	  addMethod 
;

addDefine
returns
[
	DefineType type = null,
	String addName = null	
]
:
		 (
			  	MANAGER  { $type = DefineType.MANAGER;  }			  	
			  | STATE    { $type = DefineType.STATE;    }
			  | BEHAVIOR { $type = DefineType.BEHAVIOR; }
			  | ENTITY   { $type = DefineType.ENTITY;  }
			  | GOAL     { $type = DefineType.GOAL;  }			  
		 )
		 ID { $addName = $ID.text; }
		 ( ABRE_PAR exprList CIERRA_PAR )?
		 ( exprParams = array )?
;	

addMethod
returns
[
	String addName = null	
]
:
	 ID { $addName = $ID.text; }
	 ABRE_PAR nameList CIERRA_PAR
	 ( exprParams = array )?
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
		  		| ASSET     { $type = DefineType.ASSET;   }
		  		| ID       { $type = DefineType.valueOf($ID.text);}
		  	) 
		  ID { $defName = $ID.text; } 
		  ( ABRE_PAR  = nameList CIERRA_PAR )?		  
          ABRE_COR defineValues CIERRA_COR         
        ;

on
returns
[
	String messageName	
]
locals
[
	Message message,
	OrFilters orFilters
]
		:
		ON 
		ID {$messageName = $ID.text; }
		(DOUBLEDOT filters = onFilters)?
		ABRE_COR
		statements = onStatements
		CIERRA_COR 
		;

onStatements:
			(onStatement DOTCOMA) *
		;		

onStatement :
			  send
			| destroy
			| subscribe
			| unsubscribe
			;
			
destroy		:
			DESTROY
			;

send
returns
[String messageMethodName,String receiverName, Instance receiverType]
	:
	{$receiverType = Instance.Self;}
	SEND method=ID {$messageMethodName = $method.text;}
	(ABRE_PAR exprList CIERRA_PAR)?
	(
	 TO (
	       receiver=OTHER {$receiverType = Instance.Other;}
	     | receiver=GAME  {$receiverType = Instance.Game;}  
	     | receiver=ID    {$receiverType = null;} //sin especificar todav�a
	 	)
	 {$receiverName = $receiver.text;}
	)?
	;
	
//filtros separados por espacios, es en caso que se cumpla otra condici�n tambi�n
onFilters
locals
[
 	OrFilters orFilters,
 	Message message
]
		:
		filter (filter)*
		;

filter
returns
[
	String filterName;
]
locals
[
    Message message
]
		:
		ID {$filterName = $ID.text;}
		( ABRE_PAR exprList CIERRA_PAR )?
		;


 
defineValues
	    :
	      (defineValue)* 
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

declareVar
		: varType varName=ID (EQUAL initValue = expr)?;

varType
returns
[
	
	VarType type = null
]
		:
		   NUMBER_TYPE  {$type = BasicType.Number;}
		 | BOOL_TYPE    {$type = BasicType.Bool;}		 
		 | STRING_TYPE  {$type = BasicType.String;}		 
		 | ID           {$type = new CustomType($ID.text);} // solo Define del tipo Type
        ;
        
assets:
	ASSETS
	ABRE_COR 
		assetValueWithInnerValue
		(
			COMA
			assetValueWithInnerValue
		)* COMA?
	 CIERRA_COR
;

assetValueWithInnerValue:
	value = assetValue (innerAssets = assetValuesInner)?
;

assetValue
:
	assetType=ID assetName=ID? DOUBLEDOT assetPath = STRING_LITERAL ( exprParams = array )?
;


assetValuesInner:
	ABRE_COR assetValue (COMA assetValue)* COMA? CIERRA_COR
;