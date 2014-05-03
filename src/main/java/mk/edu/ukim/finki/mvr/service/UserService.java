package mk.edu.ukim.finki.mvr.service;


import java.util.List;
import mk.edu.ukim.finki.mvr.model.User;

public interface UserService {
    public boolean register(User entity);
    public boolean login(User entity);
    public void delete(int id);
    public void update(User entity);
    public User getById(int id);
    public User getByName(String name);
    public User getByEmail(String email);
    public List<User> queryByUsertype(String usertype);
    public List<User> queryAll();
}
