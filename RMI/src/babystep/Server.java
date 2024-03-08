package babystep;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	
	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.createRegistry(9999);
			IPrinter printer = new Printer();
			registry.bind("printer", printer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
