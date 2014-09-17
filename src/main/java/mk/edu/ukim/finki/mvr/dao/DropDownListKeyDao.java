package mk.edu.ukim.finki.mvr.dao;

import java.util.List;
import mk.edu.ukim.finki.mvr.model.DropDownListKey;

public interface DropDownListKeyDao {

    public void insert(DropDownListKey entity);

    public void update(DropDownListKey entity);

    public void insertOrUpdate(DropDownListKey entity);

    public void delete(String key);

    public List<DropDownListKey> queryAll();

    public DropDownListKey getByKey(String key);

    public DropDownListKey getByDependency(String depKey);
}
