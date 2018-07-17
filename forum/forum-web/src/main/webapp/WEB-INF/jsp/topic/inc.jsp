<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<span>
<a href="javascript:openWin('<%=request.getContextPath() %>/admin/topic/add','addTopic')" class="admin_link">add topic</a>
<a href="<%=request.getContextPath() %>/admin/topic/audits" class="admin_link">Published topic list</a>
<a href="<%=request.getContextPath() %>/admin/topic/unaudits" class="admin_link">Unpublished topic list</a>
</span>