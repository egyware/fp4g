package com.apollo.annotate;

import com.apollo.BaseBehavior;
import com.apollo.Behavior;
import com.apollo.Entity;
import com.apollo.managers.Manager;
import com.apollo.managers.TagManager;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.reflect.Annotation;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.Field;

public abstract class ComponentInjector<T> 
{
	private final Class<? extends java.lang.annotation.Annotation> clazz;
	
	public static ComponentInjector<Behavior> injectorComponent = new ComponentInjector<Behavior>(InjectComponent.class) {
		@Override		
		@SuppressWarnings("unchecked")
		Behavior getInjectionObject(Behavior component, Field field) {
			InjectComponent inject = field.getDeclaredAnnotation(InjectComponent.class).getAnnotation(InjectComponent.class);
			Class<? extends Behavior> clazz = inject.value(); //familia
			Class<? extends Behavior> fieldClazz = Class.class.cast(field.getType());
			if(clazz == Behavior.class)
			{
				return component.getComponentFromOwner(fieldClazz);
			}
			else
			{
				if(!clazz.isAssignableFrom(fieldClazz))
				{
					throw new GdxRuntimeException("Warning! Autoinjection " + field.getName() + " field class " + field.getDeclaringClass() + " is not assignable fromm family class "+clazz);					
				}
				return component.getComponentFromOwner(clazz);						
			}
		}

	};
	
	public static ComponentInjector<Manager> injectorManager = new ComponentInjector<Manager>(InjectManager.class) {
		@Override
		@SuppressWarnings("unchecked")
		Manager getInjectionObject(Behavior component, Field field) {
			return component.getEngine().getManager(Class.class.cast(field.getType()));
		}
	};
	
	public static ComponentInjector<Entity> injectorTaggedEntity = new ComponentInjector<Entity>(InjectTaggedEntity.class) {
		@Override
		Entity getInjectionObject(Behavior component, Field field) {
			InjectTaggedEntity annotation = field.getDeclaredAnnotation(InjectTaggedEntity.class).getAnnotation(InjectTaggedEntity.class);
			String tag = annotation.value();
			TagManager tagManager = component.getEngine().getManager(TagManager.class);
			Entity entity = null;
			if(tagManager != null)
			{
				entity = tagManager.getEntity(tag);
			}
			else
			{
				throw new GdxRuntimeException("Warning! Autoinjection didn't find tag manager when attempting to inject entity by tag. "+ field.getDeclaringClass() + " for " + field.getName());
			}
			return entity;
		}
	};
	
	

	public ComponentInjector(Class<? extends java.lang.annotation.Annotation> clazz)
	{
		this.clazz = clazz;
	}
	
	public void inject(Field field, Behavior component) 
	{
		Annotation annotation = field.getDeclaredAnnotation(clazz);
		if(annotation!=null)
		{
			T object = getInjectionObject(component, field);
			if(object==null) {
				//This will just inject a null object, but that is likely a problem in the code
				throw new GdxRuntimeException("Warning! Autoinjection didn't find an object to inject! "+ field.getDeclaringClass() + " for " + field.getName());
			}
			try
			{
				field.setAccessible(true);
				field.set(component, object);
			}
			catch (Exception e) 
			{				
				throw new GdxRuntimeException("Failed to inject.", e);
			}
		}
	}
	
	public static void applyAnnotations(Behavior instance) 
	{	
		Class<?> clazz = instance.getClass();
		do {
			Field[] fields = ClassReflection.getDeclaredFields(clazz);
			for (int i = 0; i < fields.length; i++) 
			{
				ComponentInjector.injectorComponent.   inject(fields[i], instance);
				ComponentInjector.injectorManager.     inject(fields[i], instance);
				ComponentInjector.injectorTaggedEntity.inject(fields[i], instance);
			}
			clazz = clazz.getSuperclass();
		} while (Behavior.class.isAssignableFrom(clazz) && clazz != BaseBehavior.class);
	}
	
	abstract T getInjectionObject(Behavior component, Field field);

	public ComponentInjector<Behavior> getInjectorComponent()
	{
		return injectorComponent;
	}

}
