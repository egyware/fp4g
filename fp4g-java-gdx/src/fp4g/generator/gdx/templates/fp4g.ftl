<#macro params p><#list p as param>${param}<#if param_has_next>,</#if></#list></#macro>

<#macro flags list>
<#list list as flag>	private ${flag.type} ${flag.name}<#if flag.defaultValue??> = ${flag.defaultValue}</#if>;
</#list>
</#macro>


<#macro on_message message>
<#if message.methodHandlers?has_content>
<#list message.methodHandlers as method>	
<#-- Hacer funciones por cada method Handler -->
	@Override
	public void on${method.name?cap_first}${message.name?cap_first}(<#if method.params?has_content><#list method.params as param>${param.type} ${param.name}<#if param_has_next>, </#if></#list><#else></#if>)
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
			${stmnt};
		</#list>
		<#else>
			//TODO Recuerde añadir su codigo aqui...
		</#if>
		}
		<#else>		
		<#if source.statements?has_content>		
		<#list source.statements as stmnt>
			${stmnt};
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