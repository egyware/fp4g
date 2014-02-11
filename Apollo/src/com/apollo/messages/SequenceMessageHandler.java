package com.apollo.messages;

import com.apollo.MessageHandler;

public interface SequenceMessageHandler extends MessageHandler 
{
	public void onChangeSequence(String sequence);
	public void onEndSequence();
}
