package chatserverv1;

import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;

public class Client {
	
	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry("localhost",9999);
			IChatRoom chatroom = (IChatRoom) registry.lookup("chatroom");
			
			ArrayList<IParticipant> participants = new ArrayList();
			
			for(int i = 0; i < 10; i++) {
				IParticipant temp = new IParticipant(i,chatroom)
				participants.add(temp);
				chatroom.connect(temp);
				
			}
			
			String[] nbParticipants = chatroom.who();
			for(String s : nbParticipants) {
				System.out.println("Participant : " + s);
			}
			
			for(IParticipant p : participants) {
				Scanner s = new Scanner(System.in);
				String msg = s.nextLine();
				chatroom.send(p, msg);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
