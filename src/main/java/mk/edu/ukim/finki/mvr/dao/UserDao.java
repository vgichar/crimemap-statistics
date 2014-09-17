package mk.edu.ukim.finki.mvr.dao;

import java.util.List;
import mk.edu.ukim.finki.mvr.model.User;

public interface UserDao extends CrudDao<User>{

    public User getByName(String name);
    public User getByEmail(String password);
    public List<User> queryByPS(String PS);;
    public List<User> queryBySVR(String SVR);
}
