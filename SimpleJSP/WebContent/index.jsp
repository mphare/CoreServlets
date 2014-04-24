<!--
=============================================================================
Index.jsp
- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

Simple index page 
=============================================================================
=============================================================================
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
  String title = "Simple JSPs";
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="keywords" content="JSP, expressions, JavaServer Pages" />
<meta name="description" content="A quick example of JSP expressions." />
<link rel=stylesheet href="/FirstDWP/Style/Master.css" type="text/css" />
<title><%=title%></title>
</head>
<%!private int accessCount = 0;%>
<%
  String textColor = "0x05a";
%>
<body text="<%=textColor%>">
	<%@ include file="parts/Header.jsp"%>
	<h1><%=title%></h1>
	<h2>JSP Expressions</h2>
	<ul>
		<li>Current Time: <%=new java.util.Date()%></li>
		<li>Server: <%=application.getServerInfo()%></li>
		<li>Session ID: <%=session.getId()%></li>
		<li>The <CODE>testParam</CODE> form parameter: <%=request.getParameter("testParam")%></li>
	</ul>
	<h2>Scriptlet</h2>
	<%
	for (int i = 0; i < 5; i++ ) {
	  %><p><%= "Number = "+ i %></p><%
	}
	%>
	<p>
		Page accessed
		<%=++accessCount%>
		since server reboot
	</p>
	<%@ include file="parts/Footer.jsp"%>
</body>
</html>