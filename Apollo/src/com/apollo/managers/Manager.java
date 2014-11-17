package com.apollo.managers;

import java.lang.reflect.Field;

import com.apollo.Engine;
import com.apollo.Entity;
import com.apollo.annotate.ManagerInjector;

public abstract class Manager
{
	protected Engine world;
	
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
		this.world = world;
	}

	public Engine getWorldContainer() {
		return world;
	}

	public void applyAnnotations()
	{
		Class<? extends Manager> clazz = this.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			ManagerInjector.injectorManager.inject(this, fields[i]);
		}
	}	
}
