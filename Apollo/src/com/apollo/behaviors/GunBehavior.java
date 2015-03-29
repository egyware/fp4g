/**
 * 
 */
package com.apollo.behaviors;

import com.apollo.BaseBehavior;
import com.apollo.Engine;
import com.apollo.Entity;
import com.apollo.annotate.InjectComponent;
import com.badlogic.gdx.math.MathUtils;

/**
 * @author Edgardo
 *
 */
public final class GunBehavior extends BaseBehavior
{
	@InjectComponent
	private TransformBehavior transform;
	private Engine world;	
	private int ammo;
	private String entity;
	private boolean enableAutoGun;
	private float currentTime;
	private float delayTime;
	private float rot;
	private float dist;
	private float vel;
	
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
	public void update(float delta)
	{
		if(enableAutoGun)
		{
			if(currentTime >= delayTime)
			{
				currentTime -= delayTime;
				onShotGun(rot, dist, vel);
			}
			currentTime += delta;
		}
	}
	
	@Override
	public void initialize()
	{
		owner.addMessageHandler(GunMessageType.onChangeBulletGun, this);
		owner.addMessageHandler(GunMessageType.onReloadGun, this);
		owner.addMessageHandler(GunMessageType.onShotGun, this);	
		owner.addMessageHandler(AutoGunMessage.onSetDelayShotAutoGun,this);
		owner.addMessageHandler(AutoGunMessage.onSetShotAutoGun,this);	
		
		world = owner.getEngine();		
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
			Entity gunEnt = world.createEntity(entity,(int)(transform.x + dist*cos),(int)(transform.y +dist*sin),(int)(vel*cos), (int)(vel*sin));
			world.addEntity(gunEnt);

			ammo -=1;
		}
	}
	

	@Override
	public void onChangeBulletGun(String entityName)
	{
		this.entity = entityName;
	}
	
	@Override
	public void onSetDelayShotAutoGun(int delayTime) 
	{
		this.enableAutoGun = (delayTime != 0);
		this.delayTime = delayTime*0.001f;
		currentTime = this.delayTime;		
	}
	
	@Override
	public void onSetShotAutoGun(float rot, float dist, float vel)
	{
		this.rot = rot;
		this.dist = dist;
		this.vel = vel;		
	}

}
