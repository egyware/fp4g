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
	on${message.name}${source.name},
	</#list>	
	;

	@Override
	public void dispatch(MessageHandler h, Object... args)
	{
		final ${source.name}MessageHandler handler = (${source.name}MessageHandler)h;
		switch(this)
		{		
		<#list messages as message>
		case on${message.name}${source.name}:
			handler.on${message.name}${source.name}(<#list arguments as arg><#if arg.method??>((${arg.type})args[${arg_index}]).${arg.method}()<#else>(${arg.type})args[${arg_index}]</#if><#if arg_has_next>, </#if></#list>);
			break;
		</#list>		
		}		
	}

	@Override
	public Class<${message.name}MessageHandler> getClassHandler() 
	{
		return ${message.name}MessageHandler.class;		
	}
}