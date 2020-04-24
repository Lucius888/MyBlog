package com.lucius.service;

import com.lucius.entity.BlogComment;
import com.lucius.util.PageResult;

import java.util.List;

/**
 * (BlogComment)表服务接口
 *
 * @author makejava
 * @since 2020-04-16 20:12:17
 */
public interface BlogCommentService {

    /**
     * 通过ID查询单条数据
     *
     * @param commentId 主键
     * @return 实例对象
     */
    BlogComment queryById(Long commentId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BlogComment> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param blogComment 实例对象
     * @return 实例对象
     */
    BlogComment insert(BlogComment blogComment);

    /**
     * 修改数据
     *
     * @param blogComment 实例对象
     * @return 实例对象
     */
    BlogComment update(BlogComment blogComment);

    /**
     * 通过主键删除数据
     *
     * @param commentId 主键
     * @return 是否成功
     */
    boolean deleteById(Long commentId);
    /**
     * 查询评论总数
     *
     * @return 影响行数
     */
    int getTotalNum();

    /**
     * 查询全部评论
     *
     * @return 影响行数
     */
    List<BlogComment> getCommentList();

    /**
     * 删除选中评论
     *
     */
    boolean deleteBatch(Integer[] ids);

    /**
     * 批量审核
     *
     * @param ids
     * @return
     */
    Boolean checkDone(Integer[] ids);

    /**
     * 添加回复
     *
     * @param commentId
     * @param replyBody
     * @return
     */
    Boolean reply(Long commentId, String replyBody);

    /**
     * 根据文章id和分页参数获取文章的评论列表
     *
     * @param blogId
     * @param page
     * @return
     */
    PageResult getCommentPageByBlogIdAndPageNum(Long blogId, int page);

    /**
     * 添加评论
     *
     * @param blogComment
     * @return
     */
    Boolean addComment(BlogComment blogComment);
}