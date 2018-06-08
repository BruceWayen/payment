package com.unit.dao;

import com.unit.domain.SysMenu;
import com.unit.domain.SysOperate;
import com.unit.domain.SysRole;
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
        int menuStatus, @Param("menuSuperId") int menuSuperId);

    /**
     * <一句话功能简述> <功能详细描述>
     *
     * @param password 用户修改的密码
     * @param userId   根据用户userId修改密码
     * @see [类、类#方法、类#成员]
     */
    void editPassword(@Param("psw")
        String password, @Param("userId")
        int userId);

    /**
     * 新增管理员 <原来是想新增用户返回用户新增的ID，但是未实现>
     *
     * @param user 传入的参数 对象
     * @return int 返回的int型 大于0表示成功
     * @see [类、类#方法、类#成员]
     */
    int addUser(@Param("user")
        SysUsers user);

    /**
     * 重置管理员密码 <功能详细描述>
     *
     * @param user 传入参数 用户对象
     * @return int 判断操作是否成功
     * @see [类、类#方法、类#成员]
     */
    int resetPassword(@Param("user")
        SysUsers user);

    /**
     * <一句话功能简述> 重置教师用户密码，默认为123456<功能详细描述>
     *
     * @param user
     * @return
     * @see [类、类#方法、类#成员]
     */
    int reset(int id);

    /**
     * <查询管理员ID> <根据账号查询用户ID>
     *
     * @param userName 账号
     * @return id 返回用户id
     * @see [类、类#方法、类#成员]
     */
    int getUserId(@Param("userName")
        String userName);

    /**
     * <添加管理员权限> <添加后台用户角色 权限>
     *
     * @param userRole 后台用户角色类
     * @return int 判断操作是否成功
     * @see [类、类#方法、类#成员]
     */
    int addUserRole(@Param("userRole")
        SysRole userRole);

    /**
     * <查询管理员总数> <功能详细描述>
     *
     * @return long 返回管理员总的数目
     * @see [类、类#方法、类#成员]
     */
    long getUserListSize();

    /**
     * <查询管理员信息> <功能详细描述>
     *
     * @param page 用于分页
     * @return list 返回用户集合
     * @see [类、类#方法、类#成员]
     */
    List<SysUsers> getUserList();

    /**
     * <修改管理员信息> <功能详细描述>
     *
     * @param user 传入用户类对象
     * @return int 判断是否操作成功
     * @see [类、类#方法、类#成员]
     */
    int editUser(@Param("user")
        SysUsers user);

    /**
     * <删除管理员权限> <功能详细描述>
     *
     * @param id 根据id删除管理员权限
     * @return int 标识操作是否成功
     * @see [类、类#方法、类#成员]
     */
    int deleteTeacherRole(@Param("id")
        int id);

    /**
     * 删除管理员 <根据id逻辑删除管理员>
     *
     * @param id 用户id
     * @return int 判断操作是否成功
     * @see [类、类#方法、类#成员]
     */
    int deleteTeacher(@Param("id")
        int id);

    // 添加操作记录

    /**
     * <添加操作记录> <功能详细描述>
     *
     * @param operate 操作记录类对象
     * @return int 判断操作是否成功
     * @see [类、类#方法、类#成员]
     */
    int addOperate(SysOperate operate);

    /**
     * <根据账号检查原密码是否正确 这里只做查询> <功能详细描述>
     *
     * @param userAccount 用户账号
     * @return String 返回加密过后的用户密码
     * @see [类、类#方法、类#成员]
     */
    String findPwdByName(String userAccount);

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
     * 修改密码 根据用户ID修改密码
     *
     * @param user 用户对象
     * @return int 判断操作是否成功
     * @see [类、类#方法、类#成员]
     */
    int changePwd(SysUsers user);

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

}