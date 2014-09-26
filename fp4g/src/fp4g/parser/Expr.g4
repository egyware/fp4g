parser grammar Expr;

expr  
		 :
		   array                              #arrayExpr
		 | NOT op=expr                        #notExpr
		 | TO 
		 	(otherTo= OTHER
		 	|selfTo = SELF
		 	|gameTo = GAME
		 	|idTo   = ID)                     #toExpr	          		
		 | left=expr LESS_THAN right=expr     #lessThanExpr
		 | left=expr MORE_THAN right=expr     #moreThanExpr
		 | left=expr EQUAL     right=expr     #equalExpr		
		 | ABRE_PAR op=expr CIERRA_PAR        #parExpr		 	 
		 | MINUS op=expr                      #minusExpr		
		 | left=expr MULTIPLY  right=expr     #multExpr
		 | left=expr DIVIDE    right=expr     #divExpr
		 | left=expr PLUS      right=expr     #addExpr
		 | left=expr MINUS     right=expr     #subExpr
		 | INT_LITERAL                        #intLiteral
         | DECIMAL_LITERAL                    #decimalLiteral
         | STRING_LITERAL                     #stringLiteral
         | BOOL_LITERAL			              #boolLiteral         
         | DIRECTCODE                         #directCode
         | ON defineName=ID DOUBLEDOT addName=ID #defineAddExpr
         | methodName=ID
         	 (ABRE_PAR exprList? CIERRA_PAR)  #messageExpr 
         | accessOp                           #accessOpExpr                  
		 ;
	
accessOp
returns
[
	LinkedList<String> list = new LinkedList<String>();
]
		:		 
		    varName = ID ( DOT childVarName = ID {$list.add($childVarName.text);} )*
		;
	 
array
:
	 arrayBody 
;
   		 
arrayBody
returns
[
	String bean
]
:
	   ABRE_LLAV (parArray (COMA parArray)* COMA?)   CIERRA_LLAV (AS ID {$bean = $ID.text;})?  #assocArray
     | ABRE_LLAV (itemArray (COMA itemArray)* COMA?) CIERRA_LLAV (AS ID {$bean = $ID.text;})?  #listArray
	 | EMPTY AS ID {$bean = $ID.text;}                                                         #emptyArray		 
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
