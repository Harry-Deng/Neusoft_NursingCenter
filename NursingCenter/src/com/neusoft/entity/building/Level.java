package com.neusoft.entity.building;

import java.io.Serializable;
import java.util.ArrayList;
/*
 * @Author DengYimo
 * @Date  4:52
 * @Description This is description of class
 * @Since version-1.0
 */
public class Level implements Serializable {
    private String name;
    private ArrayList<Room> rooms;
    private Building father;
/*
 * @Author DengYimo
 * @Date  4:52
 * @Description This is description of method
 * @Param [father]
 * @Return 
 * @Since version-1.0
 */
    public Level(Building father) {
        rooms = new ArrayList<Room>();
        this.father = father;
    }
/*
 * @Author DengYimo
 * @Date  4:52
 * @Description This is description of method
 * @Param [name, father]
 * @Return 
 * @Since version-1.0
 */
    public Level(String name, Building father) {
        this.name = name;
        rooms = new ArrayList<Room>();
        this.father = father;
    }
/*
 * @Author DengYimo
 * @Date  4:52
 * @Description This is description of method
 * @Param [name, rooms, father]
 * @Return 
 * @Since version-1.0
 */
    public Level(String name, ArrayList<Room> rooms, Building father) {
        this.name = name;
        this.rooms = rooms;
        this.father = father;
    }
/*
 * @Author DengYimo
 * @Date  4:52
 * @Description This is description of method
 * @Param []
 * @Return 
 * @Since version-1.0
 */
    public Level() {
    }
/*
 * @Author DengYimo
 * @Date  4:52
 * @Description This is description of method
 * @Param []
 * @Return com.neusoft.entity.building.Building
 * @Since version-1.0
 */
    public Building getFather() {
        return father;
    }
/*
 * @Author DengYimo
 * @Date  4:52
 * @Description This is description of method
 * @Param [father]
 * @Return void
 * @Since version-1.0
 */
    public void setFather(Building father) {
        this.father = father;
    }
/*
 * @Author DengYimo
 * @Date  4:52
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
 * @Date  4:52
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
 * @Date  4:52
 * @Description This is description of method
 * @Param []
 * @Return java.util.ArrayList<com.neusoft.entity.building.Room>
 * @Since version-1.0
 */
    public ArrayList<Room> getRooms() {
        return rooms;
    }
/*
 * @Author DengYimo
 * @Date  4:52
 * @Description This is description of method
 * @Param [rooms]
 * @Return void
 * @Since version-1.0
 */
    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }
/*
 * @Author DengYimo
 * @Date  4:54
 * @Description This is description of method
 * @Param []
 * @Return java.lang.String
 * @Since version-1.0
 */
    public String toString() {
        return this.name;
    }
}
