package chatserverv1;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ChatRoom extends UnicastRemoteObject implements IChatRoom{

	
	private ArrayList<IParticipant> participants;
	private String name;
	
	public ChatRoom(String name) throws RemoteException{
		this.name = name;
		participants = new ArrayList();
	}
	
	public void connect(IParticipant p) throws RemoteException{
		participants.add(p);
	}
	
	public void leave(IParticipant p) throws RemoteException{
		participants.remove(p);
	}
	
	public String name() throws RemoteException{
		return name;
	}
	
	public String[] who() throws RemoteException{
		String[] result = new String[participants.size()];
		int i = 0;
		for(IParticipant p : participants) {
			result[i] = p.name();
			i++;
		}
		return result:
	}
	
	public void send(IParticipant p, String msg) {
		String name = p.name();
		System.out.println("Participant " + name + " send " + msg);
		for(IParticipant other : participants) {
			if(p != other) {
				other.receive(name, msg);
			}
		}
	}
}
