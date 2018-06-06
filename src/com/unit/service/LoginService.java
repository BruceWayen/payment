/*
 * 文 件 名:  UserService.java
 * 版    权:  Anhui Shixu Intelligent Technology CO.,LTD. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  shandong
 * 修改时间:  2016年6月23日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.unit.service;

import com.unit.dao.SysUsersMapper;
import com.unit.domain.SysMenu;
import com.unit.domain.SysUsers;
import com.unit.domain.Tree;
import com.unit.utils.Const;
import com.unit.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * <一句话功能简述> 用户登录 <功能详细描述>
 *
 * @author 李欢
 * @version [版本号, 2016年6月23日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Service
public class LoginService
{
    /**
     * 注入UserMapper
     */
    @Autowired
    private SysUsersMapper sysUsersMapper;

    /**
     * 登录匹配 根据账号查询相关信息并返回结果
     *
     * @param request 获取传入的参数
     * @return user
     * @see [类、类#方法、类#成员]
     */
    public SysUsers checkLogin(HttpServletRequest request)
    {
        String userAccount = request.getParameter("username");
        String password = request.getParameter("password");
        if (userAccount != null && password != null)
        {
            password = MD5Util.md5(password);
            SysUsers user = sysUsersMapper.getUserByName(userAccount);
            if (user != null && password.equals(user.getPassWord()))
            {
                return user;
            }
            else
            {

                return null;
            }
        }
        else
        {
            return null;
        }
    }

    /**
     * <一句话功能简述> 获取菜单<功能详细描述>
     *
     * @param session  全局变量
     * @param parentId
     * @return list集合
     * @see [类、类#方法、类#成员]
     */
    public List<Tree> getMenu(HttpSession session, int parentId)
    {
        List<SysMenu> menuList = new ArrayList<SysMenu>();
        SysUsers user = (SysUsers)session.getAttribute(Const.SESSION_USER);
        int roleId = sysUsersMapper.getRoleIdByUserId(user.getId());
        session.setAttribute("roleId", roleId);
        if (parentId == 0)
        {
            menuList = sysUsersMapper.getMenuByUserId(user.getId(), roleId);
        }
        else if (parentId > 0)
        {
            String pid = null;
            if (parentId < 10)
            {
                pid = "0" + Integer.toString(parentId);
            }
            else
            {
                pid = Integer.toString(parentId);
            }
            menuList = sysUsersMapper.getChildrenMenu(user.getId(), roleId, pid);
        }
        List<Tree> treeList = new ArrayList<Tree>();

        for (int i = 0; i < menuList.size(); i++)
        {
            SysMenu menu = menuList.get(i);
            Tree node = new Tree();
            node.setId(menu.getId());
            node.setPid(menu.getMenuSuperId());
            node.setText(menu.getMenuName());
            node.setIconCls(menu.getMenuIconUrl());
            node.setUrl(menu.getMenuUrl());
            if (!"00".equals(menu.getMenuSuperId()))
            { // 有父节点
                node.setPid(menu.getMenuSuperId());
            }
            if (menu.getCountChildrens() > 0)
            { // 有子节点
                node.setState("closed");
            }

            treeList.add(node);
        }
        return treeList;
    }
}
