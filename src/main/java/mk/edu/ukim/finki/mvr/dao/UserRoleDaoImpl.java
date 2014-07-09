package mk.edu.ukim.finki.mvr.dao;

import java.util.List;
import mk.edu.ukim.finki.mvr.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRoleDaoImpl implements UserRoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public UserRole getUserRole(String role) {
        return (UserRole) getCurrentSession().createQuery("from UserRoles where role =: r").setParameter("r", role).uniqueResult();
    }

    @Override
    public List<UserRole> queryAllUserRoles() {
        return getCurrentSession().createQuery("from UserRoles").list();
    }

    @Override
    public List<User> queryUsersByUserRole(UserRole userRole) {
            return userRole.getUsers();
    }
}
