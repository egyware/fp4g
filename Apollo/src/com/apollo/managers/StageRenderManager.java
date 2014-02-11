package com.apollo.managers;

import com.apollo.Entity;
import com.apollo.components.ActorBehavior;
import com.badlogic.gdx.scenes.scene2d.Stage;


public class StageRenderManager extends Manager 
{
	private final Stage stage;
	private final com.badlogic.gdx.scenes.scene2d.Group backgroundLayer;
	private final com.badlogic.gdx.scenes.scene2d.Group actorLayer;
	private final com.badlogic.gdx.scenes.scene2d.Group frontLayer;
	
	public StageRenderManager()
	{
		stage = new Stage();
		backgroundLayer = new com.badlogic.gdx.scenes.scene2d.Group();
		actorLayer  = new com.badlogic.gdx.scenes.scene2d.Group();
		frontLayer  = new com.badlogic.gdx.scenes.scene2d.Group();
		stage.addActor(backgroundLayer);
		stage.addActor(actorLayer);
		stage.addActor(frontLayer);
	}
	public StageRenderManager(int w,int h)
	{
		stage = new Stage(w,h);
		backgroundLayer = new com.badlogic.gdx.scenes.scene2d.Group();
		actorLayer  = new com.badlogic.gdx.scenes.scene2d.Group();
		frontLayer  = new com.badlogic.gdx.scenes.scene2d.Group();
		
		stage.addActor(backgroundLayer);
		stage.addActor(actorLayer);
		stage.addActor(frontLayer);
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
	
	
}
