package chatserverv3.client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import chatserverv3.interfaces.IChatRoom;
import chatserverv3.interfaces.IParticipant;


public class Participant extends UnicastRemoteObject implements IParticipant{
	
	private static final long serialVersionUID = 1L;
	IChatRoom chatroom;
	String name;

	public Participant(String name, IChatRoom chatroom2) throws RemoteException{
		this.name = name;
		this.chatroom = chatroom2;
	}
	
	public String name() throws RemoteException{
		return name;
	}
	
	public void receive(String name, String msg) throws RemoteException{
		System.out.println("Participant " + this.name + " received " + msg + " from " + name);
	}

	@Override
	public IChatRoom getChatRoom() throws RemoteException{
		return chatroom;
	}
}
