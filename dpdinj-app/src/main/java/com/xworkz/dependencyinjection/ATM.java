package com.xworkz.dependencyinjection;

public class ATM {

	private long atmNo;
	private int cvv;
	private boolean wifiConnected;

	public ATM() {
		System.out.println("atm no-arg constructor invoked");
	}

	public ATM(long atmNo, int cvv, boolean wifiConnected) {
		super();
		this.atmNo = atmNo;
		this.cvv = cvv;
		this.wifiConnected = wifiConnected;
		System.out.println("ATM param-constructor called");

	}

	public long getAtmNo() {
		return atmNo;
	}

	public void setAtmNo(long atmNo) {
		this.atmNo = atmNo;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public boolean isWifiConnected() {
		return wifiConnected;
	}

	public void setWifiConnected(boolean wifiConnected) {
		this.wifiConnected = wifiConnected;
	}

}
