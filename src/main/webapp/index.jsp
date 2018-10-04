<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head> 
	<body>
		<c:url value="/hello" var="messageUrl" />
		<a href="${messageUrl}">Click to enter</a>
		<c:url value="/showItems" var="messageUrl" />
		<a href="${messageUrl}">Show the items</a><br>
		<c:url value="/helo" var="messageUrl" />
		<a href="${messageUrl}">Show the MyData</a>
	</body>
</html>
