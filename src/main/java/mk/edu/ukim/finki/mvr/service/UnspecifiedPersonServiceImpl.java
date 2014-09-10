package mk.edu.ukim.finki.mvr.service;

import java.util.List;

import mk.edu.ukim.finki.mvr.dao.UnspecifiedPersonDao;
import mk.edu.ukim.finki.mvr.model.UnspecifiedPerson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UnspecifiedPersonServiceImpl implements UnspecifiedPersonService {

	@Autowired
	UnspecifiedPersonDao unspecifiedPersonDao;

	public List<UnspecifiedPerson> queryAll() {
		return unspecifiedPersonDao.queryAll();
	}

	public UnspecifiedPerson getPersonById(int id) {
		return unspecifiedPersonDao.queryById(id);
	}
}
