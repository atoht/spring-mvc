<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="F" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title }</title>
<style>
	h1 {
		font-size: 16pt; background-color: #CCCCFF; padding: 3px;
    }
    p {
		color: #000066;
}
</style>
</head>
<body>
	<h1>${title }</h1>
	<p>${message }</p>
	<table>
	<form action="/SpringMyApp/find" method="post">
		<tr><td>FIND:</td>
		<td><input type="text" name="fstr" size="20" /></td>
		</tr>
		<tr><td></td><td><input type="submit"/></td></tr>
	</form>
<!-- 	<f:form modelAttribute="formModel"></f:form> -->
	</table>
	<hr>
	<c:if test="${datalist != null }">
		<table border="1">
			<tr><th>ID</th><th>名前</th></tr>
			<c:forEach var="obj" items="${datalist }" varStatus="status">
				<tr>
					<td><c:out value="${obj.id }"></c:out></td>
					<td><c:out value="${obj.name }"></c:out></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>