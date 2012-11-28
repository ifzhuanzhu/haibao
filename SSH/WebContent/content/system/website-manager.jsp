<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit</title>
<link href="/SSH/theme/comm/simpl.css" type="text/css" rel="stylesheet" media="screen" />
<link href="/SSH/theme/comm/base.css" type="text/css" rel="stylesheet" media="screen" />

<script type="text/javascript">
function changeImage() {
	alert(document.all.imageUpload.value);
	document.all.logoImage.src = document.all.imageUpload.value;
	alert(document.all.logoImage.src);
}
</script>
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
	<div></div>
	<div>
		<s:debug></s:debug>
		<form action="" method="post" enctype="multipart/form-data">
			<s:hidden name="webSite.websiteId"></s:hidden>
			<s:hidden name="webSite.imageUri"></s:hidden>
			<div ></div>
			<img id="logoImage" alt="logo" src="<s:property value='webSite.imageUri'/>" /><br>
			<s:file id="imageUpload" name="imageUpload" onchange="changeImage();"></s:file><br>
			<s:textfield name="webSite.name"></s:textfield><br>
			<s:textfield name="webSite.url"></s:textfield><br>
			<s:textfield name="webSite.description"></s:textfield><br>
			<br>
			<s:submit name="Save" value="Save" method="save"></s:submit>
			<s:submit name="Delete" value="Delete" method="delete"></s:submit>
			<s:submit name="Cancel" value="Cancel" method="cancel"></s:submit>
		</form>
	</div>
</div>
</body>
</html>