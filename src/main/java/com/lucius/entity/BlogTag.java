package com.lucius.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (BlogTag)实体类
 *
 * @author makejava
 * @since 2020-04-16 20:12:17
 */
public class BlogTag implements Serializable {
    private static final long serialVersionUID = 360982385523949447L;
    /**
    * 标签表主键id
    */
    private Integer tagId;
    /**
    * 标签名称
    */
    private String tagName;
    /**
    * 是否删除 0=否 1=是
    */
    private Object isDeleted;
    /**
    * 创建时间
    */
    private Date createTime;


    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Object getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Object isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "BlogTag{" +
                "tagId=" + tagId +
                ", tagName='" + tagName + '\'' +
                ", isDeleted=" + isDeleted +
                ", createTime=" + createTime +
                '}';
    }
}