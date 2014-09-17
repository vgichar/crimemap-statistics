package mk.edu.ukim.finki.mvr.service;

import java.util.List;

import mk.edu.ukim.finki.mvr.dao.DropDownListDao;
import mk.edu.ukim.finki.mvr.dao.DropDownListKeyDao;
import mk.edu.ukim.finki.mvr.model.DropDownListKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class DropDownListKeyServiceImpl implements DropDownListKeyService {

    @Autowired
    DropDownListKeyDao dropDownListDao;

    @Override
    public void insert(DropDownListKey entity) {
        dropDownListDao.insert(entity);
    }

    @Override
    public void update(DropDownListKey entity) {
        dropDownListDao.update(entity);
    }

    @Override
    public void insertOrUpdate(DropDownListKey entity) {
        dropDownListDao.insertOrUpdate(entity);
    }

    @Override
    public void delete(String key) {
        dropDownListDao.delete(key);
    }

    @Override
    public List<DropDownListKey> queryAll() {
        return dropDownListDao.queryAll();
    }

    @Override
    public DropDownListKey getByKey(String key) {
        return dropDownListDao.getByKey(key);
    }

    @Override
    public DropDownListKey getByDependency(String depKey) {
        return dropDownListDao.getByDependency(depKey);
    }
}
