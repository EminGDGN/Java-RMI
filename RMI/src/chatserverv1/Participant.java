package chatserverv1;

import java.rmi.server.UnicastRemoteObject;

public class Participant extends UnicastRemoteObject implements IParticipant{
	
	IChatRoom chatroom;
	String name;

	public Participant(String name, IchatRoom chatroom) {
		this.name = name;
		this.chatroom = chatroom;
	}
	
	public String name() throws RemoteException{
		return name;
	}
	
	public void receive(String name, String msg) throws RemoteException{
		System.out.println("Participant " + this.name + " received " + msg + " from " + name);
	}
}
