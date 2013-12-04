package com.apollo;

import java.util.HashMap;
import java.util.Map;

import com.apollo.messages.KeyMessage;
import com.apollo.utils.Bag;
import com.apollo.utils.ImmutableBag;
import com.badlogic.gdx.InputProcessor;

// TODO Aún faltan mensajes por hacer...
public class ApolloInputProcesor implements InputProcessor,MessageReceiver
{
	private final MessageSender instance;
	private final Map<Message,Bag<MessageHandler>> handlersByEventType;
	private final ImmutableBag<MessageHandler> emptyBag;
	public ApolloInputProcesor()
	{
		handlersByEventType = new HashMap<>();
		instance = MessageSender.instance();
		emptyBag = new ImmutableBag<MessageHandler>()
		{
			@Override public MessageHandler get(int index){return null;}
			@Override public int size() {return 0;}
			@Override public boolean isEmpty() {return true;}
		};
	}
	
	public <T extends Message> void addEventHandler(Message messageType, MessageHandler listener) 
	{		
		Bag<MessageHandler> listeners = handlersByEventType.get(messageType);
		if(listeners == null) {
			listeners = new Bag<MessageHandler>();
			handlersByEventType.put(messageType,listeners);
		}
		listeners.add(listener);
	}
	
	@Override
	public ImmutableBag<MessageHandler> getMessageHandler(Message message) 
	{		
		ImmutableBag<MessageHandler> bag = handlersByEventType.get(message);
		if(bag == null)
		{
			return emptyBag;
		}
		else
		{
			return bag;
		}
	}
	
	@Override
	public boolean keyDown(int key) 
	{		
		instance.send(this, KeyMessage.onPressKey,key);		
		return false;
	}

	@Override
	public boolean keyUp(int key) 
	{
		instance.send(this, KeyMessage.onReleaseKey,key);
		return false;
	}
	
	@Override
	public boolean keyTyped(char key) 
	{
		// TODO No hay mensaje aún para este tipo
		return false;
	}

	@Override
	public boolean mouseMoved(int x, int y) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int scroll) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) 
	{
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean touchUp(int x, int y, int pointer, int button) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer) 
	{
		// TODO Auto-generated method stub
		return false;
	}	
}
