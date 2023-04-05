package com.neusoft.service;

import com.neusoft.entity.AbstractUser;
import com.neusoft.entity.Admin;
import com.neusoft.entity.Staff;
import com.neusoft.util.FileOperator;

import java.util.List;

public class UserManager {
    private List<Staff> staffs;
    private  List<Admin> admins;
    private AbstractUser currentUser;
    private static UserManager singletonInstance;

    //实现单例模式
    public static UserManager getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new UserManager();
        }
        return singletonInstance;
    }

    private UserManager() {
        staffs =  FileOperator.loadData("Staffs.json", Staff.class);
        admins = FileOperator.loadData("Admins.json", Admin.class);
    }

    /**
     * 用于验证密码输入的重要方法，并将所对应的身份信息写入本地currentUser变量，等待下一个界面读取
     * @param account 输入的账户
     * @param password 输入的密码
     * @param role  角色 1=管理员，2=员工
     * @return  boolean 表示密码验证成功与否
     */
    public boolean CheckLogin(String account, String password, int role){
        if (role == 1) {    // Admin
            for (Admin localAdmin : admins) {
                if(localAdmin.getAccount().equals(account) && localAdmin.getPassword().equals(password)) {
                    currentUser = localAdmin;
                    return true;
                }
            }
        }
        if (role == 2) {    // Staff
            for (Staff localStaff : staffs) {
                if (localStaff.getAccount().equals(account) && localStaff.getPassword().equals(password)) {
                    currentUser = localStaff;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addAdmin(Admin admin) {
        for (Admin localAdmin : admins) {
            if (admin.getAccount().equals(localAdmin.getAccount()))
                return false;
        }
        admins.add(admin);
        FileOperator.writeData(admin, "Admins.json");
        return true;
    }

    public boolean addStaff(Staff staff) {
        for (Staff localStaff : staffs) {
            if (staff.getAccount().equals(localStaff.getAccount()))
                return false;
        }
        staffs.add(staff);
        FileOperator.writeData(staffs, "Staffs.json");
        return true;
    }

    public boolean removeAdmin(AbstractUser user) {
        if (user.getClass() == Admin.class) {
            admins.remove(user);
            FileOperator.writeData(admins, "Admins.json");
            return true;
        } else if (user.getClass() == Staff.class) {
            staffs.remove(user);
            FileOperator.writeData(staffs, "Admins.json");
            return true;
        }
        return false;
    }

    public boolean removeStaff(AbstractUser user) {
        if (user.getClass() == Staff.class) {
            staffs.remove(user);
            FileOperator.writeData(staffs, "Staffs.json");
            return true;
        }
        return false;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public AbstractUser getCurrentUser() {
        return currentUser;
    }

    public List<Admin> getAdmins() {
        return admins;
    }
}
