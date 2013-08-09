package fp4g.data;


public class Send extends Code {
	private String messageType;
	private IScope local;
	private String to;
	private IScope contents;

	public Send(String messageType, IScope local, String to, IScope contents) {
		//super(messageType);
		this.messageType = messageType;
		this.local = local;
		this.to = to;
		this.contents = contents;
	}

}
