package com.apollo.managers;

import java.lang.reflect.Field;

import com.apollo.Entity;
import com.apollo.Message;
import com.apollo.MessageHandler;
import com.apollo.MessageReceiver;
import com.apollo.WorldContainer;
import com.apollo.annotate.ManagerInjector;

public abstract class Manager implements MessageReceiver
{
	protected WorldContainer world;
		
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

	public void setWorldContainer(WorldContainer world) {
		this.world = world;
	}

	public WorldContainer getWorldContainer() {
		return world;
	}

	public void applyAnnotations() {
		Class<? extends Manager> clazz = this.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			ManagerInjector.injectorManager.inject(this, fields[i]);
		}
	}	
	
	public abstract <T extends Message<?>> void addEventHandler(Message<?> messageType, MessageHandler listener);
	public abstract <T extends Message<?>> void removeEventHandler(Message<?> messagetType, MessageHandler listener);
}
