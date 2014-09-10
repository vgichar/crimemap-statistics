package mk.edu.ukim.finki.mvr.service;

import java.util.List;

import mk.edu.ukim.finki.mvr.model.Vehicle;

public interface VehicleService {

	public List<Vehicle> gueryAll();
	
	public Vehicle getVehicleById(int id);
	
	public Vehicle getVehicleByPlate(String plate);
}
