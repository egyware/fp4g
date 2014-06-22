package com.egysoft.fp4g.server.messages;

public class DeltaMessage extends MessageBase
{
	public DeltaMessage()
	{
		super(Message.DeltaMessage);
	}
	public int tick;
	public int entityid;    ///!< Id de la entidad quien envia el mensaje
	public short messageid; ///!< Una id unica para cada mensaje
	public short methodid;  ///!< Id para cada metodo del mensaje
	public byte[] params;   ///!< Parametros del mensaje
}
