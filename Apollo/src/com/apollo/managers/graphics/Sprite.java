package com.apollo.managers.graphics;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.OrderedMap;

public class Sprite{
	private int width;
	private int height;
	private Vector2 origin;
	private String first;
	private OrderedMap<String,Animation> animations;
	
	public Sprite()
	{
		animations = new OrderedMap<String,Animation>();
	}
	
	public int getWidth()
	{
		return width;
	}
	public int geHeight()
	{
		return height;
	}
	public Vector2 origin()
	{
		return origin;
	}	
	
	public Animation getFirstAnimation() {
		return animations.get(first);		
	}
	public void addAnimation(String id, Animation s) {
		animations.put(id, s);
		s.setPlayMode(Animation.LOOP);
	}

	public Animation getAnimation(String id) {
		return animations.get(id);		
	}

	public TextureRegion getKeyFrame(Animation current_sequence,float current_time,boolean loop) {		
		return current_sequence.getKeyFrame(current_time,loop);
	}

	public boolean isAnimationFinished(Animation current_sequence, float current_time) {
		return current_sequence.isAnimationFinished(current_time);		
	}

}
