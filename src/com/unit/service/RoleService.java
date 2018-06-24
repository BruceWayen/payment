package com.unit.service;

import com.unit.dao.SysRoleMapper;
import com.unit.domain.SysRole;
import com.unit.utils.BusiException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
 *@TIME 2018/6/24-14:36
 *@PACKAGE_NAME com.unit.service
 **/
@Service
public class RoleService
{
    private Log log = LogFactory.getLog(RoleService.class);

    @Autowired
    private SysRoleMapper sysRoleMapper;

    public List<SysRole> getAllRole()
        throws Exception
    {
        List<SysRole> roles = new ArrayList<SysRole>();
        try
        {
            roles = sysRoleMapper.selectAll();
        }
        catch (Exception e)
        {
            log.error("查询角色信息出错.....");
            e.printStackTrace();
            throw new BusiException("查询角色信息出错.....");
        }
        return roles;
    }

}
