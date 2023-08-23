package edu.disease.asn3;

import java.io.Serializable;
import java.util.UUID;

public abstract class Disease implements Serializable {
UUID diseaseId;
String name;
public Disease() {
	
}
public Disease(UUID diseasesId, String name) {
	super();
	this.diseaseId = diseasesId;
	this.name = name;
}
public int hashCode() {
	return super.hashCode();
}
public boolean equals(Object obj) {
	return super.equals(obj);
}
public String toString() {
	return super.toString();
}
public UUID getDiseaseId() {
	return diseaseId;
}
public void setDiseaseId(UUID diseasesId) {
	this.diseaseId = diseasesId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public abstract String[] getExamples();
	

}


