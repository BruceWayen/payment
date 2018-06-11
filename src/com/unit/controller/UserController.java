package com.unit.controller;

import com.unit.domain.SysUsers;
import com.unit.service.UserService;
import com.unit.utils.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController
{
    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     *@DESCRIPTION 查询用户列表
     *@AUTHOR SongHongWei
     *@TIME 2018/6/11-20:32
     *@CLASS_NAME UserController
     **/
    @RequestMapping("/user_list.do")
    public ModelAndView userList(String ids, HttpServletResponse res)
        throws Exception
    {
        ModelAndView mv = new ModelAndView();
        Map<String, Object> appMap = new HashMap<String, Object>();
        List<SysUsers> userList = userService.getUserList();
        appMap.put("list", userList);
        return ResponseUtil.forword("user/user_list", appMap);

    }
}
