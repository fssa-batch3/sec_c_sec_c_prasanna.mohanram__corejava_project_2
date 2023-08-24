package com.fssa.bikerzzone.exceptions;

/**
 * Custom exception class for database-related errors.
 */
public class DAOException extends Exception {

	private static final long serialVersionUID = 7L;

	/**
	 * Constructs a new DAOException with the specified detail message.
	 *
	 * @param msg The detail message.
	 */
	public DAOException(String msg) {
		super(msg);
	}

	/**
	 * Constructs a new DAOException with the specified cause.
	 *
	 * @param te The cause (which is saved for later retrieval by the getCause()
	 *           method).
	 */
	public DAOException(Throwable te) {
		super(te);
	}

	/**
	 * Constructs a new DAOException with the specified detail message and cause.
	 *
	 * @param msg The detail message.
	 * @param te  The cause (which is saved for later retrieval by the getCause()
	 *            method).
	 */
	public DAOException(String msg, Throwable te) {
		super(msg, te);
	}
}
