package com.unit.controller;

import com.alibaba.fastjson.JSON;
import com.unit.domain.SysUsers;
import com.unit.service.UserService;
import com.unit.utils.DataGrid;
import com.unit.utils.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    @ResponseBody
    public ModelAndView userList(String ids, HttpServletResponse res)
        throws Exception
    {
        ModelAndView mv = new ModelAndView();
        Map<String, Object> appMap = new HashMap<String, Object>();
        List<SysUsers> userList = userService.getUserList();
        appMap.put("list", userList.get(0));
        log.info("用户信息====={}",userList.size());
        return ResponseUtil.forword("user/user_list", appMap);

    }
    @RequestMapping("/user_list2.do")
    @ResponseBody
    public String userList2(String ids, HttpServletResponse res)
        throws Exception
    {
        ModelAndView mv = new ModelAndView();
        Map<String, Object> appMap = new HashMap<String, Object>();
        List<SysUsers> userList = userService.getUserList();
        String str = null;
        try
        {
            str = JSON.toJSON(userList).toString();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        log.info("======{}",str);
        return str;

    }
    @RequestMapping("/user_list3.do")
    @ResponseBody
    public DataGrid desiredatagrid() {
        DataGrid dg = new DataGrid();
        List<SysUsers> userList = null;
        try
        {
            userList = userService.getUserList();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        dg.setRows(userList);
        dg.setTotal(userList.size());
        return dg;
    }

}
