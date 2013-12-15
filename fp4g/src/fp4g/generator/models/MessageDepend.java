package fp4g.generator.models;

import java.util.Arrays;
import java.util.List;

import fp4g.classes.MessageMethod;
import fp4g.classes.MessageMethods;
import fp4g.data.define.Game;
import fp4g.data.define.Message;
import fp4g.data.expresion.ClassMap;
import fp4g.data.expresion.CustomClassMap;

/**
 * Clase que resuelve las dependencias de el KeyMessage
 * @author Edgardo
 *
 */
public class MessageDepend extends Depend<Message> {
	private final List<String> importsKeyRequired;
	private final List<String> importsMoveRequired;
	private final List<String> importsContactRequired;
	
	private Message keyMessage;
	private Message contactMessage;
	private Message moveMessage;
	
	public MessageDepend()
	{
		importsKeyRequired = Arrays.asList(
				"com.badlogic.gdx.Input",
				"com.apollo.messages.KeyMessage",
				"com.apollo.messages.KeyMessageHandler"				
				);
		importsMoveRequired = Arrays.asList(				
				"com.apollo.messages.MoveMessage",
				"com.apollo.messages.MoveMessageHandler"				
				);
		importsContactRequired = Arrays.asList(				
				"com.apollo.messages.ContactMessage",
				"com.apollo.messages.ContactMessageHandler"				
				);
	}
	
	@Override
	public void perform(Message data, JavaCodeModel model)
	{
		if(data == keyMessage)
		{
			model.imports.addAll(importsKeyRequired);
		}else
		if(data == moveMessage)
		{
			model.imports.addAll(importsMoveRequired);
		}else
		if(data == contactMessage)
		{		
			model.imports.addAll(importsContactRequired);
		}	
	}

	@Override
	public Class<Message> getForClass() 
	{
		return Message.class;
	}

	@Override
	public void install(Game gameConf) {
		keyMessage = new Message("Key",gameConf);
    	MessageMethod press = new MessageMethod(keyMessage);
    	press.setName("press");
    	press.setValueReplace("Input.Keys.%s == key");
    	press.setParams("int key");
    	press.setAttachInputProcessor(true);
    	keyMessage.set("press", new ClassMap(press)); //nombre del metodo
    	
    	MessageMethod release = new MessageMethod(keyMessage);
    	release.setName("release");
    	release.setValueReplace("Input.Keys.%s == key");
    	release.setParams("int key");
    	press.setAttachInputProcessor(true);
    	keyMessage.set("release", new ClassMap(release)); //nombre del metodo
    	
    	contactMessage = new Message("Contact",gameConf);
    	MessageMethod begin = new MessageMethod(contactMessage);
    	begin.setName("begin");
    	begin.setValueReplace("other instanceof %s");
    	begin.setParams("Entity other, Contact c");    	
    	contactMessage.set("begin", new ClassMap(begin)); //nombre del metodo
    	
    	MessageMethod end = new MessageMethod(contactMessage);
    	end.setName("end");
    	end.setValueReplace("other instanceof %s");
    	end.setParams("Entity other, Contact c");    	
    	contactMessage.set("end", end); //nombre del metodo
    	
    	moveMessage = new Message("Move",gameConf);
    	
    	MessageMethod translate = new MessageMethod(moveMessage);
    	translate.setName("translate");
    	translate.setParams("float x, float y");
    	moveMessage.set("translate",end);
    	
    	MessageMethod speed = new MessageMethod(moveMessage);
    	speed.setName("speed");
    	speed.setParams("float x, float y");
    	moveMessage.set("speed",speed);
    	
    	//Agregar todos los metodos 
    	MessageMethods methods = new MessageMethods();
    	methods.add(press);
    	methods.add(release);
    	methods.add(begin);
    	methods.add(end);
    	methods.add(translate);
    	methods.add(speed);
   	
    	gameConf.set("methods", new CustomClassMap(methods));
    	
    	gameConf.setDefine(keyMessage);
    	gameConf.setDefine(contactMessage);
    	gameConf.setDefine(moveMessage);
		
	}

}
