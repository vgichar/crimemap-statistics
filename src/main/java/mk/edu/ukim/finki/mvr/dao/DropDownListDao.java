package mk.edu.ukim.finki.mvr.dao;

import java.util.List;

import mk.edu.ukim.finki.mvr.model.DropDownList;

public interface DropDownListDao {

	public List<DropDownList> queryAll();
	
	public DropDownList getById(String key,String value);
}
