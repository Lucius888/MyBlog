/**
 * Copyright (C), Lucius
 * FileName: TagController
 * Author:
 * Date:     2020/4/20 20:24
 * Description: 后台标签管理页
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lucius.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lucius.entity.BlogTag;
import com.lucius.entity.Link;
import com.lucius.service.BlogTagService;
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
public class TagController {

    @Resource
    private BlogTagService blogTagService;

    @GetMapping("/admin/tags")
    public String tagPage(HttpServletRequest request) {
        request.setAttribute("path", "tags");
        return "admin/tag";
    }

    @GetMapping("/admin/tags/list")
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
        int page= Integer.parseInt(params.get("page").toString());
        int pageSize= Integer.parseInt(params.get("limit").toString());
        PageHelper.startPage(page,pageSize);
        List<BlogTag> linkList=blogTagService.getTagList();
        PageInfo<Link> pageInfo= new PageInfo(linkList);
        //创建一个返回值对象
        PageResult pageResult=new PageResult(linkList, (int) pageInfo.getTotal(),pageInfo.getPageSize(),pageInfo.getPageNum());
//        System.out.println(ResultGenerator.genSuccessResult(pageResult));
        return ResultGenerator.genSuccessResult(pageResult);
    }


    @PostMapping("/admin/tags/save")
    @ResponseBody
    public Result save(@RequestParam("tagName") String tagName) {
        if (StringUtils.isEmpty(tagName)) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (blogTagService.saveTag(tagName)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("标签名称重复");
        }
    }

    @PostMapping("/admin/tags/delete")
    @ResponseBody
    public Result delete(@RequestBody int[] ids) {
        if (ids.length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (blogTagService.deleteBatch(ids)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("有关联数据请勿强行删除");
        }
    }
}
