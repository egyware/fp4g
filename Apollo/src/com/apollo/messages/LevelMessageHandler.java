package com.apollo.messages;

import com.apollo.IMessageReceiver;

public interface LevelMessageHandler extends IMessageReceiver 
{
	public void onChangeLevel(String level);
	public void onReloadLevel();
}
