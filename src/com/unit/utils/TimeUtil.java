package com.unit.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
 *@DESCRIPTION ${END}
 *@AUTHOR SongHongWei
 *@TIME 2018/6/25-15:07
 *@PACKAGE_NAME com.unit.utils
 **/
public class TimeUtil
{

    public static String getNowTime()
    {
        String dateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        Date date = new Date();
        // 获取前月的第一天
        Calendar cal_1 = Calendar.getInstance();// 获取当前日期
        int dayNow = cal_1.get(Calendar.DAY_OF_MONTH);
        cal_1.setTime(date);
        int day = cal_1.get(Calendar.DAY_OF_MONTH);
        cal_1 = Calendar.getInstance();
        if (day > dayNow)
        {
            cal_1.add(Calendar.MONTH, 0);
        }
        else
        {
            cal_1.add(Calendar.MONTH, 1);
        }
        cal_1.set(Calendar.DAY_OF_MONTH, day - 1);// 设置为当前日期,当前日期既为本月指定日期
        return format.format(cal_1.getTime());
    }

    public static void main(String[] args){
        System.out.println(getNowTime());
    }
}
