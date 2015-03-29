package com.egysoft.gdx.assets;

import com.badlogic.gdx.utils.ObjectMap;

/**
 * 
 * @author Edgardo
 *
 */
public class Spawn
{
	public String entity;
	public String script;
	public int x;
	public int y;
	public int w;
	public int h;
	public ObjectMap<String,Object> map;
	
	public Spawn(String _e, int _x,int _y, int _w, int _h,ObjectMap<String, Object> _map)
	{
		entity = _e;
		x = _x;
		y = _y;
		w = _w;
		h = _h;
		map = _map;
	}	
	public Spawn(String _e, int _x,int _y, int _w, int _h, String _script, ObjectMap<String, Object> _map)
	{
		entity = _e;
		x = _x;
		y = _y;
		w = _w;
		h = _h;
		map = _map;
		script = _script;
	}
}
