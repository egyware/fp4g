package fp4g.generator.gdx;

import java.io.File;

import fp4g.data.ICode;
import fp4g.data.define.Message;
import fp4g.generator.CodeGenerator;

public class MessageGenerator extends CodeGenerator<JavaGenerator> {

	public MessageGenerator(JavaGenerator generator) 
	{
		super(generator);		
	}

	@Override
	public void generateCode(ICode gameData, File path) throws Exception
	{
		//FALTA EL GENERADOR DE MENSAJES
	}

	@Override
	public void usingCode(ICode gameData, File path) 
	{
		Message message = (Message)gameData;
		generator.usingFile(generator.sourceDir, String.format("com/apollo/messages/%sMessage.java",message.name));		
		generator.usingFile(generator.sourceDir, String.format("com/apollo/messages/%sMessageHandler.java",message.name));
	}	
}
