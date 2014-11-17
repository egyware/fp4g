package com.apollo.messages;

import com.apollo.MessageReciever;

public interface TransformMessageHandler extends MessageReciever
{
	public void onTranslateTransform(float x,float y);
	public void onRotateTransform(float grad);
}
