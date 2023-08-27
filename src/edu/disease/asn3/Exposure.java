package edu.disease.asn3;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;

public class Exposure implements Serializable {
	private UUID patientId;
	private LocalDateTime dateTime;
	private String exposureType;

	public Exposure(UUID patientId) {
		setPatientId(patientId);
	}

	public Exposure(String exposuretype, LocalDateTime dateTime) {
		setExposureType(exposuretype);
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime * result + ((exposureType == null) ? 0 : exposureType.hashCode());
		result = prime * result + ((patientId == null) ? 0 : patientId.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exposure other = (Exposure) obj;
		if (dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
			return false;
		if (exposureType == null) {
			if (other.exposureType != null)
				return false;
		} else if (!exposureType.equals(other.exposureType))
			return false;
		if (patientId == null) {
			if (other.patientId != null)
				return false;
		} else if (!patientId.equals(other.patientId))
			return false;
		return true;
	}

	public String toString() {

		return super.toString();
	}

	public UUID getPatientId() {
		return patientId;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public String getExposureType() {
		return exposureType;
	}

	public void setPatientId(UUID patientId) {
		this.patientId = patientId;
	}

	public void setDateTime(LocalDateTime datetime) {
		this.dateTime = datetime;
	}

	public void setExposureType(String exposuretype) {
		if (exposuretype.equalsIgnoreCase("D")) {
			this.exposureType = "D";
		} else if (exposuretype.equalsIgnoreCase("I")) {
			this.exposureType = "I";
		} else {
			try {
				throw new IllegalArgumentException();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
	}

}