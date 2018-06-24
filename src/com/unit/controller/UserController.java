package com.unit.controller;

import com.unit.domain.SysDept;
import com.unit.domain.SysRole;
import com.unit.domain.SysUsers;
import com.unit.domain.easyui.DataGrid;
import com.unit.domain.easyui.Json;
import com.unit.service.DeptService;
import com.unit.service.RoleService;
import com.unit.service.SeqService;
import com.unit.service.UserService;
import com.unit.utils.Const;
import com.unit.utils.RequestUtil;
import com.unit.utils.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
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

    @Autowired
    private DeptService deptService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private SeqService seqService;

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
        return ResponseUtil.forword("user/user_list", appMap);
    }

    @RequestMapping("/user_add.do")
    @ResponseBody
    public Json addUser(HttpServletRequest request)
        throws Exception
    {
        Json json = new Json();
        SysUsers users = new SysUsers();
        users = RequestUtil.request2Bean(request, SysUsers.class);
        try
        {
            String contractNo = seqService.getSysSequence("CONTRACT_NO");
            String loginNo = seqService.getSysSequence("LOGIN_NO");
            users.setLoginNo(loginNo);
            users.setContractNo(Long.parseLong(contractNo));
            userService.insertUser(users);
            json.setSuccess(true);
            json.setMsg("用户新增成功！");
            json.setObj("");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            json.setMsg(e.getMessage());
            throw new Exception("事务回滚!!!");
        }
        return json;
    }

    /**
     *@DESCRIPTION 删除用户/批量删除
     *@AUTHOR SongHongWei
     *@TIME 2018/6/24-19:50
     *@CLASS_NAME UserController
     **/
    @ResponseBody
    @RequestMapping("/user_del.do")
    public Json deleteUser(HttpServletRequest request)
        throws Exception
    {
        String[] ids = request.getParameterValues("ids[]");
        SysUsers activeUser = (SysUsers)request.getSession().getAttribute(Const.SESSION_USER);//当前用户
        Json j = new Json();
        log.info("穿过来的用户ID为：" + ids);
        try
        {
            String msg = userService.deleteUser(ids, activeUser);
            j.setSuccess(true);
            j.setMsg(msg);
        }
        catch (Exception e)
        {
            j.setMsg(e.getMessage());
            throw new Exception("删除用户失败,事务回滚!!!");
        }
        return j;
    }

    /**
     *@DESCRIPTION 用户信息列表
     *@AUTHOR SongHongWei
     *@TIME 2018/6/24-13:29
     *@CLASS_NAME UserController
     **/
    @RequestMapping("/all_user.do")
    @ResponseBody
    public DataGrid allUserList()
    {
        DataGrid dg = new DataGrid();
        List<SysUsers> userList = null;
        try
        {
            userList = userService.getUserList();
        }
        catch (Exception e)
        {
            log.info("查询用户列表失败");
            e.printStackTrace();
        }
        dg.setRows(userList);
        dg.setTotal(userList.size());
        return dg;
    }

    /**
     *@DESCRIPTION 条件查询用户
     *@AUTHOR SongHongWei
     *@TIME 2018/6/24-20:58
     *@CLASS_NAME UserController
     **/
    @RequestMapping("/search_user.do")
    @ResponseBody
    public DataGrid searchUser(HttpServletRequest request)
    {
        DataGrid dg = new DataGrid();
        SysUsers users = new SysUsers();
        List<SysUsers> userList = null;
        try
        {
            users = RequestUtil.request2Bean(request, SysUsers.class);
            userList = userService.searchUser(users);
        }
        catch (Exception e)
        {
            log.info("带条件查询用户列表失败");
            e.printStackTrace();
        }
        dg.setRows(userList);
        dg.setTotal(userList.size());
        return dg;
    }

    /**
     *@DESCRIPTION 获取所有的部门信息
     *@AUTHOR SongHongWei
     *@TIME 2018/6/24-13:29
     *@CLASS_NAME UserController
     **/
    @RequestMapping("/all_dept.do")
    @ResponseBody
    public DataGrid allDept()
    {
        DataGrid dg = new DataGrid();
        List<SysDept> sysDepts = null;
        try
        {
            sysDepts = deptService.selectAll();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        dg.setRows(sysDepts);
        dg.setTotal(sysDepts.size());
        return dg;
    }

    /**
     *@DESCRIPTION 获取所有的角色信息
     *@AUTHOR SongHongWei
     *@TIME 2018/6/24-13:29
     *@CLASS_NAME UserController
     **/
    @RequestMapping("/all_role.do")
    @ResponseBody
    public DataGrid allRole()
    {
        DataGrid dg = new DataGrid();
        List<SysRole> roles = new ArrayList<SysRole>();
        try
        {
            roles = roleService.getAllRole();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        dg.setRows(roles);
        dg.setTotal(roles.size());
        return dg;
    }
}
