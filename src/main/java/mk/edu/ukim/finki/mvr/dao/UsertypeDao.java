package mk.edu.ukim.finki.mvr.dao;

import java.util.List;
import mk.edu.ukim.finki.mvr.model.*;

public interface UsertypeDao {
    public Usertype getUsertypeById(int id);
    public Usertype getUsertypeByText(String role);
    public List<Usertype> queryAllUsertypes();
    public List<User> queryUsersByUsertype(Usertype usertype);
}