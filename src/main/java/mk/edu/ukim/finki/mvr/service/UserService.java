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
    public List<Usertype> queryAllUsertypes();
    public List<User> queryUsersByUsertype(Usertype usertype);
}
