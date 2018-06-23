<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>


<script type="text/javascript">
    var path = "${path}";
</script>
<link rel="stylesheet" type="text/css" href="${path}/easyui/1.3.4/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="${path}/css/wu.css"/>
<link rel="stylesheet" type="text/css" href="${path}/css/icon.css"/>
<!-- 导入Easy UI的图标Css文件 -->
<%--<link href="${path}/easyui/1.3.4/themes/icon.css" rel="stylesheet" type="text/css" />--%>
<script type="text/javascript" src="${path}/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${path}/easyui/1.3.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${path}/easyui/1.3.4/locale/easyui-lang-zh_CN.js"></script>
<!-- 引入easyui扩展 -->
<script src="${path}/easyui/1.3.4/extEasyUI.js" type="text/javascript"></script>
<!-- 扩展jQuery -->
<script src="${path}/easyui/1.3.4//extJquery.js" type="text/javascript"></script>
