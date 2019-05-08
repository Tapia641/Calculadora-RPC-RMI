import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/*HACER LA CALCULADORA.JAVA T3.2 */
public class Servidor implements Calculadora {
    public Servidor() {
    }

    public int Suma(int a, int b) {
        return a + b;
    }

    
    public int Resta(int a, int b) {
        return a - b;
    }

    public int Multiplica(int a, int b) {
        return a * b;
    }

    public float Divide(float a, float b) {
        return a / b;
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
            Calculadora stub = (Calculadora) UnicastRemoteObject.exportObject(obj, 0);

            /* LIGAMOS EL OBJETO REMOTO EN EL REGISTRO */
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Calculadora", stub);
            System.err.println("Servidor listo...");
        } catch (Exception e) {
        }
    }
}