import java.rmi.Naming;
import java.rmi.NotBoundException;

public class CarClient {

    public static void main(String[] args) throws java.rmi.RemoteException {
        Car car = new Car("Honda","White",1234);
        System.out.println(car.toString());

        try{
            CarInterface c = (CarInterface) Naming.lookup("rmi://localhost:1099/CarRegistration");
            car = c.generatePlate(car);
            System.out.println(car.toString());

        } catch(Throwable e){
            System.out.println(e);
        }
    }
}
