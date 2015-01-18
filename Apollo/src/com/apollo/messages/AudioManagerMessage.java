package com.apollo.messages;

import com.apollo.IMessage;
import com.apollo.IMessageReceiver;

public enum AudioManagerMessage implements IMessage<AudioManagerMessageHandler> 
{
	onPlaySoundAudioManager,	
	onPlayMusicAudioManager,	
	;

	@Override
	public void dispatch(IMessageReceiver h, Object... args)
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
}
