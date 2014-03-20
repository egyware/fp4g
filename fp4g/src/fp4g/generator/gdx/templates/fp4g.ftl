<#macro translate statement>
<#switch statement.type>
<#case 0><#-- Send MessageSender.instance().send(receiver, message); -->
<#if statement.direct>	
		${statement.to}.${statement.message}(<#if statement.params?has_content><@params p=statement.params /></#if>);
<#else>
		${statement.to}.onMessage(${statement.message}<#if statement.params?has_content>,<@params p=statement.params /></#if>);
</#if>
<#break>
<#case 1><#-- delete owner -->			
		getWorld().deleteEntity(this);
<#break>
<#case 2>
<#if statement.subscribe>
	<#list statement.method as method>
		${statement.attach}.getWorld().getManager(${statement.subscribeTo}.class).addEventHandler(${statement.message}Message.on${method?capitalize}${statement.message},${statement.attach});
	</#list>
<#else>
		${statement.attach}.getWorld().getManager(${statement.subscribeTo}.class).removeEventHandler(${statement.message}Message.on${method?capitalize}${statement.message},${statement.attach});
</#if>
<#break>
<#default>
		//TODO No se reconoce la instrucción: "${statement.class.simpleName}"
</#switch>
</#macro>
<#macro params p><#list p as param>${param}<#if param_has_next>,</#if></#list></#macro>


<#macro on_message message>
<#if message.methodHandlers?has_content>
<#list message.methodHandlers as method>	
<#-- Hacer funciones por cada method Handler -->
	@Override
	public void on${method.name?cap_first}${message.name?cap_first}(${method.params})
	{
		<#if method.sources?has_content>
		<#list method.sources as source>		
		<#if source.filters?has_content>
		<#if (source.filters?size == 1)>
		if(<#list source.filters as filter><#list filter.iterator() as condition>${condition}<#if condition_has_next> && </#if></#list></#list>)
		<#else>
		if(<#list source.filters as filter>(<#list filter.iterator() as condition>${condition}<#if condition_has_next> && </#if></#list>)<#if filter_has_next>||</#if></#list>)
		</#if>
		{		
		<#if source.statements?has_content>		
		<#list source.statements as stmnt>						
			<@fp4g.translate statement=stmnt />
		</#list>
		<#else>
			//TODO Recuerde añadir su codigo aqui...
		</#if>
		}
		<#else>		
		<#if source.statements?has_content>		
		<#list source.statements as stmnt>
			<@fp4g.translate statement=stmnt />
		</#list>
		<#else>
			//TODO Recuerde añadir su codigo aqui...
		</#if>		
		</#if>
		</#list>
		</#if>
	}		
</#list>	
</#if>
</#macro>