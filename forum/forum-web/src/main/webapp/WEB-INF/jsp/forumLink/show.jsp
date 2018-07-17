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
</head>
<body>
<div id="content">
	<h3 class="admin_link_bar">
		<jsp:include page="inc.jsp"></jsp:include>
	</h3>
	<table width="550px" cellspacing="0" cellPadding="0">
		<thead><tr><td colspan="2">Display hyperlink</td></tr></thead>
		<tr>
			<td class="rightTd" width="96px">hyperlink title:</td><td class="leftTd">${forumLink.title }</td>
		</tr>
		<tr>
			<td class="rightTd" width="96px">hyperlink address:</td><td class="leftTd"><a href="${forumLink.url }" class="list_link" target="_blank">${forumLink.url }</a></td>
		</tr>
		<tr>
			<td class="rightTd">hyperlink type：</td>
			<td class="leftTd">
				${forumLink.type }
			</td>
		</tr>
		<tr>
			<td class="rightTd">way of open]:</td>
			<td><c:if test="${forumLink.newWin eq 0}">this window</c:if>
				<c:if test="${forumLink.newWin eq 1}">new window</c:if></td>
		</tr>
		<tr>
			<td class="rightTd">link label ID:</td>
			<td>${forumLink.urlId }</td>
		</tr>
		<tr>
			<td class="rightTd">link label type:</td>
			<td>${forumLink.urlClass}</td>
		</tr>
	</table>
</div>
</body>
</html>