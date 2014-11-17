package com.apollo.messages;

import com.apollo.MessageReciever;

public interface KeyMessageHandler extends MessageReciever {
	public void onPressKey(int key);
	public void onReleaseKey(int key);
}
