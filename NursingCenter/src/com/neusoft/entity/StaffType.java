package com.neusoft.entity;

import com.neusoft.util.FileOperator;

import java.util.List;
/*
 * @Author DengYimo
 * @Date  4:35
 * @Description This is description of class
 * @Since version-1.0
 */
public class StaffType {
    private final List<Type> types;
    private static StaffType singletonInstance;

    // 实现单例模式：只有一个DeviceType被创建
    /*
     * @Author DengYimo
     * @Date  4:35
     * @Description This is description of method
     * @Param []
     * @Return com.neusoft.entity.StaffType
     * @Since version-1.0
     */
    public static StaffType getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new StaffType();
        }
        return singletonInstance;
    }
/*
 * @Author DengYimo
 * @Date  4:35
 * @Description This is description of method
 * @Param []
 * @Return
 * @Since version-1.0
 */
    private StaffType() {
        types = FileOperator.loadData("Types.json", Type.class);
    }
/*
 * @Author DengYimo
 * @Date  4:35
 * @Description This is description of method
 * @Param []
 * @Return java.util.List<com.neusoft.entity.Type>
 * @Since version-1.0
 */
    public List<Type> getTypes() {
        return types;
    }
}
