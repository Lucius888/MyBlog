package com.lucius.dao;

import com.lucius.entity.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Blog)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-16 20:08:21
 */
 @Mapper
public interface BlogDao {

    /**
     * 通过ID查询单条数据
     *
     * @param blogId 主键
     * @return 实例对象
     */
    Blog queryById(Long blogId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Blog> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param blog 实例对象
     * @return 对象列表
     */
    List<Blog> queryAll(Blog blog);

    /**
     * 新增数据
     *
     * @param blog 实例对象
     * @return 影响行数
     */
    int insert(Blog blog);

    /**
     * 修改数据
     *
     * @param blog 实例对象
     * @return 影响行数
     */
    int update(Blog blog);

    /**
     * 通过主键删除数据
     *
     * @param blogId 主键
     * @return 影响行数
     */
    int deleteById(Long blogId);

    /**
     * 查询文章总数
     *
     * @return 影响行数
     */
    int getTotalNum();

    /**
     * 查询所有博客
     *
     */
    List<Blog> getBlogList();

    /**
     * 根据Tag获得博客
     *
     */
    List<Blog> getBlogListByTagId(Integer tagId);

    /**
     * 删除选中博客
     *
     */
    int deleteBatch(Integer[] ids);

    /**
     * 保存发布的文章
     */
    int insertSelective(Blog record);
    /**
     * 通过类型查找文章
     */
    List<Blog> findBlogListByType(@Param("type") int type, @Param("limit") int limit);
}