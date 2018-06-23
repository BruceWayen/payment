<%@ page language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath =
            request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String message = (String)request.getSession().getAttribute("message");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@include file="/jsp/common/easyui.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<script type="text/javascript">
</script>
<body class="easyui-layout" fit="true">
<div class="easyui-layout" data-options="fit:true">
    <div data-options="region:'center',border:false">
        <!-- Begin of toolbar -->
            <!-- 按钮 -->
            <div id="toolbar">
                <a href="javascript:void(0);" class="easyui-linkbutton"
                   iconCls="icon-add" plain="true" onclick="addUser();">新增</a>
                <a href="javascript:void(0);" class="easyui-linkbutton"
                   iconCls="icon-edit" plain="true" onclick="editUser();">编辑</a>
                <a href="javascript:void(0);" class="easyui-linkbutton"
                   iconCls="icon-remove" plain="true" onclick="deleteUser();">删除</a>
                <a href="javascript:void(0);" class="easyui-linkbutton"
                   iconCls="icon-reload" plain="true" onclick="reload();">刷新</a>
                <label style="font-size: 12px;  vertical-align: baseline;">关键词：</label><input class="wu-text" style="width:100px;height: 18px;" value="${list.phoneNo}">
                <a href="javascript:FindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
                <a href="javascript:void(0);" class="easyui-linkbutton"
                   iconCls="icon-jright" plain="true" onclick="searchUser();">更多查询</a>
            </div>
        <%--<div id="wu-toolbar">--%>
            <%--<div class="wu-toolbar-button">--%>
                <%--<a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="openAdd()" plain="true">添加</a>--%>
                <%--<a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="openEdit()" plain="true">修改</a>--%>
                <%--<a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="remove()" plain="true">删除</a>--%>
                <%--<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="cancel()" plain="true">取消</a>--%>
                <%--<a href="#" class="easyui-linkbutton" iconCls="icon-reload" onclick="reload()" plain="true">刷新</a>--%>
                <%--<a href="#" class="easyui-linkbutton" iconCls="icon-print" onclick="openAdd()" plain="true">打印</a>--%>
                <%--<a href="#" class="easyui-linkbutton" iconCls="icon-help" onclick="openEdit()" plain="true">帮助</a>--%>
                <%--<a href="#" class="easyui-linkbutton" iconCls="icon-undo" onclick="remove()" plain="true">撤销</a>--%>
                <%--<a href="#" class="easyui-linkbutton" iconCls="icon-redo" onclick="cancel()" plain="true">重做</a>--%>
                <%--<a href="#" class="easyui-linkbutton" iconCls="icon-sum" onclick="reload()" plain="true">总计</a>--%>
                <%--<a href="#" class="easyui-linkbutton" iconCls="icon-back" onclick="reload()" plain="true">返回</a>--%>
                <%--<a href="#" class="easyui-linkbutton" iconCls="icon-tip" onclick="reload()" plain="true">提示</a>--%>
                <%--<a href="#" class="easyui-linkbutton" iconCls="icon-save" onclick="reload()" plain="true">保存</a>--%>
                <%--<a href="#" class="easyui-linkbutton" iconCls="icon-cut" onclick="reload()" plain="true">剪切</a>--%>
            <%--</div>--%>
            <%--<div class="wu-toolbar-search">--%>
                <%--<label>起始时间：</label><input class="easyui-datebox" style="width:100px">--%>
                <%--<label>结束时间：</label><input class="easyui-datebox" style="width:100px">--%>
                <%--<label>用户组：</label>--%>
                <%--<select class="easyui-combobox" panelHeight="auto" style="width:100px">--%>
                    <%--<option value="0">选择用户组</option>--%>
                    <%--<option value="1">黄钻</option>--%>
                    <%--<option value="2">红钻</option>--%>
                    <%--<option value="3">蓝钻</option>--%>
                <%--</select>--%>
                <%--<label>关键词：</label><input class="wu-text" style="width:100px" value="${list.phoneNo}">--%>
                <%--<a href="#" class="easyui-linkbutton" iconCls="icon-search">开始检索</a>--%>
            <%--</div>--%>
        <%--</div>--%>
        <!-- End of toolbar -->

        <table id="datagrid" class="easyui-datagrid" singleSelect="true"
               fit="true" url="<%=basePath%>/user/user_list3.do" toolbar="#toolbar" autoRowHeight="true"
               pagination="true" fitColumns="true" singleSelect="true"
               rownumbers="true" striped="true" border="false" nowrap="false">
            <thead>
            <tr>
                <th field="contractNo" width="50" sortable="true">帖子编号</th>
                <th field="userName" width="50" sortable="true">帖子标题</th>
                <th field="idIccid" width="50">发帖人</th>
                <th field="phoneNo" width="100">用户名</th>
                <th field="registerTime" width="110">评论内容</th>
                <th field="registerType" width="100">回复人</th>
            </tr>
            </thead>
        </table>
    </div>
</div>
</body>
