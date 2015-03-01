package com.egysoft.gdx.assets;

import static com.apollo.managers.PhysicsManager.SCALE;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;

public class Edge extends Collision
{
	public int x0;
	public int y0;
	public int x1;
	public int y1;
	public Edge()
	{		
	}
	@Override
	public Body createBody(World world) 
	{
		EdgeShape shape = new EdgeShape();
		BodyDef def = new BodyDef();
		def.type = BodyDef.BodyType.StaticBody;
		
		float x=(x0+x1)*0.5f;
		float y=(y0+y1)*0.5f;
		 
		//obtiene el largo
		float len2 = (float) Math.sqrt((x0-x1)*(x0-x1)+(y0-y1)*(y0-y1))*0.5f*SCALE;		
		shape.set(-len2,0,len2,0);
		
		//crea una linea centrado en en los dos puntos de (x0,y0) y (x1,y1)
		def.position.x =  x*SCALE;
		def.position.y =  y*SCALE;
		def.angle = MathUtils.atan2(y1-y0, x1-x0);
		
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