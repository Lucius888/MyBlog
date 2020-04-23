package com.lucius.controller.admin;


import com.lucius.entity.Config;
import com.lucius.service.ConfigService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 系统配置Controller
 */
@Controller
public class ConfigurationController {

    @Resource
    private ConfigService configService;

    @GetMapping("/admin/configurations")
    public String list(HttpServletRequest request) {
        request.setAttribute("path", "configurations");
        request.setAttribute("configurations", configService.getAllConfigs());
        return "admin/configuration";
    }

    @PostMapping("/admin/configurations/website")
    @ResponseBody
    public String website(@RequestParam(value = "websiteName", required = false) String websiteName,
                          @RequestParam(value = "websiteDescription", required = false) String websiteDescription,
                          @RequestParam(value = "websiteLogo", required = false) String websiteLogo,
                          @RequestParam(value = "websiteIcon", required = false) String websiteIcon) {

        Config websiteNameConfig =configService.queryById("websiteName");
        websiteNameConfig.setConfigValue(websiteName);
        configService.update(websiteNameConfig);
        Config websiteDescriptionConfig =configService.queryById("websiteDescription");
        websiteDescriptionConfig.setConfigValue(websiteDescription);
        configService.update(websiteDescriptionConfig);
        Config websiteLogoConfig =configService.queryById("websiteLogo");
        websiteLogoConfig.setConfigValue(websiteLogo);
        configService.update(websiteLogoConfig);
        Config websiteIconConfig =configService.queryById("websiteIcon");
        websiteIconConfig.setConfigValue(websiteIcon);
        configService.update(websiteIconConfig);
        return "success";
    }

    @PostMapping("/admin/configurations/userInfo")
    @ResponseBody
    public String userInfo(@RequestParam(value = "yourAvatar", required = false) String yourAvatar,
                           @RequestParam(value = "yourName", required = false) String yourName,
                           @RequestParam(value = "yourEmail", required = false) String yourEmail) {
        Config yourAvatarConfig =configService.queryById("yourAvatar");
        yourAvatarConfig.setConfigValue(yourAvatar);
        configService.update(yourAvatarConfig);
        Config yourNameConfig =configService.queryById("yourName");
        yourNameConfig.setConfigValue(yourName);
        configService.update(yourNameConfig);
        Config yourEmailConfig =configService.queryById("yourEmail");
        yourEmailConfig.setConfigValue(yourEmail);
        configService.update(yourEmailConfig);
        return "success";
    }

    @PostMapping("/admin/configurations/footer")
    @ResponseBody
    public String footer(@RequestParam(value = "footerAbout", required = false) String footerAbout,
                         @RequestParam(value = "footerICP", required = false) String footerICP,
                         @RequestParam(value = "footerCopyRight", required = false) String footerCopyRight,
                         @RequestParam(value = "footerPoweredBy", required = false) String footerPoweredBy,
                         @RequestParam(value = "footerPoweredByURL", required = false) String footerPoweredByURL) {
        Config footerAboutConfig =configService.queryById("footerAbout");
        footerAboutConfig.setConfigValue(footerAbout);
        configService.update(footerAboutConfig);
        Config footerICPConfig =configService.queryById("footerICP");
        footerICPConfig.setConfigValue(footerICP);
        configService.update(footerICPConfig);
        Config footerCopyRightConfig =configService.queryById("footerCopyRight");
        footerCopyRightConfig.setConfigValue(footerCopyRight);
        configService.update(footerCopyRightConfig);
        Config footerPoweredByConfig =configService.queryById("footerPoweredBy");
        footerPoweredByConfig.setConfigValue(footerPoweredBy);
        configService.update(footerPoweredByConfig);
        Config footerPoweredByURLConfig =configService.queryById("footerPoweredByURL");
        footerPoweredByURLConfig.setConfigValue(footerPoweredByURL);
        configService.update(footerPoweredByURLConfig);
        return "success";
    }


}
