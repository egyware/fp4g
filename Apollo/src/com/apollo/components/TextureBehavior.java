package com.apollo.components;

import com.apollo.Layer;
import com.apollo.annotate.InjectComponent;
import com.apollo.components.spatial.Spatial;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class TextureBehavior extends Spatial<SpriteBatch> 
{
	@InjectComponent
	private TransformFamily transform;
	private Texture texture;
	private final int w;
	private final int h;
	 
	public TextureBehavior(Texture texture)
	{
		this.texture = texture;		
//		w = texture.getRegionWidth();
//		h = texture.getRegionHeight();
		w = texture.getWidth();
		h = texture.getHeight();
	}
	
	public static TextureBehavior build(Texture texture)
	{
		return new TextureBehavior(texture);
	}
	
	@Override
	public Layer getLayer() {
		return Layers.ActorLayer;
	}


	@Override
	public void render(SpriteBatch batch) {
		//batch.draw(texture, transform.x-w/2,transform.y-w/2,w/2,h/2,w,h,1,1,MathUtils.radiansToDegrees*transform.rotation);
		batch.draw(texture, transform.x-w/2,transform.y-w/2, w/2,h/2, w,h, 1,1, MathUtils.radiansToDegrees * transform.rotation, 0,0, w,h, false,false);
	}

}
