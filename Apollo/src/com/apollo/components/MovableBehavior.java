package com.apollo.components;

import com.apollo.messages.MoveMessage;
import com.apollo.messages.MoveMessageHandler;
import com.badlogic.gdx.math.MathUtils;

public class MovableBehavior extends TransformBehavior implements MoveMessageHandler
{	
	private float vx;
	private float vy;
	private float w;// omega
	public MovableBehavior() {
	}

	public MovableBehavior(float x, float y) {
		super(x,y);
	}
	

	public MovableBehavior(float x, float y, float rotation) 
	{
		super(x,y,rotation);		
	}
	
	public MovableBehavior(float x, float y, float rotation, float vx, float vy) 
	{
		super(x,y,rotation);
		this.vx = vx;
		this.vy = vy;
	}
	
	
	public MovableBehavior(MovableBehavior t)
	{
		super(t);
		this.vx = t.vx;
		this.vx = t.vy;
		this.w  = t.w;
	}
	
	
	public static MovableBehavior build()
	{
		return new MovableBehavior();
	}

	public static MovableBehavior build(Number x, Number y) 
	{
		return new MovableBehavior(x.floatValue(),y.floatValue());		
	}
		
	public static MovableBehavior build(Number x, Number y, Number rot) 
	{
		return new MovableBehavior(x.floatValue(), y.floatValue(), rot.floatValue());
	}
	
	public static MovableBehavior build(MovableBehavior t)
	{
		return new MovableBehavior(t);
	}
	

	@Override
	public String toString() {
		return String.format("Movable: Transform(%f, %f, %f) speed = (%f, %f)", x,y,rotation,vx,vy);
	}	
	
	
	
	@Override
	public void initialize()
	{
		super.initialize();		
		owner.addEventHandler(MoveMessage.onAngularSpeedMove, this);
		owner.addEventHandler(MoveMessage.onForwardMove, this);		
		owner.addEventHandler(MoveMessage.onSpeedMove, this);
	}
	
	@Override
	public void uninitialize()
	{
		super.uninitialize();
		owner.removeEventHandler(MoveMessage.onAngularSpeedMove, this);
		owner.removeEventHandler(MoveMessage.onForwardMove, this);		
		owner.removeEventHandler(MoveMessage.onSpeedMove, this);
	}

	@Override
	public void update(float delta)
	{
		x = x + vx*delta;
		y = y + vy*delta;
		
		rotation = rotation + w * delta;
		
	}

	@Override
	public void onAngularSpeedMove(float w) 
	{
		this.w = w;		
	}

	@Override
	public void onSpeedMove(float x, float y) 
	{
		this.vx = x;
		this.vy = y;
	}

	@Override
	public void onForwardMove(float units) 
	{
		this.vx = units * MathUtils.cosDeg(rotation+90);
		this.vy = units * MathUtils.sinDeg(rotation+90);				
	}
	
}