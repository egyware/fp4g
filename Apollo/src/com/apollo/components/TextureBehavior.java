package com.apollo.components;

import com.apollo.Layer;
import com.apollo.annotate.InjectComponent;
import com.apollo.components.spatial.Spatial;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;

public class TextureBehavior extends Spatial<SpriteBatch> 
{
	@InjectComponent
	private ITransform transform;
	private TextureRegion texture;
	private final int w;
	private final int h;
	 
	public TextureBehavior(TextureRegion texture)
	{
		this.texture = texture;		
		w = texture.getRegionWidth();
		h = texture.getRegionHeight();
	}
	
	@Override
	public Layer getLayer() {
		return Layers.ActorLayer;
	}


	@Override
	public void render(SpriteBatch batch) {
		batch.draw(texture, transform.x-w/2,transform.y-w/2,w/2,h/2,w,h,1,1,MathUtils.radiansToDegrees*transform.rotation);		
	}

}
