grammar FP4G;
import Lexer,Expr; 
 
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
	List<List<String>> or = new LinkedList<List<String>>();
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

/** dise�adas para no permitir otro nivel adicional de profundidad en los assets */
assetValuesInner:
	ABRE_COR assetValueInner (COMA assetValueInner)* COMA? CIERRA_COR
;

assetValueInner:
	assetType assetName=ID? DOUBLEDOT asset=STRING_LITERAL
;