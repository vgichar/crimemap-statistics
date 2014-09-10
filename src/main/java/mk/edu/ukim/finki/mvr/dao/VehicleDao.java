package mk.edu.ukim.finki.mvr.dao;

import java.util.List;

import mk.edu.ukim.finki.mvr.model.Vehicle;

public interface VehicleDao {

	public List<Vehicle> queryAll();
	
	public Vehicle getById(int id);
	
	public Vehicle getByPlate (String plate);
}
