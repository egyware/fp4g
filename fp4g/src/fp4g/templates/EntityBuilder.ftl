package ${class.package};

<#if class.imports??>
<#list class.imports as import>
import ${import};
</#list>
</#if>

${autodoc}
public class ${class.name}Builder implements EntityBuilder
{

	@Override
	public String getEntityBuilderName()
	{
		return "${class.name}";
	}
	
	@Override
	public Entity buildEntity(World world, Object... params)
	{ 
		Entity entity = new Entity(world);
		
		<#if behaviors??>
		//crear los behaviors
		<#list behaviors as behavior>
		${behavior} ${behavior?uncap_first} = new ${behavior}(); //TODO agregar paremetros de entrada a ${behavior}		
		</#list>
		<#else>
		//TODO: Se te olvido agregar los Behaviors?
		</#if>
		
		//añadir las instancias
		<#if behaviors??>
		<#list behaviors as behavior>
		entity.setBehavior(${behavior?uncap_first});		
		</#list>
		</#if>
		
		return entity;
	}		
}