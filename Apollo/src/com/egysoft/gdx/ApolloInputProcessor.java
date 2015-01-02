package com.egysoft.gdx;

import com.apollo.Engine;
import com.apollo.messages.KeyMessage;
import com.apollo.messages.MouseMessage;
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
		engine.onMessage(KeyMessage.onPressKey,key);		
		return true;
	}

	@Override
	public boolean keyUp(int key) 
	{		
		engine.onMessage(KeyMessage.onReleaseKey,key);
		return true;
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
		engine.onMessage(MouseMessage.onMoveMouse,x,y);
		return true;
	}

	@Override
	public boolean scrolled(int scroll) 
	{	
		return false;
	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) 
	{
		engine.onMessage(MouseMessage.onPressButtonMouse,x, y, pointer, button);
		return true;
	}
	
	@Override
	public boolean touchUp(int x, int y, int pointer, int button) 
	{
		engine.onMessage(MouseMessage.onReleaseButtonMouse,x,y, pointer, button);
		return true;
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer) 
	{
		engine.onMessage(MouseMessage.onDraggedMouse,x,y,pointer);
		return true;
	}
}