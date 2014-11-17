package com.apollo.messages;

import com.apollo.Message;
import com.apollo.MessageReciever;

public enum AudioManagerMessage implements Message<AudioManagerMessageHandler> 
{
	onPlaySoundAudioManager,	
	onPlayMusicAudioManager,	
	;

	@Override
	public void dispatch(MessageReciever h, Object... args)
	{
		final AudioManagerMessageHandler handler = (AudioManagerMessageHandler)h;
		switch(this)
		{		
		case onPlaySoundAudioManager:
			if(args.length>1)
			{
				handler.onPlayAudio(args[0].toString(),args[1],args[2].toString());				
			}
			else
			{
				handler.onPlayAudio(args[0].toString(),null,null);				
			}
			break;
		case onPlayMusicAudioManager:
			if(args.length>1)
			{
				handler.onPlayMusic(args[0].toString(),args[1],args[2].toString());
			}
			else
			{
				handler.onPlayMusic(args[0].toString(),null,null);
			}
			break;
		}
		
	}

	@Override
	public Class<AudioManagerMessageHandler> getClassHandler() 
	{
		return AudioManagerMessageHandler.class;		
	}

}
