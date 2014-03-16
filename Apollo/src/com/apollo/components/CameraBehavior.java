package com.apollo.components;

import com.apollo.Entity;
import com.apollo.BaseBehavior;
import com.apollo.messages.CameraMessage;
import com.apollo.messages.CameraMessageHandler;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;

public class CameraBehavior extends BaseBehavior implements CameraMessageHandler
{
	private final OrthographicCamera camera;
	private Entity player;
	private TransformFamily transform_player;

	private int x;
	private int y;
	private int w;
	private int h;
	
	public CameraBehavior(OrthographicCamera cam) 
	{		
		camera = cam;
	}
	
	public CameraBehavior(OrthographicCamera cam, int x, int y, int w, int h) 
	{		
		this(cam);
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	@Override
	public void initialize()
	{
		owner.addEventHandler(CameraMessage.onFollow, this);
		owner.addEventHandler(CameraMessage.onUnfollow, this);
		
	}
	
	@Override
	public void uninitialize()
	{
		owner.getWorld().getEntityManager();
	}
	
	public static CameraBehavior build(Camera cam)
	{
		return new CameraBehavior((OrthographicCamera)cam);
	}
	
	public static CameraBehavior build(Camera cam, Number x, Number y, Number w, Number h)
	{
		return new CameraBehavior((OrthographicCamera)cam, x.intValue(),y.intValue(), w.intValue(), h.intValue());
	}
	
	public static CameraBehavior build(Camera cam, Rectangle r)
	{
		return new CameraBehavior((OrthographicCamera)cam, (int)r.x, (int)r.y, (int)r.width, (int)r.height);
	}
	
	public void update(float delta)
	{			
		if(player != null && !player.isDeleted())
		{						
			camera.position.x = transform_player.x;
			camera.position.y = transform_player.y;
		}		
	}

	

	@Override
	public void onFollow(Entity entity)
	{
		player = entity;
		transform_player = player.getBehavior(TransformFamily.class);				
	}

	@Override
	public void onUnfollow() 
	{	
		player = null;
		transform_player = null;
	}
}
