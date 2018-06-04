package main.java.com.unit.domain;

import java.util.Date;

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
 *@DESCRIPTION 用户信息类
 *@AUTHOR SongHongWei
 *@TIME 2018/5/23-15:32
 *@PACKAGE_NAME main.java.com.unit.domain
 **/
public class SyUsers
{
    private long idNo;

    private String userName;//用户名

    private int sex;//性别 查询配置表，0男，1女

    private String loginNo;//用户账号

    private String passWord;//用户密码

    private String phoneNo;//用户手机号

    private long contractNo;//用户账号

    private int registerType;//注册类型，查配置表，自主注册，单位注册

    private int userStatus;//用户状态，差配置表，正常，退休，离职，停用，注销

    private Date registerTime;//注册时间

    private Date lastLoginTime;//最后一次登录时间

    private int deptId;//用户归属部门

    private int roleId;//用户角色归属
}
