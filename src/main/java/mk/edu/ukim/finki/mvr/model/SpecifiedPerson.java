package mk.edu.ukim.finki.mvr.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.FetchMode;

@Entity
public class SpecifiedPerson implements Serializable {

	private String name;
	
	private String surname;
	
	private Date birthDate;
	
	private String homeAddress;
	
	private String residenceAddress;
	
	private int age;

	private Person person;
	
	private List<Person_Vehicles> person_Vehicles;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="birthDate")
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getResidenceAddress() {
		return residenceAddress;
	}

	public void setResidenceAddress(String residenceAddress) {
		this.residenceAddress = residenceAddress;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Id
	@OneToOne
	@ForeignKey(name="id")
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@OneToMany//(mappedBy="specifiedPerson")
	@Fetch(value=FetchMode.SUBSELECT)
	@JsonIgnore
	public List<Person_Vehicles> getPerson_Vehicles() {
		return person_Vehicles;
	}

	public void setPerson_Vehicles(List<Person_Vehicles> person_Vehicles) {
		this.person_Vehicles = person_Vehicles;
	}
	
}
