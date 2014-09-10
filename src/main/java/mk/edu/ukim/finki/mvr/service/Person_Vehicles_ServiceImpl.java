package mk.edu.ukim.finki.mvr.service;

import java.util.List;

import mk.edu.ukim.finki.mvr.dao.Person_VehiclesDao;
import mk.edu.ukim.finki.mvr.dao.VehicleDao;
import mk.edu.ukim.finki.mvr.model.Person_Vehicles;
import mk.edu.ukim.finki.mvr.model.Vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class Person_Vehicles_ServiceImpl implements Person_Vehicles_Service {

	@Autowired
	Person_VehiclesDao person_vehiclesDao;
	
	@Autowired
	VehicleDao vehicleDao;

	public List<Person_Vehicles> queryAll() {
		return person_vehiclesDao.queryAll();
	}

	public Person_Vehicles getById(int id) {
		return person_vehiclesDao.getById(id);
	}

	public Person_Vehicles getByOwnerId(int id) {
		return person_vehiclesDao.getByOwnerId(id);
	}

	public void addVehicle(Vehicle v, Person_Vehicles v1) {
		if(vehicleDao.getById(v.getId())!=null)
		{
			v1.getVehicles().add(v);
		}
	}

	public void removeVehicle(Vehicle v, Person_Vehicles v1) {
		if(v1.getVehicles().contains(v) && (vehicleDao.getById(v.getId())!=null))
		{
			for(int i=0;i<v1.getVehicles().size();i++)
			{
				if(v1.getVehicles().get(i).getId()==v.getId())
				{
					v1.getVehicles().remove(i);
				}
			}
		}
	}
}
