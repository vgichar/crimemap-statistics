package mk.edu.ukim.finki.mvr.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="Event")
public class Event {

	private int id;
	
	private Date biltenDate;
	
	private Date startDate;
	
	private Date endDate;
	
	private String location;
	
	private double damage;
	
	private double profit;
	
	private String info;

	private List<Person> persons;
	
    private List<TakenItems> items;
	
	private List<Vehicle_in_the_Event> vehicles;
	
	@Id
	@Column(name="id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="biltenDate")
	public Date getBiltenDate() {
		return biltenDate;
	}

	public void setBiltenDate(Date biltenDate) {
		this.biltenDate = biltenDate;
	}

	@Column(name="startDate")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(name="endDate")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name="location")
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name="damage")
	public double getDamage() {
		return damage;
	}

	public void setDamage(double damage) {
		this.damage = damage;
	}

	@Column(name="profit")
	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	@Column(name="information")
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name="event_person",
			joinColumns={
					@JoinColumn(name="event_id",nullable=false,unique=true)
			},
			inverseJoinColumns={
					@JoinColumn(name="person_id",nullable=false,unique=true)
			}
			)
	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	@OneToMany(mappedBy="event")
	@JsonIgnore
	public List<TakenItems> getItems() {
		return items;
	}

	public void setItems(List<TakenItems> items) {
		this.items = items;
	}

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="vehicle_event",
			joinColumns={
					@JoinColumn(name="event_id",nullable=false,unique=true)
			},
			inverseJoinColumns={
					@JoinColumn(name="vehicle_id",nullable=false,unique=true)
			}
			)
	public List<Vehicle_in_the_Event> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle_in_the_Event> vehicles) {
		this.vehicles = vehicles;
	}

}
