package com.egysoft.fp4g.net;

import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.util.DefaultClassResolver;

public class FP4GClassResolver extends DefaultClassResolver
{
	@Override	
	@SuppressWarnings("rawtypes")
	public Registration getRegistration (Class type) 
	{
		Registration registration = super.getRegistration(type);
		if(registration == null)
		{
			Class superClass = type.getSuperclass();
			if(superClass != null && superClass != Object.class)
			{
				registration = getRegistration(superClass);
				if(registration != null) return registration;
			}
			
			for(Class interfeis:type.getInterfaces())
			{
				registration = super.getRegistration(interfeis);
				if(registration != null) return registration; 
			}
		}
		return registration;
	}
	
}
