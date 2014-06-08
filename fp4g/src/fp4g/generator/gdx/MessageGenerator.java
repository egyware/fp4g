package fp4g.generator.gdx;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import fp4g.data.ICode;
import fp4g.data.add.AddMethod;
import fp4g.data.define.Message;
import fp4g.generator.gdx.models.JavaMetaSourceModel;
import fp4g.generator.gdx.models.MessageModel;
import fp4g.generator.gdx.models.VarCodeModel;
import freemarker.template.Template;

public class MessageGenerator extends JavaCodeGenerator
{
	private static File messagePackageDir;

	public MessageGenerator(JavaGenerator generator) 
	{
		super(generator);		
	}

	@Override
	public void generateCode(ICode gameData, File path) throws Exception
	{
		final Message message = (Message)gameData;
		final JavaParamListBuilder paramBuilder = new JavaParamListBuilder(generator);
		Template    enumTpl  = generator.getTemplate("Message.ftl"); 
		Template handlerTpl  = generator.getTemplate("MessageHandler.ftl");
		
		final String entityPackage = "com.apollo.messages";
		MessageModel messageModel = new MessageModel(entityPackage, message.name);
		JavaMetaSourceModel messageMeta = messageModel.getMetaSource();
		
		messageMeta.setJavadoc(JavaGenerator.autodoc);
		messageMeta.addRequireSource("com.apollo.Message");
		
		LinkedList<MessageModel.Method> methods = new LinkedList<MessageModel.Method>();
		for(AddMethod method:message.getAddMethods())
		{
			List<VarCodeModel> enumArgList    = (method.nameList != null)?paramBuilder.buildForMessage(method.nameList, message, messageMeta):null;
			List<VarCodeModel> handlerArgList = (method.nameList != null)?paramBuilder.build(method.nameList, message, messageMeta):null;
			MessageModel.Method m = new MessageModel.Method(method.name,enumArgList, handlerArgList);
			methods.add(m);
		}
		messageModel.setMessages(methods);
		
		if(messagePackageDir == null)
		{
			messagePackageDir = new File(generator.sourceDir, "com/apollo/messages");
			if(!messagePackageDir.exists())
			{
				messagePackageDir.mkdirs();
			}
		}
		
		generator.createFile(generator.sourceDir,String.format("com/apollo/messages/%sMessage.java",message.name),        enumTpl,messageModel);
		generator.createFile(generator.sourceDir,String.format("com/apollo/messages/%sMessageHandler.java",message.name), handlerTpl,messageModel);
			
		
	}

	@Override
	public void usingCode(ICode gameData, File path) 
	{
		Message message = (Message)gameData;
		generator.usingFile(generator.sourceDir, String.format("com/apollo/messages/%sMessage.java",message.name));		
		generator.usingFile(generator.sourceDir, String.format("com/apollo/messages/%sMessageHandler.java",message.name));
	}	
}
