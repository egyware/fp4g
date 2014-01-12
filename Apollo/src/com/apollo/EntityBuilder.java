package com.apollo;

public interface EntityBuilder {

	Entity buildEntity(final WorldContainer world,Object ...args);
	
	public String getEntityBuilderName();

}