package com.neusoft.service;

import com.neusoft.dao.AbstractTemplate;
import com.neusoft.entity.Patient;
import com.neusoft.entity.Template;
import com.neusoft.util.FileOperator;
import java.util.List;

public class TemplateManager implements AbstractTemplate {
    private List<Template> templates;
    private long templateId = 1;
    private static TemplateManager singletonInstance;

    public long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(long templateId) {
        this.templateId = templateId;
    }


    private TemplateManager() {
        templates = FileOperator.loadData("Templates.json", Patient.class);
    }

    //单例模式
    public static TemplateManager getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new TemplateManager();
        }
        return singletonInstance;
    }
    //增
    public boolean addTemplate(Template template) {
        templates.add(template);
        FileOperator.writeData(template, "Templates.json");
        return true;
    }
    //删
    public void removeTemplate(Template template) {
        templates.remove(template);
        FileOperator.writeData(templates, "Templates.json");
    }

    public List<Template> getTemplates() {
        return templates;
    }
}
