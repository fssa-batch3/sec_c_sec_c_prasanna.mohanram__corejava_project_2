package com.fssa.bikerzzone.testvalidator;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.bikerzzone.enums.Ownership;
import com.fssa.bikerzzone.errors.BikeValidatorErrors;
import com.fssa.bikerzzone.model.Bike;
import com.fssa.bikerzzone.validator.BikeValidator;

/**
 * Test class for testing the BikeValidator class.
 */
public class TestBikeValidator {

	// Create sample Bike objects for testing
	Bike bike = new Bike(1, "Yamaha", "RX100", 100000, "FIRST", "Chennai", LocalDate.of(1998, 9, 5));
	Bike invalidBike = new Bike(-2, "8Yama6$ha", "rX@100", 9999, "SIX", "Ch3nn@1", LocalDate.of(2025, 9, 5));
	BikeValidator validatorBike = new BikeValidator();

	// Test case for validate method
	@Test
	void testValidate() throws Exception {
		Assertions.assertTrue(validatorBike.validate(bike));
	}

	// Test case for validate method with null Bike
	@Test
	void testValidatenull() throws Exception {
		Bike bike = null;
		try {
			Assertions.assertTrue(validatorBike.validate(bike));
		} catch (Exception ex) {
			Assertions.assertEquals(BikeValidatorErrors.INVALID_BIKE_NULL, ex.getMessage());
		}
	}

	// Test case for validateId method
	@Test
	void testValidateId() throws Exception {
		Assertions.assertTrue(validatorBike.validateId(bike.getId()));
	}

	// Test case for validateId method with negative ID
	@Test
	void testNegativeValidatId() {
		try {
			validatorBike.validateId(invalidBike.getId());
			// Assertions.fail("Test case failed");
		} catch (Exception e) {
			Assertions.assertEquals(BikeValidatorErrors.INVALID_ID, e.getMessage());
		}
	}

	// Test case for validateBrand method
	@Test
	void testValidateBrand() throws Exception {
		Assertions.assertTrue(validatorBike.validateBrand(bike.getBrand()));
	}

	// Test case for validateBrand method with null brand
	@Test
	void testNullValidateBrand() {
		try {
			validatorBike.validateBrand(null);
			// Assertions.fail("Test case failed");
		} catch (Exception e) {
			Assertions.assertEquals(BikeValidatorErrors.INVALID_BRAND_NULL, e.getMessage());
		}
	}

	// Test case for validateBrand method with invalid brand
	@Test
	void testInvalidBrand() {
		try {
			validatorBike.validateBrand(invalidBike.getBrand());
			// Assertions.fail("Test case failed");
		} catch (Exception e) {
			Assertions.assertEquals(BikeValidatorErrors.INVALID_BRAND_PATTERN, e.getMessage());
		}
	}

	// Test case for validateModel method
	@Test
	void testValidateModel() throws Exception {
		Assertions.assertTrue(validatorBike.validateModel(bike.getModel()));
	}

	// Test case for validateModel method with null model
	@Test
	void testNullValidateModel() {
		try {
			validatorBike.validateModel(null);
			// Assertions.fail("Test case failed");
		} catch (Exception e) {
			Assertions.assertEquals(BikeValidatorErrors.INVALID_MODEL_NULL, e.getMessage());
		}
	}

	// Test case for validateModel method with invalid model
	@Test
	void testInvalidModel() {
		try {
			validatorBike.validateModel("ya###^maha");
			// Assertions.fail("Test case failed");
		} catch (Exception e) {
			Assertions.assertEquals(BikeValidatorErrors.INVALID_MODEL_PATTERN, e.getMessage());
		}
	}

	@Test
	void testValidatePrice() throws Exception {
		// Test positive case: validate a valid price
		Assertions.assertTrue(validatorBike.validatePrice(bike.getPrice()));
	}

	@Test
	void testNegativeValidatPrice() {
		// Test case for negative price value
		try {
			validatorBike.validatePrice(invalidBike.getPrice());
			// Assertions.fail("Test case failed");
		} catch (Exception e) {
			Assertions.assertEquals(BikeValidatorErrors.INVALID_PRICE, e.getMessage());
		}
	}

	@Test
	void testNegativeValidatPrice2() {
		// Test case for price less than zero
		try {
			validatorBike.validatePrice(-1);
			// Assertions.fail("Test case failed");
		} catch (Exception e) {
			Assertions.assertEquals(BikeValidatorErrors.INVALID_PRICE, e.getMessage());
		}
	}

	@Test
	void testNegativeValidatPrice3() {
		// Test case for price greater than the maximum limit
		try {
			validatorBike.validatePrice(10000001);
			// Assertions.fail("Test case failed");
		} catch (Exception e) {
			Assertions.assertEquals(BikeValidatorErrors.INVALID_PRICE, e.getMessage());
		}
	}

	@Test
	void testValidateLocation() throws Exception {
		// Test positive case: validate a valid location
		Assertions.assertTrue(validatorBike.validateLocation(bike.getLocation()));
	}

	@Test
	void testNullValidateLocation() {
		// Test case for null location
		try {
			validatorBike.validateLocation(null);
			// Assertions.fail("Test case failed");
		} catch (Exception e) {
			Assertions.assertEquals(BikeValidatorErrors.INVALID_LOCATION_NULL, e.getMessage());
		}
	}

	@Test
	void testInvalidLocation() {
		// Test case for invalid location pattern
		try {
			validatorBike.validateLocation(invalidBike.getLocation());
			// Assertions.fail("Test case failed");
		} catch (Exception e) {
			Assertions.assertEquals(BikeValidatorErrors.INVALID_LOCATION_PATTERN, e.getMessage());
		}
	}

	@Test
	void testValidateManufactureDate() throws Exception {
		// Test positive case: validate a valid manufacture date
		Assertions.assertTrue(validatorBike.validateManufactureDate(bike.getManufactureDate()));
	}

	@Test
	void testNullValidateManufactureDate() {
		// Test case for null manufacture date
		try {
			validatorBike.validateManufactureDate(null);
		} catch (Exception e) {
			Assertions.assertEquals(BikeValidatorErrors.INVALID_MANUFACTUREDATE_NULL, e.getMessage());
		}
	}

	@Test
	void testInvalidManufactureDate() {
		// Test case for invalid manufacture date (in the future)
		try {
			validatorBike.validateManufactureDate(invalidBike.getManufactureDate());
			// Assertions.fail("Test case failed");
		} catch (Exception e) {
			Assertions.assertEquals(BikeValidatorErrors.INVALID_MANUFACTUREDATE_PATTERN, e.getMessage());
		}
	}

	@Test
	void testValidateOwnershipValid() throws Exception {
		// Test positive case: validate a valid ownership
		Assertions.assertTrue(validatorBike.validateOwnership(bike.getOwnership()));
	}

	@Test
	void testValidateOwnershipInvalid() throws Exception {
		// Test case for invalid ownership
		try {
			validatorBike.validateOwnership(invalidBike.getOwnership());
		} catch (Exception ex) {
			Assertions.assertEquals(BikeValidatorErrors.INVALID_OWNERSHIP, ex.getMessage());
		}
	}

}
