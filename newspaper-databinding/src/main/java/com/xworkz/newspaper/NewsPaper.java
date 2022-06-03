package com.xworkz.newspaper;

import org.springframework.stereotype.Component;

//here this class is a DTO class where data will transfered from UI to java class, this
// class is always mapped with web page or view
//Without Encapsulation this class is called as POJO class with respect to EJB
//Entity classes usually meant for DB Mapping 
//the instance variable name must be as same as Input field's names
@Component 
public class NewsPaper {

	private String name;
	private double price;
	private int noOfPages;
	private String language;
	
	public NewsPaper() {
		
	}
	
	
	public NewsPaper(String name, double price, int noOfPages, String language) {
		super();
		this.name = name;
		this.price = price;
		this.noOfPages = noOfPages;
		this.language = language;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNoOfPages() {
		return noOfPages;
	}
	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	@Override
	public String toString() {
		return "NewsPaper [name=" + name + ", price=" + price + ", noOfPages=" + noOfPages + ", language=" + language
				+ "]";
	}
	
	
}
