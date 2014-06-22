package com.egysoft.fp4g.server.messages;

public class SnapshotMessage extends MessageBase
{
	public SnapshotMessage() 
	{
		super(Message.SnapshotMessage);
	}
	public int tick;
	public EntityData[] entities;
}
