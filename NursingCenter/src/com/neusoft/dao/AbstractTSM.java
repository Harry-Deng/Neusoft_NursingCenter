package com.neusoft.dao;

import com.neusoft.entity.TemplateShow;

import java.util.List;
/*
 * @Author DengYimo
 * @Date  8:49
 * @Description 抽象测试管理接口
 * @Since version-1.0
 */
public interface AbstractTSM {
    boolean addTemplateShow(TemplateShow template);
    void removeTemplateShow(TemplateShow template);
    List<TemplateShow> getTemplateShows();
}
