package com.apollo.messages;

import com.apollo.MessageHandler;

public interface LevelMessageHandler extends MessageHandler 
{
	public void onChangeLevel(String level);
	public void onReloadLevel();
}
