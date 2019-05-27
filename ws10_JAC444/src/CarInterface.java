import java.rmi.RemoteException;

public interface CarInterface extends java.rmi.Remote {

    Car generatePlate(Car c) throws RemoteException;
}
