package com.apollo;

public interface IEntityBuilder 
{
	public String getEntityBuilderName();

	public Entity buildEntity(final Engine engine, Object... args);

}