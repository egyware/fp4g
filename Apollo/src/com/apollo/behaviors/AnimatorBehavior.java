package com.apollo.behaviors;

import com.apollo.BaseBehavior;
import com.apollo.Behavior;
import com.apollo.BehaviorTemplate;
import com.apollo.Engine;
import com.apollo.annotate.InjectComponent;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.Array;
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
		public ObjectMap<String, Animation> animations;
		
		@Override
		public Behavior createBehavior(Engine engine, int x, int y, int w, int h, ObjectMap<String, Object> map) 
		{
			
			
			return null;
		}

		@Override
		public void write(Json json)
		{
			// TODO Auto-generated method stub
			
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
		}
		
	}
	@InjectComponent(ActorBehavior.class)
	private SpriteBehavior spriteBehavior;
	private ObjectMap<String, Animation> animations;
	private Animation currentAnimation;
	private float stateTime;
	
	@Override
	public void update(float delta)
	{
		//revisar las condiciones		
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
	
	public boolean isEndedCurrentAnimation()
	{
		return (PlayMode.NORMAL == currentAnimation.getPlayMode()) && currentAnimation.isAnimationFinished(stateTime);
	}
	
}
