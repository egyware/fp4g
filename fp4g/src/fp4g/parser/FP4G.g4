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
program : usings programBody EOF;

parseLib: usings libBody EOF;

usings  : (using)*;

libBody     : (set DOTCOMA | define)*;

programBody : (set DOTCOMA | game | define)*;

using
returns
[
	DefineType type = null,
]   
		: USING 
			(
			   MANAGER  { $type = DefineTypes.MANAGER; }
			 | STATE    { $type = DefineTypes.STATE;   }
			 | BEHAVIOR { $type = DefineTypes.BEHAVIOR;}
			 | ENTITY   { $type = DefineTypes.ENTITY;  }
			 | GOAL     { $type = DefineTypes.GOAL;    }
			 | MESSAGE  { $type = DefineTypes.MESSAGE; }
			 | ID       { $type = DefineTypes.getDefineTypeByName($ID.text);}
			) 
		  name = ID (DOTCOMA | ABRE_COR usingValues CIERRA_COR)		  
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
		
gameValues:
	(gameValue)*
;

gameValue  
		: 
		  add DOTCOMA
		| set DOTCOMA		
		| when DOTCOMA
		| on
		| flag DOTCOMA
		;
	



set
returns
[ String key ]
		: SET ID { $key = $ID.text; } EQUAL expr 
		;


add 
:	      	
	  ADD
	  (
	   addDefine |
	   addMethod
	  ) 
;

addDefine
returns
[
	DefineType type = null,
	String addName = null	
]
:
		 (
			  	MANAGER  { $type = DefineTypes.MANAGER;  }			  	
			  | STATE    { $type = DefineTypes.STATE;    }
			  | BEHAVIOR { $type = DefineTypes.BEHAVIOR; }
			  | ENTITY   { $type = DefineTypes.ENTITY;  }
			  | GOAL     { $type = DefineTypes.GOAL;  }			  
		 )
		 ID { $addName = $ID.text; }
		 ( ABRE_PAR exprList? CIERRA_PAR )?
		 ( exprParams = array )?
;	

addMethod
returns
[
	String addName = null	
]
:
	 ID { $addName = $ID.text; }
	 ABRE_PAR nameList? CIERRA_PAR
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
		  		 MANAGER    { $type = DefineTypes.MANAGER; }
		  		| STATE     { $type = DefineTypes.STATE;   }
		  		| BEHAVIOR  { $type = DefineTypes.BEHAVIOR;}
		  		| ENTITY    { $type = DefineTypes.ENTITY;  }
		  		| GOAL      { $type = DefineTypes.GOAL;    }
		  		| MESSAGE   { $type = DefineTypes.MESSAGE; }		  		
		  		| ASSET     { $type = DefineTypes.ASSET;   }
		  		| ID        { $type = DefineTypes.getDefineTypeByName($ID.text);}
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
		statements
		CIERRA_COR 
		;

statements:
			(statement DOTCOMA) *
		;		

statement
		:
		  functionCall
		| assign
		;

functionCall 
		:
		name=ID //nombre de la funcion
		functionExprList?
		;
functionExprList
		:
		expr+   //expresiones separadas por ESPACIOS
		;

assign
:
	varName = ID  EQUAL expr
;
	
//filtros separados por espacios, es en caso que se cumpla otra condición también
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
		( ABRE_PAR exprList? CIERRA_PAR )?
		;


 
defineValues
	    :
	      (defineValue)* 
	    ;

defineValue
		:
		  assets
		| add DOTCOMA
		| set DOTCOMA
		| flag DOTCOMA
		| when DOTCOMA
		| on		 
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
		   NUMBER_TYPE   {$type = BasicType.Number;}
		 | BOOL_TYPE     {$type = BasicType.Bool;}		 
		 | STRING_TYPE   {$type = BasicType.String;}
		 | INTEGER_TYPE  {$type = BasicType.Integer;}
		 | DOUBLE_TYPE   {$type = BasicType.Double;}
		 | FLOAT_TYPE    {$type = BasicType.Float;}
		 | id = defineID {$type = new CustomType(($id.type != null)?DefineTypes.getDefineTypeByName($id.type):DefineTypes.STRUCT, $id.name);} // solo Define del tipo Type
        ;

defineID
returns
[
	String type,
	String name
]
       :
       (defineType = ID DOUBLEDOT {$type = $defineType.text;})?
       defineName = ID {$name = $defineName.text;}
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


assetValuesInner
:
	ABRE_COR assetValue (COMA assetValue)* COMA? CIERRA_COR
;

flag
:
	FLAG declareVar
;

when
:
	WHEN condition = expr THEN stmnt = statement
;

