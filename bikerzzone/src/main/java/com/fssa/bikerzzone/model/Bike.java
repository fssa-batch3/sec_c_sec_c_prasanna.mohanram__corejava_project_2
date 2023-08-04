package com.fssa.bikerzzone.model;

import java.time.LocalDate;


//import com.fssa.bikerzzone.model.Bike.Types;

public class Bike {

	private long id;
	private String brand;
	private String model;
	private double price;
	private String ownership;
	
//	private Types ownership;
//	 public enum Types{
//		 FIRST, SECOND, THIRD, FOURTH
//	 }
	private String location;
	private LocalDate manufactureDate;

	public Bike() {
//		default constructor
	}

	public Bike(long id, String brand, String model, double price, String ownership, String location,
			LocalDate manufactureDate) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.ownership = ownership;
		this.location = location;
		this.manufactureDate = manufactureDate;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOwnership() {
		return ownership;
	}

	public void setOwnership(String ownership) {
		this.ownership = ownership;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() { 
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

//	public Types getOwnership() {
//		return ownership;
//	}
//
//	public void setOwnership(Types ownership) {
//		this.ownership = ownership;
//	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long getId() {
		return id;
	}

	public LocalDate getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public static void main(String[] args) {
		System.out.println();
	}

}
