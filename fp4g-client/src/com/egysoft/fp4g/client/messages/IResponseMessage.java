package com.egysoft.fp4g.client.messages;

import com.egysoft.fp4g.net.client.NetEngine;

public interface IResponseMessage
{
	public void processMessage(NetEngine engine);
}
