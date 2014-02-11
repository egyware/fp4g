package com.apollo.components;
import com.apollo.Layer;


public enum Layers implements Layer {
	BackLayer,ActorLayer,TopLayer;

	@Override
	public int getLayerId() {		
		return ordinal();
	}

}
