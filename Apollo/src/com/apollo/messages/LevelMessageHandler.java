package com.apollo.messages;

import com.apollo.MessageReciever;

public interface LevelMessageHandler extends MessageReciever 
{
	public void onChangeLevel(String level);
	public void onReloadLevel();
}
