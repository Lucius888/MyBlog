package com.lucius.entity;

import java.io.Serializable;

/**
 * (AdminUser)实体类
 *
 * @author makejava
 * @since 2020-04-16 17:32:27
 */
public class AdminUser implements Serializable {
    private static final long serialVersionUID = -26701647962033500L;
    /**
    * 管理员id
    */
    private Integer adminUserId;
    /**
    * 管理员登陆名称
    */
    private String loginUserName;
    /**
    * 管理员登陆密码
    */
    private String loginPassword;
    /**
    * 管理员显示昵称
    */
    private String nickName;
    /**
    * 是否锁定 0未锁定 1已锁定无法登陆
    */
    private Object locked;


    public Integer getAdminUserId() {
        return adminUserId;
    }

    public void setAdminUserId(Integer adminUserId) {
        this.adminUserId = adminUserId;
    }

    public String getLoginUserName() {
        return loginUserName;
    }

    public void setLoginUserName(String loginUserName) {
        this.loginUserName = loginUserName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Object getLocked() {
        return locked;
    }

    public void setLocked(Object locked) {
        this.locked = locked;
    }

    @Override
    public String toString() {
        return "AdminUser{" +
                "adminUserId=" + adminUserId +
                ", loginUserName='" + loginUserName + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                ", nickName='" + nickName + '\'' +
                ", locked=" + locked +
                '}';
    }
}