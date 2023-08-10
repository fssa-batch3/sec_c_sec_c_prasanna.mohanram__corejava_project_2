package com.fssa.bikerzzone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fssa.bikerzzone.logger.Logger;
import com.fssa.bikerzzone.model.Bike;
import com.fssa.bikerzzone.validator.BikeValidator;

public class BikeDao {

	private BikeDao() {

	}

	public static boolean addBike(Bike bike) throws Exception {
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

	public static Bike findBikesByBrand(String brand) throws SQLException {

		Bike bike = null;

		try (Connection connection = ConnectionUtil.getConnection()) {
			String query = "SELECT * FROM bike WHERE brand = ?";

			try (PreparedStatement pst = connection.prepareStatement(query)) {

				pst.setString(1, brand);

				try (ResultSet rs = pst.executeQuery()) {

					while (rs.next()) {

						Logger.info("id: " + rs.getInt(1));
						Logger.info("brand: " + rs.getString(2));
						Logger.info("model: " + rs.getString(3));
						Logger.info("price: " + rs.getDouble(4));
						Logger.info("ownership: " + rs.getString(5));
						Logger.info("location: " + rs.getString(6));
						Logger.info("Manufacture Date: " + rs.getDate("manufactureDate").toLocalDate());

					}
				}
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);

		}
		return bike;

	}

	public static boolean readBike() throws SQLException {

		try (Connection connection = ConnectionUtil.getConnection()) {
			String query = "SELECT * FROM bike";

			try (Statement statement = connection.createStatement()) {

				try (ResultSet rs = statement.executeQuery(query)) {

					while (rs.next()) {

						Logger.info("id: " + rs.getInt(1));
						Logger.info("brand: " + rs.getString(2));
						Logger.info("model: " + rs.getString(3));
						Logger.info("price: " + rs.getDouble(4));
						Logger.info("ownership: " + rs.getString(5));
						Logger.info("location: " + rs.getString(6));
						Logger.info("manufacture Date: " + rs.getDate(7));
						Logger.info("\n");

					}
					return true;
				}
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);

		}

	}

	public static boolean updateBike(String brand, int id) throws Exception {

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

	public static boolean deleteBike(int id) throws Exception {

		try (Connection connection = ConnectionUtil.getConnection()) {
			String query = "DELETE FROM bike WHERE id = ?";

			try (PreparedStatement pst = connection.prepareStatement(query)) {

				pst.setInt(1, id);
				int row = pst.executeUpdate();

				return (row > 0);
			}
		}
	}

	public static boolean readBikeAll(String brand) throws SQLException {

		try (Connection connection = ConnectionUtil.getConnection()) {
			String query = "SELECT * FROM bike WHERE brand = ?";

			try (PreparedStatement pst = connection.prepareStatement(query)) {

				pst.setString(1, brand);

				try (ResultSet rs = pst.executeQuery()) {

					while (rs.next()) {
						Logger.info("id: " + rs.getInt("id"));
						Logger.info("brand: " + rs.getString("brand"));
						Logger.info("model: " + rs.getString("model"));
						Logger.info("price: " + rs.getDouble("price"));
						Logger.info("ownership: " + rs.getString("ownership"));
						Logger.info("location: " + rs.getString("location"));
						Logger.info("manufacture Date: " + rs.getDate("manufactureDate"));
						Logger.info("\n");

					}

				}

			}

		} catch (SQLException ex) {
			throw new SQLException(ex);

		}
		return true;

	}
}
