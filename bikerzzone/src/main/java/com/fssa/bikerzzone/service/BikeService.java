package com.fssa.bikerzzone.service;

import java.sql.SQLException;

import com.fssa.bikerzzone.dao.BikeDao;
import com.fssa.bikerzzone.model.Bike;
import com.fssa.bikerzzone.validator.BikeValidator;

public class BikeService {

	public static boolean addBike(Bike bike) throws Exception {

		if (BikeValidator.validate(bike)) {

			boolean result = BikeDao.addBike(bike);
			return result;
		}
		return false;
	}

	public static boolean updateBike(String brand, int id) throws Exception {

		if (BikeValidator.validateId(id) && BikeValidator.validateBrand(brand)) {

			return BikeDao.updateBike(brand, id);

		}
		return false;
	}

	public static boolean readBike() throws SQLException {

		return BikeDao.readBike();

	}

	public static boolean deleteBike(int id) throws Exception {

		if (BikeValidator.validateId(id)) {
			return BikeDao.deleteBike(id);
		}
		return false;
	}

}
