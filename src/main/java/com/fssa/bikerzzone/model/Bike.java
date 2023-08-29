package com.fssa.bikerzzone.model;

import java.time.LocalDate;

/**
 * A class representing a bike entity.
 */
public class Bike {

	private long id; // The ID of the bike
	private String brand; // The brand of the bike
	private String model; // The model of the bike
	private double price; // The price of the bike
	private String ownership; // The ownership status of the bike
	private String location; // The location of the bike
	private LocalDate manufactureDate; // The manufacture date of the bike

	/**
	 * Default constructor for creating a Bike object.
	 */
	public Bike() {
		// default constructor
	}

	/**
	 * Constructor for creating a Bike object with specified values.
	 *
	 * @param id              The ID of the bike.
	 * @param brand           The brand of the bike.
	 * @param model           The model of the bike.
	 * @param price           The price of the bike.
	 * @param ownership       The ownership status of the bike.
	 * @param location        The location of the bike.
	 * @param manufactureDate The manufacture date of the bike.
	 */
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

	/**
	 * Sets the ID of the bike.
	 *
	 * @param id The ID to set.
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the ownership status of the bike.
	 *
	 * @return The ownership status of the bike.
	 */
	public String getOwnership() {
		return ownership;
	}

	/**
	 * Sets the ownership status of the bike.
	 *
	 * @param ownership The ownership status to set.
	 */
	public void setOwnership(String ownership) {
		this.ownership = ownership;
	}

	/**
	 * Gets the brand of the bike.
	 *
	 * @return The brand of the bike.
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Sets the brand of the bike.
	 *
	 * @param brand The brand to set.
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * Gets the model of the bike.
	 *
	 * @return The model of the bike.
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Sets the model of the bike.
	 *
	 * @param model The model to set.
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * Gets the price of the bike.
	 *
	 * @return The price of the bike.
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets the price of the bike.
	 *
	 * @param price The price to set.
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Gets the location of the bike.
	 *
	 * @return The location of the bike.
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Sets the location of the bike.
	 *
	 * @param location The location to set.
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Gets the ID of the bike.
	 *
	 * @return The ID of the bike.
	 */
	public long getId() {
		return id;
	}

	/**
	 * Gets the manufacture date of the bike.
	 *
	 * @return The manufacture date of the bike.
	 */
	public LocalDate getManufactureDate() {
		return manufactureDate;
	}

	/**
	 * Sets the manufacture date of the bike.
	 *
	 * @param manufactureDate The manufacture date to set.
	 */
	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	@Override
	public String toString() {
		return "Bike [id=" + id + ", brand=" + brand + ", model=" + model + ", price=" + price + ", ownership="
				+ ownership + ", location=" + location + ", manufactureDate=" + manufactureDate + "]";
	}
	
	
}
