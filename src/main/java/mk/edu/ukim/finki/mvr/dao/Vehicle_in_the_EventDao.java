package mk.edu.ukim.finki.mvr.dao;

import java.util.List;

import mk.edu.ukim.finki.mvr.model.Vehicle_in_the_Event;

public interface Vehicle_in_the_EventDao {

	public List<Vehicle_in_the_Event> queryAll();
	
	public Vehicle_in_the_Event getById (int id);
}
