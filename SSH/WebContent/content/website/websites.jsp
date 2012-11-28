<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WebSite</title>
<link href="/SSH/theme/comm/simpl.css" type="text/css" rel="stylesheet" media="screen" />
<link href="/SSH/theme/comm/base.css" type="text/css" rel="stylesheet" media="screen" />

<style type="text/css">
body {
	font-size: 11px;
}
#WebSiteContent ul {
	display: inline-block;
	vertical-align: text-top;
}

#WebSiteContent li {
	display: list-item;
}
.pin {
	width: 120px;
	height: 90px;
	padding: 3px;
	background-color: rgb(255, 255, 255);
	box-shadow: 0px 1px 3px rgba(34, 25, 25, 0.4);
}

.Img {
	max-width: 90%;
	max-height: 100%;
	margin: 0px auto;
	display: block;
}
</style>
</head>
<body class="Margin">
<jsp:include page="/content/comm/header.jsp"></jsp:include>
<div class="PageBackground">
	<header><p style="font-size:15px; font-weight: bold;">Web Site View</p></header>
	<br>
	<div id="WebSiteContent" class="Columns">
		<div class="Column OneQuarter">&nbsp;</div>
		<div class="Column OneHalf">
		<ul>
		<s:iterator id="website" value="WebSites" status="st">
		<li>
			<div style="height: 100px; padding: 10px 5px 0px 5px; border-top: 1px solid #CCC;">
				<div style="width:200px; height:100%; float:left;">
					<a href="#"><img src="<s:property value='imageUri' />" class="Img" /></a>
				</div>
				<div style="height:100%; margin: 0px 50px 0px 200px;">
					<header>
						<a target="_blank" href="http://<s:property value='url'/>" style="font-weight: bold;"><s:property value="name"/></a>
					</header>
					<section><s:property value="description"/></section>
					<br>
				</div>
			</div>
		</li>
		</s:iterator>
		</ul>
		</div>
		<div class="Column OneQuarter">&nbsp;</div>
	</div>
</div>
</body>
</html>