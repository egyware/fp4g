package com.egysoft.gdx;

import java.util.HashMap;
import java.util.Map;

import com.apollo.Message;
import com.apollo.MessageReciever;
import com.apollo.MessageSender;
import com.apollo.messages.KeyMessage;
import com.apollo.messages.MouseMessage;
import com.apollo.utils.Bag;
import com.apollo.utils.ImmutableBag;
import com.badlogic.gdx.InputProcessor;

/*
 *  TODO Aún faltan mensajes por hacer... 
 */
public class ApolloInputProcessor implements InputProcessor, MessageSender
{	
	private final Map<Message<?>,Bag<MessageReciever>> handlersByEventType;	
	public ApolloInputProcessor()
	{
		handlersByEventType = new HashMap<Message<?>, Bag<MessageReciever>>();		
	}
	
	public <T extends Message<?>> void addEventHandler(Message<?> messageType, MessageReciever listener) 
	{	
		Bag<MessageReciever> listeners = handlersByEventType.get(messageType);
		if(listeners == null) 
		{
			listeners = new Bag<MessageReciever>();
			handlersByEventType.put(messageType,listeners);
		}
		listeners.add(listener);
	}
	
	public <T extends Message<?>> void removeEventHandler(Message<?> messageType, MessageReciever listener) 
	{		
		Bag<MessageReciever> listeners = handlersByEventType.get(messageType);
		if(listeners != null) {
			listeners.remove(listener);
		}		
	}
	
	@Override
	public boolean keyDown(int key) 
	{		
		this.onMessage(KeyMessage.onPressKey,key);		
		return false;
	}

	@Override
	public boolean keyUp(int key) 
	{		
		this.onMessage(KeyMessage.onReleaseKey,key);
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
		this.onMessage(MouseMessage.onMoveMouse,x,y);
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
		this.onMessage(MouseMessage.onPressButtonMouse,x, y, pointer, button);
		return false;
	}
	
	@Override
	public boolean touchUp(int x, int y, int pointer, int button) 
	{
		this.onMessage(MouseMessage.onReleaseButtonMouse,x,y, pointer, button);
		return false;
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer) 
	{
		this.onMessage(MouseMessage.onDraggedMouse,x,y,pointer);
		return false;
	}

	//Esta cosa puede/debe recibir mensajes? O.o?
	//claro que si, o sino como enruto los mensajes?
	@Override
	public void onMessage(Message<? extends MessageReciever> message, Object... args) 
	{
		ImmutableBag<MessageReciever> listeners = handlersByEventType.get(message);		
		if(listeners == null) return;		
		final int size = listeners.size();		
		for(int i=0; i<size; i++)
		{			
			MessageReciever handler = listeners.get(i);
			handler.onMessage(message, args);					
		}				
	}	
}
