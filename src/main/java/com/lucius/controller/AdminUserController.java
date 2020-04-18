package com.lucius.controller;

import com.lucius.entity.AdminUser;
import com.lucius.service.*;
import com.lucius.util.PasswordUtil;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * (AdminUser)表控制层
 *
 * @author makejava
 * @since 2020-04-16 17:32:29
 */
@Controller
public class AdminUserController {
    /**
     * 服务对象
     */
    @Resource
    private AdminUserService adminUserService;
    @Resource
    private BlogService blogService;
    @Resource
    private BlogCommentService blogCommentService;
    @Resource
    private BlogCategoryService blogCategoryService;
    @Resource
    private BlogTagService blogTagService;
    @Resource
    private LinkService linkService;


    /*
    登录跳转页面
     */
    @GetMapping({"/admin", "/admin/login", "/admin/toLogin"})
    public String login(HttpSession session) {
        session.setAttribute("msg", "Please Login");
        return "admin/login";
    }

    /*
    后台首页
     */
    @GetMapping({"/admin/index", "/admin/toIndex"})
    public String index(Model model) {

        //获取当前用户
        AdminUser currentUser = (AdminUser) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("path", "/admin/index");
        model.addAttribute("nickName", currentUser.getNickName());
        model.addAttribute("blogCount", blogService.getTotalNum());
        model.addAttribute("commentCount", blogCommentService.getTotalNum());
        model.addAttribute("categoryCount", blogCategoryService.getTotalNum());
        model.addAttribute("tagCount", blogTagService.getTotalNum());
        model.addAttribute("linkCount", linkService.getTotalNum());
        return "admin/index";
    }

    /*
    登录验证，shiro验证成功重定向到后台首页，否则返回登录页面
     */
    @RequestMapping({"/admin/login"})
    public String adminIndex(
            HttpSession session,
            @RequestParam("username") String username,
            @RequestParam("password") String password) {
        // 获取Subject对象
        Subject subject = SecurityUtils.getSubject();

        //封装用户
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            subject.login(token);
            return "redirect:/admin/index";
        } catch (UnknownAccountException e) {
            session.setAttribute("msg", "用户名或密码错误");
            return "admin/login";
        } catch (IncorrectCredentialsException e) {//密码错误
            session.setAttribute("msg", "用户名或密码错误");
            return "admin/login";
        }
    }

    /*
    系统管理下的个人资料页面
     */

    @GetMapping("/admin/profile")
    public String profile(Model model) {
        //获取当前登录用户，注意你这不是从数据库中获得的
        AdminUser currentUser = (AdminUser) SecurityUtils.getSubject().getPrincipal();
        System.out.println(currentUser.toString());
        if (currentUser == null) {
            return "admin/login";
        }
        model.addAttribute("path", "profile");
        model.addAttribute("loginUserName", currentUser.getLoginUserName());
        model.addAttribute("nickName", currentUser.getNickName());
        return "admin/profile";
    }

    @PostMapping("/admin/profile/password")
    @ResponseBody
    public String passwordUpdate(
                                 @RequestParam("originalPassword") String originalPassword,
                                 @RequestParam("newPassword") String newPassword) {
        if (StringUtils.isEmpty(originalPassword) || StringUtils.isEmpty(newPassword)) {
            return "参数不能为空";
        }
        //这个操作是在更新当前登录的用户
        Subject subject = SecurityUtils.getSubject();
        PrincipalCollection principalCollection = subject.getPrincipals();
        //获取当前登录用户
        AdminUser currentUser = (AdminUser) subject.getPrincipal();
        String originalPasswordMd5 = PasswordUtil.shiroPasswordEncode(currentUser.getLoginUserName(), originalPassword);
        String newPasswordMd5 = PasswordUtil.shiroPasswordEncode(currentUser.getLoginUserName(), newPassword);
        if (originalPasswordMd5.equals(currentUser.getLoginPassword())) {
            //设置新密码并修改
            currentUser.setLoginPassword(newPasswordMd5);
            if (adminUserService.update(currentUser) != null) {
                String realmName = principalCollection.getRealmNames().iterator().next();
                //传入更新后的对象
                PrincipalCollection newPrincipalCollection = new SimplePrincipalCollection(adminUserService.queryById(currentUser.getAdminUserId()), realmName);
                subject.runAs(newPrincipalCollection);
                return "success";
            }
        }
        return "修改失败";
    }


    /*
    修改名称页面
     */
    @PostMapping("/admin/profile/name")
    @ResponseBody
    public String nameUpdate(
                             @RequestParam("loginUserName") String loginUserName,
                             @RequestParam("nickName") String nickName) {
        if (StringUtils.isEmpty(loginUserName) || StringUtils.isEmpty(nickName)) {
            return "参数不能为空";
        }
        //这个操作是在更新当前登录的用户
        Subject subject = SecurityUtils.getSubject();
        PrincipalCollection principalCollection = subject.getPrincipals();
        //获取当前登录用户
        AdminUser currentUser = (AdminUser) subject.getPrincipal();
        currentUser.setLoginUserName(loginUserName);
        currentUser.setNickName(nickName);
        if (adminUserService.update(currentUser)!=null){
            String realmName = principalCollection.getRealmNames().iterator().next();
            //传入更新后的对象
            PrincipalCollection newPrincipalCollection = new SimplePrincipalCollection(adminUserService.queryById(currentUser.getAdminUserId()), realmName);
            subject.runAs(newPrincipalCollection);
            return "success";
        } else {
            return "修改失败";
        }
    }

    @GetMapping("/admin/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("loginUserId");
        request.getSession().removeAttribute("loginUser");
        request.getSession().removeAttribute("errorMsg");
        return "admin/login";
    }
}