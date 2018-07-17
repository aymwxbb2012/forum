<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/main.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/js/base/jquery.ui.all.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/core/jquery.forum.core.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/main.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/ui/jquery.ui.core.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/ui/jquery.ui.widget.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/ui/jquery.ui.mouse.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/ui/jquery.ui.sortable.js"></script>

<script type="text/javascript">
$(function(){
	if($("#refresh").val()=="1") {
		parent.refreshTree();
	}
	$(".listTable").mysorttable();
});
</script>
</head>
<body>
<div id="content">
	<h3 class="admin_link_bar">
		<jsp:include page="inc.jsp"></jsp:include>
	</h3>
	<input type="hidden" id="refresh" value="${refresh}"/>
	<table width="580" cellspacing="0" cellPadding="0" class="listTable">
		<thead>
		<tr>
			<td>Channel name</td>
			<td>Channel type</td>
			<td>Is recommended</td>
			<td>home channel</td>
			<td>channel type</td>
			<Td>operation</Td>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${channels }" var="c">
			<tr id="id_${c.id }">
				<td>
				${c.name }
				&nbsp;</td>
				<td class="ctype">${c.type.name }</td>
				<td>
				<c:if test="${c.recommend eq 0 }"><span class="emp">Not recommend</span></c:if>
				<c:if test="${c.recommend eq 1 }">Recommend</c:if>
				&nbsp;</td>
				<td>
				<c:if test="${c.isIndex eq 0 }"><span class="emp">No</span></c:if>
				<c:if test="${c.isIndex eq 1 }">Yes</c:if>
				&nbsp;
				</td>
				<td><c:if test="${c.status eq 0 }">Start</c:if>
				<c:if test="${c.status eq 1 }"><span class="emp">Stop</span></c:if>
				&nbsp;</td>
				<td class="centerTd">
					<a href="<%=request.getContextPath() %>/admin/channel/update/${c.id}" class="list_op">
					update</a>
					<a href="<%=request.getContextPath() %>/admin/channel/delete/${pid}/${c.id}"  class="list_op delete">delete</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
		<tfoot>
		<tr>
		<td colspan="6" class="rightTd"><a id="beginOrder" href="#" title="#" class="list_op">Start sorting</a>
				&nbsp;<a id="saveOrder" href="#" title="#" class="list_op">Save sorting</a>&nbsp;</td>
		</tr>
		</tfoot>
	</table>
</div>
</body>
</html>