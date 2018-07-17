<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>welcome${baseInfo.name }</title>
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
		<div id="breadcrumb">
			<span>your position&nbsp; <a href="<%=request.getContextPath()%>/index">home page</a>|
				<a href="<%=request.getContextPath()%>/channel/${pc.id}">${pc.name }</a>|${channel.name }</span>
		</div>
		<div id="channel_content">
			<div id="channel_left">
				<dl>
					<dt><span>${pc.name}</span></dt>
					<c:forEach var="c" items="${cs}">
						<dd><a href="${c.id }" class="channel_left_href">${c.name }</a></dd>
					</c:forEach>
				</dl>
			</div>
			<div id="channel_right">
				<div id="channel_title">
					<span>${channel.name}</span>
				</div>
				<table>
					<c:if test="${datas.total le 0 }">
						<tr><td>There are no questions  in this column...</td></tr>
					</c:if>
					<c:if test="${datas.total gt 0 }">
					<c:forEach items="${datas.datas}" var="question">
					<tr>
						<td>
							<a href="<%=request.getContextPath() %>/question/${question.id}" class="channel_right_href">
							${question.title }</a>
						</td>
						<td>[<fmt:formatDate value="${question.publishDate }" pattern="yyyy-MM-dd"/>]</td>
					</tr>
					</c:forEach>
					<tfoot>
					<tr>
					<td colspan="2">
						<jsp:include page="/jsp/index_pager.jsp">
							<jsp:param value="${datas.total }" name="totalRecord"/>
							<jsp:param value="channel/${channel.id}" name="url"/>
						</jsp:include>
					</td>
					</tr>
					</tfoot>
					</c:if>
				</table>
				
			</div>
		</div>
	</div>
</div>
<jsp:include page="/jsp/template/bottom.jsp"/>
</body>
</html>