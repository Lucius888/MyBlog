package com.lucius.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Config)实体类
 *
 * @author makejava
 * @since 2020-04-18 17:03:27
 */
public class Config implements Serializable {
    private static final long serialVersionUID = -81724155033623797L;
    /**
    * 配置项的名称
    */
    private String configName;
    /**
    * 配置项的值
    */
    private String configValue;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 修改时间
    */
    private Date updateTime;


    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}