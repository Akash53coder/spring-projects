package com.xworkz.dependencyinjection;

public class Wallet {

	private String color;
	private String brand;
	private ATM atm;
	private Money money;
	
	public Wallet() {
		System.out.println("Wallet no-arg constructor invoked");
	}

	public Wallet(String color, String brand, ATM atm, Money money) {
		super();
		this.color = color;
		this.brand = brand;
		this.atm = atm;
		this.money = money;
		System.out.println("Wallet param-constructor called");
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public ATM getAtm() {
		return atm;
	}

	public void setAtm(ATM atm) {
		this.atm = atm;
	}

	public Money getMoney() {
		return money;
	}

	public void setMoney(Money money) {
		this.money = money;
	}
		
}