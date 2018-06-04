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
 *@DESCRIPTION 账户信息表
 *@AUTHOR SongHongWei
 *@TIME 2018/5/23-16:16
 *@PACKAGE_NAME main.java.com.unit.domain
 **/
public class SyContract
{
    private long idNo;//账户标识

    private String contractDesc;//账户描述

    private int contractStatus;//账户装填，查询配置表，0，正常，1，冻结

    private String contractPassWd;//支付密码

    private long systemFee;//系统充值费用，单位为分，不是元

    private long userFee;//自主充值费用

    private Date payTime;//充值时间

    private int payType;//充值方式，微信在线充值。后台管理员充值，系统自动充值

    private String acceptdealA;//操作流水

}
