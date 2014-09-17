package mk.edu.ukim.finki.mvr.service;

import java.util.LinkedList;
import java.util.List;

import mk.edu.ukim.finki.mvr.dao.DropDownListDao;
import mk.edu.ukim.finki.mvr.model.DropDownList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class DropDownListServiceImpl implements DropDownListService {

    @Autowired
    DropDownListDao dropDownListDao;

    @Override
    public boolean insert(DropDownList entity) {
        return dropDownListDao.insert(entity);
    }

    @Override
    public void update(DropDownList entity) {
        dropDownListDao.update(entity);
    }

    @Override
    public void insertOrUpdate(DropDownList entity) {
        dropDownListDao.insertOrUpdate(entity);
    }

    @Override
    public void delete(String key, String value) {
        dropDownListDao.delete(key, value);
    }

    @Override
    public List<DropDownList> queryAll() {
        return dropDownListDao.queryAll();
    }

    @Override
    public List<DropDownList> queryByKey(String key) {
        return dropDownListDao.queryByKey(key);
    }

    @Override
    public DropDownList getByKeyAndValue(String key, String value) {
        return dropDownListDao.getByKeyAndValue(key, value);
    }

    @Override
    public List<DropDownList> getByDependencyKeyAndValue(String key, String value) {
        List<DropDownList> list = dropDownListDao.getByDependencyKeyAndValue(key, value);
        return list != null ? list : new LinkedList<DropDownList>();
    }

}
