<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Restore record success</title>
<script type="text/javascript">
function closewindow(){
	if(window.opener){
		window.opener.location.reload(true);
		window.close();
	}
}
function clock(){
	i = i -1;
	if(document.getElementById("info")){
		document.getElementById("info").innerHTML = "this window will close after"+i+"seconds";
	}
	if(i > 0)
		setTimeout("clock();",1000);
	else
		window.close();
}

var i = 4;
clock();

</script>
</head>
<body>
<center>
	Restore data success!<p>
	<div id="info">This window will be automatically closed after 3 seconds</div>
	<input type="hidden" id="contextPath" value="<%=request.getContextPath() %>"/>
	<input type="button" value="close window" onclick="closewindow();">
</center>
</body>
</html>