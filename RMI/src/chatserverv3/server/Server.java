package chatserverv3.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import chatserverv3.interfaces.IChatRoom;

public class Server {
	
	private static int NBCHATROOMS = 5;
	
	public static void main(String[] args) {
		try {
			ArrayList<IChatRoom> chatrooms = new ArrayList<>();
			Registry registry = LocateRegistry.createRegistry(9999);
			
			for(int i = 0; i < NBCHATROOMS; i++) {
				IChatRoom cr = new ChatRoom("chatroom n°" + i);
				chatrooms.add(cr);
				registry.bind("chatroom n°" + i ,cr);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
