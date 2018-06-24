<%@ page language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath =
            request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String message = (String)request.getSession().getAttribute("message");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@include file="/jsp/common/easyui.jsp" %>
<script src="${path}/js/user.js" type="text/javascript"></script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<script type="text/javascript">
    $(function () {
        /**
         * Name 载入数据
         */
        $('#datagrid').datagrid({
            url: '<%=basePath%>/user/user_list3.do',
            loadFilter: pagerFilter,
            rownumbers: true,
            singleSelect: false,
            pageSize: 10,
            pagination: true,
            multiSort: true,
            fitColumns: true,
            fit: true,
            columns: [[
                {checkbox: true},
                {field: 'id', title: '用户标识', width: 100, sortable: true},
                {field: 'contractNo', title: '支付账号', width: 180, sortable: true},
                {field: 'userName', title: '用户名', width: 100},
                {field: 'loginNo', title: '工号', width: 100},
                {field: 'sex', title: '性别', width: 100},
                {field: 'deptId', title: '部门', width: 100},
                {field: 'phoneNo', title: '手机号', width: 110},
                {
                    field: 'registerTime', title: '注册时间', width: 100, formatter: function (value, row, index) {
                        //alert(value);
                        return DateTimeFormatter(value);
                    }
                }
            ]]
        });
    })
</script>
<body class="easyui-layout" fit="true">
<div class="easyui-layout" data-options="fit:true">
    <div data-options="region:'center',border:false">
        <div id="wu-toolbar">
            <div class="wu-toolbar-button">
                <a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="openAdd()" plain="true">添加</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-upload" onclick="" plain="true">批量添加</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="" plain="true">修改</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="remove()" plain="true">删除</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-reload" onclick="reload()" plain="true">刷新</a>
                <%--<a href="#" class="easyui-linkbutton" iconCls="icon-print" onclick="openAdd()" plain="true">打印</a>--%>
                <%--<a href="#" class="easyui-linkbutton" iconCls="icon-help" onclick="openEdit()" plain="true">帮助</a>--%>
                <%--<a href="#" class="easyui-linkbutton" iconCls="icon-undo" onclick="remove()" plain="true">撤销</a>--%>
                <%--<a href="#" class="easyui-linkbutton" iconCls="icon-redo" onclick="cancel()" plain="true">重做</a>--%>
                <%--<a href="#" class="easyui-linkbutton" iconCls="icon-sum" onclick="reload()" plain="true">总计</a>--%>
                <%--<a href="#" class="easyui-linkbutton" iconCls="icon-back" onclick="reload()" plain="true">返回</a>--%>
                <%--<a href="#" class="easyui-linkbutton" iconCls="icon-tip" onclick="reload()" plain="true">提示</a>--%>
                <%--<a href="#" class="easyui-linkbutton" iconCls="icon-save" onclick="reload()" plain="true">保存</a>--%>
                <%--<a href="#" class="easyui-linkbutton" iconCls="icon-cut" onclick="reload()" plain="true">剪切</a>--%>
                <%--<label style="font-size: 12px;  vertical-align: baseline;">关键词：</label>--%>
                <%--<input class="wu-text" style="width:100px;height: 20px;" value="${list.phoneNo}">--%>
                <%--<label>注册时间：</label><input class="easyui-datebox" style="width:100px">--%>
                <%--<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>--%>
                <%--</div>--%>
                <%--<div class="wu-toolbar-search">--%>

                <label>起始时间：</label><input class="easyui-datebox" style="width:100px">
                <label>结束时间：</label><input class="easyui-datebox" style="width:100px">
                <label>用户组：</label>
                <select class="easyui-combobox" panelHeight="auto" style="width:100px">
                    <option value="0">选择用户组</option>
                    <option value="1">黄钻</option>
                    <option value="2">红钻</option>
                    <option value="3">蓝钻</option>
                </select>
                <label style="font-size: 12px;  vertical-align: baseline;">关键词：</label>
                <input class="wu-text" style="width:100px" value="${list.phoneNo}">
                <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
            </div>
        </div>
        <!-- End of toolbar -->
        <table id="datagrid" class="easyui-datagrid" toolbar="#wu-toolbar"></table>
    </div>
</div>
<!-- 添加/修改对话框 -->
<%--<div id="adddlg" class="easyui-dialog"--%>
     <%--style="width:350px;height:280px;padding:10px 20px" closed="true"--%>
     <%--buttons="#dlg-buttons">--%>
    <%--<form id="addfrom" method="post" novalidate>--%>
        <%--<table>--%>
            <%--<tr>--%>
                <%--<td width="60" align="right">用户名:</td>--%>
                <%--<td><input type="text" name="name" class="wu-text"/></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td align="right">性别:</td>--%>
                <%--<td>--%>
                <%--<select class="easyui-combobox" panelHeight="auto" >--%>
                    <%--<option value="0">男</option>--%>
                    <%--<option value="1">女</option>--%>
                <%--</select>--%>
                <%--</td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td align="right">部门:</td>--%>
                <%--<td><input type="text" name="subject" class="wu-text"/></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td align="right">角色:</td>--%>
                <%--<td><input type="text" name="subject" class="wu-text"/></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td valign="top" align="right">手机号:</td>--%>
                <%--<td><input type="text" name="subject" class="wu-text"/></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td valign="top" align="right">身份证号:</td>--%>
                <%--<td><input type="text" name="subject" class="wu-text"/></td>--%>
            <%--</tr>--%>
        <%--</table>--%>
    <%--</form>--%>
<%--</div>--%>
<div id="adddlg" class="easyui-dialog"
     style="width:400px;height:400px;padding:30px 20px" closed="true"
     buttons="#dlg-buttons">
    <form id="addfrom" method="post" novalidate>
        <div class="fitem">
            <label>用户名:</label> <input name="username" class="easyui-textbox" required="true">
        </div>
        <div class="fitem">
            <label>密码:</label> <input name="password" class="easyui-textbox" required="true">
        </div>
        <div class="fitem">
            <label>身份证:</label> <input name="idcard" class="easyui-textbox" required="true">
        </div>
        <div class="fitem">
            <label>性别:</label>
            <input type="radio" name="gender" id="gender" value="男" style="width:50px;">男</input>
            <input type="radio" name="gender" id="gender" value="女" style="width:50px;">女</input>
        </div>
        <div class="fitem">
            <label>入职时间:</label> <input name="regtime" type="text" class="easyui-datebox"/>
        </div>
        <div class="fitem">
            <label>Email:</label> <input name="email" class="easyui-textbox" validType="email">
        </div>
        <div class="fitem">
            <label>QQ:</label> <input name="qq" class="easyui-textbox" >
        </div>
        <div class="fitem">
            <label>微信:</label> <input name="weixin" class="easyui-textbox" >
        </div>
    </form>
</div>
</body>
