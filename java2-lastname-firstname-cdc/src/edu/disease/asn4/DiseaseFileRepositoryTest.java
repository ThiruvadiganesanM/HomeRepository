package edu.disease.asn3;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class DiseaseFileRepositoryTest {
	Disease[] diseases = new Disease[2];
	Patient[] patients = new Patient[2];

	@Test
	public void testSave() throws IOException {
		DiseaseFileRepository dfr = new DiseaseFileRepository();
		dfr.save(diseases, patients);
		assertNotNull(dfr);
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

	
	@Test
	public void testInit() throws ClassNotFoundException, IOException {
		String folderPath="D:\\Ganesh";
		DiseaseFileRepository dfr = new DiseaseFileRepository();
		assertNotNull(dfr.init(folderPath));
	}
	public void testInit1() throws ClassNotFoundException, IOException {
		String folderPath=null;
		DiseaseFileRepository dfr=new DiseaseFileRepository();
		assertThrows(IllegalArgumentException.class,()->dfr.init(folderPath));
	}
}
