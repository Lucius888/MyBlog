/**
 * Copyright (C), Lucius
 * FileName: LinkController
 * Author:
 * Date:     2020/4/20 14:13
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lucius.controller.admin;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lucius.entity.Link;
import com.lucius.service.LinkService;
import com.lucius.util.PageResult;
import com.lucius.util.Result;
import com.lucius.util.ResultGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class LinkController {


    @Resource
    LinkService linkService;


    @GetMapping("/admin/links")
    public String linkPage(HttpServletRequest request) {
        request.setAttribute("path", "links");
        return "admin/link";
    }


    @GetMapping("/admin/links/list")
    @ResponseBody
    public Result linkList(@RequestParam Map<String, Object> params) {

        int page= Integer.parseInt(params.get("page").toString());
        int pageSize= Integer.parseInt(params.get("limit").toString());
        PageHelper.startPage(page,pageSize);
        List<Link> linkList=linkService.getLinkList();
        PageInfo<Link> pageInfo= new PageInfo(linkList);
        //创建一个返回值对象
        PageResult pageResult=new PageResult(linkList, (int) pageInfo.getTotal(),pageInfo.getPageSize(),pageInfo.getPageNum());
//        System.out.println(ResultGenerator.genSuccessResult(pageResult));
        return ResultGenerator.genSuccessResult(pageResult);
    }

    /**
     * 友链添加
     */
    @PostMapping("/admin/links/save")
    @ResponseBody
    public Result save(@RequestParam("linkType") Integer linkType,
                       @RequestParam("linkName") String linkName,
                       @RequestParam("linkUrl") String linkUrl,
                       @RequestParam("linkRank") Integer linkRank,
                       @RequestParam("linkDescription") String linkDescription) {
        if (linkType == null || linkType < 0 || linkRank == null || linkRank < 0 || StringUtils.isEmpty(linkName) || StringUtils.isEmpty(linkName) || StringUtils.isEmpty(linkUrl) || StringUtils.isEmpty(linkDescription)) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        Link link = new Link();
        link.setLinkType(linkType.byteValue());
        link.setLinkRank(linkRank);
        link.setLinkName(linkName);
        link.setLinkUrl(linkUrl);
        link.setLinkDescription(linkDescription);
        return ResultGenerator.genSuccessResult(linkService.insert(link));
    }

    /**
     * 详情
     */
    @GetMapping("/admin/links/info/{id}")
    @ResponseBody
    public Result info(@PathVariable("id") Integer id) {
        Link link = linkService.queryById(id);
        return ResultGenerator.genSuccessResult(link);
    }

    /**
     * 友链修改
     */
    @RequestMapping(value = "/admin/links/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(@RequestParam("linkId") Integer linkId,
                         @RequestParam("linkType") Integer linkType,
                         @RequestParam("linkName") String linkName,
                         @RequestParam("linkUrl") String linkUrl,
                         @RequestParam("linkRank") Integer linkRank,
                         @RequestParam("linkDescription") String linkDescription) {
        Link tempLink = linkService.queryById(linkId);
        if (tempLink == null) {
            return ResultGenerator.genFailResult("无数据！");
        }
        if (linkType == null || linkType < 0 || linkRank == null || linkRank < 0 || StringUtils.isEmpty(linkName) || StringUtils.isEmpty(linkName) || StringUtils.isEmpty(linkUrl) || StringUtils.isEmpty(linkDescription)) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        tempLink.setLinkType(linkType.byteValue());
        tempLink.setLinkRank(linkRank);
        tempLink.setLinkName(linkName);
        tempLink.setLinkUrl(linkUrl);
        tempLink.setLinkDescription(linkDescription);
        return ResultGenerator.genSuccessResult(linkService.update(tempLink));
    }

    /**
     * 友链删除
     */
    @PostMapping("/admin/links/delete")
    @ResponseBody
    public Result delete(@RequestBody Integer[] ids) {
        if (ids.length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (linkService.deleteBatch(ids)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("删除失败");
        }
    }
}
