package com.qiheng.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.qiheng.model.Person;
import com.qiheng.service.PersonService;
import com.qiheng.service.impl.PersonServiceImpl;

public class PersonAction extends ActionSupport {

	private int id;

	private String username;

	private String password;

	private int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String savePerson() throws Exception {

		Person person = new Person();

		person.setUsername(username);
		person.setPassword(password);
		person.setAge(age);

		java.sql.Date registerDate = new java.sql.Date(
				new java.util.Date().getTime());
		person.setRegisterDate(registerDate);

		PersonService service = new PersonServiceImpl();
		service.savePerson(person);

		List<Person> list = service.queryAllPerson();

		HttpServletRequest req = ServletActionContext.getRequest();

		req.setAttribute("list", list);

		return SUCCESS;
	}

	public String deletePerson() throws Exception {

		PersonService service = new PersonServiceImpl();
		service.deletePerson(this.id);

		List<Person> list = service.queryAllPerson();

		HttpServletRequest req = ServletActionContext.getRequest();

		req.setAttribute("list", list);

		return SUCCESS;
	}

	public String queryPerson() throws Exception {

		PersonService service = new PersonServiceImpl();

		Person person = service.queryPerson(id);

		HttpServletRequest req = ServletActionContext.getRequest();

		req.setAttribute("person", person);

		return SUCCESS;
	}

	public String updatePerson() throws Exception {
		

		PersonService service = new PersonServiceImpl();

		
		Person person = service.queryPerson(id);
		
		person.setPassword(password);
		person.setAge(age);
		
		service.updatePerson(person);
		
		List<Person> list = service.queryAllPerson();

		HttpServletRequest req = ServletActionContext.getRequest();

		req.setAttribute("list", list);

		return SUCCESS;
	}

}
