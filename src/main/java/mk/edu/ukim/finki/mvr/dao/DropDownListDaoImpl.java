package mk.edu.ukim.finki.mvr.dao;

import java.util.List;

import mk.edu.ukim.finki.mvr.model.DropDownList;
import mk.edu.ukim.finki.mvr.model.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DropDownListDaoImpl implements DropDownListDao {

    @Autowired
    private SessionFactory sessionFactory;
    

    @Override
    public boolean insert(DropDownList entity) {
        if (getByKeyAndValue(entity.getKey(), entity.getValue()) == null) {
            getCurrentSession().save(entity);
            return true;
        }
        return false;
    }

    @Override
    public void update(DropDownList entity) {
        DropDownList u = getByKeyAndValue(entity.getKey(), entity.getValue());
        if (u != null) {
            u.update(entity);
            getCurrentSession().update(u);
        }
    }

    @Override
    public void insertOrUpdate(DropDownList entity) {
        DropDownList u = getByKeyAndValue(entity.getKey(), entity.getValue());
        if(u == null){
            insert(entity);
        }else{
            update(u);
        }
    }

    @Override
    public void delete(String key, String value) {
        DropDownList u = getByKeyAndValue(key, value);
        if (u != null) {
            getCurrentSession().delete(u);
        }
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<DropDownList> queryAll() {
        return (List<DropDownList>) getCurrentSession().createQuery("from DropDownList").list();
    }

    @Override
    public List<DropDownList> queryByKey(String key) {
        return (List<DropDownList>) getCurrentSession().createQuery("from DropDownList where ddlKey = :key").setParameter("key", key).list();
    }

    @Override
    public DropDownList getByKeyAndValue(String key, String value) {
        return (DropDownList) getCurrentSession().createQuery("from DropDownList where ddlKey = :key and ddlValue = :value").setParameter("key", key).setParameter("value", value).uniqueResult();
    }

    @Override
    public List<DropDownList> getByDependencyKeyAndValue(String key, String value) {
        return (List<DropDownList>) getCurrentSession().createQuery("from DropDownList where dependencyKey = :key and dependencyValue = :value").setParameter("key", key).setParameter("value", value).list();
    }
}
