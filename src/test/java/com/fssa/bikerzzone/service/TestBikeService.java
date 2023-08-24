package com.fssa.bikerzzone.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.fssa.bikerzzone.dao.BikeDao;
import com.fssa.bikerzzone.exceptions.DAOException;
import com.fssa.bikerzzone.model.Bike;
import com.fssa.bikerzzone.validator.BikeValidator;

/**
 * Test class for testing the BikeService class.
 */
public class TestBikeService {

	/**
	 * Test method for adding a bike.
	 *
	 * @throws Exception If an unexpected exception occurs.
	 */
	@Test
	void testAddBike() throws Exception {
		// Create a sample Bike object
		Bike bike = new Bike(1, "Yamaha", "RX150", 80000, "FIRST", "Chennai", LocalDate.of(2003, 9, 5));

		// Validate the Bike object and add it using the BikeDao
		assertTrue(BikeValidator.validate(bike));
		assertDoesNotThrow(() -> BikeService.addBike(bike));
	}

	/**
	 * Test method for reading bike information.
	 *
	 * @throws Exception If an unexpected exception occurs.
	 */
	@Test
	void testReadBike() throws Exception {
		// Invoke the readBike method from BikeDao
		BikeService.readBike();
	}

	/**
	 * Test method for updating bike information.
	 *
	 * @throws Exception If an unexpected exception occurs.
	 */
	@Test
	void testUpdateBike() throws Exception {
		int id = 1;
		String brand = "Hero";

		// Validate the ID and brand, then update the bike using the BikeDao
		assertTrue(BikeValidator.validateId(id));
		assertTrue(BikeValidator.validateBrand(brand));
		assertDoesNotThrow(() -> BikeService.updateBike(brand, id));
	}

	/**
	 * Test method for deleting bike information.
	 *
	 * @throws Exception If an unexpected exception occurs.
	 */
	@Test
	void testDeleteBike() throws Exception {
		int id = 1;

		// Validate the ID and delete the bike using the BikeDao
		assertTrue(BikeValidator.validateId(id));
		assertDoesNotThrow(() -> BikeService.deleteBike(id));
	}
}
