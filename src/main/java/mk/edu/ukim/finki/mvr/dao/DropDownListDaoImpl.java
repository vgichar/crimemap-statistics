package mk.edu.ukim.finki.mvr.dao;

import java.util.List;

import mk.edu.ukim.finki.mvr.model.DropDownList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DropDownListDaoImpl implements DropDownListDao {

	@Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

	@SuppressWarnings("unchecked")
	public List<DropDownList> queryAll() {
		return (List<DropDownList>)getCurrentSession().createQuery("from DropDownList").list();
	}

	public DropDownList getById(String key, String value) {
		//Ne sum siguren treba da se testira
		String [] s=new String [2];
		s[0]=key;
		s[1]=value;
		return (DropDownList)getCurrentSession().createQuery("from DropDownList where id.key = :key and id.value = :key").setParameterList("key", s).uniqueResult();
	}
}
