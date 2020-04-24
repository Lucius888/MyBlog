package com.lucius.dao;

import com.lucius.entity.BlogComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * (BlogComment)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-16 20:12:17
 */
 @Mapper
public interface BlogCommentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param commentId 主键
     * @return 实例对象
     */
    BlogComment queryById(Long commentId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BlogComment> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param blogComment 实例对象
     * @return 对象列表
     */
    List<BlogComment> queryAll(BlogComment blogComment);

    /**
     * 新增数据
     *
     * @param blogComment 实例对象
     * @return 影响行数
     */
    int insert(BlogComment blogComment);

    /**
     * 修改数据
     *
     * @param blogComment 实例对象
     * @return 影响行数
     */
    int update(BlogComment blogComment);

    /**
     * 通过主键删除数据
     *
     * @param commentId 主键
     * @return 影响行数
     */
    int deleteById(Long commentId);

    /**
     * 查询评论总数
     *
     * @return 影响行数
     */
    int getTotalNum();

    /**
     * 查询所有评论
     *
     */
    List<BlogComment> getCommentList();

    /**
     * 查询当前博客评论
     *
     */
    List<BlogComment> getBlogCommentList(Long blogId);

    /**
     * 删除选中链接
     *
     */
    int deleteBatch(Integer[] ids);

    /**
     * 评论批量审核
     *
     */
    int checkDone(Integer[] ids);

    /**
     * 获取当前博客的全部评论
     *
     */
    int getTotalBlogComments(Map map);
}