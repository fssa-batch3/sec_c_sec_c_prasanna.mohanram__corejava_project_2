package com.fssa.bikerzzone.service;

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
		Bike bike = new Bike(1, "RoyalEnfield", "ThunderBird", 100000, "FIRST", "Chennai", LocalDate.of(1998, 9, 05));

		if (BikeValidator.validate(bike)) {
			BikeDao.addBike(bike);
		}
	}

	@Test
	public void testReadBike() throws DAOException, SQLException {
		BikeDao.readBike();
	}

	@Test
	public void testUpdateBike() throws Exception, DAOException {
		int id = 1;
		String brand = "UpdatedBrand";

		if (BikeValidator.validateId(id) && BikeValidator.validateBrand(brand)) {
			BikeDao.updateBike(brand, id);
		}
	}

	@Test
	public void testDeleteBike() throws Exception {
		int id = 1;

		if (BikeValidator.validateId(id)) {
			BikeDao.deleteBike(id);
		}
	}
}
