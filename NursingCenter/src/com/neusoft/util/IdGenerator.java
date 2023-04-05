package com.neusoft.util;

import java.text.SimpleDateFormat;
import java.util.Date;
/*
 * @Author DengYimo
 * @Date  4:28
 * @Description This is description of class
 * @Since version-1.0
 */
public class IdGenerator {
    /*
     * @Author DengYimo
     * @Date  4:33
     * @Description This is description of method
     * @Param []
     * @Return java.lang.String
     * @Since version-1.0
     */
    public static synchronized String getCode() {
        SimpleDateFormat format = new SimpleDateFormat("YYMMddHHmm"); // 时间字符串产生方式，防止重复
        String uid = format.format(new Date());
        return uid;
    }
}
