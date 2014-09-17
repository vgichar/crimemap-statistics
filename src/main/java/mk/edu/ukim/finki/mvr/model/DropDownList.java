package mk.edu.ukim.finki.mvr.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "DropDownList")
public class DropDownList implements Serializable{

    @Id
    @Column(name = "ddlKey")
    private String key;

    @Id
    @Column(name = "ddlValue")
    private String value;
    
    private String dependencyKey;
    
    private String dependencyValue;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDependencyKey() {
        return dependencyKey;
    }

    public void setDependencyKey(String dependencyKey) {
        this.dependencyKey = dependencyKey;
    }

    public String getDependencyValue() {
        return dependencyValue;
    }

    public void setDependencyValue(String dependencyValue) {
        this.dependencyValue = dependencyValue;
    }

    public void update(DropDownList ddl){
        this.key = ddl.getKey();
        this.value = ddl.getValue();
        this.dependencyKey = ddl.getDependencyKey();
        this.dependencyValue = ddl.getDependencyKey();
    }
}
