<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View1</title>
</head>
<body>
    <p>View1 : ${message}</p><br>    
    <img src="${pageContext.request.contextPath}/res/images/image1.png" /><br>
    <a  href="${pageContext.request.contextPath}/webapp/">WebApp</a><br>
    <a  href="${pageContext.request.contextPath}/todo/">Hibernate</a><br>
</body>
</html>