package mk.edu.ukim.finki.mvr.dao;

import java.util.List;

import mk.edu.ukim.finki.mvr.model.UnspecifiedPerson;

public interface UnspecifiedPersonDao {

	public List<UnspecifiedPerson> queryAll();
	
	public UnspecifiedPerson queryById(int id);
	
}
