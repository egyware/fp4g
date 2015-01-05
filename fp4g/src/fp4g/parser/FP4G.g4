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

libBody     : (set[lib] DOTCOMA | define)*;

programBody : (set[lib] DOTCOMA | define)*;

type
returns
[
	Type value;
]
   		:
		TYPE ABRE_PAR typeName=ID CIERRA_PAR { $value = lib.getType($typeName.text); }
		;

define returns [Define value]
locals
[
	String defName;
	DefineType t;
]
@after 
{
	value = t.createInstance($defName);
}
		: 
		  DEFINE ID { $t = DefineTypes.getDefineTypeByName($ID.text);}		  	 
		  name = ID { defName = $name.text; }
          ABRE_COR (defineValue[value])* CIERRA_COR                   
        ;
        
 
defineValue[Define d]
		:		
		  set[d] DOTCOMA
		| modifiers[d] DOTCOMA				 
		;

modifiers[Define d]
		:
		instantiator [d]
		on  
		;
		
resolver returns[Resolver r]
locals
[
	Type t
]
@init
{ 
	List<String> imports = new LinkedList<String>(); 
}
//la proxima vez que weebees con este codigo probablemente no sepas que pasa aqui
// por alguna razon, solo se permite un after por gramatica, lo cual no tiene mucho sentido
// y no existe solucion (todavia) asi que averigua una alternativa para esto.
@after
{
	$r = new Resolver($t);
	$r.setSources(imports);
	lib.registerResolver($t, $r);
}
			: 
			RESOLVER type { $t = $type.value; }
			ABRE_COR
				(set[$r] DOTCOMA)*
				(string=STRING_LITERAL COMA { imports.add($string.text); })* (string2=STRING_LITERAL { imports.add($string2.text); })?  DOTCOMA
			CIERRA_COR			 
			;

// SET llave = 5
set[ Object object ]
			:
			SET key=ID EQUAL expr { setValue($object,$key.text,$expr.value); } 
			;

//BEHAVIOR add
instantiator[Define d] 
:	      	
	  id=ID { lib.getType($id.text) != null }? id=ID name=ID ( ABRE_PAR exprList? CIERRA_PAR )? ( exprParams = array )?	  
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

