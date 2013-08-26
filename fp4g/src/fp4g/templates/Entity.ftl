package ${class.package};

<#if class.imports??>
<#list class.imports as import>
import ${import};
</#list>
</#if>

${autodoc}
public class ${class.name} extends Entity
{
	private final Bag<Behavior> behaviors;
	<#if behaviors??>		
	<#list behaviors as behavior>
	public ${behavior.name} ${behavior.varName};				 		
	</#list>
	<#else>
	//TODO: Se te olvido agregar los Behaviors?
	</#if>
	
	
	public ${class.name}(World world)
	{
		super(world);
		behaviors = new Bag<Behavior>();		
	}
	
	public Bag<Behavior> getBehaviors()
	{
		return behaviors;
	}

	public <T extends Behavior> T getBehavior(Class<T> type)
	{	
		//WARNING: If you change something in this code, the results can be unexpected 
		int hash = type.getSimpleName().hashCode();
		switch(hash)
		{
		<#if behaviors??>		
		<#list behaviors as behavior>
			case ${behavior.hash?string.computer}:
				return ${behavior.varName};
		</#list>
		</#if>
			default:
				return null;
		}	
	}

	public void update(float delta)
	{
		for (int i = 0, s = components.size(); s > i; i++) {
			components.get(i).update(delta);
		}
	}
	
	protected void initialize()
	{
		<#if behaviors??>		
		<#list behaviors as behavior>
		behaviors.add(${behavior.varName});						 		
		</#list>		
		</#if>
		<#if behaviors??>		
		<#list behaviors as behavior>
		${behavior.varName}.initialize();
		</#list>
		</#if>		
	}
	
	protected void uninitialize()
	{
		for (int i = 0, s = behaviors.size(); s > i; i++) {
			behaviors.get(i).uninitialize();
		}		
	}
	
				
}