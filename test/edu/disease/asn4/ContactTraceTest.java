package edu.disease.asn4;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import edu.disease.asn3.Disease;
import edu.disease.asn3.DiseaseControlManagerImpl;
import edu.disease.asn3.Exposure;
import edu.disease.asn3.Patient;

public class ContactTraceTest {

@Test
public void testContactTrace() {
	DiseaseControlManagerImpl dcm=new DiseaseControlManagerImpl(1,3);
	Disease corona =dcm.addDisease("corona", true);
	UUID coronaId=corona.getDiseaseId();
	
	Patient A=dcm.addPatient("Ganesh", "M", 1, 0);
	UUID Aid=A.getPatientId();
	
	Patient B=dcm.addPatient("Naren", "k", 1, 1);
	UUID Bid=B.getPatientId();
	
	Patient C=dcm.addPatient("Thilak", "A", 1, 2);
	UUID Cid=C.getPatientId();
	
	dcm.addDiseaseToPatient(Aid,coronaId);
	dcm.addDiseaseToPatient(Bid,coronaId);
	dcm.addDiseaseToPatient(Cid, coronaId);
	
	Exposure B_A=new Exposure(Aid);
	LocalDateTime dateTimeB_A=LocalDateTime.of(2023,8,25,22,00);
	B_A.setDateTime(dateTimeB_A);
	B_A.setExposureType("D");
	
	Exposure C_A=new Exposure(Cid);
	LocalDateTime dateTimeC_A=LocalDateTime.of(2023,8,27,22,00);
	C_A.setDateTime(dateTimeC_A);
	C_A.setExposureType("D");
	
	Exposure C_B=new Exposure(Cid);
	LocalDateTime dateTimeC_B=LocalDateTime.of(2023,8,27,22,00);
	C_B.setDateTime(dateTimeC_B);
	C_B.setExposureType("D");
	
	C.addExposure(C_A);
	C.addExposure(C_B);
	
	B.addExposure(B_A);
	
	ContactTrace ct=new ContactTrace(dcm);
	
	PatientZero zero=ct.findPatientZero(C);
	
	System.out.println(zero.getPatient().getFirstName());
}

}
