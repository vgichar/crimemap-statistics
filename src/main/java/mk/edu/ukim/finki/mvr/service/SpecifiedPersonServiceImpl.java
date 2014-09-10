package mk.edu.ukim.finki.mvr.service;

import java.util.List;

import mk.edu.ukim.finki.mvr.dao.Person_VehiclesDao;
import mk.edu.ukim.finki.mvr.dao.SpecifiedPersonDao;
import mk.edu.ukim.finki.mvr.model.Person_Vehicles;
import mk.edu.ukim.finki.mvr.model.SpecifiedPerson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class SpecifiedPersonServiceImpl implements SpecifiedPersonService {

	@Autowired
	SpecifiedPersonDao specifiedPersonDao;

	@Autowired
	Person_VehiclesDao person_vehiclesDao;
	
	public List<SpecifiedPerson> queryAll() {
		return specifiedPersonDao.queryAll();
	}

	public SpecifiedPerson getById(int id) {
		return specifiedPersonDao.getById(id);
	}

	public List<SpecifiedPerson> getPersonByHomeAddress(String address) {
		return specifiedPersonDao.getByHomeAddress(address);
	}

	public List<SpecifiedPerson> getPersonByResidence(String address) {
		return specifiedPersonDao.getByResidenceAddress(address);
	}

	public void addVehicles(Person_Vehicles p, SpecifiedPerson s) {
		if(person_vehiclesDao.getById(p.getId())!=null)
		{
			s.getPerson_Vehicles().add(p);
		}
	}

	public void removeVehicles(Person_Vehicles p, SpecifiedPerson s) {
		if(s.getPerson_Vehicles().contains(p) && (person_vehiclesDao.getById(p.getId())!=null))
		{
			for(int i=0;i<s.getPerson_Vehicles().size();i++)
			{
				if(s.getPerson_Vehicles().get(i).getId()==p.getId())
				{
					s.getPerson_Vehicles().remove(i);
				}
			}
		}
		
	}
}
