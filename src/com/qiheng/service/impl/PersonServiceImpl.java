package com.qiheng.service.impl;

import java.util.List;

import com.qiheng.DAO.PersonDAO;
import com.qiheng.DAO.impl.PersonDAOImpl;
import com.qiheng.model.Person;
import com.qiheng.service.PersonService;

public class PersonServiceImpl implements PersonService {

	public void savePerson(Person person) {

		PersonDAO dao = new PersonDAOImpl();
		dao.savePerson(person);

	}

	public List<Person> queryAllPerson() {
		PersonDAO dao = new PersonDAOImpl();

		return dao.queryAllPerson();
	}

	public void deletePerson(Integer id) {
		PersonDAO dao = new PersonDAOImpl();

		dao.deletePerson(id);

	}

	public Person queryPerson(Integer id) {
		PersonDAO dao = new PersonDAOImpl();

		return dao.queryPerson(id);
	}
	
	public void updatePerson(Person person) {
		PersonDAO dao = new PersonDAOImpl();
		
		dao.updatePerson(person);
	}
}
