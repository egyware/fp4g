package com.apollo.components;

import com.apollo.BaseBehavior;
import com.apollo.messages.MoveMessageHandler;
import com.apollo.utils.TrigLUT;
import com.apollo.utils.Utils;

public abstract class TransformFamily extends BaseBehavior
implements MoveMessageHandler
{
	//estos campos deben ser actualizados por los hijos para asegurar maxima compatibilidad
	protected float x;
	protected float y;
	protected float rotation;
	
	//interfaz publica util para la herencia de las transformaciones como box2d
	public abstract void setPosition(float x, float y);
	
	public void addX(float dx){
		x += dx;
		setPosition(x,y);
	}
	public void addY(float dy){
		y += dy;
		setPosition(x,y);
	}
	public float getX()
	{
		return x;
	}
	public void setX(float x){
		setPosition(x,y);
	}
	public float getY(){
		return y;
	}
	public void setY(float y)
	{
		setPosition(x,y);
	}	

	public void move(float distance, float heading) {		
		x += (float) (TrigLUT.cos(heading) * distance);
		y += (float) (TrigLUT.sin(heading) * distance);
		setPosition(x,y);
	}

	public void move(float distance) {
		x += (float) (TrigLUT.cos(rotation) * distance);
		y += (float) (TrigLUT.sin(rotation) * distance);
		setPosition(x,y);
	}

	public void addRotation(float angle) {
		rotation = (rotation + angle) % 360;
		setRotation(rotation);
	}

	public abstract void setRotation(float rotation);
	
	public float getRotation()
	{
		return rotation;
	}

	public void set(TransformFamily t) {
		setPosition(t.x,t.y);
		setRotation(t.rotation);
	}

	public float getRotationAsRadians() {
		return (float)Math.toRadians(rotation);
	}

	public float getDistanceTo(TransformBehavior t) {
		return Utils.distance(t.getX(), t.getY(), x, y);
	}

	public float getDistanceTo(float x, float y) {
		return Utils.distance(x, y, this.x, this.y);
	}

	public float angleInRadians(TransformFamily t) {
		return Utils.angleInRadians(x, y, t.x, t.y);
	}

	public float angleInRadians(float x, float y) {
		return Utils.angleInRadians(this.x, this.y, x, y);
	}
	
	public Class<TransformFamily> getType(){
		return TransformFamily.class;
	}

}