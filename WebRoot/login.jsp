<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
    <meta charset="utf-8">
    <title>支付系统后台管理</title>
    <link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
<div class="main">
    <div class="mainin">
        <h1><img src="images/ht_name.png"></h1>
        <div class="mainin1">
            <ul>
                <li><span>用户名：</span><input name="loginName" type="text" id="loginName" placeholder="登录名" class="SearchKeyword"></li>
                <li><span>密码：</span><input type="password" name="Possword" id="Possword" placeholder="密码" class="SearchKeyword2"></li>
                <li><button class="tijiao">登录</button></li>
            </ul>
        </div>
        <div class="footpage"><span style=" font-family:arial;">Copyright ©</span>2018 宋宏伟</div>
    </div>
</div>
<img src="images/loading.gif" id="loading" style=" display:none;position:absolute;" />
<div id="POPLoading" class="cssPOPLoading">
    <div style=" height:110px; border-bottom:1px solid #9a9a9a">
        <div class="showMessge"></div>
    </div>
    <div style=" line-height:40px; font-size:14px; letter-spacing:1px;">
        <a onclick="puc()">确定</a>
    </div>
</div>
<div style="text-align:center;">

</div>
</body>
</html>
