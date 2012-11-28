<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WebSite</title>
<link href="/SSH/theme/comm/simpl.css" type="text/css" rel="stylesheet" media="screen" />
<link href="/SSH/theme/comm/base.css" type="text/css" rel="stylesheet" media="screen" />
</head>
<body>
<form action="/SSH/login.do" method="post">
	<s:hidden name="redirectUrl"></s:hidden>
	LoginName:<s:textfield id="loginName" name="loginName"></s:textfield>
	PassWord:<s:password id="passWord" name="passWord"></s:password>
	<s:submit id="submit" method="login" value="Login"></s:submit>
</form>
</body>
</html>