package com.apollo.messages;

import com.apollo.MessageHandler;

public interface TimerMessageHandler extends MessageHandler 
{
	void onActiveTimer(int index);
	void onSetTimeTimer(int index, int time);
	void onCancelTimer(int index);
}
