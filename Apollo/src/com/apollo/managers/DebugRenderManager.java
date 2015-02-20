package com.apollo.managers;

import static com.apollo.managers.PhysicsManager.SCALE;

import com.apollo.annotate.InjectManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.egysoft.gdx.Game;


public class DebugRenderManager extends RenderManager 
{
	@InjectManager
	private PhysicsManager physicsManager;
	private OrthographicCamera debugCamera;
	private Box2DDebugRenderer debugRender;
	private boolean debug = true;
	private World world;	
	
	
	public DebugRenderManager()
	{	
	}
	
	public DebugRenderManager(Stage stage)
	{
		super(stage);	
		
	}
		
	@Override
	public void initialize()
	{
		world = physicsManager.getb2World();
		debugCamera = new OrthographicCamera();
		debugCamera.setToOrtho(false,Game.Width*SCALE,Game.Height*SCALE);
		debugRender = new Box2DDebugRenderer(true,true,true,true,true,true);
	}
	
	public boolean isDebug()
	{
		return debug;
	}
	
	public void setDebug(boolean d)
	{
		debug = d;
	}
	
	
	public void update(float delta)
	{		
		super.update(delta);
		if(debug)
		{
			debugCamera.position.set(camera.position).scl(SCALE);
			debugCamera.update();
			debugRender.render(world,debugCamera.combined);
		}
	}	
	
		
}
