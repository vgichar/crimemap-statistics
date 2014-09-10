package mk.edu.ukim.finki.mvr.dao;

import java.util.List;

import mk.edu.ukim.finki.mvr.model.Dependency;

public interface DependencyDao {

	public List<Dependency> queryAll();
	
	public Dependency getById (String key,String value);
}
