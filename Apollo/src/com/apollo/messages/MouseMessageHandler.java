package com.apollo.messages;

import com.apollo.IMessageReceiver;

public interface MouseMessageHandler extends IMessageReceiver 
{
	public void onPressButtonMouse(int x,int y, int pointer, int button);
	public void onReleaseButtonMouse(int x,int y,int pointer, int button);
	public void onMoveMouse(int x,int y);
	public void onDraggedMouse(int dx,int dy, int pointer);
}
