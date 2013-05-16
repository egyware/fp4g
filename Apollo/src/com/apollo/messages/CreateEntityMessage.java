/**
 * 
 */
package com.apollo.messages;

import com.apollo.Entity;
import com.apollo.Message;

/**
 * Pide crear una entidad nueva, la nueva entididad qudará guardada en entity
 * @author egyware
 *
 */
public class CreateEntityMessage implements Message {
	public String name;
	public Entity entity;
	public Object[] args;
}
