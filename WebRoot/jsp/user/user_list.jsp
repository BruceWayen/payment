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
         *  载入数据
         */
        loadData("all_user.do");
        allRole("sRoleId");
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
                <label>注册时间：</label><input class="easyui-datetimebox" id="sRegisterTime" style="width:100px">
                <label>职称：</label>
                <select class="easyui-combobox" id="sRoleId"  data-options="valueField:'id', textField:'roleName', panelHeight:'auto'" style="width:100px">
                </select>
                <label style="font-size: 12px;  vertical-align: baseline;">手机号：</label>
                <input id="sPhoneNo" class="wu-text"  style="width:100px" value="">
                <a href="javascript:searchUser()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
            </div>
        </div>
        <!-- End of toolbar -->
        <table id="datagrid" class="easyui-datagrid" toolbar="#wu-toolbar"></table>
    </div>
</div>
<!-- 添加/修改对话框 -->
<div id="adddlg" class="easyui-dialog"
     style="width:370px;height:340px;padding:30px 20px" closed="true"
     buttons="#dlg-buttons">
    <form id="addfrom" method="post" novalidate>
        <div class="fitem">
            <label>用户名:</label> <input name="userName" class="easyui-textbox" required="true">
        </div>
        <div class="fitem">
            <label>手机号:</label> <input name="phoneNo" class="easyui-textbox" required="true">
        </div>
        <div class="fitem">
            <label>身份证:</label> <input name="idIccid" class="easyui-textbox" required="true">
        </div>
        <div class="fitem">
            <label>性别:</label>
            <select class="easyui-combobox" panelHeight="auto" style="width:160px" id="sex" name="sex">
                <option value="0" selected="selected">男</option>
                <option value="1">女</option>
            </select>
        </div>
        <div class="fitem">
            <label>部门:</label> <select class="easyui-combobox" name="deptId"
                                       data-options="valueField:'id', textField:'deptName', panelHeight:'auto'"
                                       style="width:160px" id="depts">
        </select>
        </div>
        <div class="fitem">
            <label>职称:</label> <select class="easyui-combobox" name="roleId"
                                       data-options="valueField:'id', textField:'roleName', panelHeight:'auto'"
                                       style="width:160px" id="role">

        </select>
        </div>
        <div class="fitem">
            <label>入职时间:</label> <input name="registerTime" type="text" style="width:160px" class="easyui-datetimebox"/>
        </div>
        <!--隐藏域,标记注册方式为后台注册-->
        <input name="registerType" id="registerType" type="hidden" value="1" class="easyui-textbox">
        <input name="userSatus" id="userSatus" type="hidden" value="0" class="easyui-textbox">

    </form>
</div>
</body>
