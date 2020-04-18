package com.lucius.service;

import com.lucius.entity.AdminUser;
import java.util.List;

/**
 * (AdminUser)表服务接口
 *
 * @author makejava
 * @since 2020-04-16 17:32:29
 */
public interface AdminUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param adminUserId 主键
     * @return 实例对象
     */
    AdminUser queryById(Integer adminUserId);
    /**
     * 通过Name查询单条数据
     *
     * @param loginUserName 主键
     * @return 实例对象
     */
    AdminUser queryByUserName(String loginUserName);
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<AdminUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param adminUser 实例对象
     * @return 实例对象
     */
    AdminUser insert(AdminUser adminUser);

    /**
     * 修改当前登录用户的名称信息
     *
     * @param adminUser
     * @return
     */
    AdminUser update(AdminUser adminUser);



    /**
     * 通过主键删除数据
     *
     * @param adminUserId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer adminUserId);
}