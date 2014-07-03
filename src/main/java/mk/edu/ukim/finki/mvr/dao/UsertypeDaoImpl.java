package mk.edu.ukim.finki.mvr.dao;

import java.util.List;
import mk.edu.ukim.finki.mvr.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsertypeDaoImpl implements UsertypeDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Usertype getUsertypeById(int id) {
        return (Usertype) getCurrentSession().get(Usertype.class, id);
    }

    @Override
    public Usertype getUsertypeByText(String role) {
        return (Usertype) getCurrentSession().createQuery("from Usertypes where role =: r").setParameter("r", role).uniqueResult();
    }

    @Override
    public List<Usertype> queryAllUsertypes() {
        return getCurrentSession().createQuery("from Usertypes").list();
    }

    @Override
    public List<User> queryUsersByUsertype(Usertype usertype) {
        if (usertype.getUsertypeId() == -1) {
            return getUsertypeByText(usertype.getRole()).getUsers();
        }else{
            return getUsertypeByText(getUsertypeById(usertype.getUsertypeId()).getRole()).getUsers();
        }
    }
}
