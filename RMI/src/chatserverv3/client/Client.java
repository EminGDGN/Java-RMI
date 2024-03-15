package chatserverv3.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;

import chatserverv3.interfaces.IChatRoom;
import chatserverv3.interfaces.IParticipant;


public class Client {
	
	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry("localhost",9999);
			Scanner s = new Scanner(System.in);
			
			System.out.println("What is your name : ");
			String name = s.nextLine();
			
			System.out.println("Type index of desired chatroom : ");
			String chatroomIndex = s.nextLine();
			int index = Integer.valueOf(chatroomIndex);
			
			IChatRoom chatroom = (IChatRoom) registry.lookup("chatroom n°" + index);
			IParticipant participant = new Participant(name, chatroom);
					
			System.out.println("Send a message : ");	
			String msg = s.nextLine();
			participant.getChatRoom().send(participant, msg);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
