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
		<#if params??>
		//parametros de entrada!
		<#list params as param>
		${param.type} ${param.name} = (${param.type})params[${param_index}];
		</#list>	
		</#if>
		
		${class.name} entity = new ${class.name}(world);
		
		<#if behaviors??>
		//crear los behaviors
		<#list behaviors as behavior>
		${behavior.name} ${behavior.varName} = new ${behavior.name}(<#if behavior.params??><#list behavior.params as param>${param}<#if param_has_next>, </#if></#list></#if>);		 		
		</#list>
		<#else>
		//TODO: Se te olvido agregar los Behaviors?
		</#if>
		
		//añadir las instancias
		<#if behaviors??>
		<#list behaviors as behavior>
		entity.${behavior.varName} = ${behavior.varName};				
		</#list>
		</#if>
		entity.pack();
		
		return entity;
	}		
}