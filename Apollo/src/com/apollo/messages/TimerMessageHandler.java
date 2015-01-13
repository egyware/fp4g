package com.apollo.messages;

import com.apollo.IMessageReceiver;

public interface TimerMessageHandler extends IMessageReceiver 
{
	void onActiveTimer(int index);
	void onSetTimeTimer(int index, int time);
	void onCancelTimer(int index);
}
