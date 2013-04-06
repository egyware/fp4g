package fp4g.generator;

import java.util.Map.Entry;

import com.apollo.Entity;
import com.apollo.World;
import com.apollo.managers.EntityManager;
import com.apollo.managers.GameState;
import com.apollo.managers.GdxRenderManager;
import com.apollo.managers.PhysicsManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.sun.codemodel.JBlock;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JExpression;
import com.sun.codemodel.JFieldRef;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JInvocation;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
import com.sun.codemodel.JPackage;
import com.sun.codemodel.JType;
import com.sun.codemodel.JVar;

import static fp4g.Log.ErrType;
import static fp4g.Log.WarnType;
import static fp4g.Log.InfoType;
import static fp4g.Log.Show;
import fp4g.data.Add;
import fp4g.data.Define;
import fp4g.data.Function;
import fp4g.data.IScope;
import fp4g.data.MapScope;
import fp4g.data.Type;

public class StateGenerator {
	private final JCodeModel jcm;
	private final Define state;
	private ScopeVisitor entityVisitor = new ScopeVisitor(){

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
	
	public StateGenerator(Define _define) {
		jcm = Utils.getJCM();
		state = _define;		
	}

	public JDefinedClass generate() throws JClassAlreadyExistsException, ClassNotFoundException {
		// sistema a construir
		String stateName = state.getName();
		IScope stateScope = state.getScope();
		JPackage gamePack = Utils.getGamePackage();
		JDefinedClass stateClass = gamePack._class(JMod.PUBLIC|JMod.FINAL, stateName);		
		stateClass._extends(GameState.class);
		Utils.addAutogenerated(stateClass);
		
		boolean isDebug = (Boolean)stateScope.get("debug");

		// agregar las funciones necesarias, para que quede definido esta cosa y		
		// vaya que son varias
		JMethod update = stateClass.method(JMod.PUBLIC, jcm.VOID, "update");
		JVar delta = update.param(jcm.FLOAT, "delta");
		update.annotate(Override.class);
		
		JFieldVar world = stateClass.field(JMod.PUBLIC, World.class, "world");		
		JInvocation updateWorld = world.invoke("update").arg(delta);		
		{
			JBlock block = update.body();
			
			JFieldRef gl = jcm.ref(Gdx.class).staticRef("gl");
			block.add(gl.invoke("glClearColor").arg(JExpr.lit(1)).arg(JExpr.lit(1)).arg(JExpr.lit(1)).arg(JExpr.lit(1)));				
			block.add(gl.invoke("glClear").arg(jcm.ref(GL10.class).staticRef("GL_COLOR_BUFFER_BIT")));
			//block.directStatement("Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);");		
			block.add(updateWorld);							
		}
			
		
		
		JMethod constructor = stateClass.constructor(JMod.PUBLIC);
		constructor.body().assign(world, JExpr._new(world.type()));
		

//		JMethod resize = stateClass.method(JMod.PRIVATE, jcm.VOID, "resize");
//		resize.annotate(Override.class);
//		resize.param(jcm.INT, "width");
//		resize.param(jcm.INT, "height");		
		
		JMethod load = stateClass.method(JMod.PUBLIC, jcm.BOOLEAN, "load");		
		JMethod unload = stateClass.method(JMod.PUBLIC, jcm.VOID, "unload");
		JMethod enter = stateClass.method(JMod.PUBLIC, jcm.VOID, "enter");
		JMethod exit = stateClass.method(JMod.PUBLIC, jcm.VOID, "exit");		
		JMethod pause = stateClass.method(JMod.PUBLIC, jcm.VOID, "pause");
		JMethod resume = stateClass.method(JMod.PUBLIC, jcm.VOID, "resume");
		
		load.annotate(Override.class);		
		unload.annotate(Override.class);
		enter.annotate(Override.class);
		exit.annotate(Override.class);		
		pause.annotate(Override.class);
		resume.annotate(Override.class);
		
		JFieldVar cameraVar = stateClass.field(JMod.PUBLIC, OrthographicCamera.class, "camera");
		{
			int w = (Integer) stateScope.get("width");
			int h = (Integer) stateScope.get("height");
			JBlock block = load.body();
			block.assign(cameraVar, JExpr._new(jcm._ref(OrthographicCamera.class)));
			block.invoke(cameraVar, "setToOrtho").arg(JExpr.FALSE).arg(JExpr.lit(w)).arg(JExpr.lit(h));
		}
		// una variable loca para el sistema Entity
		JVar entitySystemVar = null;
		JVar physicsSystemVar = null;

		// con esto evitamos el acceso concurrente al hashmap

		Entry<String, Object> arraySets[] = stateScope.toArray();
		for (Entry<String, Object> entry : arraySets) {
			String key = String.format("_%s", entry.getKey());
			Object value = entry.getValue();

			JType typeValue = Utils.getType(value);
			JExpression expr = Utils.getExpr(value);
			if (expr != null) {
				// el objeto field
				stateClass.field(JMod.PRIVATE, typeValue, key, expr);
			} else if (value instanceof Define) {
				Define define = (Define) value;
				Type defineType = define.getType();
				
				switch (defineType) {
				case ENTITY:
					EntityGenerator entityGen = new EntityGenerator(define);
					JDefinedClass entityFactory = entityGen.generate(); 
					
					
					// agregamos la factory correspondiente...
					JInvocation inv = world.invoke("setEntityBuilder").arg(
							JExpr._new(entityFactory));
					load.body().add(inv);

					break;
				case STATE:
					// No se esperaba Define State, se ignora, cambie a otro
					// nivel
					Show(WarnType.ExpectedDefine,define);
					break;
				default:
					break;
				}
			} else if (value instanceof Function)
			{
				Function f = (Function)value;				
				if(f.call(stateClass, null, stateScope) !=null){
					//TODO mostrar error el generador no esperaba una asignaci�n del resultado de una funcion generadora
				}				
			} else if (value instanceof Add) {
				Add add = (Add) value;
				Type addType = add.getType();
				String addName = add.getName();
				IScope addScope = add.getScope();
				Define define = (Define) stateScope.get(addName);
				if (define == null) {
					// no se ha encontrado la variable correcta
					Show(ErrType.NotFoundVar,add);
					break;
				}

				if (addType == define.getType()) // correcto
				{
					switch (addType) {
					case SYSTEM: {
						// copiamos las definiciones de define a addScope sin
						// modificar si ya existen
						define.getScope().writeWithoutOverride(addScope);
						// el objeto field
						Class<?> classSystem =
								Class.forName(String.format("%s.%s",Utils.managersPackageName, define.getName()));
						typeValue = jcm._ref(classSystem);
						JFieldVar var = stateClass.field(JMod.PRIVATE,
								typeValue, key, expr);						
						
						// update method
						{

							JBlock block = update.body();
							JInvocation inv = block.invoke(var, "update");
							inv.arg(delta);
						}

						// loadState
						{													
							JInvocation inv = JExpr._new(typeValue);
							JBlock block = load.body();
						
							//argumentos...
							if(addScope.size()>0){
								JClass dataClass = jcm.ref(String.format("%s.%s",classSystem.getName(),"Def")); 	
								JExpression dataExpr = Utils.addDefClass(dataClass, addName,
										addScope, block);
								inv.arg(dataExpr);
							}

							block.assign(var, inv);
							JInvocation addSystemInv = null;
							if(classSystem == EntityManager.class)
							{	
								if (entitySystemVar == null) {									
									entitySystemVar = var;
								} 
								else
								{
									//TODO error ya est� definido
								}
								addSystemInv = world.invoke("setEntityManager").arg(var);								
							}
							else if(classSystem == PhysicsManager.class)
							{
								if(physicsSystemVar == null)
								{
									physicsSystemVar = var;
								}
								else
								{
									//TODO error ya est� definido para este estado
								}								
								addSystemInv = world.invoke("setManager").arg(var);
							}
							else if(classSystem == GdxRenderManager.class)
							{
								block.invoke(var, "setCamera").arg(cameraVar); //agrego la camara
								addSystemInv = world.invoke("setManager").arg(var);
							}
							else								
							{
								addSystemInv = world.invoke("setManager").arg(var);
							}
							block.add(addSystemInv);

						}
						break;
					}
					case ENTITY: {
						// TODO no se detecta si existe esta factory....
						if (world == null) {
							// no se ha definido el sistema de entidades en este
							// state
							Show(ErrType.NotFoundEntitySystem,add);
							break;
						}
						Class<?> entity = Entity.class;
						JBlock block = load.body();
						JInvocation createEntityInv = JExpr.invoke(world,
								"createEntity");
						createEntityInv.arg(Utils.getExpr(addName));
					
						String varName = String.format("_%s%s", entity
								.getSimpleName().toLowerCase(), key);
						if (addScope.size() > 0) {
							JVar entityVar = block.decl(jcm._ref(entity),varName, createEntityInv);
							Utils.assingScope(entityVar, block, addScope,entityVisitor);
							block.invoke(world, "addEntity").arg(entityVar);
						} else {
							block.invoke(world, "addEntity").arg(createEntityInv);	
						}
						
						break;
					}
					default:
						break;
					}
				} else {
					// No coinciden los tipos
					Show(ErrType.DontMatchTypes,add);
				}
			} else {
				// TODO mostrar error....
			}
			// TODO los dem�s los declaramos despues...

		}
		
		if(isDebug)
		{			
			if(physicsSystemVar != null)
			{
				JFieldVar cameraDebugVar = stateClass.field(JMod.PRIVATE, OrthographicCamera.class, "debugCamera");
				{
						int w = (Integer) stateScope.get("width");
						int h = (Integer) stateScope.get("height");
						JBlock block = load.body();
						block.assign(cameraDebugVar, JExpr._new(jcm._ref(OrthographicCamera.class)));
						block.invoke(cameraDebugVar, "setToOrtho").arg(JExpr.FALSE).arg(JExpr.lit(w*PhysicsManager.SCALE)).arg(JExpr.lit(h*PhysicsManager.SCALE));
				}
				JFieldVar renderDebug = stateClass.field(JMod.PRIVATE, Box2DDebugRenderer.class, "debugRender",JExpr._new(jcm.ref(Box2DDebugRenderer.class)).arg(JExpr.TRUE).arg(JExpr.TRUE).arg(JExpr.TRUE).arg(JExpr.TRUE).arg(JExpr.TRUE));
				update.body().invoke(renderDebug,"render").arg(JExpr.invoke(physicsSystemVar,"getb2World")).arg(JExpr.ref(cameraDebugVar,"combined"));				
			}
			JFieldVar fpsLoggerVar = stateClass.field(JMod.PRIVATE| JMod.FINAL, FPSLogger.class, "fpsLogger");
			update.body().invoke(fpsLoggerVar,"log");
			constructor.body().assign(fpsLoggerVar, JExpr._new(jcm.ref(FPSLogger.class)));
		}
		// y finalizando...
		// regresamos true, asumiendo que todo funcion�
		load.body()._return(JExpr.lit(true));
		return stateClass;

	}
}
