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

            /* ENLAZAMOS CON EL SERVIDOR */
            Calculadora stub = (Calculadora) registry.lookup("Calculadora");

            /* DECLARAMOS LAS VARIABLES A MANDAR AL SERVIDOR */
            int a = 7, b = 4;

            /* HACEMOS USO DE LAS FUNCIONES DEL SERVIDOR */
            int response = stub.Suma(a, b);
            int response2 = stub.Resta(a, b);
            int response3 = stub.Multiplica(a, b);
            float response4 = stub.Divide((float)a, (float)b);

            /* IMPRIMIMOS EL RESULTADO DE LAS FUNCIONES */
            System.out.println("Respuesta de sumar " + a + " + " + b + " : " + response);
            System.out.println("Respuesta de restar " + a + " - " + b + " : " + response2);
            System.out.println("Respuesta de multiplicar " + a + " * " + b + " : " + response3);
            System.out.println("Respuesta de dividir " + a + " / " + b + " : " + response4);

        } catch (Exception e) {
            System.err.println("Exception of Client: " + e.toString());
            e.printStackTrace();
        }
    }
}
