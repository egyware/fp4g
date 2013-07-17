package com.apollo;

public final class Variable<T> {
	private T value;
	
	public Variable(T t)
	{
		value = t;
	}
	public Variable()
	{	
	}
	
	public T getValue() {	
		return value;
	}

	public void setValue(T t) {		
		value = t;
	}

}
