package mk.edu.ukim.finki.mvr.service;

import java.util.List;

import mk.edu.ukim.finki.mvr.model.DropDownList;

public interface DropDownListService {

	public List<DropDownList> queryAll();
	
	public DropDownList getById(String key,String value);
}
