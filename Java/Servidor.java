import java.rmi.registry.registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.rmi.UnicastRemoteObject;

public class Servidor implements Suma {
    public Servidor() {
    }

    public int Suma(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        try {
            /* PUERTO POR DEFECTO DE REGISTRY */
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            System.out.println("RMI registro listo.");
        } catch (Exception e) {
            System.err.println("Exception RMI of registry: ");
            e.printStackTrace();
        }

        try {
            System.setProperty("java.rmi.server.codebase ", "file:/c:/Temp/Suma/");
            Servidor obj = new Servidor();
            Suma stub = (Suma) UnicastRemoteObject.exportObject(obj, 0);

            /* LIGAMOS EL OBJETO REMOTO EN EL REGISTRO */
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Suma", stub);
            System.err.println("Servidor listo...");
        } catch (Exception e) {
        }
    }
}