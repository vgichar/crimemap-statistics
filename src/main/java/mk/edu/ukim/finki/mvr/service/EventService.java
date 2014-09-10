package mk.edu.ukim.finki.mvr.service;

import java.util.Date;
import java.util.List;

import mk.edu.ukim.finki.mvr.model.Event;
import mk.edu.ukim.finki.mvr.model.Person;
import mk.edu.ukim.finki.mvr.model.TakenItems;
import mk.edu.ukim.finki.mvr.model.Vehicle_in_the_Event;

public interface EventService {

	public Event getById(int id);
	
	public List<Event> queryAll();
	
	public List<Event> getByBiltenDate(Date d);
	
	public List<Event> getByLocation (String location);
	
	public void addPersonInEvent(Person p,Event e);
	
	public void removePersonFromEvent (Person p, Event e);
	
	public void addTakenItemToEvent (TakenItems t,Event e);
	
	public void removeTakenItemFromEvent(TakenItems t,Event e);
	
	public void addVehicleInEvent(Vehicle_in_the_Event v,Event e);
	
	public void removeVehicleFromEvent (Vehicle_in_the_Event v, Event e);
}
