package com.unit.service;

import com.unit.dao.SysUsersMapper;
import com.unit.domain.SysUsers;
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
    @Autowired
    private SysUsersMapper sysUsersMapper;

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
          throw  new Exception("查询出错");
        }
        return userList;
    }
}
