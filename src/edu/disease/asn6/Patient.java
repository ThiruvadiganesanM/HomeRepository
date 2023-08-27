
package edu.disease.asn6;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.UUID;
import java.util.List;

import edu.disease.asn3.Exposure;

public class Patient implements Comparable<Patient>, Serializable {
	private UUID patientId;
	private String firstName;
	private String lastName;
	private List<Exposure> exposures;
	private List<UUID> diseaseIds;
	
	public Patient() {
		exposures =new LinkedList<>();
		diseaseIds=new LinkedList<>();
		}
	public void addDiseaseId(UUID diseaseid) {
		diseaseIds.add(diseaseid);
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

	public void addExposure(Exposure exposure) {
		
		exposures.add(exposure);

	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", exposures=" + exposures + ", diseaseIds=" + diseaseIds + "]";
	}
	public int compareTo(Patient o) {
		int isEqual = this.lastName.compareToIgnoreCase(o.lastName);
		if (isEqual != 0) {
			return isEqual;
		} else {
			return this.firstName.compareToIgnoreCase(o.firstName);
		}
	}

	public List<UUID> getDiseaseIds() {
		return diseaseIds;
	}

	public void setDiseaseIds(List<UUID> diseaseIds) {
		this.diseaseIds = diseaseIds;
	}

	public List<Exposure> getExposures() {
		return exposures;
	}

	public void setExposures(List<Exposure> exposures) {
		this.exposures = exposures;
	}
}