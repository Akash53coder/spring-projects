package com.xworkz.tvremote;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.xworkz.tvremote.entity.TvRemoteEntity;
import com.xworkz.tvremote.service.TVRemoteServiceImpl;



public class TvRemoteTester{
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//LocalSessionFactoryBean bootstraps Hibernate
		TvRemoteEntity entity = new TvRemoteEntity();
		entity.setName("something");
		entity.setColor("Grey");
		entity.setNoOfCells(0);
		entity.setPowerButtonWorking(false);
		entity.setPrice(140);
		

		TVRemoteServiceImpl serviceImpl=context.getBean(TVRemoteServiceImpl.class);
		//written validations in serviceimpl
//		boolean entityValresult = serviceImpl.validateTVRemoteEntity(entity);
//		if(entityValresult) {
//			System.out.println("Data is saved");
//		}else {
//			System.out.println("Data not saved");
//		}
		
		//written validations in serviceimpl i.e to check color is empty or null 
//		boolean colorValresult = serviceImpl.getColor();
//		if(colorValresult) {
//			System.out.println("color fetched");
//		}else {
//			System.out.println("Color is either  null or empty");
//
//		}
		
		//written validations in serviceimpl for null and empty check
		boolean validateUpdateRes = serviceImpl.updateTVRemoteEntity(entity);
		if(validateUpdateRes) {
			System.out.println("Updated the value");
		}else {
			System.out.println("row/s not updated");
		}
				
		ClassPathXmlApplicationContext c = (ClassPathXmlApplicationContext)context;
		c.close();
	}
}
