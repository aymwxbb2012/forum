<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/main.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/validate/main.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.validate.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/core/jquery.forum.validate.js"></script>
<script type="text/javascript">
$(function(){
	$("#beginBackup").click(function(){
		var v = $("#backupFilename").val();
		if(v=="") {
			var c = confirm("The backup file name has no input, and the default is not named as the filename. is it ok?");
			if(!c) return; 
			else {
				$("#backupFilename").val("Unnamed");	
			}
		}
		$("#backupCon").html("In the backup, please wait a moment...");
		$("#addForm").submit();
	});
});
</script>
</head>
<body>
<div id="content">
	<h3 class="admin_link_bar">
		<jsp:include page="inc.jsp"></jsp:include>
	</h3>
	<sf:form method="post" modelAttribute="userDto" id="addForm">
	<table width="800" cellspacing="0" cellPadding="0">
		<thead><tr><td colspan="2">backup data function</td></tr></thead>
		<tr>
			<td class="rightTd" width="200px">Type the backup file name:</td>
			<td class="leftTd"><input type="text" name="backupFilename" id="backupFilename"/></td>
		</tr>
		<tr>
			<td colspan="2" class="centerTd"><span id="backupCon"><input type="button" value="make a backup" id="beginBackup"/><input type="reset"/></span></td>
		</tr>
	</table>
	</sf:form>
</div>
</body>
</html>