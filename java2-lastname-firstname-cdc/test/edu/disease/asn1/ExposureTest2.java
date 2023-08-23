package edu.disease.asn1;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ExposureTest2 {
	public Exposure exposure;
	@Test
public void testMethods() {
		assertNotNull(exposure.getExposureType());
	}
}
