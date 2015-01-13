package com.apollo.messages;

import com.apollo.IMessageReceiver;

public interface TransformMessageHandler extends IMessageReceiver
{
	public void onTranslateTransform(float x,float y);
	public void onRotateTransform(float grad);
}
