package edu.disease.asn4;

import edu.disease.asn3.Patient;
import edu.disease.asn3.DiseaseControlManager;
import edu.disease.asn3.DiseaseControlManagerImpl;
import edu.disease.asn3.Exposure;

public class ContactTrace {
	static DiseaseControlManager diseaseControlManager;
	public static PatientZero findPatientZero(Patient patient) 
	{
		if(patient.getExposures().length==0) {
			PatientZero patientZero=new PatientZero();
			patientZero.setPatient(patient);
			patientZero.setExposed(false);
			return patientZero;
		}
		
		Exposure[] exposures=patient.getExposures();
		Exposure earliestExposure=exposures[0];
		for(int i=1;i<exposures.length;i++) {
			if(earliestExposure.getDateTime().isAfter(exposures[i].getDateTime())) {
				earliestExposure=exposures[i];
			}
		}
		Patient earliestPatient=diseaseControlManager.getPatient(earliestExposure.getPatientId());
		return findPatientZero(earliestPatient);
	}
	
	public ContactTrace(DiseaseControlManager diseaseControlManager) {
		this.diseaseControlManager = diseaseControlManager;
	}

}
