package mk.edu.ukim.finki.mvr.dao;

import java.util.List;

import mk.edu.ukim.finki.mvr.model.UnspecifiedPerson;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UnspecifiedPersonDaoImpl implements UnspecifiedPersonDao {

	@Autowired
	 private SessionFactory sessionFactory;

	 private Session getCurrentSession() {
		 return sessionFactory.getCurrentSession();
	    }

	@SuppressWarnings("unchecked")
	public List<UnspecifiedPerson> queryAll() {
		return (List<UnspecifiedPerson>)getCurrentSession().createQuery("from UnspecifiedPerson").list();
	}

	public UnspecifiedPerson queryById(int id) {
		return (UnspecifiedPerson)getCurrentSession().get(UnspecifiedPerson.class, id);
	}
}
