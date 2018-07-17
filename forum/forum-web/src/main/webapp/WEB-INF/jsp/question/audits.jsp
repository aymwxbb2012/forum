<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/main.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/core/jquery.forum.core.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/main.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/inc.js"></script>
<script type="text/javascript">
$(function(){
	$("#search").click(function(event){
		var con = $("#con").val(); var cid = $("#cid").val();
		var path = "audits?con="+$("#con").val()+"&cid="+$("#cid").val();
		window.location=path;
	});
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
		<tr><td colspan="6">
		search question:<input type="text" name="con" size="30" id="con" value="${con}">
		<select name="cid" id="cid">
			<option value="0">choose channel</option>
			<c:forEach items="${cs }" var="c">
				<c:if test="${c.id  eq cid}">
				<option value="${c.id }" selected="selected">${c.name }</option>
				</c:if>
				<c:if test="${c.id  ne cid}">
				<option value="${c.id }">${c.name }</option>
				</c:if>
			</c:forEach>
		</select>
		<input type="button" id="search" value="search question"/>
		</td></tr> 
		<tr>
			<td>title</td>
			<td>author</td>
			<td>recommend</td>
			<td>channel</td>
			<td>status</td>
			<td>actions</td>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${datas.datas }" var="q">
			<tr>
				<td><a href="${q.id }" class="list_link">${q.title }</a></td>
				<td>${q.author}</td>
				<td>
					<c:if test="${q.recommend eq 0 }">not recommended</c:if>
					<c:if test="${q.recommend eq 1 }">recommended</c:if>
				</td>
				<td>
					${q.cname }
				</td>
				<td>
					<c:if test="${q.status eq 0 }">unpublished</c:if>
					<c:if test="${q.status eq 1 }">published</c:if>
				</td>
				<td>
					<a href="delete/${q.id }?status=${q.status}" class="list_op delete">delete</a>
					<a href="changeStatus/${q.id }?status=${q.status}" class="list_op delete">cancel</a>
				&nbsp;
				</td>
			</tr>
		</c:forEach>
		</tbody>
		<tfoot>
		<tr>
			<td colspan="6" style="text-align:right;margin-right:10px;">
			<jsp:include page="/jsp/pager.jsp">
				<jsp:param value="${datas.total }" name="totalRecord"/>
				<jsp:param value="audits" name="url"/>
			</jsp:include>
			</td>
		</tr>
		</tfoot>
	</table>
</div>
</body>
</html>