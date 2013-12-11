parser grammar Expr;

expr  
		 :  
		   lExpr                   #logicalExpr
		 | nExpr                   #numericExpr
		 
		 | functionName=ID 
		   ABRE_PAR exprList CIERRA_PAR  #functionCallExpr		 
		 | array                         #arrayExpr	 		 
         | STRING_LITERAL                #stringLiteral         
         | DIRECTCODE                    #directCode
         | accessVarOp                   #varExpr          
		 ;		

lExpr
		:
		  NOT op=lExpr	               #notLExpr
		| ABRE_PAR op=lExpr CIERRA_PAR #parLExpr
		| BOOL_LITERAL                 #boolLiteral
		| accessVarOp                  #varLExpr
		;
		
nExpr
		:
		  MINUS op=nExpr   				   #minusNExpr
		| ABRE_PAR op=nExpr CIERRA_PAR     #parNExpr
		| left=nExpr MULTIPLY right=nExpr  #multNExpr
		| left=nExpr DIVIDE   right=nExpr  #divNExpr
		| left=nExpr PLUS     right=nExpr  #addNExpr
		| left=nExpr MINUS    right=nExpr  #subNExpr
			 
		| INT_LITERAL                    #intLiteral
        | DECIMAL_LITERAL                #decimalLiteral
        | accessVarOp                    #varNExpr
		;

accessVarOp
		:
		  accessVarOp DOT variable      #accessVarOperator
		| variable                      #accessVar
		;
variable
		:	
		var=ID
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
