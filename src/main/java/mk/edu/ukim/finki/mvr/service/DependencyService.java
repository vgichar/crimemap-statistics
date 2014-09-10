package mk.edu.ukim.finki.mvr.service;

import java.util.List;

import mk.edu.ukim.finki.mvr.model.Dependency;
import mk.edu.ukim.finki.mvr.model.DropDownList;

public interface DependencyService {

	public List<Dependency> queryAll();
	
	public Dependency getById(DropDownList d);
}
