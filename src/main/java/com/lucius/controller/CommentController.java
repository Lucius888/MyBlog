/**
 * Copyright (C), Lucius
 * FileName: CommentController
 * Author: 后台评论管理
 * Date:     2020/4/21 16:15
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lucius.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lucius.entity.BlogComment;
import com.lucius.service.BlogCommentService;
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
public class CommentController {

    @Resource
    private BlogCommentService blogCommentService;

    @GetMapping("/admin/comments")
    public String list(HttpServletRequest request) {
        request.setAttribute("path", "comments");
        return "admin/comment";
    }

    @GetMapping("/admin/comments/list")
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        int page= Integer.parseInt(params.get("page").toString());
        int pageSize= Integer.parseInt(params.get("limit").toString());
        PageHelper.startPage(page,pageSize);
        List<BlogComment> linkList=blogCommentService.getCommentList();
        PageInfo<BlogComment> pageInfo= new PageInfo(linkList);
        //创建一个返回值对象
        PageResult pageResult=new PageResult(linkList, (int) pageInfo.getTotal(),pageInfo.getPageSize(),pageInfo.getPageNum());
        return ResultGenerator.genSuccessResult(pageResult);
    }

    @PostMapping("/admin/comments/checkDone")
    @ResponseBody
    public Result checkDone(@RequestBody Integer[] ids) {
        if (ids.length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (blogCommentService.checkDone(ids)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("审核失败");
        }
    }

    @PostMapping("/admin/comments/reply")
    @ResponseBody
    public Result checkDone(@RequestParam("commentId") Long commentId,
                            @RequestParam("replyBody") String replyBody) {
        if (commentId == null || commentId < 1 || StringUtils.isEmpty(replyBody)) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (blogCommentService.reply(commentId, replyBody)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("回复失败");
        }
    }

    @PostMapping("/admin/comments/delete")
    @ResponseBody
    public Result delete(@RequestBody Integer[] ids) {
        if (ids.length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (blogCommentService.deleteBatch(ids)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("刪除失败");
        }
    }


}
