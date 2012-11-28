<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Manager</title>
</head>
<body>
<table>
<s:iterator id="admin" value="Admins" status="st">
	<tr>
		<td>
			<s:property value="LoginName"/>
		</td>
		<td>${ admin.adminID }</td>
		<td>${ admin.firstName }</td>
		<td>${ admin.lastName }</td>
	</tr>
</s:iterator>
</table>
</body>
</html>