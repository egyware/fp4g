/**
 * 
 */
package fp4g.generator.models;

import java.util.List;
import java.util.Map;

/**
 * @author Edgardo
 *
 */
public class OnMessageDepend extends Depend {
	public List<String> imports;
	
	
	@Override
	public void perform(Map<String, Object> root, JavaCodeModel model) {
		//a�adir todos los imports necesarios.
		model.imports.addAll(imports);		
	}

}
