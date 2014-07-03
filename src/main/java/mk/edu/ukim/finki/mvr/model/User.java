package mk.edu.ukim.finki.mvr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "Users")
public class User {

    @Id
    @GeneratedValue
    private int userId;

    private String name;
    
    private String email;

    private String password;
    
    @ManyToOne
    private Usertype usertype;
    
    private boolean readOnlyPermission;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usertype getUsertype() {
        return usertype;
    }

    public void setUsertype(Usertype usertype) {
        this.usertype = usertype;
    }

    public boolean getReadOnlyPermission() {
        return readOnlyPermission;
    }

    public void setReadOnlyPermission(boolean readOnlyPermission) {
        this.readOnlyPermission = readOnlyPermission;
    }
    
    public void update(User u){
        this.name = u.getName();
        this.email = u.getEmail();
        this.password = u.getPassword();
        this.usertype = u.getUsertype();
        this.readOnlyPermission = u.getReadOnlyPermission();
    }
}
