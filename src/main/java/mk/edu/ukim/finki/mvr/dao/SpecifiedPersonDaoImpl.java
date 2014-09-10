package mk.edu.ukim.finki.mvr.dao;

import java.util.List;

import mk.edu.ukim.finki.mvr.model.SpecifiedPerson;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SpecifiedPersonDaoImpl implements SpecifiedPersonDao {

	@Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

	@SuppressWarnings("unchecked")
	public List<SpecifiedPerson> queryAll() {
		return (List<SpecifiedPerson>)getCurrentSession().createQuery("from SpecifiedPerson").list();
	}

	public SpecifiedPerson getById(int id) {
		return (SpecifiedPerson)getCurrentSession().get(SpecifiedPerson.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<SpecifiedPerson> getByHomeAddress(String address) {
		return (List<SpecifiedPerson>)getCurrentSession().createQuery("from SpecifiedPerson where homeAddress = :add").setParameter("add", address).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<SpecifiedPerson> getByResidenceAddress(String address) {
		return (List<SpecifiedPerson>)getCurrentSession().createQuery("from SpecifiedPerson where residenceAddress = :add").setParameter("add", address).uniqueResult();
	}
}
