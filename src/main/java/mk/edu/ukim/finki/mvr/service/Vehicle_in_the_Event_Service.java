package mk.edu.ukim.finki.mvr.service;

import java.util.List;

import mk.edu.ukim.finki.mvr.model.Event;
import mk.edu.ukim.finki.mvr.model.Vehicle;
import mk.edu.ukim.finki.mvr.model.Vehicle_in_the_Event;

public interface Vehicle_in_the_Event_Service {

	public List<Vehicle_in_the_Event> queryAll();
	
	public Vehicle_in_the_Event getById(int id);
	
	public void addVehicle (Vehicle v,Vehicle_in_the_Event v1);
	
	public void removeVehicle(Vehicle v,Vehicle_in_the_Event v1);
	
	public void addEvent (Event e,Vehicle_in_the_Event v);
	
	public void removeEvent(Event e,Vehicle_in_the_Event v);
}
