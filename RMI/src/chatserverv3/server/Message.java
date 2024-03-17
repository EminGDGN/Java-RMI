package chatserverv3.server;

public class Message {

	private String from;
	private String content;
	
	public Message(String from, String content) {
		this.from = from;
		this.content = content;
	}
	
	public String from() {
		return from;
	}
	
	public String content() {
		return content;
	}
	
}
