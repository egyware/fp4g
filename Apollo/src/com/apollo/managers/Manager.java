package com.apollo.managers;

import java.lang.reflect.Field;

import com.apollo.Entity;
import com.apollo.World;
import com.apollo.annotate.ManagerInjector;
import com.apollo.messages.Message;
import com.apollo.messages.Signal;
import com.apollo.messages.Slot;

public abstract class Manager implements Slot{
	protected World world;
		
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

	public void setWorld(World world) {
		this.world = world;
	}

	public World getWorld() {
		return world;
	}

	public void applyAnnotations() {
		Class<? extends Manager> clazz = this.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			ManagerInjector.injectorManager.inject(this, fields[i]);
		}
	}
	
	@Override
	public void onMessage(Message m) {
	}
	
	public <T extends Message> Signal signal(Class<T> clazz) {
		return Signal.nullSignal;
	}
}
