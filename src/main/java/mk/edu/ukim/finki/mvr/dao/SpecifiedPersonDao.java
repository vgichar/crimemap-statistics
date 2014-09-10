package mk.edu.ukim.finki.mvr.dao;

import java.util.List;

import mk.edu.ukim.finki.mvr.model.SpecifiedPerson;

public interface SpecifiedPersonDao {

	public List<SpecifiedPerson> queryAll();
	
	public SpecifiedPerson getById(int id);
	
	public List<SpecifiedPerson> getByHomeAddress (String address);
	
	public List<SpecifiedPerson> getByResidenceAddress (String address);
}
