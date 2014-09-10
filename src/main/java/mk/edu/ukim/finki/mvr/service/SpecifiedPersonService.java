package mk.edu.ukim.finki.mvr.service;

import java.util.List;

import mk.edu.ukim.finki.mvr.model.Person_Vehicles;
import mk.edu.ukim.finki.mvr.model.SpecifiedPerson;

public interface SpecifiedPersonService {

	public List<SpecifiedPerson> queryAll();
	
	public SpecifiedPerson getById(int id);
	
	public List<SpecifiedPerson> getPersonByHomeAddress (String address);
	
	public List<SpecifiedPerson> getPersonByResidence (String address);
	
	public void addVehicles (Person_Vehicles p,SpecifiedPerson s);
	
	public void removeVehicles (Person_Vehicles p, SpecifiedPerson s);
}
