import java.rmi.Naming;

public class CarServer {
    public CarServer(){
        try{
            CarInterface car = new CarImplementation();
            Naming.rebind("rmi://localhost:1099/CarRegistration", car);
            System.out.println("Server Started");
        } catch(Throwable e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args){
        new CarServer();
    }
}
