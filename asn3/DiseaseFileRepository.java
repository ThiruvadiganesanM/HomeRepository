package edu.disease.asn3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DiseaseFileRepository {
	String folderPath;

	public void save(Disease[] diseases, Patient[] patients) throws IOException {
		FileOutputStream diseaseFile = new FileOutputStream(folderPath + "\\diseases.dat");
		ObjectOutputStream output = new ObjectOutputStream(diseaseFile);
		output.writeObject(diseases);
		FileOutputStream patientFile = new FileOutputStream("\\patients.date11");
		ObjectOutputStream patientOutput = new ObjectOutputStream(patientFile);
		patientOutput.writeObject(patients);
	}

	public DiseaseAndPatient init(String folderPath) throws IOException, ClassNotFoundException {
		if (folderPath == null) {
			throw new IllegalArgumentException("The folder is empty");
		} else {
			DiseaseAndPatient diseasePatient = new DiseaseAndPatient();
			this.folderPath = folderPath;
			FileInputStream disease = new FileInputStream(folderPath + "\\diseases.dat");
			ObjectInputStream diseaseInput = new ObjectInputStream(disease);
			diseasePatient.setDiseases((Disease[]) diseaseInput.readObject());

			FileInputStream patient = new FileInputStream(folderPath + "\\patients.dat");
			ObjectInputStream patientInput = new ObjectInputStream(patient);
			diseasePatient.setPatients((Patient[]) patientInput.readObject());
			return diseasePatient;
		}
	}
}
