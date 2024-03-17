package chatserverv3.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;

import chatserverv3.interfaces.IChatRoom;
import chatserverv3.interfaces.IParticipant;


public class Client {
	
	private static Scanner s = new Scanner(System.in);
	
	public static IParticipant connect() throws RemoteException, NotBoundException{
		Registry registry = LocateRegistry.getRegistry("localhost",9999);
		
		System.out.println("What is your name : ");
		String name = s.nextLine();
		
		System.out.println("Type index of desired chatroom : ");
		String chatroomIndex = s.nextLine();
		int index = Integer.valueOf(chatroomIndex);
		
		IChatRoom chatroom = (IChatRoom) registry.lookup("chatroom n°" + index);
		IParticipant newParticipant = new Participant(name, chatroom);
		chatroom.connect(newParticipant);
		return newParticipant;
	}
	
	public static void main(String[] args) {
		try {
			
			IParticipant participant = connect();
			
			while(true) {
				System.out.println("Send a message : ");	
				String msg = s.nextLine();
				try {
					participant.getChatRoom().send(participant, msg);
				}
				catch(RemoteException e) {
					System.out.println("Server unavailable wait 5s");
					Thread.sleep(5000);
					try {
						participant = connect();
					}catch(Exception ex) {
						ex.printStackTrace();
						System.exit(-1);
					}
					
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
