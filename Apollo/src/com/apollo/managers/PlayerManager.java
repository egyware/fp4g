package com.apollo.managers;

import java.util.HashMap;
import java.util.Map;

import com.apollo.Entity;
import com.apollo.Message;
import com.apollo.MessageHandler;
import com.apollo.utils.ImmutableBag;

public class PlayerManager extends Manager {
	private Map<Entity, Player> playerByEntity;

	public PlayerManager() {
		playerByEntity = new HashMap<Entity, Player>();
	}

	public void setPlayer(Entity e, Player player) {
		playerByEntity.put(e, player);
	}

	public Player getPlayer(Entity e) {
		return playerByEntity.get(e);
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
