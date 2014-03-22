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

	private int xo;
	private int yo;
	private int w;
	private int h;
	private int screen_width;
	private int screen_height;
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
		this.screen_width = sw;
		this.screen_height = sh;
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
		this.screen_width = sw;		
		this.screen_height = sh;
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
	
	public static CameraBehavior build(Camera cam, Number screen_width, Number screen_height,Number w, Number h)
	{
		return new CameraBehavior((OrthographicCamera)cam, w.intValue(), h.intValue(),screen_width.intValue()/2, screen_height.intValue()/4);
		
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
				camera.position.x = transform_player.x+screen_width;
			}
			if(y >= yo + screen_height_4 && y <= yo + h - screen_height_4)
			{
				camera.position.y = transform_player.y + screen_height_4;
			}
		}		
	}

	

	@Override
	public void onFollow(Entity entity)
	{
 		player = entity;
		transform_player = player.getBehavior(TransformFamily.class);
		int x = (int)transform_player.x;
		int y = (int)transform_player.y;
		if((x >= xo  && x <= xo + w) && (y >= yo && y <= yo + h))
		{
			camera.position.x = xo+screen_width;
			camera.position.y = yo+screen_height;
		}		
	}

	@Override
	public void onUnfollow() 
	{	
		player = null;
		transform_player = null;
	}
}
