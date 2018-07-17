<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/main.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/js/base/jquery-ui.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/core/jquery.forum.core.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/main.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/inc.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/ui/jquery.ui.core.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/ui/jquery.ui.widget.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/ui/jquery.ui.button.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/ui/jquery.ui.spinner.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/dwr/engine.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/dwr/interface/dwrService.js"></script>
<script type="text/javascript">
$(function(){
	$(".setPos").click(setPos);
	function setPos(event) {
		event.preventDefault();
		var pos = $(this).attr("pos");
		var id = $(this).attr("objid");
		$(this).after("<span>&nbsp;<input type='text' value='"+pos+"' size='3'/>&nbsp;<input id='pos"+id+"' type='hidden' value='"+pos+"'/><a href='#' class='list_opg confirmPos'>确定</a>&nbsp;<a href='' class='list_opg cancelPos'>取消</a></span>");
		$(this).next("span").children("input:text").spinner({
			min:$("#minPos").val(),
			max:$("#maxPos").val(),
			spin:function(event,ui){
				$("#pos"+id).val(ui.value);
			}
		});
		$(this).off("click");
	}
	$(".posCon").on("click",".cancelPos",function(e){
		e.preventDefault();
		$(this).parent("span").prev("a.setPos").on("click",setPos);
		$(this).parent("span").remove();
	});
	$(".posCon").on("click",".confirmPos",function(e){
		e.preventDefault();
		var id = $(this).parent("span").prev("a").attr("objid");
		var op = $(this).parent("span").prev("a").attr("pos");
		var np = $(this).prev("input").val();
		if(op!=np) {
			dwrService.updateLinkPos(id,op,np,function(){
				window.location.reload();
			});
		}
		$(this).parent("span").prev("a.setPos").on("click",setPos);
		$(this).parent("span").remove();
	});
	$("#selectType").change(function(){
		var v = $(this).val();
		if(v=="-1")
			window.location.href="links";
		else
			window.location.href="links?type="+v
	})
}) 
</script>
</head>
<body>
<div id="content">
<input type="hidden" id="maxPos" value="${max }"/>
<input type="hidden" id="minPos" value="${min }"/>
	<h3 class="admin_link_bar">
		<jsp:include page="inc.jsp"></jsp:include>
	</h3>
	<table width="800" cellspacing="0" cellPadding="0" id="listTable">
		<thead>
		<tr><td colspan="6">choose Class:
			<select id="selectType">
			<option value="-1">Select category</option>
			<c:forEach items="${ types}" var="t">
				<option> value="${t }" <c:if test="${param.type eq t}">selected</c:if>>${t }</option>
			</c:forEach>
			</select></td></tr>
		<tr>
			<td>title</td>
			<td width="240">hyperlink</td>
			<td>type</td>
			<td>way of open</td>
			<td>position</td>
			<td>actions</td>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${datas.datas }" var="fl">
			<tr>
				<td><a href="${fl.id }" class="list_link">${fl.title }</a></td>
				<td><a href="${fl.url }" class="list_link">${fl.url }</a></td>
				<td>${fl.type }</td>
				<td>
				<c:if test="${fl.newWin eq 0}">this window</c:if>
				<c:if test="${fl.newWin eq 1}">new window</c:if>
				</td>
				<td class="posCon">
				${pic.pos }&nbsp;<a href="#" class="list_opg setPos" pos="${fl.pos }" objid="${fl.id }">order</a>
				</td>
				<td>
					<a href="delete/${fl.id }" class="list_op delete">delete</a>
					<a href="<%=request.getContextPath() %>/admin/forumLink/update/${fl.id }" class="list_op">update</a>
				&nbsp;
				</td>
			</tr>
		</c:forEach>
		</tbody>
		<tfoot>
		<tr>
			<td colspan="6" style="text-align:right;margin-right:10px;">
			<jsp:include page="/jsp/pager.jsp">
				<jsp:param value="${datas.total }" name="totalRecord"/>
				<jsp:param value="links" name="url"/>
			</jsp:include>
			</td>
		</tr>
		</tfoot>
	</table>
</div>
</body>
</html>