package com.apollo.messages;

import com.apollo.MessageHandler;

public interface TransformMessageHandler extends MessageHandler
{
	public void onTranslateTransform(float x,float y);
	public void onRotateTransform(float grad);
}
