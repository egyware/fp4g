package com.apollo;

public interface EntityBuilder {

	Entity buildEntity(final WorldContainer world,final Object ...args);
	
	public String getEntityBuilderName();

}