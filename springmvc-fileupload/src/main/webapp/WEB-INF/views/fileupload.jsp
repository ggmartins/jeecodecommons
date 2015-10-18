<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View File Upload</title>
</head>
<body>
    <p>View File Upload : ${message}</p><br>    
    <img src="${pageContext.request.contextPath}/res/images/image2.png" /><br>
    <a  href="${pageContext.request.contextPath}/">Main</a><br>
    <a  href="${pageContext.request.contextPath}/webapp/">WebApp</a><br>
    
    <form method="POST" enctype="multipart/form-data" action="${pageContext.request.contextPath}/upload_file">
				File to upload: 
				<input type="file" name="file"> 
				<input type="submit" value="Upload">
	</form>
</body>
</html>