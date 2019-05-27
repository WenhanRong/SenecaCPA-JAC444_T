
import java.rmi.RemoteException;

public class CarImplementation extends java.rmi.server.UnicastRemoteObject implements CarInterface {


    CarImplementation() throws RemoteException {
        super();
    }

    public Car generatePlate(Car c) throws java.rmi.RemoteException {
        c.getRegistered(Integer.toString(c.hashCode()));
        return c;
    }
}
