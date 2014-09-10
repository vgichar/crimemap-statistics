package mk.edu.ukim.finki.mvr.service;

import java.util.List;

import mk.edu.ukim.finki.mvr.dao.DropDownListDao;
import mk.edu.ukim.finki.mvr.model.DropDownList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class DropDownListServiceImpl implements DropDownListService{

	@Autowired
	DropDownListDao dropDownListDao;
	
	public List<DropDownList> queryAll() {
		return dropDownListDao.queryAll();
	}

	public DropDownList getById(String key, String value) {
		return dropDownListDao.getById(key, value);
	}

}
