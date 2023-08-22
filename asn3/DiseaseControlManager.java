package edu.disease.asn3;

import java.util.UUID;

import edu.disease.asn1.Exposure;

public interface DiseaseControlManager {
	public abstract Disease addDisease(String diseaseName,boolean isInfectious);
	public abstract Disease getDisease(UUID diseaseId);
	public abstract Patient addPatient(String firstName,String lastName,int maxDiseases,int maxExposures);
	public abstract Patient getPatient(UUID patientId);
	public abstract void addDiseaseToPatient(UUID patientId,UUID diseaseId);
	public abstract void addExposureToPatient(UUID patientId,Exposure exposure);
	
	public Disease[] getDiseases();
	public Patient[] getPatient();
}
