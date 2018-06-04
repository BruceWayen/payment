package com.unit.controller;

import main.java.com.unit.service.IUserService;
import main.java.com.unit.utils.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController
{
    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @Resource
    private IUserService userService;

    @RequestMapping("/menu.do")
    public String menu(@RequestParam(value = "ids") String ids, HttpServletResponse res)
        throws Exception
    {
       String jsonObject="[{\"id\":1,\"parentId\":0,\"url\":\"javascript:void(0)\",\"text\":\"系统设置\",\"checked\":false,\"state\":\"open\",\"children\":[{\"id\":2,\"parentId\":1,\"url\":\"sys/menu/index\",\"text\":\"菜单管理\",\"checked\":false,\"state\":null,\"children\":[]},{\"id\":3,\"parentId\":1,\"url\":\"sys/role/index\",\"text\":\"角色管理\",\"checked\":false,\"state\":null,\"children\":[]},{\"id\":4,\"parentId\":1,\"url\":\"sys/user/index\",\"text\":\"用户管理\",\"checked\":false,\"state\":null,\"children\":[]}]},{\"id\":8,\"parentId\":0,\"url\":\"javascript:void(0)\",\"text\":\"基础设置\",\"checked\":false,\"state\":\"open\",\"children\":[]}]";
        ResponseUtil.write(res, jsonObject);
        return null;
    }
}
