package mk.edu.ukim.finki.mvr.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Dependency {

	private DependencyPK id;
	
	private String value;

	@EmbeddedId
	public DependencyPK getId() {
		return id;
	}

	public void setId(DependencyPK id) {
		this.id = id;
	}

	@Column(name="value",updatable=false,insertable=false)
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
