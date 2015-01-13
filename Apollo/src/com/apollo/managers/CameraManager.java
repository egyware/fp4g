package com.apollo.managers;

import com.apollo.Entity;
import com.apollo.behaviors.CameraBehavior;
import com.apollo.behaviors.TransformBehavior;
import com.apollo.utils.Bag;
import com.badlogic.gdx.math.Vector2;

public class CameraManager extends Manager
{
	private com.badlogic.gdx.graphics.Camera camera;
	private Bag<CameraBehavior> cameras = new Bag<CameraBehavior>();
	private CameraBehavior active;
	
	private Entity entity;	
	private TransformBehavior transform;
			
	public void initialize()
	{
		camera = engine.getManager(StageRenderManager.class).getCamera();	
		current = new Vector2(camera.position.x, camera.position.y);
	}
	
	public void added(Entity e) 
	{
		CameraBehavior cameraBehavior = e.getBehavior(CameraBehavior.class);
		if(cameraBehavior != null)
		{
			cameras.add(cameraBehavior);			
		}		
	}
	public void removed(Entity e) 
	{
		CameraBehavior cameraBehavior = e.getBehavior(CameraBehavior.class);
		if(cameraBehavior != null)
		{
			cameras.remove(cameraBehavior);			
		}
		if(e == entity)
		{
			entity = null;
			transform = null;
		}
	}

	public void update(float delta) 
	{	
		if(end != null)
		{
			float alfa = (1-duration/WAIT_TIME);
			current.x = init.x + (end.x - init.x) * alfa;
			current.y = init.y + (end.y - init.y) * alfa;			
			if(duration <= 0) end = null;			
			duration -= delta;
			if(duration <= 0) duration = 0;	
			
			camera.position.x = current.x;
			camera.position.y = current.y;
			camera.update();
			return;
		}		
		if(entity != null && active != null)
		{
			float x = transform.x, y = transform.y;				
			if(active.inZone(x, y))
			{
				active.update(current, x,y);
				
				camera.position.x = current.x;
				camera.position.y = current.y;
				camera.update();
			}
			else
			{
				setActiveCamera();		
			}			
		}		
	}
	
	public void follow(Entity e)
	{
		entity = e;		
		transform = e.getBehavior(TransformBehavior.class);		
		setActiveCamera();
	}

	private static final float WAIT_TIME = 0.75f; //en ms
	private float duration;
	private Vector2 current;
	private Vector2 end;
	private Vector2 init;
	private void setActiveCamera() 
	{
		if(cameras.size() > 0)
		{
			//buscar una camara que contenga la entidad.
			for(CameraBehavior c:cameras)
			{
				if(c.inZone(transform.x, transform.y))
				{
					active = c; 
					break; 
				}
			}
			end = current.cpy();
			init = new Vector2(camera.position.x, camera.position.y);
			active.setCamera(end, transform.x, transform.y);
			duration = WAIT_TIME;
		}
	}

	public CameraBehavior getActiveCamera() 
	{
		return active;
	}

	public com.badlogic.gdx.graphics.Camera getCamera() 
	{
		return camera;
	}	
}
