package edu.disease.asn6;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import edu.disease.asn3.Disease;
import edu.disease.asn3.Exposure;
import edu.disease.asn3.InfectiousDisease;
import edu.disease.asn3.NonInfectiousDisease;

public class DiseaseControlManagerImpl implements DiseaseControlManager {
	private List<Disease> diseases;
	private List<Patient> patient;
	int diseaseCount = 0, patientCount = 0;

	public DiseaseControlManagerImpl() {
		diseases = new LinkedList();
		patient = new LinkedList();
	}

	public Disease addDisease(String diseaseName, boolean isInfectious) {
		Disease disease;

		if (isInfectious) {
			disease = new InfectiousDisease();
			disease.setName(diseaseName);
			disease.setDiseaseId(UUID.randomUUID());
		} else {
			disease = new NonInfectiousDisease();
			disease.setName(diseaseName);
			disease.setDiseaseId(UUID.randomUUID());
		}
		this.diseases.add(disease);
		return disease;
	}

	public Disease getDisease(UUID diseaseId) {
		Disease disease1 = null;
		for (Disease diseases1 : diseases) {
			if (diseaseId.equals(diseases1.getDiseaseId())) {
				disease1 = diseases1;
			}
		}
		
		return disease1;
	}

	public Patient addPatient(String firstName, String lastName, int maxDiseases, int maxExposures) {
		Patient p1 = new Patient();
		p1.setPatientId(UUID.randomUUID());
		
			patient.add(p1);
		
		return p1;
	}

	public Patient getPatient(UUID patientId) {
		Patient p1 = null;
		for (int i = 0; i < patient.size(); i++) {
			if (patientId.equals(patient.get(i).getPatientId()) ) {
				p1 = patient.get(i);
			}
		}
		return p1;
	}

	public void addDiseaseToPatient(UUID patientId, UUID diseaseId) {
		Patient pat = null;
		for (int i = 0; i < patient.size(); i++) {
			if (patientId == patient.get(i).getPatientId()) {
				pat = patient.get(i);
				break;
			}
		}
		if (pat == null) {
			throw new IllegalStateException("patient is not found");
		}
		Disease dis = null;
		for (int i = 0; i < diseases.size(); i++) {
			if (diseaseId == diseases.get(i).getDiseaseId()) {
				dis = diseases.get(i);
				break;
			}
		}
		if (dis == null) {
			throw new IllegalStateException("disease is not found");
		}
		pat.addDiseaseId(diseaseId);
	}

	public void addExposureToPatient(UUID patientId, Exposure exposure) {
		Patient patient1 = null;
		for (Patient p : patient) {
			if ( p.getPatientId().equals(patientId)) {
				patient1 = p;
			}

		}
		if (patient1 == null) {
			throw new IllegalArgumentException("patient is not there");
		}

		patient1.addExposure(exposure);
	}

	public List<Disease> getDiseases() {

		return this.diseases;
	}

	public List<Patient> getPatient() {
		return this.patient;
	}

}