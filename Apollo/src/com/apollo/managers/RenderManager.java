package com.apollo.managers;

import com.apollo.Entity;
import com.apollo.components.spatial.Spatial;
import com.apollo.utils.Bag;

public class RenderManager<T> extends Manager {
	private Bag<Bag<Spatial<T>>> buckets;
	protected T context;

	public RenderManager(T context) {
		this.context = context;
		buckets = new Bag<Bag<Spatial<T>>>();
	}

	public T getContext() {
		return context;
	}

	public void render(T context) {
		renderBuckets(context);
	}

	@SuppressWarnings("unchecked")
	private void addBaseEntitySpatialsToBuckets(Entity entity) {
		Spatial<T> spatial = entity.getBehavior(Spatial.class);
		if (spatial != null) {
			spatial.addToRenderBuckets(buckets);
		}
	}

	private void renderBuckets(T context) {
		for (int i = 0; buckets.size() > i; i++) {
			Bag<Spatial<T>> bag = buckets.get(i);
			if (bag != null) {
				for (int a = 0; bag.size() > a; a++) {
					Spatial<T> spatial = bag.get(a);
					spatial.render(context);
				}
			}
		}
	}

	@Override
	public void added(Entity e) {
		addBaseEntitySpatialsToBuckets(e);
	}

	@Override
	@SuppressWarnings("unchecked")	
	public void removed(Entity entity) {
		Spatial<T> spatial = entity.getBehavior(Spatial.class);
		if (spatial != null) {
			spatial.removeFromRenderBuckets(buckets);
		}	
	}

}
