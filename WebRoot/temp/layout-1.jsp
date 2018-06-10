<%@ page language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath =
            request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String message = (String)request.getSession().getAttribute("message");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="copyright" content="All Rights Reserved, Copyright (C) 2013, Wuyeguo, Ltd."/>
    <title>支付管理系统V1.1</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>easyui/1.3.4/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/wu.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/icon.css"/>
    <script type="text/javascript" src="<%=basePath%>js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>easyui/1.3.4/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>easyui/1.3.4/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
<div class="easyui-layout" data-options="fit:true">
    <div data-options="region:'west',border:true,split:true," title="分类管理" style="width:150px; padding:5px;">
        <ul id="wu-category-tree" class="easyui-tree"></ul>
    </div>
    <div data-options="region:'center',border:false">
        <!-- Begin of toolbar -->
        <div id="wu-toolbar">
            <div class="wu-toolbar-button">
                <a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="openAdd()" plain="true">添加</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="openEdit()" plain="true">修改</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="remove()" plain="true">删除</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="cancel()" plain="true">取消</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-reload" onclick="reload()" plain="true">刷新</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-print" onclick="openAdd()" plain="true">打印</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-help" onclick="openEdit()" plain="true">帮助</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-undo" onclick="remove()" plain="true">撤销</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-redo" onclick="cancel()" plain="true">重做</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-sum" onclick="reload()" plain="true">总计</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-back" onclick="reload()" plain="true">返回</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-tip" onclick="reload()" plain="true">提示</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-save" onclick="reload()" plain="true">保存</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-cut" onclick="reload()" plain="true">剪切</a>
            </div>
            <div class="wu-toolbar-search">
                <label>起始时间：</label><input class="easyui-datebox" style="width:100px">
                <label>结束时间：</label><input class="easyui-datebox" style="width:100px">
                <label>用户组：</label>
                <select class="easyui-combobox" panelHeight="auto" style="width:100px">
                    <option value="0">选择用户组</option>
                    <option value="1">黄钻</option>
                    <option value="2">红钻</option>
                    <option value="3">蓝钻</option>
                </select>
                <label>关键词：</label><input class="wu-text" style="width:100px">
                <a href="#" class="easyui-linkbutton" iconCls="icon-search">开始检索</a>
            </div>
        </div>
        <!-- End of toolbar -->
        <table id="wu-datagrid" toolbar="#wu-toolbar"></table>
    </div>
</div>
<!-- Begin of easyui-dialog -->
<div id="wu-dialog" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'"
     style="width:400px; padding:10px;">
    <form id="wu-form" method="post">
        <table>
            <tr>
                <td width="60" align="right">姓 名:</td>
                <td><input type="text" name="name" class="wu-text"/></td>
            </tr>
            <tr>
                <td align="right">邮 箱:</td>
                <td><input type="text" name="email" class="wu-text"/></td>
            </tr>
            <tr>
                <td align="right">主 题:</td>
                <td><input type="text" name="subject" class="wu-text"/></td>
            </tr>
            <tr>
                <td valign="top" align="right">内 容:</td>
                <td><textarea name="content" rows="6" class="wu-textarea" style="width:260px"></textarea></td>
            </tr>
        </table>
    </form>
</div>
</body>
