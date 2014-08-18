<#import "fp4g.ftl" as fp4g />
package ${source.pckg};
<#if source.imports??>
<#list source.imports as import>
import ${import};
</#list>
</#if>

${source.javadoc}
public class ${source.name} extends Entity
<#if source.interfaces?has_content>
implements <#list source.interfaces as interface>${interface}<#if interface_has_next>,</#if></#list>
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
	<#if flags?has_content>
	<@fp4g.flags list = flags />
	</#if>
	
	
	public ${source.name}(WorldContainer container)
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
		<#if whenList?has_content>
		//when
		<#list whenList as when>
		final boolean check${when.flagName?cap_first} = (${when.condition});
		</#list>
		<#list whenList as when>
		if(check${when.flagName?cap_first} && !${when.flagName})
		{
			${when.flagName} = true;
			<#list when.statements as stmnt>						
				<@fp4g.translate statement=stmnt />
			</#list>
		}
		else if(!check${when.flagName?cap_first} && ${when.flagName})	
		{
			${when.flagName} = false;
		}
		</#list>
		</#if>
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