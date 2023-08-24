package com.fssa.bikerzzone.errors;

/**
 * This class provides error messages related to bike validation.
 */
public class BikeValidatorErrors {

	/**
	 * Private constructor to prevent instantiation.
	 */
	private BikeValidatorErrors() {

	}

	/**
	 * Error message for invalid null bike.
	 */
	public static final String INVALID_BIKE_NULL = "Bike can't be null";

	/**
	 * Error message for invalid ID value.
	 */
	public static final String INVALID_ID = "Id can't be zero or less than zero";

	/**
	 * Error message for invalid null brand.
	 */
	public static final String INVALID_BRAND_NULL = "Brand can't be null";

	/**
	 * Error message for invalid null model.
	 */
	public static final String INVALID_MODEL_NULL = "Model can't be null";

	/**
	 * Error message for invalid price value.
	 */
	public static final String INVALID_PRICE = "Price can't be zero or less than zero and price should be greater than 10000 and lesser than 10000000";

	/**
	 * Error message for invalid null location.
	 */
	public static final String INVALID_LOCATION_NULL = "Location can't be null";

	/**
	 * Error message for invalid brand pattern.
	 */
	public static final String INVALID_BRAND_PATTERN = "Brand's pattern is wrong!";

	/**
	 * Error message for invalid model pattern.
	 */
	public static final String INVALID_MODEL_PATTERN = "Model's pattern is wrong!";

	/**
	 * Error message for invalid location pattern.
	 */
	public static final String INVALID_LOCATION_PATTERN = "Location's pattern is wrong!";

	/**
	 * Error message for invalid null manufacture date.
	 */
	public static final String INVALID_MANUFACTUREDATE_NULL = "ManufactureDate can't be null";

	/**
	 * Error message for invalid future manufacture date.
	 */
	public static final String INVALID_MANUFACTUREDATE_PATTERN = "ManufactureDate can't be in the future!";

	/**
	 * Error message for invalid ownership.
	 */
	public static final String INVALID_OWNERSHIP = "Ownership is invalid!";
}
