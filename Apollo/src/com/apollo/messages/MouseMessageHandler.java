package com.apollo.messages;

import com.apollo.MessageHandler;

public interface MouseMessageHandler extends MessageHandler 
{
	public void onPressButtonMouse(int button, int x,int y);
	public void onReleaseButtonMouse(int button, int x,int y);
	public void onMoveMouse(int x,int y);
	public void onDraggedMouse(int dx,int dy);
}
