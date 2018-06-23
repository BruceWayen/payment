<%@ page language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath =
            request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String message = (String)request.getSession().getAttribute("message");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
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
<script type="text/javascript">
    $(function () {
        jQuery("#layout_west_accordion").accordion({ //初始化accordion
            fillSpace: true,
            fit: true,
            border: false,
            animate: false
        });
        $.post("${pageContext.request.contextPath}/getMenu.do", //获取第一层目录
            function (data) {
                if (data == "0") {
                    window.location = "/login";
                }
                $.each(data, function (i, e) {//循环创建手风琴的项
                    var id = e.id;
                    $('#layout_west_accordion').accordion('add', {
                        title: e.text,
                        content: "<ul id='tree" + id + "' ></ul>",
                        selected: true,
                        iconCls: e.iconCls//e.Icon
                    });
                    $.parser.parse();
                    $.post("${pageContext.request.contextPath}/children.do?treeId=" + id, function (data) {//循环创建树的项
                        $("#tree" + id).tree({
                            data: data,
                            onBeforeExpand: function (node, param) {
                                $("#tree" + id).tree('options').url = "/@info/Home/GetTreeByEasyui?id=" + node.id;
                            },
                            onClick: function (node) {
                                if (node.state == 'closed') {
                                    $(this).tree('expand', node.target);
                                } else if (node.state == 'open') {
                                    $(this).tree('collapse', node.target);
                                } else {
                                    var tabTitle = node.text;
                                    var url = "<%=basePath%>"+ node.attributes;
                                    var icon = node.iconCls;
                                    addTab(tabTitle, url);
                                }
                            }
                        });
                    }, 'json');
                });
            }, "json");
    });

    function addTab(title, url) {
        //判断选项卡是否重复打开
        if ($('#wu-tabs').tabs('exists', title)) {
            $('#wu-tabs').tabs('select', title);//选中并刷新
        } else {
            var content = createFrame(url); //创建Frame
            $("#wu-tabs").tabs("add", {
                title: title,
                content: content,
                closable: true

            })
        }
    }
    //创建Frame
    function createFrame(url) {
        var tabHeight = $("#tabs").height() - 35;
        var s = '<iframe scrolling="auto" allowTransparency="true" frameborder="0"  src="' + url + '" style="width:100%; height:' + tabHeight + 'px;"></iframe>';
        return s;
    }

</script>
<body class="easyui-layout">
<!-- begin of header -->
<div class="wu-header" data-options="region:'north',border:false,split:true">
    <div class="wu-header-left">
        <h1>支付系统后台管理</h1>
    </div>
    <div class="wu-header-right">
        <p><strong class="easyui-tooltip" title="">${user.phoneNo}</strong>，欢迎您！</p>
        <p><a href="<%=basePath%>login.do">网站首页</a>|<a href="#">支持论坛</a>|<a href="#">帮助中心</a>|<a href="#">安全退出</a></p>
    </div>
</div>
<!-- end of header -->
<!-- begin of sidebar -->
<div class="wu-sidebar" data-options="region:'west',split:true,border:true,title:'导航菜单'">
    <div id="layout_west_accordion" class="easyui-accordion" data-options="border:false,fit:true">

    </div>
</div>
<!-- end of sidebar -->
<!-- begin of main -->
<div class="wu-main" data-options="region:'center'">
    <div id="wu-tabs" class="easyui-tabs" data-options="border:false,fit:true">
        <div title="首页" data-options="href:'temp/layout-1.html',closable:false,iconCls:'icon-tip',cls:'pd3'"></div>
    </div>
</div>
<!-- end of main -->
<!-- begin of footer -->
<%--<div class="wu-footer" data-options="region:'south',border:true,split:true">--%>
    <%--&copy; 2018 SongHongWei Payment System--%>
<%--</div>--%>
<!-- end of footer -->

</body>
</html>
