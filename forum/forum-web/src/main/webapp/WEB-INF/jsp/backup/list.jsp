<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/main.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/core/jquery.forum.core.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/main.js"></script>
<script type="text/javascript">
$(function(){
	$("a.resumeDatabase").click(function() {
		if(!confirm("Cannot recover after coverage, do you want to overwrite? A backup is recommended")) {
			event.preventDefault();
		} else {
			$("a.resumeDatabase").parent("td").html("Please wait a moment while recovering.");
		}
	})
})
</script>
</head>
<body>
<div id="content">
	<h3 class="admin_link_bar">
		<jsp:include page="inc.jsp"></jsp:include>
	</h3>
	<table width="800" cellspacing="0" cellPadding="0" id="listTable">
		<thead>
		<tr>
			<td>backup file name</td>
			<td>size of file</td>
			<td>backup time</td>
			<td>type</td>
			<td>actions</td>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${backups }" var="b">
			<tr>
				<td>${b.name }</td>
				<td>${b.size }K</td>
				<td><fmt:formatDate value="${b.time }" pattern="dd-MM-yyyy HH:mm"/></td>
				<td>
					${b.filetype }
				</td>
				<td>
					<a href="delete/${b.name }?type=${b.filetype}"  class="list_op delete">delete</a>
					<a href="resume/${b.name}?type=${b.filetype}" class="list_op resumeDatabase">restore database</a>
				&nbsp;
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>