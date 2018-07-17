<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/main.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/js/base/jquery.ui.all.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/article.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/validate/main.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/js/core/jquery.more.keywordinput.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/main.js"></script>
</head>
<body>
<div id="menuContent" class="menuContent" style="display:none; position: absolute;background:#eee;z-index: 999;border:1px solid #999">
	<ul id="mytree" class="ztree" style="margin-top:0;"></ul>
</div>
<div id="container">
<jsp:include page="/jsp/admin/top_inc.jsp"></jsp:include>
<div id="contents">
<input type="hidden" id="ctx" value="<%=request.getContextPath() %>"/>
	<h3 class="admin_link_bar" style="text-align:center">
	<span>${answer.author }</span>
	</h3>
	<table width="980" cellspacing="0" cellPadding="0" id="addTable">
		
		<tr>
			<td class="rightTd">question:</td>
			<td class="leftTd">
			${answer.question.name }
			</td>
		</tr>
			<tr>
				<td class="rightTd">文章状态:</td>
				<td class="leftTd">
					<c:if test="${answer.status eq 0 }">未发布</c:if>
					<c:if test="${answer.status eq 1 }">已发布</c:if>
				</td>
			</tr>
		<tr>
			<td class="rightTd">是否推荐该文章:</td>
			<td class="leftTd">
				<c:if test="${answer.recommend eq 0 }">不推荐</c:if>
				<c:if test="${answer.recommend eq 1 }">推荐</c:if>
			</td>
		</tr>
		<tr>
			<td class="rightTd">create time:</td>
			<td class="leftTd">
				<fmt:formatDate value="${answer.createDate}" pattern="dd-MM-yyyy HH:mm"/>(<fmt:formatDate value="${answer.createDate}" pattern="dd-MM-yyyy HH:mm"/>)
			</td>
		</tr>
		
		
		<tr>
			<td colspan="2"> content</td>
		</tr>
		<tr>
			<td colspan="2">
			${answer.content }
			</td>
		</tr>
		
		<tr>
			<td colspan="2" class="centerTd"><input type="button" onclick="window.close()" value="close"/></td>
		</tr>
	</table>
</div>
</div>
</body>
</html>