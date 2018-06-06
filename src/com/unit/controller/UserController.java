package com.unit.controller;

import com.unit.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String menu(String ids, HttpServletResponse res)
        throws Exception
    {

        return "";
    }
}
