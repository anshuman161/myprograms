<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import ="com.bridgelabz.model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ProfileJsp</title>
</head>
<body>
	<%
	User user = null;
	if (session.getAttribute("uname") == null) {
		response.sendRedirect("LoginPage.html");
	} else
	{
			user =(User)(session.getAttribute("uname"));
	}
		String sessionID = null;
		String userName = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("uname"))
					userName = cookie.getValue();
				if (cookie.getName().equals("JSESSIONID"))
					sessionID = cookie.getValue();
			}
		}
		if (userName == null)
			response.sendRedirect("LoginPage.html");
	%>
	<h3>
		Hi
		<%=userName%>, Login successful.<br>Your Session ID=<%=sessionID%></h3>
	<br>
	
	<a href ="PersonProfile.jsp">Proceed to profile--></a>
	
</body>
</html>