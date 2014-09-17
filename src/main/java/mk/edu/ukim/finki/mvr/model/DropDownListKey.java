package mk.edu.ukim.finki.mvr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "DropDownListKey")
public class DropDownListKey {

    @Id
    @Column(name = "ddlkKey")
    private String key;
    
    private String dependency;
    
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    
    public String getDependency() {
        return dependency;
    }

    public void setDependency(String dependency) {
        this.dependency = dependency;
    }
    
    public void update(DropDownListKey entity){
        this.key = entity.key;
        this.dependency = entity.dependency;
    }
}
