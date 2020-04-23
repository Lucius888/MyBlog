package com.lucius.service;

import com.lucius.controller.vo.BlogDetailVO;
import com.lucius.controller.vo.SimpleBlogListVO;
import com.lucius.entity.Blog;
import com.lucius.util.PageResult;

import java.util.List;

/**
 * (Blog)表服务接口
 *
 * @author makejava
 * @since 2020-04-16 20:08:21
 */
public interface BlogService {

    /**
     * 通过ID查询单条数据
     *
     * @param blogId 主键
     * @return 实例对象
     */
    Blog queryById(Long blogId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Blog> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param blog 实例对象
     * @return 实例对象
     */
    Blog insert(Blog blog);

    /**
     * 修改数据
     *
     * @param blog 实例对象
     * @return 实例对象
     */
    Blog update(Blog blog);

    /**
     * 通过主键删除数据
     *
     * @param blogId 主键
     * @return 是否成功
     */
    boolean deleteById(Long blogId);

    /**
     * 查询文章总数
     *
     * @return 影响行数
     */
    int getTotalNum();

    /**
     * 查询链接总数
     *
     * @return 影响行数
     */
    List<Blog> getBlogList();

    /**
     * 删除选中链接
     *
     */
    boolean deleteBatch(Integer[] ids);

    /**
     * 保存博客
     *
     */
    String saveBlog(Blog blog);


    /**
     * 后台修改
     *
     * @param blog
     * @return
     */
    String updateBlog(Blog blog);

    /**
     * 获取首页文章列表
     *
     * @param page
     * @return
     */
    PageResult getBlogsForIndexPage(int page);

    /**
     * 首页侧边栏数据列表
     * 0-点击最多 1-最新发布
     *
     * @param type
     * @return
     */
    List<SimpleBlogListVO> getBlogListForIndexPage(int type);
    /**
     * 文章详情
     *
     * @param blogId
     * @return
     */
    BlogDetailVO getBlogDetail(Long blogId);

    /**
     * 根据标签获取文章列表
     *
     * @param tagName
     * @param page
     * @return
     */
    PageResult getBlogsPageByTag(String tagName, int page);

    /**
     * 根据分类获取文章列表
     *
     * @param categoryId
     * @param page
     * @return
     */
    PageResult getBlogsPageByCategory(String categoryId, int page);

    /**
     * 根据搜索获取文章列表
     *
     * @param keyword
     * @param page
     * @return
     */
    PageResult getBlogsPageBySearch(String keyword, int page);


    BlogDetailVO getBlogDetailBySubUrl(String subUrl);
}