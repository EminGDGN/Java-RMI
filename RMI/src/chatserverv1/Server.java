package chatserverv1;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

	
	private IChatRoom chatroom;
	private Registry registry;
	
	public static void main(String[] args) {
		try {
			IChatRoom chatroom = new ChatRoom("chatroom");
			Registry registry = LocateRegistry.createRegistry(9999);
			registry.bind("chatroom",chatroom);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
