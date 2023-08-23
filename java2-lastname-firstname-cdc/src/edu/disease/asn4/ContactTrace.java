package edu.disease.asn4;

import edu.disease.asn3.Patient;
import edu.disease.asn3.DiseaseControlManager;
import edu.disease.asn3.Exposure;

public class ContactTrace {
	Patient[] patient;

	public ContactTrace(DiseaseControlManager diseaseControlManager) {
		this.patient = diseaseControlManager.getPatient();
	}

	public static PatientZero findPatientZero(Patient patient) 
	{
		for (int i = patient.getExposures().length; i >= 0; i--) 
		{
			if (patient.getExposures()[i].getExposureType().equalsIgnoreCase("D"))
			{
				for(Patient p:patient)
				{
					
				}
				
				
				
				if (patient.getExposures()[i].getDateTime().isBefore(patient.getExposures()[i - 1].getDateTime())) {

				}
			}

		}
		return null;
	}

}
