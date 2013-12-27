/**
 * 
 */
package com.apollo.components;

import com.apollo.Behavior;
import com.apollo.Entity;
import com.apollo.World;
import com.apollo.annotate.InjectComponent;
import com.apollo.messages.GunMessage;
import com.apollo.messages.GunMessageHandler;
import com.badlogic.gdx.math.MathUtils;

/**
 * @author Edgardo
 *
 */
public final class GunBehavior extends Behavior implements GunMessageHandler
{
	private World world;
	@InjectComponent
	private ITransform transform;
	private int ammo;
	private String entity;
	
	public GunBehavior()
	{	
		this("Bullet");		
	}
	public GunBehavior(int ammo)
	{
		this("Bullet",ammo);
	}
	public GunBehavior(String entity)
	{
		this(entity,100);
	}
	public GunBehavior(String entity,int ammo)
	{
		this.entity = entity;
		this.ammo   = ammo;		
	}
	
	public static GunBehavior build()
	{	
		return new GunBehavior();		
	}
	public static GunBehavior build(int ammo)
	{
		return new GunBehavior(ammo);
	}
	public static GunBehavior build(String entity)
	{
		return new GunBehavior(entity);
	}
	public static GunBehavior build(String entity,int ammo)
	{
		return new GunBehavior(entity,ammo);		
	}
		
	@Override
	public void initialize()
	{
		owner.addEventHandler(GunMessage.onChangeBulletGun, this);
		owner.addEventHandler(GunMessage.onReloadGun, this);
		owner.addEventHandler(GunMessage.onShotGun, this);		
		
		world = owner.getWorld();		
	}
	
	@Override
	public void onReloadGun(int ammo) 
	{
		this.ammo = ammo;
	}

	@Override
	public void onShotGun(float rot, float dist, float vel) 
	{
		if(ammo > 0)
		{
			float r = transform.rotation + rot*MathUtils.degreesToRadians;			
			final float sin = MathUtils.sin(r);
			final float cos = MathUtils.cos(r);
			Entity gunEnt = world.createEntity(entity,transform.x + dist*cos,transform.y +dist*sin, vel*cos, vel*sin);
			world.addEntity(gunEnt);

			ammo -=1;
		}
	}

	@Override
	public void onChangeBulletGun(String entityName)
	{
		this.entity = entityName;
		
	}

}
