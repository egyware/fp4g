package com.apollo.messages;

import com.apollo.IMessageReceiver;

public interface KeyMessageHandler extends IMessageReceiver {
	public void onPressKey(int key);
	public void onReleaseKey(int key);
}
