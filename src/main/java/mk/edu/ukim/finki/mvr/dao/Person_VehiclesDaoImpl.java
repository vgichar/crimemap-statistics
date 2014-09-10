package mk.edu.ukim.finki.mvr.dao;

import java.util.List;

import mk.edu.ukim.finki.mvr.model.Person_Vehicles;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Person_VehiclesDaoImpl implements Person_VehiclesDao {

	@Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

	@SuppressWarnings("unchecked")
	public List<Person_Vehicles> queryAll() {
		return (List<Person_Vehicles>)getCurrentSession().createQuery("from Person_Vehicles").list();
	}

	public Person_Vehicles getById(int id) {
		return (Person_Vehicles)getCurrentSession().get(Person_Vehicles.class, id);
	}

	public Person_Vehicles getByOwnerId(int id) {
		//Treba da se proveri ne sum siguren za ova 
		return (Person_Vehicles)getCurrentSession().createQuery("from Person_Vehicles where specifiedPerson.id = :id").setParameter("id", id).uniqueResult();
	}
	
}
