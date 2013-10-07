package ${class.package};

<#if class.imports??>
<#list class.imports as import>
import ${import};
</#list>
</#if>

${autodoc}
public class ${class.name} extends GameManager {
	public static final int Width  = ${width};
	public static final int Height = ${height};

	@Override
	public void create()
	{
		super.create();
		Utils.initialize();	
	}
	
	@Override 
	public void resize(int w,int h)
	{
		<#if start_state??>
		//iniciando el juego 
		${start_state} _start = new ${start_state}(this);     	
		start(_start);
		<#else>
		throw new RuntimeException("¿Se te olvido usar start?");
    	</#if>
	}
    
	@Override
	public void dispose()
	{
		Utils.dispose();
		super.dispose();		
	}
}