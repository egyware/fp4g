package com.apollo.managers;

import com.apollo.Entity;
import com.apollo.components.ActorBehavior;
import com.badlogic.gdx.scenes.scene2d.Stage;


public class StageRenderManager extends Manager 
{
	private Stage stage;
	public StageRenderManager()
	{
		stage = new Stage();
	}
	public StageRenderManager(int w,int h)
	{
		stage = new Stage(w,h);
	}
	
	public void added(Entity e) 
	{
		ActorBehavior ab = e.getBehavior(ActorBehavior.class);
		if(ab != null)
		{
			stage.addActor(ab);
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
