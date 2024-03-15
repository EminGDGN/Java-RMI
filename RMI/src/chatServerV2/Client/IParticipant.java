package chatServerV2.Client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IParticipant extends Remote{

	
	public String name() throws RemoteException;
	
	public void receive(String name, String msg) throws RemoteException;
	
}
