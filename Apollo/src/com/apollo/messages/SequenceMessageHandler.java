package com.apollo.messages;

import com.apollo.IMessageReceiver;

public interface SequenceMessageHandler extends IMessageReceiver 
{
	public void onChangeSequence(String sequence);
	public void onEndSequence();
}
