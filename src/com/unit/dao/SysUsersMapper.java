package com.unit.dao;

import com.unit.domain.SysMenu;
import com.unit.domain.SysUsers;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUsersMapper
{
    /**
     * 根据账号查询用户 查询单条记录
     *
     * @param user_account 账户 根据账户名查找用户
     * @return 返回用户对象
     * @see [类、类#方法、类#成员]
     */
    SysUsers getUserByName(@Param("userName") String usreName);

    /**
     * 菜单列表 根据用户ID获取菜单
     *
     * @param id     根据用户ID查找
     * @param roleId 角色id
     * @return 返回后台菜单集合
     * @see [类、类#方法、类#成员]
     */
    List<SysMenu> getMenuByUserId(@Param("id")
        long id, @Param("menuStatus")
        int menuStatus);

    /**
     *@DESCRIPTION 查询一级菜单
     *@AUTHOR SongHongWei
     *@TIME 2018/6/8-16:17
     *@CLASS_NAME SysUsersMapper
     **/
    List<SysMenu> getMenuByUserId(@Param("id")
        long id, @Param("menuStatus")
        String menuStatus, @Param("menuSuperId") int menuSuperId);

    /**
     * <查询管理员信息> <功能详细描述>
     *
     * @param page 用于分页
     * @return list 返回用户集合
     * @see [类、类#方法、类#成员]
     */
    List<SysUsers> getUserList();

    /**
     * <获取用户权限ID> <功能详细描述>
     *
     * @param id 用户id
     * @return 用户权限ID
     * @see [类、类#方法、类#成员]
     */
    int getRoleIdByUserId(@Param("userId")
        long id);

    /**
     * <一句话功能简述> <功能详细描述>
     *
     * @param id
     * @param roleId
     * @param pid
     * @return
     * @see [类、类#方法、类#成员]
     */
    List<SysMenu> getChildrenMenu(@Param("userId")
        long id, @Param("roleId")
        int roleId, @Param("pid")
        String pid);

    int insertSelective(SysUsers user);

    int deleteById(@Param("userId") String id);

    List<SysUsers> searchUser(SysUsers user);
}