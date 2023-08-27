
package edu.disease.asn3;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.UUID;

//import edu.disease.asn3.Exposure;

public class Patient implements Comparable<Patient>, Serializable {
	UUID patientId;
	String firstName;
	String lastName;
	Exposure[] exposures;
	UUID[] diseaseIds;
	int count = 0, count1 = 0;

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
		exposures[count1++] = exp;

	}

	public String toString() {
		return "Patient [patientId=" + patientId + ",+" + " lastName=" + lastName + ",firstName=" + firstName + "]";

	}

	public int compareTo(Patient o) {
		int isEqual = this.lastName.compareToIgnoreCase(o.lastName);
		if (isEqual != 0) {
			return isEqual;
		} else {
			return this.firstName.compareToIgnoreCase(o.firstName);
		}
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