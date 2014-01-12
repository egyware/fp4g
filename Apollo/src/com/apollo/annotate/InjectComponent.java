package com.apollo.annotate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.apollo.BaseBehavior;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface InjectComponent {
	Class<? extends BaseBehavior> value() default BaseBehavior.class;

}
