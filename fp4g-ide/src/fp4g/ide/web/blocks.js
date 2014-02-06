'use strict';

Blockly.Blocks['block_game'] = {
  init: function() {
    this.setHelpUrl('http://www.example.com/');
    this.setColour(230);
    this.appendDummyInput()
        .appendField("GAME")
        .appendField(new Blockly.FieldTextInput("default"), "name");
    this.appendStatementInput("game_defines")
        .setCheck(["block_define","block_set"]);    
    this.setPreviousStatement(true);
    this.setTooltip('');
  }
};

Blockly.Blocks['block_define'] = {
		  init: function() {
		    this.setHelpUrl('http://www.example.com/');
		    this.setColour(210);
		    this.appendValueInput("name")
		        .setCheck("String")
		        .appendField("DEFINE")
		        .appendField(new Blockly.FieldDropdown([["Entity", "ENTITY"], ["GameState", "STATE"]]), "type");
		    this.appendStatementInput("defines")
		        .setCheck(["block_define", "block_add", "block_on", "block_set"]);
		    this.setPreviousStatement(true, ["block_define", "block_add", "block_on", "block_set"]);
		    this.setNextStatement(true, ["block_define", "block_add", "block_on", "block_set"]);
		    this.setTooltip('');
		  }
		};
Blockly.Blocks['block_add'] = {
		  init: function() {
		    this.setHelpUrl('http://www.example.com/');
		    this.setColour(0);
		    this.appendValueInput("name")
		        .setCheck("String")
		        .appendField("ADD")
		        .appendField(new Blockly.FieldDropdown([["Entity", "entity"], ["Manager", "maanger"], ["Behavior", "behavior"], ["GameState", "gamestate"]]), "type");
		    this.setPreviousStatement(true, ["block_define", "block_add", "block_set", "block_on"]);
		    this.setNextStatement(true, ["block_define", "block_add", "block_set", "block_on"]);
		    this.setTooltip('');
		  }
		};

Blockly.Blocks['block_set'] = {
		  init: function() {
		    this.setHelpUrl('http://www.example.com/');
		    this.setColour(120);
		    this.appendValueInput("NAME")
		        .setCheck("block_expresion")
		        .appendField("SET")
		        .appendField(new Blockly.FieldTextInput("varname"), "name")
		        .appendField("=");
		    this.setPreviousStatement(true, ["block_define", "block_add", "block_set", "block_on"]);
		    this.setNextStatement(true, ["block_define", "block_add", "block_set", "block_on"]);
		    this.setTooltip('');
		  }
		};