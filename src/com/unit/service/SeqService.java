package com.unit.service;

import com.unit.dao.SysSequenceMapper;
import com.unit.domain.SysSequence;
import com.unit.utils.BusiException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
 *@TIME 2018/6/24-15:36
 *@PACKAGE_NAME com.unit.service
 **/
@Service
public class SeqService
{
    private Log log = LogFactory.getLog(SeqService.class);

    @Autowired
    private SysSequenceMapper sysSequenceMapper;

    public String getSysSequence(String seqName)
    {
        String currentVal = "";
        try
        {
            SysSequence sysSequence = sysSequenceMapper.selectBySeqName(seqName);
            currentVal = sysSequence.getCurrentVal();
            Integer incrementVal = sysSequence.getIncrementVal();
            long currentValNow = Long.parseLong(currentVal) + incrementVal;
            sysSequence.setCurrentVal(currentValNow + "");
            incrementVal = sysSequenceMapper.updateBySeqName(sysSequence);
        }
        catch (Exception e)
        {
            log.error("查询序列信息出错.....");
            e.printStackTrace();
            throw new BusiException("查询序列信息出错.....");
        }
        return currentVal;
    }
}
