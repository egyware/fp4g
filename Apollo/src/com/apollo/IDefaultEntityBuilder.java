package com.apollo;

import com.badlogic.gdx.utils.ObjectMap;

public interface IDefaultEntityBuilder extends IEntityBuilder
{
	Entity buildEntity(final Engine engine, final int x, final int y, final int w, final int h,final ObjectMap<String, Object> map);	
}

