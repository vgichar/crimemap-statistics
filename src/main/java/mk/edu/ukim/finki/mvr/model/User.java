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
    
    private String email;

    private String password;
    
    // PUBLIC       // Public events only
    // PS           // Police station events
    // SVR          // Internal affairs sector events
    // MODERATOR    // All events
    // ADMIN        // All events + create-assign users
    private String usertype;
    
    private boolean readOnlyPermission;

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

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
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
