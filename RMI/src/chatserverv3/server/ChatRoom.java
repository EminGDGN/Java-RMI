package chatserverv3.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import chatserverv3.interfaces.IChatRoom;
import chatserverv3.interfaces.IParticipant;

public class ChatRoom extends UnicastRemoteObject implements IChatRoom{

	
	private static final long serialVersionUID = 1L;
	private ArrayList<IParticipant> participants;
	private String name;
	
	public ChatRoom(String name) throws RemoteException{
		super();
		this.name = name;
		participants = new ArrayList<IParticipant>();
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
	
	public String[] who()  throws RemoteException{
		String[] result = new String[participants.size()];
		int i = 0;
		for(IParticipant p : participants) {
			result[i] = p.name();
			i++;
		}
		return result;
	}
	
	public void send(IParticipant p, String msg)throws RemoteException {
		String name;
		try {
			name = p.name();
			System.out.println("Participant " + name + " send " + msg);
			for(IParticipant other : participants) {
				if(p != other) {
					other.receive(name, msg);
				}
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
