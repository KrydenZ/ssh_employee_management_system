<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!doctype html>
<html>
<head>
<style type="text/css">
.div1{ margin-top:50px; margin-left:600px; font-size:14px; color:white}
</style>
</head>

<body bgcolor="#0099FF">
<div class="div1">
欢迎您：<s:property value="#session.existEmployee.ename" />
<!-- 添加target=_parent保证子页面内跳转整个页面 -->
<a href="${pageContext.request.contextPath}/login_logout" target=_parent>退出</a>
</div>
</body>
</html>