package chatServerV2.Client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import chatServerV2.Interfaces.IParticipant;
import chatServerV2.Interfaces.IChatRoom;


public class Participant extends UnicastRemoteObject implements IParticipant{
	
	private static final long serialVersionUID = 1L;
	IChatRoom chatroom;
	String name;

	public Participant(String name, IChatRoom chatroom) throws RemoteException{
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
