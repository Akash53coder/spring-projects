package com.xworkz.newspaper.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="newspaper_table")
public class NewsPaperEntity {

	@Id
	@Column(name="newspaper_id")
	@GeneratedValue(generator = "abc") // present in jpa for generating unique and auto increment value
	@GenericGenerator(name = "abc", strategy = "increment")
	private int id;
	
	@Column(name="newspaper_name")
	private String name;
	
	@Column(name="newspaper_price")
	private double price;
	
	@Column(name="newspaper_pages")
	private int noOfPages;
	
	@Column(name="newspaper_lang")
	private String language;
	
	
	public NewsPaperEntity() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

	public NewsPaperEntity(int id, String name, double price, int noOfPages, String language) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.noOfPages = noOfPages;
		this.language = language;
	}

	@Override
	public String toString() {
		return "NewsPaperEntity [id=" + id + ", name=" + name + ", price=" + price + ", noOfPages=" + noOfPages
				+ ", language=" + language + "]";
	}
	
	
}
