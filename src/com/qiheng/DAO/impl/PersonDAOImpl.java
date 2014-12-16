package com.qiheng.DAO.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qiheng.DAO.PersonDAO;
import com.qiheng.model.Person;
import com.qiheng.util.HibernateUtil;

public class PersonDAOImpl implements PersonDAO {

	public void savePerson(Person person) {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(person);
			transaction.commit();
			
			
		} catch (Exception e) {
			if(null != transaction){
				transaction.rollback();
			}
		}finally{
			
			HibernateUtil.closeSession(session);
		}
		
		
		
	}
	@SuppressWarnings("unchecked")
	public List<Person> queryAllPerson() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		List<Person> list=null;
		try {
			
			Query query = session.createQuery("from Person");
			
			list = query.list();
			
			
			transaction.commit();
			
			
		} catch (Exception e) {
			if(null != transaction){
				transaction.rollback();
			}
		}finally{
			
			HibernateUtil.closeSession(session);
		}
		
		return list;
	}
	
	public void deletePerson(Integer id) {
		
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			
			Person person = (Person)session.get(Person.class, id);
			session.delete(person);
			
			transaction.commit();
			
			
		} catch (Exception e) {
			if(null != transaction){
				transaction.rollback();
			}
		}finally{
			
			HibernateUtil.closeSession(session);
		}
		
		
	}
	
	public Person queryPerson(Integer id) {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		Person person=null;
		try {
			
			person = (Person)session.get(Person.class, id);
			
			
			transaction.commit();
			
			
		} catch (Exception e) {
			if(null != transaction){
				transaction.rollback();
			}
		}finally{
			
			HibernateUtil.closeSession(session);
		}
		return person;
	}
	
	public void updatePerson(Person person) {

		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			
			
			session.update(person);
			
			transaction.commit();
			
			
		} catch (Exception e) {
			if(null != transaction){
				transaction.rollback();
			}
		}finally{
			
			HibernateUtil.closeSession(session);
		}
		
	}

}
