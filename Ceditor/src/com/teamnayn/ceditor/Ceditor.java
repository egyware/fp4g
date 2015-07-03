package com.teamnayn.ceditor;

import com.badlogic.gdx.assets.loaders.resolvers.LocalFileHandleResolver;
import com.egysoft.gdx.Game;

public class Ceditor extends Game
{
	public Ceditor()
	{
		super(new LocalFileHandleResolver());
			
	}
	
	public void create()
	{
		super.create();
		
		start(new Menu());
	}
	
	@Override
	public int getWidth() 
	{
		return 800;
	}

	@Override
	public int getHeight() 
	{
		return 640;
	}

}
