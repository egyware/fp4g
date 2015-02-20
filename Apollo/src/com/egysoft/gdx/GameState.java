package com.egysoft.gdx;




public abstract class GameState
{
	private boolean is_load = false;	
	
	protected abstract boolean load();
	protected abstract void dispose();
	
	protected abstract void pause();
	protected abstract void resume();
	protected abstract void resize(int w, int h);
	
	public abstract void render(float delta);
	
	public GameState()
	{		 
	}
	
	public final boolean loadState(){
		if(!is_load){
			is_load = load();
		}
		return is_load;
	}	
	
	public final void disposeState()
	{
		is_load = false;
		dispose();
	}
	
	public final boolean isLoad(){
		return is_load;
	}
	
	void setLoad(boolean b)
	{
		is_load = b;
	}

	
	
}
