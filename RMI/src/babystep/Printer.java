package babystep;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Printer extends UnicastRemoteObject implements IPrinter{

	
	public Printer() throws RemoteException{
	}
	
	@Override
	public void print(String s) throws RemoteException{
		// TODO Auto-generated method stub
		System.out.println(s);
	}

}
