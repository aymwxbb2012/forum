﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
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
	<h3 class="admin_link_bar">
		<jsp:include page="inc.jsp"></jsp:include>
	</h3>
	<sf:form method="post" modelAttribute="userDto" id="addForm">
	<table width="800" cellspacing="0" cellPadding="0">
	<sf:hidden path="id"/><sf:hidden path="username"/>
	<sf:hidden path="password"/>
		<thead><tr><td colspan="2">Modify user-->${userDto.username}</td></tr></thead>
		<tr>
			<td class="rightTd">Display name(Chinese accessiable):</td><td class="leftTd"><sf:input path="nickname" size="30"/></td>
		</tr>
		<tr>
			<td class="rightTd">Contact phone:</td><td><sf:input path="phone" size="30"/></td>
		</tr>
		<tr>
			<td class="rightTd">Email:</td><td><sf:input path="email" size="30"/><sf:errors path="email"/></td>
		</tr>
		<tr>
			<td class="rightTd">Status:</td>
			<td>
				<sf:select path="status">
					<sf:option value="0">Stop</sf:option>
					<sf:option value="1">Start</sf:option>
				</sf:select>
			</td>
		</tr>
		<tr>
			<td class="rightTd">Role:</td>
			<td>
				<%-- <c:forEach var="role" items="${roles }">
					${role.descr }<input type="checkbox" name="roleIds" value="${role.id }"/>
				</c:forEach> --%>
				<sf:checkboxes  items="${roles}" itemLabel="name" itemValue="id" path="roleIds"/>
			</td>
		</tr>
		<tr>
			<td class="rightTd">User group:</td>
			<td>
				<%-- <c:forEach var="role" items="${roles }">
					${role.descr }<input type="checkbox" name="roleIds" value="${role.id }"/>
				</c:forEach> --%>
				<sf:checkboxes items="${groups }" path="groupIds" itemLabel="name" itemValue="id"/>
			</td>
		</tr>
		<tr>
			<td colspan="2" class="centerTd"><input type="submit" value="修改用户"/><input type="reset"/></td>
		</tr>
	</table>
	</sf:form>
</div>
</body>
</html>