/**
 * 
 */
package com.apollo.messages;

import com.apollo.Entity;

/**
 * Pide crear una entidad nueva, la nueva entididad qudar� guardada en entity
 * @author egyware
 *
 */
public class CreateEntityMessage implements Message {
	public String name;
	public Entity entity;
}
