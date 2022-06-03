package com.xworkz.tvremote.dao;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
	@Override
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
}
