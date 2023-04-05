package com.neusoft.entity;
/*
 * @Author DengYimo
 * @Date  4:36
 * @Description This is description of class
 * @Since version-1.0
 */
public class Staff extends AbstractUser {
    private String birthday;
    private String specialty;
    private String title;
    private String contact;
    private String id;
/*
 * @Author DengYimo
 * @Date  4:36
 * @Description This is description of method
 * @Param [account, password, name, birthday, specialty, title, contact, id]
 * @Return 
 * @Since version-1.0
 */
    public Staff(String account, String password, String name, String birthday, String specialty, String title, String contact, String id) {
        super(account, password, name);
        this.birthday = birthday;
        this.specialty = specialty;
        this.title = title;
        this.contact = contact;
        this.id = id;
    }
/*
 * @Author DengYimo
 * @Date  4:36
 * @Description This is description of method
 * @Param []
 * @Return java.lang.String
 * @Since version-1.0
 */
    public String getBirthday() {
        return birthday;
    }
/*
 * @Author DengYimo
 * @Date  4:36
 * @Description This is description of method
 * @Param []
 * @Return java.lang.String
 * @Since version-1.0
 */
    public String getSpecialty() {
        return specialty;
    }
/*
 * @Author DengYimo
 * @Date  4:36
 * @Description This is description of method
 * @Param []
 * @Return java.lang.String
 * @Since version-1.0
 */
    public String getTitle() {
        return title;
    }
/*
 * @Author DengYimo
 * @Date  4:36
 * @Description This is description of method
 * @Param []
 * @Return java.lang.String
 * @Since version-1.0
 */
    public String getContact() {
        return contact;
    }
/*
 * @Author DengYimo
 * @Date  4:36
 * @Description This is description of method
 * @Param []
 * @Return java.lang.String
 * @Since version-1.0
 */
    public String getId() {
        return id;
    }
/*
 * @Author DengYimo
 * @Date  4:36
 * @Description This is description of method
 * @Param [birthday]
 * @Return void
 * @Since version-1.0
 */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
/*
 * @Author DengYimo
 * @Date  4:36
 * @Description This is description of method
 * @Param [specialty]
 * @Return void
 * @Since version-1.0
 */
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    /*
     * @Author DengYimo
     * @Date  4:36
     * @Description This is description of method
     * @Param [title]
     * @Return void
     * @Since version-1.0
     */
    public void setTitle(String title) {
        this.title = title;
    }
/*
 * @Author DengYimo
 * @Date  4:37
 * @Description This is description of method
 * @Param [contact]
 * @Return void
 * @Since version-1.0
 */
    public void setContact(String contact) {
        this.contact = contact;
    }
/*
 * @Author DengYimo
 * @Date  4:42
 * @Description This is description of method
 * @Param [id]
 * @Return void
 * @Since version-1.0
 */
    public void setId(String id) {
        this.id = id;
    }
}
