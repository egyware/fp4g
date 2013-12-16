package com.apollo;

import java.util.HashMap;
import java.util.Map;

import com.apollo.messages.KeyMessage;
import com.apollo.utils.Bag;
import com.apollo.utils.ImmutableBag;
import com.badlogic.gdx.InputProcessor;

// TODO Aún faltan mensajes por hacer...
/* TODO 
 * acá hay un problema, actuamente solo es un MessageReceiver común (como si fuese una entidad).
 * Y no un multiplexer de MessageReceiver.
 */
public class ApolloInputProcessor implements InputProcessor,MessageReceiver
{	
	private final Map<Message<?>,Bag<MessageHandler>> handlersByEventType;	
	public ApolloInputProcessor()
	{
		handlersByEventType = new HashMap<Message<?>, Bag<MessageHandler>>();		
	}
	
	public <T extends Message<?>> void addEventHandler(Message<?> messageType, MessageHandler listener) 
	{		
		Bag<MessageHandler> listeners = handlersByEventType.get(messageType);
		if(listeners == null) {
			listeners = new Bag<MessageHandler>();
			handlersByEventType.put(messageType,listeners);
		}
		listeners.add(listener);
	}
	
	public <T extends Message<?>> void addEventHandler(Message<?> messageType, MessageReceiver receiver) 
	{		
		Bag<MessageHandler> listeners = handlersByEventType.get(messageType);
		if(listeners == null) {
			listeners = new Bag<MessageHandler>();
			handlersByEventType.put(messageType,listeners);
		}		
		ImmutableBag<MessageHandler> handlers = receiver.getMessageHandler(messageType);
		if(handlers != null)
		{
			listeners.addAll(handlers);
		}				
	}
	
	public <T extends Message<?>> void removeEventHandler(Message<?> messageType, MessageHandler listener) 
	{		
		Bag<MessageHandler> listeners = handlersByEventType.get(messageType);
		if(listeners == null) {
			listeners = new Bag<MessageHandler>();
			handlersByEventType.put(messageType,listeners);
		}
		listeners.remove(listener);
	}
	
	public <T extends Message<?>> void removeEventHandler(Message<?> messageType, MessageReceiver receiver) 
	{		
		Bag<MessageHandler> listeners = handlersByEventType.get(messageType);
		if(listeners == null) {
			listeners = new Bag<MessageHandler>();
			handlersByEventType.put(messageType,listeners);
		}		
		ImmutableBag<MessageHandler> handlers = receiver.getMessageHandler(messageType);
		if(handlers != null)
		{
			listeners.removeAll(handlers);
		}				
	}
	
	@Override
	public ImmutableBag<MessageHandler> getMessageHandler(Message<?> message) 
	{		
		ImmutableBag<MessageHandler> bag = handlersByEventType.get(message);
		return bag;
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
		// TODO No hay mensaje aÃºn para este tipo
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

	//Esta cosa puede/debe recibir mensajes? O.o?
	//claro que si, o sino como enruto los mensajes?
	@Override
	public void onMessage(Message<? extends MessageHandler> message, Object... args) 
	{
		ImmutableBag<MessageHandler> listeners = getMessageHandler(message);
		if(listeners == null) return;
		final int size = listeners.size();
		for(int i=0; i<size; i++)
		{
			MessageHandler handler = listeners.get(i);
			message.dispatch(handler,args);			
		}				
	}	
}
