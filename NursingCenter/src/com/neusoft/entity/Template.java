package com.neusoft.entity;

import com.neusoft.service.TemplateManager;

import java.io.Serializable;
import java.util.ArrayList;
/*
 * @Author DengYimo
 * @Date  4:34
 * @Description This is description of class
 * @Since version-1.0
 */
public class Template implements Serializable {
    public final static String[] TYPES = {"A", "B"};
    private ArrayList<Problem> problems = new ArrayList<Problem>();
    private String name = "";
    private String type = "A";
    private long id = 0;
/*
 * @Author DengYimo
 * @Date  4:34
 * @Description This is description of method
 * @Param []
 * @Return java.util.ArrayList<com.neusoft.entity.Problem>
 * @Since version-1.0
 */
    public ArrayList<Problem> getProblems() {
        return problems;
    }
/*
 * @Author DengYimo
 * @Date  4:34
 * @Description This is description of method
 * @Param [problems]
 * @Return void
 * @Since version-1.0
 */
    public void setProblems(ArrayList<Problem> problems) {
        this.problems = problems;
    }
/*
 * @Author DengYimo
 * @Date  4:35
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
 * @Date  4:35
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
 * @Date  4:35
 * @Description This is description of method
 * @Param []
 * @Return java.lang.String
 * @Since version-1.0
 */
    public String getType() {
        return type;
    }
/*
 * @Author DengYimo
 * @Date  4:35
 * @Description This is description of method
 * @Param [type]
 * @Return void
 * @Since version-1.0
 */
    public void setType(String type) {
        this.type = type;
    }
/*
 * @Author DengYimo
 * @Date  4:35
 * @Description This is description of method
 * @Param []
 * @Return long
 * @Since version-1.0
 */
    public long getId() {
        return id;
    }
/*
 * @Author DengYimo
 * @Date  4:35
 * @Description This is description of method
 * @Param [id]
 * @Return void
 * @Since version-1.0
 */
    public void setId(long id) {
        this.id = id;
    }
/*
 * @Author DengYimo
 * @Date  4:35
 * @Description This is description of method
 * @Param []
 * @Return com.neusoft.entity.Template
 * @Since version-1.0
 */
    public static Template newTemplate() {
        Template template = new Template();
        template.id = TemplateManager.getInstance().getTemplateId();
        TemplateManager.getInstance().setTemplateId(template.id + 1);
        return template;
    }
/*
 * @Author DengYimo
 * @Date  4:35
 * @Description This is description of method
 * @Param []
 * @Return
 * @Since version-1.0
 */
    public Template() {
    }
/*
 * @Author DengYimo
 * @Date  4:35
 * @Description This is description of method
 * @Param [name]
 * @Return
 * @Since version-1.0
 */
    public Template(String name) {
        this.id = TemplateManager.getInstance().getTemplateId();
        this.name = name;
        TemplateManager.getInstance().setTemplateId(this.id + 1);
    }
}