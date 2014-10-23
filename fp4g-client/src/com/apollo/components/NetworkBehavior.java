package com.apollo.components;

import com.apollo.BaseBehavior;

public class NetworkBehavior extends BaseBehavior 
{
	private int netid;
	
	public void setNetID(int id)
	{
		this.netid = id;
	}
	
	public int getNetID()
	{
		return this.netid;
	}
}
