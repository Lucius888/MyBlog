package com.lucius.service.impl;

import com.lucius.entity.BlogCategory;
import com.lucius.dao.BlogCategoryDao;
import com.lucius.service.BlogCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BlogCategory)表服务实现类
 *
 * @author makejava
 * @since 2020-04-16 20:12:17
 */
@Service("blogCategoryService")
public class BlogCategoryServiceImpl implements BlogCategoryService {
    @Resource
    private BlogCategoryDao blogCategoryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param categoryId 主键
     * @return 实例对象
     */
    @Override
    public BlogCategory queryById(Integer categoryId) {
        return this.blogCategoryDao.queryById(categoryId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BlogCategory> queryAllByLimit(int offset, int limit) {
        return this.blogCategoryDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param blogCategory 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(BlogCategory blogCategory) {

        return this.blogCategoryDao.insert(blogCategory)>0;
    }

    /**
     * 修改数据
     *
     * @param blogCategory 实例对象
     * @return 实例对象
     */
    @Override
    public BlogCategory update(BlogCategory blogCategory) {
        this.blogCategoryDao.update(blogCategory);
        return this.queryById(blogCategory.getCategoryId());
    }

    /**
     * 通过主键删除数据
     *
     * @param categoryId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer categoryId) {
        return this.blogCategoryDao.deleteById(categoryId) > 0;
    }

    @Override
    public int getTotalNum() {
        return this.blogCategoryDao.getTotalNum();
    }

    @Override
    public List<BlogCategory> getCategoryList() {
        return this.blogCategoryDao.getCategoryList();
    }

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return this.blogCategoryDao.deleteBatch(ids)>0;
    }
}