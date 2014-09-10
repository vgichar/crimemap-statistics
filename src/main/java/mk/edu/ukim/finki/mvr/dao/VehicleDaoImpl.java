package mk.edu.ukim.finki.mvr.dao;

import java.util.List;

import mk.edu.ukim.finki.mvr.model.Vehicle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VehicleDaoImpl implements VehicleDao{

	@Autowired
	 private SessionFactory sessionFactory;

	 private Session getCurrentSession() {
		 return sessionFactory.getCurrentSession();
	    }

	@SuppressWarnings("unchecked")
	public List<Vehicle> queryAll() {
		return (List<Vehicle>)getCurrentSession().createQuery("from Vehicle").list();
	}

	public Vehicle getById(int id) {
		return (Vehicle)getCurrentSession().get(Vehicle.class, id);
	}

	public Vehicle getByPlate(String plate) {
		return (Vehicle)getCurrentSession().createQuery("from Vehicle where registrationPlates = :pl").setParameter("pl", plate).uniqueResult();
	}

	 
}
