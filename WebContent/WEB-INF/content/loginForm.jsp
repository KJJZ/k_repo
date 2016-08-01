<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<ul>
			<li>${fieldErrors['user.name']}</li>
			<li>${fieldErrors['user.pass']}</li>
		</ul>
	<s:fielderror />
	<form action="login" method="post">
		<p>username:<input type="text" name="user.name"/></p>
		<p>password:<input type="password" name="user.pass"/></p>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>