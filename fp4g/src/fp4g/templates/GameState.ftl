package ${class.pckg};

<#if class.imports??>
<#list class.imports as import>
import ${import};
</#list>
</#if>

${class.javadoc}
public final class ${class.name} extends GameState{
	private World world;
	public OrthographicCamera camera;
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
		${manager.preupdate}
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
		${manager.postupdate}
		</#if>
		</#list>
		</#if>		
	}	
	
	@Override
	public boolean load()
	{
		final int w = ${game.name}.Width;		 
		final int h = ${game.name}.Height;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false,w,h);	
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
		${manager.varName} = new ${manager.name}();
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
		
			
		//entidades
		<#if entities??>		
		<#list entities as entity>
		<#if entity.varName??>
		Entity ${entity.varName} = world.createEntity("${entity.name}"); //TODO agregar parametros a esta wea...
		world.addEntity(${entity.varName});
		<#else>
		world.addEntity(world.createEntity("${entity.name}")); //TODO agregar parametros a esta wea...
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
