<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/main.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/article.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/main.js"></script>
</head>
<body>
<input type="hidden" id="sid" value="<%=session.getId()%>"/>
<div id="container">
<jsp:include page="/jsp/admin/top_inc.jsp"></jsp:include>
<div id="contents">
<input type="hidden" id="ctx" value="<%=request.getContextPath() %>"/>
	<h3 class="admin_link_bar" style="text-align:center">
	<span>show homepage picture</span>
	</h3>
	<table width="980" cellspacing="0" cellPadding="0" id="addTable">
		<tr>
			<td colspan="2">
				<img src="<%=request.getContextPath() %>/resources/indexPic/${indexPic.newName}"/>
			</td>
		</tr>
		<tr>
			<td class="rightTd" width="120px">title:</td>
			<td class="leftTd">${indexPic.title }</td>
		</tr>
		<tr>
			<td class="rightTd" width="120px">subtitle:</td>
			<td class="leftTd">${indexPic.subTitle }</td>
		</tr>
		<tr>
			<td class="rightTd">status:</td>
			<td class="leftTd">
			<c:if test="${indexPic.status eq 0 }">unpublished</c:if>
			<c:if test="${indexPic.status ne 0 }">published</c:if>
			</td>
		</tr>
		<tr>
			<td class="rightTd">link type:</td>
			<td class="leftTd">
				<c:if test="${indexPic.linkType eq 0 }">internal link</c:if>
				<c:if test="${indexPic.linkType ne 0 }">external link</c:if>
			</td>
		</tr>
		<tr>
			<td class="rightTd">link address:</td>
			<td class="leftTd">
				${indexPic.linkUrl }
			</td>
		</tr>
	</table>
</div>
</div>
</body>
</html>