package com.apollo.managers;

import com.apollo.messages.Message;
import com.apollo.messages.Signal;
import com.apollo.messages.Slot;

//TODO [egyware] No estoy realmente seguro de esta clase
public interface ISystem extends Slot {
		
	public <T extends Message> Signal signal(Class<T> clazz);	
}
