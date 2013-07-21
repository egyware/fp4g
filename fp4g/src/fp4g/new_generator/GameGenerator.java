package fp4g.new_generator;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import fp4g.new_data.Game;
import fp4g.new_data.IGameData;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class GameGenerator extends Generator {

	@Override
	protected void generateData(Configuration cfg,IGameData gameData, File path) throws IOException, TemplateException {
		Game game = (Game)gameData;
		
		Template temp = cfg.getTemplate("GameManager.ftl"); 
		Map<String,Object> root = new HashMap<>();
		root.put("package", "caca1");
		root.put("name",game.name);
		root.put("width", game.width);
		root.put("height", game.height);
				
		
		Writer out = new OutputStreamWriter(System.out);
		temp.process(root, out);  
		
	}

}
