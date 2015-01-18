package com.apollo;


public interface IEntityBuilder 
{
	Entity buildEntity(final Engine engine, final Object ...args);
	
	public String getEntityBuilderName();

}