package com.lucius.service;

import com.lucius.entity.Link;
import java.util.List;

/**
 * (Link)表服务接口
 *
 * @author makejava
 * @since 2020-04-16 20:12:17
 */
public interface LinkService {

    /**
     * 通过ID查询单条数据
     *
     * @param linkId 主键
     * @return 实例对象
     */
    Link queryById(Integer linkId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Link> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param link 实例对象
     * @return 实例对象
     */
    Link insert(Link link);

    /**
     * 修改数据
     *
     * @param link 实例对象
     * @return 实例对象
     */
    Link update(Link link);

    /**
     * 通过主键删除数据
     *
     * @param linkId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer linkId);

    /**
     * 查询链接总数
     *
     * @return 影响行数
     */
    int getTotalNum();
}