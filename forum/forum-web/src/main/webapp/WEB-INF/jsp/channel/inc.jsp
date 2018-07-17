<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<span>
Corrent column:${pc.name }[${pc.id }]&nbsp;
<a href="<%=request.getContextPath() %>/admin/channel/add/${pid}" class="admin_link">Add sub channel</a>
<a href="<%=request.getContextPath() %>/admin/channel/channels/${pid}/-1" class="admin_link">Sub column list</a>
</span>