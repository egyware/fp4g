package org.luaj.vm2.lib.jse;

import org.luaj.vm2.LuaFunction;

import com.apollo.Message;
import com.apollo.MessageReceiver;

class MessageReceiverLuaAdapter implements MessageReceiver 
{
	public final LuaFunction function;
	public MessageReceiverLuaAdapter(LuaFunction f)
	{
		function = f;
	}
	
	@Override
	public void onMessage(Object sender, Message message)
	{
		function.call(CoerceJavaToLua.coerce(sender), CoerceJavaToLua.coerce(message));
	}
}
