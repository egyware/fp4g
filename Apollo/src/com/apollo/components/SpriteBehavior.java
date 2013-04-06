package com.apollo.components;

import com.apollo.Layer;
import com.apollo.World;
import com.apollo.components.spatial.Spatial;
import com.apollo.managers.graphics.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class SpriteBehavior extends Spatial<SpriteBatch> 
{		
	public final Vector2 position = new Vector2();
	private Sprite sequence;
	private float current_time;
		
	public static class Def
	{			
		public final Vector2 position = new Vector2();
		public String animation;				
		public Sprite sequence;
	}	
	public SpriteBehavior(World world)
	{	 
	}
	public SpriteBehavior(World world,Def def)
	{	
		sequence = def.sequence;
		position.set(def.position);
		if(def.animation == null)
		{
			sequence.setFirstAnimation();
		}	
		else
		{
			sequence.setAnimation(def.animation);			
		}
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
		TextureRegion current_region = sequence.getKeyFrame(current_time,true);		
		graphicsContext.draw(current_region, position.x, position.y);		
	}
	

	

}
