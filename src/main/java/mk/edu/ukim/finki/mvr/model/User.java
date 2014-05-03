package mk.edu.ukim.finki.mvr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "User")
public class User {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String password;
    
    private String email;
    
    private String usertype;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
    
    public void update(User u){
        this.name = u.getName();
        this.email = u.getEmail();
        this.password = u.getPassword();
        this.usertype = u.getUsertype();
    }
}
