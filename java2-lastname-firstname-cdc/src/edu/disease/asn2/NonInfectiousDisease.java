package edu.disease.asn2;

import java.util.UUID;

public class NonInfectiousDisease extends Disease{
	String[] disease= {"Heart Disease","Cancer","Diabetes","Stroke"};
	@Override
	public String[] getExamples() {
		return disease;
	}
	public NonInfectiousDisease(UUID diseaseId,String name) {
		super(diseaseId,name);
	}
	NonInfectiousDisease(){
		
	}
}
