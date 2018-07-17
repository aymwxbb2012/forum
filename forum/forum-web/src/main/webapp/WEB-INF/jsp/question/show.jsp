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
	<span>${question.title }</span>
	</h3>
	<table width="980" cellspacing="0" cellPadding="0" id="addTable">
		<tr>
			<td class="rightTd" width="120px">question title:</td>
			<td class="leftTd">${question.title}[${question.user.nickname }&nbsp;coins:${question.coins}]</td>
			
		</tr>
		<tr>
			<td class="rightTd">question channel:</td>
			<td class="leftTd">
			${question.channel.name }
			</td>
		</tr>
			<tr>
				<td class="rightTd">status:</td>
				<td class="leftTd">
					<c:if test="${question.status eq 0 }">unpublished</c:if>
					<c:if test="${question.status eq 1 }">published</c:if>
				</td>
			</tr>
		<tr>
			<td class="rightTd">Whether to recommend this article:</td>
			<td class="leftTd">
				<c:if test="${question.recommend eq 0 }">not recommended</c:if>
				<c:if test="${question.recommend eq 1 }">recommended</c:if>
			</td>
		</tr>
		<tr>
			<td class="rightTd">publish date:</td>
			<td class="leftTd">
				<fmt:formatDate value="${question.publishDate}" pattern="yyyy-MM-dd HH:mm"/>(<fmt:formatDate value="${question.createDate}" pattern="yyyy-MM-dd HH:mm"/>)
			</td>
		</tr>
		<tr>
			<td class="rightTd">question keywords:</td>
			<td class="leftTd">
				${question.keyword }
			</td>
		</tr>
		
		<tr>
			<td colspan="2">question content</td>
		</tr>
		<tr>
			<td colspan="2">
			${question.content }
			</td>
		</tr>
		
		<c:forEach items="${adatas }" var="a">
			<tr>
				<td>${a.author}</td>
				
				
<c:if test="${question.coins gt 0}&&${loginuser.id eq question.author}">	


					<td>
					<a href="<%=request.getContextPath() %>/WEB-INF/jsp/answer/chosen/${a.id }" class="list_op delete">chosen</a>
					
				</td>
					


</c:if>

				
				
				<c:if test="${a.chosen eq 1 }"> <td> Best Answer</td></c:if>
				
			</tr>
			
			<tr>
			
			<td colspan="2">
			${a.content }
			
			</td>
			
			</tr>
		</c:forEach>
		
		
		<tr>
			<td colspan="2" class="centerTd"><input type="button" onclick="window.close()" value="close"/></td>
		</tr>
		
		
		
		
		
		
	</table>
	
</div>
</div>
</body>
</html>