package com.xworkz.dependencyinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WalletTester {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Wallet wallet = context.getBean(Wallet.class);
		System.out.println(wallet.hashCode());
		System.out.println(wallet.getMoney().getSize());
		//singleton object
		Wallet wallet1 = context.getBean(Wallet.class);
		System.out.println(wallet1.hashCode());
		
		
		Photo photo=context.getBean(Photo.class);
		System.out.println(photo);
				
	}
}
