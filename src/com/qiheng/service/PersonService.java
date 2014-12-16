package com.qiheng.service;

import java.util.List;

import com.qiheng.model.Person;

public interface PersonService {
	
	public void savePerson(Person person);
	
	public List<Person> queryAllPerson();
	
	public void deletePerson(Integer id);
	
	public Person queryPerson(Integer id);
	
	public void updatePerson(Person person);
}
