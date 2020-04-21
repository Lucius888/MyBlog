package com.lucius.service.impl;

import com.lucius.dao.BlogTagRelationDao;
import com.lucius.entity.BlogTag;
import com.lucius.dao.BlogTagDao;
import com.lucius.service.BlogTagService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * (BlogTag)表服务实现类
 *
 * @author makejava
 * @since 2020-04-16 20:12:17
 */
@Service("blogTagService")
public class BlogTagServiceImpl implements BlogTagService {
    @Resource
    private BlogTagDao blogTagDao;

    @Resource
    private BlogTagRelationDao blogTagRelationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param tagId 主键
     * @return 实例对象
     */
    @Override
    public BlogTag queryById(Integer tagId) {
        return this.blogTagDao.queryById(tagId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BlogTag> queryAllByLimit(int offset, int limit) {
        return this.blogTagDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param blogTag 实例对象
     * @return 实例对象
     */
    @Override
    public BlogTag insert(BlogTag blogTag) {
        this.blogTagDao.insert(blogTag);
        return blogTag;
    }

    /**
     * 修改数据
     *
     * @param blogTag 实例对象
     * @return 实例对象
     */
    @Override
    public BlogTag update(BlogTag blogTag) {
        this.blogTagDao.update(blogTag);
        return this.queryById(blogTag.getTagId());
    }

    /**
     * 通过主键删除数据
     *
     * @param tagId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer tagId) {
        return this.blogTagDao.deleteById(tagId) > 0;
    }

    @Override
    public int getTotalNum() {
        return this.blogTagDao.getTotalNum();
    }

    @Override
    public List<BlogTag> getTagList() {
        return this.blogTagDao.getTagList();
    }

    @Override
    public boolean saveTag(String tagName) {
        BlogTag temp = blogTagDao.selectByTagName(tagName);
        if (temp == null) {
            BlogTag blogTag = new BlogTag();
            blogTag.setTagName(tagName);
            return blogTagDao.insert(blogTag) > 0;
        }
        return false;
    }

    @Override
    public boolean deleteBatch(int[] ids) {
        //已存在关联关系不删除
        List<Long> relations = blogTagRelationDao.selectDistinctTagIds(ids);
        if (!CollectionUtils.isEmpty(relations)) {
            return false;
        }
        //删除tag
        return blogTagDao.deleteBatch(ids) > 0;
    }
}