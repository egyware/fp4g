package com.apollo;

import java.util.LinkedHashMap;
import java.util.Map;

import com.apollo.messages.MessageReceiver;
import com.apollo.utils.Bag;

/**
 * An Abstract Entity
 * 
 *
 */
public final class DefaultEntity extends Entity {
	private Bag<Behavior> components;
	private Map<Class<? extends Behavior>, Behavior> componentsByType;	
	private Map<String,Var<?>> variables;
	public DefaultEntity(World world) {
		super(world);
		
		components = new Bag<Behavior>();
		componentsByType = new LinkedHashMap<Class<? extends Behavior>, Behavior>();
		variables = new LinkedHashMap<String,Var<?>>();
	}

	public void setBehavior(Behavior component) {		
		component.setOwner(this);
		components.add(component);
		componentsByType.put(component.getType(), component);		
	}
	
	public void removeBehavior(Class<? extends Behavior> clazz) {
		Behavior component = getBehavior(clazz);
		if(component!=null) {
			removeBehavior(component);
		}
	}
	
	/**
	 * Remove a Component
	 * @param component to remove
	 */
	public void removeBehavior(Behavior component) {
		components.remove(component);
		componentsByType.remove(component);	
	}
	
	/** 
	 * Initialize all the component
	 */
	@Override
	protected void initialize() {
		for (int i = 0, s = components.size(); s > i; i++) {
			components.get(i).initialize();
		}
	}
	
	@Override
	protected void uninitialize() {
		for (int i = 0, s = components.size(); s > i; i++) {
			components.get(i).uninitialize();
		}
	}

	@Override
	public void update(float delta) {
		for (int i = 0, s = components.size(); s > i; i++) {
			components.get(i).update(delta);
		}
	}

	@Override
	public <T extends Behavior> T getBehavior(Class<T> type) {
		return type.cast(componentsByType.get(type));
	}
	
	@Override
	public Bag<Behavior> getBehaviors() {
		return components;
	}
	
	public Var<?> getVariable(String name)
	{
		return variables.get(name);
	}
	public void setVariable(String name,Var<?> var)
	{
		variables.put(name,var);		
	}
}
