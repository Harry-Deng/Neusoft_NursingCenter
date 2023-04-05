package com.neusoft.entity;
/*
 * @Author DengYimo
 * @Date  4:49
 * @Description This is description of class
 * @Since version-1.0
 */
public abstract class AbstractUser {
    private String account;
    private String password;
    private String name;
/*
 * @Author DengYimo
 * @Date  4:49
 * @Description This is description of method
 * @Param [account, password, name]
 * @Return 
 * @Since version-1.0
 */
    public AbstractUser(String account, String password, String name) {
        this.account = account;
        this.password = password;
        this.name = name;
    }
/*
 * @Author DengYimo
 * @Date  4:49
 * @Description This is description of method
 * @Param []
 * @Return java.lang.String
 * @Since version-1.0
 */
    public String getAccount() {
        return account;
    }
/*
 * @Author DengYimo
 * @Date  4:49
 * @Description This is description of method
 * @Param []
 * @Return java.lang.String
 * @Since version-1.0
 */
    public String getPassword() {
        return password;
    }
/*
 * @Author DengYimo
 * @Date  4:49
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
 * @Date  4:49
 * @Description This is description of method
 * @Param [account]
 * @Return void
 * @Since version-1.0
 */
    public void setAccount(String account) {
        this.account = account;
    }
/*
 * @Author DengYimo
 * @Date  4:49
 * @Description This is description of method
 * @Param [password]
 * @Return void
 * @Since version-1.0
 */
    public void setPassword(String password) {
        this.password = password;
    }
/*
 * @Author DengYimo
 * @Date  4:54
 * @Description This is description of method
 * @Param [name]
 * @Return void
 * @Since version-1.0
 */
    public void setName(String name) {
        this.name = name;
    }

}
