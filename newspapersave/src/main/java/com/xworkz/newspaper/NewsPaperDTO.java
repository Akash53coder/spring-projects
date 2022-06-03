package com.xworkz.newspaper;

public class NewsPaperDTO {
	private String name;
	private double price;
	private int noOfPages;
	private String language;
	
	public NewsPaperDTO() {
		
	}
	
	
	public NewsPaperDTO(String name, double price, int noOfPages, String language) {
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
