package com.apollo.messages;

import com.apollo.MessageHandler;

public interface MouseMessageHandler extends MessageHandler 
{
	public void onPressButtonMouse(int x,int y, int pointer, int button);
	public void onReleaseButtonMouse(int x,int y,int pointer, int button);
	public void onMoveMouse(int x,int y);
	public void onDraggedMouse(int dx,int dy, int pointer);
}
