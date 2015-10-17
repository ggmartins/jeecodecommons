<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View1</title>
</head>
<body>
    <p>View1 : ${message}</p><br>    
    <img src="${pageContext.request.contextPath}/res/images/image1.png" /><br>
    <a  href="${pageContext.request.contextPath}/">Main</a><br>
    <a  href="${pageContext.request.contextPath}/webapp/">WebApp</a><br><br>
    
    <c:url var="addAction" value="/todo/add" ></c:url>
    <form:form action="${addAction}" commandName="todo">
	    <form:input path="taskname" name="edit_task" type="text" size="15" value="Task Name" />
	    <form:input path="description" name="edit_desc" type="text" size="40" value="Description" />
	    <input name="button_add" type="submit" value="Add" />
    </form:form><br>
    
	<c:if test="${!empty listTodos}">
		<table>
		<tr>
			<th>Todo Number</th>
			<th>Task Name</th>
			<th>Description</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach items="${listTodos}" var="todo">
			<tr>
				<td>${todo.id}</td>
				<td>${todo.taskname}</td>
				<td>${todo.description}</td>
				<td><a href="" >Update</a></td>
				<td><a href="<c:url value='/todo/del/${todo.id}' />" >Delete</a></td>
			</tr>
		</c:forEach>
		</table>
	</c:if>
</body>
</html>