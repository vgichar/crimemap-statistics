package mk.edu.ukim.finki.mvr.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;


@Entity
@Table(name="Person")
public class Person {

	private int id;
	
	private boolean known;
	
	private String comment;

	private UnspecifiedPerson unspecifiedPerson;
	
	private SpecifiedPerson specifiedPerson;
	
	private List<Event> events;
	
//	private List<Person_Vehicles> person_Vehicles;
	
	@Id
	@GeneratedValue
	@Column(name="id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="known")
	public boolean isKnown() {
		return known;
	}

	public void setKnown(boolean known) {
		this.known = known;
	}

	@Column(name="comment")
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@OneToOne(mappedBy="person")
	public UnspecifiedPerson getUnspecifiedPerson() {
		return unspecifiedPerson;
	}

	public void setUnspecifiedPerson(UnspecifiedPerson unspecifiedPerson) {
		this.unspecifiedPerson = unspecifiedPerson;
	}

	@OneToOne(mappedBy="person")
	public SpecifiedPerson getSpecifiedPerson() {
		return specifiedPerson;
	}

	public void setSpecifiedPerson(SpecifiedPerson specifiedPerson) {
		this.specifiedPerson = specifiedPerson;
	}

	/*
	@OneToMany
	@Fetch(value=FetchMode.SUBSELECT)
	public List<Person_Vehicles> getPerson_Vehicles() {
		return person_Vehicles;
	}

	public void setPerson_Vehicles(List<Person_Vehicles> person_Vehicles) {
		this.person_Vehicles = person_Vehicles;
	}
*/
	@ManyToMany(mappedBy="persons")
	@JsonIgnore
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
}
