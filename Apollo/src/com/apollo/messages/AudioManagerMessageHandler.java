package com.apollo.messages;

import com.apollo.MessageReciever;

public interface AudioManagerMessageHandler extends MessageReciever 
{
	void onPlayAudio(String audio, Object args, String var);
	void onPlayMusic(String music, Object args, String var);
	
}
