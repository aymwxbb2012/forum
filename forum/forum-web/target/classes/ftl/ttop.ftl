<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <input type="hidden" id="ctx" value="<%=request.getContextPath()%>"/>
<div id="header">
	<div id="header_con">
		<div id="logo"></div>
		<div id="main_nav">
			<ul>
				<li><a class="main_nav_link" href=""<%=request.getContextPath()%>/tindex">home page</a></li>
				<li><a class="main_nav_link" href="<%=request.getContextPath()%>/index">DF Questions</a></li>
				<li><a class="main_nav_link" href="<%=request.getContextPath()%>/login">login</a></li>
				<li><a class="main_nav_link" href="<%=request.getContextPath()%>/register">register</a></li>
				<li><a class="main_nav_link" href="<%=request.getContextPath()%>/admin/question/add">ask question</a></li>
				<li><a class="main_nav_link" href="mailto:${baseInfo.email}">contact us</a></li>
			</ul>
		</div>
		<div id="search">
			<input type="text" id="search_con" value="Search.." />
			<div id="search_btn"></div>
		</div>
	</div>
</div>
<div id="nav">
	<div id="nav_con">
		<ul>
			<li><span href="<%=request.getContextPath()%>/tindex">home page</span></li>
			<#list navs as nav>
				<li>
				<#if nav.customLink==0>
					<span href="<%=request.getContextPath()%>/tchannel/${nav.id}">${nav.name}</span>
				<#else>
					<span href="${nav.customLinkUrl}">${nav.name}</span>
				</#if>
				</li>
			</#list>
		</ul>
	</div>
</div>