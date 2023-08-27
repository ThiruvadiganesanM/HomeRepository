
package edu.disease.asn3;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.UUID;

import org.junit.jupiter.api.Test;

class DiseaseFileRepositoryTest {
	Disease[] diseases = new Disease[2];
	Patient[] patients = new Patient[2];
	DiseaseFileRepository dfr;
	@Test
	public void testSave() throws IOException, ClassNotFoundException {
		dfr.save(diseases, patients);
		String folderPath="D:\\Ganesh";
		FileInputStream fis=new FileInputStream(folderPath+"diseases.dat");
		ObjectInputStream ois=new ObjectInputStream(fis);
		
		Disease[] disease=(Disease[]) ois.readObject();
		
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	@Test
	public void testInit() throws ClassNotFoundException, IOException {
		Disease d1=new InfectiousDisease();
		d1.setDiseaseId(UUID.randomUUID());
		
		Disease[] diseases= {d1};
		
		String folderPath="D:\\Ganesh";
		
		FileOutputStream fos1=new FileOutputStream(folderPath+ "\\diseases.dat");
		ObjectOutputStream oos1=new ObjectOutputStream(fos1);
		oos1.writeObject(diseases);
		
		Patient p1=new Patient(1,1);
		p1.setPatientId(UUID.randomUUID());
		Patient[] patient= {p1};
		
		FileOutputStream fos2=new FileOutputStream(folderPath+"\\patients.dat");
		ObjectOutputStream oos2=new ObjectOutputStream(fos2);
		oos2.writeObject(patient);
		
		dfr=new DiseaseFileRepository();
	
		DiseaseAndPatient dap=dfr.init(folderPath);
		Disease[] diseases1=dap.getDiseases();
		Patient[] patient1=dap.getPatients();
		assertTrue(diseases1[0].equals(d1) && patient[0].equals(p1));
		
	}
	@Test
	public void testInit2() throws ClassNotFoundException, IOException {
		String folderPath1=null;
		DiseaseFileRepository dfr=new DiseaseFileRepository();
		assertThrows(IllegalArgumentException.class,()->dfr.init(folderPath1));
	}
}