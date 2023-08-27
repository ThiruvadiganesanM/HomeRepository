package edu.disease.asn1;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;

public class Exposure {
	private UUID patientId;
	private LocalDateTime dateTime;
	private String exposureType;

/**
 * for set patientId
 * @param patientId
 */
	public Exposure(UUID patientId) {
		setPatientId(patientId);
	}

/**
 *  override hashcode method for creating unique hashcode based on fields
 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime * result + ((exposureType == null) ? 0 : exposureType.hashCode());
		result = prime * result + ((patientId == null) ? 0 : patientId.hashCode());
		return result;
	}
	/**
	 * override equals methods to compare fields
	 */
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
	/**
	 * override toString method for printing purpose
	 */
	public String toString() {

		return super.toString();
	}
	/**
	 * getPatientId is used to get the patient id
	 * @return
	 */
	public UUID getPatientId() {
		return patientId;
	}
	/**
	 * to used to get Date Time
	 * @return
	 */
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	/**
	 * is used to get ExposureType
	 * @return
	 */
	public String getExposureType() {
		return exposureType;
	}
	/**
	 * is used to set patient ID
	 * @param patientId
	 */
	public void setPatientId(UUID patientId) {
		this.patientId = patientId;
	}
	/**
	 * is used to set date time
	 * @param datetime
	 */
	public void setDateTime(LocalDateTime datetime) {
		this.dateTime = datetime;
	}
	/**
	 * is used to set Exposure Type
	 * @param exposuretype
	 */
	public void setExposureType(String exposuretype) {
		if((exposuretype.equalsIgnoreCase("D")||(exposuretype.equalsIgnoreCase("I")))){
			this.exposureType=exposuretype;
		}
		else {
			try {
				throw new IllegalArgumentException();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
	}

}