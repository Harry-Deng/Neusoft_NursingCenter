package com.neusoft.service;

import com.neusoft.dao.AbstractTSM;
import com.neusoft.entity.TemplateShow;
import com.neusoft.util.FileOperator;

import java.util.List;

public class TemplateShowManager implements AbstractTSM {
        private List<TemplateShow> templates;
        private static TemplateShowManager singletonInstance;

        private TemplateShowManager() {
            templates = FileOperator.loadData("TemplateShows.json", TemplateShow.class);
        }

        //单例模式
        public static TemplateShowManager getInstance() {
            if (singletonInstance == null) {
                singletonInstance = new TemplateShowManager();
            }
            return singletonInstance;
        }
        //增
        public boolean addTemplateShow(TemplateShow template) {
            templates.add(template);
            FileOperator.writeData(template, "TemplateShows.json");
            return true;
        }
        //删
        public void removeTemplateShow(TemplateShow template) {
            templates.remove(template);
            FileOperator.writeData(templates, "TemplateShows.json");
        }

        public List<TemplateShow> getTemplateShows() {
            return templates;
        }
}


