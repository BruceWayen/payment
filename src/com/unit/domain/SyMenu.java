package main.java.com.unit.domain;

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
 *@DESCRIPTION 菜单类
 *@AUTHOR SongHongWei
 *@TIME 2018/5/23-16:10
 *@PACKAGE_NAME main.java.com.unit.domain
 **/
public class SyMenu
{
    private int idNo;//才旦表示

    private int menuSuperId;//父及菜单标识

    private int menuStatus;//菜单状态，查询配置表，0可用，1不可用

    private int menuSort;//菜单排序

    private String menuName;//菜单名称

    private String menuIconUrl;//菜单显示的图片路径

    private String menuUrl;//菜单链接URL


}
