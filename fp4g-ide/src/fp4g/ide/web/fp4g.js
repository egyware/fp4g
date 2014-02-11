'use strict';

var rootBlock = null;

/**
 * Initialize Blockly and layout.  Called on page load.
 */
function init() 
{
  var toolbox = document.getElementById('toolbox');
  Blockly.inject(document.getElementById('blocklyDiv'),
                 {path: './lib/', toolbox: toolbox});

  // Create the root block.
  rootBlock = new Blockly.Block.obtain(Blockly.mainWorkspace, 'block_game');
  rootBlock.initSvg();
  rootBlock.render();
  rootBlock.setMovable(false);
  rootBlock.setDeletable(false);  
  
  
}
window.addEventListener('load', init);

function generate()
{
	var code = Blockly.FP4G.blockToCode(rootBlock);
	setCode(code);
}

function setCode(code)
{
	console.log(code);
}

