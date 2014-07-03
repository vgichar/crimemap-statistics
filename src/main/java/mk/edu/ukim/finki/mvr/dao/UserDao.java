package mk.edu.ukim.finki.mvr.dao;

import mk.edu.ukim.finki.mvr.model.User;

public interface UserDao extends CrudDao<User>{

    public User getByName(String name);
    public User getByEmail(String password);
}
