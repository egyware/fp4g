package com.apollo;

import com.apollo.utils.ImmutableBag;
import com.esotericsoftware.reflectasm.MethodAccess;

public class MessageSender 
{
	private static MessageSender messageSender = new MessageSender();
	private MessageSender()	{ }
	private Object array1[] = new Object[1];
	private Object array2[] = new Object[2];
	private Object array3[] = new Object[3];
	private Object array4[] = new Object[4];
	private Object array5[] = new Object[5];	
	//con esto evito los news de los varargs
	public void send(MessageReceiver receiver,Message message)
	{	
		ImmutableBag<MessageHandler> listeners = receiver.getMessageHandler(message);
		if(listeners == null) return;
		final int size = listeners.size();
		for(int i=0;i<size;i++)
		{
			MessageHandler handler = listeners.get(i);
			MethodAccess methods = MethodAccess.get(handler.getClass());			
			methods.invoke(handler, message.name());			
		}
	}
	public void send(MessageReceiver receiver,Message message,Object arg1)
	{		
		array1[0] = arg1;
		ImmutableBag<MessageHandler> listeners = receiver.getMessageHandler(message);
		if(listeners == null) return;
		final int size = listeners.size();
		for(int i=0;i<size;i++)
		{
			MessageHandler handler = listeners.get(i);
			MethodAccess methods = MethodAccess.get(handler.getClass());
			methods.invoke(handler, message.name(),array1);			
		}
	}
	public void send(MessageReceiver receiver,Message message,Object arg1,Object arg2)
	{		
		array2[0] = arg1;
		array2[1] = arg2;
		ImmutableBag<MessageHandler> listeners = receiver.getMessageHandler(message);
		if(listeners == null) return;
		final int size = listeners.size();
		for(int i=0;i<size;i++)
		{
			MessageHandler handler = listeners.get(i);
			MethodAccess methods = MethodAccess.get(handler.getClass());
			methods.invoke(handler, message.name(),array2);			
		}
	}
	public void send(MessageReceiver receiver,Message message,Object arg1,Object arg2,Object arg3)
	{	
		array3[0] = arg1;
		array3[1] = arg2;
		array3[2] = arg3;
		ImmutableBag<MessageHandler> listeners = receiver.getMessageHandler(message);
		if(listeners == null) return;
		final int size = listeners.size();
		for(int i=0;i<size;i++)
		{
			MessageHandler handler = listeners.get(i);
			MethodAccess methods = MethodAccess.get(handler.getClass());
			methods.invoke(handler, message.name(),array3);			
		}
	}
	public void send(MessageReceiver receiver,Message message,Object arg1,Object arg2,Object arg3,Object arg4)
	{		
		array4[0] = arg1;
		array4[1] = arg2;
		array4[2] = arg3;
		array4[3] = arg4;		
		ImmutableBag<MessageHandler> listeners = receiver.getMessageHandler(message);
		if(listeners == null) return;
		final int size = listeners.size();
		for(int i=0;i<size;i++)
		{
			MessageHandler handler = listeners.get(i);
			MethodAccess methods = MethodAccess.get(handler.getClass());
			methods.invoke(handler, message.name(),array4);			
		}
	}
	public void send(MessageReceiver receiver,Message message,Object arg1,Object arg2,Object arg3,Object arg4,Object arg5)
	{		
		array5[0] = arg1;
		array5[1] = arg2;
		array5[2] = arg3;
		array5[3] = arg4;
		array5[4] = arg5;
		ImmutableBag<MessageHandler> listeners = receiver.getMessageHandler(message);
		if(listeners == null) return;
		final int size = listeners.size();
		for(int i=0;i<size;i++)
		{
			MessageHandler handler = listeners.get(i);
			MethodAccess methods = MethodAccess.get(handler.getClass());
			methods.invoke(handler, message.name(),array5);			
		}
	}
	
	public static MessageSender instance()
	{
		return messageSender;
	}	
	
}