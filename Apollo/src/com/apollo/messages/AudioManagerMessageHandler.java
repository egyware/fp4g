package com.apollo.messages;

import com.apollo.MessageHandler;

public interface AudioManagerMessageHandler extends MessageHandler 
{
	void onPlayAudio(String audio, Object args, String var);
	void onPlayMusic(String music, Object args, String var);
	
}
