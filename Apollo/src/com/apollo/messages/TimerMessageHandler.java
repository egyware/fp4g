package com.apollo.messages;

import com.apollo.MessageReciever;

public interface TimerMessageHandler extends MessageReciever 
{
	void onActiveTimer(int index);
	void onSetTimeTimer(int index, int time);
	void onCancelTimer(int index);
}
