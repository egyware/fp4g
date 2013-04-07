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
	 * Permite al Manager recibir un mensaje 
	 * @param m Mensaje que puede ser procesado por este manager
	 */
	public void onMessage(Message m)
	{		
	}
	/**
	 * Permite obtener la señal según el mensaje a enviar
	 * @param clazz tipo de la señal
	 * @return Retorna la señal deseada, sino devuelve nullSignal
	 */
	public <T extends Message> Signal signal(Class<T> clazz)
	{
		return Signal.nullSignal;
	}
	
	
	public void added(Entity e) {		
	}

	public void removed(Entity e) {
	}

	public void update(float delta) {		
	}

	public void initialize() {
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

}
