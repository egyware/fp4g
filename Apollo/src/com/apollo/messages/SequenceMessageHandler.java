package com.apollo.messages;

import com.apollo.MessageReciever;

public interface SequenceMessageHandler extends MessageReciever 
{
	public void onChangeSequence(String sequence);
	public void onEndSequence();
}
