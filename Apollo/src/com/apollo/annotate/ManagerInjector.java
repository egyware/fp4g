package com.apollo.annotate;

import com.apollo.managers.Manager;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.reflect.Annotation;
import com.badlogic.gdx.utils.reflect.Field;

public abstract class ManagerInjector<T> {
	private final Class<? extends java.lang.annotation.Annotation> clazz;

	public static ManagerInjector<Manager> injectorManager = new ManagerInjector<Manager>(InjectManager.class) {
		@Override
		Manager getInjectionObject(Manager manager, Class<Manager> type) 
		{
			return manager.getWorldContainer().getManager(type);
		}
	};

	public ManagerInjector(Class<? extends java.lang.annotation.Annotation> clazz) 
	{
		this.clazz = clazz;
	}
	
	public void inject(Manager manager, Field field) {
		Annotation annotation = field.getDeclaredAnnotation(clazz);
		if(annotation!=null && clazz.isAssignableFrom(clazz)) {
			//Get the object to inject
			@SuppressWarnings("unchecked")
			Class<T> type = (Class<T>)field.getType();
			T object = getInjectionObject(manager, type);
			if(object==null) 
			{
				//This will just inject a null object, but that is likely a problem in the code
				throw new GdxRuntimeException("Warning! Autoinjection didn't find an object to inject! "+ field.getDeclaringClass() + " for " + field.getName());			
			}
			try {
				field.setAccessible(true);
				field.set(manager, object);
			} catch (Exception e) {				
				throw new GdxRuntimeException("Failed to inject.", e);
			}
		}
	}
	
	abstract T getInjectionObject(Manager manager, Class<T> type);

}
