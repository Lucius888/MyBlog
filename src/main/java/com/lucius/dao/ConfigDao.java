package com.lucius.dao;

import com.lucius.entity.Config;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Config)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-18 17:03:27
 */
 @Mapper
public interface ConfigDao {

    /**
     * 通过ID查询单条数据
     *
     * @param configName 主键
     * @return 实例对象
     */
    Config queryById(String configName);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Config> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */
    List<Config> queryAll();

    /**
     * 新增数据
     *
     * @param config 实例对象s
     * @return 影响行数
     */
    int insert(Config config);

    /**
     * 修改数据
     *
     * @param config 实例对象
     * @return 影响行数
     */
    int update(Config config);

    /**
     * 通过主键删除数据
     *
     * @param configName 主键
     * @return 影响行数
     */
    int deleteById(String configName);

}