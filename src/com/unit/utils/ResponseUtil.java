package main.java.com.unit.utils;

/**
 * @DESCRIPTION ${END}
 * @AUTHOR SongHongWei
 * @TIME 2018/5/9-15:52
 * @PACKAGE_NAME main.java.com.unit.payment.utils
 **/

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/***
 * 主要用于返回json数据
 * @author Administrator
 */
public class ResponseUtil
{
    public static void write(HttpServletResponse response, Object object)
        throws Exception
    {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(object);
        out.flush();
        out.close();
    }
}