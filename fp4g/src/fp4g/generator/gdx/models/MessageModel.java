package fp4g.generator.gdx.models;

import java.util.List;

public final class MessageModel extends JavaSourceModel
{
	private List<Method> messages;
	public MessageModel(String pckg, String name) 
	{
		super(new JavaMetaSourceModel(pckg,name));		
	}
	
	public final List<Method> getMessages() {
		return messages;
	}
	
	public final void setMessages(List<Method> messages) {
		this.messages = messages;
	}
	
	public final static class Method
	{
		private final String name;
		private final List<VarCodeModel> enumArgs;
		private final List<VarCodeModel> handlerArgs;
		
		public Method(String name, List<VarCodeModel> enumArgs, List<VarCodeModel> handlerArgs)
		{
			this.name = name;
			this.enumArgs    = enumArgs;
			this.handlerArgs = handlerArgs;
		}
		
		public final String getName() 
		{
			return name;
		}
		
		public final List<VarCodeModel> getArguments() 
		{
			return enumArgs;
		}
		
		public final List<VarCodeModel> getHandlerArguments() 
		{
			return handlerArgs;
		}
	}
}
