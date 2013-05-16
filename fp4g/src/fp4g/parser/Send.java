package fp4g.parser;

import fp4g.data.IScope;
import fp4g.data.Value;

public class Send extends Value {
	private String messageType;
	private IScope local;
	private String to;
	private IScope contents;

	public Send(String messageType, IScope local, String to, IScope contents) {
		super(messageType);
		this.messageType = messageType;
		this.local = local;
		this.to = to;
		this.contents = contents;
	}

}
