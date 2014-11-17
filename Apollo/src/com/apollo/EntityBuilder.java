package com.apollo;

public interface EntityBuilder {

	Entity buildEntity(final Engine world,final Object ...args);
	
	public String getEntityBuilderName();

}