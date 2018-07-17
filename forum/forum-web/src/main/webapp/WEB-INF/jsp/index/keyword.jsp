<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>welcome visit ${baseInfo.name }</title>
<meta http-equiv="keywords" content="Darwin">   
<meta http-equiv="description" content="cdu website">   
<!-- Date: 2013-09-04 -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/index/web.css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.cycle2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/index/main.js"></script>
<script type="text/javascript">
$(function(){
	$("#keyword_btn").click(function() {
		var k = $("#keyword").val();
		if(k=="") {
			alert("Please enter key words to retrieve");
		} else {
			window.location.href=$("#ctx").val()+"/keyword/"+k;
		}
	})
})
</script>
</head>
<body>
<jsp:include page="/jsp/template/qtop.jsp"/>	
<div id="content">
	<div id="content_con">
		<div id="breadcrumb">
			<span>
			your position&nbsp; <a href="<%=request.getContextPath()%>/index">home page</a>|Tag to retrieve:${con }
			</span>
		</div>
		<div id="channel_content">
			<div id="channel_left">
				<dl>
					<dt><span>tags</span></dt>
					<c:forEach var="k" items="${kws}">
						<dd><a href="<%=request.getContextPath() %>/keyword/${k.name}" class="channel_left_href">${k.name}</a></dd>
					</c:forEach>
				</dl>
			</div>
			<div id="channel_right">
				<div id="channel_title">
					<span>retrieval content:[${con }]——retrieval tag:<input type="text" id="keyword" value="${con }"/><input type="button" id="keyword_btn" value="To retrieve"/></span>
				</div>
				<table>
					<c:if test="${datas.total le 0 }">
						<tr><td>No relevant questions and articles were retrieved</td></tr>
					</c:if>
					<c:if test="${datas.total gt 0 }">
					<c:forEach items="${datas.qdatas}" var="question">
					<tr>
						<td>
							<a href="<%=request.getContextPath() %>/question/${question.id}" class="channel_right_href">
							${question.title }</a>
						</td>
						<td>[<fmt:formatDate value="${question.publishDate }" pattern="yyyy-MM-dd"/>]</td>
					</tr>
					</c:forEach>
					<c:forEach items="${datas.tdatas}" var="topic">
					<tr>
						<td>
							<a href="<%=request.getContextPath() %>/topic/${topic.id}" class="channel_right_href">
							${topic.title }</a>
						</td>
						<td>[<fmt:formatDate value="${topic.publishDate }" pattern="yyyy-MM-dd"/>]</td>
					</tr>
					</c:forEach>
					<tfoot>
					<tr>
					<td colspan="2">
						<jsp:include page="/jsp/index_pager.jsp">
							<jsp:param value="${datas.total }" name="totalRecord"/>
							<jsp:param value="search/${con }" name="url"/>
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