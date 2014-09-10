package mk.edu.ukim.finki.mvr.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mk.edu.ukim.finki.mvr.model.Event;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EventDaoImpl implements EventDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	public List<Event> queryAllEvents() {
		
		@SuppressWarnings("unchecked")
		List<Event> res=(List<Event>)getCurrentSession().createQuery("from Event").list();
		return res;
	}

	public Event getEventById(int id) {
		// TODO Auto-generated method stub
		Event event=(Event)getCurrentSession().get(Event.class, id);
		return event;
	}

	
	public List<Event> queryEventsByBiltenDate(Date biltenDate) {
		// TODO Auto-generated method stub
		List<Event> allEvents=queryAllEvents();
		List<Event> res=new ArrayList<Event>();
		
		for (Event event : allEvents) {
			if(event.getBiltenDate().toString().equals(biltenDate.toString()))
			{
				res.add(event);
			}
		}
		
		return res;
	}

	public List<Event> queryEventsByLocation(String location) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List <Event> res=(List<Event>)getCurrentSession().createQuery("from Event where location = :loc").setParameter("loc", location).uniqueResult();
		return res;
	}

}
