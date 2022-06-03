package com.xworkz.tvremote.entity;

import java.sql.DriverManager;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tv_remote")
public class TvRemoteEntity implements java.io.Serializable{
	@Id
	@GeneratedValue(generator = "abc") // present in jpa for generating unique and auto increment value
	@GenericGenerator(name = "abc", strategy = "increment")
	@Column(name="ID")
	private int id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "COLOR")
	private String color;
	@Column(name = "PRICE")
	private double price;
	@Column(name = "NO_OF_CELLS")
	private int noOfCells;
	@Column(name = "IS_POWER_BUTTON_WORKING")
	private boolean isPowerButtonWorking;
	
	public TvRemoteEntity() {
		
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNoOfCells() {
		return noOfCells;
	}

	public void setNoOfCells(int noOfCells) {
		this.noOfCells = noOfCells;
	}

	public boolean getIsPowerButtonWorking() {
		return isPowerButtonWorking;
	}

	public void setPowerButtonWorking(boolean isPowerButtonWorking) {
		this.isPowerButtonWorking = isPowerButtonWorking;
	}

	public TvRemoteEntity(int id, String name, String color, double price, int noOfCells,
			boolean isPowerButtonWorking) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.price = price;
		this.noOfCells = noOfCells;
		this.isPowerButtonWorking = isPowerButtonWorking;
	}

	@Override
	public String toString() {
		return "TvRemoteEntity [id=" + id + ", name=" + name + ", color=" + color + ", price=" + price + ", noOfCells="
				+ noOfCells + ", isPowerButtonWorking=" + isPowerButtonWorking + "]";
	}
	
}
