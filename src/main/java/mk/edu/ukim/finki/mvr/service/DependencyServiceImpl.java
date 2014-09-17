package mk.edu.ukim.finki.mvr.service;

import java.util.List;

import mk.edu.ukim.finki.mvr.dao.DependencyDao;
import mk.edu.ukim.finki.mvr.model.Dependency;
import mk.edu.ukim.finki.mvr.model.DropDownList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class DependencyServiceImpl implements DependencyService {

    @Autowired
    DependencyDao dependencyDao;

    public List<Dependency> queryAll() {
        return dependencyDao.queryAll();
    }

    public Dependency getById(DropDownList d) {
        return null;
    }

}
