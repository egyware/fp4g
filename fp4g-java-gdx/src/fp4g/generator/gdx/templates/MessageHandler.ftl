<#import "fp4g.ftl" as fp4g />
package ${source.pckg};
<#if source.imports??>
<#list source.imports as import>
import ${import};
</#list>
</#if>

${source.javadoc}
public interface ${source.name}MessageHandler extends MessageHandler
{
	<#list messages as message>
	public void on${message.name?cap_first}${source.name}(<#if message.handlerArguments?has_content><#list message.handlerArguments as arg>${arg.type} ${arg.name}<#if arg_has_next>, </#if></#list></#if>);
	</#list>	
}