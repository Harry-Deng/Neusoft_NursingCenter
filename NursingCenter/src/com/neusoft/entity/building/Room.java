package com.neusoft.entity.building;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
/*
 * @Author DengYimo
 * @Date  4:50
 * @Description This is description of class
 * @Since version-1.0
 */
public class Room implements Serializable {
    public final static String[] RARETYPES = {"棋牌室", "健身房", "娱乐室", "浴室"};
    public final static int GYM = "gym".hashCode();
    public final static int BATHROOM = "bathroom".hashCode();
    public final static int ENTERTAINMENTROOM = "ENTERTAINMENTROOM".hashCode();
    public final static int CHESSROOM = "chessroom".hashCode();
    private String name;
    private boolean isRareRoom;
    private int maxCapacity;
    private int resCapacity;
    private ArrayList<RareRoomApplication> applicationList;

    public ArrayList<RareRoomApplication> getApplicationList() {
        return applicationList;
    }
/*
 * @Author DengYimo
 * @Date  4:50
 * @Description This is description of method
 * @Param [applicationList]
 * @Return void
 * @Since version-1.0
 */
    public void setApplicationList(ArrayList<RareRoomApplication> applicationList) {
        this.applicationList = applicationList;
    }
/*
 * @Author DengYimo
 * @Date  4:50
 * @Description This is description of method
 * @Param []
 * @Return com.neusoft.entity.building.Level
 * @Since version-1.0
 */
    public Level getFather() {
        return father;
    }
/*
 * @Author DengYimo
 * @Date  4:50
 * @Description This is description of method
 * @Param [father]
 * @Return void
 * @Since version-1.0
 */
    public void setFather(Level father) {
        this.father = father;
    }
/*
 * @Author DengYimo
 * @Date  4:50
 * @Description This is description of method
 * @Param 
 * @Return 
 * @Since version-1.0
 */
    private int RareType;
    private ArrayList<Bed> beds;
    private Level father;
/*
 * @Author DengYimo
 * @Date  4:50
 * @Description This is description of method
 * @Param [father]
 * @Return 
 * @Since version-1.0
 */
    public Room(Level father) {
        applicationList = new ArrayList<RareRoomApplication>();
        beds = new ArrayList<Bed>();
        this.father = father;
    }
/*
 * @Author DengYimo
 * @Date  4:50
 * @Description This is description of method
 * @Param [name, isRareRoom, father]
 * @Return 
 * @Since version-1.0
 */
    public Room(String name, boolean isRareRoom, Level father) {
        applicationList = new ArrayList<RareRoomApplication>();
        beds = new ArrayList<Bed>();
        this.name = name;
        this.isRareRoom = isRareRoom;
        this.father = father;
    }
/*
 * @Author DengYimo
 * @Date  4:50
 * @Description This is description of method
 * @Param []
 * @Return java.lang.String
 * @Since version-1.0
 */
    public String getName() {
        return name;
    }
/*
 * @Author DengYimo
 * @Date  4:50
 * @Description This is description of method
 * @Param [name]
 * @Return void
 * @Since version-1.0
 */
    public void setName(String name) {
        this.name = name;
    }
/*
 * @Author DengYimo
 * @Date  4:50
 * @Description This is description of method
 * @Param []
 * @Return 
 * @Since version-1.0
 */
    public Room() {
    }
/*
 * @Author DengYimo
 * @Date  4:50
 * @Description This is description of method
 * @Param []
 * @Return int
 * @Since version-1.0
 */
    public int getMaxCapacity() {
        return maxCapacity;
    }
/*
 * @Author DengYimo
 * @Date  4:50
 * @Description This is description of method
 * @Param [maxCapacity]
 * @Return void
 * @Since version-1.0
 */
    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
/*
 * @Author DengYimo
 * @Date  4:50
 * @Description This is description of method
 * @Param []
 * @Return int
 * @Since version-1.0
 */
    public int getResCapacity() {
        return resCapacity;
    }
/*
 * @Author DengYimo
 * @Date  4:50
 * @Description This is description of method
 * @Param [resCapacity]
 * @Return void
 * @Since version-1.0
 */
    public void setResCapacity(int resCapacity) {
        this.resCapacity = resCapacity;
    }
/*
 * @Author DengYimo
 * @Date  4:50
 * @Description This is description of method
 * @Param [name, isRareRoom, rareType, father, maxCapacity, resCapacity]
 * @Return 
 * @Since version-1.0
 */
    public Room(String name, boolean isRareRoom, int rareType, Level father, int maxCapacity, int resCapacity) {
        applicationList = new ArrayList<RareRoomApplication>();
        beds = new ArrayList<Bed>();
        this.name = name;
        this.isRareRoom = isRareRoom;
        RareType = rareType;
        this.father = father;
        this.maxCapacity = maxCapacity;
        this.resCapacity = resCapacity;
    }
/*
 * @Author DengYimo
 * @Date  4:50
 * @Description This is description of method
 * @Param []
 * @Return boolean
 * @Since version-1.0
 */
    public boolean isRareRoom() {
        return isRareRoom;
    }
/*
 * @Author DengYimo
 * @Date  4:50
 * @Description This is description of method
 * @Param [isRareRoom]
 * @Return void
 * @Since version-1.0
 */
    public void setRareRoom(boolean isRareRoom) {
        this.isRareRoom = isRareRoom;
    }
/*
 * @Author DengYimo
 * @Date  4:50
 * @Description This is description of method
 * @Param []
 * @Return int
 * @Since version-1.0
 */
    public int getRareType() {
        return RareType;
    }
/*
 * @Author DengYimo
 * @Date  4:51
 * @Description This is description of method
 * @Param [rareType]
 * @Return void
 * @Since version-1.0
 */
    public void setRareType(int rareType) {
        RareType = rareType;
    }
/*
 * @Author DengYimo
 * @Date  4:51
 * @Description This is description of method
 * @Param []
 * @Return java.util.ArrayList<com.neusoft.entity.building.Bed>
 * @Since version-1.0
 */
    public ArrayList<Bed> getBeds() {
        return beds;
    }
/*
 * @Author DengYimo
 * @Date  4:51
 * @Description This is description of method
 * @Param [beds]
 * @Return void
 * @Since version-1.0
 */
    public void setBeds(ArrayList<Bed> beds) {
        this.beds = beds;
    }
/*
 * @Author DengYimo
 * @Date  4:51
 * @Description This is description of method
 * @Param []
 * @Return java.lang.String
 * @Since version-1.0
 */
    public String toString() {
        return this.name;
    }
/*
 * @Author DengYimo
 * @Date  4:51
 * @Description This is description of method
 * @Param [s]
 * @Return int
 * @Since version-1.0
 */
    public static int getTypeByChinese(String s) {
        if (s.equals("浴室")) return Room.BATHROOM;
        if (s.equals("健身房")) return Room.GYM;
        if (s.equals("娱乐室")) return Room.ENTERTAINMENTROOM;
        if (s.equals("棋牌室")) return Room.CHESSROOM;
        return -1;
    }
/*
 * @Author DengYimo
 * @Date  4:51
 * @Description This is description of method
 * @Param [hashNum]
 * @Return java.lang.String
 * @Since version-1.0
 */
    public static String getType(int hashNum) {
        if (hashNum == Room.GYM) return "健身房";
        if (hashNum == Room.BATHROOM) return "浴室";
        if (hashNum == Room.ENTERTAINMENTROOM) return "娱乐室";
        if (hashNum == Room.CHESSROOM) return "棋牌室";
        return "无";
    }
/*
 * @Author DengYimo
 * @Date  4:54
 * @Description This is description of method
 * @Param []
 * @Return void
 * @Since version-1.0
 */
    public void refreshApplicationTime() {
        Date now = new Date();
        for (int i = 0; i < applicationList.size(); i++) {
            long applicationTime = applicationList.get(i).getStartTime().getTime();
            if ((new Date(applicationTime + applicationList.get(i).getDurationTime())).before(now)) {
                applicationList.remove(i);
                i--;
            }
        }
        resCapacity = maxCapacity - applicationList.size();
    }
}
