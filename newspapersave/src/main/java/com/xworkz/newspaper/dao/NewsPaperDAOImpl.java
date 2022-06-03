package com.xworkz.newspaper.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.xworkz.newspaper.entity.NewsPaperEntity;

@Repository
public class NewsPaperDAOImpl implements NewsPaperDAO {

	@Autowired
	private SessionFactory factory;

	public NewsPaperDAOImpl() {
		System.out.println("bean for NewsPaperDAOimpl created");
	}

	@Override
	public boolean saveNewsPaperEntity(NewsPaperEntity newsPaperEntity) {
		System.out.println("save entity called");
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			session.save(newsPaperEntity);
			System.out.println("Data saved");
			session.getTransaction().commit();
			return true;
		} catch (HibernateException exp) {
			session.getTransaction().rollback();
			System.out.println("exception occured");
		} finally {
			if (session != null) {
				session.close();
				System.out.println("session closed");
			} else {
				System.out.println("session not closed");
			}
		}
		return false;
	}

	@Override
	public NewsPaperEntity getNewsPaperEntity(String newsPaperName) {
		Session session = null;
		System.out.println("invoked DaoImpl getNewsPaperEntity()");
		// we can't use get and load method to get the news paper details because
		// they accept Id, but we are searching the news paper by name
		try {
			session = factory.openSession();
			String hqlQuery = "From NewsPaperEntity WHERE name=:newsPaperName";
			Query query = session.createQuery(hqlQuery);
			query.setParameter("newsPaperName", newsPaperName);
			NewsPaperEntity newsPaperEntity = (NewsPaperEntity) query.uniqueResult();
			return newsPaperEntity;
		} catch (HibernateException exp) {
			System.out.println("An exception occured" + exp.getMessage());
		} finally {
			if (session != null) {
				System.out.println("session is closed");
				session.close();
			}
		}
		return null;
	}

	@Override
	public List<NewsPaperEntity> getAllNewsPaper() {
		Session session = null;
		System.out.println("Invoked getAllNewsPaper from DAOImpl");
		try {
			session = factory.openSession();
			String hqlQuery = "FROM NewsPaperEntity";
			Query query = session.createQuery(hqlQuery);
			List<NewsPaperEntity> list = query.list();
			if (!list.isEmpty() && list != null) {
				return list;
			} else {
				System.out.println("Table is Empty");
			}
		} catch (Exception exp) {
			System.out.println("Exception" + exp.getMessage());
		} finally {
			if (session != null) {
				System.out.println("session is closed");
				session.close();
			}
		}
		return null;
	}

	@Override
	public boolean deleteNewsPaper(String name) {
		Session session = null;
		Transaction transaction = null;
		System.out.println("invoked DaoImpl deleteNewsPaper()");
		// we can't use get and load method to get the news paper details because
		// they accept Id, but we are searching the news paper by name
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			String hqlQuery = "From NewsPaperEntity WHERE name=:newsPaperName";
			Query query = session.createQuery(hqlQuery);
			query.setParameter("newsPaperName", name);
			NewsPaperEntity newsPaperEntity = (NewsPaperEntity) query.uniqueResult();
			if (newsPaperEntity != null) {
				session.delete(newsPaperEntity);
				transaction.commit();
				return true;
			} else {
				return false;
			}
		} catch (HibernateException exp) {
			transaction.rollback();
			System.out.println("An exception occured" + exp.getMessage());
		} finally {
			if (session != null) {
				System.out.println("session is closed");
				session.close();
			}
		}
		return false;
	}

	@Override
	public boolean updateNewsPaper(NewsPaperEntity newsPaperEntity) {
		Session session = null;
		try {
			session = factory.openSession();
			String name = newsPaperEntity.getName();
			NewsPaperEntity newEntity = this.getNewsPaperEntity(name);
			newEntity.setLanguage(newsPaperEntity.getLanguage());
			newEntity.setName(newsPaperEntity.getName());
			newEntity.setNoOfPages(newsPaperEntity.getNoOfPages());
			newEntity.setPrice(newsPaperEntity.getPrice());
			session.getTransaction().begin();
			session.update(newEntity);
			session.getTransaction().commit();
			return true;
		} catch (HibernateException exp) {
			session.getTransaction().rollback();
			System.out.println("Exception " + exp.getMessage());
		} finally {
			if (session != null) {
				System.out.println("session is closed");
				session.close();
			}
		}
		return false;
	}
}
