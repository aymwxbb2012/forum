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

</head>
<body>
<div id="content">
	<h3 class="admin_link_bar">
		<jsp:include page="inc.jsp"></jsp:include>
	</h3>
	<table width="800" cellspacing="0" cellPadding="0" id="listTable">
		<thead>
		
		<tr>
			<td width="400">id</td>
			<td>author</td>
			<td>question</td>
			<td>chosen</td>
			<td>actions</td>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${datas.datas }" var="a">
			<tr>
				<td><a href="javascript:openWin('<%=request.getContextPath() %>/admin/answer/${a.id }','showQAnswer')" class="list_link">${a.qname }${a.id }</a></td>
				<td>${a.author}</td>
				<td>
					<c:if test="${a.chosen eq 0 }">not chosen</c:if>
					<c:if test="${a.chosen eq 1 }">chosen</c:if>
				</td>
				<td>
					${a.qname }
				</td>
				
				<td>
					<a href="delete/${a.id }?status=${a.status}" class="list_op delete">delete</a>
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