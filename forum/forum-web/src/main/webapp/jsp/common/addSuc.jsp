<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Add record success</title>
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
		document.getElementById("info").innerHTML = "This window will be closed in"+i+"seconds";
	}
	if(i > 0)
		setTimeout("clock();",1000);
	else
		closewindow();
}

var i = 4;
clock();

</script>
</head>
<body>
<center>
	Add record success!<p>
	<div id="info">This window will be automatically closed after 3 seconds</div>
	<input type="button" value="close the window" onclick="closewindow();">
</center>
</body>
</html>