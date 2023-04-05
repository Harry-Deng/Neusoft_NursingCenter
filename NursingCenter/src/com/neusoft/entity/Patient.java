package com.neusoft.entity;
/*
 * @Author DengYimo
 * @Date  4:44
 * @Description This is description of class
 * @Since version-1.0
 */
public class Patient {
    private String name;
    private String birthday;
    private String gender;
    private String id;
    private String contact;
    private String ECP;
    private String ECN;
/*
 * @Author DengYimo
 * @Date  4:45
 * @Description This is description of method
 * @Param [name, birthday, gender, id, contact, ECP, ECN]
 * @Return
 * @Since version-1.0
 */
    public Patient(String name, String birthday, String gender, String id, String contact, String ECP, String ECN) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.contact = contact;
        this.id = id;
        this.ECP = ECP;
        this.ECN = ECN;
    }
/*
 * @Author DengYimo
 * @Date  4:45
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
 * @Date  4:45
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
 * @Date  4:45
 * @Description This is description of method
 * @Param []
 * @Return java.lang.String
 * @Since version-1.0
 */
    public String getGender() {
        return gender;
    }
/*
 * @Author DengYimo
 * @Date  4:45
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
 * @Date  4:45
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
 * @Date  4:45
 * @Description This is description of method
 * @Param []
 * @Return java.lang.String
 * @Since version-1.0
 */
    public String getECP() {
        return ECP;
    }
/*
 * @Author DengYimo
 * @Date  4:45
 * @Description This is description of method
 * @Param []
 * @Return java.lang.String
 * @Since version-1.0
 */
    public String getECN() {
        return ECN;
    }
/*
 * @Author DengYimo
 * @Date  4:45
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
 * @Date  4:45
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
 * @Date  4:45
 * @Description This is description of method
 * @Param [gender]
 * @Return void
 * @Since version-1.0
 */
    public void setGender(String gender) {
        this.gender = gender;
    }
/*
 * @Author DengYimo
 * @Date  4:45
 * @Description This is description of method
 * @Param [id]
 * @Return void
 * @Since version-1.0
 */
    public void setId(String id) {
        this.id = id;
    }
/*
 * @Author DengYimo
 * @Date  4:45
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
 * @Date  4:45
 * @Description This is description of method
 * @Param [ECP]
 * @Return void
 * @Since version-1.0
 */
    public void setECP(String ECP) {
        this.ECP = ECP;
    }
/*
 * @Author DengYimo
 * @Date  4:45
 * @Description This is description of method
 * @Param [ECN]
 * @Return void
 * @Since version-1.0
 */
    public void setECN(String ECN) {
        this.ECN = ECN;
    }
}
