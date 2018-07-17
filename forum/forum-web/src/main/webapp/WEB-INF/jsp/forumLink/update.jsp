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
	$("#urlType").change(function(){
		var v = $(this).val();
		if(v=="-1") {
			$("#type").removeAttr("readonly");
			$("#type").select();
			$("#type").focus();
		} else if(v!="0"){
			$("#type").val(v);
			$("#type").attr("readonly","true");
		}
	})
});
</script>
</head>
<body>
<div id="content">
	<h3 class="admin_link_bar">
		<jsp:include page="inc.jsp"></jsp:include>
	</h3>
	<sf:form method="post" modelAttribute="forumLink" id="addForm">
	<table width="550px" cellspacing="0" cellPadding="0">
		<thead><tr><td colspan="2">update hyperlink</td></tr></thead>
		<tr>
			<td class="rightTd" width="96px">title:</td><td class="leftTd"><sf:input path="title" size="50"/><sf:errors cssClass="errorContainer" path="title"/></td>
		</tr>
		<tr>
			<td class="rightTd" width="96px">address:</td><td class="leftTd"><sf:input path="url" size="50"/></td>
		</tr>
		<tr>
			<td class="rightTd">type：</td>
			<td class="leftTd">
				<select id="urlType">
				<option value="0">choose type</option>
				<c:forEach items="${types }" var="t">
					<option value="${t }">${t }</option>
				</c:forEach>
				<option value="-1">choose other</option>
				</select>
				<sf:input path="type" readonly="true"/>
			</td>
		</tr>
		<tr>
			<td class="rightTd">way of open:</td>
			<td><sf:radiobutton path="newWin" value="0"/>this window
				<sf:radiobutton path="newWin" value="1"/>new window</td>
		</tr>
		<tr>
			<td class="rightTd">link label ID:</td>
			<td><sf:input path="urlId" size="50"/></td>
		</tr>
		<tr>
			<td class="rightTd">link label type:</td>
			<td><sf:input path="urlClass" size="50"/></td>
		</tr>
		<tr>
			<td colspan="2" class="centerTd"><input type="submit" value="update hyperlink"/><input type="reset"/></td>
		</tr>
	</table>
	</sf:form>
</div>
</body>
</html>