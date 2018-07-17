<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/main.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/validate/main.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.validate.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/core/jquery.forum.validate.js"></script>
<script type="text/javascript">
$(function(){
	$("#addForm").forumvalidate();
});
</script>
</head>
<body>
<div id="content">
	
	<sf:form method="post" modelAttribute="userDto" id="addForm">
	<table width="800" cellspacing="0" cellPadding="0">
		<thead><tr><td colspan="2">register</td></tr></thead>
		<tr>
			<td class="rightTd" width="200px">User name:</td>
			<td class="leftTd"><sf:input path="username" size="30"/><sf:errors cssClass="errorContainer" path="username"/></td>
		</tr>
		<tr>
			<td class="rightTd">Display Name:</td><td class="leftTd"><sf:input path="nickname" size="30"/></td>
		</tr>
		<tr>
			<td class="rightTd">user password:</td><td><sf:password path="password" size="30"/><sf:errors cssClass="errorContainer" path="password"/></td>
		</tr>
		<tr>
			<td class="rightTd">confirm password:</td><td><input type="password" id="confirmPwd" name="confirmPwd" size="30"/></td>
		</tr>
		<tr>
			<td class="rightTd">contact number:</td><td><sf:input path="phone" size="30"/></td>
		</tr>
		<tr>
			<td class="rightTd">e-mail:</td><td><sf:input path="email" size="30"/><sf:errors path="email"/></td>
		</tr>
		
		<tr>
			<td colspan="2" class="centerTd"><input type="submit" value="add user"/><input type="reset"/>reset</td>
		</tr>
	</table>
	</sf:form>
</div>
</body>
</html>