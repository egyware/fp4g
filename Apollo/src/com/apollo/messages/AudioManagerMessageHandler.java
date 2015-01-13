package com.apollo.messages;

import com.apollo.IMessageReceiver;

public interface AudioManagerMessageHandler extends IMessageReceiver 
{
	void onPlayAudio(String audio, Object args, String var);
	void onPlayMusic(String music, Object args, String var);
	
}
