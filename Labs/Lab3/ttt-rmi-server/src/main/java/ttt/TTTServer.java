package ttt;


import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TTTServer {
    public static void main(String args[]) throws RemoteException{
        int registryPort =8090;
        System.out.println("Main OK");
        try {
            TTT tttServant = new TTT();
            System.out.println("After create");

            Registry reg = LocateRegistry.createRegistry(registryPort);
            reg.rebind("ttt-galo", tttServant);
            System.out.println("Server Running");
        }catch(Exception e){
            System.out.println("Server Exception: " + e.toString());
        }

    }
}

