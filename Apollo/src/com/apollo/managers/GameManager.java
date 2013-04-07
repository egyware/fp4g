package com.apollo.managers;

import com.apollo.messages.Message;
import com.apollo.messages.Signal;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;

// estas clases están temporalmente en este paquete hasta su reubicación
public class GameManager implements ApplicationListener, ISystem {
	private GameState next;
	private GameState current;
	private final Array<GameState> states;
	
	
	
	public GameManager()
	{
		states = new Array<GameState>();		
	}
	
	public void start(GameState next)
	{
		current = states.size > 0?states.peek():null;
		if(current != null)
		{
			current.exit();
			if(current.isLoad())
			{
				current.unloadState();
			}
			states.pop();
		}	
		current = next;
		if(!current.isLoad())
		{
			boolean result = current.load();
			if(result)
			{
				current.setLoad(true);
			}
			else
			{
				//TODO error
			}
		}
		current.enter();
		states.add(current);
	}
	
	public void nextState(GameState _next)
	{
		next = _next;
	}	
	/**
	 * Pausa el actual contexto y le da prioridad a este
	 * @param next
	 */
	public void pauseState(GameState next)
	{
		//se asume que existe un contexto actual y guardado en  states...
		if(current != null)
		{
			current.pause();
		}
		current = next;
		if(!current.isLoad())
		{
			boolean result = current.load();
			if(result)
			{
				current.setLoad(true);
			}
			else
			{
				//TODO error
			}
		}
		current.enter();
		states.add(current);	
	}
	public void resumeState()
	{
		//se asume que existe un contexto actual y guardado en  states...
		if(current != null)
		{
			current.exit();
			current.unloadState();
			states.pop(); //retiro
		}		
		current = states.size > 0?states.peek():null;
		if(current != null)
		{
			current.resume();
		}		
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {		
		if(current != null)
		{
			current.exit();
			current.unloadState();
		}
		//TODO [egyware] revisar si existen más estados cargados

	}

	@Override
	public void pause() {		
		if(current != null)
		{
			current.pause();			
		}
	}

	@Override
	public void render() {		
		if(current != null)
		{			
			current.update(Gdx.graphics.getDeltaTime());			
		}
		if(next != null)
		{
			start(next);			
		}

	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		if(current != null)
		{
			current.resume();			
		}
	}

	@Override
	public void onMessage(Message m) {		
		
	}

	@Override
	public <T extends Message> Signal signal(Class<T> clazz) {
		return Signal.nullSignal;
	}

}
