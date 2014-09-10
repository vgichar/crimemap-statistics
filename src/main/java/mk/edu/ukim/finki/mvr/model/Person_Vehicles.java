package mk.edu.ukim.finki.mvr.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ForeignKey;

@Entity
public class Person_Vehicles implements Serializable  {

	private int id;
	
	private String comment;
	
	private SpecifiedPerson specifiedPerson;
	
	private List<Vehicle> vehicles;

	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	//@ManyToOne
	@ForeignKey(name="person_id")
	public SpecifiedPerson getSpecifiedPerson() {
		return specifiedPerson;
	}

	public void setSpecifiedPerson(SpecifiedPerson specifiedPerson) {
		this.specifiedPerson = specifiedPerson;
	}

	@OneToMany(mappedBy="personOwnsVehicles")
	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

}
