package mk.edu.ukim.finki.mvr.service;

import java.util.List;
import mk.edu.ukim.finki.mvr.model.*;

public interface UserService {
    public User register(User entity);
    public User login(User entity);
    public void delete(int id);
    public void update(User entity);
    public User getById(int id);
    public User getByName(String name);
    public User getByEmail(String email);
    public List<User> queryAll();
    public List<UserRole> queryAllUserRoles();
    public List<User> queryUsersByUserRole(UserRole usertype);
    public List<User> queryUsersByPS(String PS);
    public List<User> queryUsersBySVR(String SVR);
}
