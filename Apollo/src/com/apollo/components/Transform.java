package com.apollo.components;

import com.apollo.messages.MoveMessage;
import com.apollo.utils.TrigLUT;
import com.badlogic.gdx.math.MathUtils;

public class Transform extends ITransform 
{	
	private float vx;
	private float vy;
	private float w;
	public Transform() {
	}

	public Transform(float x, float y) {
		this.x = x;
		this.y = y;
	}
	public Transform(float x, float y,float vx, float vy) {
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
	}
	
	public Transform(Transform t) {
		this.x = t.x;
		this.y = t.y;
		this.rotation = t.rotation;
	}
	
	public Transform(float x, float y, float rotation) {
		this.x = x;
		this.y = y;
		this.rotation = rotation;
	}

	@Override
	public String toString() {
		return String.format("Transform: x=%f y=%f rotation=%f", x,y,rotation);
	}
	
	
	public void setRotation(float rotation)
	{
		this.rotation = rotation;
	}
	
	public void update(float t)
	{
		x += (vx*t);
		y += (vy*t);
		rotation +=(w*t);		
	}


	@Override
	public void setPosition(float x, float y) {
		this.x = x;
		this.y = y;
		
	}
	
	@Override
	public void initialize()
	{
		owner.addEventHandler(MoveMessage.onTranslateMove, this);
		owner.addEventHandler(MoveMessage.onSpeedMove, this);
		owner.addEventHandler(MoveMessage.onRotateMove, this);
		owner.addEventHandler(MoveMessage.onForwardMove, this);
		owner.addEventHandler(MoveMessage.onAngularSpeedMove, this);
	}

	@Override
	public void onTranslateMove(float x, float y) 
	{
		this.x += x;
		this.y += y;	
	}

	@Override
	public void onSpeedMove(float x, float y) 
	{			
		this.vx = x;
		this.vy = y;
	}
	
	@Override
	public void onRotateMove(float grad) 
	{
		this.rotation += MathUtils.degreesToRadians * grad;
	}
	
	@Override
	public void onForwardMove(float units)
	{
		vx = (float) (TrigLUT.cos(rotation+MathUtils.PI * 0.5f) * units);
		vy = (float) (TrigLUT.sin(rotation+MathUtils.PI * 0.5f) * units);		
	}

	@Override
	public void onAngularSpeedMove(float w) {
		this.w = MathUtils.degreesToRadians * w;
		
	}	
}