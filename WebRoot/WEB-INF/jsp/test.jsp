<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath =
            request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String message = (String)request.getSession().getAttribute("message");
%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>easyui/1.3.4/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/wu.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/icon.css"/>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=basePath%>easyui/1.3.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>easyui/1.3.4/locale/easyui-lang-zh_CN.js"></script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript">

    $(function () {
        $.ajax({
            type: 'POST',
            dataType: "json",
            url: '${pageContext.request.contextPath}/getMenu.do',
            success: function (data) {
                $.each(data, function (i, n) {//加载父类节点即一级菜单
                    if (i == 0) {//显示第一个一级菜单下的二级菜单
                        $('#layout_west_accordion').accordion('add', {
                            title: n.text,
                            iconCls: n.iconCls,
                            selected: false,
                            content: '<div style="padding:10px"><ul name="' + n.text + '"></ul></div>',
                        });
                    } else {
                        $('#layout_west_accordion').accordion('add', {
                            title: n.text,
                            iconCls: n.iconCls,
                            selected: false,
                            content: '<div style="padding:10px"><ul name="' + n.text + '"></ul></div>',
                        });
                    }

                });
            }
        });
        //异步加载子节点，即二级菜单
        $('#layout_west_accordion').accordion({
            onSelect: function (title, index) {
                $("ul[name='" + title + "']").tree({
                    url: '${pageContext.request.contextPath}/children.do?treeId=1',
                    animate: true,
                     lines: true,//显示虚线效果
                    onClick: function (node) {// 在用户点击一个子节点即二级菜单时触发addTab()方法,用于添加tabs
                        alert(node);
                        if (node.url) {//判断url是否存在，存在则创建tabs
                            addTab(node);
                        }
                    }
                });
            }
        });
    });

</script>
<body>
<div id="layout_west_accordion" class="easyui-accordion" data-options="fit:true,border:false,nimate:true,lines:true">
        
    <div title="搜索菜单" data-options="iconCls:'icon-search',collapsed:false,collapsible:false" style="padding: 10px;">
                <input id="layout_west_sc" class="easyui-searchbox" data-options="prompt:'请输入你需要的菜单'"
                       style="width: 180px; height: 25px;">
    </div>

</div>
</body>
</html>
