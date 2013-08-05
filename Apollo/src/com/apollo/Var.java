package com.apollo;

public final class Var<T> {
	private T value;
	
	public Var(T t)
	{
		value = t;
	}
	public Var()
	{	
	}
	
	public T getValue() {	
		return value;
	}

	public void setValue(T t) {		
		value = t;
	}

}
