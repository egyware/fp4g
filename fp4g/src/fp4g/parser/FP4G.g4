grammar FP4G;
import Lexer,Expr; 
 
@parser::header
{
package fp4g.parser;

import static fp4g.log.Log.*;

import fp4g.core.*;
import fp4g.data.*;
import fp4g.data.statements.*;
import fp4g.data.define.*;
import fp4g.data.vartypes.*;

import java.util.LinkedList;

}

@parser::members
{
private ILib lib; 

public void setValue(Object o, String key, Object value)
{
	if(value instanceof Expresion)
	{
		value = ((Expresion)value).eval(lib);
	}
	if(value instanceof IValue)
	{
		value = ((IValue)value).getValue();
	}
	BeanAccess.setValue(o,key,value);
}
}

@lexer::header
{
package fp4g.parser;
}



// **** PARSER ****
program : programBody EOF;

parseLib: libBody EOF;

usings  : (using)*;

libBody     : (set[lib] DOTCOMA | define)*;

programBody : (set[lib] DOTCOMA | game | define)*;

type
returns
[
	Type value;
]
   		:
		TYPE ABRE_PAR typeName=ID CIERRA_PAR { $value = lib.getType($typeName.text); }
		;

define
		:
		DEFINE 
		(		
			TYPE typeName=ID { Type t = new Type(); t.setName($typeName.text); lib.registerType(t); } |				
			MODEL modelName=ID ABRE_PAR modelClass=STRING_LITERAL CIERRA_PAR { Model m = new Model(); m.setName($modelName.text); m.setModel($modelClass.text); lib.registerModel(m); } |
			CONTROLLER controllerName=ID ABRE_PAR controllerClass=STRING_LITERAL CIERRA_PAR { Controller c = new Controller(); lib.registerContronller(c); } |
			VIEW viewName=ID ABRE_PAR viewPath=STRING_LITERAL CIERRA_PAR  { View v = new View(); lib.registerView(v); } 	
		)
		;
		
resolver
returns
[
	Resolver r;
]
locals
[
	Type t;
]
@init
{ 
	List<String> imports = new LinkedList<String>(); 
}
@after 
{
	$r.setSources(imports);
	lib.registerResolver($t, $r);
}
			: 
			RESOLVER name=ID { $r = new Resolver(lib.getType($name.text)); lib.registerResolver($r); }
			ABRE_COR
				(set[$r] DOTCOMA)*
				(string=STRING_LITERAL COMA { imports.add($string.text); })* (string2=STRING_LITERAL { imports.add($string2.text); })?  DOTCOMA
			CIERRA_COR
			FOR type {$t = $type.value; }
			;

// SET llave = 5
set[ Object object ]
			:
			SET key=ID EQUAL expr { setValue($object,$key.text,$expr.value); } 
			;

using
returns
[
	DefineType type3 = null,
]   
		: USING 
			(
			   MANAGER  { $type3 = DefineTypes.MANAGER; }
			 | STATE    { $type3 = DefineTypes.STATE;   }
			 | BEHAVIOR { $type3 = DefineTypes.BEHAVIOR;}
			 | ENTITY   { $type3 = DefineTypes.ENTITY;  }
			 | GOAL     { $type3 = DefineTypes.GOAL;    }
			 | MESSAGE  { $type3 = DefineTypes.MESSAGE; }
			 | ID       { $type3 = DefineTypes.getDefineTypeByName($ID.text);}
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
	| set[null] DOTCOMA			
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
		| set[null] DOTCOMA		
		| when DOTCOMA
		| on
		| flag DOTCOMA
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
	DefineType type3 = null,
	String addName = null	
]
:
		 (
			  	MANAGER  { $type3 = DefineTypes.MANAGER;  }			  	
			  | STATE    { $type3 = DefineTypes.STATE;    }
			  | BEHAVIOR { $type3 = DefineTypes.BEHAVIOR; }
			  | ENTITY   { $type3 = DefineTypes.ENTITY;  }
			  | GOAL     { $type3 = DefineTypes.GOAL;  }			  
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

define2  
returns
[
	
	DefineType type3 = null,
	String defName = null
]
		: 
		  DEFINE 
		  	( 
		  		 MANAGER    { $type3 = DefineTypes.MANAGER; }
		  		| STATE     { $type3 = DefineTypes.STATE;   }
		  		| BEHAVIOR  { $type3 = DefineTypes.BEHAVIOR;}
		  		| ENTITY    { $type3 = DefineTypes.ENTITY;  }
		  		| GOAL      { $type3 = DefineTypes.GOAL;    }
		  		| MESSAGE   { $type3 = DefineTypes.MESSAGE; }		  		
		  		| ASSET     { $type3 = DefineTypes.ASSET;   }
		  		| ID        { $type3 = DefineTypes.getDefineTypeByName($ID.text);}
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
		| set[null] DOTCOMA
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
	
	VarType type3 = null
]
		:
		   NUMBER_TYPE   {$type3 = BasicType.Number;}
		 | BOOL_TYPE     {$type3 = BasicType.Bool;}		 
		 | STRING_TYPE   {$type3 = BasicType.String;}
		 | INTEGER_TYPE  {$type3 = BasicType.Integer;}
		 | DOUBLE_TYPE   {$type3 = BasicType.Double;}
		 | FLOAT_TYPE    {$type3 = BasicType.Float;}
		 | id = defineID {$type3 = new CustomType(($id.type3 != null)?DefineTypes.getDefineTypeByName($id.type3):DefineTypes.STRUCT, $id.name);} // solo Define del tipo Type
        ;

defineID
returns
[
	String type3,
	String name
]
       :
       (defineType = ID DOUBLEDOT {$type3 = $defineType.text;})?
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

