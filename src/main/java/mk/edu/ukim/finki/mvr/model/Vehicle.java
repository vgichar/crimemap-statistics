package mk.edu.ukim.finki.mvr.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {

	private int id;
	
	private String registrationPlates;
	
	private String comment;
	
	private Person_Vehicles personOwnsVehicles;
	
	private Vehicle_in_the_Event vehicleInTheEvent;

	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegistrationPlates() {
		return registrationPlates;
	}

	public void setRegistrationPlates(String registrationPlates) {
		this.registrationPlates = registrationPlates;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@ManyToOne
	public Person_Vehicles getPersonOwnsVehicles() {
		return personOwnsVehicles;
	}

	public void setPersonOwnsVehicles(Person_Vehicles personOwnsVehicles) {
		this.personOwnsVehicles = personOwnsVehicles;
	}

	@ManyToOne
	public Vehicle_in_the_Event getVehicleInTheEvent() {
		return vehicleInTheEvent;
	}

	public void setVehicleInTheEvent(Vehicle_in_the_Event vehicleInTheEvent) {
		this.vehicleInTheEvent = vehicleInTheEvent;
	}
	
}
