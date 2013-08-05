package ${class.package};

<#if class.imports??>
<#list class.imports as import>
import ${import};
</#list>
</#if>

${autodoc}
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
	private ${manager.name} ${manager.name?uncap_first};
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
		
		world.update(delta);
		<#if managers??>
		<#list managers as manager>
			${manager.name?uncap_first}.update(delta);
		</#list>
		</#if>
		
		
		//your render here
		<#if debug>
		<#if physicsManager??>
		cameraDebug.position.x = camera.position.x * SCALE;
		cameraDebug.position.y = camera.position.y * SCALE;
		cameraDebug.update();
		debugRender.render(${physicsManager}.getb2World(),debugCamera.combined); 
		</#if>	
		fpsLogger.log();			
		</#if>
	}	
	
	@Override
	public boolean load()
	{
		int w = ${game.name}.Width;		 
		int h = ${game.name}.Height;
		
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
		world.setEntityBuilder(new ${builder.name});
		</#list>
		</#if>
		
		//managers
		<#if managers??>
		<#list managers as manager>
		${manager.name?uncap_first} = new ${manager.name}();
		<#if manager.entity>
		world.setEntityManager(${manager.name?uncap_first});
		<#elseif manager.render>
		world.setCamera(camera);
		world.setManager(${manager.name?uncap_first});
		<#else>
		world.setManager(${manager.name?uncap_first});
		</#if>
		</#list>
		</#if>		
		
		//entidades
		<#if entities??>		
		<#list entities as entity>
		<#if entity.varName??>
		Entity ${entity.varName} = world.createEntity(${entity.name}); //TODO agregar parametros a esta wea...
		world.addEntity(${entity.varName});//TODO acá le falta agregar algo extra...
		<#else>
		world.addEntity((world.createEntity(${entity.name})); //TODO agregar parametros a esta wea...
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
		

<#-- visitante
		@Override
		public void visitor(JExpression dataVar, JBlock block,IScope scope, String key, Object value) {
			if(value instanceof IScope) //es otro scope
			{	
				JClass _familyClass    = jcm.ref(String.format("%s.%s",Utils.componentsPackageName,Utils.getFamilyByComponent(key)));
				JClass _componentClass = jcm.ref(String.format("%s.%s",Utils.componentsPackageName,key));
				JExpression inv = dataVar.invoke("getComponent").arg(_familyClass.staticRef("class"));
				if(!_familyClass.equals(_componentClass))
				{
					inv = JExpr.cast(_componentClass, inv);
				}	
				IScope child = (IScope)value;
				if(child.size() > 0)
				{
					JBlock subBlock = block.block();
					inv = subBlock.decl(_componentClass, String.format("_%s_component",key), inv);
					Utils.assingScope(inv,subBlock,(MapScope)value);
				}
				else
				{
					Utils.assingScope(inv,block,(MapScope)value);
				}
								
			}			
		}
		
	};
-->	
}
