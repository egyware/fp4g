package com.apollo;

public interface EntityBuilder {

	Entity buildEntity(final World world);
	
	public String getEntityBuildName();

}