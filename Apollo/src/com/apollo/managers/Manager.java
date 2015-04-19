package com.apollo.managers;

import com.apollo.Engine;
import com.apollo.Entity;
import com.apollo.annotate.ManagerInjector;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.Field;

public abstract class Manager
{
	protected Engine engine;
	
	/**
	 * Inicializa el Manager
	 */
	public void initialize() {
	}
	
	public void added(Entity e) {		
	}

	public void removed(Entity e) {
	}

	public void update(float delta) {		
	}

	public void setWorldContainer(Engine world) {
		this.engine = world;
	}

	public Engine getWorldContainer() {
		return engine;
	}

	public void applyAnnotations()
	{
		Class<? extends Manager> clazz = getClass();		
		Field[] fields = ClassReflection.getFields(clazz);
		for (int i = 0; i < fields.length; i++) {
			ManagerInjector.injectorManager.inject(this, fields[i]);
		}
	}	
}
