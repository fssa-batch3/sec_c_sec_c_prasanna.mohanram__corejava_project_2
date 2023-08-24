package com.fssa.bikerzzone.logger;

/**
 * A simple logging utility class for printing log messages to the console.
 */
public class Logger {
	/**
	 * Default constructor for creating a Logger object.
	 */
	private Logger() {
		// Default constructor
	}

	/**
	 * Print an informational log message to the console.
	 *
	 * @param msg The log message to be printed.
	 */
	public static void info(String msg) {
		System.out.println(msg);
//      Logger.info(msg); // This line is commented out to prevent potential recursive call
	}
}
