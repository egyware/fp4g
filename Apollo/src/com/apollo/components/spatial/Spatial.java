package com.apollo.components.spatial;

import com.apollo.BaseBehavior;
import com.apollo.Layer;
import com.apollo.utils.Bag;

public abstract class Spatial<T> extends BaseBehavior {
	
	public abstract Layer getLayer();
	
	private int getLayerId() {
		Layer layer = getLayer();
		return layer.getLayerId();
	}

	public void addToRenderBuckets(Bag<Bag<Spatial<T>>> buckets) {
		Bag<Spatial<T>> bucket = buckets.get(getLayerId());
		if (bucket == null) {
			bucket = buckets.set(getLayerId(), new Bag<Spatial<T>>());
		}
		bucket.add(this);
	}
	public void removeFromRenderBuckets(Bag<Bag<Spatial<T>>> buckets) {
		Bag<Spatial<T>> bucket = buckets.get(getLayerId());	
		bucket.remove(this);
	}
	
	@Override
	public void initialize() {
	}

	@Override
	public void update(float delta) {
	}
	
	public abstract void render(T graphicsContext);

	@Override
	public Class<? extends BaseBehavior> getType() {
		return Spatial.class;
	}

}
