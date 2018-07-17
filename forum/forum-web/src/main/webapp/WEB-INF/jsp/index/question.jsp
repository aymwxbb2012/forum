<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>welcome ${baseInfo.name }</title>
<meta http-equiv="keywords" content="Darwin,cdu">   
<meta http-equiv="description" content="cdu website,Darwin">   
<!-- Date: 2013-09-04 -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/index/web.css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.cycle2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/index/main.js"></script>
<style type="text/css">
</style>
</head>
<body>
<jsp:include page="/jsp/template/qtop.jsp"/>	
<div id="content">
	<div id="content_con">
		<div id="article_title"><span>${question.title}</span><span><a href="<%=request.getContextPath() %>/answer/add/${question.id}" class="question_keyword_href">Answer this question</a></span></div>
		<div id="article_info">
		<fmt:formatDate value="${question.publishDate }" pattern="yyyy-MM-dd HH:mm:ss"/>
		&nbsp;${question.author }
		</div>
		<div id="article_keyword">
			<a href="<%=request.getContextPath() %>/channel/${question.channel.id}" class="question_keyword_href">${question.channel.name}</a>
			<c:if test="${hasKey }">
				<c:forEach items="${kws }" var="k">
					<a href="<%=request.getContextPath() %>/keyword/${k}" class="question_keyword_href">${k }</a>
				</c:forEach>
			</c:if>
		</div>
		<div id="article_content">
		${question.content }
		</div>
		<div class="article_atts">
		Related answers:
		<c:if test="${!hasAsws}">The question has no answers</c:if>
		<c:if test="${hasAsws }">
			<c:forEach items="${Asws }" var="asw">
				<tr>
				<td>${asw.auther }</td>
				<td>${asw.createDate }</td>
				<c:if test="${asw.chosen}">
				<td>best answer</td>
				</c:if>
				</tr>
				<tr>
				<td>${asw.content }</td>
				</tr>
			</c:forEach>
		</c:if>
		</div>
	</div>
</div>
<jsp:include page="/jsp/template/bottom.jsp"/>
</body>
</html>