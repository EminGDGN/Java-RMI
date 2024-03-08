package babystep;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

	
	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry("localhost",9999);
			IPrinter printer = (IPrinter) registry.lookup("printer");
			printer.print("hello");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
