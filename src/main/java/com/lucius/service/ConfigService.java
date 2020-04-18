package com.lucius.service;

import com.lucius.entity.Config;
import java.util.List;
import java.util.Map;

/**
 * (Config)表服务接口
 *
 * @author makejava
 * @since 2020-04-18 17:03:27
 */
public interface ConfigService {

    /**
     * 通过ID查询单条数据
     *
     * @param configName 主键
     * @return 实例对象
     */
    Config queryById(String configName);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Config> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param config 实例对象
     * @return 实例对象
     */
    Config insert(Config config);

    /**
     * 修改数据
     *
     * @param config 实例对象
     * @return 实例对象
     */
    Config update(Config config);

    /**
     * 通过主键删除数据
     *
     * @param configName 主键
     * @return 是否成功
     */
    boolean deleteById(String configName);

    /**
     * 获取所有的配置项
     *
     * @return
     */
    Map<String,String> getAllConfigs();

}