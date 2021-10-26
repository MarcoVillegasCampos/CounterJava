<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Count</title>
</head>
<body>
	<h1>You have visited <c:out value="${ count }"/> Times</h1>
	<a href="/">Test another visit?</a>
	<a href="/add2">Test two visits?</a>
	<a href="/reset"><button>Reset Session</button></a>
</body>
</html>