package com.teamnayn.ceditor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.egysoft.gdx.Assets;
import com.egysoft.gdx.Game;
import com.egysoft.gdx.GameState;

public class Menu extends GameState
{
	public Menu() 
	{
		super("menu");	
	}

	private Stage hud;
	@Override
	protected void create() 
	{
		final Assets assets = Game.instance.assets;
		assets.loadGroup(groupName);
		assets.finishLoading();
		
		hud = new Stage();
		
		final Skin skin = assets.get("assets/uiskin.json");
		
		final Table table = new Table();		
		final TextButton button = new TextButton("Cargar Mapa", skin);
		final Dialog maps = createDialog(skin);
		
		button.addListener(new ChangeListener()
		{
			@Override
			public void changed(ChangeEvent event, Actor actor) 
			{
				maps.show(hud);
			}			
		});
		
		table.setFillParent(true);		
		table.add(button);
		
		hud.addActor(table);
		
		Game.instance.addInputProcessor(hud);		
	}

	private Dialog createDialog(final Skin skin) 
	{
		final Dialog dialog = new Dialog("Abrir", skin);
		final List<String> list = new List<String>(skin);
		final TextButton ok = new TextButton("Abrir", skin);
		final TextButton nah = new TextButton("Cancelar", skin);
		
		list.clearItems();
		list.getItems().addAll(Game.instance.assets.getGroups());
		list.getItems().removeValue("common", false);
		list.getItems().removeValue("menu", false);
		list.layout();
		
		dialog.row();
		dialog.add(list).fillX().colspan(2);
		dialog.row();
		dialog.add(ok).left();
		dialog.add(nah).right();
		
		list.addListener(new ChangeListener()
		{
			@Override
			public void changed(ChangeEvent event, Actor actor) 
			{			
				
			}			
		});
		
		ok.addListener(new ChangeListener()
		{
			@Override
			public void changed(ChangeEvent event, Actor actor) 
			{
				final String selectedGroup = list.getSelected();
				if(selectedGroup != null)
				{
					//cargo el siguiente mapa
					Game.instance.nextState(new Editor(selectedGroup));
				}
			}
		});
		
		nah.addListener(new ChangeListener()
		{
			@Override
			public void changed(ChangeEvent event, Actor actor) 
			{
				dialog.hide();
			}
		});
		
		return dialog;
	}

	@Override
	protected void dispose() 
	{
		Game.instance.removeInputProcessor(hud);		
	}

	@Override
	protected void pause() 
	{
		// TODO Auto-generated method stub		
	}

	@Override
	protected void resume() 
	{
		// TODO Auto-generated method stub		
	}

	@Override
	protected void resize(int w, int h) 
	{
		hud.getViewport().update(w, h);
		
	}

	@Override
	public void render(float delta) 
	{
		Gdx.gl.glClearColor(0,0.2f,0.8f,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		hud.act();
		hud.draw();
		
	}	
}
