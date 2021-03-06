package com.unit.controller;

import com.unit.domain.SysUsers;
import com.unit.domain.Tree;
import com.unit.service.LoginService;
import com.unit.utils.Const;
import com.unit.utils.UserCookieUtil;
import com.unit.utils.annotation.OperateLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 *@DESCRIPTION 登录及菜单展示 登录后获取菜单进行展示
 *@AUTHOR SongHongWei
 *@TIME 2018/6/6-16:41
 *@CLASS_NAME LoginController
 **/
@Controller
public class LoginController
{
    /**
     * 注入LoginService
     */
    @Autowired
    private LoginService userService;

    /**
     * 登录 登录成功则跳转到index.jsp,反之则停留在login.jsp
     *
     * @param request  获取值
     * @param response 将值传出
     * @return modelAndView
     * @throws Exception 抛出异常
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("/login.do")
    @ResponseBody
    @OperateLog(module = "用户登录")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response, HttpSession session)
        throws Exception
    {
        Integer parentId = 0;
        ModelAndView modelAndView = new ModelAndView();
        SysUsers user = null;
        user = (SysUsers)session.getAttribute("user");
        if (user == null)
            user = userService.checkLogin(request);
        if (user != null)
        {
            request.getSession().setAttribute(Const.SESSION_USER, user);
            userService.updateLoginTime(user);
            //  List<Tree> treeList = userService.getMenu(session, parentId);
            // session.setAttribute("tree", treeList);
            session.setAttribute("user", user);
            modelAndView.setViewName("index");
        }
        else
        {
            modelAndView.addObject("message", "用户名或密码错误");
        }
        return modelAndView;
    }

    /**
     * 注销 注销后返回login.jsp
     *
     * @param response 将值传出
     * @param session  全局变量
     * @return modelAndView
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("/logout.do")
    @ResponseBody
    @OperateLog(module = "退出登陆")
    public ModelAndView logout(HttpSession session, HttpServletResponse response)
    {
        ModelAndView modelAndView = new ModelAndView();
        session.removeAttribute("USER");
        session.removeAttribute("message");
        UserCookieUtil.clearCookie(response);
        modelAndView.setViewName("login");
        return modelAndView;

    }

    /**
     * 获取菜单 根据登录用户的权限获取不同菜单
     *
     * @param session 全局变量
     * @return 获取菜单treeList集合
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("/getMenu.do")
    @ResponseBody
    public List<Tree> getMenu(HttpSession session)
    {
        int parentId = 0;
        List<Tree> treeList = userService.getMenu(session, parentId);

        return treeList;
    }

    /**
     * 根据pid获取二级菜单
     *
     * @param request 获取上一菜单的id
     * @param session 获取登录用户的信息
     * @return {@link ModelAndView}
     */
    @RequestMapping("/children.do")
    @ResponseBody
    public List<Tree> children(HttpServletRequest request, HttpSession session)
        throws Exception
    {
        List<Tree> childrenTreeList = null;
        try
        {
            int parentId = Integer.parseInt(request.getParameter("treeId"));
            childrenTreeList = userService.getMenu(session, parentId);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new Exception("处理失败");
        }
        return childrenTreeList;
    }
}
