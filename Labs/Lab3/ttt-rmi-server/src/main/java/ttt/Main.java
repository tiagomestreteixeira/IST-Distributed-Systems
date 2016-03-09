package ttt;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
	public static void main(String[] args) {
		int registryPort = 8080;
        System.out.println("Main OK");
        try{
            TTTService ttt = new TTTServant();
            System.out.println("After create");
            
            Registry reg = LocateRegistry.createRegistry(registryPort);
			reg.rebind("TTT", ttt);
           
            System.out.println("TTT server ready");
            System.out.println("Press ENTER to close server.");
            System.in.read();
        } catch(Exception e) {
            System.out.println("TTT server main " + e.getMessage());
        }
	}
}
