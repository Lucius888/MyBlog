package com.lucius.service.impl;

import com.lucius.entity.AdminUser;
import com.lucius.dao.AdminUserDao;
import com.lucius.service.AdminUserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AdminUser)表服务实现类
 *
 * @author makejava
 * @since 2020-04-16 17:32:29
 */
@Service("adminUserService")
public class AdminUserServiceImpl implements AdminUserService {
    @Resource
    private AdminUserDao adminUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param adminUserId 主键
     * @return 实例对象
     */
    @Override
    public AdminUser queryById(Integer adminUserId) {
        return this.adminUserDao.queryById(adminUserId);
    }

    @Override
    public AdminUser queryByUserName(String loginUserName) {
        return this.adminUserDao.queryByUserName(loginUserName);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<AdminUser> queryAllByLimit(int offset, int limit) {
        return this.adminUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param adminUser 实例对象
     * @return 实例对象
     */
    @Override
    public AdminUser insert(AdminUser adminUser) {
        this.adminUserDao.insert(adminUser);
        return adminUser;
    }

    /**
     * 修改数据
     *
     * @param adminUser 实例对象
     * @return 实例对象
     */
    @Override
    public AdminUser update(AdminUser adminUser) {
        this.adminUserDao.update(adminUser);
        return this.queryById(adminUser.getAdminUserId());
    }



    /**
     * 通过主键删除数据
     *
     * @param adminUserId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer adminUserId) {
        return this.adminUserDao.deleteById(adminUserId) > 0;
    }

}