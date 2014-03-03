package com.apollo.components;

import com.apollo.annotate.InjectComponent;
import com.apollo.managers.graphics.Sprite;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class SpriteBehavior extends ActorBehavior
{
	private Animation current;
	private Sprite sprite;
	private Vector2 o;		
	private float time;
	
	@InjectComponent
	private TransformFamily transform;
	
	public SpriteBehavior(Sprite sprite)
	{
		this.sprite = sprite;
		o = sprite.origin();
		current = sprite.getFirstAnimation();
	}
	
	public void setAnimation(String id)
	{
		current = sprite.getAnimation(id);
		time = 0;
	}
	
	public void act(float delta)
	{
		super.act(delta);
		time += delta;
		setPosition(transform.x,transform.y);
		setRotation(transform.rotation * MathUtils.radiansToDegrees);
	}
	
	public void draw(SpriteBatch batch, float parentAlpha)
	{	
		TextureRegion frame = sprite.getKeyFrame(current,time);
		batch.draw(frame, getX() - frame.getRegionWidth()/2 - o.x, getY() - o.y);		
	}
	
	public static SpriteBehavior build(Sprite sprite)
	{
		return new SpriteBehavior(sprite);
	}
}
