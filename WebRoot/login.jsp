<%@ page language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath =
            request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>支付系统后台管理</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="easyui/1.3.4/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="easyui/1.3.4/locale/easyui-lang-zh_CN.js"></script>
</head>
<script type="text/javascript">
    $(function () {
        //提交表单
        $('#submit_btn').click(function () {
            if ($('#username').val() == '') {
                $.messager.alert('用户名还没填呢！','info');
                $('#username').focus();
            } else if ($('#password').val() == '') {
                alert('密码还没填呢！');
                $('#password').focus();
            } else if ($('#username').val() != '' && $('#password').val() != '' && $('#j_captcha').val() != '') {
                document.login.submit();
            }

        });
    });

    function ShowMsg() {
        $.messager.alert('Success', 'Save Success!');
        closeDialog();
    }
</script>
<body>
<div class="main">
    <form action="login.do" method="post" name="login" id="login">
        <div class="mainin">
            <h1><img src="images/ht_name.png"></h1>
            <div class="mainin1">
                <ul>
                    <li><span>用户名：</span><input name="username" type="text" id="username" placeholder="登录名"  value="admin"
                                                class="SearchKeyword"></li>
                    <li><span>密码：</span><input type="password" name="password" id="password" placeholder="密码" value=""
                                               class="SearchKeyword2"></li>
                    <li>
                        <button class="tijiao" id="submit_btn">登录</button>
                    </li>
                </ul>
            </div>
            <div class="footpage"><span style=" font-family:arial;">Copyright ©</span>2018 宋宏伟</div>
        </div>
    </form>
</div>
<img src="images/loading.gif" id="loading" style=" display:none;position:absolute;"/>
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
