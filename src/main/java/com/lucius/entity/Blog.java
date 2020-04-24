package com.lucius.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Blog)实体类
 *
 * @author makejava
 * @since 2020-04-16 20:08:21
 */
public class Blog implements Serializable {
    private static final long serialVersionUID = 818542317655837668L;
    /**
    * 博客表主键id
    */
    private Long blogId;
    /**
    * 博客标题
    */
    private String blogTitle;
    /**
    * 博客自定义路径url
    */
    private String blogSubUrl;
    /**
    * 博客封面图
    */
    private String blogCoverImage;
    /**
    * 博客内容
    */
    private String blogContent;
    /**
    * 博客分类id
    */
    private Integer blogCategoryId;
    /**
    * 博客分类(冗余字段)
    */
    private String blogCategoryName;
    /**
    * 博客标签
    */
    private String blogTags;
    /**
    * 0-草稿 1-发布
    */
    private Object blogStatus;
    /**
    * 阅读量
    */
    private Long blogViews;
    /**
    * 0-允许评论 1-不允许评论
    */
    private Byte enableComment;
    /**
    * 是否删除 0=否 1=是
    */
    private Object isDeleted;
    /**
    * 添加时间
    */
    private Date createTime;
    /**
    * 修改时间
    */
    private Date updateTime;


    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogSubUrl() {
        return blogSubUrl;
    }

    public void setBlogSubUrl(String blogSubUrl) {
        this.blogSubUrl = blogSubUrl;
    }

    public String getBlogCoverImage() {
        return blogCoverImage;
    }

    public void setBlogCoverImage(String blogCoverImage) {
        this.blogCoverImage = blogCoverImage;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public Integer getBlogCategoryId() {
        return blogCategoryId;
    }

    public void setBlogCategoryId(Integer blogCategoryId) {
        this.blogCategoryId = blogCategoryId;
    }

    public String getBlogCategoryName() {
        return blogCategoryName;
    }

    public void setBlogCategoryName(String blogCategoryName) {
        this.blogCategoryName = blogCategoryName;
    }

    public String getBlogTags() {
        return blogTags;
    }

    public void setBlogTags(String blogTags) {
        this.blogTags = blogTags;
    }

    public Object getBlogStatus() {
        return blogStatus;
    }

    public void setBlogStatus(Object blogStatus) {
        this.blogStatus = blogStatus;
    }

    public Long getBlogViews() {
        return blogViews;
    }

    public void setBlogViews(Long blogViews) {
        this.blogViews = blogViews;
    }

    public Byte getEnableComment() {
        return enableComment;
    }

    public void setEnableComment(Byte enableComment) {
        this.enableComment = enableComment;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}