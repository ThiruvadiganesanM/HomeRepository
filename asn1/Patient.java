package edu.disease.asn1;

import java.time.LocalDateTime;
import java.util.UUID;

public class Patient {
	UUID patientId;
	String firstName;
	String lastName;
	Exposure[] exposures;
UUID []diseaseIds;
	int count = 0, count1 = 0;
	/**
	 * is used to initiate the size of exposures and diseaseIds array
	 * it throw illegalArgumentException when the input is negative or zero
	 * @param maxDiseases
	 * @param maxExposures
	 */
	public Patient(int maxDiseases, int maxExposures) {
		if (maxDiseases <= 0 && maxExposures <= 0) {
			try {
				throw new IllegalArgumentException();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}

		exposures = new Exposure[maxExposures];
		diseaseIds = new UUID[maxDiseases];
	}

	public void addDiseaseId(UUID diseaseid) {
		if (count == diseaseIds.length) {
			try {
				throw new IndexOutOfBoundsException();
			} catch (IndexOutOfBoundsException e) {
				e.printStackTrace();
			}
		}
		diseaseIds[count] = diseaseid;
		count++;
	}

	public UUID getPatientId() {
		return patientId;
	}

	public void setPatientId(UUID patientId) {
		this.patientId = patientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void addExposure(Exposure exp) {
		if (count1 == exposures.length) {
			try {
				throw new IndexOutOfBoundsException();
			} catch (IndexOutOfBoundsException e) {
				e.printStackTrace();
			}
		}
		exposures[count1] = exp;
		count++;
	}

	public UUID[] getDiseaseIds() {
		return diseaseIds;
	}

	public void setDiseaseIds(UUID[] diseaseIds) {
		this.diseaseIds = diseaseIds;
	}

	public Exposure[] getExposures() {
		return exposures;
	}

	public void setExposures(Exposure[] exposures) {
		this.exposures = exposures;
	}
}