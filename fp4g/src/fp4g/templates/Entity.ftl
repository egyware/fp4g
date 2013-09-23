package ${class.package};

<#if class.imports??>
<#list class.imports as import>
import ${import};
</#list>
</#if>

${autodoc}
public class ${class.name} extends Entity
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
	public void onMessage(Message message)
	{
		<#list messages as message>
		if(message instanceof ${message.name})
		{
			onMessage((${message.name}Message)message);			
		}
		<#if message_has_next>
		else
		</#if>		
		</#list>		
	}
	<#list messages as message>
	public void onMessage(${message.name}Message message)
	{		
		<#list message.sources as source>
		<#if source.filter??>
		if(${source.filter})
		{
			${source.code}
		}		
		<#else>
		${source.code}
		</#if>
		</#list>
	}
	</#list>
	</#if>
	
				
}