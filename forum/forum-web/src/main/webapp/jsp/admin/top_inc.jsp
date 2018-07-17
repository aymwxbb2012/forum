<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<input type="hidden" id="contextPath" value="<%=request.getContextPath()%>"/>
<div id="top">
	<div id="topIntro">
		<span id="logo"></span>
		<span id="user_operator">
			<a href="<%=request.getContextPath()%>/index"  target="_blank">home page</a>
			|<a href="<%=request.getContextPath()%>/admin/user/showSelf"  target="content">search user information</a>
			| <a href="<%=request.getContextPath()%>/admin/user/updateSelf"  target="content">update user information</a>
			| <a href="<%=request.getContextPath()%>/admin/user/updatePwd"  target="content">change password </a>
			| <a href="javascript:exitSystem()">exit system</a>
		</span>
	</div>
	<div id="remind">
		<span id="showDate">welcome[${loginUser.nickname }]to${baseInfo.name }background management system。
		</span>
	</div>
</div>
