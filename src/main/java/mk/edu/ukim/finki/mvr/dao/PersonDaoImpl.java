package mk.edu.ukim.finki.mvr.dao;

import java.util.List;

import mk.edu.ukim.finki.mvr.model.Person;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDaoImpl implements PersonDao {

	 @Autowired
	 private SessionFactory sessionFactory;

	 private Session getCurrentSession() {
		 return sessionFactory.getCurrentSession();
	    }

	@SuppressWarnings("unchecked")
	public List<Person> queryAllPersons() {
		// TODO Auto-generated method stub
		return (List<Person>)getCurrentSession().createQuery("from Person").list();
	}

	public Person getPersonById(int id) {
		// TODO Auto-generated method stub
		return (Person)getCurrentSession().get(Person.class, id);
	}
	 
}
