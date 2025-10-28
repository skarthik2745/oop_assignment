package oops4;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            // Start RMI registry programmatically (this replaces 'rmiregistry' command)
            LocateRegistry.createRegistry(2055);
            System.out.println("RMI Registry started automatically.");

            ArithmeticImpl obj = new ArithmeticImpl();

            Registry reg = LocateRegistry.getRegistry();
            reg.rebind("ArithmeticService", obj);

            System.out.println("RMI Server is running and bound to registry...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
