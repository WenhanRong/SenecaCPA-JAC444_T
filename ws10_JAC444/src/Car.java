//The objects of type Car must be serialized so that they could be sent over the sockets
import java.io.*;

import java.io.Serializable;
public class Car implements Serializable{

	private String model;
	private String colour;
	private double mileage;
	private String plate;

	public Car() throws java.rmi.RemoteException {
		super();
	}
	public Car( String brand, String name, double m ) throws java.rmi.RemoteException {
		model = brand;
		colour = name;
		mileage = m;
		plate = "unregistered";
	}

	public String toString(){
		return "Model: " + model + " Colour: " + colour +
				" Mileage: " +  mileage +
				" Plate: " + plate;
	}

	public void getRegistered(String plate) {
		this.plate = plate;
	}
}