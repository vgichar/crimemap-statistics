package mk.edu.ukim.finki.mvr.dao;

import java.util.List;

import mk.edu.ukim.finki.mvr.model.Person;

public interface PersonDao {

	public List<Person> queryAllPersons();
	
	public Person getPersonById(int id);
	
}
