package com.fssa.bikerzzone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fssa.bikerzzone.exceptions.DAOException;
import com.fssa.bikerzzone.logger.Logger;
import com.fssa.bikerzzone.model.Bike;
import com.fssa.bikerzzone.validator.BikeValidator;

/**
 * This class provides methods for interacting with the 'bike' table in the
 * database.
 */
public class BikeDao {

	private static final String ID_LABEL = "id: ";
	private static final String BRAND_LABEL = "brand: ";
	private static final String MODEL_LABEL = "model: ";
	private static final String PRICE_LABEL = "price: ";
	private static final String OWNERSHIP_LABEL = "ownership: ";
	private static final String LOCATION_LABEL = "location: ";
	private static final String MANUFACTURE_DATE_LABEL = "manufacture Date: ";

	/**
	 * Private constructor to prevent instantiation.
	 */
	private BikeDao() {

	}

	/**
	 * Adds a bike to the 'bike' table in the database.
	 *
	 * @param bike The Bike object to be added.
	 * @return True if the bike was added successfully, false otherwise.
	 * @throws DAOException If a database-related error occurs.
	 * @throws SQLException If a SQL-related error occurs.
	 */
	public static boolean addBike(Bike bike) throws DAOException, SQLException {
		BikeValidator.validate(bike);
		try (Connection connection = ConnectionUtil.getConnection()) {
			String query = "insert into bike(brand,model,price,ownership,location,manufactureDate)values(?,?,?,?,?,?)";
			try (PreparedStatement pst = connection.prepareStatement(query)) {
				pst.setString(1, bike.getBrand());
				pst.setString(2, bike.getModel());
				pst.setDouble(3, bike.getPrice());
				pst.setString(4, bike.getOwnership());
				pst.setString(5, bike.getLocation());
				pst.setDate(6, java.sql.Date.valueOf(bike.getManufactureDate()));
				int row = pst.executeUpdate();

				return (row > 0);
			}
		}
	}

	/**
	 * Finds bikes in the 'bike' table by brand.
	 *
	 * @param brand The brand of the bikes to search for.
	 * @return A Bike object if a bike with the given brand is found, null
	 *         otherwise.
	 * @throws DAOException If a database-related error occurs.
	 */
	public static Bike findBikesByBrand(String brand) throws DAOException {

		Bike bike = null;

		try (Connection connection = ConnectionUtil.getConnection()) {
			String query = "SELECT * FROM bike WHERE brand = ?";

			try (PreparedStatement pst = connection.prepareStatement(query)) {

				pst.setString(1, brand);

				try (ResultSet rs = pst.executeQuery()) {

					while (rs.next()) {

						Logger.info(ID_LABEL + rs.getInt(1));
						Logger.info(BRAND_LABEL + rs.getString(2));
						Logger.info(MODEL_LABEL + rs.getString(3));
						Logger.info(PRICE_LABEL + rs.getDouble(4));
						Logger.info(OWNERSHIP_LABEL + rs.getString(5));
						Logger.info(LOCATION_LABEL + rs.getString(6));
						Logger.info(MANUFACTURE_DATE_LABEL + rs.getDate("manufactureDate").toLocalDate());

					}
				}
			}
		} catch (SQLException ex) {
			throw new DAOException(ex);

		}
		return bike;
	}

	/**
	 * Reads and logs information about all bikes in the 'bike' table.
	 *
	 * @return True if reading and logging were successful, false otherwise.
	 * @throws DAOException If a database-related error occurs.
	 */

	public static boolean readBike() throws DAOException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String query = "SELECT * FROM bike";

			try (Statement statement = connection.createStatement()) {

				try (ResultSet rs = statement.executeQuery(query)) {

					while (rs.next()) {
						Logger.info(ID_LABEL + rs.getInt(1));
						Logger.info(BRAND_LABEL + rs.getString(2));
						Logger.info(MODEL_LABEL + rs.getString(3));
						Logger.info(PRICE_LABEL + rs.getDouble(4));
						Logger.info(OWNERSHIP_LABEL + rs.getString(5));
						Logger.info(LOCATION_LABEL + rs.getString(6));
						Logger.info(MANUFACTURE_DATE_LABEL + rs.getDate(7));
						Logger.info("\n");
					}
					return true;
				}
			}
		} catch (SQLException ex) {
			throw new DAOException(ex);
		}
	}

	/**
	 * Updates the brand of a bike in the 'bike' table by its ID.
	 *
	 * @param brand The new brand value.
	 * @param id    The ID of the bike to be updated.
	 * @return True if the bike was updated successfully, false otherwise.
	 * @throws SQLException If a SQL-related error occurs.
	 */

	public static boolean updateBike(String brand, int id) throws SQLException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String query = "UPDATE bike SET brand = ? WHERE id = ?";

			try (PreparedStatement pst = connection.prepareStatement(query)) {
				pst.setString(1, brand);
				pst.setInt(2, id);

				int row = pst.executeUpdate();

				return (row > 0);
			}
		}
	}

	/**
	 * Deletes a bike from the 'bike' table by its ID.
	 *
	 * @param id The ID of the bike to be deleted.
	 * @return True if the bike was deleted successfully, false otherwise.
	 * @throws SQLException If a SQL-related error occurs.
	 */

	public static boolean deleteBike(int id) throws SQLException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String query = "DELETE FROM bike WHERE id = ?";

			try (PreparedStatement pst = connection.prepareStatement(query)) {
				pst.setInt(1, id);
				int row = pst.executeUpdate();

				return (row > 0);
			}
		}
	}

	/**
	 * Reads and logs information about bikes in the 'bike' table with a specific
	 * brand.
	 *
	 * @param brand The brand of the bikes to search for.
	 * @return True if reading and logging were successful, false otherwise.
	 * @throws DAOException If a database-related error occurs.
	 */

	public static boolean readBikeAll(String brand) throws DAOException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String query = "SELECT * FROM bike WHERE brand = ?";

			try (PreparedStatement pst = connection.prepareStatement(query)) {
				pst.setString(1, brand);

				try (ResultSet rs = pst.executeQuery()) {
					while (rs.next()) {
						Logger.info(ID_LABEL + rs.getInt("id"));
						Logger.info(BRAND_LABEL + rs.getString("brand"));
						Logger.info(MODEL_LABEL + rs.getString("model"));
						Logger.info(PRICE_LABEL + rs.getDouble("price"));
						Logger.info(OWNERSHIP_LABEL + rs.getString("ownership"));
						Logger.info(LOCATION_LABEL + rs.getString("location"));
						Logger.info(MANUFACTURE_DATE_LABEL + rs.getDate("manufactureDate"));
						Logger.info("\n");
					}
				}
			}
		} catch (SQLException ex) {
			throw new DAOException(ex.getMessage());
		}
		return true;
	}
}
