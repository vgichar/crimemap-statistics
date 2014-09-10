package mk.edu.ukim.finki.mvr.dao;

import java.util.List;

import mk.edu.ukim.finki.mvr.model.Person_Vehicles;

public interface Person_VehiclesDao {

	public List<Person_Vehicles> queryAll();
	
	public Person_Vehicles getById(int id);

	public Person_Vehicles getByOwnerId (int id);
}
