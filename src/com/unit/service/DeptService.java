package com.unit.service;

import com.unit.dao.SysDeptMapper;
import com.unit.domain.SysDept;
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
 *@TIME 2018/6/24-13:14
 *@PACKAGE_NAME com.unit.service
 **/
@Service
public class DeptService
{
    private Log log = LogFactory.getLog(DeptService.class);

    @Autowired
    private SysDeptMapper sysDeptMapper;

    public List<SysDept> selectAll()
        throws Exception
    {
        List<SysDept> sysDepts = new ArrayList<SysDept>();
        try
        {
            sysDepts = sysDeptMapper.selectAll();
        }
        catch (Exception e)
        {
            log.error("查询部门信息出错.....");
            e.printStackTrace();
            throw new BusiException("查询部门信息出错.....");
        }
        return sysDepts;
    }
}
