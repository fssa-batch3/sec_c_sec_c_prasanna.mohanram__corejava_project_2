package com.fssa.bikerzzone.errors;

public class BikeValidatorErrors {

	private BikeValidatorErrors() {

	}

	public static final String INVALID_BIKE_NULL = "Bike can't be null";

	public static final String INVALID_ID = "Id can't be zero or less than zero";

	public static final String INVALID_BRAND_NULL = "Brand can't be null";

	public static final String INVALID_MODEL_NULL = "Model can't be null";

	public static final String INVALID_PRICE = "Price can't be zero or less than zero and price should be greater than 10000 and lesser than 10000000";

	public static final String INVALID_LOCATION_NULL = "Location can't be null";

	public static final String INVALID_BRAND_PATTERN = "Brand's pattern is wrong!";

	public static final String INVALID_MODEL_PATTERN = "Model's pattern is wrong!";

	public static final String INVALID_LOCATION_PATTERN = "Location's pattern is wrong!";

	public static final String INVALID_MANUFACTUREDATE_NULL = "ManufactureDate can't be null";

	public static final String INVALID_MANUFACTUREDATE_PATTERN = "ManufactureDate can't be in future!";

	public static final String INVALID_OWNERSHIP = "Ownership is invalid!";
}
