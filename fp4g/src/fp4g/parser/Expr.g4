parser grammar Expr;

expr  
		 :
		   array                          #arrayExpr
		 | ABRE_PAR op=expr CIERRA_PAR    #parExpr
		 | NOT op=expr	                  #notExpr		 
		 | MINUS op=expr                  #minusExpr
		 | left=expr LESS_THAN right=expr #lessThanExpr
		 | left=expr MORE_THAN right=expr #moreThanExpr
		 | left=expr EQUAL     right=expr #equalExpr
		 | left=expr MULTIPLY  right=expr #multExpr
		 | left=expr DIVIDE    right=expr #divExpr
		 | left=expr PLUS      right=expr #addExpr
		 | left=expr MINUS     right=expr #subExpr
			 
		 | INT_LITERAL                   #intLiteral
         | DECIMAL_LITERAL               #decimalLiteral         
		 | BOOL_LITERAL			         #boolLiteral	 		 
         | STRING_LITERAL                #stringLiteral         
         | DIRECTCODE                    #directCode
         | functionName=ID 
		    ABRE_PAR exprList CIERRA_PAR #functionCallExpr         
         | accessVarOp                   #varExpr         		          
		 ;		
	
accessVarOp
		:
		    var = varOp                                         #accessVarName 
		|  pVar = parentVarOp (DOT propertyAccess=accessVarOp)? #accessVarOperator				
		;
		
parentVarOp
returns
[String name]
		:
		   CURRENT_LITERAL                         #currentOperator                  
		 | PARENT_LITERAL                          #parentOperator 
		 | varName = varID {$name=$varName.text;}  #varNameOperator
		;
varOp
		:
		   CURRENT_LITERAL  #varCurrent                  
		 | PARENT_LITERAL	#varParent 
		 | varName = varID	#varName
		 
		;
		
varID   : MANAGER | GAME | STATE | ASSET | BEHAVIOR | ENTITY | GOAL | MESSAGE | ID ;		
	 
array   
returns [ String bean ] 
		:
		 ABRE_LLAV
		 arrayBody
		 CIERRA_LLAV
		 (AS ID {$bean = $ID.text;})?
   		 ;
arrayBody
locals [String bean]
		:
		   (parArray (COMA parArray)* COMA?)   #assocArray
		 | (itemArray (COMA itemArray)* COMA?) #listArray
		;
		
itemArray
		:
		expr
		;
		   		
   		 
parArray 
returns
[
	String key	
]
		 :
		 ID { $key = $ID.text; } EQUAL expr
		 ;
