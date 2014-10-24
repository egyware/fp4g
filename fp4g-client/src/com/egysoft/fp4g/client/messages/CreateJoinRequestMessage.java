package com.egysoft.fp4g.client.messages;
public class CreateJoinRequestMessage
{
	public String name;
	public String roomClass;
	public int max_users = Integer.MAX_VALUE; //sin limites
}