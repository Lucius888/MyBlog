package com.lucius.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (BlogComment)实体类
 *
 * @author makejava
 * @since 2020-04-16 20:12:17
 */
public class BlogComment implements Serializable {
    private static final long serialVersionUID = -34774901052113863L;
    /**
    * 主键id
    */
    private Long commentId;
    /**
    * 关联的blog主键
    */
    private Long blogId;
    /**
    * 评论者名称
    */
    private String commentator;
    /**
    * 评论人的邮箱
    */
    private String email;
    /**
    * 网址
    */
    private String websiteUrl;
    /**
    * 评论内容
    */
    private String commentBody;
    /**
    * 评论提交时间
    */
    private Date commentCreateTime;
    /**
    * 评论时的ip地址
    */
    private String commentatorIp;
    /**
    * 回复内容
    */
    private String replyBody;
    /**
    * 回复时间
    */
    private Date replyCreateTime;
    /**
    * 是否审核通过 0-未审核 1-审核通过
    */
    private Object commentStatus;
    /**
    * 是否删除 0-未删除 1-已删除
    */
    private Object isDeleted;


    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getCommentator() {
        return commentator;
    }

    public void setCommentator(String commentator) {
        this.commentator = commentator;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    public Date getCommentCreateTime() {
        return commentCreateTime;
    }

    public void setCommentCreateTime(Date commentCreateTime) {
        this.commentCreateTime = commentCreateTime;
    }

    public String getCommentatorIp() {
        return commentatorIp;
    }

    public void setCommentatorIp(String commentatorIp) {
        this.commentatorIp = commentatorIp;
    }

    public String getReplyBody() {
        return replyBody;
    }

    public void setReplyBody(String replyBody) {
        this.replyBody = replyBody;
    }

    public Date getReplyCreateTime() {
        return replyCreateTime;
    }

    public void setReplyCreateTime(Date replyCreateTime) {
        this.replyCreateTime = replyCreateTime;
    }

    public Object getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Object commentStatus) {
        this.commentStatus = commentStatus;
    }

    public Object getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Object isDeleted) {
        this.isDeleted = isDeleted;
    }

}