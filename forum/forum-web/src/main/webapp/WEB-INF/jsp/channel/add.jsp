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
	<h3 class="admin_link_bar">
		<jsp:include page="inc.jsp"></jsp:include>
	</h3>
	<sf:form method="post" modelAttribute="channel" id="addForm">
	<table width="550px" cellspacing="0" cellPadding="0">
		<thead><tr><td colspan="2">Add[${pc.name}]Sub-channel function</td></tr></thead>
		<tr>
			<td class="rightTd" width="96px">Channelname:</td><td class="leftTd"><sf:input path="name" size="30"/><sf:errors cssClass="errorContainer" path="name"/></td>
		</tr>
		<tr>
			<td class="rightTd">IS to specify a link</td>
			<td class="leftTd">
				<sf:radiobutton path="customLink" value="0"/>Not Specify
				<sf:radiobutton path="customLink" value="1"/>Specify
			</td>
		</tr>
		<tr>
			<td class="rightTd">link address:</td>
			<td><sf:input path="customLinkUrl" size="50"/></td>
		</tr>
		<tr>
			<td class="rightTd">Channel type:</td>
			<td><sf:select path="type">
				<sf:options items="${types}"/>
			</sf:select></td>
		</tr>
		<tr>
			<td class="rightTd">Is displayed on the home page:</td>
			<td><sf:radiobutton path="isIndex" value="0"/>Not Display
				<sf:radiobutton path="isIndex" value="1"/>Display</td>
		</tr>
		<tr>
			<td class="rightTd">Navigate the top section:</td>
			<td><sf:radiobutton path="isTopNav" value="0"/>No
				<sf:radiobutton path="isTopNav" value="1"/>Yes</td>
		</tr>
		<tr>
			<td class="rightTd">Is recommended section:</td>
			<td><sf:radiobutton path="recommend" value="0"/>No
				<sf:radiobutton path="recommend" value="1"/>Yes</td>
		</tr>
		<tr>
			<td class="rightTd">Status:</td>
			<td>
				<sf:radiobutton path="status" value="0"/>Enabled
				<sf:radiobutton path="status" value="1"/>Disabled
			</td>
		</tr>
		<tr>
			<td class="rightTd">Navigation serial number:</td>
			<td>
				<sf:input path="navOrder" size="50"/>
			</td>
		</tr>
		<tr>
			<td colspan="2" class="centerTd"><input type="submit" value="Add chanel"/><input type="reset"/>reset</td>
		</tr>
	</table>
	</sf:form>
</div>
</body>
</html>