package com.lucius.dao;

import com.lucius.entity.BlogTagRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (BlogTagRelation)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-20 21:39:26
 */
 @Mapper
public interface BlogTagRelationDao {

    /**
     * 通过ID查询单条数据
     *
     * @param relationId 主键
     * @return 实例对象
     */
    BlogTagRelation queryById(Long relationId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BlogTagRelation> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param blogTagRelation 实例对象
     * @return 对象列表
     */
    List<BlogTagRelation> queryAll(BlogTagRelation blogTagRelation);

    /**
     * 新增数据
     *
     * @param blogTagRelation 实例对象
     * @return 影响行数
     */
    int insert(BlogTagRelation blogTagRelation);

    /**
     * 修改数据
     *
     * @param blogTagRelation 实例对象
     * @return 影响行数
     */
    int update(BlogTagRelation blogTagRelation);

    /**
     * 通过主键删除数据
     *
     * @param relationId 主键
     * @return 影响行数
     */
    int deleteById(Long relationId);

    List<Long> selectDistinctTagIds(int[] tagIds);

    /**
     * 批量插入
     */
    int batchInsert(@Param("relationList") List<BlogTagRelation> blogTagRelationList);

}