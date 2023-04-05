package com.neusoft.dao;

import com.neusoft.entity.TemplateShow;

import java.util.List;
/*
 * @Author DengYimo
 * @Date  8:49
 * @Description 抽象用户接口类
 * @Since version-1.0
 */
public interface AbstractUser {
    boolean addUser(TemplateShow template);
    void removeUser(TemplateShow template);
    List<TemplateShow> getUsers();
}
