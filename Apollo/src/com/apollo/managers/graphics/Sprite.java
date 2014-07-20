package com.apollo.managers.graphics;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.OrderedMap;

public class Sprite
{	
	private final Vector2 origin;	
	private final OrderedMap<String,Animation> animations;
	private String first;
	
	public Sprite()
	{
		animations = new OrderedMap<String,Animation>();
		origin = new Vector2();
	}
	
	public Vector2 origin()
	{
		return origin;
	}	
	
	public Animation getFirstAnimation()
	{
		return animations.get(first);		
	}
	public void addAnimation(String id, Animation s, PlayMode playMode ) 
	{
		animations.put(id, s);
		s.setPlayMode(playMode);
	}

	public Animation getAnimation(String id) 
	{
		return animations.get(id);
	}

	public TextureRegion getKeyFrame(Animation current_sequence,float current_time)	
	{		
		return current_sequence.getKeyFrame(current_time);
	}

	public boolean isAnimationFinished(Animation current_sequence, float current_time) 
	{
		return current_sequence.isAnimationFinished(current_time);		
	}

}
