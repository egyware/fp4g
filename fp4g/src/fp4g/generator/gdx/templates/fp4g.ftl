<#macro translate statement>
<#switch statement.type>
<#case 0><#-- Send MessageSender.instance().send(receiver, message); -->	
		${statement.to}.onMessage(${statement.message}<#if statement.params?has_content>,<@params p=statement.params /></#if>);
<#break>
<#case 1><#-- delete owner -->			
		getWorld().deleteEntity(this);
<#break>
<#default>
		//TODO No se reconoce la instrucción: "${statement.class.simpleName}"
</#switch>
</#macro>
<#macro params p><#list p as param>${param}<#if param_has_next>,</#if></#list></#macro>