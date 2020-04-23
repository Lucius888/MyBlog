package com.lucius.service.impl;

import com.lucius.entity.Link;
import com.lucius.dao.LinkDao;
import com.lucius.service.LinkService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * (Link)表服务实现类
 *
 * @author makejava
 * @since 2020-04-16 20:12:17
 */
@Service("linkService")
public class LinkServiceImpl implements LinkService {
    @Resource
    private LinkDao linkDao;

    /**
     * 通过ID查询单条数据
     *
     * @param linkId 主键
     * @return 实例对象
     */
    @Override
    public Link queryById(Integer linkId) {
        return this.linkDao.queryById(linkId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Link> queryAllByLimit(int offset, int limit) {
        return this.linkDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param link 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(Link link) {
        return this.linkDao.insert(link)>0;
    }

    /**
     * 修改数据
     *
     * @param link 实例对象
     * @return 实例对象
     */
    @Override
    public Link update(Link link) {
        this.linkDao.update(link);
        return this.queryById(link.getLinkId());
    }

    /**
     * 通过主键删除数据
     *
     * @param linkId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer linkId) {
        return this.linkDao.deleteById(linkId) > 0;
    }
    /**
     * 获取链接总数
     *
     */
    @Override
    public int getTotalNum() {
        return this.linkDao.getTotalNum();
    }
    /**
     * 获取全部连接
     *
     */
    @Override
    public List<Link> getLinkList() {
        return this.linkDao.getLinkList();
    }
    /**
     * 删除选中链接
     *
     */
    @Override
    public boolean deleteBatch(Integer[] ids) {
        return linkDao.deleteBatch(ids) > 0;
    }

    @Override
    public Map<Byte, List<Link>> getLinksForLinkPage() {
        //获取所有链接数据
        List<Link> links = linkDao.findLinkList();
        if (!CollectionUtils.isEmpty(links)) {
            //根据type进行分组
            Map<Byte, List<Link>> linksMap = links.stream().collect(Collectors.groupingBy(Link::getLinkType));
            return linksMap;
        }
        return null;
    }


}