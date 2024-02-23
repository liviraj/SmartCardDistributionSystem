package com.scds.utill;

import java.util.UUID;

public class RationCardUtil {
	public static String generateUniqueNumber() {
		// Generate a random UUID
		UUID uuid = UUID.randomUUID();

		// Extract the numerical part and format it as a 10-digit number
		long numericValue = Math.abs(uuid.getMostSignificantBits()); // Use the most significant bits for better
																		// randomness
		String formattedNumber = String.format("%010d", numericValue);

		return formattedNumber.substring(0, 10);
	}

}
