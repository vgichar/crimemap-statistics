package mk.edu.ukim.finki.mvr.service;

import java.util.List;

import mk.edu.ukim.finki.mvr.model.TakenItems;

public interface TakenItemsService {

	public List<TakenItems> queryAll();
	
	public TakenItems getItemById(int id);
	
}
