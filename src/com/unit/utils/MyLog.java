package com.unit.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * 
 * @描述：Aop日志类
 * 
 * @创建人：lli
 * 
 * @创建日期：2016年5月13日
 */
public class MyLog



{
    // 单元测试这个不能用，应该是web.xml 没起作用
   // @Autowired
    //private HttpServletRequest request;
    
    Logger logger = LoggerFactory.getLogger(MyLog.class);
    
    /**
     * 环绕通知：包围一个连接点的通知，可以在方法的调用前后完成自定义的行为，也可以选择不执行
     */
    public Object doAround(ProceedingJoinPoint pjp)
        throws Throwable
    {
        Object result = null;
        
        // 获取进入的类名
        String className = pjp.getSignature().getDeclaringTypeName();
        // 判断哪些需要日志
        long start = System.currentTimeMillis();
        // 截取获得出去包名的类名
        className = className.substring(className.lastIndexOf(".") + 1).trim();
        // 调用方法名称
        String methodName = pjp.getSignature().getName();
        // 获取参数
       // String params = showParams(request);
        String preLog = "【" + className + "." + methodName + "】";
        logger.info(preLog + "操作类：{}");
        logger.info(preLog + "操作方法：{}", methodName);
       // logger.info(preLog + "操作参数：{}", params);
        try
        {
            result = pjp.proceed();
        }
        catch (Exception e)
        {
            logger.error(e.getMessage());
        }
        if (result != null)
        {
            logger.info(preLog + "返回的结果为：" + result);
        }
        logger.info(preLog + "执行时间为：" + (System.currentTimeMillis() - start) + "毫秒");
        return result;
    }
    
    /**
     * 判断是否需要打印日志
     * 
     * @param className
     * @return
     */
    private boolean isPrintLog(String className)
    {
        boolean flag = false;
        flag = className.indexOf("com.chuibilong.controller") != -1;
        return flag;
    }
    
    /**
     * 获取请求的参数
     * 
     * @param request
     * @return
     */
    private String showParams(HttpServletRequest request)
    {
        StringBuilder paramLog = new StringBuilder();
        @SuppressWarnings("unchecked")
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements())
        {
            String paraName = enu.nextElement();
            paramLog.append(paraName).append(":").append(request.getParameter(paraName)).append(",");
        }
        String result = "";
        if (paramLog.length() > 0)
        {
            result = paramLog.substring(0, paramLog.length() - 1);
        }
        return result;
    }
}
