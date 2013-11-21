package com.apollo.managers;

import java.lang.reflect.Field;

import com.apollo.Entity;
import com.apollo.Message;
import com.apollo.World;
import com.apollo.annotate.ManagerInjector;
import com.apollo.messages.MessageSender;
import com.apollo.messages.MessageReceiver;

public abstract class Manager implements MessageReceiver{
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
	
	public <T extends Message> MessageSender signal(Class<T> clazz) {
		return MessageSender.nullSignal;
	}
}
