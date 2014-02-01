package com.apollo;


public abstract class GameState {
	private boolean is_load = false;
	
	protected abstract boolean load();
	protected abstract void unload();
	protected abstract void enter();
	protected abstract void exit();
	protected abstract void pause();
	protected abstract void resume();
	public abstract void update(float delta);
	
	
	public final boolean loadState(){
		if(!is_load){
			is_load = load();
		}
		return is_load;
	}
	public final void unloadState(){
		is_load = false;
		unload();		
	}
	public final boolean isLoad(){
		return is_load;
	}
	
	void setLoad(boolean b)
	{
		is_load = b;
	}
	
	
}
