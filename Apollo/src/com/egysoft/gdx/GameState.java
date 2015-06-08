package com.egysoft.gdx;




public abstract class GameState
{
	protected final String groupName;
	
	protected abstract void create();
	protected abstract void dispose();
	
	protected abstract void pause();
	protected abstract void resume();
	protected abstract void resize(int w, int h);
	
	public abstract void render(float delta);
	
	public GameState(String groupName)
	{		 
		this.groupName = groupName;
	}
	
	public String getGroupName()
	{
		return groupName;
	}
	
	
}
