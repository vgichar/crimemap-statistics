package mk.edu.ukim.finki.mvr.dao;

import java.util.List;

import mk.edu.ukim.finki.mvr.model.DropDownList;

public interface DropDownListDao {

    public boolean insert(DropDownList entity);

    public void update(DropDownList entity);

    public void insertOrUpdate(DropDownList entity);

    public void delete(String key, String value);

    public List<DropDownList> queryAll();

    public List<DropDownList> queryByKey(String key);

    public DropDownList getByKeyAndValue(String key, String value);
    
    public List<DropDownList> getByDependencyKeyAndValue(String key, String value);
}
