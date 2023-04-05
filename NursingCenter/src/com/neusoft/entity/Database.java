package com.neusoft.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.neusoft.entity.building.Building;

import java.io.*;
import java.util.ArrayList;
/*
 * @Author DengYimo
 * @Date  4:47
 * @Description This is description of class
 * @Since version-1.0
 */
public class Database implements Serializable {

    private ArrayList<Building> buildings = new ArrayList<Building>();
    private ArrayList<CheckInInfo> checkInInfos = new ArrayList<CheckInInfo>();
    private static Database singleton;
/*
 * @Author DengYimo
 * @Date  4:47
 * @Description This is description of method
 * @Param []
 * @Return
 * @Since version-1.0
 */
    private Database() {
    }
/*
 * @Author DengYimo
 * @Date  4:47
 * @Description This is description of method
 * @Param []
 * @Return java.util.ArrayList<com.neusoft.entity.building.Building>
 * @Since version-1.0
 */
    public ArrayList<Building> getBuildings() {
        return buildings;
    }
/*
 * @Author DengYimo
 * @Date  4:47
 * @Description This is description of method
 * @Param [buildings]
 * @Return void
 * @Since version-1.0
 */
    public void setBuildings(ArrayList<Building> buildings) {
        this.buildings = buildings;
    }
/*
 * @Author DengYimo
 * @Date  4:47
 * @Description This is description of method
 * @Param []
 * @Return com.neusoft.entity.Database
 * @Since version-1.0
 */
    public static Database getInstance() {
        if (singleton == null) {
            singleton = new Database();
            readFromFile();
        }
        return singleton;
    }
/*
 * @Author DengYimo
 * @Date  4:47
 * @Description This is description of method
 * @Param []
 * @Return void
 * @Since version-1.0
 */
    public static void saveToFile() {
        String path = ".\\data\\";
        File file = new File(path);

        if (!file.exists()) {
            file.mkdir();
        }

        String jsonString = JSON.toJSONString(Database.getInstance().getBuildings());
        StringtoFile(jsonString, path + "buildings.json");
        jsonString = JSON.toJSONString(Database.getInstance().getCheckInInfos());
        StringtoFile(jsonString, path + "checkInInfos.json");
    }
/*
 * @Author DengYimo
 * @Date  4:47
 * @Description This is description of method
 * @Param []
 * @Return java.util.ArrayList<com.neusoft.entity.CheckInInfo>
 * @Since version-1.0
 */
    public ArrayList<CheckInInfo> getCheckInInfos() {
        return checkInInfos;
    }
/*
 * @Author DengYimo
 * @Date  4:47
 * @Description This is description of method
 * @Param [checkInInfos]
 * @Return void
 * @Since version-1.0
 */
    public void setCheckInInfos(ArrayList<CheckInInfo> checkInInfos) {
        this.checkInInfos = checkInInfos;
    }
/*
 * @Author DengYimo
 * @Date  4:48
 * @Description This is description of method
 * @Param []
 * @Return void
 * @Since version-1.0
 */
    public static void readFromFile() {
        String path = ".\\data\\";
        File file = new File(path + "users.json");
        String jsonString = "";

        file = new File(path + "buildings.json");
        if (file.exists()) {
            jsonString = readJson(file);
            singleton.setBuildings(new ArrayList<Building>(JSONArray.parseArray(jsonString, Building.class)));
        }
        file = new File(path + "checkInInfos.json");
        if (file.exists()) {
            jsonString = readJson(file);
            singleton.setCheckInInfos(new ArrayList<CheckInInfo>(JSONArray.parseArray(jsonString, CheckInInfo.class)));
        }

    }
/*
 * @Author DengYimo
 * @Date  4:48
 * @Description This is description of method
 * @Param [file]
 * @Return java.lang.String
 * @Since version-1.0
 */
    public static String readJson(File file) {
        if (!file.exists()) {
            return "";
        }
        BufferedReader bufr = null;
        String line = null;
        String tmp = null;
        try {
            bufr = new BufferedReader(new FileReader(file));
            while ((tmp = bufr.readLine()) != null) {
                if (line == null) line = tmp;
                else line += tmp;
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            try {
                if (bufr != null)
                    bufr.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        return line;
    }
/*
 * @Author DengYimo
 * @Date  4:48
 * @Description This is description of method
 * @Param [s, path]
 * @Return void
 * @Since version-1.0
 */
    public static void StringtoFile(String s, String path) {
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        OutputStream outPutStream = null;
        try {
            outPutStream = new FileOutputStream(file);
            byte[] bytes = s.getBytes("UTF-8");
            outPutStream.write(bytes);
            outPutStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (outPutStream != null)
                    outPutStream.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
