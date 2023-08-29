package com.fssa.bikerzzone.validator;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.bikerzzone.enums.Ownership;
import com.fssa.bikerzzone.errors.BikeValidatorErrors;
import com.fssa.bikerzzone.exceptions.DAOException;
import com.fssa.bikerzzone.model.Bike;

/**
 * Validator class for validating bike information.
 */
public class BikeValidator {

	/**
	 * Validates a Bike object.
	 *
	 * @param bike The Bike object to be validated.
	 * @return True if the Bike object is valid, false otherwise.
	 * @throws DAOException If the bike is null.
	 */
	public static boolean validate(Bike bike) throws DAOException {
		if (bike == null) {
			throw new DAOException(BikeValidatorErrors.INVALID_BIKE_NULL);
		}
		validateId(bike.getId());
		validateBrand(bike.getBrand());
		validateModel(bike.getModel());
		validatePrice(bike.getPrice());
		validateLocation(bike.getLocation());
		validateManufactureDate(bike.getManufactureDate());
		validateOwnership(bike.getOwnership());

		return true;
	}

	/**
	 * Validates an ID.
	 *
	 * @param id The ID to be validated.
	 * @return True if the ID is valid, false otherwise.
	 * @throws DAOException If the ID is zero or negative.
	 */
	public static boolean validateId(long id) throws DAOException {
		if (id <= 0) {
			throw new DAOException(BikeValidatorErrors.INVALID_ID);
		}
		return true;
	}

	/**
	 * Validates a brand.
	 *
	 * @param brand The brand to be validated.
	 * @return True if the brand is valid, false otherwise.
	 * @throws DAOException If the brand is null or has an invalid pattern.
	 */
	public static boolean validateBrand(String brand) throws DAOException {
		if (brand == null) {
			throw new DAOException(BikeValidatorErrors.INVALID_BRAND_NULL);
		}

		String regex = "^[A-Za-z\\s-]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(brand);
		Boolean isMatch = matcher.matches();

		if (Boolean.FALSE.equals(isMatch)) {
			throw new DAOException(BikeValidatorErrors.INVALID_BRAND_PATTERN);
		}
		return true;
	}

	/**
	 * Validates a model.
	 *
	 * @param model The model to be validated.
	 * @return True if the model is valid, false otherwise.
	 * @throws DAOException If the model is null or empty, or has an invalid
	 *                      pattern.
	 */
	public static boolean validateModel(String model) throws DAOException {
		if (model == null || model.trim().isEmpty()) {
			throw new DAOException(BikeValidatorErrors.INVALID_MODEL_NULL);
		}

		String regex = "^[A-Za-z0-9]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(model);
		Boolean isMatch = matcher.matches();

		if (Boolean.FALSE.equals(isMatch)) {
			throw new DAOException(BikeValidatorErrors.INVALID_MODEL_PATTERN);
		}
		return true;
	}

	/**
	 * Validates a price.
	 *
	 * @param price The price to be validated.
	 * @return True if the price is valid, false otherwise.
	 * @throws DAOException If the price is zero, negative, or outside the allowed
	 *                      range.
	 */
	public static boolean validatePrice(double price) throws DAOException {
		if (price <= 0 || price < 10000 || price > 10000000) {
			throw new DAOException(BikeValidatorErrors.INVALID_PRICE);
		}
		return true;
	}

	/**
	 * Validates a location.
	 *
	 * @param location The location to be validated.
	 * @return True if the location is valid, false otherwise.
	 * @throws DAOException If the location is null or has an invalid pattern.
	 */
	public static boolean validateLocation(String location) throws DAOException {
		if (location == null) {
			throw new DAOException(BikeValidatorErrors.INVALID_LOCATION_NULL);
		}

		String regex = "^[A-Za-z]{2,50}+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(location);
		Boolean isMatch = matcher.matches();

		if (Boolean.FALSE.equals(isMatch)) {
			throw new DAOException(BikeValidatorErrors.INVALID_LOCATION_PATTERN);
		}
		return true;
	}

	/**
	 * Validates a manufacture date.
	 *
	 * @param manufactureDate The manufacture date to be validated.
	 * @return True if the manufacture date is valid, false otherwise.
	 * @throws DAOException If the manufacture date is null or in the future.
	 */
	public static boolean validateManufactureDate(LocalDate manufactureDate) throws DAOException {
		LocalDate today = LocalDate.now();
		if (manufactureDate == null) {
			throw new DAOException(BikeValidatorErrors.INVALID_MANUFACTUREDATE_NULL);
		} else if (manufactureDate.isAfter(today)) {
			throw new DAOException(BikeValidatorErrors.INVALID_MANUFACTUREDATE_PATTERN);
		} else {
			return true;
		}
	}

	/**
	 * Validates an ownership status.
	 *
	 * @param ownership The ownership status to be validated.
	 * @return True if the ownership status is valid, false otherwise.
	 * @throws DAOException If the ownership status is invalid.
	 */
	public static boolean validateOwnership(String ownership) throws DAOException {
		for (Ownership owner : Ownership.values()) {
			if (owner.toString().equalsIgnoreCase(ownership)) {
				return true;
			}
		}
		throw new DAOException(BikeValidatorErrors.INVALID_OWNERSHIP);
	}
}
