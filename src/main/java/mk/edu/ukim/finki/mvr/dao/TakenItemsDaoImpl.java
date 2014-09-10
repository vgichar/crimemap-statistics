package mk.edu.ukim.finki.mvr.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mk.edu.ukim.finki.mvr.model.TakenItems;

@Repository
public class TakenItemsDaoImpl implements TakenItemsDao{

	@Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
	
	@SuppressWarnings("unchecked")
	public List<TakenItems> queryAllItems() {
		// TODO Auto-generated method stub
		return (List<TakenItems>)getCurrentSession().createQuery("from TakenItems").list();
	}

	public TakenItems getItemById(int id) {
		// TODO Auto-generated method stub
		return (TakenItems)getCurrentSession().get(TakenItems.class,id);
	}

}
