package com.neusoft.dao;

import com.neusoft.entity.PatientTester;

import java.util.List;
/*
 * @Author DengYimo
 * @Date  8:48
 * @Description 抽象测试者类
 * @Since version-1.0
 */
public interface AbstractPatientTester {
    boolean addPatientTester(PatientTester patient);
    void removePatientTester(PatientTester patient);
    List<PatientTester> getPatientTesters();
}
