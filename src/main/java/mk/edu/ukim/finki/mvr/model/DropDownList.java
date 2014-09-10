package mk.edu.ukim.finki.mvr.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class DropDownList {

	private DropDownListPK id;

	@EmbeddedId
	public DropDownListPK getId() {
		return id;
	}

	public void setId(DropDownListPK id) {
		this.id = id;
	}
	
}
