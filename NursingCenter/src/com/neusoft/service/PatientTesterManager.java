package com.neusoft.service;

import com.neusoft.dao.AbstractPatientTester;
import com.neusoft.entity.PatientTester;
import com.neusoft.util.FileOperator;

import java.util.List;

public class PatientTesterManager implements AbstractPatientTester {
    private final List<PatientTester> patients;
    private static PatientTesterManager singletonInstance;

    private PatientTesterManager() {
        patients = FileOperator.loadData("PatientTester.json", PatientTester.class);
    }

    //单例模式
    public static PatientTesterManager getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new PatientTesterManager();
        }
        return singletonInstance;
    }
    //增
    public boolean addPatientTester(PatientTester patient) {
        patients.add(patient);
        FileOperator.writeData(patient, "PatientTester.json");
        return true;
    }
    //删
    public void removePatientTester(PatientTester patient) {
        patients.remove(patient);
        FileOperator.writeData(patients, "PatientTester.json");
    }

    public List<PatientTester> getPatientTesters() {
        return patients;
    }
}
