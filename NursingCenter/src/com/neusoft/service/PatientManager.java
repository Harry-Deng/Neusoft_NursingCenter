package com.neusoft.service;

import com.neusoft.dao.AbstractPatient;
import com.neusoft.entity.Patient;
import com.neusoft.util.FileOperator;
import java.util.List;

public class PatientManager implements AbstractPatient {
    private final List<Patient> patients;
    private static PatientManager singletonInstance;

    private PatientManager() {
        patients = FileOperator.loadData("Patients.json", Patient.class);
    }

    //单例模式
    public static PatientManager getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new PatientManager();
        }
        return singletonInstance;
    }
    //增
    public boolean addPatient(Patient patient) {
        patients.add(patient);
        FileOperator.writeData(patient, "Patients.json");
        return true;
    }
    //删
    public void removePatient(Patient patient) {
        patients.remove(patient);
        FileOperator.writeData(patients, "Patients.json");
    }

    public List<Patient> getPatients() {
        return patients;
    }
}
