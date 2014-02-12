'use strict';

Blockly.FP4G = new Blockly.Generator('FP4G');


//ojo esta lista puede tener palabras reservadadas que no se usarán más adelante
Blockly.FP4G.addReservedWords(
    'Blockly,' +  // In case JS is evaled in the current window.
    'DEFINE,ADD,ON,SEND,DESTROY,GROUP,SUBSCRIBE,UNSUBSCRIBE,RESUME,PAUSE,USING,EXIT,SET,START,ASSETS' + 
    'MANAGER,GAME,STATE,ASSET,BEHAVIOR,ENTITY,GOAL,MESSAGE,BASE,TO,AS,OTHER'     
);

/**
 * Solo reemplaze la lista de Javascript, mucho de estos ni siquiera usaré
 */
Blockly.FP4G.ORDER_ATOMIC = 0;         // 0 "" ...
Blockly.FP4G.ORDER_MEMBER = 1;         // . []
Blockly.FP4G.ORDER_NEW = 1;            // new
Blockly.FP4G.ORDER_FUNCTION_CALL = 2;  // ()
Blockly.FP4G.ORDER_INCREMENT = 3;      // ++
Blockly.FP4G.ORDER_DECREMENT = 3;      // --
Blockly.FP4G.ORDER_LOGICAL_NOT = 4;    // !
Blockly.FP4G.ORDER_BITWISE_NOT = 4;    // ~
Blockly.FP4G.ORDER_UNARY_PLUS = 4;     // +
Blockly.FP4G.ORDER_UNARY_NEGATION = 4; // -
Blockly.FP4G.ORDER_TYPEOF = 4;         // typeof
Blockly.FP4G.ORDER_VOID = 4;           // void
Blockly.FP4G.ORDER_DELETE = 4;         // delete
Blockly.FP4G.ORDER_MULTIPLICATION = 5; // *
Blockly.FP4G.ORDER_DIVISION = 5;       // /
Blockly.FP4G.ORDER_MODULUS = 5;        // %
Blockly.FP4G.ORDER_ADDITION = 6;       // +
Blockly.FP4G.ORDER_SUBTRACTION = 6;    // -
Blockly.FP4G.ORDER_BITWISE_SHIFT = 7;  // << >> >>>
Blockly.FP4G.ORDER_RELATIONAL = 8;     // < <= > >=
Blockly.FP4G.ORDER_IN = 8;             // in
Blockly.FP4G.ORDER_INSTANCEOF = 8;     // instanceof
Blockly.FP4G.ORDER_EQUALITY = 9;       // == != === !==
Blockly.FP4G.ORDER_BITWISE_AND = 10;   // &
Blockly.FP4G.ORDER_BITWISE_XOR = 11;   // ^
Blockly.FP4G.ORDER_BITWISE_OR = 12;    // |
Blockly.FP4G.ORDER_LOGICAL_AND = 13;   // &&
Blockly.FP4G.ORDER_LOGICAL_OR = 14;    // ||
Blockly.FP4G.ORDER_CONDITIONAL = 15;   // ?:
Blockly.FP4G.ORDER_ASSIGNMENT = 16;    // = += -= *= /= %= <<= >>= ...
Blockly.FP4G.ORDER_COMMA = 17;         // ,
Blockly.FP4G.ORDER_NONE = 99;          // (...)
/**
 * Arbitrary code to inject into locations that risk causing infinite loops.
 * Any instances of '%1' will be replaced by the block ID that failed.
 * E.g. '  checkTimeout(%1);\n'
 * @type ?string
 */
Blockly.FP4G.INFINITE_LOOP_TRAP = null;

/**
 * Initialise the database of variable names.
 */
Blockly.FP4G.init = function() {
	//curioso, sirve para detectar si existen datos repetidos
//  // Create a dictionary of definitions to be printed before the code.
//  Blockly.JavaScript.definitions_ = Object.create(null);
//  // Create a dictionary mapping desired function names in definitions_
//  // to actual function names (to avoid collisions with user functions).
//  Blockly.JavaScript.functionNames_ = Object.create(null);
//
//  if (Blockly.Variables) {
//    if (!Blockly.JavaScript.variableDB_) {
//      Blockly.JavaScript.variableDB_ =
//          new Blockly.Names(Blockly.JavaScript.RESERVED_WORDS_);
//    } else {
//      Blockly.JavaScript.variableDB_.reset();
//    }
//
//    var defvars = [];
//    var variables = Blockly.Variables.allVariables();
//    for (var x = 0; x < variables.length; x++) {
//      defvars[x] = 'var ' +
//          Blockly.JavaScript.variableDB_.getName(variables[x],
//          Blockly.Variables.NAME_TYPE) + ';';
//    }
//    Blockly.JavaScript.definitions_['variables'] = defvars.join('\n');
//  }
};

/**
 * Prepend the generated code with the variable definitions.
 * @param {string} code Generated code.
 * @return {string} Completed code.
 */
Blockly.FP4G.finish = function(code) 
{
//  // Convert the definitions dictionary into a list.
//  var definitions = [];
//  for (var name in Blockly.JavaScript.definitions_) {
//    definitions.push(Blockly.JavaScript.definitions_[name]);
//  }
//  return definitions.join('\n\n') + '\n\n\n' + code;
	return code;
};

/**
 * Naked values are top-level blocks with outputs that aren't plugged into
 * anything.  A trailing semicolon is needed to make this legal.
 * @param {string} line Line of generated code.
 * @return {string} Legal line of code.
 */
Blockly.FP4G.scrubNakedValue = function(line) {
  return line + ';\n';
};

/**
 * Encode a string as a properly escaped JavaScript string, complete with
 * quotes.
 * @param {string} string Text to encode.
 * @return {string} JavaScript string.
 * @private
 */
Blockly.FP4G.quote_ = function(string) {
  // TODO: This is a quick hack.  Replace with goog.string.quote
  string = string.replace(/\\/g, '\\\\')
                 .replace(/\n/g, '\\\n')
                 .replace(/'/g, '\\\'');
  return '\'' + string + '\'';
};

/**
 * Common tasks for generating JavaScript from blocks.
 * Handles comments for the specified block and any connected value blocks.
 * Calls any statements following this block.
 * @param {!Blockly.Block} block The current block.
 * @param {string} code The JavaScript code created for this block.
 * @return {string} JavaScript code with comments and subsequent blocks added.
 * @this {Blockly.CodeGenerator}
 * @private
 */
Blockly.FP4G.scrub_ = function(block, code) {
  if (code === null) {
    // Block has handled code generation itself.
    return '';
  }
  var commentCode = '';
  // Only collect comments for blocks that aren't inline.
  if (!block.outputConnection || !block.outputConnection.targetConnection) {
    // Collect comment for this block.
    var comment = block.getCommentText();
    if (comment) {
      commentCode += this.prefixLines(comment, '// ') + '\n';
    }
    // Collect comments for all value arguments.
    // Don't collect comments for nested statements.
    for (var x = 0; x < block.inputList.length; x++) {
      if (block.inputList[x].type == Blockly.INPUT_VALUE) {
        var childBlock = block.inputList[x].connection.targetBlock();
        if (childBlock) {
          var comment = this.allNestedComments(childBlock);
          if (comment) {
            commentCode += this.prefixLines(comment, '// ');
          }
        }
      }
    }
  }
  var nextBlock = block.nextConnection && block.nextConnection.targetBlock();
  var nextCode = this.blockToCode(nextBlock);
  return commentCode + code + nextCode;
};


Blockly.FP4G['block_game'] = function(block) 
{
	//bloque del juego.
	var decl = 'DEFINE GAME ' + block.getFieldValue('name');
	var branch = Blockly.FP4G.statementToCode(block, 'game_defines');
	var code = decl + '\n[\n' + branch +'\n]\n';
	return code;
};

Blockly.FP4G['block_define'] = function(block) 
{
	//bloque del juego.
	var decl = 'DEFINE '+ block.getFieldValue('type')+ ' ' + Blockly.FP4G.statementToCode(block, 'name');//block.getFieldValue('name');
	var branch = Blockly.FP4G.statementToCode(block, 'defines');
	var code = decl + '\n[\n' + branch +'\n]\n';
	return code;
};

Blockly.FP4G['text'] = function(block)
{
	var code = block.getFieldValue('TEXT');
	return code;
}
