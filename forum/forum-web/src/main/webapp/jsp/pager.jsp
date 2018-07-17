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
	<span style="float:right;padding:6px;">
	total
	<pg:last>
		${pageNumber } page[${param.totalRecord }records],every page show<%=SystemContext.getPageSize() %>items,
	</pg:last>
	<c:forEach items="${param.params }" var="p">
		<pg:param name="${p }"/>
	</c:forEach>
	<pg:first>
		<a href="${pageUrl }" class="pager_link">first page</a>
	</pg:first>
	<pg:prev>
		<a href="${pageUrl }" class="pager_link">previous page</a>
	</pg:prev>
	<pg:pages>
		<c:if test="${curPage eq pageNumber }">
			[${pageNumber }]
		</c:if>
		<c:if test="${curPage != pageNumber }">
			<a href="${pageUrl }" class="pager_link">${pageNumber }</a>
		</c:if>
	</pg:pages>
	<pg:next>
		<a href="${pageUrl }" class="pager_link">next page</a>
	</pg:next>
	<pg:last>
		<a href="${pageUrl }" class="pager_link">last page</a>
	</pg:last>
	</pg:pager>
	</span>