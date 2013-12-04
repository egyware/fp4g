package com.apollo.managers;

import com.apollo.Behavior;
import com.apollo.Entity;
import com.apollo.utils.Bag;
import com.apollo.utils.ImmutableBag;

//TODO arreglar mensajeria
public class EntityManager extends Manager {
	private Bag<Entity> entities;
		
	public EntityManager() {
		entities = new Bag<Entity>();
	}

	public ImmutableBag<Entity> getEntities() {
		return entities;
	}

	@Override
	public void added(Entity entity) {
		entities.add(entity);		
	}

	public void applyComponentAnnotations(Entity entity) {
		for (Behavior component : entity.getBehaviors()) {
			component.applyAnnotations();
		}
	}

	@Override
	public void removed(Entity e) {
		entities.remove(e);		
	}

	@Override
	public void update(float delta) {		
		for (int i = 0, s = entities.size(); s > i; i++) {
			Entity entity = entities.get(i);
			entity.update(delta);
		}
	}
	
}
