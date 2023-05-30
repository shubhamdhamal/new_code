import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RPSServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            RPSImpl game = new RPSImpl();
            Naming.rebind("rmi://localhost/RPSGame", game);
            System.out.println("Server started.");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
