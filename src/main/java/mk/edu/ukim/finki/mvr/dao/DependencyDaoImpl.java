package mk.edu.ukim.finki.mvr.dao;

import java.util.List;

import mk.edu.ukim.finki.mvr.model.Dependency;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DependencyDaoImpl implements DependencyDao {

	@Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

	@SuppressWarnings("unchecked")
	public List<Dependency> queryAll() {
		return (List<Dependency>)getCurrentSession().createQuery("from Dependency").list();
	}

	public Dependency getById(String key, String value) {
		//Treba da se proveri
		String [] s=new String[2];
		s[0]=key;
		s[1]=value;
		return (Dependency)getCurrentSession().createQuery("from Dependency where id.list.id.key = :key and id.list.id.value = :key").setParameterList("key", s);
	}

}
