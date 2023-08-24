package com.fssa.bikerzzone.dao;

import java.sql.Connection;

import java.sql.DriverManager;

import com.fssa.bikerzzone.logger.Logger;

/**
 * This class provides utility methods for establishing a database connection.
 */
public class ConnectionUtil {

	/**
	 * Establishes a database connection using the provided connection parameters.
	 *
	 * @return A Connection object representing the established database connection.
	 */
	public static Connection getConnection() {
		Connection con = null;

		// Database connection parameters
		String url;
		String userName;
		String passWord;

		url = System.getenv("DATABASE_HOST");
		userName = System.getenv("DATABASE_USERNAME");
		passWord = System.getenv("DATABASE_PASSWORD");

		try {
			// Load the MySQL JDBC driver class
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Establish the database connection
			con = DriverManager.getConnection(url, userName, passWord);
			Logger.info("Connection created");
		} catch (Exception e) {
			// Handle any exceptions that occur during connection establishment
			e.getMessage();
		}
		return con;
	}

	/**
	 * Entry point of the program for testing the getConnection method.
	 *
	 * @param args Command-line arguments (unused).
	 */
	public static void main(String[] args) {
		// Test the getConnection method
		ConnectionUtil.getConnection();
	}
}
