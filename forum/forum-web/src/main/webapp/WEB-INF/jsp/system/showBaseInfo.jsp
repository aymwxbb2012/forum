<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<jsp:include page="incBaseInfo.jsp"></jsp:include>
	</h3>
	<table width="800" cellspacing="0" cellPadding="0">
		<thead><tr><td colspan="2">Modify the site information function</td></tr></thead>
		<tr>
			<td class="rightTd" width="200px">web name:</td>
			<td class="leftTd">${baseInfo.name }</td>
		</tr>
		<tr>
			<td class="rightTd">web address:</td>
			<td class="leftTd">${baseInfo.address }</td>
		</tr>
		<tr>
			<td class="rightTd">zipcode:</td>
			<td class="leftTd">${baseInfo.zipCode }</td>
		</tr>
		<tr>
			<td class="rightTd">phone number:</td>
			<td class="leftTd">${baseInfo.phone }</td>
		</tr>
		<tr>
			<td class="rightTd">email:</td>
			<td class="leftTd">${baseInfo.email }</td>
		</tr>
		<tr>
			<td class="rightTd">Domain name:</td>
			<td class="leftTd">${baseInfo.domainName }</td>
		</tr>
		<tr>
			<td class="rightTd">Website record number:</td>
			<td class="leftTd">${baseInfo.recordCode }</td>
		</tr>
		<tr>
			<td class="rightTd">width of index picture:</td>
			<td class="leftTd">${baseInfo.indexPicWidth }</td>
		</tr>
		<tr>
			<td class="rightTd">height of index picture:</td>
			<td class="leftTd">${baseInfo.indexPicHeight }</td>
		</tr>
		<tr>
			<td colspan="2" class="centerTd"><a href="<%=request.getContextPath() %>/admin/system/baseinfo/update" class="list_op">modify web information</a></td>
		</tr>
	</table>
</div>
</body>
</html>