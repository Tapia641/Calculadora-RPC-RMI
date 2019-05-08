import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculadora extends Remote {
    int Suma(int a, int b) throws RemoteException;
    
    int Resta(int a, int b) throws RemoteException;
    
    int Multiplica(int a, int b) throws RemoteException;

    float Divide(float a, float b) throws RemoteException;
}