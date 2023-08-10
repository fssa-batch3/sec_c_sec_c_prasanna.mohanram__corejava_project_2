package com.fssa.bikerzzone.service;

import java.sql.SQLException;

import com.fssa.bikerzzone.dao.BikeDao;
import com.fssa.bikerzzone.exceptions.DAOException;
import com.fssa.bikerzzone.model.Bike;
import com.fssa.bikerzzone.validator.BikeValidator;

public class BikeService {

	public static boolean addBike(Bike bike) throws DAOException, SQLException {

		if (BikeValidator.validate(bike)) {

			return BikeDao.addBike(bike);
		}
		return false;
	}

	public static boolean updateBike(String brand, int id) throws DAOException, SQLException {

		if (BikeValidator.validateId(id) && BikeValidator.validateBrand(brand)) {

			return BikeDao.updateBike(brand, id);

		}
		return false;
	}

	public static boolean readBike() throws DAOException {

		return BikeDao.readBike();

	}

	public static boolean deleteBike(int id) throws DAOException, SQLException {

		if (BikeValidator.validateId(id)) {
			return BikeDao.deleteBike(id);
		}
		return false;
	}

}
