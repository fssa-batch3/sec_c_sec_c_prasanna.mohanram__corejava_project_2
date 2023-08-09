package com.fssa.bikerzzone.validator;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.bikerzzone.enums.Ownership;
import com.fssa.bikerzzone.errors.BikeValidatorErrors;
import com.fssa.bikerzzone.model.Bike;

public class BikeValidator {

	public static boolean validate(Bike bike) throws Exception {

		if (bike == null) {
			throw new Exception(BikeValidatorErrors.INVALID_BIKE_NULL);
		}
		return true;
	}

	public static boolean validateId(long id) throws Exception {

		if (id <= 0) {
			throw new Exception(BikeValidatorErrors.INVALID_ID);
		}
		return true;
	}

	public static boolean validateBrand(String brand) throws Exception {

		if (brand == null) {
			throw new Exception(BikeValidatorErrors.INVALID_BRAND_NULL);
		}

		String regex = "^[A-Za-z\\s-]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(brand);
		Boolean isMatch = matcher.matches();

		if (Boolean.FALSE.equals(isMatch)) {
			throw new Exception(BikeValidatorErrors.INVALID_BRAND_PATTERN);
		}
		return true;
	}

	public static boolean validateModel(String model) throws Exception {

		if (model == null || model.trim().equals("")) {
			throw new Exception(BikeValidatorErrors.INVALID_MODEL_NULL);
		}

		String regex = "^[A-Za-z0-9]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(model);
		Boolean isMatch = matcher.matches();

		if (Boolean.FALSE.equals(isMatch)) {
			throw new Exception(BikeValidatorErrors.INVALID_MODEL_PATTERN);
		}
		return true;

	}

	public static boolean validatePrice(double price) throws Exception {

		if (price <= 0 || price < 10000 || price > 10000000) {
			throw new Exception(BikeValidatorErrors.INVALID_PRICE);
		}
		return true;
	}

	public static boolean validateLocation(String location) throws Exception {

		if (location == null) {
			throw new Exception(BikeValidatorErrors.INVALID_LOCATION_NULL);
		}

		String regex = "^[A-Za-z]{2,50}+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(location);
		Boolean isMatch = matcher.matches();

		if (Boolean.FALSE.equals(isMatch)) {
			throw new Exception(BikeValidatorErrors.INVALID_LOCATION_PATTERN);
		}
		return true;
	}

	public static boolean validateManufactureDate(LocalDate manufactureDate) throws Exception {
		LocalDate today = LocalDate.now();
		if (manufactureDate == null) {
			throw new Exception(BikeValidatorErrors.INVALID_MANUFACTUREDATE_NULL);
		} else if (manufactureDate.isAfter(today)) {
			throw new Exception(BikeValidatorErrors.INVALID_MANUFACTUREDATE_PATTERN);
		} else {
			return true;
		}
	}

	public static boolean validateOwnership(String ownership) throws Exception {

		for (Ownership owner : Ownership.values()) {
			if (owner.toString().equalsIgnoreCase(ownership)) {
				return true;
			}
		}

		throw new Exception(BikeValidatorErrors.INVALID_OWNERSHIP);
	}

}
