package mk.edu.ukim.finki.mvr.dao;

import java.util.List;

import mk.edu.ukim.finki.mvr.model.TakenItems;

public interface TakenItemsDao {

	public List<TakenItems> queryAllItems();
	
	public TakenItems getItemById(int id);
	
}
