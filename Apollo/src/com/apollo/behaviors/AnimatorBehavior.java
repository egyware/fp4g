package com.apollo.behaviors;

import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;

import com.apollo.BaseBehavior;
import com.apollo.Behavior;
import com.apollo.BehaviorTemplate;
import com.apollo.Engine;
import com.apollo.annotate.InjectComponent;
import com.apollo.utils.State;
import com.apollo.utils.StateMachine;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.ObjectMap.Entry;
import com.egysoft.gdx.Game;

public class AnimatorBehavior extends BaseBehavior
{
	private static class AnimatorStateTemplate 
	{
		public Animation animation;
		public String action;
		public AnimatorStateTemplate(Animation _animation, String _action) 
		{
			animation = _animation;
			action = _action;
		}		
	}
	public static class Template implements BehaviorTemplate, Serializable 
	{
		public static final int DEFAULT_DURATION = 200;		
		public String atlasName;
		public String regionName;		
		public ObjectMap<String, Animation> animations;
		public ObjectMap<String, AnimatorStateTemplate> states;
		
		@Override
		public void write(Json json)
		{						
		}

		@Override
		public void read(Json json, JsonValue jsonData) 
		{
			atlasName = jsonData.getString("atlasName"); //no debe ser null y si lo es gg
			regionName = jsonData.getString("regionName", null);
			animations = new ObjectMap<String, Animation>();
			
			TextureAtlas atlas = Game.instance.assets.get(atlasName);
			Array<AtlasRegion> regions = (regionName != null)?atlas.findRegions(regionName):null;
			JsonValue animationsData = jsonData.get("animations");
			
			for (JsonValue animation : animationsData)
			{
				if(regionName == null) regions = atlas.findRegions(animation.name);				
				JsonValue data = animation.get("data");												
				final int duration = animation.getInt("duration", DEFAULT_DURATION);
				Array<TextureRegion> array = null;
				final String playModeName = animation.getString("playMode", "NORMAL").toUpperCase();
				final PlayMode loopType = PlayMode.valueOf(playModeName);
				//corrigiendo un bug, si no existe sequence
				if(data != null)
				{
					array = new Array<TextureRegion>(data.size);
					for (int i = 0; i < data.size; i++)
					{
						array.add(regions.get(data.getInt(i))); 
					}
				}
				else
				{
					array = new Array<TextureRegion>(regions.size);
					for (int i = 0; i < regions.size; i++) {
						array.add(regions.get(i));
					}
				}
				
				// ya ahora están listos los datos :D				
				animations.put(animation.name, new Animation(duration * 0.001f, array,loopType));
			}
			// Los states tienen 3 valores
			//- Animation: El nombre de la animacion a usar
			//- Action: Alguna acción si es que tiene que aplicar flip o alguna otra cosa
			//- Condition: Condiciones automaticas para cambiar las animaciones
			JsonValue statesData = jsonData.get("states");
			if(statesData != null)
			{
				states = new ObjectMap<String, AnimatorStateTemplate>();
				
				for(JsonValue state:statesData)
				{
					String animationName = state.getString("animation");					
					Animation animation = animations.get(animationName);
					String action    = state.getString("action", null); //action, pertenece a state
					
					states.put(state.name, new AnimatorStateTemplate(animation, action));
				}
			}
		}
		
		@Override
		public Behavior createBehavior(final Engine engine, int x, int y, int w, int h, ObjectMap<String, Object> map) 
		{
			AnimatorBehavior behavior = new AnimatorBehavior(animations);
			if(states != null)
			{
				ObjectMap<String, AnimatorState> statesMap = behavior.states;
				for(Entry<String, AnimatorStateTemplate> state:states)
				{
					final AnimatorStateTemplate template = state.value;
					final AnimatorState animatorState;
					if(template.action != null)
					{												
						LuaValue function = engine.loadScript(template.action);
						
						// [27-04-2015] es buena la idea de usar otro script de lua para inyectar sin tener que hacer cosas raras en luaj las variables necesarias
						// Sin embargo:
						// 1.- No tenemos la instancia de entity
						// 2.- Si la tuviesemos, entity no está construido bien aún.
						// 3.- Queda hacer new en initialize.

						animatorState = behavior.new AnimatorState(template.animation,function);
					}
					else
					{
						animatorState = behavior.new AnimatorState(template.animation);
					}
					statesMap.put(state.key, animatorState);					 
				}				
			}
			
			
			return behavior;
		}
		
	}
	@InjectComponent(ActorBehavior.class)
	private SpriteBehavior spriteBehavior;
	private ObjectMap<String, Animation> animations;
	private ObjectMap<String, AnimatorState> states;
	private StateMachine stateMachine;
	private Animation currentAnimation;
	private float stateTime;
	
	public AnimatorBehavior()
	{
		this(new ObjectMap<String, Animation>());		
	}
	
	public AnimatorBehavior(ObjectMap<String, Animation> _animations)
	{
		animations = _animations;
		stateMachine = new StateMachine();
		states = new ObjectMap<String, AnimatorState>();
	}
	
	@Override
	public void initialize()
	{
		final Engine engine = getEngine();
		LuaValue _class = getEngine().getGlobals().get("animatorState");
		if(_class == LuaValue.NIL)
		{
			engine.getGlobals().get("require").call("animations");
			_class = engine.getGlobals().get("animatorState");
		}
		for(AnimatorState state:states.values())
		{
			//se almacena temporalmente la funcion de action (enter) en el estado y luego se inicializa acá.
			if(state.action != null)
			{
				LuaValue action = _class.get("new").call(CoerceJavaToLua.coerce(owner), state.action);
				state.action = action;
			}			
		}		
	}
	
	
	public void setState(String newState)
	{
		final State state = states.get(newState);
		if(state != null)
		{	
			if(!stateMachine.isStackEmpty()) stateMachine.popState();		
			stateMachine.pushState(state);
		}
	}
	
	@Override
	public void update(float delta)
	{
		//revisar las condiciones
		stateMachine.update(delta);
		stateTime += delta; 
		TextureRegion region = currentAnimation.getKeyFrame(stateTime);
		spriteBehavior.setRegion(region);		
	}
	
	public void setAnimation(String newAnimation)
	{
		Animation nuevo = animations.get(newAnimation);
		if(nuevo != null)
		{
			currentAnimation = nuevo;
			stateTime = 0;
		}
	}	
	
	private void setAnimation(Animation nuevo) 
	{
		if(nuevo != null)
		{
			currentAnimation = nuevo;
			stateTime = 0;
		}		
	}
	
	private class Condition
	{
		public boolean isActive()
		{
			return false;
		}
		public AnimatorState getNext()
		{
			return null;
		}
	}
	private class AnimatorState implements State
	{
		private Animation animation;
		private LuaValue action;
		private Array<Condition> conditions;
		
		public AnimatorState(Animation _animation, LuaValue _action) 
		{
			animation = _animation;
			action    = _action;
		}

		public AnimatorState(Animation animation)
		{
			this(animation, null);
		}

		@Override
		public void enter() 
		{	
			setAnimation(animation);
			if(action != null) action.get("enter").call();
		}

		@Override
		public void update(float dt) 
		{	
			//revisar condiciones
			for(Condition c:conditions)
			{
				if(c.isActive())
				{
					stateMachine.popState();
					stateMachine.pushState(c.getNext());
				}
			}
		}		
	}
}
