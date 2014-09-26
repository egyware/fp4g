package com.apollo.managers;

import java.util.HashMap;
import java.util.Map;

import com.apollo.Entity;
import com.apollo.Message;
import com.apollo.MessageHandler;
import com.apollo.utils.ImmutableBag;

public class TagManager extends Manager {
	private Map<String, Entity> entityByTag;

	public TagManager() {
		entityByTag = new HashMap<String, Entity>();
	}

	public void register(String tag, Entity e) {
		entityByTag.put(tag, e);
	}

	public void unregister(String tag) {
		entityByTag.remove(tag);
	}

	public boolean isRegistered(String tag) {
		return entityByTag.containsKey(tag);
	}

	public Entity getEntity(String tag) {
		return entityByTag.get(tag);
	}
	
	@Override
	public void removed(Entity e) {
		entityByTag.values().remove(e);
	}

	@Override
	public ImmutableBag<MessageHandler> getMessageHandler(Message<?> message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onMessage(Message<? extends MessageHandler> message,
			Object... args) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T extends Message<?>> void addEventHandler(Message<?> messageType,
			MessageHandler listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T extends Message<?>> void removeEventHandler(
			Message<?> messagetType, MessageHandler listener) {
		// TODO Auto-generated method stub
		
	}
}
