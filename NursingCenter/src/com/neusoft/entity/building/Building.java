package com.neusoft.entity.building;

import java.io.Serializable;
import java.util.ArrayList;
/*
 * @Author DengYimo
 * @Date  4:52
 * @Description This is description of class
 * @Since version-1.0
 */
public class Building implements Serializable {
    private String name;
    private ArrayList<Level> levels;
/*
 * @Author DengYimo
 * @Date  4:52
 * @Description This is description of method
 * @Param []
 * @Return
 * @Since version-1.0
 */
    public Building() {
        levels = new ArrayList<Level>();
    }
/*
 * @Author DengYimo
 * @Date  4:53
 * @Description This is description of method
 * @Param [name]
 * @Return
 * @Since version-1.0
 */
    public Building(String name) {
        levels = new ArrayList<Level>();
        this.name = name;
    }
/*
 * @Author DengYimo
 * @Date  4:53
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
 * @Date  4:53
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
 * @Date  4:53
 * @Description This is description of method
 * @Param []
 * @Return java.util.ArrayList<com.neusoft.entity.building.Level>
 * @Since version-1.0
 */
    public ArrayList<Level> getLevels() {
        return levels;
    }
/*
 * @Author DengYimo
 * @Date  4:53
 * @Description This is description of method
 * @Param [levels]
 * @Return void
 * @Since version-1.0
 */
    public void setLevels(ArrayList<Level> levels) {
        this.levels = levels;
    }
/*
 * @Author DengYimo
 * @Date  4:53
 * @Description This is description of method
 * @Param []
 * @Return java.lang.String
 * @Since version-1.0
 */
    @Override
    public String toString() {
        return this.name;
    }
}
