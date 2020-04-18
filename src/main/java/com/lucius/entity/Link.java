package com.lucius.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Link)实体类
 *
 * @author makejava
 * @since 2020-04-16 20:12:17
 */
public class Link implements Serializable {
    private static final long serialVersionUID = 182685966611036375L;
    /**
    * 友链表主键id
    */
    private Integer linkId;
    /**
    * 友链类别 0-友链 1-推荐 2-个人网站
    */
    private Object linkType;
    /**
    * 网站名称
    */
    private String linkName;
    /**
    * 网站链接
    */
    private String linkUrl;
    /**
    * 网站描述
    */
    private String linkDescription;
    /**
    * 用于列表排序
    */
    private Integer linkRank;
    /**
    * 是否删除 0-未删除 1-已删除
    */
    private Object isDeleted;
    /**
    * 添加时间
    */
    private Date createTime;


    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public Object getLinkType() {
        return linkType;
    }

    public void setLinkType(Object linkType) {
        this.linkType = linkType;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getLinkDescription() {
        return linkDescription;
    }

    public void setLinkDescription(String linkDescription) {
        this.linkDescription = linkDescription;
    }

    public Integer getLinkRank() {
        return linkRank;
    }

    public void setLinkRank(Integer linkRank) {
        this.linkRank = linkRank;
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

}