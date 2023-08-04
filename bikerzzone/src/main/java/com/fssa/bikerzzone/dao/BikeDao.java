package com.fssa.bikerzzone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
//import java.util.logging.Logger;

import com.fssa.bikerzzone.enums.Ownership;
import com.fssa.bikerzzone.model.Bike;
import com.fssa.bikerzzone.validator.BikeValidator;

public class BikeDao {

//	public static final Logger LOGGER = Logger.getLogger(BikeDao.class.getName());

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

				return (row > 0) ? true : false;
			}
		}
	}

	public static Bike findBikesByBrand(String brand) throws SQLException {

		Bike bike = null;

		try (Connection connection = ConnectionUtil.getConnection()) {
			String query = "SELECT * FROM bike WHERE brand = ?";
			try (PreparedStatement pst = connection.prepareStatement(query)) {
				pst.setString(1, brand);

				try (ResultSet resultSet = pst.executeQuery()) {
					while (resultSet.next()) {
//						bike = new bike();
//						bike.setName(resultSet.getString("name"));
//						bike.setSymbol(resultSet.getString("symbol"));
//						bike.setRank(resultSet.getInt("ranking"));
//						bike.setPrice(resultSet.getDouble("price"));
//						bike.setMarketCap(resultSet.getDouble("market_cap"));
//						bike.setTotalSupply(resultSet.getDouble("total_supply"));
//						bike.setMaximumSupply(resultSet.getDouble("maximum_supply"));
//						bike.setVolume24h(resultSet.getDouble("volume_24h"));
//						bike.setAllTimeHigh(resultSet.getDouble("all_time_high"));
//						bike.setAllTimeLow(resultSet.getDouble("all_time_low"));
//						bike.setCreationDate(resultSet.getDate("creationdate").toLocalDate());

						System.out.println("id: " + resultSet.getInt(1));
						System.out.println("Brand: " + resultSet.getString(2));
						System.out.println("model: " + resultSet.getString(3));
						System.out.println("price: " + resultSet.getDouble(4));
						System.out.println("Ownership: " + resultSet.getString(5));
						System.out.println("Location: " + resultSet.getString(6));
						System.out.println("Manufacture Date: " + resultSet.getDate("manufactureDate").toLocalDate());

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
						System.out.println("id: " + rs.getInt(1));
						System.out.println("brand: " + rs.getString(2));
						System.out.println("model: " + rs.getString(3));
						System.out.println("price: " + rs.getDouble(4));
						System.out.println("Ownership: " + rs.getString(5));
						System.out.println("location: " + rs.getString(6));
						System.out.println("manufacture Date: " + rs.getDate(7));
						System.out.println("\n");

					}
					return true;
				}
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);

		}

	}

	public static boolean updateBike(String brand, int id) throws Exception {
//		BikeValidator.validate(bike);
		try (Connection connection = ConnectionUtil.getConnection()) {
			String query = "UPDATE bike SET brand = ? WHERE id = ?";
			try (PreparedStatement pst = connection.prepareStatement(query)) {
//
				pst.setString(1, brand);
				pst.setInt(2, id);

				int row = pst.executeUpdate();

				return (row > 0) ? true : false;
			}
		}
	}

	public static boolean deleteBike(int id) throws Exception {
//		BikeValidator.validate(bike);
		try (Connection connection = ConnectionUtil.getConnection()) {
			String query = "DELETE FROM bike WHERE id = ?";
			try (PreparedStatement pst = connection.prepareStatement(query)) {

				pst.setInt(1, id);
				int row = pst.executeUpdate();

				return (row > 0) ? true : false;
			}
		}
	}

	public static boolean readBikeAll(String brand) throws SQLException {

		try (Connection connection = ConnectionUtil.getConnection()) {
			String query = "SELECT * FROM bike WHERE brand = '" + brand + "'";

			try (Statement st = connection.createStatement()) {

				st.addBatch(brand);

				try (ResultSet rs = st.executeQuery(query)) { 

					while (rs.next()) {
						System.out.println("id: " + rs.getInt("id"));
						System.out.println("brand: " + rs.getString("brand"));
						System.out.println("model: " + rs.getString("model"));
						System.out.println("price: " + rs.getDouble("price"));
						System.out.println("location: " + rs.getString("location"));
						System.out.println("manufacture Date: " + rs.getDate("manufactureDate"));
						System.out.println();

					}

				}

			}

		} catch (SQLException ex) {
			throw new SQLException(ex);

		}
		return true;

	}

	public static void main(String[] args) throws Exception {
		Bike bike = new Bike(1, "Yamaha", "R15", 110000, "SECOND", "Chennai", LocalDate.of(1998, 9, 06));

//		addBike(bike);
//		readBike();
//		updateBike("Her", 1);
//		deleteBike(10);
//		readBikeAll("Yamaha");
	}
}
