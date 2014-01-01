grammar FP4G;
import Lexer,Expr; 
 
@parser::header
{
package fp4g.parser;

import static fp4g.Log.*;

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

using   : USING ( MANAGER | STATE | BEHAVIOR | ENTITY | GOAL | MESSAGE ) ID DOTCOMA;

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
		  		| ASSET     { $type = DefineType.ASSET;   }
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
		(onStatement DOTCOMA) * 
		CIERRA_COR 
		;

onStatement :
			  send
			| destroy
			;
			
destroy		:
			DESTROY
			;

send
returns
[String messageMethodName,String receiverName, Send.SendTo receiverType]
	:
	{$receiverType = Send.SendTo.Self;}
	SEND method=ID {$messageMethodName = $method.text;}
	(ABRE_PAR exprList CIERRA_PAR)?
	(
	 TO (
	       receiver=OTHER {$receiverType = Send.SendTo.Other;}
	     | receiver=ID    {$receiverType = null;} //sin especificar todavía
	 	)
	 {$receiverName = $receiver.text;}
	)?
	;
//filtros On:pressA pressB (parsea la disyuncion pressA or pressB)
onFilters
returns
[
	List<List<String>> or = new LinkedList<List<String>>();
]
		:
		filter  {$or.add($filter.filters);} 
		(filter {$or.add($filter.filters);})*		
		;

//filtros y On:pressA,pressB (parsea la conjunciÃ³n pressA and pressB)
//filtro methodValue
filter
returns
[
	List<String> filters = new LinkedList<String>();
]
		:
		ID      {$filters.add($ID.text);}
		(COMA ID {$filters.add($ID.text);})*			
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
		 | ENTITY_TYPE  {$type = BasicType.Entity;}
		 | STRING_TYPE  {$type = BasicType.String;}		 
		 | ID           {$type = new CustomType($ID.text);} // solo Define del tipo Type
        ;
        
assets:
	ASSETS
	ABRE_COR assetValue (COMA assetValue)* COMA? CIERRA_COR
;

assetValue:
	assetType=ID assetName=ID? DOUBLEDOT asset=STRING_LITERAL (innerAssetValues = assetValuesInner)?	
;

/** diseñadas para no permitir otro nivel adicional de profundidad en los assets */
assetValuesInner:
	ABRE_COR assetValueInner (COMA assetValueInner)* COMA? CIERRA_COR
;

assetValueInner:
	assetType=ID assetName=ID? DOUBLEDOT asset=STRING_LITERAL
;