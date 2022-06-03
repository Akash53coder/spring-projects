package com.xworkz.dependencyinjection;

public class Money {

	private int size;
	private String value;
	private boolean isCoin;

	public Money() {
		System.out.println("Money no-arg constructor invoked");
	}

	public Money(int size, String value, boolean isCoin) {
		super();
		this.size = size;
		this.value = value;
		this.isCoin = isCoin;
		System.out.println("Money param-constructor called");

	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean getIsCoin() {
		return isCoin;
	}

	public void setIsCoin(boolean isCoin) {
		this.isCoin = isCoin;
	}

}
