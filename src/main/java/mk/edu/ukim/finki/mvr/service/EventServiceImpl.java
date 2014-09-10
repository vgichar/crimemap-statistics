package mk.edu.ukim.finki.mvr.service;

import java.util.Date;
import java.util.List;

import mk.edu.ukim.finki.mvr.dao.EventDao;
import mk.edu.ukim.finki.mvr.dao.PersonDao;
import mk.edu.ukim.finki.mvr.dao.TakenItemsDao;
import mk.edu.ukim.finki.mvr.dao.Vehicle_in_the_EventDao;
import mk.edu.ukim.finki.mvr.model.Event;
import mk.edu.ukim.finki.mvr.model.Person;
import mk.edu.ukim.finki.mvr.model.TakenItems;
import mk.edu.ukim.finki.mvr.model.Vehicle_in_the_Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class EventServiceImpl implements EventService {

	@Autowired
	EventDao eventDao;

	@Autowired
	PersonDao personDao;
	
	@Autowired
	TakenItemsDao takenItemsDao;
	
	@Autowired
	Vehicle_in_the_EventDao vehicle_in_the_Event;
	
	public Event getById(int id) {
		return eventDao.getEventById(id);
	}

	public List<Event> queryAll() {
		return eventDao.queryAllEvents();
	}

	public List<Event> getByBiltenDate(Date d) {
		return eventDao.queryEventsByBiltenDate(d);
	}

	public List<Event> getByLocation(String location) {
		return eventDao.queryEventsByLocation(location);
	}

	public void addPersonInEvent(Person p, Event e) {
		if(personDao.getPersonById(p.getId())!=null)
		{
			e.getPersons().add(p);
		}
	}

	public void removePersonFromEvent(Person p, Event e) {
		if(e.getPersons().contains(p) && (personDao.getPersonById(p.getId())!=null))
		{
			for(int i=0;i<e.getPersons().size();i++)
			{
				if(e.getPersons().get(i).getId()==p.getId())
				{
					e.getPersons().remove(i);
				}
			}
		}
	}

	public void addTakenItemToEvent(TakenItems t, Event e) {
		if(takenItemsDao.getItemById(t.getId())!=null)
		{
			e.getItems().add(t);
		}
	}

	public void removeTakenItemFromEvent(TakenItems t, Event e) {
		if(e.getItems().contains(e) &&(takenItemsDao.getItemById(t.getId())!=null))
		{
			for(int i=0;i<e.getItems().size();i++)
			{
				if(e.getItems().get(i).getId()==t.getId())
				{
					e.getItems().remove(i);
				}
			}
		}
	}

	public void addVehicleInEvent(Vehicle_in_the_Event v, Event e) {
		if(vehicle_in_the_Event.getById(v.getId())!=null)
		{
			e.getVehicles().add(v);
		}
		
	}

	public void removeVehicleFromEvent(Vehicle_in_the_Event v, Event e) {
		if(e.getVehicles().contains(v) && (vehicle_in_the_Event.getById(v.getId())!=null))
		{
			for(int i=0;i<e.getVehicles().size();i++)
			{
				if(e.getVehicles().get(i).getId()==v.getId())
				{
					e.getVehicles().remove(i);
				}
			}
		}
	}
	
}
