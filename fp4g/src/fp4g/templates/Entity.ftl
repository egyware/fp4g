package ${class.pckg};

<#if class.imports??>
<#list class.imports as import>
import ${import};
</#list>
</#if>

${class.javadoc}
public class ${class.name} extends Entity
<#if class.interfaces?has_content>
implements <#list class.interfaces as interface>${interface}<#if interface_has_next>,</#if></#list>
</#if>
{
	<#if behaviors??>
	private final Bag<Behavior> behaviors;
	private final Map<Class<? extends Behavior>,Behavior> behaviorsByType;		
	<#list behaviors as behavior>
	public ${behavior.name} ${behavior.varName};				 		
	</#list>
	<#else>
	//TODO: Se te olvido agregar los Behaviors?
	</#if>
	
	
	public ${class.name}(World world)
	{
		super(world);
		<#if behaviors??>
		behaviors = new Bag<Behavior>(${behaviors?size});
		behaviorsByType = new HashMap<Class<? extends Behavior>,Behavior>(${behaviors?size},1);
		</#if>		
	}
	
	public Bag<Behavior> getBehaviors()
	{
		return behaviors;
	}

	public <T extends Behavior> T getBehavior(Class<T> type)
	{	
		return type.cast(behaviorsByType.get(type));
	}

	public void update(float delta)
	{
		for (int i = 0, s = behaviors.size(); s > i; i++) {
			behaviors.get(i).update(delta);
		}
	}
	
	protected void initialize()
	{		
		for (int i = 0, s = behaviors.size(); s > i; i++) {
			behaviors.get(i).initialize();
		}
		<#if messages??>
		<#list messages as message>
		<#assign messageName = message.name?cap_first />
		<#list message.methodHandlers as method>		
		addEventHandler(${messageName}Message.on${method.name?cap_first}${messageName}, this);
		</#list>
		</#list>
		</#if>			
	}
	
	protected void uninitialize()
	{
		for (int i = 0, s = behaviors.size(); s > i; i++) {
			behaviors.get(i).uninitialize();
		}		
	}
	
	protected void pack()
	{
		<#if behaviors??>
		<#list behaviors as behavior>
		${behavior.varName}.setOwner(this);
		</#list>				
		<#list behaviors as behavior>
		behaviors.add(${behavior.varName});						 		
		</#list>
		<#list behaviors as behavior>		
		behaviorsByType.put(${behavior.varName}.getType(),${behavior.varName});
		</#list>
		</#if>
	}
	
	<#if messages??>
	<#list messages as message>
	//Categoria ${message.name}	
	<#if message.methodHandlers?has_content>
	<#list message.methodHandlers as method>
	<#-- Hacer funciones por cada method Handler -->
	@Override
	public void on${method.name?cap_first}${message.name?cap_first}(${method.params})
	{
		<#if method.sources?has_content>
		<#list method.sources as source>
		<#if source.filtersD?has_content>
		<#if (source.filtersD?size == 1)>
		if(<#list source.filtersD as filterD><#list filterD.filtersC as filterC>${filterC}<#if filterC_has_next> && </#if></#list></#list>)
		<#else>
		if(<#list source.filtersD as filterD>(<#list filterD.filtersC as filterC>${filterC}<#if filterC_has_next> && </#if></#list>)<#if filterD_has_next>||</#if></#list>)
		</#if>
		{
			${source.code}
		}		
		</#if>
		</#list>
		</#if>
	}
	</#list>
	</#if>
	</#list>
	/**
	  * Caso general de envio de mensajes.
	  * @param message Mensaje a enviar.
	  * @param args Argumentos del mensaje.
	  */
	@Override
	public void onMessage(Message message, Object... args) 
	{		
		ImmutableBag<MessageHandler> listeners = getMessageHandler(message);
		final int size = listeners.size();
		for(int i=0; i<size; i++)
		{
			MessageHandler handler = listeners.get(i);
			MethodAccess methods = MethodAccess.get(handler.getClass());
			methods.invoke(handler, message.name());
		}		
	}
	</#if>
				
}