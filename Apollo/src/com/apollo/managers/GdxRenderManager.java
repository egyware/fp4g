package com.apollo.managers;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GdxRenderManager extends RenderManager<SpriteBatch> {
	private Camera camera; 

	
	public GdxRenderManager() {
		super(new SpriteBatch());

	}
	public void setCamera(Camera cam)
	{
		camera = cam;
	}
	public Camera getCamera()
	{
		return camera;
	}
	
	@Override
	public void update(float delta)
	{		
		context.setProjectionMatrix(camera.combined);
		context.begin();
		render(context);
        context.end();		
	}

	
	public Texture getTexture(String textureName)
	{		
		return null;
	}
}
