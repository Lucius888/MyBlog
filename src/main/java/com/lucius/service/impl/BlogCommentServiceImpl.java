package com.lucius.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lucius.entity.Blog;
import com.lucius.entity.BlogComment;
import com.lucius.dao.BlogCommentDao;
import com.lucius.service.BlogCommentService;
import com.lucius.util.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (BlogComment)表服务实现类
 *
 * @author makejava
 * @since 2020-04-16 20:12:17
 */
@Service("blogCommentService")
public class BlogCommentServiceImpl implements BlogCommentService {
    @Resource
    private BlogCommentDao blogCommentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param commentId 主键
     * @return 实例对象
     */
    @Override
    public BlogComment queryById(Long commentId) {
        return this.blogCommentDao.queryById(commentId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BlogComment> queryAllByLimit(int offset, int limit) {
        return this.blogCommentDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param blogComment 实例对象
     * @return 实例对象
     */
    @Override
    public BlogComment insert(BlogComment blogComment) {
        this.blogCommentDao.insert(blogComment);
        return blogComment;
    }

    /**
     * 修改数据
     *
     * @param blogComment 实例对象
     * @return 实例对象
     */
    @Override
    public BlogComment update(BlogComment blogComment) {
        this.blogCommentDao.update(blogComment);
        return this.queryById(blogComment.getCommentId());
    }

    /**
     * 通过主键删除数据
     *
     * @param commentId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long commentId) {
        return this.blogCommentDao.deleteById(commentId) > 0;
    }

    @Override
    public int getTotalNum() {
        return this.blogCommentDao.getTotalNum();
    }

    @Override
    public List<BlogComment> getCommentList() {
        return this.blogCommentDao.getCommentList();
    }

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return this.blogCommentDao.deleteBatch(ids)>0;
    }

    @Override
    public Boolean checkDone(Integer[] ids) {
        return blogCommentDao.checkDone(ids) > 0;
    }

    @Override
    public Boolean reply(Long commentId, String replyBody) {
        BlogComment blogComment = blogCommentDao.queryById(commentId);
        //blogComment不为空且状态为已审核，则继续后续操作
        if (blogComment != null && Integer.parseInt(String.valueOf(blogComment.getCommentStatus()))==1) {
            blogComment.setReplyBody(replyBody);
            blogComment.setReplyCreateTime(new Date());
            return blogCommentDao.update(blogComment) > 0;
        }
        return false;
    }

    @Override
    public PageResult getCommentPageByBlogIdAndPageNum(Long blogId, int page) {
        if (page < 1) {
            return null;
        }
        PageHelper.startPage(page, 8);
        List<BlogComment> commentList = blogCommentDao.getBlogCommentList(blogId);
        PageInfo<Blog> pageInfo = new PageInfo(commentList);
        //创建一个返回值对象
        if (!CollectionUtils.isEmpty(commentList)) {
            //创建一个返回值对象
            PageResult pageResult = new PageResult(commentList, (int) pageInfo.getTotal(), pageInfo.getPageSize(), pageInfo.getPageNum());
            return pageResult;
        }
        return null;
    }

    @Override
    public Boolean addComment(BlogComment blogComment) {
        return blogCommentDao.insert(blogComment)>0;
    }
}