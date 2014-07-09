package mk.edu.ukim.finki.mvr.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.codehaus.jackson.annotate.JsonIgnore;

@Entity(name = "UserRoles")
public class UserRole {

    // PUBLIC       // Public events only
    // PS           // Police station events
    // SVR          // Internal affairs sector events
    // MODERATOR    // All events
    // ADMIN        // All events + create-assign users
    
    @Id
    private String role;

    @OneToMany(mappedBy = "userRole")
    @JsonIgnore
    private List<User> users;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
