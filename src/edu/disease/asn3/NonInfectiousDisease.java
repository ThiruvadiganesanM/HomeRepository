package edu.disease.asn3;

import java.io.Serializable;
import java.util.UUID;

public class NonInfectiousDisease extends Disease {
	String[] disease= {"Heart Disease","Cancer","Diabetes","Stroke"};
	@Override
	public String[] getExamples() {
		return disease;
	}
	
	public NonInfectiousDisease(){
		
	}
}