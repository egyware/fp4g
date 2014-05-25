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
	private TransformFamily transform_player;
	private Entity player;

	private int xo;
	private int yo;
	private int w;
	private int h;
	private int screen_width_2;
	private int screen_height_4;
	
	
	public CameraBehavior(OrthographicCamera cam) 
	{		
		camera = cam;
	}
	
	public CameraBehavior(OrthographicCamera cam, int sw, int sh, int w, int h) 
	{		
		this(cam);
		this.xo = 0;
		this.yo = 0;
		this.screen_width_2 = sw/2;
		this.screen_height_4 = sh/4;
		this.w = w;
		this.h = h;
	}
	
	public CameraBehavior(OrthographicCamera cam, int sw, int sh, int x, int y, int w, int h) 
	{		
		this(cam);
		this.xo = x;
		this.yo = y;
		this.screen_width_2 = sw/2;
		this.screen_height_4 = sh/4;
		this.w = w;
		this.h = h;
	}
	
	@Override
	public void initialize()
	{
		owner.addEventHandler(CameraMessage.onFollowCamera, this);
		owner.addEventHandler(CameraMessage.onUnfollowCamera, this);
		owner.addEventHandler(CameraMessage.onCheckAndFollowCamera, this);
	}
	
	@Override
	public void uninitialize()
	{
		owner.removeEventHandler(CameraMessage.onFollowCamera, this);
		owner.removeEventHandler(CameraMessage.onUnfollowCamera, this);
		owner.removeEventHandler(CameraMessage.onCheckAndFollowCamera, this);
	}
	
	public static CameraBehavior build(Camera cam)
	{
		return new CameraBehavior((OrthographicCamera)cam);
	}
	
	public static CameraBehavior build(Camera cam, Number screen_width, Number screen_height,Number w, Number h)
	{
		return new CameraBehavior((OrthographicCamera)cam, w.intValue(), h.intValue(),screen_width.intValue(), screen_height.intValue());		
	}
	
	public static CameraBehavior build(Camera cam,  Number screen_width, Number screen_height, Rectangle r)
	{
		return new CameraBehavior((OrthographicCamera)cam, screen_width.intValue(), screen_height.intValue(), (int)r.x, (int)r.y, (int)r.width, (int)r.height);
	}
	
	public void update(float delta)
	{			
		if(player != null && !player.isDeleted())
		{						
			int x = (int)transform_player.x;
			int y = (int)transform_player.y;
			if(x >= xo + screen_width_2  && x <= xo + w - screen_width_2 )
			{
				camera.position.x = transform_player.x;
			}
			if(y >= yo + screen_height_4 && y <= yo + h - screen_height_4)
			{
				camera.position.y = transform_player.y;
			}
			//notificamos si se salio el cochinon
			if((x <= xo || x >= xo + w)||(y <= yo || y >= yo + h))
			{
				owner.onMessage(CameraMessage.onExitFollowZoneCamera, player);
			}
		}		
	}	

	@Override
	public void onFollowCamera(Entity entity)
	{
 		player = entity;
		transform_player = player.getBehavior(TransformFamily.class);
		int x = (int)transform_player.x;
		int y = (int)transform_player.y;
		if(x > xo + screen_width_2 && x < xo + w - screen_width_2 )
		{
			camera.position.x = transform_player.x;
		}
		else if(x >= xo && x < xo + screen_width_2)
		{
			camera.position.x = xo + screen_width_2;
		}
		else
		{
			camera.position.x = xo + w - screen_width_2;
		}
		
		if(y > yo + screen_height_4 && y < yo + h - screen_height_4)
		{
			camera.position.y = transform_player.y;
		}
		else if(y >= yo && y < yo + screen_height_4)
		{
			camera.position.y = yo + screen_height_4;
		}
		else
		{
			camera.position.y = yo + h - screen_height_4;
		}	
	}

	@Override
	public void onUnfollowCamera() 
	{	
		player = null;
		transform_player = null;
	}

	@Override
	public void onExitFollowZoneCamera(Entity entity) 
	{
	}

	@Override
	public void onCheckAndFollowCamera(Entity entity) 
	{
		final TransformFamily t = entity.getBehavior(TransformFamily.class);
		final float x = t.x;
		final float y = t.y;
		//revisamos si este mono está dentro de la zona
		if((x >= xo && x <= xo + w)&&(y >= yo && y <= yo + h))
		{
			onFollowCamera(entity); //si es así lo seguimos :)
		}
	}
}
