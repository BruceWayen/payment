package com.unit.utils;

import com.unit.domain.SysOperate;
import com.unit.domain.SysUsers;
import com.unit.service.OperateService;
import com.unit.utils.annotation.OperateLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

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
 *@TIME 2018/6/25-15:15
 *@PACKAGE_NAME com.unit.utils
 **/
@Aspect
// 该注解标示该类为切面类
@Component
public class LogAspect
{

    @Autowired
    private OperateService operateService;

    /**
     * 在所有标注@OperateLog的地方注入
     *
     * @param joinPoint
     * @throws ClassNotFoundException
     * */
    @After("@annotation(com.unit.utils.annotation.OperateLog)")
    public void afterExce(final JoinPoint joinPoint)
        throws ClassNotFoundException
    {
        final HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        final HttpSession session = request.getSession();
        final SysUsers user = (SysUsers)session.getAttribute(Const.SESSION_USER);
        final String targetName = joinPoint.getTarget().getClass().getName();
        final String methodName = joinPoint.getSignature().getName();
        // 将操作日志实体类托管给spring管理
        final SysOperate operate = new SysOperate();
        operate.setContent(targetName + "中的" + methodName + "方法");
        operate.setOperModule(this.getMethodModule(joinPoint, targetName, methodName));
        operate.setOperTime(TimeUtil.getNowTime());
        operate.setOperUser(user.getLoginNo());
        operate.setRemark("访问地址IP:" + request.getRemoteAddr() + ";用户名:" + user.getUserName() + ";用户登录工号:" + user.getLoginNo());
        operateService.save(operate);
    }

    /**
     * 获取@OperateLog中的module的信息
     *
     * @param joinPoint
     * @param targetName
     * @param methodName
     * @return
     * @throws ClassNotFoundException
     * @see [类、类#方法、类#成员]
     */
    public static String getMethodModule(final JoinPoint joinPoint, final String targetName, final String methodName)
        throws ClassNotFoundException
    {
        final Object[] arguments = joinPoint.getArgs();
        final Class targetClass = Class.forName(targetName);
        final Method[] methods = targetClass.getMethods();
        String module = "";
        for (Method method : methods)
        {
            if (method.getName().equals(methodName))
            {
                final Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length)
                {
                    module = method.getAnnotation(OperateLog.class).module();
                    break;
                }
            }
        }
        return module;
    }

    public OperateService getOperateService()
    {
        return operateService;
    }

    public void setOperateService(final OperateService operateService)
    {
        this.operateService = operateService;
    }
}