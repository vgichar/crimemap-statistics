package mk.edu.ukim.finki.mvr.dao;

import java.util.List;
import mk.edu.ukim.finki.mvr.model.*;

public interface UserRoleDao {
    public UserRole getUserRole(String role);
    public List<UserRole> queryAllUserRoles();
    public List<User> queryUsersByUserRole(UserRole usertype);
}