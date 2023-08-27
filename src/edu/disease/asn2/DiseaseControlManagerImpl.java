package edu.disease.asn2;

import java.util.UUID;

import edu.disease.asn1.Exposure;

public class DiseaseControlManagerImpl implements DiseaseControlManager{
	int maxDiseases,maxPatients;
	int diseaseCount=0,patientCount=0;
	public DiseaseControlManagerImpl(int maxDiseases,int maxPatients) {
		if(maxDiseases <=0 && maxPatients <=0) {
			try {
			throw new IllegalArgumentException();
			}catch(IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
		this.maxDiseases=maxDiseases;
		this.maxPatients=maxPatients;
	}
	private Disease[] diseases=new Disease[maxDiseases];
	private Patient[] patient=new Patient[maxPatients];
	
	
	public Disease addDisease(String diseaseName, boolean isInfectious) {
		Disease disease=null;
		if(disease!=null && diseases.length==diseaseCount) {
			throw new IllegalStateException("disease list is full");
		}
		if(isInfectious==true) {
			disease=new InfectiousDisease();
		}
		else {
			disease=new NonInfectiousDisease();
		}
		if(disease!=null) {
			diseases[diseaseCount++]=disease;
			
		}
	return disease;
	}

	public Disease getDisease(UUID diseaseId) {
		Disease disease1=null;
		for(int i=0;i<diseases.length;i++) {
			if(diseaseId==diseases[i].getDiseaseId()) {
				disease1=diseases[i];
			}
		}
		if(disease1==null) {
			try {
			throw new NullPointerException();
			}catch(NullPointerException e) {
				e.printStackTrace();
			}
		}
		return disease1;
	}

	public Patient addPatient(String firstName, String lastName, int maxDiseases, int maxExposures) {
		Patient p1=new Patient(maxDiseases,maxExposures);
		p1.setPatientId(UUID.randomUUID());
		if(patientCount==patient.length) {
			try {
			throw new IllegalStateException("Patient list is full");
			}
			catch(IllegalStateException e) {
				e.printStackTrace();
			}
		}else {
			patient[patientCount++]=p1;
		}
		return p1;
	}

	public Patient getPatient(UUID patientId) {
		Patient p1=null;
		for(int i=0;i<patient.length;i++) {
			if(patientId==patient[i].patientId) {
				p1=patient[i];
			}
		}
		if(p1==null) {
			try {
			throw new NullPointerException("No such patient is there in that id");
			}
			catch(NullPointerException e) {
				e.printStackTrace();
			}
		}
		return p1;
	}

	public void addDiseaseToPatient(UUID patientId, UUID diseaseId) {
		Patient pat=null;
		for(int i=0;i<patient.length;i++) {
			if(patientId==patient[i].patientId) {
				pat=patient[i];
			}
		}
		if(pat==null) {
			try {
			throw new NullPointerException("No such patient is there in that id");
			}
			catch(NullPointerException e) {
				e.printStackTrace();
			}
		}
		Disease dis=null;
		for(int i=0;i<diseases.length;i++) {
			if(diseaseId==diseases[i].diseaseId) {
				dis=diseases[i];
			}
		}
		if(dis==null) {
			try {
			throw new NullPointerException("No such disease is there in that id");
			}catch(NullPointerException e) {
				e.printStackTrace();
			}
		}
		pat.addDiseaseId(diseaseId);
	}

	public void addExposureToPatient(UUID patientId, Exposure exposure) {
		Patient patie=null;
		for(int i=0;i<patient.length;i++) {
			if(patientId==patient[i].patientId) {
				patie=patient[i];
			}
		}
		if(patie==null) {
			try {
			throw new NullPointerException("No such patient is there in that id");
			}
			catch(NullPointerException e) {
				e.printStackTrace();
			}
		}

		patie.addExposure(exposure);
	}
}