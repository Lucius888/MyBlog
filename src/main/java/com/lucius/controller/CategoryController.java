/**
 * Copyright (C), Lucius
 * FileName: CategoryController
 * Author: 分类管理页面
 * Date:     2020/4/21 15:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lucius.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lucius.entity.BlogCategory;
import com.lucius.service.BlogCategoryService;
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
public class CategoryController {
    @Resource
    private BlogCategoryService blogCategoryService;

    @GetMapping("/admin/categories")
    public String categoryPage(HttpServletRequest request) {
        request.setAttribute("path", "categories");
        return "admin/category";
    }

    /**
     * 分类列表
     */
    @GetMapping("/admin/categories/list")
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
        int page= Integer.parseInt(params.get("page").toString());
        int pageSize= Integer.parseInt(params.get("limit").toString());
        PageHelper.startPage(page,pageSize);
        List<BlogCategory> linkList=blogCategoryService.getCategoryList();
        PageInfo<BlogCategory> pageInfo= new PageInfo(linkList);
        //创建一个返回值对象
        PageResult pageResult=new PageResult(linkList, (int) pageInfo.getTotal(),pageInfo.getPageSize(),pageInfo.getPageNum());
        return ResultGenerator.genSuccessResult(pageResult);
    }

    /**
     * 分类添加
     */
    @PostMapping("/admin/categories/save")
    @ResponseBody
    public Result save(@RequestParam("categoryName") String categoryName,
                       @RequestParam("categoryIcon") String categoryIcon) {
        if (StringUtils.isEmpty(categoryName)) {
            return ResultGenerator.genFailResult("请输入分类名称！");
        }
        BlogCategory blogCategory =new BlogCategory();
        blogCategory.setCategoryName(categoryName);
        blogCategory.setCategoryIcon(categoryIcon);
        return ResultGenerator.genSuccessResult(blogCategoryService.insert(blogCategory));

    }


    /**
     * 分类修改
     */
    @PostMapping("/admin/categories/update")
    @ResponseBody
    public Result update(@RequestParam("categoryId") Integer categoryId,
                         @RequestParam("categoryName") String categoryName,
                         @RequestParam("categoryIcon") String categoryIcon) {
        if (StringUtils.isEmpty(categoryName)) {
            return ResultGenerator.genFailResult("请输入分类名称！");
        }
        if (StringUtils.isEmpty(categoryIcon)) {
            return ResultGenerator.genFailResult("请选择分类图标！");
        }

        BlogCategory tempBlogCategory =new BlogCategory();
        tempBlogCategory.setCategoryId(categoryId);
        tempBlogCategory.setCategoryName(categoryName);
        tempBlogCategory.setCategoryIcon(categoryIcon);
        return ResultGenerator.genSuccessResult(blogCategoryService.update(tempBlogCategory));
    }


    /**
     * 分类删除
     */
    @PostMapping("/admin/categories/delete")
    @ResponseBody
    public Result delete(@RequestBody Integer[] ids) {
        if (ids.length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (blogCategoryService.deleteBatch(ids)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("删除失败");
        }
    }

}
