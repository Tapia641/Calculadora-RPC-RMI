import java.rmi.registry.LocateRegistry;;
import java.rmi.registry.Registry;;

public class Cliente {
    private Cliente() {
    }

    public static void main(String[] args) {
        String host = (args.length < 1) ? null : args[0];

        try {
            Registry registry = LocateRegistry.getRegistry(host);

            /*
             * ALTERNATIVA .getRegistry(host, port);
             */

            Suma stub = (Suma) registry.lookup("Suma");
            int x = 5, y = 4;
            int response = stub.Suma(x, y);
            System.out.println("Respuesta de sumar " + x + " + " + y + " : " + response);
        } catch (Exception e) {
            System.err.println("Exception of Client: " + e.toString());
            e.printStackTrace();
        }
    }
}
