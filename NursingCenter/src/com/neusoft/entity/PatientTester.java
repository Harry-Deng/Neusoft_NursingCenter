package com.neusoft.entity;
/*
 * @Author DengYimo
 * @Date  4:43
 * @Description This is description of class
 * @Since version-1.0
 */
public class PatientTester {
    private String evaluater;
    private String time;
    private String gender;
    private String templateName;
    private String templateMode;
    private String name;
    private String advice;
/*
 * @Author DengYimo
 * @Date  4:44
 * @Description This is description of method
 * @Param []
 * @Return java.lang.String
 * @Since version-1.0
 */
    public String getTemplateMode() {
        return templateMode;
    }
/*
 * @Author DengYimo
 * @Date  4:44
 * @Description This is description of method
 * @Param [templateMode]
 * @Return void
 * @Since version-1.0
 */
    public void setTemplateMode(String templateMode) {
        this.templateMode = templateMode;
    }
/*
 * @Author DengYimo
 * @Date  4:44
 * @Description This is description of method
 * @Param []
 * @Return java.lang.String
 * @Since version-1.0
 */
    public String getAdvice() {
        return advice;
    }
/*
 * @Author DengYimo
 * @Date  4:44
 * @Description This is description of method
 * @Param [advice]
 * @Return void
 * @Since version-1.0
 */
    public void setAdvice(String advice) {
        this.advice = advice;
    }
/*
 * @Author DengYimo
 * @Date  4:44
 * @Description This is description of method
 * @Param [name, templateName, templateMode, gender, time, evaluater, advice]
 * @Return 
 * @Since version-1.0
 */
    public PatientTester(String name, String templateName, String templateMode, String gender, String time, String evaluater, String advice) {
        this.name = name;
        this.templateName = templateName;
        this.gender = gender;
        this.time = time;
        this.evaluater = evaluater;
        this.templateMode = templateMode;
        this.advice = advice;
    }
/*
 * @Author DengYimo
 * @Date  4:44
 * @Description This is description of method
 * @Param []
 * @Return java.lang.String
 * @Since version-1.0
 */
    public String getTime() {
        return time;
    }
/*
 * @Author DengYimo
 * @Date  4:44
 * @Description This is description of method
 * @Param [time]
 * @Return void
 * @Since version-1.0
 */
    public void setTime(String time) {
        this.time = time;
    }
/*
 * @Author DengYimo
 * @Date  4:44
 * @Description This is description of method
 * @Param []
 * @Return java.lang.String
 * @Since version-1.0
 */
    public String getTemplateName() {
        return templateName;
    }
/*
 * @Author DengYimo
 * @Date  4:44
 * @Description This is description of method
 * @Param [templateName]
 * @Return void
 * @Since version-1.0
 */
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }
/*
 * @Author DengYimo
 * @Date  4:44
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
 * @Date  4:44
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
 * @Date  4:44
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
 * @Date  4:44
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
 * @Date  4:44
 * @Description This is description of method
 * @Param []
 * @Return java.lang.String
 * @Since version-1.0
 */
    public String getEvaluater() {
        return evaluater;
    }
/*
 * @Author DengYimo
 * @Date  4:46
 * @Description This is description of method
 * @Param [evaluater]
 * @Return void
 * @Since version-1.0
 */
    public void setEvaluater(String evaluater) {
        this.evaluater = evaluater;
    }
}
