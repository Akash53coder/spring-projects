package com.xworkz.dependencyinjection;

public class Photo {

	private String photoSize;
	private double price;
	
	public Photo() {
		
	}
	
	public Photo(String photoSize, double price) {
		super();
		this.photoSize = photoSize;
		this.price = price;
	}

	public void setPhotoSize(String photoSize) {
		this.photoSize = photoSize;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Photo [photoSize=" + photoSize + ", price=" + price + "]";
	}
	
	
	
}
