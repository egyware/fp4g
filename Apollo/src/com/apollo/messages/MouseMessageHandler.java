package com.apollo.messages;

import com.apollo.MessageReciever;

public interface MouseMessageHandler extends MessageReciever 
{
	public void onPressButtonMouse(int x,int y, int pointer, int button);
	public void onReleaseButtonMouse(int x,int y,int pointer, int button);
	public void onMoveMouse(int x,int y);
	public void onDraggedMouse(int dx,int dy, int pointer);
}
