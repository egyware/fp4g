package com.apollo;

import com.apollo.Engine;
import com.apollo.Entity;
import com.apollo.IEntityBuilder;
import com.badlogic.gdx.utils.ObjectMap;

public interface INetworkedEntityBuilder extends IEntityBuilder
{
	Entity buildEntity(final Engine engine, long id, final int x, final int y, final ObjectMap<String, Object> map);
}

