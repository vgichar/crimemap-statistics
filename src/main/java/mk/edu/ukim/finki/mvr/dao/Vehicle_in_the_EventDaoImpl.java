package mk.edu.ukim.finki.mvr.dao;

import java.util.List;

import mk.edu.ukim.finki.mvr.model.Vehicle_in_the_Event;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Vehicle_in_the_EventDaoImpl implements Vehicle_in_the_EventDao {

	  @Autowired
	  private SessionFactory sessionFactory;

	  private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
      }

	@SuppressWarnings("unchecked")
	public List<Vehicle_in_the_Event> queryAll() {
		return (List<Vehicle_in_the_Event>)getCurrentSession().createQuery("from Vehicle_in_the_Event").list();
	}

	public Vehicle_in_the_Event getById(int id) {
		return (Vehicle_in_the_Event)getCurrentSession().get(Vehicle_in_the_Event.class, id);
	}
	  
}
