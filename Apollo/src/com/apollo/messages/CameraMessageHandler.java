package com.apollo.messages;

import com.apollo.Entity;
import com.apollo.MessageHandler;

public interface CameraMessageHandler extends MessageHandler
{
	public void onFollow(Entity entity);
	public void onUnfollow();
}
