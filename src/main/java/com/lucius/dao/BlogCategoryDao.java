package com.lucius.dao;

import com.lucius.entity.BlogCategory;
import com.lucius.entity.BlogTagCount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (BlogCategory)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-16 20:12:17
 */
 @Mapper
public interface BlogCategoryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param categoryId 主键
     * @return 实例对象
     */
    BlogCategory queryById(Integer categoryId);

    /**
     * 通过ID查询单条数据
     *
     * @param categoryName 主键
     * @return 实例对象
     */
    BlogCategory queryByCategoryName(String categoryName);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BlogCategory> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param blogCategory 实例对象
     * @return 对象列表
     */
    List<BlogCategory> queryAll(BlogCategory blogCategory);

    /**
     * 新增数据
     *
     * @param blogCategory 实例对象
     * @return 影响行数
     */
    int insert(BlogCategory blogCategory);

    /**
     * 修改数据
     *
     * @param blogCategory 实例对象
     * @return 影响行数
     */
    int update(BlogCategory blogCategory);

    /**
     * 通过主键删除数据
     *
     * @param categoryId 主键
     * @return 影响行数
     */
    int deleteById(Integer categoryId);

    /**
     * 查询文章分类总数
     *
     * @return 影响行数
     */
    int getTotalNum();

    /**
     * 查询所有分类
     *
     */
    List<BlogCategory> getCategoryList();

    /**
     * 删除选中分类
     *
     */
    int deleteBatch(Integer[] ids);

    /**
     * 根据多id查询分类
     *
     */
    List<BlogCategory> selectByCategoryIds(@Param("categoryIds") List<Integer> categoryIds);

    /**
     * 为前台需要展示的Tag
     * 其实这些为了前台数据展示的东西可以使用中台 dto 来进行实现
     */
    List<BlogCategory> getCategoryCount();
}