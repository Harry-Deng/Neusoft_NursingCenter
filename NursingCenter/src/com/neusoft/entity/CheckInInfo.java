package com.neusoft.entity;

import com.neusoft.entity.building.Bed;

import java.io.Serializable;
import java.time.LocalDate;
/*
 * @Author DengYimo
 * @Date  4:48
 * @Description This is description of class
 * @Since version-1.0
 */
public class CheckInInfo implements Serializable {
    private Bed bed;
    private Patient patient;
    private LocalDate checkInTime;
    private LocalDate checkOutTime;
    private boolean isInBed;
/*
 * @Author DengYimo
 * @Date  4:48
 * @Description This is description of method
 * @Param []
 * @Return com.neusoft.entity.building.Bed
 * @Since version-1.0
 */
    public Bed getBed() {
        return bed;
    }
/*
 * @Author DengYimo
 * @Date  4:48
 * @Description This is description of method
 * @Param [bed]
 * @Return void
 * @Since version-1.0
 */
    public void setBed(Bed bed) {
        this.bed = bed;
    }
/*
 * @Author DengYimo
 * @Date  4:48
 * @Description This is description of method
 * @Param []
 * @Return com.neusoft.entity.Patient
 * @Since version-1.0
 */
    public Patient getPatient() {
        return patient;
    }
/*
 * @Author DengYimo
 * @Date  4:48
 * @Description This is description of method
 * @Param [patient]
 * @Return void
 * @Since version-1.0
 */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
/*
 * @Author DengYimo
 * @Date  4:48
 * @Description This is description of method
 * @Param []
 * @Return java.time.LocalDate
 * @Since version-1.0
 */
    public LocalDate getCheckInTime() {
        return checkInTime;
    }
/*
 * @Author DengYimo
 * @Date  4:48
 * @Description This is description of method
 * @Param [checkInTime]
 * @Return void
 * @Since version-1.0
 */
    public void setCheckInTime(LocalDate checkInTime) {
        this.checkInTime = checkInTime;
    }
/*
 * @Author DengYimo
 * @Date  4:48
 * @Description This is description of method
 * @Param []
 * @Return java.time.LocalDate
 * @Since version-1.0
 */
    public LocalDate getCheckOutTime() {
        return checkOutTime;
    }
/*
 * @Author DengYimo
 * @Date  4:48
 * @Description This is description of method
 * @Param [checkOutTime]
 * @Return void
 * @Since version-1.0
 */
    public void setCheckOutTime(LocalDate checkOutTime) {
        this.checkOutTime = checkOutTime;
    }
/*
 * @Author DengYimo
 * @Date  4:48
 * @Description This is description of method
 * @Param []
 * @Return boolean
 * @Since version-1.0
 */
    public boolean isInBed() {
        return isInBed;
    }
/*
 * @Author DengYimo
 * @Date  4:49
 * @Description This is description of method
 * @Param [isInBed]
 * @Return void
 * @Since version-1.0
 */
    public void setInBed(boolean isInBed) {
        this.isInBed = isInBed;
    }
/*
 * @Author DengYimo
 * @Date  4:49
 * @Description This is description of method
 * @Param [bed, patient, checkInTime, checkOutTime, isInBed]
 * @Return
 * @Since version-1.0
 */
    public CheckInInfo(Bed bed, Patient patient, LocalDate checkInTime, LocalDate checkOutTime, boolean isInBed) {
        this.bed = bed;
        this.patient = patient;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.isInBed = isInBed;
    }
/*
 * @Author DengYimo
 * @Date  4:49
 * @Description This is description of method
 * @Param []
 * @Return
 * @Since version-1.0
 */
    public CheckInInfo() {
    }

}
