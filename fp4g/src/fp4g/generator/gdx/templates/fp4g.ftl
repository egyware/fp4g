<#macro translate statement>
<#switch statement.type>
<#case 0><#-- Send MessageSender.instance().send(receiver, message); -->	
		${statement.to}.onMessage(${statement.message}<#if statement.params?has_content>,<@params p=statement.params /></#if>);
<#break>
<#case 1><#-- delete owner -->			
		getWorld().deleteEntity(this);
<#break>
<#default>
		//TODO No se reconoce la instrucci�n: "${statement.class.simpleName}"
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
		<#if source.filtersD?has_content>
		<#if (source.filtersD?size == 1)>
		if(<#list source.filtersD as filterD><#list filterD.filtersC as filterC>${filterC}<#if filterC_has_next> && </#if></#list></#list>)
		<#else>
		if(<#list source.filtersD as filterD>(<#list filterD.filtersC as filterC>${filterC}<#if filterC_has_next> && </#if></#list>)<#if filterD_has_next>||</#if></#list>)
		</#if>
		{		
		<#if source.statements?has_content>		
		<#list source.statements as stmnt>						
			<@fp4g.translate statement=stmnt />
		</#list>
		<#else>
			//TODO Recuerde a�adir su codigo aqui...
		</#if>
		}
		<#else>		
		<#if source.statements?has_content>		
		<#list source.statements as stmnt>
			<@fp4g.translate statement=stmnt />
		</#list>
		<#else>
			//TODO Recuerde a�adir su codigo aqui...
		</#if>		
		</#if>
		</#list>
		</#if>
	}		
</#list>	
</#if>
</#macro>