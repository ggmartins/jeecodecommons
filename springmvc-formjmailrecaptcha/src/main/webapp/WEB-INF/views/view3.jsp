<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Form</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/view3.css" />
	<script src='https://www.google.com/recaptcha/api.js'></script>
	<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
	<script src="${pageContext.request.contextPath}/res/js/view3.js"></script>
</head>
<body>
    <p>Form : ${message}</p><br>    
    <img src="${pageContext.request.contextPath}/res/images/image2.png" /><br>
    <a  href="${pageContext.request.contextPath}/">Main</a><br>
    <a  href="${pageContext.request.contextPath}/webapp/">WebApp</a><br>
    
    <input type="button"  id="contactbutton" value="Contact Form" />
    
	<div id="contactdiv" style="display: none;">            
	    <form class="request_form" action="${pageContext.request.contextPath}/form/request_form" method="POST" id="contact" enctype="application/x-www-form-urlencoded">
	        <h3>Contact Form</h3>
	        <hr><br>
	        <label>Name: <span>*</span></label>
	        <br>
	        <input name="name" type="text" id="name" placeholder="Name"><br>
	        <br>
	        <label>Email: <span>*</span></label>
	        <br>
	        <input name="email" type="text" id="email" placeholder="Email"><br>
	        <br>
	        <input type="checkbox" name="notabot" value="NotABot" />I'm not a BOT.<br>
	        <br>
	        <label>Reason: <span>*</span></label>
	        <br>
	        <div class="g-recaptcha" data-sitekey="skdjfkgjsdlkgjsdl"></div>
	        <br>
	        <textarea name="message" style="width: 300px; height: 120px" id="message" placeholder=""></textarea><br>
	        <br>                
	        <p>* Required fields.</p>
	        <input type="button" id="send" value="Send">
	        <input type="button" id="cancel" value="Cancel">
	        <br>
	    </form>
	</div>
    
</body>
</html>