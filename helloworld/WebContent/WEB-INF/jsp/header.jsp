<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav>
	<c:choose>
	  <c:when test="${core != 'home' }">
	    <a href="/helloworld/index.jsp?page=home">Home</a>
	  </c:when>
	  <c:otherwise>
	    Home
	  </c:otherwise>
    </c:choose>
	<c:choose>
	  <c:when test="${core != 'news' }">
	    <a href="/helloworld/index.jsp?page=news">News</a>
	  </c:when>
	  <c:otherwise>
	    News
	  </c:otherwise>
    </c:choose>
	<c:choose>
	  <c:when test="${core != 'contact' }">
	    <a href="/helloworld/index.jsp?page=contact">Contact</a>
	  </c:when>
	  <c:otherwise>
	    Contact
	  </c:otherwise>
    </c:choose>
	<c:choose>
	  <c:when test="${core != 'About' }">
	    <a href="/helloworld/index.jsp?page=About">About</a>
	  </c:when>
	  <c:otherwise>
	    Contact
	  </c:otherwise>
    </c:choose>
</nav>
<%-- ${pageContext.request.servletPath} --%>