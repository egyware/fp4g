package com.egysoft.gdx.assets;

import static com.apollo.managers.PhysicsManager.SCALE;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Box extends SubTerrain
{
	public int x;
	public int y;
	public int w;
	public int h;
	public Box()
	{		
	}
	@Override
	public Body createBody(World world) 
	{
		PolygonShape shape = new PolygonShape();
		BodyDef def = new BodyDef();
		def.type = BodyDef.BodyType.StaticBody;
		
		shape.setAsBox(w*0.5f*SCALE, h*0.5f*SCALE);
		def.position.x =  (x + w*0.5f)*SCALE;
		def.position.y =  (y + h*0.5f)*SCALE;
		Body body = world.createBody(def);
		Fixture fixture = body.createFixture(shape,1);
		if(filter != null)
		{
			fixture.setFilterData(filter);			
		}		
		shape.dispose();		
		
		return body;

	}
}