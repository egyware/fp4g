package com.apollo.messages;

import com.apollo.Message;

public interface Slot{
	
	/**
	 * Slot que permite recibir cualquier tipo de se�al o mensaje
	 * @param message Mensaje a recibir
	 */
	public void onMessage(Message message);
	
}
