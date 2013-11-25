package fp4g.generator.models;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import fp4g.data.define.Message;

/**
 * Clase que resuelve las dependencias de el KeyMessage
 * @author Edgardo
 *
 */
public class KeyMessageDepend extends Depend<Message> {
	private final List<String> importsRequired;	
	
	public KeyMessageDepend()
	{
		importsRequired = Arrays.asList("com.apollo.messages.KeyMessage","com.apollo.messages.KeyMessageHandler");
	}
	
	@Override
	public void perform(Message data,Map<String, Object> root, JavaCodeModel model) {
		model.imports.addAll(importsRequired);
		model.addInterface("KeyMessageHandler");
	}

}
