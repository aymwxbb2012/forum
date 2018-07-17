<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<span>
<a href="javascript:openWin('<%=request.getContextPath() %>/admin/question/add','addQuestion')" class="admin_link">add question</a>
<a href="<%=request.getContextPath() %>/admin/question/audits" class="admin_link">list of published questions</a>
<a href="<%=request.getContextPath() %>/admin/question/unaudits" class="admin_link">list of unpublished questions</a>
</span>