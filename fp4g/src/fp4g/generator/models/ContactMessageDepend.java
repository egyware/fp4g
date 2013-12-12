package fp4g.generator.models;

import java.util.Arrays;
import java.util.List;

import fp4g.data.define.Message;

/**
 * Clase que resuelve las dependencias de el KeyMessage
 * @author Edgardo
 *
 */
public class ContactMessageDepend extends Depend<Message> {
	private final List<String> importsRequired;	
	
	public ContactMessageDepend()
	{
		importsRequired = Arrays.asList(				
				"com.apollo.messages.ContactMessage",
				"com.apollo.messages.ContactMessageHandler"				
				);
	}
	
	@Override
	public void perform(Message data, JavaCodeModel model) {
		model.imports.addAll(importsRequired);
		model.addInterface("ContactMessageHandler");
	}

}
