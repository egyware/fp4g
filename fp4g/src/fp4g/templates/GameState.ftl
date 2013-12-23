package ${class.pckg};

<#if class.imports??>
<#list class.imports as import>
import ${import};
</#list>
</#if>

${class.javadoc}
public final class ${class.name} extends GameState{
	private final World world;	
	<#if debug>
	<#if physicsManager??>
	private OrthographicCamera debugCamera;
	private Box2DDebugRenderer debugRender = new Box2DDebugRenderer(true,true,true,true,true);
	</#if>
	private FPSLogger fpsLogger = new FPSLogger();	
	</#if>		
	
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
	
	public ${class.name}(GameManager manager)
	{
		world = new World(manager);		
	}
	
	@Override	
	public void update(float delta)
	{
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		<#if managers??>
		<#list managers as manager>
		<#if manager.preupdate?has_content>
		<#list manager.preupdate as preupdate>
		${preupdate};		
		</#list>
		</#if>
		</#list>
		</#if>
		
		world.update(delta);
		<#if managers??>
		<#list managers as manager>
		${manager.varName}.update(delta);
		</#list>
		</#if>
		
		<#if managers??>
		<#list managers?reverse as manager>
		<#if manager.postupdate?has_content>
		<#list manager.postupdate as postupdate>
		${postupdate};
		</#list>
		</#if>
		</#list>
		</#if>		
	}	
	
	@Override
	public boolean load()
	{
		final int w = ${game.name}.Width;
		final int h = ${game.name}.Height;
		
		Gdx.input.setInputProcessor(world.getInputProcessor());
		
		<#if debug>
		<#if physicsManager??>
		debugCamera = new OrthographicCamera();
		debugCamera.setToOrtho(false,w*SCALE,h*SCALE);
		</#if>
		</#if>
		
		//entityBuilders
		<#if entityBuilders??>		
		<#list entityBuilders as builder>
		world.setEntityBuilder(new ${builder}Builder());
		</#list>
		</#if>
		
		//managers
		<#if managers??>
		<#list managers as manager>
		<#if manager.preinit??>
		<#list manager.preinit as preinit>
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
		world.set${manager.setMethod}(${manager.varName});
		<#else>
		world.setManager(${manager.varName});		
		</#if>
		</#list>
		</#if>		
		
		//cargar los assets aqui.
		<#if assets?has_content>
		<#assign counter = 0 />
		<#list assets as asset>		
		<#if asset.parameterName??>
		//TODO quedo pendiente esto...
		<#assign paramName = "${asset.parameterName?uncap_first}_${counter}" />
		${asset.parameterName} ${paramName} = new ${asset.parameterName}();				
		<#list asset.params as param>
		//${paramName}.;
		<#assign counter = counter + 1 />
		</#list>
		Utils.loadAsset(${asset.resource}, ${asset.type}.class, ${paramName});
		<#else>
		Utils.loadAsset(${asset.resource}, ${asset.type}.class);
		</#if>		
		</#list>
		Utils.loadAssets();
		</#if>
			
		//entidades
		<#if entities??>		
		<#list entities as entity>
		<#if entity.varName??>
		Entity ${entity.varName} = world.createEntity("${entity.name}"<#if entity.params?has_content>,<#list entity.params as param>${param}<#if param_has_next>, </#if></#list></#if>);
		world.addEntity(${entity.varName});
		<#else>
		world.addEntity(world.createEntity("${entity.name}"<#if entity.params?has_content>,<#list entity.params as param>${param}<#if param_has_next>, </#if></#list></#if>));
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
