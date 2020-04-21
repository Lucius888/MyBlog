package com.lucius.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (BlogTagRelation)实体类
 *
 * @author makejava
 * @since 2020-04-20 21:39:26
 */
public class BlogTagRelation implements Serializable {
    private static final long serialVersionUID = -62133752071928519L;
    /**
    * 关系表id
    */
    private Long relationId;
    /**
    * 博客id
    */
    private Long blogId;
    /**
    * 标签id
    */
    private Integer tagId;
    /**
    * 添加时间
    */
    private Date createTime;


    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}