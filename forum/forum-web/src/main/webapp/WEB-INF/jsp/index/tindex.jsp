<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>welcome${baseInfo.name }</title>
<meta http-equiv="keywords" content="cdu,Darwin,NT">   
<meta http-equiv="description" content="Darwin forum,cdu forum">   
<!-- Date: 2017-09-24 -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/index/web.css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.cycle2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/index/main.js"></script>
<style type="text/css">
</style>
</head>
<body>
<jsp:include page="/jsp/template/ttop.jsp"/>	
<jsp:include page="/jsp/template/tbody.jsp"/>
<jsp:include page="/jsp/template/bottom.jsp"/>
</body>
</html>