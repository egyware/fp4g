package com.apollo.components;

import com.apollo.Message;
import com.apollo.messages.MoveMessage;

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
	
	
	public void setRotation(float rotation) {
		this.rotation = rotation;
	}


	@Override
	public void setPosition(float x, float y) {
		this.x = x;
		this.y = y;
		
	}

	@Override
	public void onTranslateMove(float x, float y) {
		this.x += x;
		this.y += y;
	}

	@Override
	public void onSpeedMove(float x, float y) 
	{			
		//TODO I dont understand
	}

	@Override
	public void onMessage(Message message, Object... args)
	{
		if(message instanceof MoveMessage)
		{
			switch((MoveMessage)message)
			{
			case onSpeedMove:
				onSpeedMove((Float)args[0],(Float)args[1]);
				break;
			case onTranslateMove:
				onTranslateMove((Float)args[0],(Float)args[1]);
				break;			
			}
		}
	}

}
