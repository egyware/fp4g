package com.apollo;

public interface EntityBuilder {

	Entity buildEntity(final World world,Object ...args);
	
	public String getEntityBuilderName();

}