package fp4g.data;

/* expresiones de lua
exp ::= prefixexp
exp ::= nil | false | true (Literales)
exp ::= Number             (Numero)
exp ::= String             (String)
exp ::= functiondef        (funcion, nop, esto no lo tiene Fp4g)
exp ::= tableconstructor   (constructor, nop, esto tampoco)
exp ::= ‘...’              (...)
exp ::= exp binop exp      (expresion operador binario, claro que si :C)
exp ::= unop exp           (operador unario, expresion)
prefixexp ::= var | functioncall | ‘(’ exp ‘)’ (variable o llamada a funcion, vaya que hay tipos de expresiones)
*/
public abstract class Expresion {	
}
