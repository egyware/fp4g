package ${source.pckg};

<#if source.imports??>
<#list source.imports as import>
import ${import};
</#list>
</#if>

${source.javadoc}
public final class ${source.name} extends GameState
{
	private final WorldContainer container;	
	
	//sistemas o manejadores
	<#if managers??>
	<#list managers as manager>
	private ${manager.name} ${manager.varName};
	</#list>
	</#if>
	
	//variables adicionales, a�adidas por los sistemas.
	<#if managers??>
	<#list managers as manager>
	<#if manager.fields?has_content>
	<#list manager.fields as field>
	private ${field};
	</#list>	
	</#if>
	</#list>
	</#if>
	
	private GameManager game;
	public ${source.name}(GameManager game)
	{
		super(game);
		this.game = game;
		container = new WorldContainer(game);		
	}
	
	@Override	
	public void update(float delta)
	{
		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		<#if managers??>
		<#list managers as manager>
		<#if manager.preUpdate?has_content>
		<#list manager.preUpdate as preupdate>
		${preupdate};		
		</#list>
		</#if>
		</#list>
		</#if>
		
		container.update(delta);
		<#if managers??>
		<#list managers as manager>
		${manager.varName}.update(delta);
		</#list>
		</#if>
		
		<#if managers??>
		<#list managers?reverse as manager>
		<#if manager.postUpdate?has_content>
		<#list manager.postUpdate as postupdate>
		${postupdate};
		</#list>
		</#if>
		</#list>
		</#if>		
	}	
	
	@Override
	public boolean load()
	{
		final int w = game.getWidth();
		final int h = game.getHeight();
		
		Gdx.input.setInputProcessor(container.getInputProcessor());
		
		//entityBuilders
		<#if builders??>		
		<#list builders as builder>
		container.setEntityBuilder(new ${builder}Builder());
		</#list>
		</#if>
		
		//cargar los assets aqui.
		<#if assets?has_content>
		<#assign counter = 0 />
		<#list assets as asset>		
		<#if asset.parameterName??>
		<#assign paramName = "${asset.parameterName?uncap_first}_${counter}" />
		${asset.parameterName} ${paramName} = new ${asset.parameterName}();				
		<#list asset.params as param>
		${paramName}.${param.key} = ${param.value};		
		<#assign counter = counter + 1 />
		</#list>
		assets.load("${asset.resource}", ${asset.type}.class, ${paramName});
		<#else>
		assets.load("${asset.resource}", ${asset.type}.class);
		</#if>		
		</#list>
		assets.finishLoading();
		</#if>
		
		//managers
		<#if managers??>
		<#list managers as manager>
		<#if manager.preInitialize??>
		<#list manager.preInitialize as preinit>
		${preinit};
		</#list>
		</#if>
		${manager.varName} = new ${manager.name}(<#if manager.params??><#list manager.params as param>${param}<#if param_has_next>, </#if></#list></#if>);
		</#list>
		</#if>
		
		<#if managers??>
		<#list managers as manager>
		<#if manager.setters??>
		<#list manager.setters as set>
		${manager.varName}.${set};
		</#list>
		</#if>
		<#if manager.setMethod??>
		container.set${manager.setMethod}(${manager.varName});
		<#else>
		container.setManager(${manager.varName});		
		</#if>				
		<#if manager.postInitialize??>
		<#list manager.postInitialize as postinit>
		${postinit};
		</#list>
		</#if>
		</#list>
		</#if>		
		
		<#if managers?has_content>
		<#list managers as manager>
		<#if manager.property?has_content>		
		<#assign map = manager.property>
		<#list map?keys as key> 
		${manager.varName}.set${key?cap_first}(${map[key]});
		</#list>
		</#if>
		</#list>
		</#if>		
		
		
		//entidades
		<#if entities??>		
		<#list entities as entity>
		<#if entity.varName??>
		Entity ${entity.varName} = container.createEntity("${entity.name}"<#if entity.params?has_content>,<#list entity.params as param>${param}<#if param_has_next>, </#if></#list></#if>);
		container.addEntity(${entity.varName});
		<#else>
		container.addEntity(container.createEntity("${entity.name}"<#if entity.params?has_content>,<#list entity.params as param>${param}<#if param_has_next>, </#if></#list></#if>));
		</#if>		
		</#list>
		</#if>
		
		return true;	
	}
	@Override
	public void unload()
	{
	}	

	@Override
	public void enter()
	{
	}	
	
	@Override
	public void exit()
	{
	}		
	
	@Override
	public void pause()
	{
	}	
	
	@Override
	public void resume()
	{
	}
}
