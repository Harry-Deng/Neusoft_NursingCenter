package com.neusoft.dao;

import com.neusoft.entity.Patient;

import java.util.List;
/*
 * @Author DengYimo
 * @Date  8:48
 * @Description 抽象病人接口
 * @Since version-1.0
 */
public interface AbstractPatient {
    boolean addPatient(Patient patient);
    void removePatient(Patient patient);
    List<Patient> getPatients();
}
