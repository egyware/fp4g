package com.apollo.managers;

import java.util.HashMap;
import java.util.Map;

import com.apollo.Entity;
import com.apollo.DefaultEntity;

public class PlayerManager extends Manager {
	private Map<DefaultEntity, Player> playerByEntity;

	public PlayerManager() {
		playerByEntity = new HashMap<DefaultEntity, Player>();
	}

	public void setPlayer(DefaultEntity e, Player player) {
		playerByEntity.put(e, player);
	}

	public Player getPlayer(Entity e) {
		return playerByEntity.get(e);
	}
	
}
