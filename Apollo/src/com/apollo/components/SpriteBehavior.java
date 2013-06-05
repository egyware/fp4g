package com.apollo.components;

import com.apollo.Layer;
import com.apollo.World;
import com.apollo.annotate.InjectComponent;
import com.apollo.components.spatial.Spatial;
import com.apollo.managers.graphics.Sprite;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class SpriteBehavior extends Spatial<SpriteBatch> 
{	
	@InjectComponent
	private Transform transform;
	private Sprite sequence;	
	private Animation current_sequence;
	private float current_time;	
	private String current_id;
	private boolean flip_x;
	private boolean flip_y;
	private float origin_x;
	private float origin_y;
		
	public static class Def
	{		
		public String animation;				
		public Sprite sequence;
	}	
	public SpriteBehavior(World world)
	{	
		
	}
	public SpriteBehavior(World world,Def def)
	{	
		sequence = def.sequence;		
		if(def.animation == null)
		{
			current_sequence = sequence.getFirstAnimation();
		}	
		else
		{
			current_sequence = sequence.getAnimation(def.animation);			
		}
		Vector2 temp = sequence.origin();
		origin_x = temp.x;
		origin_y = temp.y;
	}
	
	public void flip(boolean x, boolean y)
	{
		flip_x = x;
		flip_y = y;
	}
	
	@Override
	public Layer getLayer() {
		
		return Layers.ActorLayer;
	}
	
	@Override 
	public void update(float delta)
	{		
		current_time += delta;		
	}

	@Override
	public void render(SpriteBatch graphicsContext) {
		TextureRegion current_region = sequence.getKeyFrame(current_sequence,current_time,true);		
		if(flip_x && !current_region.isFlipX())
		{
			current_region.flip(true, false);			
		}
		else if(!flip_x && current_region.isFlipX())			
		{
			current_region.flip(true, false);
		}
		if(flip_y && !current_region.isFlipY())
		{
			current_region.flip(false,true);			
		}
		else if(!flip_y && current_region.isFlipY())			
		{
			current_region.flip(false,true);
		}
		
		graphicsContext.draw(current_region, transform.x-origin_x, transform.y-origin_y);		
	}
	public void setAnimation(String animation) {
		if(current_id == null)
		{
			current_id = animation;
			current_sequence = sequence.getAnimation(animation);
		}
		else if(!current_id.equals(animation))
		{
			current_id = animation;
			current_sequence = sequence.getAnimation(animation);
		}
	}
	

	

}
