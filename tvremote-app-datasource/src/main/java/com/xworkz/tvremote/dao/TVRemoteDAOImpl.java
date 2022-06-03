package com.xworkz.tvremote.dao;

import org.hibernate.HibernateException;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.tvremote.entity.TvRemoteEntity;

@Component
public class TVRemoteDAOImpl implements TVRemoteDAO{

	@Autowired
	private SessionFactory factory;
	
	public TVRemoteDAOImpl() {
		System.out.println("bean created");
	}
	public void addTvRemoteEntity(TvRemoteEntity tvRemoteEntity) {
		Session session = null;
		Transaction transaction = null;
		try {
			//creating SessionFactory is taken care by LocalSessionFactoryBean, so we are using @Autowired
			//session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.save(tvRemoteEntity);
			transaction.commit();
			System.out.println("Data saved");
		} catch (HibernateException e) {
			transaction.rollback();
			System.out.println("Hibernate Exception" + e.getMessage());
		} finally {
			if (session != null) {
				session.close();
				System.out.println("session closed");
			} else {
				System.out.println("session not closed");
			}

		}
	}
	@Override
	public String getColorById(int id) {
		Session session = null;
		String color=null;
		try {
			session=factory.openSession();
			String hqlQuery = "SELECT color FROM TvRemoteEntity WHERE id=16";
			Query query = session.createQuery(hqlQuery);
			color = (String) query.uniqueResult();
		}catch(HibernateException exp) {
			System.out.println(exp.getMessage());
		}finally {
			if (session != null) {
				session.close();
				System.out.println("session closed");
			} else {
				System.out.println("session not closed");
			}

		}
		return color;
	}
	@Override
	public void updateTvRemoteEntity(TvRemoteEntity tvRemoteEntity) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.openSession();
			String hqlQuery = "UPDATE TvRemoteEntity SET noOfCells=5 WHERE id=16";
			Query query = session.createQuery(hqlQuery);
			transaction = session.beginTransaction();
			int noOfrowsAffected = query.executeUpdate();
			transaction.commit();
			System.out.println(noOfrowsAffected+" row/s updated");
			//factory.close();			
		}catch(HibernateException exp) {
			transaction.rollback();
			System.out.println(exp.getLocalizedMessage());
		}finally {
			if(session!=null) {
				System.out.println("session closed");
			}else {
				System.out.println("session not closed");
			}
		}
		
	}
}
