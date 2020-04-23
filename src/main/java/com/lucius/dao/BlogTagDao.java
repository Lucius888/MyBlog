package com.lucius.dao;

import com.lucius.entity.BlogTag;
import com.lucius.entity.BlogTagCount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (BlogTag)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-16 20:12:17
 */
 @Mapper
public interface BlogTagDao {

    /**
     * 通过ID查询单条数据
     *
     * @param tagId 主键
     * @return 实例对象
     */
    BlogTag queryById(Integer tagId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BlogTag> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param blogTag 实例对象
     * @return 对象列表
     */
    List<BlogTag> queryAll(BlogTag blogTag);

    /**
     * 新增数据
     *
     * @param blogTag 实例对象
     * @return 影响行数
     */
    int insert(BlogTag blogTag);

    /**
     * 修改数据
     *
     * @param blogTag 实例对象
     * @return 影响行数
     */
    int update(BlogTag blogTag);

    /**
     * 通过主键删除数据
     *
     * @param tagId 主键
     * @return 影响行数
     */
    int deleteById(Integer tagId);

    /**
     * 查询标签总数
     *
     * @return 影响行数
     */
    int getTotalNum();

    /**
     * 查询所有链接
     *
     */
    List<BlogTag> getTagList();

    /**
     * 通过TagName查询单条数据
     *
     */
    BlogTag selectByTagName(String TagName);

    /**
     * 删除所选的Tag
     *
     */
    int deleteBatch(int[] ids);
    /**
     * 批量插入Tag
     *
     */
    int batchInsertBlogTag(List<BlogTag> tagList);
    /**
     * 为前台需要展示的Tag
     * 其实这些为了前台数据展示的东西可以使用中台 dto 来进行实现
     */
    List<BlogTagCount> getTagCount();
}