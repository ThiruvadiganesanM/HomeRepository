package edu.disease.asn1;

import java.util.UUID;

public class Disease {
UUID diseasesId;
String name;
public int hashCode() {
	return super.hashCode();
}
public boolean equals(Object obj) {
	return super.equals(obj);
}
public String toString() {
	return super.toString();
}
/**
 * is used to get disease id
 * @return
 */
public UUID getDiseasesId() {
	return diseasesId;
}
/**
 * is used to set disease id
 * @param diseasesId
 */
public void setDiseasesId(UUID diseasesId) {
	this.diseasesId = diseasesId;
}
/**
 * is used to get name
 * @return
 */
public String getName() {
	return name;
}
/**
 * is used to set Name
 * @param name
 */
public void setName(String name) {
	this.name = name;
}


}