package com.apollo.behaviors;

import com.apollo.BaseBehavior;
import com.apollo.Behavior;
import com.apollo.BehaviorTemplate;
import com.apollo.utils.TrigLUT;
import com.apollo.utils.Utils;
import com.badlogic.gdx.math.Vector2;

public class TransformBehavior extends BaseBehavior 
{	
	//estos campos deben ser actualizados por los hijos para asegurar maxima compatibilidad
	public float x;
	public float y;
	public float rotation;
	
	public static class Template  implements BehaviorTemplate
	{
		public float x;
		public float y;
		public float rotation;
		@Override
		public Behavior createBehavior() 
		{
			return new TransformBehavior(x,y,rotation);
		}
		
	}
	
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
	
	
	public Class<TransformBehavior> getType(){
		return TransformBehavior.class;
	}
	

	@Override
	public String toString() {
		return String.format("Transform: x=%f y=%f rotation=%f", x,y,rotation);
	}	
	
	public void setRotation(float rotation)
	{
		this.rotation = rotation;
	}
	
	public void setPosition(float x, float y) 
	{
		this.x = x;
		this.y = y;		
	}
	public void setPosition(Vector2 p) 
	{
		this.x = p.x;
		this.y = p.y;		
	}
	public void setTrasnform(TransformBehavior t) 
	{
		this.x = t.x;
		this.y = t.y;
		this.rotation = t.rotation;
	}
	
	public void translate(float distance, float heading) {		
		x += (float) (TrigLUT.cos(heading) * distance);
		y += (float) (TrigLUT.sin(heading) * distance);		
	}

	public void translate(float distance) {
		x += (float) (TrigLUT.cos(rotation) * distance);
		y += (float) (TrigLUT.sin(rotation) * distance);		
	}

	public void rotate(float angle) {
		rotation = (rotation + angle) % 360;
		setRotation(rotation);
	}
	
	public float getRotationAsRadians() {
		return (float)Math.toRadians(rotation);
	}

	public float getDistanceTo(TransformBehavior t) {
		return Utils.distance(t.x, t.y, x, y);
	}

	public float getDistanceTo(float x, float y) {
		return Utils.distance(x, y, this.x, this.y);
	}

	public float angleInRadians(TransformBehavior t) {
		return Utils.angleInRadians(x, y, t.x, t.y);
	}

	public float angleInRadians(float x, float y) {
		return Utils.angleInRadians(this.x, this.y, x, y);
	}

	
}