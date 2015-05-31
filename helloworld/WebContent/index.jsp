<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Hello World</title>
</head>
<body>
<c:set var="core" value="${param.page}" scope="session" />
<c:if test="${empty param.page}">
  <c:set var="core" value="home" scope="session"/>
</c:if>

<jsp:include page="WEB-INF/jsp/header.jsp" />

<c:choose>
  <c:when test="${core == 'home' }">
    <jsp:include page="WEB-INF/jsp/home.jsp" />
  </c:when>
</c:choose>
<c:choose>
  <c:when test="${core == 'news' }">
    <jsp:include page="WEB-INF/jsp/news.jsp" />
  </c:when>
</c:choose>
<c:choose>
  <c:when test="${core == 'contact' }">
    <jsp:include page="WEB-INF/jsp/contact.jsp" />
  </c:when>
</c:choose>
<c:choose>
  <c:when test="${core == 'contact' }">
    <jsp:include page="WEB-INF/jsp/about.jsp" />
  </c:when>
</c:choose>

<jsp:include page="WEB-INF/jsp/footer.jsp" />
</body>
</html>