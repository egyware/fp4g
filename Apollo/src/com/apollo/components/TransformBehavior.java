package com.apollo.components;

import com.apollo.messages.TransformMessage;
import com.badlogic.gdx.math.MathUtils;

public class TransformBehavior extends TransformFamily 
{	
	public TransformBehavior() {
	}

	public TransformBehavior(float x, float y) {
		this.x = x;
		this.y = y;
	}
	

	public TransformBehavior(float x, float y, float rotation) 
	{
		this.x = x;
		this.y = y;
		this.rotation = rotation;
	}
	
	public TransformBehavior(TransformBehavior t)
	{
		this.x = t.x;
		this.y = t.y;
		this.rotation = t.rotation;
	}
	
	
	public static TransformBehavior build()
	{
		return new TransformBehavior();
	}

	public static TransformBehavior build(Number x, Number y) 
	{
		return new TransformBehavior(x.floatValue(),y.floatValue());		
	}
		
	public static TransformBehavior build(Number x, Number y, Number rot) 
	{
		return new TransformBehavior(x.floatValue(), y.floatValue(), rot.floatValue());
	}
	
	public static TransformBehavior build(TransformBehavior t)
	{
		return new TransformBehavior(t);
	}
	

	@Override
	public String toString() {
		return String.format("Transform: x=%f y=%f rotation=%f", x,y,rotation);
	}	
	
	public void setRotation(float rotation)
	{
		this.rotation = rotation;
	}
	
	@Override
	public void setPosition(float x, float y) {
		this.x = x;
		this.y = y;
		
	}
	
	@Override
	public void initialize()
	{
		owner.addEventHandler(TransformMessage.onTranslateTransform, this);
		owner.addEventHandler(TransformMessage.onRotateTransform, this);		
	}
	
	@Override
	public void uninitialize()
	{
		owner.removeEventHandler(TransformMessage.onTranslateTransform, this);
		owner.removeEventHandler(TransformMessage.onRotateTransform, this);		
	}

	@Override
	public void onTranslateTransform(float x, float y) 
	{
		this.x += x;
		this.y += y;	
	}
	
	@Override
	public void onRotateTransform(float grad) 
	{
		this.rotation += MathUtils.degreesToRadians * grad;
	}
}