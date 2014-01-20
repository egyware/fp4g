package ${class.pckg};

<#if class.imports??>
<#list class.imports as import>
import ${import};
</#list>
</#if>

${class.javadoc}
public class ${class.name} implements EntityBuilder
{

	@Override
	public String getEntityBuilderName()
	{
		return "${entity.name}";
	}
	
	@Override
	public Entity buildEntity(WorldContainer container, Object... params)
	{ 
		<#if params??>
		//parametros de entrada!
		final int length = params.length;		
		<#list params as param>		
		<#if param.defaultValue?has_content>		
		${param.type} ${param.name} = (${param_index}<length)?((${param.type})params[${param_index}]):${param.defaultValue};
		<#else>
		${param.type} ${param.name} = (${param.type})params[${param_index}];
		</#if>
		</#list>	
		</#if>
		
		${entity.name} entity = new ${entity.name}(container);
		
		<#if behaviors??>
		//crear los behaviors
		<#list behaviors as behavior>
		${behavior.name}Behavior ${behavior.varName} = ${behavior.name}Behavior.build(<#if behavior.params??><#list behavior.params as param>${param}<#if param_has_next>, </#if></#list></#if>);		 		
		</#list>
		<#else>
		//TODO: Se te olvido agregar los Behaviors?
		</#if>
		
		//a�adir las instancias
		<#if behaviors??>
		<#list behaviors as behavior>
		entity.${behavior.varName} = ${behavior.varName};				
		</#list>
		</#if>
		entity.pack();
		
		return entity;
	}		
}