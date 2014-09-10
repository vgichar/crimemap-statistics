package mk.edu.ukim.finki.mvr.service;

import java.util.List;

import mk.edu.ukim.finki.mvr.dao.PersonDao;
import mk.edu.ukim.finki.mvr.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonDao personDao;
	
	public Person getPersonById(int id) {
		return personDao.getPersonById(id);
	}

	public List<Person> queryAll() {
		return personDao.queryAllPersons();
	}

	public boolean isSpecifiedPerson(Person p) {
		if(personDao.getPersonById(p.getId())!=null)
		{
			if(p.isKnown())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		return false;
	}

}
