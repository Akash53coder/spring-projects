package com.xworkz.tvremote;

import org.springframework.context.ApplicationContext;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xworkz.tvremote.dao.TVRemoteDAOImpl;
import com.xworkz.tvremote.entity.TvRemoteEntity;



public class TvRemoteTester{
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//LocalSessionFactoryBean bootstraps Hibernate
		TvRemoteEntity entity = new TvRemoteEntity();
		entity.setColor("Grey");
		entity.setName("Apple");
		entity.setNoOfCells(3);
		entity.setPowerButtonWorking(false);
		entity.setPrice(140);
		
		TVRemoteDAOImpl dao = context.getBean(TVRemoteDAOImpl.class);
		dao.addTvRemoteEntity(entity);
				
		ClassPathXmlApplicationContext c = (ClassPathXmlApplicationContext)context;
		c.close();
	}
}
