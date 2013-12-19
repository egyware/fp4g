package fp4g.generator.models;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class MessageDepend extends Depend<Message> 
{
	private final Map<String,List<String>> importsRequired;
	
	public MessageDepend()
	{
		importsRequired = new HashMap<String,List<String>>();
		importsRequired.put("Key", Arrays.asList
					(
						"com.badlogic.gdx.Input",
						"com.apollo.messages.KeyMessage",
						"com.apollo.messages.KeyMessageHandler"				
					)
				);
		importsRequired.put("Move",	Arrays.asList
					(				
						"com.apollo.messages.MoveMessage",
						"com.apollo.messages.MoveMessageHandler"				
					)
				);
		importsRequired.put("Contact", Arrays.asList
					(				
						"com.apollo.messages.ContactMessage",
						"com.apollo.messages.ContactMessageHandler"				
					)
				);
	}
	
	@Override
	public void perform(Message data, JavaCodeModel model)
	{
		List<String> imports = importsRequired.get(data.name);
		
		model.imports.addAll(imports);			
	}

	@Override
	public Class<Message> getForClass() 
	{
		return Message.class;
	}
}
