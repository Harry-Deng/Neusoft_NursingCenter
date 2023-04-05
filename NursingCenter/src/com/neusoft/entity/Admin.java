package com.neusoft.entity;
/*
 * @Author DengYimo
 * @Date  4:49
 * @Description This is description of class
 * @Since version-1.0
 */
public class Admin extends AbstractUser {
    /*
     * @Author DengYimo
     * @Date  4:54
     * @Description This is description of method
     * @Param [account, password, name]
     * @Return 
     * @Since version-1.0
     */
    public Admin(String account, String password, String name) {
        super(account, password, name);
    }
}