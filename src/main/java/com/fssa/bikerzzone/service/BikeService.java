package com.fssa.bikerzzone.service;

import java.sql.SQLException;

import com.fssa.bikerzzone.dao.BikeDao;
import com.fssa.bikerzzone.exceptions.DAOException;
import com.fssa.bikerzzone.model.Bike;
import com.fssa.bikerzzone.validator.BikeValidator;

/**
 * Service class that provides operations related to bikes.
 */
public class BikeService {

	/**
	 * Adds a bike to the database.
	 *
	 * @param bike The Bike object to be added.
	 * @return True if the bike is added successfully, false otherwise.
	 * @throws DAOException If a database-related error occurs.
	 * @throws SQLException If a SQL-related error occurs.
	 */
	public static boolean addBike(Bike bike) throws DAOException, SQLException {
		if (BikeValidator.validate(bike)) {
			return BikeDao.addBike(bike);
		}
		return false;
	}

	/**
	 * Updates the brand of a bike with the specified ID.
	 *
	 * @param brand The new brand to set.
	 * @param id    The ID of the bike to be updated.
	 * @return True if the bike's brand is updated successfully, false otherwise.
	 * @throws DAOException If a database-related error occurs.
	 * @throws SQLException If a SQL-related error occurs.
	 */
	public static boolean updateBike(String brand, int id) throws DAOException, SQLException {
		if (BikeValidator.validateId(id) && BikeValidator.validateBrand(brand)) {
			return BikeDao.updateBike(brand, id);
		}
		return false;
	}

	/**
	 * Reads and displays information about all bikes.
	 *
	 * @return True if bike information is read and displayed successfully, false
	 *         otherwise.
	 * @throws DAOException If a database-related error occurs.
	 */
	public static boolean readBike() throws DAOException {
		return BikeDao.readBike();
	}

	/**
	 * Deletes a bike with the specified ID from the database.
	 *
	 * @param id The ID of the bike to be deleted.
	 * @return True if the bike is deleted successfully, false otherwise.
	 * @throws DAOException If a database-related error occurs.
	 * @throws SQLException If a SQL-related error occurs.
	 */
	public static boolean deleteBike(int id) throws DAOException, SQLException {
		if (BikeValidator.validateId(id)) {
			return BikeDao.deleteBike(id);
		}
		return false;
	}
}
