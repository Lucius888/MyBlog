package com.lucius.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (BlogCategory)实体类
 *
 * @author makejava
 * @since 2020-04-16 20:12:17
 */
public class BlogCategory implements Serializable {
    private static final long serialVersionUID = 877078433090703060L;
    /**
    * 分类表主键
    */
    private Integer categoryId;
    /**
    * 分类的名称
    */
    private String categoryName;
    /**
    * 分类的图标
    */
    private String categoryIcon;
    /**
    * 分类的排序值 被使用的越多数值越大
    */
    private Integer categoryRank;
    /**
    * 是否删除 0=否 1=是
    */
    private Object isDeleted;
    /**
    * 创建时间
    */
    private Date createTime;


    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryIcon() {
        return categoryIcon;
    }

    public void setCategoryIcon(String categoryIcon) {
        this.categoryIcon = categoryIcon;
    }

    public Integer getCategoryRank() {
        return categoryRank;
    }

    public void setCategoryRank(Integer categoryRank) {
        this.categoryRank = categoryRank;
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