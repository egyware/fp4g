package com.apollo.behaviors;

import com.apollo.Behavior;
import com.apollo.BehaviorTemplate;
import com.apollo.Engine;
import com.apollo.annotate.InjectComponent;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ObjectMap;
import com.egysoft.gdx.Game;

public class SpriteBehavior extends ActorBehavior
{
	public static class Template implements BehaviorTemplate
	{
		public String atlasName;
		public String regionName;
		public int index;
		

		@Override
		public Behavior createBehavior(final Engine engine, final int x, final int y, final int w, final int h,final ObjectMap<String, Object> map)
		{
			TextureAtlas atlas = Game.instance.assets.get(atlasName);
			if(regionName != null)
			{
				return new SpriteBehavior(atlas, regionName, index);
			}
			else
			{
				return new SpriteBehavior();
			}
		
			
		}		
	}
	private Sprite sprite;
	
	
	@InjectComponent
	private TransformBehavior transform;
	
	public SpriteBehavior(TextureAtlas atlas, String spriteName, int index)
	{
		sprite = atlas.createSprite(spriteName);
	}
	public SpriteBehavior()
	{
		sprite = new Sprite();
	}
	
	public void act(float delta)
	{
		super.act(delta);
		setPosition(transform.x,transform.y);
		setRotation(transform.rotation * MathUtils.radiansToDegrees);
		//pasandole las weas a sprite
		sprite.setPosition(getX(), getY());
	    sprite.setOrigin(getOriginX(), getOriginY());
	    sprite.setRotation(getRotation());
	    sprite.setScale(getScaleX(), getScaleY());
	}
	
	public void draw(Batch batch, float parentAlpha)
	{	
		Color color = getColor();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        sprite.draw(batch);
	}
	
	public void setFlipX(boolean b)
	{
		sprite.setFlip(b, sprite.isFlipY());
	}
	public void setFlipY(boolean b)
	{
		sprite.setFlip(sprite.isFlipX(), b);
	}
	public boolean isFlipX()
	{
		return sprite.isFlipX();
	}
	public boolean isFlipY()
	{
		return sprite.isFlipY();
	}
	
	
	public void setRegion(TextureRegion region) 
	{
		sprite.setRegion(region);		
	}
	@Override
	public String toString()
	{
		return String.format("SpriteBehavior: {}");
	}
}
