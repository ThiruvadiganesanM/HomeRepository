package edu.disease.asn3;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DiseaseAndPatientTest {
	
	Disease[] diseases=new Disease[5];
	Patient[] patients=new Patient[5];
@Test
public void testGetDiseases() {
	
	DiseaseAndPatient dap=new DiseaseAndPatient(diseases,patients);
	 assertNotNull(dap.getDiseases());
}

@Test
public void testSetDiseases() {
	DiseaseAndPatient dap=new DiseaseAndPatient(diseases,patients);
	 dap.setDiseases(diseases);
	 
}
@Test
public void testGetPatients() {
	
	DiseaseAndPatient dap=new DiseaseAndPatient(diseases,patients);
	 assertNotNull(dap.getPatients());
}

@Test
public void testSetPatients() {
	DiseaseAndPatient dap=new DiseaseAndPatient(diseases,patients);
	 dap.setPatients(patients);
}
@Test
public void testDefaultConstructor() {
	DiseaseAndPatient dap=new DiseaseAndPatient();
}

}