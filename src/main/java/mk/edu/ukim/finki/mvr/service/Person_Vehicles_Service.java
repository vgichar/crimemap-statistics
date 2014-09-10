package mk.edu.ukim.finki.mvr.service;

import java.util.List;

import mk.edu.ukim.finki.mvr.model.Person_Vehicles;
import mk.edu.ukim.finki.mvr.model.Vehicle;

public interface Person_Vehicles_Service {

	public List<Person_Vehicles> queryAll();
	
	public Person_Vehicles getById(int id);
	
	public Person_Vehicles getByOwnerId (int id);
	
	public void addVehicle (Vehicle v,Person_Vehicles v1);
	
	public void removeVehicle(Vehicle v,Person_Vehicles v1);
}
