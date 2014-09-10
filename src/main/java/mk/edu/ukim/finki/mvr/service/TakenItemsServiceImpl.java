package mk.edu.ukim.finki.mvr.service;

import java.util.List;

import mk.edu.ukim.finki.mvr.dao.TakenItemsDao;
import mk.edu.ukim.finki.mvr.model.TakenItems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TakenItemsServiceImpl implements TakenItemsService{

	@Autowired
	TakenItemsDao takenItemsDao;

	public List<TakenItems> queryAll() {
		return takenItemsDao.queryAllItems();
	}

	public TakenItems getItemById(int id) {
		return takenItemsDao.getItemById(id);
	}
	
}
