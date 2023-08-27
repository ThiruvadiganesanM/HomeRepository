package edu.disease.asn6;

import java.util.List;

import edu.disease.asn3.Disease;

public class DiseaseAndPatient {
	private List<Disease> diseases;
	private List<Patient> patients;
	public DiseaseAndPatient() {
		
	}
	public DiseaseAndPatient(List<Disease> diseases, List<Patient> patients) {
		super();
		this.diseases = diseases;
		this.patients = patients;
	}
	public List<Disease> getDiseases() {
		return diseases;
	}
	public void setDiseases(List<Disease> diseases) {
		this.diseases = diseases;
	}
	public List<Patient> getPatients() {
		return patients;
	}
	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

}