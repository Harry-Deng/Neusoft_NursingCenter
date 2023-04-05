package com.neusoft.entity;
/*
 * @Author DengYimo
 * @Date  4:33
 * @Description This is description of class
 * @Since version-1.0
 */
public class Type {
    String type;
/*
 * @Author DengYimo
 * @Date  4:33
 * @Description This is description of method
 * @Param [type]
 * @Return
 * @Since version-1.0
 */
    public Type(String type) {
        this.type = type;
    }
/*
 * @Author DengYimo
 * @Date  4:34
 * @Description This is description of method
 * @Param []
 * @Return java.lang.String
 * @Since version-1.0
 */
    @Override
    public String toString() {
        return type;
    }
}
