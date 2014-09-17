package mk.edu.ukim.finki.mvr.dao;

import java.util.List;
import mk.edu.ukim.finki.mvr.model.DropDownList;
import mk.edu.ukim.finki.mvr.model.DropDownListKey;
import mk.edu.ukim.finki.mvr.model.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DropDownListKeyDaoImpl implements DropDownListKeyDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void insert(DropDownListKey entity) {
        if (getByKey(entity.getKey()) == null) {
            getCurrentSession().save(entity);
        }
    }

    @Override
    public void update(DropDownListKey entity) {
        DropDownListKey u = getByKey(entity.getKey());
        if (u != null) {
            u.update(entity);
            getCurrentSession().update(u);
        }
    }

    @Override
    public void insertOrUpdate(DropDownListKey entity) {
        DropDownListKey u = getByKey(entity.getKey());
        if (u == null) {
            insert(entity);
        } else {
            update(u);
        }
    }

    @Override
    public void delete(String key) {
        DropDownListKey u = getByKey(key);
        if (u != null) {
            getCurrentSession().delete(u);
        }
    }

    @Override
    public List<DropDownListKey> queryAll() {
        return (List<DropDownListKey>) getCurrentSession().createQuery("from DropDownListKey").list();
    }

    @Override
    public DropDownListKey getByKey(String key) {
        return (DropDownListKey) getCurrentSession().createQuery("from DropDownListKey where ddlKey = :key").setParameter("key", key).list();
    }

    @Override
    public DropDownListKey getByDependency(String depKey) {
        return (DropDownListKey) getCurrentSession().createQuery("from DropDownListKey where dependency = :dependencyKey").setParameter("dependencyKey", depKey).uniqueResult();
    }
}
