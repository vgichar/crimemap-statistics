package mk.edu.ukim.finki.mvr.dao;

import java.util.List;

public interface CrudDao<T> {

    public void insert(T entity);
    public void update(T entity);
    public void insertOrUpdate(T entity);
    public void delete(int id);
    public T getById(int id);
    public List<T> queryAll();
}
