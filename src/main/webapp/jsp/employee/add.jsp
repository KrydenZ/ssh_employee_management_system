<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="/style/easyui.css"/>
<link rel="stylesheet" type="text/css" href="/style/icon.css"/>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/js/easyui-lang-zh_CN.js"></script>
</head>
<body>

<script type="text/javascript">
	$(document).ready(function(){
		$("#date_input").datebox({required:true});
		$("#date_input2").datebox({required:true});
	});
	function myformatter(date){
		var y = date.getFullYear();
		var m = date.getMonth()+1;
		var d = date.getDate();
		return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
	}
	function myparser(s){
		if (!s) return new Date();
		var ss = (s.split('-'));
		var y = parseInt(ss[0],10);
		var m = parseInt(ss[1],10);
		var d = parseInt(ss[2],10);
		if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
			return new Date(y,m-1,d);
		} else {
			return new Date();
		}
	}
</script>

<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 员工添加</td>
</tr>
<tr>
<td align="right" > 
<a href="javascript:document.getElementById('saveForm').submit()">保存</a> &nbsp;&nbsp;
<a href="javascript:history.go(-1)">退回</a>
</td>
</tr>
</table>
<br/>

<s:form action="employee_save" method="" namespace="/" id="saveForm" theme="simple">
<table border='0' cellpadding="0"  cellspacing="10">

<tr>
<td>姓名：</td>
<td><s:textfield name="ename"/></td>
<td>性别：</td>
<td><s:radio name="sex" list="{'男','女'}"/></td>
</tr>

<tr>
<td>用户名：</td>
<td><s:textfield name="username"/></td>
<td>密码：</td>
<td><s:password name="password"/></td>
</tr>

<tr>
<td>出生日期：</td>
<td><s:textfield name="birthday" id="date_input" data-options="formatter:myformatter,parser:myparser"/></td>
<td>入职时间：</td>
<td><s:textfield name="joinDate" id="date_input2" data-options="formatter:myformatter,parser:myparser"/></td>
</tr>

<tr>
<td>所属部门：</td>
<td><s:select name="department.did" list="list" listKey="did" listValue="dname" headerKey="" headerValue="--请选择--"/></td>
<td>编号：</td>
<td><s:textfield name="eno" /></td>
</tr>
</table>
</s:form>

</body>
</html>