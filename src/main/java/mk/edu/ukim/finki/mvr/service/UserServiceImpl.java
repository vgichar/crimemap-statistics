package mk.edu.ukim.finki.mvr.service;

import java.util.List;

import mk.edu.ukim.finki.mvr.dao.UserDao;
import mk.edu.ukim.finki.mvr.dao.UserRoleDao;
import mk.edu.ukim.finki.mvr.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    
    @Autowired
    UserRoleDao usertypeDao;

    @Override
    public User register(User entity) {
        if(userDao.getByName(entity.getName()) != null || userDao.getByEmail(entity.getEmail()) != null){
            return null;
        }
        userDao.insert(entity);
        return entity;
    }

    @Override
    public User login(User entity) {
        User user = userDao.getByName(entity.getName());
        if(user != null && user.getPassword().equals(entity.getPassword())){
            return user;
        }
        user = userDao.getByEmail(entity.getEmail());
        if(user != null && user.getPassword().equals(entity.getPassword())){
            return user;
        }
        return null;
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public void update(User entity) {
        userDao.update(entity);
    }

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }

    @Override
    public User getByName(String name) {
        return userDao.getByName(name);
    }

    @Override
    public User getByEmail(String email) {
        return userDao.getByEmail(email);
    }

    @Override
    public List<User> queryAll() {
        return userDao.queryAll();
    }

    @Override
    public List<UserRole> queryAllUserRoles() {
        return usertypeDao.queryAllUserRoles();
    }

    @Override
    public List<User> queryUsersByUserRole(UserRole usertype) {
        return usertypeDao.queryUsersByUserRole(usertype);
    }

    @Override
    public List<User> queryUsersByPS(String PS) {
        return userDao.queryByPS(PS);
    }

    @Override
    public List<User> queryUsersBySVR(String SVR) {
        return userDao.queryBySVR(SVR);
    }
}
