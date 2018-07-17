<%@page import="cdu.xeon.basic.model.SystemContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<pg:pager export="curPage=pageNumber" 
	items="${param.totalRecord }" 
	maxPageItems="<%=SystemContext.getPageSize() %>"
	url="${param.url }">
	<c:forEach items="${param.params }" var="p">
		<pg:param name="${p }"/>
	</c:forEach>
	<pg:last>
	<span class="weith">total pages：${pageNumber}page,${param.totalRecord }records</span>
	</pg:last> 
	<pg:first>
		<span><a href="${pageUrl }"class="bottom_page_span">first page</a></span> 
	</pg:first>
	<pg:prev>
		<span><a href="${pageUrl }" class="bottom_page_span">previous page</a></span>
	</pg:prev>
	<pg:pages>
		<c:if test="${curPage eq pageNumber }">
			<span class="curPage_span">[${pageNumber }]</span>
		</c:if>
		<c:if test="${curPage != pageNumber }">
			<span><a href="${pageUrl }" class="bottom_page_span">${pageNumber }</a></span>
		</c:if>
	</pg:pages>
	<pg:next>
		<span><a href="${pageUrl }" class="bottom_page_span">next page</a></span>
	</pg:next>
	<pg:last>
		<span><a href="${pageUrl }" class="bottom_page_span">last page</a></span>
		<span class="weith">page：${curPage }/${pageNumber}</span>
	</pg:last>
</pg:pager>
