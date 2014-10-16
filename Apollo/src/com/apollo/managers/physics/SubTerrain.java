package com.apollo.managers.physics;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.World;

public abstract class SubTerrain 
{
	public Filter filter;
	public abstract Body createBody(World world);

}
