package mk.edu.ukim.finki.mvr.dao;

import java.util.List;

import mk.edu.ukim.finki.mvr.model.User;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void insert(User entity) {
        if (getById(entity.getUserId()) == null) {
            getCurrentSession().save(entity);
        }
    }

    @Override
    public void update(User entity) {
        User u = getById(entity.getUserId());
        if (u != null) {
            u.update(entity);
            getCurrentSession().update(u);
        }
    }

    @Override
    public void insertOrUpdate(User entity) {
        User u = getById(entity.getUserId());
        if(u == null){
            insert(entity);
        }else{
            update(u);
        }
    }

    @Override
    public void delete(int id) {
        User u = getById(id);
        if (u != null) {
            getCurrentSession().delete(u);
        }
    }

    @Override
    public User getById(int id) {
        return (User) getCurrentSession().get(User.class, id);
    }

    @Override
    public List<User> queryAll() {
        return (List<User>) getCurrentSession().createQuery("from Users").list();
    }

    @Override
    public User getByName(String name) {
        Query q = getCurrentSession().createQuery("from Users where name = :un")
                .setParameter("un", name);
        return (User) q.uniqueResult();
    }

    @Override
    public User getByEmail(String email) {
        Query q = getCurrentSession().createQuery("from Users where email = :email")
                .setParameter("email", email);
        return (User) q.uniqueResult();
    }

    @Override
    public List<User> queryByPS(String PS) {
        Query q = getCurrentSession().createQuery("from Users where PS = :PS")
                .setParameter("PS", PS);
        return (List<User>) q.list();
    }

    @Override
    public List<User> queryBySVR(String SVR) {
        Query q = getCurrentSession().createQuery("from Users where SVR = :SVR")
                .setParameter("SVR", SVR);
        return (List<User>) q.list();
    }
}
