package com.apollo.annotate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import com.apollo.ApolloException;
import com.apollo.Behavior;
import com.apollo.Entity;
import com.apollo.BaseBehavior;
import com.apollo.managers.Manager;
import com.apollo.managers.TagManager;

public abstract class ComponentInjector<T> 
{
	private final Class<? extends Annotation> clazz;
	
	public static ComponentInjector<Behavior> injectorComponent = new ComponentInjector<Behavior>(InjectComponent.class) {
		@Override		
		@SuppressWarnings("unchecked")
		Behavior getInjectionObject(Behavior component, Field field) {
			InjectComponent inject = field.getAnnotation(InjectComponent.class);
			Class<? extends Behavior> clazz = inject.value(); //familia
			Class<? extends Behavior> fieldClazz = Class.class.cast(field.getType());
			if(clazz == BaseBehavior.class)
			{
				return component.getComponentFromOwner(fieldClazz);
			}
			else
			{
				if(!clazz.isAssignableFrom(fieldClazz))
				{
					System.out.println("Warning! Autoinjection " + field.getName() + " field class " + field.getDeclaringClass() + " is not assignable fromm family class "+clazz);
				}
				return component.getComponentFromOwner(clazz);						
			}
		}

	};
	
	public static ComponentInjector<Manager> injectorManager = new ComponentInjector<Manager>(InjectManager.class) {
		@Override
		@SuppressWarnings("unchecked")
		Manager getInjectionObject(Behavior component, Field field) {
			return component.getWorldContainer().getManager(Class.class.cast(field.getType()));
		}
	};
	
	public static ComponentInjector<Entity> injectorTaggedEntity = new ComponentInjector<Entity>(InjectTaggedEntity.class) {
		@Override
		Entity getInjectionObject(Behavior component, Field field) {
			InjectTaggedEntity annotation = field.getAnnotation(InjectTaggedEntity.class);
			String tag = annotation.value();
			TagManager tagManager = component.getWorldContainer().getManager(TagManager.class);
			Entity entity = null;
			if(tagManager != null)
			{
				entity = tagManager.getEntity(tag);
			}
			else
			{
				System.out.println("Warning! Autoinjection didn't find tag manager when attempting to inject entity by tag. "+ field.getDeclaringClass() + " for " + field.getName());
			}
			return entity;
		}
	};
	
	

	public ComponentInjector(Class<? extends Annotation> clazz)
	{
		this.clazz = clazz;
	}
	
	public void inject(Field field, Behavior component) {
		Annotation annotation = field.getAnnotation(clazz);
		if(annotation!=null && clazz.isAssignableFrom(clazz)) {
			T object = getInjectionObject(component, field);
			if(object==null) {
				//This will just inject a null object, but that is likely a problem in the code
				System.out.println("Warning! Autoinjection didn't find an object to inject! "+ field.getDeclaringClass() + " for " + field.getName());
			}
			try {
				field.setAccessible(true);
				field.set(component, object);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ApolloException("Failed to inject.", e);
			}
		}
	}
	
	public static void applyAnnotations(Behavior instance) 
	{	
		Class<?> clazz = instance.getClass();
		do {
			Field[] fields = clazz.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) 
			{
				ComponentInjector.injectorComponent.   inject(fields[i], instance);
				ComponentInjector.injectorManager.     inject(fields[i], instance);
				ComponentInjector.injectorTaggedEntity.inject(fields[i], instance);
			}
			clazz = clazz.getSuperclass();
		} while (clazz.isInstance(Behavior.class));
	}
	
	abstract T getInjectionObject(Behavior component, Field field);

	public ComponentInjector<Behavior> getInjectorComponent()
	{
		return injectorComponent;
	}

}
