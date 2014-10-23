package com.egysoft.fp4g.server.messages;

import com.egysoft.fp4g.server.FP4GServer;
import com.egysoft.fp4g.server.User;

public interface RequestMessageBase 
{
	public void processClientMessage(final FP4GServer server,final User user);	
}
