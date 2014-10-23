package com.apollo.messages;

import com.apollo.Message;
import com.apollo.MessageHandler;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public enum NetworkMessage implements Message<NetworkMessageHandler> 
{
	onSerializeNetwork, 
	onDeserializeNetwork 
	;

	@Override
	public void dispatch(MessageHandler h, Object... arg) 
	{
		NetworkMessageHandler handler = (NetworkMessageHandler)h;
		switch(this)
		{
		case onSerializeNetwork:
			handler.onSerializeNetwork((Kryo)arg[0], (Output)arg[1]); //TODO que y ahora que? se lo pasaré todo en un una cosa que supuestamente es el dato que necesito?
			break;
		case onDeserializeNetwork:
			handler.onDeserializeNetwork((Kryo)arg[0], (Input)arg[1]);
			break;				
		}
		
	}

	@Override
	public Class<NetworkMessageHandler> getClassHandler() 
	{
		return NetworkMessageHandler.class;
	}
}
