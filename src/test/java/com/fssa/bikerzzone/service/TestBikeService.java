package com.fssa.bikerzzone.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.fssa.bikerzzone.dao.BikeDao;
import com.fssa.bikerzzone.exceptions.DAOException;
import com.fssa.bikerzzone.model.Bike;
import com.fssa.bikerzzone.validator.BikeValidator;

public class TestBikeService {

	@Test
	public void testAddBike() throws Exception, DAOException {
		Bike bike = new Bike(1, "Honda", "CB170", 80000, "FIRST", "Chennai", LocalDate.of(2003, 9, 5));

		assertTrue(BikeValidator.validate(bike));
		assertDoesNotThrow(() -> BikeDao.addBike(bike));
	}

	@Test
	public void testReadBike() throws DAOException, SQLException {
		// Assuming BikeDao.readBike() returns a list of bikes, validate the list
		assertDoesNotThrow(() -> BikeDao.addBike(bike));
	}

	@Test
	public void testUpdateBike() throws Exception, DAOException {
		int id = 1;
		String brand = "Hero";

		assertTrue(BikeValidator.validateId(id));
		assertTrue(BikeValidator.validateBrand(brand));
		assertDoesNotThrow(() -> BikeDao.updateBike(brand, id));
	}

	@Test
	public void testDeleteBike() throws Exception {
		int id = 1;

		assertTrue(BikeValidator.validateId(id));
		assertDoesNotThrow(() -> BikeDao.deleteBike(id));
	}

}
