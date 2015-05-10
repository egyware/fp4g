package com.apollo.behaviors;

import com.apollo.Behavior;
import com.apollo.BehaviorTemplate;
import com.apollo.Engine;
import com.apollo.annotate.InjectComponent;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ObjectMap;
import com.egysoft.gdx.Game;

public class SpriteBehavior extends ActorBehavior
{
	public static class Template implements BehaviorTemplate
	{
		public String atlasName;
		public String regionName;
		public int index;
		public Vector2 offset;
		

		@Override
		public Behavior createBehavior(final Engine entity, final int x, final int y, final int w, final int h,final ObjectMap<String, Object> map)
		{
			final SpriteBehavior behavior;
			if(regionName != null && atlasName != null)
			{
				TextureAtlas atlas = Game.instance.assets.get(atlasName);
				behavior = new SpriteBehavior(atlas, regionName, index);
			}
			else
			{
				behavior =  new SpriteBehavior();
			}
			if(offset != null)
			{
				behavior.offsetX = offset.x;
				behavior.offsetY = offset.y;				
			}
			return behavior;
		}		
	}
	private float offsetX;
	private float offsetY;
	private TextureRegion texture;
	
	@InjectComponent
	private TransformBehavior transform;
	
	public SpriteBehavior(TextureAtlas atlas, String spriteName)
	{
		texture = atlas.findRegion(spriteName);
	}	
	public SpriteBehavior(TextureAtlas atlas, String spriteName, int index)
	{
		texture = atlas.findRegion(spriteName, index);
	}
	public SpriteBehavior()
	{		
	}
	
	public void act(float delta)
	{
		super.act(delta);
		setPosition(transform.x,transform.y);
		setRotation(transform.rotation * MathUtils.radiansToDegrees);
	}
	
	public void draw(Batch batch, float parentAlpha)
	{	
		Color color = getColor();
		batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
		final float tw = texture.getRegionWidth();
		final float th = texture.getRegionHeight();
		batch.draw(texture, getX()-offsetX, getY()-offsetY, tw/2,th/2, tw, th, getScaleX(),getScaleY(),getRotation());
		batch.setColor(color.r, color.g, color.b, color.a);		
	}
	
	public void flipX(boolean b)
	{		
		setScaleX((b?-1:1)*Math.abs(getScaleX()));		
	}
	public void flipY(boolean b)
	{
		setScaleY((b?-1:1)*Math.abs(getScaleY()));
	}
	public boolean isFlipX()
	{
		return getScaleX()<0;
	}
	public boolean isFlipY()
	{
		return getScaleY()<0;
	}
	
	public void setRegion(TextureRegion region) 
	{
		texture = region;		
	}
	@Override
	public String toString()
	{
		return String.format("SpriteBehavior: {}");
	}
}
