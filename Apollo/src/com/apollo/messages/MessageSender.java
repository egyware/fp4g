package com.apollo.messages;

import com.apollo.Message;

public interface MessageSender {
	//TODO [egyware] agregar excepciones cuando alguien se trate de hacer acciones en esta señal
	public static final MessageSender nullSignal = new MessageSender(){

		@Override
		public void send(Message message) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addMessageReceiver(MessageReceiver slot) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void removeMessangeReceiver(MessageReceiver slot) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	public void send(Message message);

	public void addMessageReceiver(MessageReceiver slot);

	public void removeMessangeReceiver(MessageReceiver slot);
	
}