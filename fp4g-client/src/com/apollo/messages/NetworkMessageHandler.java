package com.apollo.messages;

import com.apollo.MessageHandler;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public interface NetworkMessageHandler extends MessageHandler 
{

	void onSerializeNetwork(Kryo kryo, Output out);

	void onDeserializeNetwork(Kryo kryo, Input out);

}
