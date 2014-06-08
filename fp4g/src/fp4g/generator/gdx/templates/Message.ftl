<#import "fp4g.ftl" as fp4g />
package ${source.pckg};
<#if source.imports??>
<#list source.imports as import>
import ${import};
</#list>
</#if>

${source.javadoc}
public enum ${source.name}Message implements Message<${source.name}MessageHandler>
{
	<#list messages as message>
	on${message.name?cap_first}${source.name},
	</#list>	
	;

	@Override
	public void dispatch(MessageHandler h, Object... args)
	{
		final ${source.name}MessageHandler handler = (${source.name}MessageHandler)h;
		switch(this)
		{		
		<#list messages as message>
		case on${message.name?cap_first}${source.name}:
			handler.on${message.name?cap_first}${source.name}(<#if message.arguments?has_content><#list message.arguments as arg><#if arg.defaultValue??>((${arg.type?cap_first})args[${arg_index}]).${arg.defaultValue}()<#else>(${arg.type?cap_first})args[${arg_index}]</#if><#if arg_has_next>, </#if></#list></#if>);
			break;
		</#list>		
		}		
	}

	@Override
	public Class<${source.name}MessageHandler> getClassHandler() 
	{
		return ${source.name}MessageHandler.class;		
	}
}