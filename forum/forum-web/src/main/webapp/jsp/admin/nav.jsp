<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to Darwin Forum background management program</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/main.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/core/jquery.forum.core.js"></script>
<script type="text/javascript">
$(function(){
	$("#left").myaccordion();
});
</script>
</head>
<body>
<div id="left">
<c:if test="${isAdmin }">
<ul class="navMenu navSelected">
	<h3 class="navTitle">
		<span class="navTilteTxt">user management</span>
	</h3>
	<li class="navChild">
		<a href="<%=request.getContextPath() %>/admin/user/users" target="content">User Information Management</a>
	</li>
	<li class="navChild">
		<a href="<%=request.getContextPath() %>/admin/group/groups" target="content">User group management</a>
	</li>
	<li class="navChild">
		<a href="<%=request.getContextPath() %>/admin/role/roles" target="content">User role management</a>
	</li>
</ul>
</c:if>
<ul class="navMenu navSelected">
	<h3 class="navTitle">
		<span class="navTilteTxt">Article management</span>
	</h3>
	<c:if test="${isAdmin }">
	<li class="navChild">
		<a href="<%=request.getContextPath() %>/admin/channel/channels" target="content">Column information management</a>
	</li>
	</c:if>
	<li class="navChild">
		<a href="<%=request.getContextPath() %>/admin/topic/audits" target="content">Article information management</a>
	</li>
	<li class="navChild">
		<a href="<%=request.getContextPath() %>/admin/question/audits" target="content">Question information management</a>
	</li>
	<li class="navChild">
		<a href="<%=request.getContextPath() %>/admin/answer/chosens" target="content">Answer information management</a>
	</li>
</ul>
<c:if test="${isAdmin }">
	<ul class="navMenu navSelected">
		<h3 class="navTitle">
			<span class="navTilteTxt">system configuration</span>
		</h3>
		<li class="navChild">
			<a href="<%=request.getContextPath() %>/admin/forumLink/links" target="content">Hyperlink management</a>
		</li>
		<li class="navChild">
			<a href="<%=request.getContextPath() %>/admin/system/baseinfo" target="content">website information management</a>
		</li>
		<li class="navChild">
			<a href="<%=request.getContextPath() %>/admin/pic/indexPics" target="content">Homepage image management</a>
		</li>
		<li class="navChild">
			<a href="<%=request.getContextPath() %>/admin/backups" target="content">Site data backup</a>
		</li>
		<li class="navChild">
			<a href="<%=request.getContextPath() %>/admin/system/cleans" target="content">System clean-up management</a>
		</li>
	</ul>
</c:if>
		</div>
</body>
</html>