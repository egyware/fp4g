<#import "fp4g.ftl" as fp4g />
package ${class.pckg};
<#macro printParams params>
<#if params?has_content><#list params as param>${param}<#if param_has_next>, </#if></#list></#if>
</#macro>
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
	public ${behavior.name}Behavior ${behavior.varName};				 		
	</#list>
	<#else>
	//TODO: Se te olvido agregar los Behaviors?
	</#if>
	
	
	public ${class.name}(WorldContainer container)
	{
		super(container);
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
		<#if hasAttachments>		
		ApolloInputProcessor inputProcessor = world.getInputProcessor();
		</#if>		
		<#list messages as message>				
		<#assign messageName = message.name?cap_first />		
		<#list message.methodHandlers as method>		
		<#if method.sources?has_content>		
		addEventHandler(${messageName}Message.on${method.name?cap_first}${messageName}, this);
		</#if>		
		</#list>
		
		<#if hasAttachments>
		<#list message.methodHandlers as method>
		<#if method.attach && method.sources?has_content>
		inputProcessor.addEventHandler(${messageName}Message.on${method.name?cap_first}${messageName}, (MessageHandler)this);
		</#if>
		</#list>
		</#if>
		</#list>
		</#if>		
		onMessage(EntityMessage.onInitEntity);	
	}
	
	protected void uninitialize()
	{
		for (int i = 0, s = behaviors.size(); s > i; i++) {
			behaviors.get(i).uninitialize();
		}
		onMessage(EntityMessage.onDeinitEntity);
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
	<@fp4g.on_message message=message />
	</#list>	
	</#if>
	
					
}