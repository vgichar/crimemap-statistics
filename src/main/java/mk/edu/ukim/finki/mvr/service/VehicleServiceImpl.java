package mk.edu.ukim.finki.mvr.service;

import java.util.List;

import mk.edu.ukim.finki.mvr.dao.VehicleDao;
import mk.edu.ukim.finki.mvr.model.Vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleDao vehicleDao;

	public List<Vehicle> gueryAll() {
		return vehicleDao.queryAll();
	}

	public Vehicle getVehicleById(int id) {
		return vehicleDao.getById(id);
	}

	public Vehicle getVehicleByPlate(String plate) {
		return vehicleDao.getByPlate(plate);
	}
	
	
}
