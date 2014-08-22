<#import "fp4g.ftl" as fp4g />
package ${source.pckg};

<#if source.imports?has_content>
<#list source.imports as import>
import ${import};
</#list>
</#if>

${source.javadoc}
public class ${source.name} implements EntityBuilder
{

	@Override
	public String getEntityBuilderName()
	{
		return "${entity.name}";
	}
	
	@Override
	public Entity buildEntity(final WorldContainer container, final Object... params)
	{ 
		<#if params??>
		//parametros de entrada!
		final int length = params.length;		
		<#list params as param>		
		<#if param.defaultValue?has_content>		
		final ${param.type} ${param.name} = (${param_index}<length)?((${param.type})params[${param_index}]):${param.defaultValue};
		<#else>
		final ${param.type} ${param.name} = (${param.type})params[${param_index}];
		</#if>
		</#list>	
		</#if>
		
		final ${entity.name} entity = new ${entity.name}(container);
		
		<#if behaviors??>
		//crear los behaviors
		<#list behaviors as behavior>
		${behavior.name}Behavior ${behavior.varName} = ${behavior.name}Behavior.build(<#if behavior.params??><#list behavior.params as param>${param}<#if param_has_next>, </#if></#list></#if>);		 		
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
		
		<#if messages?has_content>
		<#list messages as message>
		<#assign messageName = message.name?cap_first />		
		//Categoria ${messageName}
		${messageName}MessageHandler ${message.name?uncap_first}MessageHandler = new ${messageName}MessageHandler()
		{
			<@fp4g.on_message message = message />
			
			//TODO Parche
			public void onMessage(Message<? extends MessageHandler> message, Object... args) 
			{
				message.dispatch(this, args);
			}
		};
		<#list message.methodHandlers as method>		
		entity.addEventHandler(${messageName}Message.on${method.name?cap_first}${messageName}, ${message.name?uncap_first}MessageHandler);
		</#list>
		</#list>
		</#if>		
		
		return entity;
	}		
}