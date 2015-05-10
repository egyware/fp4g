package com.apollo.behaviors;

import com.apollo.BaseBehavior;
import com.apollo.Behavior;
import com.apollo.BehaviorTemplate;
import com.apollo.Engine;
import com.apollo.annotate.InjectComponent;
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
import com.egysoft.gdx.Game;

public class AnimatorBehavior extends BaseBehavior
{
	public static class Template implements BehaviorTemplate, Serializable 
	{
		public static final int DEFAULT_DURATION = 200;		
		public String atlasName;
		public String regionName;	
		public String animation;
		public ObjectMap<String, Animation> animations;
		
		@Override
		public void write(Json json)
		{						
		}

		@Override
		public void read(Json json, JsonValue jsonData) 
		{
			atlasName = jsonData.getString("atlasName"); //no debe ser null y si lo es gg
			regionName = jsonData.getString("regionName", null);
			animation = jsonData.getString("animation", null);
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
		}
		
		@Override
		public Behavior createBehavior(final Engine engine, int x, int y, int w, int h, ObjectMap<String, Object> map) 
		{
			AnimatorBehavior animator = new AnimatorBehavior(animations);
			Animation ani;
			if(animation != null)
			{
				ani = animations.get(animation);
			}
			else
			{
				ani = animations.values().next();
			}
			animator.setAnimation(ani);
			return animator;			
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
	
	public void setState(String newState)
	{
		final AnimatorState state = states.get(newState);
		setState(state);		
	}
	
	@Override
	public void update(float delta)
	{
		//revisar las condiciones
		stateMachine.update(delta);
		if(currentAnimation != null)
		{
			stateTime += delta; 
			TextureRegion region = currentAnimation.getKeyFrame(stateTime);			
			spriteBehavior.setRegion(region);
		}
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
	
	public Animation getAnimation(String animationName) 
	{
		return animations.get(animationName);
	}
	
	protected void setAnimation(Animation nuevo) 
	{
		if(nuevo != null)
		{
			currentAnimation = nuevo;
			stateTime = 0;
		}		
	}

	protected void setState(AnimatorState next) 
	{
		if(next != null)
		{	
			stateMachine.setCurrentState(next);
		}				
	}

	public void addState(String name, AnimatorState state)
	{
		states.put(name, state);		
	}	
}
