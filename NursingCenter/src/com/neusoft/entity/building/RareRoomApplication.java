package com.neusoft.entity.building;

import com.neusoft.entity.Patient;

import java.io.Serializable;
import java.util.Date;
/*
 * @Author DengYimo
 * @Date  4:51
 * @Description This is description of class
 * @Since version-1.0
 */
public class RareRoomApplication implements Serializable {
    public static long TIMESCALE = 1000 * 60 * 60;
    private Date startTime;
    private long durationTime;
    private Patient applier;
    private Room room;
/*
 * @Author DengYimo
 * @Date  4:51
 * @Description This is description of method
 * @Param []
 * @Return java.util.Date
 * @Since version-1.0
 */
    public Date getStartTime() {
        return startTime;
    }
/*
 * @Author DengYimo
 * @Date  4:51
 * @Description This is description of method
 * @Param [startTime]
 * @Return void
 * @Since version-1.0
 */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
/*
 * @Author DengYimo
 * @Date  4:51
 * @Description This is description of method
 * @Param []
 * @Return long
 * @Since version-1.0
 */
    public long getDurationTime() {
        return durationTime;
    }
/*
 * @Author DengYimo
 * @Date  4:51
 * @Description This is description of method
 * @Param [durationTime]
 * @Return void
 * @Since version-1.0
 */
    public void setDurationTime(long durationTime) {
        this.durationTime = durationTime;
    }
/*
 * @Author DengYimo
 * @Date  4:51
 * @Description This is description of method
 * @Param [durationTime]
 * @Return void
 * @Since version-1.0
 */
    public void setDurationTime(int durationTime) {
        this.durationTime = durationTime;
    }
/*
 * @Author DengYimo
 * @Date  4:52
 * @Description This is description of method
 * @Param []
 * @Return com.neusoft.entity.Patient
 * @Since version-1.0
 */
    public Patient getApplier() {
        return applier;
    }
/*
 * @Author DengYimo
 * @Date  4:52
 * @Description This is description of method
 * @Param [applier]
 * @Return void
 * @Since version-1.0
 */
    public void setApplier(Patient applier) {
        this.applier = applier;
    }
/*
 * @Author DengYimo
 * @Date  4:52
 * @Description This is description of method
 * @Param []
 * @Return com.neusoft.entity.building.Room
 * @Since version-1.0
 */
    public Room getRoom() {
        return room;
    }
/*
 * @Author DengYimo
 * @Date  4:52
 * @Description This is description of method
 * @Param [room]
 * @Return void
 * @Since version-1.0
 */
    public void setRoom(Room room) {
        this.room = room;
    }
/*
 * @Author DengYimo
 * @Date  4:52
 * @Description This is description of method
 * @Param [startTime, durationTime, applier, room]
 * @Return 
 * @Since version-1.0
 */
    public RareRoomApplication(Date startTime, long durationTime, Patient applier, Room room) {
        this.startTime = startTime;
        this.durationTime = durationTime;
        this.applier = applier;
        this.room = room;
    }
/*
 * @Author DengYimo
 * @Date  4:52
 * @Description This is description of method
 * @Param []
 * @Return 
 * @Since version-1.0
 */
    public RareRoomApplication() {
    }
/*
 * @Author DengYimo
 * @Date  4:54
 * @Description This is description of method
 * @Param [startTime, durationTime, applier, room]
 * @Return 
 * @Since version-1.0
 */
    public RareRoomApplication(Date startTime, int durationTime, Patient applier, Room room) {
        this.startTime = startTime;
        this.durationTime = durationTime;
        this.applier = applier;
        this.room = room;
    }

}
