package com.neusoft.util;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.*;

/*
 * @Author DengYimo
 * @Date  4:31
 * @Description This is description of class
 * @Since version-1.0
 */
public class GsonUtil {
    /*
     * @Author DengYimo
     * @Date  4:31
     * @Description This is description of method
     * @Param [object]
     * @Return java.lang.String
     * @Since version-1.0
     */
    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
    /*
     * @Author DengYimo
     * @Date  4:31
     * @Description This is description of method
     * @Param [json, c]
     * @Return java.lang.Object
     * @Since version-1.0
     */
    public static Object toObj(String json, Class<?> c) {
        JsonParser jsonParser = new JsonParser();
        JsonArray jsonArray = jsonParser.parse(json).getAsJsonArray();
        Gson gson = new Gson();
        Object obj = null;
        for (JsonElement item : jsonArray) {
            obj = gson.fromJson(item, c);
        }
        return obj;
    }
    /*
     * @Author DengYimo
     * @Date  4:32
     * @Description This is description of method
     * @Param [js, c]
     * @Return java.util.List<java.lang.Object>
     * @Since version-1.0
     */
    public static List<Object> toObjList(String js, Class<?> c) {
        JsonParser parser = new JsonParser();
        JsonArray jsonArray = parser.parse(js).getAsJsonArray();
        Gson gson = new Gson();
        ArrayList<Object> objList = new ArrayList<Object>();
        for (JsonElement item : jsonArray) {
            Object obj = gson.fromJson(item, c);
            objList.add(obj);
        }

        return objList;
    }

}