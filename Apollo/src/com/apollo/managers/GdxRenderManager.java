package com.apollo.managers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GdxRenderManager extends RenderManager<SpriteBatch> {

	public GdxRenderManager(SpriteBatch batch)
	{
		super(batch);
	}
	
	public GdxRenderManager() {
		super(new SpriteBatch());

	}	
	
	@Override
	public void update(float delta)
	{		
		render(context);        		
	}

	
	public Texture getTexture(String textureName)
	{		
		return null;
	}
}
