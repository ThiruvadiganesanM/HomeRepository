package edu.disease.asn6;

import java.util.List;
import java.util.UUID;

import edu.disease.asn3.Exposure;
import edu.disease.asn3.Disease;

public interface DiseaseControlManager {
	public abstract Disease addDisease(String diseaseName,boolean isInfectious);
	public abstract Disease getDisease(UUID diseaseId);
	public abstract Patient addPatient(String firstName,String lastName,int maxDiseases,int maxExposures);
	public abstract Patient getPatient(UUID patientId);
	public abstract void addDiseaseToPatient(UUID patientId,UUID diseaseId);
	public abstract void addExposureToPatient(UUID patientId,Exposure exposure);
	
	public List<Disease> getDiseases();
	public List<Patient> getPatient();
}