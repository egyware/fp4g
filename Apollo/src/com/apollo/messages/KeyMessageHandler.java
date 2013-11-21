package com.apollo.messages;

import com.apollo.MessageHandler;

public interface KeyMessageHandler extends MessageHandler {
	public void onPressKey();
	public void onReleaseKey();
}
