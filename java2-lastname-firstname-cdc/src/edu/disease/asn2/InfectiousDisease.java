package edu.disease.asn2;

import java.util.UUID;

public class InfectiousDisease extends Disease{
	String[] disease= {"Corona","Influenza","Dengu","Fungus"};
	@Override
	public String[] getExamples() {
		return disease;
	}
	public InfectiousDisease(UUID diseaseId,String name) {
		super(diseaseId,name);
	}
	public InfectiousDisease() {
		
	}

}

