package com.neusoft.dao;

import com.neusoft.entity.Template;

import java.util.List;
/*
 * @Author DengYimo
 * @Date  8:49
 * @Description 抽象模板接口类
 * @Since version-1.0
 */
public interface AbstractTemplate {
    boolean addTemplate(Template template);
    void removeTemplate(Template template);
    List<Template> getTemplates();
}
