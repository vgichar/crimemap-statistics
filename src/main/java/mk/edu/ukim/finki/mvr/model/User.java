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
    private UserRole userRole;
    
    private boolean readOnlyPermission;
    
    private String PS;
    
    private String SVR;

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

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public boolean getReadOnlyPermission() {
        return readOnlyPermission;
    }

    public void setReadOnlyPermission(boolean readOnlyPermission) {
        this.readOnlyPermission = readOnlyPermission;
    }

    public String getPS() {
        return PS;
    }

    public void setPS(String PS) {
        this.PS = PS;
    }

    public String getSVR() {
        return SVR;
    }

    public void setSVR(String SVR) {
        this.SVR = SVR;
    }
    
    public void update(User u){
        this.name = u.getName();
        this.email = u.getEmail();
        this.password = u.getPassword();
        this.userRole = u.getUserRole();
        this.readOnlyPermission = u.getReadOnlyPermission();
        this.PS = u.getPS();
        this.SVR = u.getSVR();
    }
}
