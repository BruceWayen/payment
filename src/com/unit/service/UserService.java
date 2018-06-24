package com.unit.service;

import com.unit.dao.SysContractInfoMapper;
import com.unit.dao.SysUserRoleMapper;
import com.unit.dao.SysUsersMapper;
import com.unit.domain.SysContractInfo;
import com.unit.domain.SysUserRole;
import com.unit.domain.SysUsers;
import com.unit.utils.BusiException;
import com.unit.utils.MD5Util;
import com.unit.utils.StringUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @                           _ooOoo_
 *                            o8888888o
 *                            88" . "88
 *                            (| -_- |)
 *                            O\  =  /O
 *                         ____/`---'\____
 *                       .'  \\|     |//  `.
 *                      /  \\|||  :  |||//  \
 *                     /  _||||| -:- |||||-  \
 *                     |   | \\\  -  /// |   |
 *                     | \_|  ''\---/''  |   |
 *                     \  .-\__  `-`  ___/-. /
 *                   ___`. .'  /--.--\  `. . __
 *                ."" '<  `.___\_<|>_/___.'  >'"".
 *               | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 *               \  \ `-.   \_ __\ /__ _/   .-` /  /
 *          ======`-.____`-.___\_____/___.-`____.-'======
 *                             `=---='
 *          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 *                     佛祖保佑        永无BUG
 *@DESCRIPTION ${END}
 *@AUTHOR SongHongWei
 *@TIME 2018/6/11-21:10
 *@PACKAGE_NAME com.unit.service
 **/
@Service
public class UserService
{
    private Log log = LogFactory.getLog(UserService.class);

    @Autowired
    private SysUsersMapper sysUsersMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Autowired
    private SysContractInfoMapper sysContractInfoMapper;

    /**
     *@DESCRIPTION 获取所有用户列表
     *@AUTHOR SongHongWei
     *@TIME 2018/6/11-21:11
     *@CLASS_NAME UserService
     **/
    public List<SysUsers> getUserList()
        throws Exception
    {
        List<SysUsers> userList = null;
        try
        {
            userList = sysUsersMapper.getUserList();
        }
        catch (Exception e)
        {
            throw new Exception("查询出错");
        }
        return userList;
    }

    /**
     *@DESCRIPTION 条件查询用户
     *@AUTHOR SongHongWei
     *@TIME 2018/6/24-20:56
     *@CLASS_NAME UserService
     **/
    public List<SysUsers> searchUser(SysUsers users)
        throws Exception
    {
        List<SysUsers> userList = null;
        try
        {
            userList = sysUsersMapper.searchUser(users);
        }
        catch (Exception e)
        {
            throw new Exception("查询出错");
        }
        return userList;
    }

    /**
     *@DESCRIPTION 插入一条用户信息
     *@AUTHOR SongHongWei
     *@TIME 2018/6/24-15:48
     *@CLASS_NAME UserService
     **/
    public void insertUser(SysUsers users)
        throws Exception
    {
        SysUserRole sysUserRole = new SysUserRole();
        SysContractInfo contractInfo = new SysContractInfo();
        if (users.getRegisterType().equals("1"))
        {
            //系统注册
            users.setLoginNo("A" + users.getLoginNo());
        }
        else
        {
            //自助注册
            users.setLoginNo("B" + users.getLoginNo());
        }
        try
        {
            String idIccid = users.getIdIccid();
            if (idIccid.length() != 18)
            {
                //费二代身份证报错
                throw new BusiException("身份证不合法....");
            }
            String passWd = MD5Util.defaultPassWd(idIccid.substring(idIccid.length() - 6));
            users.setPassWord(passWd);//密码为身份证后六位
            sysUsersMapper.insertSelective(users);//入用户信息表
            sysUserRole.setRoleId(users.getRoleId());
            sysUserRole.setUserId(StringUtil.castToString(users.getId()));
            sysUserRoleMapper.insertSelective(sysUserRole);//入用户角色信息表
            //入账务信息表
            contractInfo.setUserId(StringUtil.castToString(users.getId()));
            contractInfo.setId(users.getContractNo());
            contractInfo.setContractName(users.getUserName());
            contractInfo.setContractPasswd(users.getPassWord());//默认为登录密码
            contractInfo.setContractStatus(users.getUserSatus());
            contractInfo.setSystemFee("0.00");
            contractInfo.setUserFee("0.00");
            sysContractInfoMapper.insertSelective(contractInfo);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new BusiException("新增用户错误....");
        }
    }

    public String deleteUser(String[] ids, SysUsers users)
        throws Exception
    {
        Long usersId = users.getId();
        String msg = "";
        int rows = 0;
        if (ids != null && ids.length > 0)
        {
            try
            {
                for (String id : ids)
                {   //循环删除
                    if (id.equals(usersId.toString()))
                    {
                        //当前登录用户不可删除
                        msg = "当前用户不可删除,";
                        continue;
                    }
                    else
                    {
                        sysUsersMapper.deleteById(id);
                        rows++;
                    }
                }
                msg += "已删除" + rows + "条记录";
            }
            catch (Exception e)
            {
                log.error("删除用户出错.....");
                e.printStackTrace();
                throw new BusiException("删除用户出错.....");
            }
        }
        return msg;
    }
}
