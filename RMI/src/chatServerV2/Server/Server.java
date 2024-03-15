package chatServerV2.Server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	
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
