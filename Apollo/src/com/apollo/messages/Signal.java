package com.apollo.messages;

import com.apollo.Message;

public interface Signal {
	//TODO [egyware] agregar excepciones cuando alguien se trate de hacer acciones en esta señal
	public static final Signal nullSignal = new Signal(){

		@Override
		public void send(Message message) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void subscribe(Slot slot) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void unsubscribe(Slot slot) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	public void send(Message message);

	public void subscribe(Slot slot);

	public void unsubscribe(Slot slot);
	
}