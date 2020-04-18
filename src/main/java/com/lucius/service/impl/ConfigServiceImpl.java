package com.lucius.service.impl;

import com.lucius.entity.Config;
import com.lucius.dao.ConfigDao;
import com.lucius.service.ConfigService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * (Config)表服务实现类
 *
 * @author makejava
 * @since 2020-04-18 17:03:27
 */
@Service("configService")
public class ConfigServiceImpl implements ConfigService {

    @Resource
    private ConfigDao configDao;

    /**
     * 通过ID查询单条数据
     *
     * @param configName 主键
     * @return 实例对象
     */
    @Override
    public Config queryById(String configName) {
        return this.configDao.queryById(configName);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Config> queryAllByLimit(int offset, int limit) {
        return this.configDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param config 实例对象
     * @return 实例对象
     */
    @Override
    public Config insert(Config config) {
        this.configDao.insert(config);
        return config;
    }

    /**
     * 修改数据
     *
     * @param config 实例对象
     * @return 实例对象
     */
    @Override
    public Config update(Config config) {
        this.configDao.update(config);
        return this.queryById(config.getConfigName());
    }

    /**
     * 通过主键删除数据
     *
     * @param configName 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String configName) {
        return this.configDao.deleteById(configName) > 0;
    }

    @Override
    public Map<String, String> getAllConfigs() {
        //获取所有的map并封装为map
        List<Config> blogConfigs = configDao.queryAll();
        Map<String, String> configMap = blogConfigs.stream().collect(Collectors.toMap(Config::getConfigName, Config::getConfigValue));
        return configMap;
    }

}