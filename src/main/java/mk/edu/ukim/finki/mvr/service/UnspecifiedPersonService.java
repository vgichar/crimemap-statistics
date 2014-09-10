package mk.edu.ukim.finki.mvr.service;

import java.util.List;

import mk.edu.ukim.finki.mvr.model.UnspecifiedPerson;

public interface UnspecifiedPersonService {

	public List<UnspecifiedPerson> queryAll();
	
	public UnspecifiedPerson getPersonById(int id);
}
