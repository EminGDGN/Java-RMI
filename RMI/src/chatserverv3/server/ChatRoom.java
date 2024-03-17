package chatserverv3.server;

import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import chatserverv3.interfaces.IChatRoom;
import chatserverv3.interfaces.IParticipant;

public class ChatRoom extends UnicastRemoteObject implements IChatRoom{

	
	private static final long serialVersionUID = 1L;
	private ArrayList<IParticipant> participants;
	private ArrayList<Message> history;
	private String name;
	
	public ChatRoom(String name) throws RemoteException{
		super();
		this.name = name;
		participants = new ArrayList<IParticipant>();
		history = new ArrayList<>();
	}
	
	public void connect(IParticipant p) throws RemoteException{
		participants.add(p);
		for(Message m : history) {
			p.receive(m.from(), m.content());
		}
	}
	
	public void leave(IParticipant p) throws RemoteException{
		participants.remove(p);
	}
	
	public String name() throws RemoteException{
		return name;
	}
	
	public String[] who()  throws RemoteException{
		String[] result = new String[participants.size()];
		ArrayList<IParticipant> toRemove = new ArrayList<>();
		
		int i = 0;
		for(IParticipant p : participants) {
			try {
				result[i] = p.name();
				i++;
			}
			catch(RemoteException e) {
				toRemove.add(p);
			}
		}
		
		for(IParticipant r : toRemove) {
			this.leave(r);
		}
		
		return result;
	}
	
	public void send(IParticipant p, String msg)throws RemoteException {
		String name;
		try {
			ArrayList<IParticipant> toRemove = new ArrayList<>();
			
			name = p.name();
			System.out.println("Participant " + name + " send " + msg);
			
			history.add(new Message(name, msg));
			
			for(IParticipant other : participants) {
				try {
					if(!name.equals(other.name())) {
						other.receive(name, msg);
					}
				}
				catch(RemoteException e) {
					toRemove.add(other);
				}
			}
			
			for(IParticipant r : toRemove) {
				this.leave(r);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
