package edu.disease.asn3;

import java.io.Serializable;
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

