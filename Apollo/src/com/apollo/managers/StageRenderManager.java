package com.apollo.managers;

import com.apollo.Entity;
import com.apollo.components.ActorBehavior;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;


public class StageRenderManager extends Manager 
{
	private final Stage stage;
	private final com.badlogic.gdx.scenes.scene2d.Group backgroundLayer;
	private final com.badlogic.gdx.scenes.scene2d.Group actorLayer;
	private final com.badlogic.gdx.scenes.scene2d.Group frontLayer;
	
	private StageRenderManager(Stage stage)
	{
		this.stage = stage;
		backgroundLayer = new com.badlogic.gdx.scenes.scene2d.Group();
		actorLayer  = new com.badlogic.gdx.scenes.scene2d.Group();
		frontLayer  = new com.badlogic.gdx.scenes.scene2d.Group();
		stage.addActor(backgroundLayer);
		stage.addActor(actorLayer);
		stage.addActor(frontLayer);
	}
	public StageRenderManager()
	{
		this(new Stage());
	}
	public StageRenderManager(int w,int h, SpriteBatch batch)
	{
		this(new Stage(w,h,true, batch));		
	}
	
	public void added(Entity e) 
	{
		ActorBehavior ab = e.getBehavior(ActorBehavior.class);
		if(ab != null)
		{
			actorLayer.addActor(ab);
		}
	}
	
	public void removed(Entity e)
	{
		ActorBehavior ab = e.getBehavior(ActorBehavior.class);
		if(ab != null)
		{
			ab.remove();
		}
	}
	
	public void update(float delta)
	{
		stage.act(delta);
	}	
	
	public Camera getCamera()
	{
		return stage.getCamera();
	}	
	
}
