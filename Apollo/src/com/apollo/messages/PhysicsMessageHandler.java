package com.apollo.messages;

import com.apollo.Entity;
import com.apollo.MessageHandler;

public interface PhysicsMessageHandler extends MessageHandler
{
	public void onMovementPhysics(float x,float y);
	public void onMovePhysics(float x, float y);
	public void onStopPhysics();
	public void onFollowPhysics(Entity entity);
	public void onJumpPhysics(float y);
	public void onGrabPhysics(Entity y);
	public void onThrowPhysics(float x, float y);
	public void onDropPhysics();
	public void onShotPhysics(Entity entity, float x, float y, float vx, float vy);
}
