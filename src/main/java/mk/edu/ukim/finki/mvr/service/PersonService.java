package mk.edu.ukim.finki.mvr.service;

import java.util.List;

import mk.edu.ukim.finki.mvr.model.Person;

public interface PersonService {

	public Person getPersonById(int id);
	
	public List<Person> queryAll();
	
	public boolean isSpecifiedPerson (Person p);
	
}
