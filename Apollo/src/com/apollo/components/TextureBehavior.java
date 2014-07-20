package com.apollo.components;

import com.apollo.annotate.InjectComponent;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;

public class TextureBehavior extends ActorBehavior 
{
	@InjectComponent
	private TransformFamily transform;
	private Texture texture;
	private final int w;
	private final int h;
	 
	public TextureBehavior(Texture texture)
	{
		this.texture = texture;
		w = texture.getWidth();
		h = texture.getHeight();
		
	}
	
	public static TextureBehavior build(Texture texture)
	{
		return new TextureBehavior(texture);
	}
	
	public void act(float delta)
	{
		super.act(delta);	
		setPosition(transform.x,transform.y);
		setRotation(transform.rotation * MathUtils.radiansToDegrees);
	}
	
	public void draw(Batch batch, float parentAlpha)
	{			
		//batch.draw(texture, getX() - w/2, getY() - h/2);
		batch.draw(texture, getX() - w/2, getY() - h/2, w/2,h/2, w,h,1,1,getRotation(),0,0,w,h,false,false);
	}
}
