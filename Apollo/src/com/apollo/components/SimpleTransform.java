package com.apollo.components;

public class SimpleTransform extends Transform {	
	public SimpleTransform() {
	}

	public SimpleTransform(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public SimpleTransform(SimpleTransform t) {
		this.x = t.x;
		this.y = t.y;
	}
	
	public SimpleTransform(float x, float y, float rotation) {
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

}
