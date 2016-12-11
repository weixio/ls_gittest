<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<%=request.getContextPath()%>/js/jquery-1.12.1.js"></script>
<title>test</title>
</head>
<body>
	<%=request.getAttribute("ss")%>
	do testjsp
	<br />
	<form name="form" action="<%=request.getContextPath()%>/mark/init">
		<input id="btnj" type="button" value="ajax调用json" /> <input id="t1"
			type="text" /> <br /> <input name="po_id" type="checkbox" value="1"
			checked="checked" /> <input name="po_id" type="checkbox" value="2"
			checked="checked" /> <input type="button" value="提交po_id"
			onclick="doArray()">
	</form>
	<form name="form1"
		action="<%=request.getContextPath()%>/mark/dovalidate" method="post">
		<input name="id" type="text"> 
		<input name="username" type="text"> 
		<input name="password" type="text"> 
		<input type="submit">
	</form><br/>
	<c:if test="${allErrors!=null}">
		<c:forEach items="${allErrors}" var="error">
			${ error.defaultMessage} 
		</c:forEach>
	</c:if>
	<br/>
	<form name="form2" action="" enctype="mulipart/form-data">
	
	</form>
	<script type="text/javascript">
	$("#btnj").click(function(){
		$.ajax(
			{
				type:'post',
				contentType:"application/json",
				url:'<%=request.getContextPath()%>/mark/dojson',
				data : '{"id":"sdf"}',

				success : function(data) {
					alert(data.id);
				},
				error : function() {
					alert('调用失败');
				}
			});
		});
	function doArray(){
		document.form.action="<%=request.getContextPath()%>/mark/doArray";
			document.form.submit();
		}
	</script>
</body>
</html>