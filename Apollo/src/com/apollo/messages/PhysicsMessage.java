package com.apollo.messages;

import com.apollo.Message;

public enum PhysicsMessage implements Message
{
	onMovementPhysics,
	onMovePhysics,
	onStopPhysics,
	onFollowPhysics,
	onJumpPhysics,
	onGrabPhysics,
	onThrowPhysics,
	onDropPhysics,
	onShotPhysics;

	@Override
	public Class<?> getClassHandler() 
	{		
		return PhysicsMessageHandler.class;
	}
}