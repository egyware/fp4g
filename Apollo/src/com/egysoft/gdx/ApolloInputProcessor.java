package com.egysoft.gdx;

import com.apollo.Engine;
import com.apollo.messages.KeyUpMessage;
import com.apollo.messages.MouseMoveMessage;
import com.apollo.messages.TouchDownMessage;
import com.apollo.messages.TouchDraggedMessage;
import com.apollo.messages.TouchUpMessage;
import com.badlogic.gdx.InputProcessor;

public class ApolloInputProcessor implements InputProcessor
{		
	private final Engine engine;
	public ApolloInputProcessor(Engine engine)
	{
		this.engine = engine;
	}
	
	@Override
	public boolean keyDown(int key) 
	{		
		//TODO pooled message
		KeyUpMessage message = new KeyUpMessage();
		message.key = key;
		engine.onMessage(engine, message);		
		return message.isConsumed();
	}

	@Override
	public boolean keyUp(int key) 
	{		
		//TODO pooled message
		KeyUpMessage message = new KeyUpMessage();
		message.key = key;
		engine.onMessage(engine, message);
		return message.isConsumed();
	}
	
	@Override
	public boolean keyTyped(char key) 
	{
		// TODO No hay mensaje a?n para este tipo
		return false;
	}

	@Override
	public boolean mouseMoved(int x, int y) 
	{
		//TODO pooled message
		MouseMoveMessage message = new MouseMoveMessage();
		message.x = x;
		message.y = y;
		engine.onMessage(engine, message);
		return message.isConsumed();
	}

	@Override
	public boolean scrolled(int scroll) 
	{	
		return false;
	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) 
	{
		//TODO pooled message
		TouchDownMessage message = new TouchDownMessage();
		message.x = x;
		message.y = y;
		message.pointer = pointer;
		message.button = button;
		engine.onMessage(engine, message);
		return message.isConsumed();
	}
	
	@Override
	public boolean touchUp(int x, int y, int pointer, int button) 
	{
		//TODO pooled message
		TouchUpMessage message = new TouchUpMessage();
		message.x = x;
		message.y = y;
		message.pointer = pointer;
		message.button = button;
		engine.onMessage(engine, message);
		return message.isConsumed();
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer) 
	{
		TouchDraggedMessage message = new TouchDraggedMessage();
		message.x = x;
		message.y = y;
		message.pointer = pointer;
		engine.onMessage(engine, message);
		return message.isConsumed();
	}
}