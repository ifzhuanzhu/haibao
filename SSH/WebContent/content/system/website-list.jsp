<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Web Site List</title>
<link href="/SSH/theme/comm/simpl.css" type="text/css" rel="stylesheet" media="screen" />
<link href="/SSH/theme/comm/base.css" type="text/css" rel="stylesheet" media="screen" />
</head>
<body class="Margin">
<jsp:include page="/content/comm/header.jsp"></jsp:include>
<header class="Header" style="margin-bottom: 10px;">
	<ul>
		<li style="display: inline-block;">Home</li>
		<li style="display: inline-block;">website</li>
	</ul>
</header>
<div class="PageBackground">
	<div><a href="website-manager.do">Add New</a></div>
	<div>		
		<table border="1">
			<tr>
				<th>Img</th>
				<th>Name</th>
				<th>Url</th>
				<th>Description</th>
				<th>Action</th>
			</tr>
			<s:iterator id="webSite" value="WebSites" status="st">
			<tr>
				<td style="text-align: center;">
					<img src="<s:property value='imageUri' />" style="max-width: 180px;" />
				</td>
				<td>
					<s:property value="name"/>
				</td>
				<td>
					<s:property value="url"/>
				</td>
				<td>
					<s:property value="description"/>
				</td>
				<td>
					<a href="/SSH/system/website-manager.do?id=<s:property value='websiteId'/>">Edit</a>
				</td>
			</tr>
			</s:iterator>
		</table>
	</div>
</div>
</body>
</html>