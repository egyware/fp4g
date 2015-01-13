package com.apollo.behaviors;


public class MovableBehavior extends TransformBehavior
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
	
	@Override
	public String toString() {
		return String.format("Movable: Transform(%f, %f, %f) speed = (%f, %f)", x,y,rotation,vx,vy);
	}	
	
	@Override
	public void update(float delta)
	{
		x = x + vx*delta;
		y = y + vy*delta;
		
		rotation = rotation + w * delta;
		
	}	
}