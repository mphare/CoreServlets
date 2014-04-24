<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/Parts/part1.jsp" />
<jsp:useBean id="sampleBean" class="com.whitehare.jsppd.SampleBean"></jsp:useBean>
<jsp:setProperty property="name" name="sampleBean" value='<%= request.getParameter("name") %>'/>
<jsp:setProperty property="id" name="sampleBean" value="5"/>
<p>From the bean:</p>
<p><jsp:getProperty property="id" name="sampleBean"/></p>
<p><jsp:getProperty property="name" name="sampleBean"/>
</body>
</html>