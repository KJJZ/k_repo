<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://code.jquery.com/jquery-3.1.0.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(e){		
		$.get("usersinfojson",null,function(data, statusText){
			$("#show").empty();
			$("#show").append("<table>");
			$("#show").append("<tr><th>ID</th><th>UserName</th><th>Age</th></tr>");
			for(var propid in data['users']){
				$("#show").append("<tr><td>"+propid+"</td><td>"+data['users'][propid][0]+"</td><td>"+data['users'][propid][1]+"</td></tr>");
			}
			$("#show").append("</table>");
		},"json");
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<h2>Users Info</h2>
	<div id="show">Results will display here</div>
</body>
</html>