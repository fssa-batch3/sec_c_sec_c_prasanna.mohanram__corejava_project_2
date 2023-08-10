package com.fssa.bikerzzone.validator;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.bikerzzone.enums.Ownership;
import com.fssa.bikerzzone.errors.BikeValidatorErrors;
import com.fssa.bikerzzone.exceptions.DAOException;
import com.fssa.bikerzzone.model.Bike;

public class BikeValidator {

	public static boolean validate(Bike bike) throws DAOException {

		if (bike == null) {
			throw new DAOException(BikeValidatorErrors.INVALID_BIKE_NULL);
		}
		return true;
	}

	public static boolean validateId(long id) throws DAOException {

		if (id <= 0) {
			throw new DAOException(BikeValidatorErrors.INVALID_ID);
		}
		return true;
	}

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

	public static boolean validateModel(String model) throws DAOException {

		if (model == null || model.trim().equals("")) {
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

	public static boolean validatePrice(double price) throws DAOException {

		if (price <= 0 || price < 10000 || price > 10000000) {
			throw new DAOException(BikeValidatorErrors.INVALID_PRICE);
		}
		return true;
	}

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

	public static boolean validateOwnership(String ownership) throws DAOException {

		for (Ownership owner : Ownership.values()) {
			if (owner.toString().equalsIgnoreCase(ownership)) {
				return true;
			}
		}

		throw new DAOException(BikeValidatorErrors.INVALID_OWNERSHIP);
	}

}
