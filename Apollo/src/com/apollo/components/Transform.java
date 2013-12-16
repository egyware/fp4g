package com.apollo.components;

import com.apollo.Message;
import com.apollo.messages.MoveMessage;
import com.badlogic.gdx.math.MathUtils;

public class Transform extends ITransform {	
	public Transform() {
	}

	public Transform(float x, float y) {
		this.x = x;
		this.y = y;
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
		return "x="+x+" y="+y+" rotation"+rotation;
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
		owner.addEventHandler(MoveMessage.onTranslateMove, this);
		owner.addEventHandler(MoveMessage.onRotateMove, this);
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
		//TODO I dont understand
	}
	
	@Override
	public void onRotateMove(float grad) 
	{
		this.rotation += MathUtils.degreesToRadians * grad;
	}

	@Override
	public void onMessage(Message<?> message, Object... args)
	{
		if(message instanceof MoveMessage)
		{
			switch((MoveMessage)message)
			{
			case onSpeedMove:
				onSpeedMove(((Number)args[0]).floatValue(),((Number)args[1]).floatValue());
				break;
			case onTranslateMove:
				onTranslateMove(((Number)args[0]).floatValue(),((Number)args[1]).floatValue());
				break;
			case onRotateMove:
				onRotateMove(((Number)args[0]).floatValue());
				break;				
			}
		}
	}

}
