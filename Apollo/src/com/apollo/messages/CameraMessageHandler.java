package com.apollo.messages;

import com.apollo.Entity;
import com.apollo.MessageHandler;

public interface CameraMessageHandler extends MessageHandler
{
	public void onFollowCamera(Entity entity);
	public void onUnfollowCamera();
	public void onExitFollowZoneCamera(Entity entity);
	public void onCheckAndFollowCamera(Entity entity);
}
