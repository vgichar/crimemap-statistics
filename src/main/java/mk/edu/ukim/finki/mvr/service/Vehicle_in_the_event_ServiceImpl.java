package mk.edu.ukim.finki.mvr.service;

import java.util.List;

import mk.edu.ukim.finki.mvr.dao.EventDao;
import mk.edu.ukim.finki.mvr.dao.VehicleDao;
import mk.edu.ukim.finki.mvr.dao.Vehicle_in_the_EventDao;
import mk.edu.ukim.finki.mvr.model.Event;
import mk.edu.ukim.finki.mvr.model.Vehicle;
import mk.edu.ukim.finki.mvr.model.Vehicle_in_the_Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Vehicle_in_the_event_ServiceImpl implements Vehicle_in_the_Event_Service {

	@Autowired
	Vehicle_in_the_EventDao vehicle_in_the_EventDao;
	
	@Autowired
	VehicleDao vehicleDao;
	
	@Autowired
	EventDao eventDao;
	
	public List<Vehicle_in_the_Event> queryAll() {
		return vehicle_in_the_EventDao.queryAll();
	}

	public Vehicle_in_the_Event getById(int id) {
		return vehicle_in_the_EventDao.getById(id);
	}

	public void addVehicle(Vehicle v, Vehicle_in_the_Event v1) {
		if(vehicleDao.getById(v.getId())!=null)
		{
			v1.getVehicles().add(v);
		}
	}

	
	
	public void addEvent(Event e, Vehicle_in_the_Event v) {
		if(eventDao.getEventById(e.getId())!=null)
		{
			v.getEvents().add(e);
		}
	}

	public void removeVehicle(Vehicle v, Vehicle_in_the_Event v1) {
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

	public void removeEvent(Event e, Vehicle_in_the_Event v) {
		if(v.getEvents().contains(e) && (eventDao.getEventById(e.getId())!=null))
		{
			for(int i=0;i<v.getEvents().size();i++)
			{
				if(v.getEvents().get(i).getId()==e.getId())
				{
					v.getEvents().remove(i);
				}
			}
		}
	}

}
