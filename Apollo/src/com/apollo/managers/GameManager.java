package com.apollo.managers;

import com.apollo.Message;
import com.apollo.messages.MessageSender;
import com.apollo.messages.MessageReceiver;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;

// estas clases están temporalmente en este paquete hasta su reubicación
public class GameManager implements ApplicationListener,MessageReceiver {
	private GameState next;
	private GameState current;
	private final Array<GameState> states;
	
	public GameManager()
	{
		states = new Array<GameState>();		
	}
	
	public void start(GameState next)
	{
		this.next = null;
		Gdx.app.log("GameCycleLife", String.format("start: %s",next.getClass().getSimpleName()));
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
				//TODO [egyware] error, de que? no se que...
			}
		}
		current.enter();
		states.add(current);
	}
	
	public void nextState(GameState _next)
	{
		Gdx.app.log("GameCycleLife", String.format("next: %s",_next.getClass().getSimpleName()));
		next = _next;
	}	
	/**
	 * Pausa el actual contexto y le da prioridad a este
	 * @param next
	 */
	public void pauseState(GameState next)
	{
		Gdx.app.log("GameCycleLife", String.format("pause: %s",next.getClass().getSimpleName()));
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
		Gdx.app.log("GameCycleLife", String.format("resume"));
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
		Gdx.app.setLogLevel(Application.LOG_INFO);
		Gdx.app.log("AppCycleLife", "create");
	}

	@Override
	public void dispose() {	
		Gdx.app.log("AppCycleLife", "dispose");	
		if(current != null)
		{
			current.exit();
			current.unloadState();
		}
		//TODO [egyware] revisar si existen más estados cargados

	}

	@Override
	public void pause() {	
		Gdx.app.log("AppCycleLife", "pause");	
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
	public void resize(int x,int y) {
		Gdx.app.log("AppCycleLife", "resize");

	}

	@Override
	public void resume() {
		Gdx.app.log("AppCycleLife", "resume");
		if(current != null)
		{
			current.resume();			
		}
	}

	@Override
	public void onMessage(Message m) {		
		
	}

	
	public <T extends Message> MessageSender signal(Class<T> clazz) {
		return MessageSender.nullSignal;
	}

}
